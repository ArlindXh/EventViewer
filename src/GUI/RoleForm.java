/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import BL.City;
import BL.Role;
import DAL.RoleException;
import DAL.RoleInterface;
import DAL.RoleRepository;
import Model.RoleTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author darda
 */
public class RoleForm extends javax.swing.JInternalFrame {

    RoleInterface rR = new RoleRepository();
    RoleTableModel rM = new RoleTableModel();
    public RoleForm() {
        initComponents();
        tableLoad();
    }

    public void emptyObject()
    {
        table.clearSelection();
        txtRoleType.setText("");
        lblRoleType.setText("");
    }
    
    private void tableSelectedIndexChange() {
        final ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Role r = rM.getRole(selectedIndex);
                    txtRoleType.setText(r.getType());
                    
                }
            }
        });
    }
    
    public void tableLoad()
    {
        List<Role> rList = rR.findAll();
        rM.add(rList);
        table.setModel(rM);
        rM.fireTableDataChanged();
        tableSelectedIndexChange();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtRoleType = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblRoleType = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Role Type");

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel1))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRoleType, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRoleType, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnRemove)
                .addGap(28, 28, 28)
                .addComponent(btnClear))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRoleType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRoleType, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove)
                    .addComponent(btnSave)
                    .addComponent(btnClear))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try
        {
            int row = table.getSelectedRow();
            if(txtRoleType.getText().equals(""))
            {
                if(txtRoleType.getText().equals(""))
                    lblRoleType.setText("Shkruani nje qytet");     
            }
            else
            {
                lblRoleType.setText("Shkruani nje qytet");
                if(row == -1)
                {
                    Role role = new Role();
                    role.setType(txtRoleType.getText());
                    
                    rR.create(role);

                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses !");
                }
                else
                {
                    Role role = this.rM.getRole(row);
                    role.setType(txtRoleType.getText());
                    
                    rR.edit(role);

                    JOptionPane.showMessageDialog(this, "E dhëna u editua me sukses !");
                }
                emptyObject();
                tableLoad();
            }
        }catch(RoleException pe)
        {
            JOptionPane.showMessageDialog(this,pe.getMessage());
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try{
            int row = table.getSelectedRow();
            if(row > -1){
                Object [] ob = {"Po","Jo"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0){
                    Role role = this.rM.getRole(row);
                    rR.remove(role);
                    tableLoad();
                    emptyObject();
                    JOptionPane.showMessageDialog(this, "E dhëna është fshir me sukses !");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Nuk keni selektuar asgjë për të fshir !");
            }
        }catch(RoleException pe){
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        emptyObject();
    }//GEN-LAST:event_btnClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblRoleType;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtRoleType;
    // End of variables declaration//GEN-END:variables
}
