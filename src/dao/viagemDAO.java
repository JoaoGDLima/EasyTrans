package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.ConexaoBD;
import model.Formatacao;
import model.IDAO_T;
import model.cliente;
import model.viagem;

public class viagemDAO implements IDAO_T<viagem> {

    ResultSet resultadoQ = null;

    @Override
    public String salvar(viagem o) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO cronograma (codigo, universidade_codigo, diasemana, horasaida, horavolta, "
                    + "funcionario_codigo, veiculo_codigo, valor, dataini, datafim, contratogerado, inativo) VALUES ("
                    + "default, "
                    + o.getOUniversidade().getCodigo() + ", "
                    + "'" + o.getDiaSemana() + "', "
                    + "'" + o.getHoraSaida() + "', "
                    + "'" + o.getHoraVolta() + "', "
                    + o.getOFuncionario().getCodigo() + ", "
                    + o.getOVeiculo().getCodigo() + ", "
                    + o.getValor() + ", "
                    + "'" + Formatacao.ajustaDataAMD(o.getDataIni()) + "', "
                    + "'" + Formatacao.ajustaDataAMD(o.getDataFim()) + "', "
                    + "'F', " 
                    + "'F') RETURNING codigo";

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                int wCodViagem = resultadoQ.getInt("codigo");

                sql = "INSERT INTO passageiro (viagem_codigo, cliente_codigo) VALUES ";
                String wIns = "";
                for (int i = 0; i < o.getAClientes().size(); i++) {

                    wIns = wIns + "(" + wCodViagem + ", " + o.getAClientes().get(i).getCodigo() + ")";

                    if (i < o.getAClientes().size() - 1) {
                        wIns = wIns + ",";
                    }
                }

                if (!wIns.equals("")) {
                    statement.executeUpdate(sql + wIns);
                }

            }

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(viagem o) {
                try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE cronograma SET " +
                        " universidade_codigo = " + o.getOUniversidade().getCodigo() + ", " +
                        " diasemana = '" + o.getDiaSemana() + "', " + 
                        " horasaida = '" + o.getHoraSaida() + "', " +
                        " horavolta = '" + o.getHoraVolta() + "', " +
                        " funcionario_codigo = " + o.getOFuncionario().getCodigo() + ", " + 
                        " veiculo_codigo = " + o.getOVeiculo().getCodigo() + ", " + 
                        " valor = " + o.getValor() + ", " +
                        " dataini = '" + Formatacao.ajustaDataAMD(o.getDataIni()) + "', " +
                        " datafim = '" + Formatacao.ajustaDataAMD(o.getDataFim()) + "' " +
                        " WHERE codigo = " + o.getCodigo();

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);
            
            statement.execute("delete from passageiro where viagem_codigo = " + o.getCodigo());
            
            sql = "INSERT INTO passageiro (viagem_codigo, cliente_codigo) VALUES ";
            String wIns = "";
            for (int i = 0; i < o.getAClientes().size(); i++) {

                wIns = wIns + "(" + o.getCodigo() + ", " + o.getAClientes().get(i).getCodigo() + ")";

                if (i < o.getAClientes().size() - 1) {
                    wIns = wIns + ",";
                }
            }

            if (!wIns.equals("")) {
                statement.executeUpdate(sql + wIns);
            }

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar viagem: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE cronograma "
                    + "SET inativo = 'V'"
                    + "WHERE codigo = " + id;

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar viagem: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<viagem> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<viagem> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public viagem consultarId(int id) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM cronograma "
                    + "WHERE codigo =  " + id;

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                ArrayList<cliente> GClientes = new ArrayList();

