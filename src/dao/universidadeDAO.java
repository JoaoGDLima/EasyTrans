package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.ConexaoBD;
import model.IDAO_T;
import model.universidade;

public class universidadeDAO implements IDAO_T<universidade> {

    ResultSet resultadoQ = null;

    @Override
    public String salvar(universidade o) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO universidade (codigo, nome, inativo) VALUES ("
                    + "default, "
                    + "'" + o.getNome() + "', "
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
    public String atualizar(universidade o) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE universidade "
                    + "SET nome = '" + o.getNome() + "' "
                    + "WHERE codigo = " + o.getCodigo();

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar universidade: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE universidade "
                    + "SET inativo = 'V'"
                    + "WHERE codigo = " + id;

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar universidade: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<universidade> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<universidade> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public universidade consultarId(int id) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM universidade "
                    + "WHERE codigo =  " + id;

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                universidade wUniversidade = new universidade(id,
                        resultadoQ.getString("nome"),
                        resultadoQ.getString("inativo")
                );

                return wUniversidade;
            }

            return null;

        } catch (Exception e) {
            System.out.println("Erro consultar obj universidade: " + e);
            return null;
        }
    }

    public void popularTabela(JTable pTable, String pCriterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Situação";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM universidade WHERE nome ILIKE '%" + pCriterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][3];

        } catch (Exception e) {
            System.out.println("Erro ao consultar universidade: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM universidade WHERE nome ILIKE '%" + pCriterio + "%' "
                    + "ORDER BY nome");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("codigo");
                dadosTabela[lin][1] = resultadoQ.getString("nome");

                String wSituaçao = "Ativo";
                if (resultadoQ.getString("inativo").equals("V")) {
                    wSituaçao = "Inativo";
                }

                dadosTabela[lin][2] = wSituaçao;
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
