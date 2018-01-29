/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author carlosafc
 */
public class TelaPrincipal extends javax.swing.JFrame {
    

    /**
     * Creates new form TelaPrincipal
     */
    
    
    public TelaPrincipal() {
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

        desktopPane = new javax.swing.JDesktopPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        cadastroClienteMenu = new javax.swing.JMenuItem();
        cadastroEquipamentoMenu = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();
        sobreMenuItem = new javax.swing.JMenuItem();
        sairMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Oficina Ilhatec");
        setPreferredSize(new java.awt.Dimension(600, 450));

        desktopPane.setBackground(new java.awt.Color(102, 102, 255));

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 255));
        jDesktopPane1.setAutoscrolls(true);
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(640, 4));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        desktopPane.add(jDesktopPane1);
        jDesktopPane1.setBounds(0, 0, 600, 450);

        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        menuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/if_system-file-manager_118825.png"))); // NOI18N
        menuCadastro.setMnemonic('f');
        menuCadastro.setText("Arquivo");

        cadastroClienteMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/if_client_account_template_64002.png"))); // NOI18N
        cadastroClienteMenu.setMnemonic('c');
        cadastroClienteMenu.setText("Clientes");
        cadastroClienteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroClienteMenuActionPerformed(evt);
            }
        });
        menuCadastro.add(cadastroClienteMenu);

        cadastroEquipamentoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/if_computer_add_16x16.png"))); // NOI18N
        cadastroEquipamentoMenu.setMnemonic('e');
        cadastroEquipamentoMenu.setText("Equipamentos");
        cadastroEquipamentoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroEquipamentoMenuActionPerformed(evt);
            }
        });
        menuCadastro.add(cadastroEquipamentoMenu);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/if_stock_form-table-control_21421.png"))); // NOI18N
        jMenuItem2.setText("Relatórios");
        menuCadastro.add(jMenuItem2);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/if_application_form_magnify_35651.png"))); // NOI18N
        jMenuItem1.setText("Consultas");
        menuCadastro.add(jMenuItem1);

        menuBar.add(menuCadastro);

        menuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/if_gtk-about_29340.png"))); // NOI18N
        menuSobre.setText("Sobre");

        sobreMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/if_client_account_template_64002.png"))); // NOI18N
        sobreMenuItem.setText("Sobre");
        sobreMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobreMenuItemActionPerformed(evt);
            }
        });
        menuSobre.add(sobreMenuItem);

        sairMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/op_delete.png"))); // NOI18N
        sairMenu.setText("Sair");
        sairMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairMenuActionPerformed(evt);
            }
        });
        menuSobre.add(sairMenu);

        menuBar.add(menuSobre);

        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastroClienteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroClienteMenuActionPerformed
        // TODO add your handling code here:
        ClienteView cadCliente = new ClienteView();
        jDesktopPane1.add(cadCliente);
        cadCliente.setVisible(true);
    }//GEN-LAST:event_cadastroClienteMenuActionPerformed

    private void cadastroEquipamentoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroEquipamentoMenuActionPerformed
        // TODO add your handling code here:
        EquipamentoView cadEquipamento = new EquipamentoView();
        this.desktopPane.add(cadEquipamento);
        cadEquipamento.setVisible(true);
    }//GEN-LAST:event_cadastroEquipamentoMenuActionPerformed

    private void sobreMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sobreMenuItemActionPerformed
//        TelaSobre telaSobre = new TelaSobre();
//        this.desktopPane.add(telaSobre);
//        telaSobre.setVisible(true);
    }//GEN-LAST:event_sobreMenuItemActionPerformed

    private void sairMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairMenuActionPerformed
        // Exibe uma caixa de diálogo de alerta
        int sair = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair?","Atenção",JOptionPane.YES_OPTION);
        if(sair == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_sairMenuActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cadastroClienteMenu;
    private javax.swing.JMenuItem cadastroEquipamentoMenu;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JMenuItem sairMenu;
    private javax.swing.JMenuItem sobreMenuItem;
    // End of variables declaration//GEN-END:variables

}