                ResultSet resultadoQ2 = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                        + "SELECT cliente_codigo "
                        + "FROM passageiro "
                        + "WHERE viagem_codigo =  " + id);

                while (resultadoQ2.next()) {
                    GClientes.add(new clienteDAO().consultarId(resultadoQ2.getInt("cliente_codigo")));
                }

                viagem wViagem = new viagem(
                        id,
                        resultadoQ.getInt("universidade_codigo"),
                        resultadoQ.getTime("horasaida"),
                        resultadoQ.getTime("horavolta"),
                        resultadoQ.getInt("funcionario_codigo"),
                        resultadoQ.getInt("veiculo_codigo"),
                        resultadoQ.getFloat("valor"),
                        resultadoQ.getDate("dataini"),
                        resultadoQ.getDate("datafim"),
                        GClientes,
                        resultadoQ.getString("inativo")
                );

                return wViagem;
            }

            return null;

        } catch (Exception e) {
            System.out.println("Erro consultar obj viagem: " + e);
            return null;
        }
    }

    public boolean validarDado(String pWhere, String pDataIni, String pDataFim, String pHoraIda, String pHoraVolta, String pDiaSemana) {
        try {
            boolean wRetorno = true;
            
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * " + 
                         " FROM cronograma " + 
                         " WHERE diasemana  = '" + pDiaSemana + "'" +
                         " AND (horasaida BETWEEN '" + pHoraIda + "' AND '" + pHoraVolta + "'" +
                         " OR horasaida BETWEEN '" + pHoraVolta + "' AND '" + pHoraIda + "'" +
                         " OR horasaida BETWEEN '" + pHoraIda + "' AND '" + pHoraVolta + "'" +
                         " OR horasaida BETWEEN '" + pHoraVolta + "' AND '" + pHoraIda + "')" +
                         " AND (dataini BETWEEN '" + pDataIni + "' AND '" + pDataFim + "'" +
                         " OR datafim BETWEEN '" + pDataIni + "' AND '" + pDataFim + "')" + 
                         " AND inativo <> 'V'" +
                         " AND " + pWhere;

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                wRetorno = false;
            }

            return wRetorno;

        } catch (Exception e) {
            System.out.println("Erro consultar obj viagem: " + e);
            return false;
        }
    }
    
    public boolean validarPassageiro(int pCliente, int pViagem, String pDataIni, String pDataFim, String pHoraIda, String pHoraVolta, String pDiaSemana) {
        try {
            boolean wRetorno = true;
            
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * " + 
                         " FROM cronograma " + 
                         " INNER JOIN passageiro ON passageiro.viagem_codigo = cronograma.codigo" +
                         " WHERE diasemana  = '" + pDiaSemana + "'" +
                         " AND (horasaida BETWEEN '" + pHoraIda + "' AND '" + pHoraVolta + "'" +
                         " OR horasaida BETWEEN '" + pHoraVolta + "' AND '" + pHoraIda + "'" +
                         " OR horasaida BETWEEN '" + pHoraIda + "' AND '" + pHoraVolta + "'" +
                         " OR horasaida BETWEEN '" + pHoraVolta + "' AND '" + pHoraIda + "')" +
                         " AND (dataini BETWEEN '" + pDataIni + "' AND '" + pDataFim + "'" +
                         " OR datafim BETWEEN '" + pDataIni + "' AND '" + pDataFim + "')" + 
                         " AND inativo <> 'V'" +
                         " AND passageiro.cliente_codigo = " + pCliente + 
                         " AND cronograma.codigo <> " + pViagem;

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                wRetorno = false;
            }

            return wRetorno;

        } catch (Exception e) {
            System.out.println("Erro consultar obj viagem: " + e);
            return false;
        }
    }

    public void popularTabela(JTable pTable, String pCriterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "Código";
        cabecalho[1] = "Universidade";
        cabecalho[2] = "Motorista";
        cabecalho[3] = "Veículo";
        cabecalho[4] = "Dia semana";
        cabecalho[5] = "Hora";
        cabecalho[6] = "Situação";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + " FROM cronograma "
                    + " INNER JOIN universidade ON universidade.codigo = cronograma.universidade_codigo "
                    + " INNER JOIN veiculo ON veiculo.codigo = cronograma.veiculo_codigo "
                    + " INNER JOIN funcionario ON funcionario.codigo = cronograma.funcionario_codigo "
                    + " WHERE universidade.nome ILIKE '%" + pCriterio + "%' "
                    + " OR funcionario.nome ILIKE '%" + pCriterio + "%' "
                    + " OR veiculo.placa ILIKE '%" + pCriterio + "%' "
                    + " OR cronograma.diasemana ILIKE '%" + pCriterio + "%' ");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][7];

        } catch (Exception e) {
            System.out.println("Erro ao consultar cronograma: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(
                    "SELECT cronograma.codigo AS CODIGO, universidade.nome AS UNIVERSIDADE, "
                    + " funcionario.nome AS FUNCIONARIO, veiculo.placa AS VEICULO, cronograma.diasemana AS DIA, "
                    + " cronograma.horasaida AS HORA, cronograma.inativo AS INATIVO"
                    + " FROM cronograma "
                    + " INNER JOIN universidade ON universidade.codigo = cronograma.universidade_codigo "
                    + " INNER JOIN veiculo ON veiculo.codigo = cronograma.veiculo_codigo "
                    + " INNER JOIN funcionario ON funcionario.codigo = cronograma.funcionario_codigo "
                    + " WHERE universidade.nome ILIKE '%" + pCriterio + "%' "
                    + " OR funcionario.nome ILIKE '%" + pCriterio + "%' "
                    + " OR veiculo.placa ILIKE '%" + pCriterio + "%' "
                    + " OR cronograma.diasemana ILIKE '%" + pCriterio + "%' "
                    + " ORDER BY cronograma.codigo");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("CODIGO");
                dadosTabela[lin][1] = resultadoQ.getString("UNIVERSIDADE");
                dadosTabela[lin][2] = resultadoQ.getString("FUNCIONARIO");
                dadosTabela[lin][3] = resultadoQ.getString("VEICULO");
                dadosTabela[lin][4] = resultadoQ.getString("DIA");
                dadosTabela[lin][5] = resultadoQ.getString("HORA");

                String wSituaçao = "Ativo";
                if (resultadoQ.getString("INATIVO").equals("V")) {
                    wSituaçao = "Inativo";
                }

                dadosTabela[lin][6] = wSituaçao;
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        pTable.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
                    //return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        pTable.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < pTable.getColumnCount(); i++) {
            column = pTable.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }
    }
}
