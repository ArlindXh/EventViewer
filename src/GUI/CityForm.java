/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.City;
import BL.Country;
import DAL.CityException;
import DAL.CityInterface;
import DAL.CityRepository;
import DAL.CountryException;
import DAL.CountryInterface;
import DAL.CountryRepository;
import Model.CityTableModel;
import Model.CountryComboBoxModel;
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
public class CityForm extends javax.swing.JInternalFrame {

    
    CityInterface cR = new CityRepository();
    CityTableModel lM = new CityTableModel();
    CountryInterface countryR = new CountryRepository();
    CountryComboBoxModel cmbM;
    
    public CityForm() {
        initComponents();
        tableLoad();
        countryCombo();
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
                    City city = lM.getCity(selectedIndex);
                    Country country = city.getCountryID();  
                    txtCityName.setText(city.getCityName());
                    txtZipCode.setText(city.getZipCode());
                    cmbCountry.setSelectedItem(country);
                    cmbCountry.repaint();
                }
            }
        });
    }
    
    public void emptyObjects()
    {
        table.clearSelection();
        txtCityName.setText("");
        txtZipCode.setText("");
        cmbCountry.setSelectedItem(null);
        lblCountryCombo.setText(""); 
        lblZipCode.setText("");
        lblCityName.setText("");
        
    }
    
    public void tableLoad()
    {
        List<City> lista = cR.findAll();
        lM.add(lista);
        table.setModel(lM);
        lM.fireTableDataChanged();
        tableSelectedIndexChange();
    }
    public void countryCombo()
    {
        List<Country> cList = countryR.findAllOrdered();
        cmbM = new CountryComboBoxModel(cList);
        this.cmbCountry.setModel(cmbM);
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCityName = new javax.swing.JTextField();
        txtZipCode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbCountry = new javax.swing.JComboBox<>();
        lblCityName = new javax.swing.JLabel();
        lblZipCode = new javax.swing.JLabel();
        lblCountryCombo = new javax.swing.JLabel();

        jTextField3.setText("jTextField3");

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("CityName:");

        jLabel2.setText("ZipCode");

        txtCityName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityNameActionPerformed(evt);
            }
        });
        txtCityName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCityNameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCityNameKeyTyped(evt);
            }
        });

        txtZipCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtZipCodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtZipCodeKeyTyped(evt);
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

        jLabel3.setText("Country");

        cmbCountry.setMinimumSize(new java.awt.Dimension(6, 20));
        cmbCountry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbCountryFocusLost(evt);
            }
        });
        cmbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCountryActionPerformed(evt);
            }
        });
        cmbCountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbCountryKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmbCountryKeyTyped(evt);
            }
        });

        lblCityName.setForeground(new java.awt.Color(188, 19, 19));

        lblZipCode.setForeground(new java.awt.Color(188, 19, 19));

        lblCountryCombo.setForeground(new java.awt.Color(188, 19, 19));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmbCountry, 0, 311, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSave)
                            .addGap(34, 34, 34)
                            .addComponent(btnRemove)
                            .addGap(59, 59, 59)
                            .addComponent(btnClear))
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(lblCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCountryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtCityName, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                        .addComponent(txtZipCode)))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lblZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCountryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove)
                    .addComponent(btnSave)
                    .addComponent(btnClear))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        emptyObjects();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try{
            int row = table.getSelectedRow();
            if(row > -1){
                Object [] ob = {"Po","Jo"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0){
                    City city = this.lM.getCity(row);
                    cR.remove(city);
                    tableLoad();
                    emptyObjects();
                    JOptionPane.showMessageDialog(this, "E dhëna është fshir me sukses !");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Nuk keni selektuar asgjë për të fshir !");
            }
        }catch(CityException pe){
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try
        {
            int row = table.getSelectedRow();
            if(txtCityName.getText().equals("") || txtZipCode.getText().equals("") ||  cmbCountry.getSelectedItem().equals(""))
            {
                if(txtCityName.getText().equals(""))
                    lblCityName.setText("Shkruani nje qytet");
                if(txtZipCode.getText().equals(""))
                    lblZipCode.setText("Shkruani zip kodin");
                if(cmbCountry.getSelectedItem() ==  null)
                    lblCountryCombo.setText("Selektoni nje shtet");     
            }
            else
            {
                lblCountryCombo.setText(""); 
                lblZipCode.setText("");
                lblCityName.setText("");
                if(row == -1)
                {
                    City city = new City();
                    Country country = countryR.findByCountryName(cmbCountry.getSelectedItem()+"");
                    city.setCityName(txtCityName.getText());
                    city.setZipCode(txtZipCode.getText());
                    city.setCountryID(country);
                    cR.create(city);

                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses !");
                }
                else
                {
                    City city = this.lM.getCity(row);
                    city.setCityName(txtCityName.getText());
                    city.setZipCode(txtZipCode.getText());

                    cR.edit(city);

                    JOptionPane.showMessageDialog(this, "E dhëna u editua me sukses !");
                }
                emptyObjects();
                tableLoad();
            }
        }catch(CityException | CountryException pe)
        {
            JOptionPane.showMessageDialog(this,pe.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtZipCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtZipCodeKeyPressed
        char c = evt.getKeyChar();
        if(isDigit(c) || c == KeyEvent.VK_BACKSPACE)
        {
            lblZipCode.setText("");
            txtZipCode.setEditable(true);
        }
        else
        {
            lblZipCode.setText("Nuk lejohen shkronja ose hapsira");
            txtZipCode.setEditable(false);
        }
    }//GEN-LAST:event_txtZipCodeKeyPressed

    private void txtCityNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCityNameKeyPressed
        char c = evt.getKeyChar();
        if( isAlphabetic(c) || c == KeyEvent.VK_BACKSPACE || evt.isControlDown() || evt.isShiftDown() || c == KeyEvent.VK_SPACE)
        {
            
            lblCityName.setText("");
            txtCityName.setEditable(true);
        }
        else
        {
            lblCityName.setText("Nuk lejohen numra");
            txtCityName.setEditable(false);
        }
            

        
        
    }//GEN-LAST:event_txtCityNameKeyPressed

    private void cmbCountryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbCountryKeyPressed
        
    }//GEN-LAST:event_cmbCountryKeyPressed

    private void cmbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCountryActionPerformed

    private void txtCityNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCityNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityNameActionPerformed

    private void txtCityNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCityNameKeyTyped
        int t = txtCityName.getText().length();
        if(t > 49)
        {
            evt.consume();
            lblCityName.setText("teksti > 50 karaktere");
        }
    }//GEN-LAST:event_txtCityNameKeyTyped

    private void cmbCountryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbCountryKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCountryKeyTyped

    private void cmbCountryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbCountryFocusLost
        if(cmbCountry.getSelectedItem() == null)
            lblCountryCombo.setText("Selekto nje shtet");
    }//GEN-LAST:event_cmbCountryFocusLost

    private void txtZipCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtZipCodeKeyTyped
        int t = txtZipCode.getText().length();
        if(t > 49)
        {
            evt.consume();
            lblZipCode.setText("teksti > 50 karaktere");
        }
    }//GEN-LAST:event_txtZipCodeKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Country> cmbCountry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblCityName;
    private javax.swing.JLabel lblCountryCombo;
    private javax.swing.JLabel lblZipCode;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCityName;
    private javax.swing.JTextField txtZipCode;
    // End of variables declaration//GEN-END:variables
}
