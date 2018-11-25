/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BL.EventCategory;
import DAL.EventCategoryException;
import Model.EventCategoryTableModel;
import DAL.EventCategoryInterface;
import DAL.EventCategoryRepository;
import com.sun.glass.events.KeyEvent;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author user
 */
public class EventCategoryForm extends javax.swing.JInternalFrame {
    
        EventCategoryInterface eRep = new EventCategoryRepository();
        EventCategoryTableModel eMod = new EventCategoryTableModel();
        
        public EventCategoryForm()
        {
            initComponents();
            tableLoad();
}
        public void emptyObject()
        {
            table.clearSelection();
            txtCategoryName.setText("");
            txtDescription.setText("");
        }
        
        public void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    EventCategory eventCategory = eMod.getEventCategory(selectedIndex);
                    txtCategoryName.setText(eventCategory.getCategoryName());
                    txtDescription.setText((String) eventCategory.getDescription());
                   
                }
            }
        });
    }
        
    public void tableLoad() {
        List<EventCategory> lista = eRep.findAll();
        eMod.add(lista);
        table.setModel(eMod);
        eMod.fireTableDataChanged();
        tabelaSelectedIndexChange();
        lblDescription.setText("");
        lblDescription.setText("");
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCategoryName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblDescription = new javax.swing.JLabel();
        lblCategoryName = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Raavi", 1, 18)); // NOI18N
        jLabel1.setText("Formulari per shtimin e kategorive");

        jLabel2.setFont(new java.awt.Font("Raavi", 0, 14)); // NOI18N
        jLabel2.setText("Emri i Kategorise:");

        jLabel3.setFont(new java.awt.Font("Raavi", 0, 14)); // NOI18N
        jLabel3.setText("Pershkrimi i Kategorise:");

        txtCategoryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoryNameActionPerformed(evt);
            }
        });
        txtCategoryName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCategoryNameKeyPressed(evt);
            }
        });

        txtDescription.setToolTipText("");
        txtDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescriptionKeyPressed(evt);
            }
        });

        btnSave.setText("Ruaj");
        btnSave.setMaximumSize(new java.awt.Dimension(63, 23));
        btnSave.setMinimumSize(new java.awt.Dimension(63, 23));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        btnSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSaveKeyPressed(evt);
            }
        });

        btnRemove.setText("Fshije");
        btnRemove.setMaximumSize(new java.awt.Dimension(63, 23));
        btnRemove.setMinimumSize(new java.awt.Dimension(63, 23));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnClear.setText("Pastro");
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

        lblDescription.setForeground(new java.awt.Color(255, 0, 0));

        lblCategoryName.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(txtCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(lblCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(lblCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnClear)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    
  
  
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            int row = table.getSelectedRow();
            if(txtCategoryName.getText().equals("") || txtDescription.getText().equals("")) {
                
                JOptionPane.showMessageDialog(this, "Ju lutem shkruani emrin e kategorise", "Error", JOptionPane.ERROR_MESSAGE);
                if(txtCategoryName.getText().equals(""))
                    lblCategoryName.setText("Mbusheni kolonen");
                if(txtDescription.getText().equals(""))
                    lblDescription.setText("Mbusheni kolonen");
            }
            else
            {
                lblDescription.setText("");
                lblDescription.setText("");
                if (row == -1) {
                    EventCategory eventCategory = new EventCategory();
                    eventCategory.setCategoryName(txtCategoryName.getText());
                    eventCategory.setDescription(txtDescription.getText());
                    eRep.create(eventCategory);
                    JOptionPane.showMessageDialog(this, "Kategoria u ruajt me sukses");
            
                } else {
                    EventCategory eventCategory = this.eMod.getEventCategory(row);
                    eventCategory.setCategoryName(txtCategoryName.getText());
                    eventCategory.setDescription(txtDescription.getText());
                    
                    eRep.edit(eventCategory);
                    JOptionPane.showMessageDialog(this, "Kategoria u editua me sukses");
                                
                }
                emptyObject();
                tableLoad();
                    
            }
        }   catch (EventCategoryException pe) {
                JOptionPane.showMessageDialog(this, pe.getMessage());
            }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtCategoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoryNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoryNameActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
         try{
            int row = table.getSelectedRow();
            if(row > -1){
                Object [] ob = {"Po","Jo"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0){
                    EventCategory eventCategory = this.eMod.getEventCategory(row);
                    eRep.remove(eventCategory);
                    tableLoad();
                    emptyObject();
                    JOptionPane.showMessageDialog(this, "Kategoria eshte fshire me sukses!");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Nuk keni selektuar asnje kategori per te fshire!");
            }
        }catch(EventCategoryException pe){
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }

    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
       emptyObject();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveKeyPressed
     
    }//GEN-LAST:event_btnSaveKeyPressed

    private void txtCategoryNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoryNameKeyPressed
           int key=evt.getKeyCode();
           char c = evt.getKeyChar();
        if (key>=evt.VK_0 && key<=evt.VK_9 || (key>=evt.VK_NUMPAD0 && key<=evt.VK_NUMPAD9))
        {
            txtCategoryName.setEditable(false);
        }
        else if(isAlphabetic(c) || c == KeyEvent.VK_BACKSPACE || evt.isControlDown() || evt.isShiftDown())
        {
            txtCategoryName.setEditable(true);
            lblCategoryName.setText("");
        }
        else 
        {
            txtCategoryName.setEditable(true);
            lblCategoryName.setText("Nuk lejohen No");
           
        }
    }//GEN-LAST:event_txtCategoryNameKeyPressed

    private void txtDescriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyPressed
           int key=evt.getKeyCode();
           char c = evt.getKeyChar();
        if (key>=evt.VK_0 && key<=evt.VK_9 || (key>=evt.VK_NUMPAD0 && key<=evt.VK_NUMPAD9))
        {
            txtDescription.setEditable(false);
        }
        else if(isAlphabetic(c) || isDigit(c) || c == KeyEvent.VK_BACKSPACE || evt.isControlDown() || evt.isShiftDown())
        {
            txtDescription.setEditable(true);
            lblDescription.setText("");
        }
        else 
        {
            txtDescription.setEditable(true);
            lblDescription.setText("Nuk lejohen simbole");
        }
    }//GEN-LAST:event_txtDescriptionKeyPressed

    
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCategoryName;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCategoryName;
    private javax.swing.JTextField txtDescription;
    // End of variables declaration//GEN-END:variables

    

    
}
