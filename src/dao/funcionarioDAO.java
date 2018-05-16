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
import model.funcionario;

public class funcionarioDAO implements IDAO_T<funcionario>{

    ResultSet resultadoQ = null;
    
    @Override
    public String salvar(funcionario o) {
       try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();
            
            int wCodUsu = 0;
            if(o.getUsuarioO()!=null)
            {
                wCodUsu = o.getUsuarioO().getCodigo(); 
            }
            
            String sql = "INSERT INTO funcionario (codigo, nome, cpf, cnh, rg, telefone, celular, usuario_codigo, observacao, inativo) " +
                         " VALUES (" + 
                         "default, " + 
                         "'" + o.getNome() + "', " + 
                         "'" + o.getCpf() + "', " + 
                         "'" + o.getCnh() + "', " + 
                         "'" + o.getRg() + "', " + 
                         "'" + o.getTelefone() + "', " + 
                         "'" + o.getCelular() + "', " +  
                         wCodUsu + ", " +  
                         "'" + o.getObservacao() + "', " +  
                         "'F')";

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(funcionario o) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE funcionario SET " +
                        " nome = '" + o.getNome() + "', " +
                        " rg = '" + o.getRg() + "', " + 
                        " cpf = '" + o.getCpf() + "', " +
                        " telefone = '" + o.getTelefone() + "', " + 
                        " celular = '" + o.getCelular() + "', " + 
                        " cnh = '" + o.getCnh() + "', " +
                        " observacao = '" + o.getObservacao() + "', " +
                        " usuario_codigo = " + o.getUsuarioO().getCodigo() + " " +
                        " WHERE codigo = " + o.getCodigo();

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar funcionario: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE funcionario " + 
                         "SET inativo = 'V'" +
                         "WHERE codigo = " + id;

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar funcionario: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<funcionario> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<funcionario> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public funcionario consultarId(int id) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * " +
                         "FROM funcionario " + 
                         "WHERE codigo =  " + id;

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                funcionario wFuncionario = new funcionario(
                        id,
                        resultadoQ.getString("nome"),
                        resultadoQ.getString("cpf"),
                        resultadoQ.getString("cnh"),
                        resultadoQ.getString("rg"),
                        resultadoQ.getString("telefone"),
                        resultadoQ.getString("celular"),
                        resultadoQ.getInt("usuario_codigo"),
                        resultadoQ.getString("observacao"),
                        resultadoQ.getString("inativo")
                );
                
                return wFuncionario;
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
        cabecalho[2] = "CPF";
        cabecalho[3] = "Celular";
        cabecalho[4] = "Situação";
        
        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("" +
                         "SELECT count(*) " + 
                         "FROM funcionario " +
                         "WHERE nome ILIKE '%" + pCriterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][5];

        } catch (Exception e) {
            System.out.println("Erro ao consultar cliente: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("" +
                    "SELECT * " +
                    "FROM funcionario "+
                    "WHERE nome ILIKE '%" + pCriterio + "%'");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("codigo");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = Formatacao.formatarCpf(resultadoQ.getString("cpf"));
                dadosTabela[lin][3] = resultadoQ.getString("celular");
                
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
