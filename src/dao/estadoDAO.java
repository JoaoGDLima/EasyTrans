package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.ConexaoBD;
import model.IDAO_T;
import model.estado;
import model.usuario;

public class estadoDAO implements IDAO_T<estado>{
    ResultSet resultadoQ = null;
    
    @Override
    public String salvar(estado o) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO estado (codigo, nome, uf, inativo) VALUES ("
                    + "default, "
                    + "'" + o.getNome() + "', "
                    + "'" + o.getUF() + "', "
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
    public String atualizar(estado o) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE estado " + 
                         "SET nome = '" + o.getNome() + "', " + 
                         "uf = '" + o.getUF() + "' " +
                         "WHERE codigo = " + o.getCodigo();

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar estado: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE estado " + 
                         "SET inativo = 'V'" +
                         "WHERE codigo = " + id;

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar estado: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<estado> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<estado> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public estado consultarId(int id) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM estado " + 
                         "WHERE codigo =  " + id;

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                estado wEstado = new estado(id, 
                        resultadoQ.getString("nome"), 
                        resultadoQ.getString("uf"),
                        resultadoQ.getString("inativo")
                );
                
                return wEstado;
            }
            
            return null;

        } catch (Exception e) {
            System.out.println("Erro consultar obj estado: " + e);
            return null;
        }
    }

    public void popularTabela(JTable pTable, String pCriterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "UF";
        cabecalho[3] = "Situaçao";
        
        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                       + "SELECT count(*) FROM estado WHERE nome ILIKE '%" + pCriterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][4];

        } catch (Exception e) {
            System.out.println("Erro ao consultar XXX: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM estado WHERE nome ILIKE '%" + pCriterio + "%' "
                            + "ORDER BY nome");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("codigo");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("uf");
                
                String wSituaçao="Ativo";
                if (resultadoQ.getString("inativo").equals("V")) {
                    wSituaçao = "Inativo";
                }
                
                dadosTabela[lin][3] = wSituaçao;
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
