package view;

import dao.CombosDAO;
import dao.contratoDAO;
import dao.formaspagamentoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Calendario;
import model.ComboItens;
import model.Contrato;
import model.Formatacao;
import model.Validacao;
import model.cliente;
import model.parcela;

public class CadastroContasRecebF extends javax.swing.JInternalFrame {

    ArrayList<parcela> GParcelas;

    public CadastroContasRecebF() {
        initComponents();
        this.setResizable(false);
        
        GParcelas = new ArrayList();
        popularTabela();
        
        edDataVencimento.setFont(new java.awt.Font("Tahoma", 0, 14));
        edDataPagamento.setFont(new java.awt.Font("Tahoma", 0, 14));

        Formatacao.formatarData(edDataVencimento);
        Formatacao.formatarData(edDataPagamento);
        
        edFormaPagamento.removeAllItems();
        new CombosDAO().popularCombo("formaspagamento","codigo, nome","","nome", edFormaPagamento);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edCodigoCli = new javax.swing.JTextField();
        edNomeCli = new javax.swing.JTextField();
        btSelecionar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        edContrato = new javax.swing.JTextField();
        btSelecionar1 = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbParcelas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btSelecionarParc = new javax.swing.JButton();
        pnParcela = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        edDataPagamento = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btCancelar1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        edParcela = new javax.swing.JFormattedTextField();
        edDataVencimento = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        edFormaPagamento = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        edValor = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setTitle("Contas a receber");
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(33, 33, 33));
        jLabel1.setText("Cliente:");

        edCodigoCli.setEditable(false);
        edCodigoCli.setBackground(new java.awt.Color(255, 255, 204));
        edCodigoCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edCodigoCli.setForeground(new java.awt.Color(33, 33, 33));

        edNomeCli.setEditable(false);
        edNomeCli.setBackground(new java.awt.Color(255, 255, 204));
        edNomeCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edNomeCli.setForeground(new java.awt.Color(33, 33, 33));

