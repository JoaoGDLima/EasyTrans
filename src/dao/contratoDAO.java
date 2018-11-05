package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.ConexaoBD;
import model.Contrato;
import model.Formatacao;
import model.IDAO_T;
import model.parcela;

public class contratoDAO implements IDAO_T<Contrato> {

    ResultSet resultadoQ = null;

    @Override
    public String salvar(Contrato o) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO contrato (codigo, cliente_codigo, dataini, datafim) VALUES ("
                    + "default, "
                    + o.getOCliente().getCodigo() + ", "
                    + "'" + Formatacao.ajustaDataAMD(o.getDataIni()) + "', "
                    + "'" + Formatacao.ajustaDataAMD(o.getDataFim()) + "'"
                    + ") RETURNING codigo";

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                int wCodContrato = resultadoQ.getInt("codigo");
                
                String[] wViagens = o.getViagens().split(",");
                
                for (int i = 0; i < wViagens.length; i++) {
                  sql = "UPDATE cronograma SET contratogerado = 'T' WHERE codigo = " + wViagens[i];
                  statement.executeUpdate(sql);
                }
                
                sql = "INSERT INTO contasreceb (contrato_codigo, seq, datavenc, datapag, valor, situacao) VALUES ";
                String wIns = "";
                for (int i = 0; i < o.getAParcelas().size(); i++) {

                    wIns = wIns + "(" + wCodContrato + ", "
                            + (i + 1) + ", "
                            + "'" + Formatacao.ajustaDataAMD(o.getAParcelas().get(i).getDataVencimento()) + "', "
                            + " null, "
                            + o.getAParcelas().get(i).getValor() + ", "
                            + "'" + o.getAParcelas().get(i).getSituacao() + "')";

                    if (i < o.getAParcelas().size() - 1) {
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
    public String atualizar(Contrato o) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE contrato SET "
                    + " codigo = " + o.getCodigo() + ", "
                    + " cliente_codigo = '" + o.getOCliente().getCodigo() + "', "
                    + " dataini = '" + Formatacao.ajustaDataAMD(o.getDataIni()) + "', "
                    + " datafim = '" + Formatacao.ajustaDataAMD(o.getDataFim()) + "' "
                    + " WHERE codigo = " + o.getCodigo();

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            statement.execute("delete from contasreceb where contrato_codigo = " + o.getCodigo());

            sql = "INSERT INTO contasreceb (contrato_codigo, seq, datavenc, datapag, valor, situacao, formaspagamento_codigo) VALUES ";
            String wIns = "";
            for (int i = 0; i < o.getAParcelas().size(); i++) {

                String wFormaPag = "null";

                if (o.getAParcelas().get(i).getOFormaPagamento() != null) {
                    wFormaPag = "" + o.getAParcelas().get(i).getOFormaPagamento().getCodigo();
                }

                String wDataPagamento = "null";
                if (o.getAParcelas().get(i).getDataPagamento() != null) {
                    wDataPagamento = "'" + Formatacao.ajustaDataAMD(o.getAParcelas().get(i).getDataPagamento()) + "'";
                }

                wIns = wIns + "(" + o.getCodigo() + ", "
                        + o.getAParcelas().get(i).getSeq() + ", "
                        + "'" + Formatacao.ajustaDataAMD(o.getAParcelas().get(i).getDataVencimento()) + "', "
                        + "" + wDataPagamento + ", "
                        + o.getAParcelas().get(i).getValor() + ", "
                        + "'" + o.getAParcelas().get(i).getSituacao() + "', "
                        + wFormaPag + ")";

                if (i < o.getAParcelas().size() - 1) {
                    wIns = wIns + ",";
                }
            }

            if (!wIns.equals("")) {
                System.out.println("SQL: " + sql + wIns);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Contrato> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Contrato> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contrato consultarId(int id) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT cliente_codigo, dataini, datafim "
                    + "FROM contrato "
                    + "WHERE codigo =  " + id;

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);
            ArrayList<parcela> GParcelas = new ArrayList();
            if (resultadoQ.next()) {
                ResultSet resultadoQ2 = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                        + "SELECT * "
                        + "FROM contasreceb "
                        + "WHERE contrato_codigo =  " + id);

                while (resultadoQ2.next()) {
                    String wDataPag = "";

                    if (resultadoQ2.getDate("datapag") != null) {
                        wDataPag = Formatacao.ajustaDataDMA(resultadoQ2.getDate("datapag").toString());
                    }

                    parcela wParc = new parcela();
                    wParc.setSeq(resultadoQ2.getInt("seq"));
                    wParc.setDataVencimento(Formatacao.ajustaDataDMA(resultadoQ2.getDate("datavenc").toString()));
                    wParc.setDataPagamento(wDataPag);
                    wParc.setValor(resultadoQ2.getFloat("valor"));
                    wParc.setSituacao(resultadoQ2.getString("situacao"));
                    wParc.setOFormaPagamento(new formaspagamentoDAO().consultarId(resultadoQ2.getInt("formaspagamento_codigo")));

                    GParcelas.add(wParc);
                }

                Contrato wContrato = new Contrato(
                        id,
                        resultadoQ.getInt("cliente_codigo"),
                        resultadoQ.getDate("dataini").toString(),
                        resultadoQ.getDate("datafim").toString(),
                        GParcelas);

                return wContrato;
            }

            return null;

        } catch (Exception e) {
            System.out.println("Erro consultar obj contrato: " + e);
            return null;
        }
    }

