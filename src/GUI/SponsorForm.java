
package GUI;

import BL.Sponsor;
import BL.ContactSponsor;
import DAL.ContactSponsorException;
import DAL.ContactSponsorInterface;
import DAL.ContactSponsorRepository;
import DAL.SponsorException;
import DAL.SponsorInterface;
import DAL.SponsorRepository;
import Model.SponsorTableModel;
import com.sun.glass.events.KeyEvent;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Color;
import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class SponsorForm extends javax.swing.JInternalFrame {

        SponsorRepository sR = new SponsorRepository();
        ContactSponsorRepository cR = new ContactSponsorRepository();
        SponsorTableModel sMod = new SponsorTableModel();
        ContactSponsorInterface cRep = new ContactSponsorRepository();
        SponsorInterface sRep = new SponsorRepository();
        
        
        
    
    public SponsorForm() {
        initComponents();
        tableLoad();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSponsorName = new javax.swing.JTextField();
        txtCompanyName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPhone2 = new javax.swing.JTextField();
        txtPhone1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmail1 = new javax.swing.JTextField();
        txtEmail2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Raavi", 1, 18)); // NOI18N
        jLabel1.setText("Formulari per regjistrimin e sponzoreve");

        jLabel2.setFont(new java.awt.Font("Raavi", 0, 14)); // NOI18N
        jLabel2.setText("Emri i Sponzorit:");

        jLabel3.setFont(new java.awt.Font("Raavi", 0, 14)); // NOI18N
        jLabel3.setText("Kompania e Sponzorit:");

        txtSponsorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSponsorNameActionPerformed(evt);
            }
        });
        txtSponsorName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSponsorNameKeyPressed(evt);
            }
        });

        txtCompanyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompanyNameActionPerformed(evt);
            }
        });
        txtCompanyName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCompanyNameKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Raavi", 0, 14)); // NOI18N
        jLabel4.setText("Telefoni1:");

        jLabel5.setFont(new java.awt.Font("Raavi", 0, 14)); // NOI18N
        jLabel5.setText("Telefoni2:");

        jLabel6.setFont(new java.awt.Font("Raavi", 0, 14)); // NOI18N
        jLabel6.setText("Email1:");

        jLabel7.setFont(new java.awt.Font("Raavi", 0, 14)); // NOI18N
        jLabel7.setText("Email2:");

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

        btnSave.setText("Ruaj");
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
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        btnRemove.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnRemoveKeyPressed(evt);
            }
        });

        btnClear.setText("Pastro");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSponsorName)
                            .addComponent(txtPhone1)
                            .addComponent(txtEmail1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCompanyName)
                            .addComponent(txtPhone2)
                            .addComponent(txtEmail2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(204, 204, 204))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSponsorName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCompanyName, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhone1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove)
                    .addComponent(btnClear)
                    .addComponent(btnSave))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void emptyObject()
    {
        table.clearSelection();
        txtSponsorName.setText("");
        txtCompanyName.setText("");
        txtPhone1.setText("");
        txtPhone2.setText("");
        txtEmail1.setText("");
        txtEmail2.setText("");
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
                    Sponsor  sponzori = sMod.getSponsor(selectedIndex);
                    ContactSponsor cS = cR.findBySponsorID(sponzori);
                    txtSponsorName.setText(sponzori.getSponsorName());
                    txtCompanyName.setText(sponzori.getSponsorCompany());
                    txtPhone1.setText(cS.getPhone1());
                    txtPhone2.setText(cS.getPhone2());
                    txtEmail1.setText(cS.getEMail1());
                    txtEmail2.setText(cS.getEMail2());
                    
                }
               
            }

            
        });
    }
         
         public void emptyObjects()
         {
             table.clearSelection();
             txtSponsorName.setText("");
             txtCompanyName.setText("");
             txtPhone1.setText("");
             txtPhone2.setText("");
             txtEmail1.setText("");
             txtEmail2.setText("");
         }
        
    public void tableLoad() {
        List<Sponsor> lista = sRep.findAll();
        sMod.add(lista);
        table.setModel(sMod);
        sMod.fireTableDataChanged();
        tabelaSelectedIndexChange();
        
    }
    
    
    
    private void txtSponsorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSponsorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSponsorNameActionPerformed

    private void txtCompanyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompanyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompanyNameActionPerformed

    private void txtSponsorNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSponsorNameKeyPressed
       char c = evt.getKeyChar();
        if(isAlphabetic(c) || c == KeyEvent.VK_BACKSPACE || isDigit(c) 
                || evt.isShiftDown() )
        {
        
            txtSponsorName.setEditable(true);
            txtSponsorName.setBackground(Color.WHITE);
        }
        else 
        {
        
            txtSponsorName.setEditable(false);
            txtSponsorName.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtSponsorNameKeyPressed

    private void txtCompanyNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompanyNameKeyPressed
       char c = evt.getKeyChar();
        if(isAlphabetic(c) || c == KeyEvent.VK_BACKSPACE || isDigit(c) 
                || evt.isShiftDown() )
        {
        
            txtCompanyName.setEditable(true);
            txtCompanyName.setBackground(Color.WHITE);
        }
        else 
        {
        
            txtCompanyName.setEditable(false);
            txtCompanyName.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtCompanyNameKeyPressed

    private void btnSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveKeyPressed
       
    }//GEN-LAST:event_btnSaveKeyPressed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            int row = table.getSelectedRow();
            if(txtSponsorName.getText().equals("") | txtCompanyName.getText().equals("") | txtEmail1.getText().equals("") | txtPhone1.getText().equals("")) {
           // if (txtSponsorName.getText().equals("")) 
              //  lblSponsor.setText("Shkruani emrin e sponzorit");
              JOptionPane.showMessageDialog(this,"Ju lutem mbushni te gjitha kolonat e nevojshme : ", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
            {
                if (row == -1) {
                    Sponsor sponzori = new Sponsor();
                    ContactSponsor cS = new ContactSponsor();
                    sponzori.setSponsorName(txtSponsorName.getText());
                    sponzori.setSponsorCompany(txtCompanyName.getText());
                    cS.setEMail1(txtEmail1.getText());
                    cS.setEMail2(txtEmail2.getText());
                    cS.setPhone1(txtPhone1.getText());
                    cS.setPhone2(txtPhone2.getText());
                    sRep.create(sponzori);
                    cS.setSponsorID(sponzori);
                    cRep.create(cS);
                    
                    
                    JOptionPane.showMessageDialog(this, "Te dhenat per sponzor u shtuan me sukses");
                    
                    
                } else 
                {
                    Sponsor sponzori = this.sMod.getSponsor(row);
                    ContactSponsor cS = cRep.findBySponsorID(sponzori);
                   // ContactSponsor cS = new ContactSponsor();
                    sponzori.setSponsorName(txtSponsorName.getText());
                    sponzori.setSponsorCompany(txtCompanyName.getText());
                    cS.setEMail1(txtEmail1.getText());
                    cS.setEMail2(txtEmail2.getText());
                    cS.setPhone1(txtPhone1.getText());
                    cS.setPhone2(txtPhone2.getText());
                    sRep.edit(sponzori);
                    cS.setSponsorID(sponzori);
                    cRep.edit(cS);
                    
                    JOptionPane.showMessageDialog(this, "Te dhenat per sponzorin u edituan me sukses");

                }
                emptyObject();
                tableLoad();  
                }
            } catch(SponsorException| ContactSponsorException pe)
            {
        JOptionPane.showMessageDialog(this, pe.getMessage());
            }
            
    }//GEN-LAST:event_btnSaveActionPerformed

    
    private void btnRemoveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRemoveKeyPressed
        
    }//GEN-LAST:event_btnRemoveKeyPressed

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
                    Sponsor sponzori = this.sMod.getSponsor(row);
                    ContactSponsor cs = cR.findBySponsorID(sponzori);
                    
                    cR.remove(cs);
                    sRep.remove(sponzori);
                    tableLoad();
                    emptyObject();
                    JOptionPane.showMessageDialog(this, "Te dhenat per kete sponzor u fshine!");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Nuk keni selektuar asnje te dhene per te fshire!");
            }
        }catch(SponsorException | ContactSponsorException pe){
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }
    }//GEN-LAST:event_btnRemoveActionPerformed
    
    

    
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtEmail2;
    private javax.swing.JTextField txtPhone1;
    private javax.swing.JTextField txtPhone2;
    private javax.swing.JTextField txtSponsorName;
    // End of variables declaration//GEN-END:variables
 }
