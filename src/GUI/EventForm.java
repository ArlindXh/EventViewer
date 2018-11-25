/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.Event;
import BL.EventCategory;
import BL.EventEntryType;
import BL.EventPayment;
import BL.EventRules;
import BL.EventSchedule;
import BL.Sponsor;
import BL.SubCategory;
import DAL.EventCategoryInterface;
import DAL.EventCategoryRepository;
import DAL.EventEntryTypeException;
import DAL.EventEntryTypeInterface;
import DAL.EventEntryTypeRepository;
import DAL.EventException;

import DAL.EventInterface;
import DAL.EventPaymentException;
import DAL.EventPaymentInterface;
import DAL.EventPaymentRepository;
import DAL.EventRepository;
import DAL.EventRulesInterface;
import DAL.EventRulesRepository;
import DAL.EventScheduleException;
import DAL.EventScheduleInterface;
import DAL.EventScheduleRepository;
import DAL.SponsorException;
import DAL.SponsorInterface;
import DAL.SponsorRepository;
import DAL.SubCategoryInterface;
import DAL.SubCategoryRepository;
import Model.CategoryComboBoxModel;
import Model.EventTableModel;
import com.sun.glass.events.KeyEvent;
import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author darda
 */
public class EventForm extends javax.swing.JInternalFrame {

    EventInterface eventRep = new EventRepository();
    EventTableModel eventTableModel = new EventTableModel();
    EventRulesInterface  eventRulesRep = new EventRulesRepository();
    EventScheduleInterface  evScheduleRep = new EventScheduleRepository();
    EventCategoryInterface  evCategoryRep = new EventCategoryRepository();
    SubCategoryInterface subCategoryRep = new SubCategoryRepository();
    SponsorInterface sponsorRep = new SponsorRepository();
    EventPaymentInterface evPayRep = new EventPaymentRepository();
    EventEntryTypeInterface evEntryRep = new EventEntryTypeRepository();
    CategoryComboBoxModel categoryCM;
    public EventForm() {
        initComponents();
        btnSponsor.setEnabled(false);
        tabelaLoad();
        addToCategoryCombo();
    }

    public void emptyObject()
    {
        tabela.clearSelection();
        txtEventName.setText("");
        txtCapacity.setText("");
        txtTypeName.setText("");
        cmbPayment.setSelectedItem(null);
        txtPrice.setText("");
        cmbCategory.setSelectedItem(null);
        cmbSubCategory.setSelectedItem(null);
        txtDescription.setText("");
        checkYes.setSelected(false);
        checkNo.setSelected(false);
        
    }
    
    public void addToCategoryCombo()
    {
        List<EventCategory> cList = evCategoryRep.findAll();
        categoryCM = new CategoryComboBoxModel(cList);
        cmbCategory.setModel(categoryCM);
    }
    
