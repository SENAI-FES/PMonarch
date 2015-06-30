package Prototipos;

import dao.ArmazemDAO;
import entity.Armazem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author matheus_santos_fraga
 */
public class TelaPrateleiraCRUD extends javax.swing.JDialog {

    /**
     * Creates new form TelaPrateleiraCRUD
     */
    public TelaPrateleiraCRUD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        atualizarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnAtivar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbRua = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPrateleira = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Prateleiras");
        setResizable(false);

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/New document.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Modify.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnAtivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Raise.png"))); // NOI18N
        btnAtivar.setText("Ativar");
        btnAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtivarActionPerformed(evt);
            }
        });

        jLabel1.setText("Rua:");

        cbRua.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E" }));

        tbPrateleira.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rua", "Estante", "Coluna", "Andar", "QtdCaixas"
            }
        ));
        jScrollPane1.setViewportView(tbPrateleira);

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnAlterar)
                .addGap(37, 37, 37)
                .addComponent(btnAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnVoltar)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRua, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAlterar, btnNovo, btnVoltar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnAlterar)
                    .addComponent(btnAtivar)
                    .addComponent(btnVoltar))
                .addGap(21, 21, 21))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAlterar, btnAtivar, btnNovo, btnVoltar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        TelaPrateleiraNovo telaNovo = new TelaPrateleiraNovo(null, true, true);
        telaNovo.setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        TelaPrateleiraNovo telaNovo = new TelaPrateleiraNovo(null, true, false);
        telaNovo.setVisible(true);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtivarActionPerformed
        if (btnAtivar.getText().equals("Desativar")) {
            btnAtivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Raise.png")));
            btnAtivar.setText("Ativar");
        } else {
            btnAtivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Fall.png")));
            btnAtivar.setText("Desativar");
        }
    }//GEN-LAST:event_btnAtivarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    public void atualizarTabela() {

        String rua = cbRua.getSelectedItem().toString();
        ArmazemDAO aDAO = new ArmazemDAO();
        Armazem a = new Armazem();
        List<Armazem> lista = aDAO.listarArmazem(rua);
        DefaultTableModel model = (DefaultTableModel) this.tbPrateleira.getModel();
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{});
            model.setValueAt(lista.get(i).getRua(), i, 0);
            model.setValueAt(lista.get(i).getEstante(), i, 1);
            model.setValueAt(lista.get(i).getColuna(), i, 2);
            model.setValueAt(lista.get(i).getAndar(), i, 3);

        }
    }

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
            java.util.logging.Logger.getLogger(TelaPrateleiraCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrateleiraCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrateleiraCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrateleiraCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPrateleiraCRUD dialog = new TelaPrateleiraCRUD(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtivar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cbRua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPrateleira;
    // End of variables declaration//GEN-END:variables
}
