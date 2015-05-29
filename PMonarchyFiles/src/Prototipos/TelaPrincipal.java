/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototipos;

/**
 *
 * @author taynara_muren
 */
public class TelaPrincipal extends javax.swing.JDialog {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal(java.awt.Frame parent, boolean modal, String obj) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        btnEmpresas = new javax.swing.JButton();
        btnDocumentos = new javax.swing.JButton();
        btnUsuários = new javax.swing.JButton();
        btnArmazem = new javax.swing.JButton();
        btnProtocolar = new javax.swing.JButton();
        btnDocumentos1 = new javax.swing.JButton();
        btnPesquisarProtocolo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastrar = new javax.swing.JMenu();
        menuCadastroUsuario = new javax.swing.JMenuItem();
        menuCadastroEmpresa = new javax.swing.JMenuItem();
        menuCadastroPrateleira = new javax.swing.JMenuItem();
        menuCadastroDocumentos = new javax.swing.JMenuItem();
        menuPesquisar = new javax.swing.JMenu();
        menuPesquisarUsuario = new javax.swing.JMenuItem();
        menuPesquisarEmpresa = new javax.swing.JMenuItem();
        menuPesquisarPrateleira = new javax.swing.JMenuItem();
        menuPesquisarDocumento = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Monarchy Files");

