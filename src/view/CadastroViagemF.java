package view;

import dao.CombosDAO;
import dao.clienteDAO;
import dao.funcionarioDAO;
import dao.universidadeDAO;
import dao.veiculoDAO;
import dao.viagemDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Calendario;
import model.ComboItens;
import model.Formatacao;
import model.Validacao;
import model.cliente;
import model.limpaCampos;
import model.viagem;


public class CadastroViagemF extends javax.swing.JInternalFrame {
    int codigo = 0;
    private ArrayList<cliente> GClientes;
    
    public CadastroViagemF() {
        initComponents();
        this.setResizable(false);
        edHoraIda.setFont(new java.awt.Font("Tahoma", 0, 14));
        edHoraVolta.setFont(new java.awt.Font("Tahoma", 0, 14));
        edValor.setFont(new java.awt.Font("Tahoma", 0, 14));
        edDataFim.setFont(new java.awt.Font("Tahoma", 0, 14));
        edDataIni.setFont(new java.awt.Font("Tahoma", 0, 14));
        
        Formatacao.formatarHora(edHoraIda);
        Formatacao.formatarHora(edHoraVolta);
        Formatacao.formatarValor(edValor);
        Formatacao.formatarData(edDataFim);
        Formatacao.formatarData(edDataIni);
        
        edUniversidade.removeAllItems();
        new CombosDAO().popularCombo("universidade","codigo, nome","","nome", edUniversidade);
        
        edMotorisa.removeAllItems();
        new CombosDAO().popularCombo("funcionario","codigo, nome","","nome", edMotorisa);
        
        edVeiculo.removeAllItems();
        new CombosDAO().popularCombo("veiculo","codigo, (marca || ' ' || modelo || ' ' || placa) AS descricao","","descricao", edVeiculo);
            
        edDiaSemana.removeAllItems();
        new CombosDAO().popularComboSemanas(edDiaSemana);
        
        GClientes = new ArrayList();
        
        new viagemDAO().popularTabela(tbViagens, "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnCampos = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        edUniversidade = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        edDiaSemana = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        edMotorisa = new javax.swing.JComboBox<String>();
        jLabel7 = new javax.swing.JLabel();
        edVeiculo = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        edCapacidade = new javax.swing.JTextField();
        lbPassageiros = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPassageiros = new javax.swing.JTable();
        btAddCliente = new javax.swing.JButton();
        btAddCliente1 = new javax.swing.JButton();
        edHoraIda = new javax.swing.JFormattedTextField();
        edHoraVolta = new javax.swing.JFormattedTextField();
        edValor = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        edDataIni = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        edDataFim = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnLista = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        edBusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbViagens = new javax.swing.JTable();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();

        setTitle("Cadastro de viagem");

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(501, 362));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(501, 362));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(501, 362));

        pnCampos.setBackground(new java.awt.Color(255, 255, 255));

        btSalvar.setBackground(new java.awt.Color(76, 175, 80));
        btSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publico/Salvar_15.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(33, 33, 33));
        jLabel1.setText("Universidade:");

        edUniversidade.setBackground(new java.awt.Color(255, 255, 204));
        edUniversidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edUniversidade.setForeground(new java.awt.Color(33, 33, 33));
        edUniversidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(33, 33, 33));
        jLabel2.setText("Dia da semana:");

        edDiaSemana.setBackground(new java.awt.Color(255, 255, 204));
        edDiaSemana.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edDiaSemana.setForeground(new java.awt.Color(33, 33, 33));
        edDiaSemana.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(33, 33, 33));
        jLabel3.setText("Hora ida:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(33, 33, 33));
        jLabel4.setText("Hora volta:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(33, 33, 33));
        jLabel6.setText("Motorista:");

        edMotorisa.setBackground(new java.awt.Color(255, 255, 204));
        edMotorisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edMotorisa.setForeground(new java.awt.Color(33, 33, 33));
        edMotorisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(33, 33, 33));
        jLabel7.setText("Veiculo:");

        edVeiculo.setBackground(new java.awt.Color(255, 255, 204));
        edVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edVeiculo.setForeground(new java.awt.Color(33, 33, 33));
        edVeiculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        edVeiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                edVeiculoItemStateChanged(evt);
            }
        });
        edVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edVeiculoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(33, 33, 33));
        jLabel8.setText("Valor mensal:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(33, 33, 33));
        jLabel9.setText("Capacidade do veiculo:");

        edCapacidade.setEditable(false);
        edCapacidade.setBackground(new java.awt.Color(255, 255, 204));
        edCapacidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edCapacidade.setForeground(new java.awt.Color(33, 33, 33));

        lbPassageiros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbPassageiros.setForeground(new java.awt.Color(33, 33, 33));
        lbPassageiros.setText("Passageiros:");

        tbPassageiros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbPassageiros.setForeground(new java.awt.Color(33, 33, 33));
        tbPassageiros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbPassageiros);

        btAddCliente.setBackground(new java.awt.Color(243, 243, 243));
        btAddCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btAddCliente.setForeground(new java.awt.Color(33, 33, 33));
        btAddCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publico/Novo_15.png"))); // NOI18N
        btAddCliente.setText("Adicionar passageiro");
        btAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddClienteActionPerformed(evt);
            }
        });

        btAddCliente1.setBackground(new java.awt.Color(243, 243, 243));
        btAddCliente1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btAddCliente1.setForeground(new java.awt.Color(33, 33, 33));
        btAddCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publico/Excluir_15.png"))); // NOI18N
        btAddCliente1.setText("Remover passageiro");
        btAddCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddCliente1ActionPerformed(evt);
            }
        });

        edHoraIda.setBackground(new java.awt.Color(255, 255, 204));

        edHoraVolta.setBackground(new java.awt.Color(255, 255, 204));

        edValor.setBackground(new java.awt.Color(255, 255, 204));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(33, 33, 33));
        jLabel12.setText("Data inicio:");

        edDataIni.setEditable(false);
        edDataIni.setBackground(new java.awt.Color(255, 255, 204));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(33, 33, 33));
        jLabel13.setText("Data fim:");

        edDataFim.setEditable(false);
        edDataFim.setBackground(new java.awt.Color(255, 255, 204));
        edDataFim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edDataFimActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Primeiro semestre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Segundo semestre");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCamposLayout = new javax.swing.GroupLayout(pnCampos);
        pnCampos.setLayout(pnCamposLayout);
        pnCamposLayout.setHorizontalGroup(
            pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lbPassageiros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAddCliente1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAddCliente))
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCamposLayout.createSequentialGroup()
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnCamposLayout.createSequentialGroup()
                                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btCancelar))
                                    .addComponent(edUniversidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(edDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnCamposLayout.createSequentialGroup()
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edDataIni, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnCamposLayout.createSequentialGroup()
                                        .addComponent(edDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2))))
                            .addGroup(pnCamposLayout.createSequentialGroup()
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnCamposLayout.createSequentialGroup()
                                        .addComponent(edHoraIda, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(edHoraVolta, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnCamposLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(edValor, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnCamposLayout.createSequentialGroup()
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(edVeiculo, 0, 353, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(edMotorisa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnCamposLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancelar, btSalvar});

        pnCamposLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        pnCamposLayout.setVerticalGroup(
            pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edUniversidade, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(edDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(edDataIni, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edValor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edHoraVolta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edHoraIda, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edMotorisa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edCapacidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbPassageiros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btAddCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAddCliente)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCancelar)
                    .addComponent(btSalvar))
                .addContainerGap())
        );

        pnCamposLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAddCliente, btAddCliente1});

        jTabbedPane1.addTab("Cadastro", pnCampos);

        pnLista.setBackground(new java.awt.Color(254, 254, 254));

        jLabel5.setFont(new java.awt.Font("TakaoExGothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(33, 33, 33));
        jLabel5.setText("Busca:");

        edBusca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tbViagens.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbViagens.setForeground(new java.awt.Color(33, 33, 33));
        tbViagens.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbViagens);

        btExcluir.setBackground(new java.awt.Color(243, 243, 243));
        btExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btExcluir.setForeground(new java.awt.Color(33, 33, 33));
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publico/Excluir_15.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btEditar.setBackground(new java.awt.Color(243, 243, 243));
        btEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btEditar.setForeground(new java.awt.Color(33, 33, 33));
        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publico/Editar_15.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btNovo.setBackground(new java.awt.Color(243, 243, 243));
        btNovo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btNovo.setForeground(new java.awt.Color(33, 33, 33));
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publico/Novo_15.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btPesquisar.setBackground(new java.awt.Color(243, 243, 243));
        btPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btPesquisar.setForeground(new java.awt.Color(33, 33, 33));
        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publico/Pesquisar_15.png"))); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnListaLayout = new javax.swing.GroupLayout(pnLista);
        pnLista.setLayout(pnListaLayout);
        pnListaLayout.setHorizontalGroup(
            pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnListaLayout.createSequentialGroup()
                .addGroup(pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnListaLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPesquisar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnListaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnListaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pnListaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btEditar, btExcluir, btNovo, btPesquisar});

        pnListaLayout.setVerticalGroup(
            pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnListaLayout.createSequentialGroup()
                .addGroup(pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnListaLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btPesquisar)))
                    .addGroup(pnListaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btEditar)
                    .addComponent(btNovo))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Listar", pnLista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        try {
            if (validaCampo()) {
                viagem wViagem = new viagem();
                
                wViagem.setCodigo(codigo);
                ComboItens ci = (ComboItens) edUniversidade.getSelectedItem();
                wViagem.setOUniversidade(new universidadeDAO().consultarId(ci.getCodigo()));
                
                ci = (ComboItens) edDiaSemana.getSelectedItem();
                wViagem.setDiaSemana(ci.getDescricao());
                wViagem.setHoraSaida(edHoraIda.getText());
                wViagem.setHoraVolta(edHoraVolta.getText());
                wViagem.setValor(Float.valueOf(edValor.getText()));
                
                ci = (ComboItens) edMotorisa.getSelectedItem();
                wViagem.setOFuncionario(new funcionarioDAO().consultarId(ci.getCodigo()));
                
                ci = (ComboItens) edVeiculo.getSelectedItem();
                wViagem.setOVeiculo(new veiculoDAO().consultarId(ci.getCodigo()));
                
                wViagem.setAClientes(GClientes);
                wViagem.setDataIni(edDataIni.getText());
                wViagem.setDataFim(edDataFim.getText());
                
                viagemDAO wViagemDAO = new viagemDAO();
                
                String retorno = null;
                if (wViagem.getCodigo() == 0) {
                    retorno = wViagemDAO.salvar(wViagem);
                } else {
                    retorno = wViagemDAO.atualizar(wViagem);
                }
                
                if (retorno == null) {
                    JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
                    limpaCampos.limparCampos(pnCampos);
                    codigo = 0;
                    new viagemDAO().popularTabela(tbViagens, "");
                    jTabbedPane1.setSelectedIndex(1);
                    
                    GClientes.clear();
                    AtualizaPassageiros();
                    
                    lbPassageiros.setText("Passageiros:");
                } else {
                    JOptionPane.showMessageDialog(null, "Problemas ao salvar registro!\n\n"
                            + "Mensagem técnica: \n" + retorno);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(CadastroViagemF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        //limpaCampos.limparCampos(pnCampos);
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        String wUsuNome = String.valueOf(tbViagens.getValueAt(tbViagens.getSelectedRow(), 0));

        Object[] options = { "Confirmar", "Cancelar" };
        int wOpc = JOptionPane.showOptionDialog(null, "Deseja excluir a viagem: " + wUsuNome,
            "Informação",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (wOpc==0)
        {
            String valor = String.valueOf(tbViagens.getValueAt(tbViagens.getSelectedRow(), 0));

            viagemDAO wEstadoDAO = new viagemDAO();

            String retorno = wEstadoDAO.excluir(Integer.parseInt(valor));

            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
                wEstadoDAO.popularTabela(tbViagens, edBusca.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Problemas ao excluir registro!\n\n"
                    + "Mensagem técnica: \n" + retorno);
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        String valor = String.valueOf(tbViagens.getValueAt(tbViagens.getSelectedRow(), 0));

        viagem wViagem = new viagemDAO().consultarId(Integer.parseInt(valor));

        codigo = Integer.parseInt(valor);
        
        ComboItens universidade = new ComboItens();
        universidade.setCodigo(wViagem.getOUniversidade().getCodigo());
        new CombosDAO().definirItemCombo(edUniversidade, universidade);
        
        // ********** Dia da semana
        
        edDataIni.setText(wViagem.getDataIni());
        edDataFim.setText(wViagem.getDataFim());
        edHoraIda.setText(wViagem.getHoraSaida());
        edHoraVolta.setText(wViagem.getHoraVolta());
        edValor.setText(wViagem.getValor().toString());
        
        ComboItens motorista = new ComboItens();
        motorista.setCodigo(wViagem.getOFuncionario().getCodigo());
        new CombosDAO().definirItemCombo(edMotorisa, motorista);
        
        ComboItens veiculo = new ComboItens();
        veiculo.setCodigo(wViagem.getOVeiculo().getCodigo());
        new CombosDAO().definirItemCombo(edVeiculo, veiculo);
        
        this.GClientes = wViagem.getAClientes();
        AtualizaPassageiros();

        jTabbedPane1.setSelectedIndex(0);
        edUniversidade.requestFocus();
    }//GEN-LAST:event_btEditarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        codigo = 0;
        limpaCampos.limparCampos(pnCampos);
        jTabbedPane1.setSelectedIndex(0);
        edUniversidade.requestFocus();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        new viagemDAO().popularTabela(tbViagens, edBusca.getText());
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void edVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edVeiculoActionPerformed

    private void btAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddClienteActionPerformed
        SelecionarCliente wSelecionarCliente = new SelecionarCliente(null, true);
        Boolean wExiste = false;
        wSelecionarCliente.setVisible(true);
        int wCapacidade = Integer.parseInt(edCapacidade.getText());
        
        try {
            if (validaCampo()) {
                if((GClientes.size()+1) <= wCapacidade) 
                {
                    if (wSelecionarCliente.getTextSearch() != null)
                    { 
                        for (cliente GCliente : GClientes) {
                            if (GCliente.getCodigo() == wSelecionarCliente.getTextSearch().getCodigo())
                            {
                                wExiste = true;
                                break;
                            }
                        }
                        
                        if (!wExiste)
                        {
                            viagemDAO wViagemDAO = new viagemDAO();
                            ComboItens ciDiaSemana = (ComboItens) edDiaSemana.getSelectedItem();
                            
                            if (!wViagemDAO.validarPassageiro(wSelecionarCliente.getTextSearch().getCodigo(), codigo, 
                                Formatacao.ajustaDataAMD(edDataIni.getText()), 
                                Formatacao.ajustaDataAMD(edDataFim.getText()), 
                                edHoraIda.getText(), 
                                edHoraVolta.getText(), 
                                ciDiaSemana.getDescricao().toUpperCase().substring(0, 3))) 
                            {

                                JOptionPane.showMessageDialog(null, "Cliente em uso por outra viagem no periodo de dia e hora informados!");
                            }
                            else
                            {
                                GClientes.add(wSelecionarCliente.getTextSearch());
                                AtualizaPassageiros();
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Cliente já adicionado na lista!");
                        }
                    }
                    
                    lbPassageiros.setText("Passageiros: " + GClientes.size());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Não foi possivel adicionar o cliente na viagem, veículo atingiu sua capacidade maxima!");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(CadastroViagemF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAddClienteActionPerformed

    private void btAddCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddCliente1ActionPerformed
        String valor = String.valueOf(tbPassageiros.getValueAt(tbPassageiros.getSelectedRow(), 0));
        
        for (int i = 0; i < GClientes.size(); i++) 
        {
                if (GClientes.get(i).getCodigo() == Integer.parseInt(valor)) 
                {
                    GClientes.remove(i);
                    AtualizaPassageiros();
                }
       }
    }//GEN-LAST:event_btAddCliente1ActionPerformed

    private void edVeiculoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_edVeiculoItemStateChanged
        ComboItens ci = (ComboItens) edVeiculo.getSelectedItem();
        if (ci!=null) {
            if (ci.getCodigo() > 0)
            {
                edCapacidade.setText(new veiculoDAO().consultarId(ci.getCodigo()).getCapacidade() + "");
            }
        }
    }//GEN-LAST:event_edVeiculoItemStateChanged

    private void edDataFimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edDataFimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edDataFimActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        calcularIntervaloDatas(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        calcularIntervaloDatas(2);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private boolean validaCampo() throws ParseException {
        boolean wRetorno = true;

        ComboItens ciUniversidade = (ComboItens) edUniversidade.getSelectedItem();

        if (ciUniversidade == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma universidade!");
            edUniversidade.requestFocus();
            return false;
        }
        
        ComboItens ciDiaSemana = (ComboItens) edDiaSemana.getSelectedItem();

        if (ciDiaSemana == null) {
            JOptionPane.showMessageDialog(null, "Selecione um dia da semana!");
            edDiaSemana.requestFocus();
            return false;   
        }
        
        ComboItens ciMotorista = (ComboItens) edMotorisa.getSelectedItem();

        if (ciMotorista == null) {
            JOptionPane.showMessageDialog(null, "Selecione um motorista!");
            edMotorisa.requestFocus();
            return false;   
        }
        
        ComboItens ciVeiculo = (ComboItens) edVeiculo.getSelectedItem();

        if (ciVeiculo == null) {
            JOptionPane.showMessageDialog(null, "Selecione um veiculo!");
            edVeiculo.requestFocus();
            return false;   
        }
        

        if (Formatacao.removerFormatacao(edHoraIda.getText()).equals("")) {
            JOptionPane.showMessageDialog(null, "Campo hora ida inválido!");
            edHoraIda.requestFocus();
            return false;
        } else if (Formatacao.removerFormatacao(edHoraVolta.getText()).equals("")) {
            JOptionPane.showMessageDialog(null, "Campo hora volta inválido!");
            edHoraVolta.requestFocus();
            return false;
        }else if (Formatacao.removerFormatacao(edValor.getText()).equals("")) {
            JOptionPane.showMessageDialog(null, "Campo valor mensal inválido!");
            edValor.requestFocus();
            return false;
        }else if (Formatacao.removerFormatacao(edDataFim.getText()).equals("")) {
            JOptionPane.showMessageDialog(null, "Campo data final inválido!");
            edDataFim.requestFocus();
            return false;
        } else if (Formatacao.removerFormatacao(edDataIni.getText()).equals("")) {
            JOptionPane.showMessageDialog(null, "Campo data inicio inválido!");
            edDataIni.requestFocus();
            return false;
        } else if (!Validacao.validarDataFormatada(edDataIni.getText()))
        {
            JOptionPane.showMessageDialog(null, "Campo data inicio inválido!");
            edDataIni.requestFocus();
            return false; 
        } else if (!Validacao.validarDataFormatada(edDataFim.getText())) {
            JOptionPane.showMessageDialog(null, "Campo data final inválido!");
            edDataFim.requestFocus();
            return false;
        }
        
        SimpleDateFormat sdData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dataIni = Calendar.getInstance();
        Calendar dataFim = Calendar.getInstance();
        
        dataIni.setTime(sdData.parse(edDataIni.getText()));
        dataFim.setTime(sdData.parse(edDataFim.getText()));
        
        if (dataFim.before(dataIni)) {
           JOptionPane.showMessageDialog(null, "Campo data final menor que o campo data inicial!");
            edDataFim.requestFocus();
            return false; 
        }
        
        viagemDAO wViagemDAO = new viagemDAO();
        
        if (!wViagemDAO.validarDado(" funcionario_codigo = " + ciMotorista.getCodigo() +
                " and cronograma.codigo <> " + codigo, 
                Formatacao.ajustaDataAMD(edDataIni.getText()), 
                Formatacao.ajustaDataAMD(edDataFim.getText()), 
                edHoraIda.getText(), 
                edHoraVolta.getText(), 
                ciDiaSemana.getDescricao().toUpperCase().substring(0, 3))) {
            
            JOptionPane.showMessageDialog(null, "Motorista em uso por outra viagem no periodo de dia e hora informados!");
            edDataFim.requestFocus();
            return false;
        }
        
                
        if (!wViagemDAO.validarDado(" veiculo_codigo = " + ciVeiculo.getCodigo() +
                " and cronograma.codigo <> " + codigo, 
                Formatacao.ajustaDataAMD(edDataIni.getText()), 
                Formatacao.ajustaDataAMD(edDataFim.getText()), 
                edHoraIda.getText(), 
                edHoraVolta.getText(), 
                ciDiaSemana.getDescricao().toUpperCase().substring(0, 3))) {
            
            JOptionPane.showMessageDialog(null, "Veiculo em uso por outra viagem no periodo de dia e hora informados!");
            edDataFim.requestFocus();
            return false;
        }
        
        
        return true;
    }
    
    public void AtualizaPassageiros() 
    {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Cpf";
        
        dadosTabela = new Object[this.GClientes.size()][3];
        for (int j = 0; j < this.GClientes.size(); j++) 
        {
            dadosTabela[j][0] = this.GClientes.get(j).getCodigo();
            dadosTabela[j][1] = this.GClientes.get(j).getNome();
            dadosTabela[j][2] = this.GClientes.get(j).getCpf();
        }

        // configuracoes adicionais no componente tabela
       tbPassageiros.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
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
        tbPassageiros.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tbPassageiros.getColumnCount(); i++) 
        {
            column = tbPassageiros.getColumnModel().getColumn(i);
            switch (i) 
            {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }
    }
    
     private void calcularIntervaloDatas(int pSemestre)
    {
        Calendario cal = new Calendario();
        String wDataAtual = cal.obterDataAtualDMA();
        
        SimpleDateFormat sdData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dataIni = Calendar.getInstance();
        
        int mes = dataIni.getTime().getMonth();        
        if(pSemestre == 1)
        {
            edDataIni.setText("01/01/" + wDataAtual.split("/")[2]);
            edDataFim.setText("30/06/" + wDataAtual.split("/")[2]);
        }
        else
        {
            edDataIni.setText("01/07/" + wDataAtual.split("/")[2]);
            edDataFim.setText("31/12/" + wDataAtual.split("/")[2]);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddCliente;
    private javax.swing.JButton btAddCliente1;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JTextField edBusca;
    private javax.swing.JTextField edCapacidade;
    private javax.swing.JFormattedTextField edDataFim;
    private javax.swing.JFormattedTextField edDataIni;
    private javax.swing.JComboBox<String> edDiaSemana;
    private javax.swing.JFormattedTextField edHoraIda;
    private javax.swing.JFormattedTextField edHoraVolta;
    private javax.swing.JComboBox<String> edMotorisa;
    private javax.swing.JComboBox<String> edUniversidade;
    private javax.swing.JFormattedTextField edValor;
    private javax.swing.JComboBox<String> edVeiculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbPassageiros;
    private javax.swing.JPanel pnCampos;
    private javax.swing.JPanel pnLista;
    private javax.swing.JTable tbPassageiros;
    private javax.swing.JTable tbViagens;
    // End of variables declaration//GEN-END:variables
}
