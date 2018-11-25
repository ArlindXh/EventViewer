/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.EventCategory;
import BL.SubCategory;
import DAL.EventCategoryException;
import DAL.EventCategoryRepository;
import DAL.SubCategoryException;
import DAL.SubCategoryRepository;
import Model.CategoryComboBoxModel;
import Model.SubCategoryTableModel;
import com.sun.glass.events.KeyEvent;
import static java.lang.Character.isAlphabetic;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author darda
 */
public class SubCategoryForm extends javax.swing.JInternalFrame {

    
    SubCategoryRepository subR = new SubCategoryRepository();
    EventCategoryRepository eventR = new EventCategoryRepository();
    SubCategoryTableModel sM = new SubCategoryTableModel();
    CategoryComboBoxModel categoryCM;
    
    public SubCategoryForm() {
        initComponents();
        tableLoad();
        addToCombo();
    }

    public void emptyObject()
    {
        table.clearSelection();
        txtSubCategory.setText("");
        comboCategory.setSelectedItem("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSubCategory = new javax.swing.JTextField();
        comboCategory = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblCategory = new javax.swing.JLabel();
        lblSubCategory = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Edit SubCategory");

        txtSubCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubCategoryActionPerformed(evt);
            }
        });
        txtSubCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSubCategoryKeyPressed(evt);
            }
        });

        comboCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoryActionPerformed(evt);
            }
        });

        jLabel1.setText("Sub category Name");

        jLabel2.setText("Category");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnEdit.setText("Clear");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
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
        jScrollPane1.setViewportView(table);

        lblCategory.setForeground(new java.awt.Color(255, 0, 0));

        lblSubCategory.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(60, 60, 60)
                        .addComponent(btnRemove))
                    .addComponent(txtSubCategory, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSubCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEdit)
                    .addComponent(jLabel2)
                    .addComponent(comboCategory, 0, 176, Short.MAX_VALUE)
                    .addComponent(lblCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnRemove)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void tableLoad() {
        List<SubCategory> lista = subR.findAll();
        sM.add(lista);
        table.setModel(sM);
        sM.fireTableDataChanged();
        tabelaSelectedIndexChange();

    }
    
    public void addToCombo()
    {
        List<EventCategory> cList = eventR.findAll();
        categoryCM = new CategoryComboBoxModel(cList);
        comboCategory.setModel(categoryCM);
    }
    
    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    
                    SubCategory admin = sM.getSubCategory(selectedIndex);
                    txtSubCategory.setText(admin.getSubCategryName());
                    comboCategory.setSelectedItem(admin.getEventCategoryID());
                    
                
                   
                }
            }
        });
    }
    private void txtSubCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubCategoryActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try
        {
            
            int row = table.getSelectedRow();
            if(txtSubCategory.getText().equals("") || comboCategory.getSelectedItem().equals(null) )
            {
                JOptionPane.showMessageDialog(this, "Ju lutem mbushini te gjitha kolonat :", "Error", JOptionPane.ERROR_MESSAGE);
                if(txtSubCategory.getText().equals(""))
                    lblSubCategory.setText("Shkruani sub kategorin");
                if(comboCategory.getSelectedItem().equals(null))
                    lblCategory.setText("Selektoni kategorin");
                    
            }
            else
            {   
                lblSubCategory.setText("");
                lblCategory.setText("");
                if (row == -1)
                {
                    SubCategory admin = new SubCategory();
                    EventCategory c = (EventCategory)comboCategory.getSelectedItem();
                    admin.setSubCategryName(txtSubCategory.getText());
                    admin.setEventCategoryID(c);
                    
                    
                    subR.create(admin);
                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses !");
                } 
                else
                {
                    SubCategory admin = new SubCategory();
                    EventCategory c = (EventCategory)comboCategory.getSelectedItem();
                    admin.setSubCategryName(txtSubCategory.getText());
                    admin.setEventCategoryID(c);
                    
                    
                    subR.edit(admin);
                    JOptionPane.showMessageDialog(this, "E dhëna u editua me sukses");
                    
                }
                emptyObject();
                tableLoad();
            };

        }catch (SubCategoryException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void comboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCategoryActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try
        {
            int row = table.getSelectedRow();
            if(row > -1)
            {
                Object [] ob = {"Po","Jo"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0)
                {
                    SubCategory studenti = this.sM.getSubCategory(row);
                    subR.remove(studenti);
                    tableLoad();
                    emptyObject();
                    JOptionPane.showMessageDialog(this, "E dhëna është fshir me sukses !");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Nuk keni selektuar asgjë për të fshir !");
            }
        }catch(SubCategoryException pe)
        {
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }
           
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        emptyObject();
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtSubCategoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubCategoryKeyPressed
        char c = evt.getKeyChar();
        
        if(isAlphabetic(c) || c == KeyEvent.VK_BACKSPACE || evt.isControlDown() || evt.isShiftDown() || c == KeyEvent.VK_SPACE )    
        {
            txtSubCategory.setEditable(true);
            lblSubCategory.setText("");
        }
        else
        {
            txtSubCategory.setEditable(false);
            lblSubCategory.setText("Shkruni sub Kategorin");
        }
    }//GEN-LAST:event_txtSubCategoryKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<EventCategory> comboCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblSubCategory;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtSubCategory;
    // End of variables declaration//GEN-END:variables
}
