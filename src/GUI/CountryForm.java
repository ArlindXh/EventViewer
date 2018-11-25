/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.Country;
import DAL.CountryException;
import Model.CountryTableModel;
import DAL.CountryInterface;
import DAL.CountryRepository;
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
 * @author darda
 */
public class CountryForm extends javax.swing.JInternalFrame {

    CountryInterface cRep = new CountryRepository();
    CountryTableModel cMod = new CountryTableModel();
    public CountryForm() {
        initComponents();
        tableLoad();
    }
    
    
    public void emptyObject()
    {
        table.clearSelection();
        txtCountryName.setText("");
        lblCountryCode.setText("");
        lblCountryName.setText("");
        txtCountryCode.setText("");
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
                    Country country = cMod.getCountry(selectedIndex);
                    txtCountryName.setText(country.getCountryName());
                    txtCountryCode.setText(country.getCountryCode());
                   
                }
            }
        });
    }
    
    public void tableLoad() {
        List<Country> lista = cRep.findAll();
        cMod.add(lista);
        table.setModel(cMod);
        cMod.fireTableDataChanged();
        tabelaSelectedIndexChange();

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtCountryName = new javax.swing.JTextField();
        txtCountryCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblCountryName = new javax.swing.JLabel();
        lblCountryCode = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 168, -1, 186));

        txtCountryName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCountryNameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCountryNameKeyTyped(evt);
            }
        });
        getContentPane().add(txtCountryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 35, 157, -1));

        txtCountryCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCountryCodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCountryCodeKeyTyped(evt);
            }
        });
        getContentPane().add(txtCountryCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 35, 148, -1));

        jLabel1.setText("Country Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 11, -1, -1));

        jLabel2.setText("Country Code");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 15, -1, -1));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 127, -1, -1));

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 127, -1, -1));

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 127, -1, -1));

        lblCountryName.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lblCountryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 150, 10));

        lblCountryCode.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lblCountryCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 130, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try{
            int row = table.getSelectedRow();
            if(row > -1){
                Object [] ob = {"Po","Jo"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0){
                    Country country = this.cMod.getCountry(row);
                    
                    cRep.remove(country);
                    tableLoad();
                    emptyObject();
                    JOptionPane.showMessageDialog(this, "E dhëna është fshir me sukses !");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Nuk keni selektuar asgjë për të fshir !");
            }
        }catch(CountryException pe){
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        emptyObject();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        try {
            int row = table.getSelectedRow();
            if (txtCountryName.getText().equals("") || txtCountryCode.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Ju lutem mbushini te gjitha kolonat :", "Error", JOptionPane.ERROR_MESSAGE);
                if(txtCountryName.getText().equals(""))
                    lblCountryName.setText("Shkruani kodin e SHTETIN");
                if(txtCountryCode.getText().equals(""))
                    lblCountryCode.setText("Shkruani kodin e SHTETIT");
                    
            }
            else
            {
                lblCountryCode.setText("");
                lblCountryName.setText("");
                if (row == -1)
                {
                    Country country = new Country();
                    country.setCountryName(txtCountryName.getText());
                    country.setCountryCode(txtCountryCode.getText());
                    cRep.create(country);
                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses !");
                } 
                else 
                {
                    Country country = this.cMod.getCountry(row);
                    country.setCountryName(txtCountryName.getText());
                    country.setCountryCode(txtCountryCode.getText());

                    cRep.edit(country);
                    JOptionPane.showMessageDialog(this, "E dhëna u editua me sukses");
                }
                emptyObject();
                tableLoad();
            };

        } catch (CountryException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtCountryNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCountryNameKeyPressed
        char c = evt.getKeyChar();
        
        if(isAlphabetic(c) || c == KeyEvent.VK_BACKSPACE || evt.isControlDown() || evt.isShiftDown() || c == KeyEvent.VK_SPACE )    
        {
            txtCountryName.setEditable(true);
            lblCountryName.setText("");
        }
        else
        {
            txtCountryName.setEditable(false);
            lblCountryName.setText("Shkruani nje SHTET");
        }
    }//GEN-LAST:event_txtCountryNameKeyPressed

    private void txtCountryCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCountryCodeKeyPressed
        char c = evt.getKeyChar();
        if(isDigit(c) || c == KeyEvent.VK_BACKSPACE || evt.isControlDown() || evt.isShiftDown())
        {
            txtCountryCode.setEditable(true);
            lblCountryCode.setText("");
        }
        else
        {
            txtCountryCode.setEditable(false);
            lblCountryCode.setText("Shkruani kodin e SHTETIT");
        }
    }//GEN-LAST:event_txtCountryCodeKeyPressed

    private void txtCountryNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCountryNameKeyTyped
        int t = txtCountryName.getText().length();
        if(t>49)
        {
            evt.consume();
            lblCountryName.setText("Me > se 50 chars");
        }
    }//GEN-LAST:event_txtCountryNameKeyTyped

    private void txtCountryCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCountryCodeKeyTyped
        
        int t = txtCountryCode.getText().length();
        if(t>49)
        {
            evt.consume();
            lblCountryCode.setText("Me > se 50 chars");
        }
    }//GEN-LAST:event_txtCountryCodeKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCountryCode;
    private javax.swing.JLabel lblCountryName;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCountryCode;
    private javax.swing.JTextField txtCountryName;
    // End of variables declaration//GEN-END:variables
}
