/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.EventEntryType;
import BL.EventPayment;
import DAL.EventEntryTypeException;
import DAL.EventEntryTypeInterface;
import DAL.EventEntryTypeRepository;
import DAL.EventPaymentException;
import DAL.EventPaymentInterface;
import DAL.EventPaymentRepository;
import Model.EventEntryTypeTableModel;
import Model.PaymentComboBoxModel;
import com.sun.glass.events.KeyEvent;
import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author darda
 */
public class EventType extends javax.swing.JInternalFrame {

    
    
    EventEntryTypeTableModel tModel = new EventEntryTypeTableModel();
    EventEntryTypeInterface eTR = new EventEntryTypeRepository();
    EventPaymentInterface ePR = new EventPaymentRepository();
 
    
    
    public EventType() 
    {
        initComponents();
        tableLoad();
        
    }

    public void emptyObject()
    {
        table.clearSelection();
        txtTypeName.setText("");
        txtPrice.setText("");
        txtDescription.setText("");
        cmbPayment.setSelectedItem(null);
        lblDescription.setText("");
        lblPayment.setText(""); 
        lblPrice.setText("");
        lblTypeName.setText("");
    }
    
    private void tableSelectedIndexChange()
    {
        final ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    EventEntryType e = tModel.getEventEntryType(selectedIndex);
                    EventPayment ep = e.getEventPaymentID();
                    
                    txtTypeName.setText(e.getEventTypeName());
                    txtPrice.setText(ep.getPrice()+"");
                    txtDescription.setText(e.getDescription());
                    cmbPayment.setSelectedItem(ep.getPaymentType());
                    cmbPayment.repaint();
                }
            }
        });
    }
   
    
    public void tableLoad()
    {
        List<EventEntryType> eList = eTR.findAll();
        tModel.add(eList);
        table.setModel(tModel);
        tModel.fireTableDataChanged();
        tableSelectedIndexChange();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtTypeName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        cmbPayment = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lblTypeName = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblPayment = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

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

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        txtTypeName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTypeNameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTypeNameKeyTyped(evt);
            }
        });

        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPriceKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
        });

        jLabel1.setText("Event Type Name");

        jLabel2.setText("Description");

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtDescription.setRows(5);
        txtDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescriptionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescriptionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescription);

        jLabel3.setText("Price");

        cmbPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Credit Card", "Cash" }));

        jLabel4.setText("Payment");

        lblTypeName.setForeground(new java.awt.Color(255, 0, 0));

        lblPrice.setForeground(new java.awt.Color(255, 0, 0));

        lblPayment.setForeground(new java.awt.Color(255, 0, 0));

        lblDescription.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane2)
                    .addComponent(lblDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel1)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel3)
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbPayment, javax.swing.GroupLayout.Alignment.TRAILING, 0, 137, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(lblPayment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(btnRemove)
                    .addComponent(btnClear))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try
        {
            int row = table.getSelectedRow();
            if(txtTypeName.getText().equals("") || txtPrice.getText().equals("") ||  cmbPayment.getSelectedItem() == null || cmbPayment.getSelectedItem().equals(" ") || txtDescription.getText().equals(""))
            {
                if(txtTypeName.getText().equals(""))
                   lblTypeName.setText("Shkruani Emrin!");
                if(txtPrice.getText().equals(""))
                   lblPrice.setText("Shkruani cmimin!");
                if(cmbPayment.getSelectedItem() ==  null || cmbPayment.getSelectedItem().equals(" "))
                   lblPayment.setText("Selektoni njeren!");
                if(txtDescription.getText().equals(""))
                   lblDescription.setText("Shkruani diqka!");
            }
            else
            {
                lblDescription.setText("");
                lblPayment.setText(""); 
                lblPrice.setText("");
                lblTypeName.setText("");
                
                if(row == -1)
                {
                    EventEntryType eType = new EventEntryType();
                    EventPayment ePayment = new EventPayment();
                    
                    eType.setEventTypeName(txtTypeName.getText());
                    eType.setDescription(txtDescription.getText());
                    ePayment.setPaymentType(cmbPayment.getSelectedItem()+"");
                    ePayment.setPrice(BigDecimal.valueOf(Double.parseDouble(txtPrice.getText())));
                    
                    ePR.create(ePayment);
                    eType.setEventPaymentID(ePayment);
                    eTR.create(eType);
                    
                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses !");
                }
                else
                {
                    EventEntryType eType = this.tModel.getEventEntryType(row);
                    EventPayment ePayment = eType.getEventPaymentID();
                    
                    eType.setEventTypeName(txtTypeName.getText());
                    eType.setDescription(txtDescription.getText());
                    ePayment.setPaymentType(cmbPayment.getSelectedItem()+"");
                    ePayment.setPrice(BigDecimal.valueOf(Double.parseDouble(txtPrice.getText())));
                    
                    ePR.edit(ePayment);
                    eTR.edit(eType);
                    
                    JOptionPane.showMessageDialog(this, "E dhëna u editua me sukses !");
                }
                emptyObject();
                tableLoad();
            }
        }catch(EventEntryTypeException | EventPaymentException pe)
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
                    EventEntryType eType = this.tModel.getEventEntryType(row);
                    //EventPayment ePayment = eType.getEventPaymentID();
                   
                    
                    eTR.remove(eType);
                   // ePR.remove(ePayment);
                    tableLoad();
                    emptyObject();
                    JOptionPane.showMessageDialog(this, "E dhëna është fshir me sukses !");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Nuk keni selektuar asgjë për të fshir !");
            }
        }catch(EventEntryTypeException pe){
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        emptyObject();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtTypeNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTypeNameKeyPressed
        char c = evt.getKeyChar();
        if( isAlphabetic(c) || c == KeyEvent.VK_BACKSPACE || evt.isControlDown() || evt.isShiftDown() || c == KeyEvent.VK_SPACE)
        {
            
            lblTypeName.setText("");
            txtTypeName.setEditable(true);
        }
        else
        {
            lblTypeName.setText("Nuk lejohen numra");
            txtTypeName.setEditable(false);
        }
        
    }//GEN-LAST:event_txtTypeNameKeyPressed

    private void txtTypeNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTypeNameKeyTyped
        int t = txtTypeName.getText().length();
        if(t > 49)
        {
            evt.consume();
            lblTypeName.setText("maks 49 karaktere");
        }
    }//GEN-LAST:event_txtTypeNameKeyTyped

    private void txtPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyPressed
        char c = evt.getKeyChar();
        if( isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == '.')
        {
            
            lblPrice.setText("");
            txtPrice.setEditable(true);
        }
        else
        {
            lblPrice.setText("Vetem numra");
            txtPrice.setEditable(false); 
        }
    }//GEN-LAST:event_txtPriceKeyPressed

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        int t = txtPrice.getText().length();
        if(t > 6)
        {
            evt.consume();
            lblPrice.setText("maks 5 nr");
        }
    }//GEN-LAST:event_txtPriceKeyTyped
    int count = 0;
    private void txtDescriptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyTyped

    }//GEN-LAST:event_txtDescriptionKeyTyped

    private void txtDescriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyPressed
        int t = txtDescription.getText().length();
        if(!(evt.getKeyChar() == KeyEvent.VK_BACKSPACE) && !(evt.getKeyChar() == KeyEvent.VK_ENTER))
        {
            if(t == 50)
                txtDescription.setText(txtDescription.getText()+"\n");
        }
    }//GEN-LAST:event_txtDescriptionKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbPayment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblPayment;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblTypeName;
    private javax.swing.JTable table;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTypeName;
    // End of variables declaration//GEN-END:variables
}
