/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ProtocoloDAO;
import entity.Protocolo;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elder_benites
 */
public class TelaPesquisarProtocolo extends javax.swing.JDialog {

    /**
     * Creates new form TelaPesquisarProtocolo1
     */
    public TelaPesquisarProtocolo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumeroProtocolo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JTextField();
        cbNomeEmpresa = new javax.swing.JComboBox();
        btnPesquisar = new javax.swing.JButton();
        txtDataEntrada = new javax.swing.JFormattedTextField();
        txtDataSaida = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDadosFiltro = new javax.swing.JTable();
        btVoltar = new javax.swing.JButton();
        btnDetalhe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar Protocolo"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jLabel1.setText("Nº Protocolo documento:");

        jLabel2.setText("Data Entrada:");

        jLabel3.setText("Data Saída:");

        jLabel4.setText("Empresa:");

        jLabel5.setText("CNPJ:");

        cbNomeEmpresa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Google", "Yahoo", "MonarchyFile", "Almeida Jr" }));

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Find.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        try {
            txtDataEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbNomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(txtDataEntrada))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataSaida))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnPesquisar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumeroProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Filtro"));

        tblDadosFiltro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nº Protocolo Documento", "Data Entrada", "Data Saída", "Empresa", "CNPJ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDadosFiltro);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back.png"))); // NOI18N
        btVoltar.setText("Voltar");

        btnDetalhe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/List.png"))); // NOI18N
        btnDetalhe.setText("Detalhe");
        btnDetalhe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDetalhe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDetalhe)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        if (txtNumeroProtocolo.equals("")) {
//            Protocolo objPesquisarProtocolo = new Protocolo();
//            objPesquisarProtocolo.setCnpj(txtCnpj.getText());
//            objPesquisarProtocolo.setDataEntrada(txtDataEntrada.getText());
//            objPesquisarProtocolo.setDataSaida(txtDataSaida.getText());

            AtualizarTabela();
            
            ProtocoloDAO dao = new ProtocoloDAO();
            //dao.select(objPesquisarProtocolo);

        } else {
            //se campo Numero protocolo estiver vazio irá executar essa função
//            PesquisarProtocolo objPesquisarProtocolo = new PesquisarProtocolo();
//            objPesquisarProtocolo.setNumeroProtocolo(txtNumeroProtocolo.getText());
//            ProtocoloDAO dao = new ProtocoloDAO();
            //dao.select(objPesquisarProtocolo.getNumeroProtocolo());

        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnDetalheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalheActionPerformed
        int linha = tblDadosFiltro.getSelectedRow();
        int id = Integer.parseInt(tblDadosFiltro.getValueAt(linha, 0).toString());
        ProtocoloDAO dao = new ProtocoloDAO();
        Protocolo objProtocolo = dao.getProtocoloById(id);

        TelaDetalhePesquisarProtocolo tela = new TelaDetalhePesquisarProtocolo(null, rootPaneCheckingEnabled);
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnDetalheActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarProtocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarProtocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarProtocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarProtocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPesquisarProtocolo dialog = new TelaPesquisarProtocolo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVoltar;
    private javax.swing.JButton btnDetalhe;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox cbNomeEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDadosFiltro;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JFormattedTextField txtDataEntrada;
    private javax.swing.JFormattedTextField txtDataSaida;
    private javax.swing.JTextField txtNumeroProtocolo;
    // End of variables declaration//GEN-END:variables

    private void AtualizarTabela() {

//        ProtocoloDAO dao = new ProtocoloDAO();
//        List<Protocolo> listaProtocolo = dao.listarProtocolo();
//
//        DefaultTableModel model = (DefaultTableModel) this.tblDadosFiltro.getModel();
//
//        model.setRowCount(listaProtocolo.size());
//
//        for (int i = 0; i < listaProtocolo.size(); i++) {
//            model.setValueAt(listaProtocolo.get(i).getId(), i, 0);
//            model.setValueAt(listaProtocolo.get(i).getNumero(), i, 1);
//            model.setValueAt(listaProtocolo.get(i).getDataEntrada(), i, 2);
//            model.setValueAt(listaProtocolo.get(i).getDataSaida(), i, 3);
//            model.setValueAt(listaProtocolo.get(i).getEmpresa(), i, 3);
//            model.setValueAt(listaProtocolo.get(i).getCnpj(), i, 3);
//        }
    }
}