
package view;

import dao.CombosDAO;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import model.ComboItens;
import model.ConexaoBD;
import model.Formatacao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioViagemF extends javax.swing.JInternalFrame {


    public RelatorioViagemF() {
        initComponents();
        this.setResizable(false);
        initComponents();
        this.setResizable(false);
        
        edUniversidade.removeAllItems();
        new CombosDAO().popularCombo("universidade","codigo, nome","","nome", edUniversidade);
        
        edMotorisa.removeAllItems();
        new CombosDAO().popularCombo("funcionario","codigo, nome","","nome", edMotorisa);
        
        edVeiculo.removeAllItems();
        new CombosDAO().popularCombo("veiculo","codigo, (marca || ' ' || modelo || ' ' || placa) AS descricao","","descricao", edVeiculo);

        edCliente.removeAllItems();
        new CombosDAO().popularCombo("cliente","codigo, nome","","nome", edCliente);

        edSituacao.removeAllItems();
        new CombosDAO().popularComboSituacao(edSituacao);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        edUniversidade = new javax.swing.JComboBox<>();
        Motorista = new javax.swing.JLabel();
        edMotorisa = new javax.swing.JComboBox<>();
        Veiculo = new javax.swing.JLabel();
        edVeiculo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        edSituacao = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        edCliente = new javax.swing.JComboBox<>();

        setTitle("Listar cidades cadastradas:");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(243, 243, 243));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publico/Selecionar_15.png"))); // NOI18N
        jButton1.setText("Listar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Universidade:");

        edUniversidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edUniversidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Motorista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Motorista.setText("Motorista:");

        edMotorisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edMotorisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Veiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Veiculo.setText("Veiculo:");

        edVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Situação:");

        edSituacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cliente:");

        edCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edUniversidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edMotorisa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(Motorista)
                            .addComponent(Veiculo)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCancelar)))
                        .addGap(0, 162, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancelar, jButton1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edUniversidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Motorista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edMotorisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Veiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btCancelar, jButton1});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String situacao = null;
        int universidade = 0;
        int motorista = 0;
        int veiculo = 0;
        String HoraIda = null;
        String HoraVolta = null;
        String DataIni = null;
        String DataFim = null;
        int cliente = 0;
        
        String DescCliente = "Todos";
        String DescUniversidade = "Todos";
        String DescMotorista = "Todos";
        String DescVeiculo = "Todos";
        String DescSituacao = "Todos";
        
        
        ComboItens ci = (ComboItens) edSituacao.getSelectedItem();
        if (ci.getCodigo()==1) {
            situacao = "F";
            DescSituacao = ci.getDescricao();
        } else if (ci.getCodigo()==2) {
            situacao = "V";
            DescSituacao = ci.getDescricao();
        }
        
        ci = (ComboItens) edCliente.getSelectedItem();
        if (ci.getCodigo()>0) {
          cliente = ci.getCodigo(); 
          DescCliente = ci.getDescricao();
        }
        
        ci = (ComboItens) edUniversidade.getSelectedItem();
        if (ci.getCodigo()>0) {
          universidade = ci.getCodigo(); 
          DescUniversidade = ci.getDescricao();
        }
        
        ci = (ComboItens) edMotorisa.getSelectedItem();
        if (ci.getCodigo()>0) {
          motorista = ci.getCodigo(); 
          DescMotorista = ci.getDescricao();
        }
        
        ci = (ComboItens) edVeiculo.getSelectedItem();
        if (ci.getCodigo()>0) {
          veiculo = ci.getCodigo();
          DescVeiculo = ci.getDescricao();
        }

        try {
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/rel_viagens.jrxml"));
            Map<String, Object> mapa = new HashMap<String, Object>();
            mapa.put("status", situacao);
            mapa.put("funcionario", motorista);
            mapa.put("universidade", universidade);
            mapa.put("veiculo", veiculo);
            mapa.put("horavolta", HoraVolta);
            mapa.put("horasaida", HoraIda);
            mapa.put("dataini", DataIni);
            mapa.put("datafim", DataFim);
            mapa.put("cliente", cliente);
            
            mapa.put("DescCliente", DescCliente);
            mapa.put("DescSituacao", DescSituacao);
            mapa.put("DescVeiculo", DescVeiculo);
            mapa.put("DescMotorista", DescMotorista);
            mapa.put("DescUniversidade", DescUniversidade);
            
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, mapa, ConexaoBD.getInstance().getConnection());

            JasperViewer.viewReport(impressao, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Motorista;
    private javax.swing.JLabel Veiculo;
    private javax.swing.JButton btCancelar;
    private javax.swing.JComboBox<String> edCliente;
    private javax.swing.JComboBox<String> edMotorisa;
    private javax.swing.JComboBox<String> edSituacao;
    private javax.swing.JComboBox<String> edUniversidade;
    private javax.swing.JComboBox<String> edVeiculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