        btSelecionar.setBackground(new java.awt.Color(243, 243, 243));
        btSelecionar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btSelecionar.setForeground(new java.awt.Color(33, 33, 33));
        btSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publico/Selecionar_15.png"))); // NOI18N
        btSelecionar.setText("Selecionar");
        btSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(33, 33, 33));
        jLabel2.setText("Contrato:");

        edContrato.setEditable(false);
        edContrato.setBackground(new java.awt.Color(255, 255, 204));
        edContrato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edContrato.setForeground(new java.awt.Color(33, 33, 33));

        btSelecionar1.setBackground(new java.awt.Color(243, 243, 243));
        btSelecionar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btSelecionar1.setForeground(new java.awt.Color(33, 33, 33));
        btSelecionar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publico/Selecionar_15.png"))); // NOI18N
        btSelecionar1.setText("Selecionar");
        btSelecionar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionar1ActionPerformed(evt);
            }
        });

        btCancelar.setBackground(new java.awt.Color(243, 243, 243));
        btCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btCancelar.setForeground(new java.awt.Color(33, 33, 33));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publico/Cancelar_15.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(edCodigoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSelecionar))
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(edContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSelecionar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edCodigoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSelecionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSelecionar1)
                    .addComponent(btCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbParcelas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbParcelas.setForeground(new java.awt.Color(33, 33, 33));
        tbParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbParcelas);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(33, 33, 33));
        jLabel3.setText("Mensalidades:");

        btSelecionarParc.setBackground(new java.awt.Color(243, 243, 243));
        btSelecionarParc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btSelecionarParc.setForeground(new java.awt.Color(33, 33, 33));
        btSelecionarParc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publico/Selecionar_15.png"))); // NOI18N
        btSelecionarParc.setText("Selecionar parcela");
        btSelecionarParc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarParcActionPerformed(evt);
            }
        });

        pnParcela.setBackground(new java.awt.Color(255, 255, 255));
        pnParcela.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parcela", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(33, 33, 33));
        jLabel5.setText("Data de pagamento:");

        edDataPagamento.setBackground(new java.awt.Color(255, 255, 204));
        edDataPagamento.setAlignmentX(0.0F);

        jButton3.setBackground(new java.awt.Color(243, 243, 243));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publico/Selecionar_15.png"))); // NOI18N
        jButton3.setText("Confirmar pagamento");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(33, 33, 33));
        jLabel6.setText("Número:");

        btCancelar1.setBackground(new java.awt.Color(243, 243, 243));
        btCancelar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btCancelar1.setForeground(new java.awt.Color(33, 33, 33));
        btCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publico/Cancelar_15.png"))); // NOI18N
        btCancelar1.setText("Cancelar pagamento");
        btCancelar1.setActionCommand("");
        btCancelar1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(33, 33, 33));
        jLabel8.setText("Valor:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(33, 33, 33));
        jLabel7.setText("Data de vencimento:");

        edParcela.setBackground(new java.awt.Color(255, 255, 204));

        edDataVencimento.setBackground(new java.awt.Color(255, 255, 204));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(33, 33, 33));
        jLabel4.setText("Forma de pagamento:");

        edFormaPagamento.setBackground(new java.awt.Color(255, 255, 204));
        edFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edFormaPagamento.setForeground(new java.awt.Color(33, 33, 33));
        edFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Data atual");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        edValor.setEditable(false);
        edValor.setBackground(new java.awt.Color(255, 255, 204));
        edValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnParcelaLayout = new javax.swing.GroupLayout(pnParcela);
        pnParcela.setLayout(pnParcelaLayout);
        pnParcelaLayout.setHorizontalGroup(
            pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnParcelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnParcelaLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar1))
                    .addGroup(pnParcelaLayout.createSequentialGroup()
                        .addComponent(edFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(edDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(pnParcelaLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addGroup(pnParcelaLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnParcelaLayout.createSequentialGroup()
                        .addComponent(edParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(edDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edValor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        pnParcelaLayout.setVerticalGroup(
            pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnParcelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(edDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(edValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(3, 3, 3)
                .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnParcelaLayout.createSequentialGroup()
                        .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSelecionarParc))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnParcela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSelecionarParc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnParcela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarActionPerformed
        SelecionarCliente wSelecionarCliente = new SelecionarCliente(null, true);

        wSelecionarCliente.setVisible(true);

        if (wSelecionarCliente.getTextSearch() != null) {
            cliente wCli = wSelecionarCliente.getTextSearch();
            edCodigoCli.setText(wCli.getCodigo() + "");
            edNomeCli.setText(wCli.getNome() + "");
            GParcelas = new ArrayList();
            popularTabela();
        }
    }//GEN-LAST:event_btSelecionarActionPerformed

    private void btSelecionar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionar1ActionPerformed
        if (edCodigoCli.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "selecione um cliente!");
        } else {
            int wCodigoCliente = Integer.parseInt(edCodigoCli.getText());

            SelecionarContrato wSelecionarContrato = new SelecionarContrato(null, true, wCodigoCliente);

            wSelecionarContrato.setVisible(true);

            if (wSelecionarContrato.getTextSearch() != null) {
                Contrato wContrato = wSelecionarContrato.getTextSearch();
                edContrato.setText(wContrato.getCodigo() + "");
                GParcelas = wContrato.getAParcelas();
                popularTabela();
            }
        }
    }//GEN-LAST:event_btSelecionar1ActionPerformed

    private void btSelecionarParcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarParcActionPerformed
        String valor = String.valueOf(tbParcelas.getValueAt(tbParcelas.getSelectedRow(), 0));

        parcela wParcela = new contratoDAO().consultarParcelaId(Integer.parseInt(edContrato.getText()), Integer.parseInt(valor));

        edParcela.setText(wParcela.getSeq() + "");
        edDataVencimento.setText(wParcela.getDataVencimento());
        edValor.setText(Float.toString(wParcela.getValor()));
        edDataPagamento.setText(wParcela.getDataPagamento());

        if (wParcela.getOFormaPagamento() != null) {
            ComboItens item = new ComboItens();
            item.setCodigo(wParcela.getOFormaPagamento().getCodigo());
            new CombosDAO().definirItemCombo(edFormaPagamento, item);
        }
    }//GEN-LAST:event_btSelecionarParcActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (validaCampo()) {
            parcela wParcela = new parcela();
            wParcela.setSeq(Integer.parseInt(edParcela.getText()));
            wParcela.setDataVencimento(edDataVencimento.getText());
            wParcela.setValor(Float.valueOf(edValor.getText()));
            wParcela.setDataPagamento(edDataPagamento.getText());
            wParcela.setSituacao("F");
            
            ComboItens ci = (ComboItens) edFormaPagamento.getSelectedItem();
            wParcela.setOFormaPagamento(new formaspagamentoDAO().consultarId(ci.getCodigo()));
            
            new contratoDAO().atualizarParcela(wParcela, Integer.parseInt(edContrato.getText()));
            
            GParcelas = new contratoDAO().consultarId(Integer.parseInt(edContrato.getText())).getAParcelas();
            popularTabela();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
            if (edCodigoCli.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Selecione um cliente!");
                edCodigoCli.requestFocus();
            }
            else if (edContrato.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Selecione um contrato!");
                edContrato.requestFocus();
            }
            else if (edParcela.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione uma parcela!");
            btSelecionarParc.requestFocus();
            }
            else
            {
                parcela wParcela = new parcela();
                wParcela.setSeq(Integer.parseInt(edParcela.getText()));
                wParcela.setDataVencimento(edDataVencimento.getText());
                wParcela.setValor(Float.valueOf(edValor.getText()));
                wParcela.setDataPagamento("");
                wParcela.setSituacao("A");
                wParcela.setOFormaPagamento(null);

                new contratoDAO().atualizarParcela(wParcela, Integer.parseInt(edContrato.getText()));

                GParcelas = new contratoDAO().consultarId(Integer.parseInt(edContrato.getText())).getAParcelas();
                popularTabela();
            }
    }//GEN-LAST:event_btCancelar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Calendario wCal = new Calendario();
        edDataPagamento.setText(wCal.obterDataAtualDMA());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void popularTabela() {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Parcela";
        cabecalho[1] = "Data de vencimento";
        cabecalho[2] = "Data de pagamento";
        cabecalho[3] = "Valor";

        dadosTabela = new Object[GParcelas.size()][4];
        for (int j = 0; j < GParcelas.size(); j++) {
            dadosTabela[j][0] = GParcelas.get(j).getSeq();
            dadosTabela[j][1] = GParcelas.get(j).getDataVencimento();
            dadosTabela[j][2] = GParcelas.get(j).getDataPagamento();
            dadosTabela[j][3] = GParcelas.get(j).getValor();
        }

        // configuracoes adicionais no componente tabela
        tbParcelas.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
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
        tbParcelas.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tbParcelas.getColumnCount(); i++) {
            column = tbParcelas.getColumnModel().getColumn(i);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCancelar1;
    private javax.swing.JButton btSelecionar;
    private javax.swing.JButton btSelecionar1;
    private javax.swing.JButton btSelecionarParc;
    private javax.swing.JTextField edCodigoCli;
    private javax.swing.JTextField edContrato;
    private javax.swing.JFormattedTextField edDataPagamento;
    private javax.swing.JFormattedTextField edDataVencimento;
    private javax.swing.JComboBox edFormaPagamento;
    private javax.swing.JTextField edNomeCli;
    private javax.swing.JFormattedTextField edParcela;
    private javax.swing.JTextField edValor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel pnParcela;
    private javax.swing.JTable tbParcelas;
    // End of variables declaration//GEN-END:variables

    private boolean validaCampo() {
        if (edCodigoCli.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente!");
            edCodigoCli.requestFocus();
            return false;
        }

        if (edContrato.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Selecione um contrato!");
            edContrato.requestFocus();
            return false;
        }
        
        
        ComboItens ciFormaPagamento = (ComboItens) edFormaPagamento.getSelectedItem();

        if (ciFormaPagamento == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma forma de pagamento!");
            edFormaPagamento.requestFocus();
            return false;
        }
        
        if (edParcela.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione uma parcela!");
            btSelecionarParc.requestFocus();
            return false;
        }
        
        if (Formatacao.removerFormatacao(edDataPagamento.getText()).equals("")) {
            JOptionPane.showMessageDialog(null, "Campo data de pagamento inválido!");
            edDataPagamento.requestFocus();
            return false;
        } else if (!Validacao.validarDataFormatada(edDataPagamento.getText()))
        {
            JOptionPane.showMessageDialog(null, "Campo data de pagamento inválido!");
            edDataPagamento.requestFocus();
            return false; 
        }

        return true;
    }
}
