package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.ConexaoBD;
import model.IDAO_T;
import model.veiculo;

public class veiculoDAO implements IDAO_T<veiculo>{
    
    ResultSet resultadoQ = null;
    
    @Override
    public String salvar(veiculo o) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO veiculo (codigo, modelo, descricao, marca, placa, " + 
                         "capacidade, cor, ano, inativo) VALUES ("
                    + "default, "
                    + "'" + o.getModelo()+ "', "
                    + "'" + o.getDescricao() + "', "
                    + "'" + o.getMarca() + "', "
                    + "'" + o.getPlaca() + "', "
                    + o.getCapacidade() + ", "
                    + "'" + o.getCor() + "', "
                    +  o.getAno() + ", "
                    + "'F'"
                    + ")";

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(veiculo o) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE veiculo SET " + 
                         "modelo = '" + o.getModelo() + "', " +
                         "descricao = '" + o.getDescricao() + "', " +
                         "marca = '" + o.getMarca() + "', " +
                         "placa = '" + o.getPlaca() + "', " +
                         "capacidade = " + o.getCapacidade() + ", " +
                         "cor = '" + o.getCor() + "', " +
                         "ano = " + o.getAno() + " " +
                         "WHERE codigo = " + o.getCodigo();

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar veiculo: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE veiculo "
                    + "SET inativo = 'V' "
                    + "WHERE codigo = " + id;

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar veiculo: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<veiculo> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<veiculo> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public veiculo consultarId(int id) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM veiculo "
                    + "WHERE codigo =  " + id;

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                veiculo wVeiculo = new veiculo(
                        id,
                        resultadoQ.getString("modelo"),
                        resultadoQ.getString("descricao"),
                        resultadoQ.getString("marca"),
                        resultadoQ.getString("placa"),
                        resultadoQ.getInt("capacidade"),
                        resultadoQ.getInt("ano"),
                        resultadoQ.getString("cor"),
                        resultadoQ.getString("inativo")
                );

                return wVeiculo;
            }

            return null;

        } catch (Exception e) {
            System.out.println("Erro consultar obj veiculo: " + e);
            return null;
        }
    }
    
    public void popularTabela(JTable pTable, String pCriterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Código";
        cabecalho[1] = "Marca";
        cabecalho[2] = "Modelo";
        cabecalho[3] = "Placa";
        cabecalho[4] = "Situação";
        
        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("" +
                         "SELECT count(*) " + 
                         "FROM veiculo " +
                         "WHERE marca ILIKE '%" + pCriterio + "%'" +
                         " OR modelo ILIKE '%" + pCriterio + "%'" +
                         " OR placa ILIKE '%" + pCriterio + "%'" );

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][5];

        } catch (Exception e) {
            System.out.println("Erro ao consultar veiculo: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("" +
                    "SELECT * " +
                    "FROM veiculo "+
                    "WHERE marca ILIKE '%" + pCriterio + "%' " +
                    " OR modelo ILIKE '%" + pCriterio + "%' " +
                    " OR placa ILIKE '%" + pCriterio + "%' " +
                    "ORDER BY codigo");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("codigo");
                dadosTabela[lin][1] = resultadoQ.getString("marca");
                dadosTabela[lin][2] = resultadoQ.getString("modelo");
                dadosTabela[lin][3] = resultadoQ.getString("placa");
                
                String wSituaçao = "Ativo";
                if (resultadoQ.getString("inativo").equals("V")) {
                    wSituaçao = "Inativo";
                }

                dadosTabela[lin][4] = wSituaçao;
                
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
