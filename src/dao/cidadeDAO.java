package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.ConexaoBD;
import model.IDAO_T;
import model.cidade;
import model.estado;

public class cidadeDAO implements IDAO_T<cidade> {

    ResultSet resultadoQ = null;

    @Override
    public String salvar(cidade o) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO cidade (codigo, estado_codigo, nome, cep, inativo) VALUES ("
                    + "default, "
                    + "" + o.getEstadoO().getCodigo() + ", "
                    + "'" + o.getNome() + "', "
                    + "'" + o.getCep() + "', "
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
    public String atualizar(cidade o) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE cidade "
                    + "SET estado_codigo = " + o.getEstadoO().getCodigo() + ", " +
                      " nome = '" + o.getNome() + "', " +
                      " cep = '" + o.getCep() + "' " + 
                      " WHERE codigo = " + o.getCodigo();

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar cidade: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
       try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE cidade " + 
                         "SET inativo = 'V'" +
                         "WHERE codigo = " + id;

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar cidade: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<cidade> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<cidade> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public cidade consultarId(int id) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM cidade " + 
                         "WHERE codigo =  " + id;

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                cidade wCidade = new cidade(id, 
                        new estadoDAO().consultarId(resultadoQ.getInt("estado_codigo")), 
                        resultadoQ.getString("nome"),
                        resultadoQ.getString("cep"),
                        resultadoQ.getString("inativo")
                );
                
                return wCidade;
            }
            
            return null;

        } catch (Exception e) {
            System.out.println("Erro consultar obj cidade: " + e);
            return null;
        }
    }

    public void popularTabela(JTable pTable, String pCriterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Cep";
        cabecalho[3] = "Estado";
        cabecalho[4] = "Situaçao";
        
        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                       + "SELECT count(*) FROM cidade WHERE nome ILIKE '%" + pCriterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][5];

        } catch (Exception e) {
            System.out.println("Erro ao consultar XXX: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(
                         "SELECT cidade.codigo AS codcid, cidade.nome AS nomecid, cidade.cep AS cepcid, " +
                         " cidade.inativo AS inativocid, estado.nome nomeest" +
                         " FROM cidade " +
                         " INNER JOIN estado ON estado.codigo = cidade.estado_codigo " +
                         " WHERE cidade.nome ILIKE '%" + pCriterio + "%' " +
                         " ORDER BY cidade.nome");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("codcid");
                dadosTabela[lin][1] = resultadoQ.getString("nomecid");
                dadosTabela[lin][2] = resultadoQ.getString("cepcid");
                
                String wSituaçao="Ativo";
                if (resultadoQ.getString("inativocid").equals("V")) {
                    wSituaçao = "Inativo";
                }
                
                dadosTabela[lin][3] = resultadoQ.getString("nomeest");
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
