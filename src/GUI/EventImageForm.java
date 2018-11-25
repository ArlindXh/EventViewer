/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.Event;
import BL.EventImages;
import DAL.EventRepository;
import DAL.EventImagesException;
import Model.EventImageModel;
import DAL.EventImagesInterface;
import DAL.EventImagesRepository;
import Model.EventComboBoxModel;
import com.sun.glass.events.KeyEvent;
import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class EventImageForm extends javax.swing.JInternalFrame {

        EventRepository eventR = new EventRepository();
        EventImagesRepository eiR = new EventImagesRepository();
        EventImageModel eiModel= new EventImageModel ();
        EventComboBoxModel ecbm;
    
    public EventImageForm() {
        initComponents();
        tableLoad();
    }
     public void emptyObject()
    {
        tabela.clearSelection(); 
    }
     
     public void addToComboEvent(){
         
         List<Event> eList = eventR.findAll();
         ecbm = new EventComboBoxModel(eList);
     }
    
     public void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = tabela.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    EventImages eI = eiModel.getEventImages(selectedIndex);
     
                }
            }
        });
    }
      public void tableLoad() {
        List<EventImages> lista = eiR.findAll();
        eiModel.add(lista);
        tabela.setModel(eiModel); 
        eiModel.fireTableDataChanged();
        tabelaSelectedIndexChange();

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnSelectedPhoto = new javax.swing.JButton();
        cmbEvent = new javax.swing.JComboBox<>();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 161, -1, -1));

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 161, -1, -1));

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 161, -1, -1));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 310, 119));

        btnSelectedPhoto.setText("Select Image");
        getContentPane().add(btnSelectedPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 81, 181, 32));

        cmbEvent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEventActionPerformed(evt);
            }
        });
        getContentPane().add(cmbEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 20, 117, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEventActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEventActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
            int row = tabela.getSelectedRow();
            if (cmbEvent.getSelectedItem() == null )
            {
                JOptionPane.showMessageDialog(this, "Ju lutem mbusheni Description:", "Error", JOptionPane.ERROR_MESSAGE);

            }
            else
            {
                if (row == -1) {
                    EventImages ei = new EventImages();
                    
                    
                    eiR.create(ei);
                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses !");
                } else {
                    EventImages ei = this.eiModel.getEventImages(row);

                    eiR.edit(ei);
                    JOptionPane.showMessageDialog(this, "E dhëna u editua me sukses");
                }
                emptyObject();
                tableLoad();
            };

        } catch (EventImagesException eie) {
            JOptionPane.showMessageDialog(this, eie.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        emptyObject();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            int row = tabela.getSelectedRow();
            if(row > -1){
                Object [] ob = {"Po","Jo"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0){
                    EventImages ei = this.eiModel.getEventImages(row);
                    
                    eiR.remove(ei);
                    tableLoad();
                    emptyObject();
                    JOptionPane.showMessageDialog(this, "E dhëna është fshir me sukses !");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Nuk keni selektuar asgjë për të fshir !");
            }
        }catch(EventImagesException eie){
            JOptionPane.showMessageDialog(this, eie.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelectedPhoto;
    private javax.swing.JComboBox<String> cmbEvent;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
