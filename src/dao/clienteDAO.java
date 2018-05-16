
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
import model.cidade;
import model.cliente;

public class clienteDAO implements IDAO_T<cliente>{

    ResultSet resultadoQ = null;
    
    @Override
    public String salvar(cliente o) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO cliente (codigo, nome, rg, cpf, data_nasc, " + 
                         "telefone, celular, logradouro, complemento, numero, bairro, cidade_codigo, inativo) " +
                         " VALUES (" + 
                         "default, " + 
                         "'" + o.getNome() + "', " + 
                         "'" + o.getRg() + "', " + 
                         "'" + o.getCpf() + "', " + 
                         "'" + o.getDataNasc() + "', " + 
                         "'" + o.getTelefone() + "', " + 
                         "'" + o.getCelular() + "', " +  
                         "'" + o.getLogradouro() + "', " +  
                         "'" + o.getComplemento() + "', " +  
                         "'" + o.getNumero() + "', " +  
                         "'" + o.getBairro() + "', " +  
                         o.getCidadeO().getCodigo() + ", " +
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
    public String atualizar(cliente o) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE cliente SET " +
                        " nome = '" + o.getNome() + "', " +
                        " rg = '" + o.getRg() + "', " + 
                        " cpf = '" + o.getCpf() + "', " + 
                        " data_nasc = '" + Formatacao.ajustaDataAMD(o.getDataNasc()) + "', " + 
                        " telefone = '" + o.getTelefone() + "', " + 
                        " celular = '" + o.getCelular() + "', " + 
                        " logradouro = '" + o.getLogradouro() + "', " + 
                        " complemento = '" + o.getComplemento() + "', " + 
                        " numero = '" + o.getNumero()  + "', " +
                        " bairro = '" + o.getBairro() + "', " +
                        " cidade_codigo = " + o.getCidadeO().getCodigo() + " " +
                        " WHERE codigo = " + o.getCodigo();

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE cliente " + 
                         "SET inativo = 'V'" +
                         "WHERE codigo = " + id;

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<cliente> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<cliente> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public cliente consultarId(int id) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * " +
                         "FROM cliente " + 
                         "WHERE codigo =  " + id;

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                cliente wCliente = new cliente(
                        id,
                        resultadoQ.getString("nome"),
                        resultadoQ.getString("rg"),
                        resultadoQ.getString("cpf"),
                        resultadoQ.getDate("data_nasc"),
                        resultadoQ.getString("telefone"),
                        resultadoQ.getString("celular"),
                        resultadoQ.getString("logradouro"),
                        resultadoQ.getString("numero"),
                        resultadoQ.getString("complemento"),
                        resultadoQ.getString("bairro"),
                        resultadoQ.getInt("cidade_codigo"),
                        resultadoQ.getString("inativo")
                );
                
                return wCliente;
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
                         "FROM cliente " +
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
                    "FROM cliente "+
                    "WHERE nome ILIKE '%" + pCriterio + "%'");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("codigo");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = Formatacao.formatarCpf(resultadoQ.getString("cpf"));
                dadosTabela[lin][3] = Formatacao.formatarCelular(resultadoQ.getString("celular"));
                
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
    
    public void popularTabelaAdd(JTable pTable, String pCriterio) {
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
                         "FROM cliente " +
                         "WHERE nome ILIKE '%" + pCriterio + "%'" + 
                         " AND inativo <> 'V'");

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
                    "FROM cliente "+
                    "WHERE nome ILIKE '%" + pCriterio + "%'");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("codigo");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = Formatacao.formatarCpf(resultadoQ.getString("cpf"));
                dadosTabela[lin][3] = Formatacao.formatarCelular(resultadoQ.getString("celular"));
                
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