    public parcela consultarParcelaId(int pContrato, int pParcela) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + " FROM contasreceb "
                    + " WHERE contrato_codigo =  " + pContrato
                    + " AND seq = " + pParcela;

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                String wDataPag = "";
                if (resultadoQ.getDate("datapag") != null) {
                    wDataPag = Formatacao.ajustaDataDMA(resultadoQ.getDate("datapag").toString());
                }
                parcela wParc = new parcela();
                wParc.setSeq(resultadoQ.getInt("seq"));
                wParc.setDataVencimento(Formatacao.ajustaDataDMA(resultadoQ.getDate("datavenc").toString()));
                wParc.setDataPagamento(wDataPag);
                wParc.setValor(resultadoQ.getFloat("valor"));
                wParc.setSituacao(resultadoQ.getString("situacao"));
                wParc.setOFormaPagamento(new formaspagamentoDAO().consultarId(resultadoQ.getInt("formaspagamento_codigo")));

                return wParc;
            }

            return null;
        } catch (Exception e) {
            System.out.println("Erro consultar obj parcela: " + e);
            return null;
        }
    }

    public String atualizarParcela(parcela o, int pContrato) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();
            
            String wDataPag = "null"; 
            if (!o.getDataPagamento().equals("")) {
               wDataPag = "'" + o.getDataPagamento() + "'";
            }
            
            String wFormaPag = "null";
            if (o.getOFormaPagamento() != null) {
               wFormaPag =  o.getOFormaPagamento().getCodigo() + "";
            }       
            
            String sql = "UPDATE contasreceb "
                    + "SET datapag = " + wDataPag + ", "
                    + " situacao = '" + o.getSituacao() + "', "
                    + " formaspagamento_codigo = " + wFormaPag + " "
                    + " WHERE contrato_codigo = " + pContrato
                    + " AND seq = " + o.getSeq();

            System.out.println("SQL: " + sql);

            int retorno = statement.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar cidade: " + e);
            return e.toString();
        }
    }

    public void popularTabela(JTable pTable, String pCriterio, int pCliente) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Código";
        cabecalho[1] = "Data inicial";
        cabecalho[2] = "Data final";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + " FROM contrato "
                    + " WHERE cliente_codigo = " + pCliente);

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][3];

        } catch (Exception e) {
            System.out.println("Erro ao consultar contrato: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(
                    "SELECT codigo, dataini, datafim "
                    + " FROM contrato "
                    + " WHERE cliente_codigo = " + pCliente);

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("CODIGO");
                dadosTabela[lin][1] = Formatacao.ajustaDataDMA(resultadoQ.getString("DATAINI"));
                dadosTabela[lin][2] = Formatacao.ajustaDataDMA(resultadoQ.getString("DATAFIM"));
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

    public String BuscarViagens(int pCliente, String pDataIni, String pDataFim){
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT ARRAY_AGG(codigo) AS viagens"
                    + " FROM cronograma "
                    + " INNER JOIN passageiro ON passageiro.viagem_codigo = cronograma.codigo "
                    + " WHERE passageiro.cliente_codigo = " + pCliente
                    + " AND dataini >= '" + Formatacao.ajustaDataAMD(pDataIni) + "'"
                    + " AND datafim <= '" + Formatacao.ajustaDataAMD(pDataFim) + "'" 
                    + " AND contratogerado <> 'T'";

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                String wViagens = resultadoQ.getString("viagens").replace("{", "");
                wViagens = wViagens.replace("}", "");
                return wViagens;
            }

            return null;
        } catch (Exception e) {
            System.out.println("Erro consultar obj viagem: " + e);
            return null;
        }
    }
    
    public ArrayList<parcela> GerarParcelas(String pViagens, String pDataIni) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT SUM(valor) AS valor"
                    + " FROM cronograma "
                    + " WHERE cronograma.codigo IN (" + pViagens +  ")";

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                ArrayList<parcela> wParcelas = new ArrayList();
                String wAno = pDataIni.split("/")[2];
                int wMes = Integer.parseInt(pDataIni.split("/")[1]);

                for (int i = 0; i < 6; i++) {
                    parcela wParc = new parcela();
                    wParc.setSeq(i + 1);
                    wParc.setValor(resultadoQ.getFloat("valor"));
                    String wMesStr = "" + wMes;
                    if (wMes < 10) {
                        wMesStr = "0" + wMes;
                    }

                    wParc.setDataVencimento("10/" + wMesStr + "/" + wAno);
                    wParc.setSituacao("A");
                    wParcelas.add(wParc);
                    wMes++;
                }
                return wParcelas;
            }

            return null;
        } catch (Exception e) {
            System.out.println("Erro consultar obj viagem: " + e);
            return null;
        }
    }
    
    /*public ArrayList<parcela> GerarParcelas(int pCliente, String pDataIni, String pDataFim) {
        try {
            Statement statement = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT SUM(valor) AS valor"
                    + " FROM cronograma "
                    + " INNER JOIN passageiro ON passageiro.viagem_codigo = cronograma.codigo "
                    + " WHERE passageiro.cliente_codigo = " + pCliente
                    + " AND dataini >= '" + Formatacao.ajustaDataAMD(pDataIni) + "'"
                    + " AND datafim <= '" + Formatacao.ajustaDataAMD(pDataFim) + "'";

            System.out.println("SQL: " + sql);

            resultadoQ = statement.executeQuery(sql);

            if (resultadoQ.next()) {
                ArrayList<parcela> wParcelas = new ArrayList();
                String wAno = pDataIni.split("/")[2];
                int wMes = Integer.parseInt(pDataIni.split("/")[1]);

                for (int i = 0; i < 6; i++) {
                    parcela wParc = new parcela();
                    wParc.setSeq(i + 1);
                    wParc.setValor(resultadoQ.getFloat("valor"));
                    String wMesStr = "" + wMes;
                    if (wMes < 10) {
                        wMesStr = "0" + wMes;
                    }

                    wParc.setDataVencimento("10/" + wMesStr + "/" + wAno);
                    wParc.setSituacao("A");
                    wParcelas.add(wParc);
                    wMes++;
                }
                return wParcelas;
            }

            return null;
        } catch (Exception e) {
            System.out.println("Erro consultar obj viagem: " + e);
            return null;
        }
    }*/
}
