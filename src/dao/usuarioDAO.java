package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.ConexaoBD;
import model.usuario;
import model.IDAO_T;

public class usuarioDAO implements IDAO_T<usuario> {

    ResultSet resultadoQ = null;

    @Override
    public String salvar(usuario o) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO usuario (codigo, email, senha, tipo, inativo) VALUES ("
                    + "default, "
                    + "'" + o.getEmail() + "', "
                    + "'" + o.getSenha() + "',"
                    + "'" + o.getTipo() + "',"
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
    public String atualizar(usuario o) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE usuario " + 
                         "SET email = '" + o.getEmail() + "', " + 
                         "senha = '" + o.getSenha() + "', " +
                         "tipo = '" + o.getTipo() + "' "+  
                         "WHERE codigo = " + o.getCodigo();

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar usuario: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE usuario " + 
                         "SET inativo = 'V'" +
                         "WHERE codigo = " + id;

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar usuario: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<usuario> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<usuario> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public usuario consultarId(int id) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM usuario "
                    + "WHERE codigo =  " + id;

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                usuario wUsuario = new usuario(id,
                        resultadoQ.getString("email"),
                        resultadoQ.getString("senha"),
                        resultadoQ.getString("tipo"),
                        resultadoQ.getString("inativo")
                );

                return wUsuario;
            }

            return null;

        } catch (Exception e) {
            System.out.println("Erro consultar obj usuario: " + e);
            return null;
        }
    }

    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Código";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Situação";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM usuario WHERE email ILIKE '%" + criterio + "%' AND codigo>1");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][3];

        } catch (Exception e) {
            System.out.println("Erro ao consultar XXX: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM usuario WHERE email ILIKE '%" + criterio + "%' " +
                    " AND codigo>1"
                    + "ORDER BY email");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("codigo");
                dadosTabela[lin][1] = resultadoQ.getString("email");

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
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
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
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
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

    public usuario validarusuario(String pEmail, String pSenha) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM usuario " + 
                         " WHERE email =  '" + pEmail + "'" + 
                         " AND senha = '" + pSenha + "'" +
                         " AND inativo <> 'V'";

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                usuario wUsuario = new usuario(resultadoQ.getInt("codigo"),
                        resultadoQ.getString("email"),
                        resultadoQ.getString("senha"),
                        resultadoQ.getString("tipo"),
                        resultadoQ.getString("inativo")
                );

                return wUsuario;
            }

            return null;

        } catch (Exception e) {
            System.out.println("Erro consultar obj usuario: " + e);
            return null;
        }
    }
}
