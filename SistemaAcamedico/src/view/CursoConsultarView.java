/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Curso;
import dao.CursoDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aluno
 */
public class CursoConsultarView extends javax.swing.JFrame {
Vector<Curso> listaCursos;
    /**
     * Creates new form CursoBuscarView
     */
    public CursoConsultarView() {
        initComponents();
        carregarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtBuscar = new javax.swing.JButton();
        jtfBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCursos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONSULTAR CURSO");

        jbtBuscar.setText("BUSCAR");
        jbtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtBuscarMouseClicked(evt);
            }
        });
        jbtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBuscarActionPerformed(evt);
            }
        });

        jtbCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Sigla", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCursosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCursos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jbtBuscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtBuscarMouseClicked
        // TODO add your handling code here:
        String valorBuscado = jtfBuscar.getText();
        try {
            CursoDAO cdao = new CursoDAO();         
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jbtBuscarMouseClicked

    private void jbtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBuscarActionPerformed
        // TODO add your handling code here:
        carregarTabela();
    }//GEN-LAST:event_jbtBuscarActionPerformed

    private void jtbCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCursosMouseClicked
        // TODO add your handling code here:
        int index = jtbCursos.getSelectedRow();
        Curso cursoSelecionado = listaCursos.get(index);
        
        System.out.println(cursoSelecionado.getDescricao());
        CursoAlterarExcluirView cursoAE = new CursoAlterarExcluirView();
        cursoAE.getCurso(cursoSelecionado);
        cursoAE.setLocationRelativeTo(null);
        cursoAE.setVisible(true);
        
        
        
    }//GEN-LAST:event_jtbCursosMouseClicked
    private void carregarTabela(){
        String valorBuscado = jtfBuscar.getText();
       
       
        try {
             CursoDAO cdao = new CursoDAO();
             Vector linhas = new Vector(),colunas = new Vector();
             listaCursos = cdao.consultar(valorBuscado);
 
            colunas.add("Código");
            colunas.add("Sigla");
            colunas.add("Descricao");

            for(Curso curso:listaCursos){
                Vector linha = new Vector();
                linha.add(curso.getCodigo());
                linha.add(curso.getSigla());
                linha.add(curso.getDescricao());
                linhas.add(linha);
            }
            DefaultTableModel model = new DefaultTableModel(linhas,colunas);
            jtbCursos.setModel(model);
            
          
        } catch (Exception e) {
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
            java.util.logging.Logger.getLogger(CursoConsultarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CursoConsultarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CursoConsultarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CursoConsultarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CursoConsultarView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtBuscar;
    private javax.swing.JTable jtbCursos;
    private javax.swing.JTextField jtfBuscar;
    // End of variables declaration//GEN-END:variables
}
