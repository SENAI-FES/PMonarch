package view;

import dao.ArmazemDAO;
import entity.Armazem;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

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
        combo();
        tblPrateleira.setAutoCreateRowSorter(true);
        alinhamentoEsquerda = new DefaultTableCellRenderer();
        alinhamentoEsquerda.setHorizontalAlignment(SwingConstants.LEFT);
        btnAtivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Fall.png")));
        btnAtivar.setText("Inativar");
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
        tblPrateleira = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();
        ckbMostrarInativos = new javax.swing.JCheckBox();

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

        cbRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRuaActionPerformed(evt);
            }
        });

        tblPrateleira.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rua", "Estante", "Coluna", "Andar", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPrateleira.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblPrateleiraMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblPrateleira);

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        ckbMostrarInativos.setText("Mostrar inativos");
        ckbMostrarInativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbMostrarInativosActionPerformed(evt);
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
                        .addComponent(cbRua, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckbMostrarInativos)))
                .addGap(50, 50, 50))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAlterar, btnNovo, btnVoltar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ckbMostrarInativos, javax.swing.GroupLayout.Alignment.LEADING))
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
        cbRua.addItem("Selecione a rua");
        String cbSelecionado = (String) cbRua.getSelectedItem();
        combo();
        cbRua.setSelectedItem(cbSelecionado);

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linha = tblPrateleira.getSelectedRow();
        if (linha > -1) {
            Armazem armazem = new Armazem();
            armazem.setRua((String) tblPrateleira.getValueAt(linha, 0));
            armazem.setEstante((String) tblPrateleira.getValueAt(linha, 1));
            armazem.setColuna((String) tblPrateleira.getValueAt(linha, 2));
            armazem.setAndar((String) tblPrateleira.getValueAt(linha, 3));
            TelaPrateleiraNovo telaNovo = new TelaPrateleiraNovo(null, true, false, armazem);
            telaNovo.setVisible(true);
            String cbSelecionado = (String) cbRua.getSelectedItem();
            combo();
            cbRua.setSelectedItem(cbSelecionado);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um endereço para alterar");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtivarActionPerformed
        int linha = tblPrateleira.getSelectedRow();
        if (linha > -1) {
            ArmazemDAO dao = new ArmazemDAO();
            Armazem armazem = new Armazem();
            armazem.setRua((String) tblPrateleira.getValueAt(linha, 0));
            armazem.setEstante((String) tblPrateleira.getValueAt(linha, 1));
            armazem.setColuna((String) tblPrateleira.getValueAt(linha, 2));
            armazem.setAndar((String) tblPrateleira.getValueAt(linha, 3));
            if (btnAtivar.getText().equals("Inativar")) {
                armazem.setAtivo(false);
                dao.ativarDesativar(armazem);
                atualizarTabela();
            } else {
                armazem.setAtivo(true);
                dao.ativarDesativar(armazem);
                atualizarTabelaTodosInativos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um endereço para ativar/inativar");
        }
    }//GEN-LAST:event_btnAtivarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void cbRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRuaActionPerformed
        limparTabela();
        atualizarTabela();
    }//GEN-LAST:event_cbRuaActionPerformed

    private void tblPrateleiraMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrateleiraMouseReleased
        ArmazemDAO dao = new ArmazemDAO();
        Armazem armazem = new Armazem();
        int linha = tblPrateleira.getSelectedRow();
        armazem.setRua((String) tblPrateleira.getValueAt(linha, 0));
        armazem.setEstante((String) tblPrateleira.getValueAt(linha, 1));
        armazem.setColuna((String) tblPrateleira.getValueAt(linha, 2));
        armazem.setAndar((String) tblPrateleira.getValueAt(linha, 3));
        if (tblPrateleira.getValueAt(linha, 4).equals("Ativo")) {
            armazem.setAtivo(true);
        } else {
            armazem.setAtivo(false);
        }
        if (armazem.isAtivo()) {
            btnAtivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Fall.png")));
            btnAtivar.setText("Inativar");
        } else {
            btnAtivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Raise.png")));
            btnAtivar.setText("Ativar");
        }
    }//GEN-LAST:event_tblPrateleiraMouseReleased

    private void ckbMostrarInativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbMostrarInativosActionPerformed
        if (ckbMostrarInativos.isSelected() && cbRua.getSelectedIndex() == 0) {
            atualizarTabelaTodosInativos();
            btnAtivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Fall.png")));
            btnAtivar.setText("Inativar");
        } else if (ckbMostrarInativos.isSelected()) {
            atualizarTabela();
            btnAtivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Raise.png")));
            btnAtivar.setText("Ativar");
        } else {
            atualizarTabela();
            btnAtivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Raise.png")));
            btnAtivar.setText("Ativar");
        }

    }//GEN-LAST:event_ckbMostrarInativosActionPerformed

    public void atualizarTabela() {
        if (cbRua.getModel().getSize() > 0) {
            String rua = cbRua.getSelectedItem().toString();
            ArmazemDAO aDAO = new ArmazemDAO();
            DefaultTableModel model = (DefaultTableModel) this.tblPrateleira.getModel();
            List<Armazem> lista;
            if (ckbMostrarInativos.isSelected()) {
                lista = aDAO.listarArmazemInativo(rua);
            } else {
                lista = aDAO.listarArmazem(rua);
            }
            model.setNumRows(0);
            for (int i = 0; i < lista.size(); i++) {
                if (tblPrateleira.getRowCount() < lista.size()) {
                    model.addRow(new Object[]{});
                    if (!lista.get(i).isAtivo()) {

                    }

                }
                model.setValueAt(lista.get(i).getRua(), i, 0);
                model.setValueAt(lista.get(i).getEstante(), i, 1);
                model.setValueAt(lista.get(i).getColuna(), i, 2);
                model.setValueAt(lista.get(i).getAndar(), i, 3);
                if (lista.get(i).isAtivo()) {
                    model.setValueAt("Ativo", i, 4);
                } else {
                    model.setValueAt("Inativo", i, 4);
                }
            }
            for (int i = 0; i < tblPrateleira.getColumnCount(); i++) {
                tblPrateleira.getColumnModel().getColumn(i).setCellRenderer(alinhamentoEsquerda);
            }
        }
    }

    public void atualizarTabelaTodosInativos() {
        if (cbRua.getModel().getSize() > 0) {
            ArmazemDAO aDAO = new ArmazemDAO();
            List<Armazem> lista = aDAO.listarArmazemDesativado();
            DefaultTableModel model = (DefaultTableModel) this.tblPrateleira.getModel();
            model.setNumRows(0);
            for (int i = 0; i < lista.size(); i++) {
                if (tblPrateleira.getRowCount() < lista.size()) {
                    model.addRow(new Object[]{});
                }
                model.setValueAt(lista.get(i).getRua(), i, 0);
                model.setValueAt(lista.get(i).getEstante(), i, 1);
                model.setValueAt(lista.get(i).getColuna(), i, 2);
                model.setValueAt(lista.get(i).getAndar(), i, 3);
                if (lista.get(i).isAtivo()) {
                    model.setValueAt("Ativo", i, 4);
                } else {
                    model.setValueAt("Inativo", i, 4);
                }

            }
        }
    }

    public void limparTabela() {
        DefaultTableModel model = (DefaultTableModel) this.tblPrateleira.getModel();
        String limpa = "";
        for (int i = 0; i < tblPrateleira.getRowCount(); i++) {
            model.setValueAt(limpa, i, 0);
            model.setValueAt(limpa, i, 1);
            model.setValueAt(limpa, i, 2);
            model.setValueAt(limpa, i, 3);
            model.removeRow(i);
        }
    }

    public void combo() {
        cbRua.removeAll();
        cbRua.removeAllItems();
        cbRua.addItem("Selecione a rua");
        ArmazemDAO aDAO = new ArmazemDAO();
        List<Armazem> lista = aDAO.listaRuaCombo();
        for (Armazem rua : lista) {
            cbRua.addItem(rua.getRua());
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
    private javax.swing.JCheckBox ckbMostrarInativos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPrateleira;
    // End of variables declaration//GEN-END:variables
DefaultTableCellRenderer alinhamentoEsquerda;
}
