/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package condominio.screens;

import condominio.model.Condominio;
import condominio.wrapper.*;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author andre
 */
public class ListaDeCondominios extends javax.swing.JFrame {
    Wrapper wrapper;
    ArrayList <Condominio> condominios;
    TelaInicial telaInicial;
    Condominio condominioSelecionado;
    /**
     * Creates new form ListaDeCondominios
     */
    public ListaDeCondominios(Wrapper wrapper, TelaInicial telaInicial) {
        this.wrapper = wrapper;
        this.condominios = wrapper.condominioDAO.findAll();
        initComponents();
        this.telaInicial = telaInicial;
        updateTable();
        listSelectionListener();
    }

    public void updateTable() {
    DefaultTableModel model = (DefaultTableModel) tbCondominios.getModel();
    model.setRowCount(0); // Clear existing rows
    
        for (Condominio condominio : condominios) {
            Object[] rowData = {
                condominio.getNome(),
                condominio.getEndereco(),
                condominio.getTaxaMensalCondominio(),
                condominio.getFatorMultiplicadorDeMetragem(),
                condominio.getValorVagaGaragem()
            };
            model.addRow(rowData);
        }
    }

    public void listSelectionListener (){
        tbCondominios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tbCondominios.getSelectedRow();
                    if (selectedRow != -1) {
                        // Linha foi selecionada
                        condominioSelecionado = condominios.get(selectedRow);
                    
                    }
                }
            }
        });
    }
    
    public void atualizarLista(){
        condominios = wrapper.condominioDAO.findAll();
        updateTable();
    }
    
    public void exibirMensagem(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbCondominios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        btVisualizarBlocos = new javax.swing.JButton();
        btEditarCondominio = new javax.swing.JButton();
        btExcluirCondominio = new javax.swing.JButton();
        btAtualizarLista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(640, 480));

        tbCondominios.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbCondominios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Endereço", "Taxa Mensal", "Valor/m²", "Taxa Garagem"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
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
        tbCondominios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbCondominios.setGridColor(new java.awt.Color(204, 204, 204));
        tbCondominios.setName(""); // NOI18N
        tbCondominios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbCondominios.setShowGrid(true);
        jScrollPane1.setViewportView(tbCondominios);

        jLabel1.setText("Lista de Condomínios");

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btVisualizarBlocos.setText("Visualizar Blocos");
        btVisualizarBlocos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisualizarBlocosActionPerformed(evt);
            }
        });

        btEditarCondominio.setText("Editar Condominio");
        btEditarCondominio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarCondominioActionPerformed(evt);
            }
        });

        btExcluirCondominio.setBackground(new java.awt.Color(153, 0, 0));
        btExcluirCondominio.setForeground(new java.awt.Color(255, 255, 255));
        btExcluirCondominio.setText("Excluir Condominio");
        btExcluirCondominio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirCondominioActionPerformed(evt);
            }
        });

        btAtualizarLista.setText("Atualizar Lista");
        btAtualizarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btExcluirCondominio)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(btVisualizarBlocos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btEditarCondominio, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btAtualizarLista)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btAtualizarLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btEditarCondominio, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btVisualizarBlocos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addComponent(btExcluirCondominio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btVoltar))
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.setVisible(false);
        this.telaInicial.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btVisualizarBlocosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisualizarBlocosActionPerformed
        if(condominioSelecionado != null) {
            ListaBlocos listaBlocos = new ListaBlocos(wrapper, this, this.condominioSelecionado);
            listaBlocos.setVisible(true);
            this.setVisible(false);
        } else {
            exibirMensagem("Nenhum condomínio selecionado.");
        }
    }//GEN-LAST:event_btVisualizarBlocosActionPerformed

    private void btEditarCondominioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarCondominioActionPerformed
        if (condominioSelecionado != null) {
            EditarCondominio editarCondominio = new EditarCondominio(wrapper, this, condominioSelecionado);
            editarCondominio.setVisible(true);
            this.setVisible(false);
        } else {
            exibirMensagem("Nenhum condomínio selecionado.");
        }
    }//GEN-LAST:event_btEditarCondominioActionPerformed

    private void btExcluirCondominioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirCondominioActionPerformed
        if (condominioSelecionado != null) {
            int resposta = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja excluir o condomínio '" + condominioSelecionado.getNome() + "'?", 
                    "Confirmar exclusão",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                wrapper.condominioDAO.delete(condominioSelecionado.getIdCondominio());
                exibirMensagem("Condomínio excluído com sucesso!");
                condominioSelecionado = null;
                atualizarLista();
            }
        } else {
            exibirMensagem("Nenhum condomínio selecionado.");
        }
    }//GEN-LAST:event_btExcluirCondominioActionPerformed

    private void btAtualizarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarListaActionPerformed
        condominios = wrapper.condominioDAO.findAll();
        updateTable();
    }//GEN-LAST:event_btAtualizarListaActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ListaDeCondominios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ListaDeCondominios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ListaDeCondominios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ListaDeCondominios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ListaDeCondominios().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizarLista;
    private javax.swing.JButton btEditarCondominio;
    private javax.swing.JButton btExcluirCondominio;
    private javax.swing.JButton btVisualizarBlocos;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCondominios;
    // End of variables declaration//GEN-END:variables
}