    private void tabelaSelectedIndexChange(){
        final ListSelectionModel rowSM = tabela.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {

                    Event event = eventTableModel.getEvent(selectedIndex);
                    EventCategory evCa = event.getEventCategoryID();
                    SubCategory evSub = subCategoryRep.findByCategoryID(evCa);
                    EventEntryType evE= event.getEventEntryType();
                    EventPayment evP = evE.getEventPaymentID();
                    EventRules evR = eventRulesRep.findEventEntry(evE);
                    Sponsor evS = event.getSponsorID();
                    EventSchedule evSch = evScheduleRep.findByEvent(event);
                    
                    txtEventName.setText(event.getEventName());
                    txtCapacity.setText(event.getEventCapacity()+"");
                    txtTypeName.setText(evE.getEventTypeName());
                    cmbPayment.setSelectedItem(evP.getPaymentType());
                    txtPrice.setText(evP.getPrice()+"");
                    cmbCategory.setSelectedItem(evCa);
                    cmbSubCategory.setSelectedItem(evSub);
                    txtDescription.setText(evE.getDescription());
                    if(evS.getSponsorID() == 1002)
                        checkNo.setSelected(true);
                    else
                        checkYes.setSelected(true);
                    
                    txtEventRule.setText(evR.getDescription());

                }
            }
        });
    }
    
    public void tabelaLoad()
    {
        List<Event> lista = lista = eventRep.findAll();
        eventTableModel.add(lista);
        tabela.setModel(eventTableModel);
        eventTableModel.fireTableDataChanged();
        tabelaSelectedIndexChange();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hasSponsor = new javax.swing.ButtonGroup();
        txtEventName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCapacity = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbCategory = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbSubCategory = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        cmbPayment = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        txtTypeName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnSponsor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnRemove = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtYear = new javax.swing.JComboBox<>();
        txtDay = new javax.swing.JComboBox<>();
        txtMonth = new javax.swing.JComboBox<>();
        txtMonth1 = new javax.swing.JComboBox<>();
        txtYear1 = new javax.swing.JComboBox<>();
        txtDay1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtRuleDesc = new javax.swing.JScrollPane();
        txtEventRule = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        checkYes = new javax.swing.JRadioButton();
        checkNo = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Event Name");

        jLabel2.setText("Capacity");

        cmbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoryActionPerformed(evt);
            }
        });

        jLabel3.setText("Event Category");

        jLabel4.setText("Sub Category");

        jLabel5.setText("Event Entry Type");

        jLabel6.setText("EntryDescription");

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

        jLabel7.setText("Price");

        cmbPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Credit Card", "Cash" }));
        cmbPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPaymentActionPerformed(evt);
            }
        });

        jLabel8.setText("Payment Type");

        lblPrice.setForeground(new java.awt.Color(255, 0, 0));

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

        btnSponsor.setText("Add Sponsor");
        btnSponsor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSponsorActionPerformed(evt);
            }
        });

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

        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRemove.setText("Remove");

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel9.setText("Has Sponsor");

        txtYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906" }));
        txtYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYearActionPerformed(evt);
            }
        });

        txtDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));

        txtMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        txtMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonthActionPerformed(evt);
            }
        });

        txtMonth1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        txtMonth1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonth1ActionPerformed(evt);
            }
        });

        txtYear1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906" }));
        txtYear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYear1ActionPerformed(evt);
            }
        });

        txtDay1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));
        txtDay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDay1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Start Date");

        jLabel11.setText("End Date");

        txtEventRule.setColumns(20);
        txtEventRule.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtEventRule.setRows(5);
        txtEventRule.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEventRuleKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEventRuleKeyTyped(evt);
            }
        });
        txtRuleDesc.setViewportView(txtEventRule);

        jLabel12.setText("Event Rule Description");

        hasSponsor.add(checkYes);
        checkYes.setText("Yes");
        checkYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkYesActionPerformed(evt);
            }
        });

        hasSponsor.add(checkNo);
        checkNo.setText("No");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(txtEventName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel3)
                                        .addGap(137, 137, 137)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(cmbSubCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel10)
                                        .addGap(155, 155, 155)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtDay1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(10, 10, 10))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnRemove)
                                                .addGap(46, 46, 46)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtMonth1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnClear))))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnSponsor))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGap(36, 36, 36)
                                                    .addComponent(jLabel5)
                                                    .addGap(103, 103, 103)
                                                    .addComponent(jLabel8))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(36, 36, 36)
                                                    .addComponent(cmbPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(34, 34, 34)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(24, 24, 24)
                                                    .addComponent(jLabel7)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(checkYes)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(checkNo))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(117, 117, 117)
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblPrice))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel12))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(txtRuleDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 88, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel9)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbSubCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSponsor)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkYes)
                            .addComponent(checkNo))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtDay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMonth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtRuleDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnClear)
                    .addComponent(btnRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyPressed
        int t = txtDescription.getText().length();
        if(!(evt.getKeyChar() == KeyEvent.VK_BACKSPACE) && !(evt.getKeyChar() == KeyEvent.VK_ENTER))
        {
            if(t == 50)
            txtDescription.setText(txtDescription.getText()+"\n");
        }
    }//GEN-LAST:event_txtDescriptionKeyPressed

    private void txtDescriptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyTyped

    }//GEN-LAST:event_txtDescriptionKeyTyped

    private void txtTypeNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTypeNameKeyPressed

    }//GEN-LAST:event_txtTypeNameKeyPressed

    private void txtTypeNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTypeNameKeyTyped

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
      
    }//GEN-LAST:event_txtPriceKeyTyped

    private void txtYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYearActionPerformed

    private void txtMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonthActionPerformed

    }//GEN-LAST:event_txtMonthActionPerformed

    private void txtMonth1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonth1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMonth1ActionPerformed

    private void txtYear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYear1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYear1ActionPerformed

    private void btnSponsorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSponsorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSponsorActionPerformed

    private void txtEventRuleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEventRuleKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEventRuleKeyPressed

    private void txtEventRuleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEventRuleKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEventRuleKeyTyped

    private void checkYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkYesActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try
        {
            int row = tabela.getSelectedRow();
            if(txtEventName.getText().equals("") || txtCapacity.getText().equals("") || txtTypeName.getText().equals("") || (cmbPayment.getSelectedItem()+"").trim().equals("")
                    || txtPrice.getText().equals("") || cmbCategory.getSelectedItem() == null || cmbSubCategory.getSelectedItem() == null || txtDescription.getText().equals("")
                    || !(checkYes.isSelected() || checkNo.isSelected()) || txtEventRule.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Mbushini te gjitha te dhenat!");
            }
            else
            {
                if(row == -1)
                {
                    Event e = new Event();
                    EventCategory evC = (EventCategory)cmbCategory.getSelectedItem();
                    SubCategory evS = (SubCategory)cmbSubCategory.getSelectedItem();
                    EventRules eRul = new EventRules();
                    EventEntryType evEn = new EventEntryType();
                    EventPayment evP = new EventPayment();
                    EventSchedule evSche = new EventSchedule();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    String startDate = txtDay.getSelectedIndex() + "-" + txtMonth.getSelectedIndex() + "-" + (2017-(txtYear.getSelectedIndex()-1));
                    String endDate = txtDay1.getSelectedIndex() + "-" + txtMonth1.getSelectedIndex() + "-" + (2017-(txtYear1.getSelectedIndex()-1));
                    
                    evSche.setStartDate(sdf.parse(startDate));
                    evSche.setEndDate(sdf.parse(endDate));
                    evP.setPrice(BigDecimal.valueOf(Double.parseDouble(txtPrice.getText())));
                    evP.setPaymentType(cmbPayment.getSelectedItem()+"");
                    evS.setEventCategoryID(evC);
                    
                    evPayRep.create(evP);
                    
                    Sponsor sponsor = sponsorRep.findById(1002);
                    
                    evEn.setDescription(txtDescription.getText());
                    evEn.setEventTypeName(txtTypeName.getText());
                    evEn.setEventPaymentID(evP);
                    evEntryRep.create(evEn);
                    
                    
                    e.setEventEntryType(evEn);
                    e.setEventCategoryID(evC);
                    e.setSponsorID(sponsor);
                    e.setEventCapacity(Integer.parseInt(txtCapacity.getText()));
                    e.setEventName(txtEventName.getText());
                    eventRep.create(e);
                    evSche.setEventID(e);
                    evScheduleRep.create(evSche);
                }
            }
        }catch(SponsorException | EventPaymentException | EventEntryTypeException | EventException | EventScheduleException s)
        {
            JOptionPane.showMessageDialog(this, s.getMessage());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearActionPerformed

    private void cmbPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPaymentActionPerformed

    private void txtDay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDay1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDay1ActionPerformed

    private void cmbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSponsor;
    private javax.swing.JRadioButton checkNo;
    private javax.swing.JRadioButton checkYes;
    private javax.swing.JComboBox<EventCategory> cmbCategory;
    private javax.swing.JComboBox<String> cmbPayment;
    private javax.swing.JComboBox<String> cmbSubCategory;
    private javax.swing.ButtonGroup hasSponsor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JComboBox<String> txtDay;
    private javax.swing.JComboBox<String> txtDay1;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtEventName;
    private javax.swing.JTextArea txtEventRule;
    private javax.swing.JComboBox<String> txtMonth;
    private javax.swing.JComboBox<String> txtMonth1;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JScrollPane txtRuleDesc;
    private javax.swing.JTextField txtTypeName;
    private javax.swing.JComboBox<String> txtYear;
    private javax.swing.JComboBox<String> txtYear1;
    // End of variables declaration//GEN-END:variables
}
