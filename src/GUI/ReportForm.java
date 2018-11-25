/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.Event;
import BL.Report;
import DAL.EventRepository;
import DAL.ReportException;
import Model.ReportTableForm;
import DAL.ReportInterface;
import DAL.ReportRepository;
import Model.EventComboBoxModel;
import com.sun.glass.events.KeyEvent;
import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class ReportForm extends javax.swing.JInternalFrame {

    
    EventRepository eventR = new EventRepository();
    ReportRepository rpRep = new ReportRepository();
    ReportTableForm rpTableF = new ReportTableForm();
    EventComboBoxModel ecbm;
   
    public ReportForm() {
        initComponents();
        tableLoad();
    }

     public void emptyObject()
    {
        tabela.clearSelection();
        txtDescription.setText("");
        
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
                    Report report = rpTableF.getReport(selectedIndex);
                    txtDescription.setText(report.getDescription());
                    
                   
                }
            }
        });
    }
    
    public void tableLoad() {
        List<Report> lista = rpRep.findAll();
        rpTableF.add(lista);
        tabela.setModel(rpTableF);
        rpTableF.fireTableDataChanged();
        tabelaSelectedIndexChange();

    }

   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        ComboBoxEventName = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        BtnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDescription.setText("Description :");
        getContentPane().add(lblDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 100, 30));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 460, 110));

        ComboBoxEventName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(ComboBoxEventName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 100, -1));

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 280, -1));

        BtnSave.setText("Save");
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(BtnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
         try {
            int row = tabela.getSelectedRow();
            if (txtDescription.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ju lutem mbusheni Description:", "Error", JOptionPane.ERROR_MESSAGE);

            }
            else
            {
                if (row == -1) {
                    Report report = new Report();
                    report.setDescription(txtDescription.getText());
                    
                    rpRep.create(report);
                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses !");
                } else {
                    Report report = this.rpTableF.getReport(row);
                    report.setDescription(txtDescription.getText());
                    

                    rpRep.edit(report);
                    JOptionPane.showMessageDialog(this, "E dhëna u editua me sukses");
                }
                emptyObject();
                tableLoad();
            };

        } catch (ReportException re) {
            JOptionPane.showMessageDialog(this, re.getMessage());
        }
    }//GEN-LAST:event_BtnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try{
            int row = tabela.getSelectedRow();
            if(row > -1){
                Object [] ob = {"Po","Jo"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0){
                    Report report = this.rpTableF.getReport(row);
                    
                    rpRep.remove(report);
                    tableLoad();
                    emptyObject();
                    JOptionPane.showMessageDialog(this, "E dhëna është fshir me sukses !");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Nuk keni selektuar asgjë për të fshir !");
            }
        }catch(ReportException re){
            JOptionPane.showMessageDialog(this, re.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        emptyObject();
    }//GEN-LAST:event_btnClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSave;
    private javax.swing.JComboBox<String> ComboBoxEventName;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JTable tabela;
    private javax.swing.JTextArea txtDescription;
    // End of variables declaration//GEN-END:variables

}