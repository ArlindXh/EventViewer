/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.Event;
import BL.EventUsers;
import BL.Role;

import DAL.EventInterface;
import DAL.EventRepository;
import DAL.EventUserInterface;
import DAL.EventUserRepository;
import DAL.RoleException;
import DAL.RoleInterface;
import DAL.RoleRepository;
import Model.EventComboBoxModel;
import Model.RoleComboBoxModel;
import EVPS.WriteInNote;
import EVPS.WriteInNoteException;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author darda
 */
public class GjeneroEventUser extends javax.swing.JInternalFrame {

    RoleComboBoxModel rlC;
    RoleInterface rI = new RoleRepository();
    EventInterface ei = new EventRepository();
    EventComboBoxModel eC ;
    EventUserInterface euR = new EventUserRepository();
    WriteInNote writeIn;
            
    public GjeneroEventUser() {
        initComponents();
        
        addToEventCombo();
        
    }

    public void emptyObject()
    {
        txtFileName.setText("");
        cmbEvents.setSelectedItem(null);
        checkTeGjitha.setSelected(false);
        checkCaktuara.setSelected(false);
    }
    
    
    public void addToEventCombo()
    {
        List<Event> eList = ei.findAll();
        eC = new EventComboBoxModel(eList);
        cmbEvents.setModel(eC);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGjenero = new javax.swing.JButton();
        cmbEvents = new javax.swing.JComboBox<>();
        checkTeGjitha = new javax.swing.JCheckBox();
        checkCaktuara = new javax.swing.JCheckBox();
        lblEvents = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFileName = new javax.swing.JTextField();
        lblEvent = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        btnGjenero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGjenero.setText("GJENERO");
        btnGjenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGjeneroActionPerformed(evt);
            }
        });

        cmbEvents.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        checkTeGjitha.setText("Te Gjitha eventet");
        checkTeGjitha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTeGjithaActionPerformed(evt);
            }
        });

        checkCaktuara.setText("Evente te caktuara");
        checkCaktuara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCaktuaraActionPerformed(evt);
            }
        });
        checkCaktuara.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                checkCaktuaraKeyPressed(evt);
            }
        });

        lblEvents.setText("Selekto Eventin");

        jLabel3.setText("Emri Listes");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Raport rreth numrit te pjesmarrsve ne event/e");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(lblEvents))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnGjenero))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(checkTeGjitha)
                                .addGap(18, 18, 18)
                                .addComponent(checkCaktuara)))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEvents, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEvents)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkTeGjitha)
                    .addComponent(checkCaktuara)
                    .addComponent(cmbEvents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGjenero))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkCaktuaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCaktuaraActionPerformed
        if(checkCaktuara.isSelected() && !(checkTeGjitha.isSelected()))
        {
            cmbEvents.setVisible(true);
            lblEvents.setVisible(true);
        }
    }//GEN-LAST:event_checkCaktuaraActionPerformed

    private void checkCaktuaraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_checkCaktuaraKeyPressed

    }//GEN-LAST:event_checkCaktuaraKeyPressed

    private void btnGjeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGjeneroActionPerformed
        try
        {
            JFileChooser jc = new JFileChooser();
            jc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int jcr;
            
            
            StringBuilder sb = new StringBuilder();
            
            if(!checkTeGjitha.isSelected() ||  txtFileName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this,"Ju lutem mbushini te gjitha te dhenat." );
                
            }
            
            else if((jcr = jc.showOpenDialog(this)) == JFileChooser.APPROVE_OPTION)
            {
                String path = jc.getSelectedFile().getPath() + "\\" + txtFileName.getText() + ".doc\\";
                Role r = rI.findById(1);
                List<EventUsers> eu = euR.findAllByUserRole(r,(Event)cmbEvents.getSelectedItem());
                
                if(eu.size() >= 0)
                {
                    sb.append("Ne eventin " + (Event)cmbEvents.getSelectedItem() + " moren pjes " + eu.size() + " participant  " + System.lineSeparator()
                                                                                                                                 + System.lineSeparator());
                    for(EventUsers ek : eu)
                    {
                        sb.append(ek.getUsersID() + System.lineSeparator());
                    }
                }
                else
                    sb.append("Nuk kishte asnje pjesmarres ne eventin " + (Event)cmbEvents.getSelectedItem() + System.lineSeparator());

                writeIn = new WriteInNote(sb.toString(),path);
                writeIn.write();
                JOptionPane.showInternalMessageDialog(this,"Te dhenat u gjeneruan me sukses");
                emptyObject();
            
            }
            
            
        }catch(WriteInNoteException | IOException | RoleException  ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Exception",JOptionPane.ERROR_MESSAGE);
        }
            


    }//GEN-LAST:event_btnGjeneroActionPerformed

    private void checkTeGjithaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTeGjithaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkTeGjithaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGjenero;
    private javax.swing.JCheckBox checkCaktuara;
    private javax.swing.JCheckBox checkTeGjitha;
    private javax.swing.JComboBox<Event> cmbEvents;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblEvent;
    private javax.swing.JLabel lblEvents;
    private javax.swing.JTextField txtFileName;
    // End of variables declaration//GEN-END:variables
}