        btnEmpresas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icoEmpresa.png"))); // NOI18N
        btnEmpresas.setText("Empresas");
        btnEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresasActionPerformed(evt);
            }
        });

        btnDocumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icoDocumento.png"))); // NOI18N
        btnDocumentos.setText("Documentos");
        btnDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocumentosActionPerformed(evt);
            }
        });

        btnUsuários.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icoUsuarios.png"))); // NOI18N
        btnUsuários.setText("Usuários");
        btnUsuários.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuáriosActionPerformed(evt);
            }
        });

        btnArmazem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icoArmazem.png"))); // NOI18N
        btnArmazem.setText("Armazém");
        btnArmazem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArmazemActionPerformed(evt);
            }
        });

        btnProtocolar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icoProtocolar.png"))); // NOI18N
        btnProtocolar.setText("Protocolar");
        btnProtocolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProtocolarActionPerformed(evt);
            }
        });

        btnDocumentos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icoPesquisarDocumento.png"))); // NOI18N
        btnDocumentos1.setText("Pesquisar");
        btnDocumentos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocumentos1ActionPerformed(evt);
            }
        });

        btnPesquisarProtocolo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icoPesquisarDocumento.png"))); // NOI18N
        btnPesquisarProtocolo.setText("Pesquisar Protocolo");
        btnPesquisarProtocolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProtocoloActionPerformed(evt);
            }
        });

        menuCadastrar.setText("Cadastrar");

        menuCadastroUsuario.setText("Usuário");
        menuCadastroUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCadastroUsuarioMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuCadastroUsuarioMouseReleased(evt);
            }
        });
        menuCadastrar.add(menuCadastroUsuario);

        menuCadastroEmpresa.setText("Empresa");
        menuCadastroEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroEmpresaActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuCadastroEmpresa);

        menuCadastroPrateleira.setText("Prateleira");
        menuCadastroPrateleira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroPrateleiraActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuCadastroPrateleira);

        menuCadastroDocumentos.setText("Documentos");
        menuCadastroDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroDocumentosActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuCadastroDocumentos);

        jMenuBar1.add(menuCadastrar);

        menuPesquisar.setText("Pesquisar");

        menuPesquisarUsuario.setText("Usuário");
        menuPesquisarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuPesquisarUsuarioMouseReleased(evt);
            }
        });
        menuPesquisarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPesquisarUsuarioActionPerformed(evt);
            }
        });
        menuPesquisar.add(menuPesquisarUsuario);

        menuPesquisarEmpresa.setText("Empresa");
        menuPesquisarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPesquisarEmpresaActionPerformed(evt);
            }
        });
        menuPesquisar.add(menuPesquisarEmpresa);

        menuPesquisarPrateleira.setText("Prateleira");
        menuPesquisarPrateleira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPesquisarPrateleiraActionPerformed(evt);
            }
        });
        menuPesquisar.add(menuPesquisarPrateleira);

        menuPesquisarDocumento.setText("Documento");
        menuPesquisarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPesquisarDocumentoActionPerformed(evt);
            }
        });
        menuPesquisar.add(menuPesquisarDocumento);

        jMenuBar1.add(menuPesquisar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEmpresas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPesquisarProtocolo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProtocolar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnArmazem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDocumentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUsuários, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDocumentos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmpresas)
                    .addComponent(btnDocumentos))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDocumentos1)
                    .addComponent(btnArmazem))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuários)
                    .addComponent(btnProtocolar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnPesquisarProtocolo)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastroUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroUsuarioMouseClicked

    }//GEN-LAST:event_menuCadastroUsuarioMouseClicked

    private void menuCadastroUsuarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroUsuarioMouseReleased
        CadastroUsuario objTela = new CadastroUsuario(this, true);

        objTela.setVisible(true);
    }//GEN-LAST:event_menuCadastroUsuarioMouseReleased

    private void menuPesquisarUsuarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPesquisarUsuarioMouseReleased

    }//GEN-LAST:event_menuPesquisarUsuarioMouseReleased

    private void menuCadastroDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroDocumentosActionPerformed
        TelaCadastroDocumentos t = new TelaCadastroDocumentos(null, true);
        t.setVisible(true);
    }//GEN-LAST:event_menuCadastroDocumentosActionPerformed

    private void menuCadastroPrateleiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroPrateleiraActionPerformed
        TelaPrateleiraNovo t = new TelaPrateleiraNovo(null, true);
        t.setVisible(true);
    }//GEN-LAST:event_menuCadastroPrateleiraActionPerformed

    private void menuCadastroEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroEmpresaActionPerformed
        TelaCadastroEmpresa t = new TelaCadastroEmpresa(null, true);
        t.setVisible(true);
    }//GEN-LAST:event_menuCadastroEmpresaActionPerformed

    private void btnEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresasActionPerformed
        TelaEmpresa t = new TelaEmpresa(null, true);
        t.setVisible(true);
    }//GEN-LAST:event_btnEmpresasActionPerformed

    private void btnDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocumentosActionPerformed
        TelaCadastroDocumentos t = new TelaCadastroDocumentos(null, true);
        t.setVisible(true);
    }//GEN-LAST:event_btnDocumentosActionPerformed

    private void btnArmazemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArmazemActionPerformed
        TelaPrateleiraCRUD t = new TelaPrateleiraCRUD(null, true);
        t.setVisible(true);
    }//GEN-LAST:event_btnArmazemActionPerformed

    private void btnUsuáriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuáriosActionPerformed
        ListaUsuario objTela = new ListaUsuario(this, true);
        objTela.setVisible(true);
    }//GEN-LAST:event_btnUsuáriosActionPerformed

    private void btnProtocolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProtocolarActionPerformed
        TelaProtocolo t = new TelaProtocolo(null, true);
        t.setVisible(true);
    }//GEN-LAST:event_btnProtocolarActionPerformed

    private void btnDocumentos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocumentos1ActionPerformed
        TelaConsultaDocumento t = new TelaConsultaDocumento(null, true);
        t.setVisible(true);
    }//GEN-LAST:event_btnDocumentos1ActionPerformed

    private void menuPesquisarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPesquisarUsuarioActionPerformed
        ListaUsuario telaUsuarios = new ListaUsuario(null, true);
        telaUsuarios.setVisible(true);
    }//GEN-LAST:event_menuPesquisarUsuarioActionPerformed

    private void menuPesquisarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPesquisarDocumentoActionPerformed
        TelaConsultaDocumento telaDocumentos = new TelaConsultaDocumento(null, true);
        telaDocumentos.setVisible(true);
    }//GEN-LAST:event_menuPesquisarDocumentoActionPerformed

    private void menuPesquisarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPesquisarEmpresaActionPerformed
        TelaEmpresa telaEmpresas = new TelaEmpresa(null, true);
        telaEmpresas.setVisible(true);
    }//GEN-LAST:event_menuPesquisarEmpresaActionPerformed

    private void menuPesquisarPrateleiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPesquisarPrateleiraActionPerformed
        TelaPrateleiraCRUD telaPrateleiras = new TelaPrateleiraCRUD(null, true);
        telaPrateleiras.setVisible(true);
    }//GEN-LAST:event_menuPesquisarPrateleiraActionPerformed

    private void btnPesquisarProtocoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProtocoloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisarProtocoloActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPrincipal dialog = new TelaPrincipal(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton btnArmazem;
    private javax.swing.JButton btnDocumentos;
    private javax.swing.JButton btnDocumentos1;
    private javax.swing.JButton btnEmpresas;
    private javax.swing.JButton btnPesquisarProtocolo;
    private javax.swing.JButton btnProtocolar;
    private javax.swing.JButton btnUsuários;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenu menuCadastrar;
    private javax.swing.JMenuItem menuCadastroDocumentos;
    private javax.swing.JMenuItem menuCadastroEmpresa;
    private javax.swing.JMenuItem menuCadastroPrateleira;
    private javax.swing.JMenuItem menuCadastroUsuario;
    private javax.swing.JMenu menuPesquisar;
    private javax.swing.JMenuItem menuPesquisarDocumento;
    private javax.swing.JMenuItem menuPesquisarEmpresa;
    private javax.swing.JMenuItem menuPesquisarPrateleira;
    private javax.swing.JMenuItem menuPesquisarUsuario;
    // End of variables declaration//GEN-END:variables
}
