/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BL.City;
import BL.ContactUser;
import BL.Country;
import BL.Role;
import BL.Users;

import DAL.CityInterface;
import DAL.CityRepository;

import DAL.ContactUserException;
import DAL.ContactUserInterface;
import DAL.ContactUserRepository;

import DAL.CountryInterface;
import DAL.CountryRepository;
import DAL.RoleException;
import DAL.RoleInterface;
import DAL.RoleRepository;
import DAL.UserException;
import DAL.UserRepository;
import Model.CityComboBoxModel;
import Model.CountryComboBoxModel;
import Model.RoleComboBoxModel;
import Model.UserTableModel;
import EVPS.EmailValidator;
import EVPS.PasswordCrypto;

import EVPS.WriteInNoteException;
import EVPS.WriteInNote;
import com.sun.glass.events.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author User
 */
public class UserForm extends javax.swing.JInternalFrame {

        UserRepository userRepository = new UserRepository();
        UserTableModel userTableForm = new UserTableModel();
        ContactUserInterface cUser = new ContactUserRepository();
        CountryInterface countryR = new CountryRepository();
        CityInterface cityR = new CityRepository();
        RoleInterface roleR = new RoleRepository();
        CountryComboBoxModel cmbM;
        CityComboBoxModel cityCM;
        PasswordCrypto pc = new PasswordCrypto("ddddd111112ddrrr");
        RoleComboBoxModel roleCo;
        
        TableRowSorter filterName;
        RowFilter<UserTableModel,Users> rf ;
    /**
     * Creates new form AdminForm
     */
    public UserForm(){
        
        initComponents();
        tabelaLoad();
        countryCombo();
        roleCombo();
        
      
    }
    
    
    public void filter()
    {
        filterName = new TableRowSorter<UserTableModel>(userTableForm);
        tabela.setRowSorter(filterName);
        rf = RowFilter.regexFilter(txtSearchName.getText(),0);
        filterName.setRowFilter(rf);
    }
    
    public void countryCombo()
    {
        List<Country> cList = countryR.findAllOrdered();
        cmbM = new CountryComboBoxModel(cList);
        this.txtCountry.setModel(cmbM);
        
    }
    
   
   
    public void roleCombo()
    {
        List<Role> cList = roleR.findAll();
        roleCo = new RoleComboBoxModel(cList);
        this.cmbRole.setModel(roleCo);
    }
    
    public void addToCityCombo(Country country)
    {
        List<City> cList = cityR.findCitys(country);
        cityCM = new CityComboBoxModel(cList);
        this.txtCity.setModel(cityCM);
        
    }
     
    private void tabelaLoad() {
        
        List<Users> lista = lista = userRepository.findAll();
        userTableForm.add(lista);
        tabela.setModel(userTableForm);
        userTableForm.fireTableDataChanged();
        tabelaSelectedIndexChange();
    
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

                    Users user = userTableForm.getUser(selectedIndex);
                    ContactUser contactUser = cUser.finnByUserID(user);
                    City city = user.getCityID();
                    Date date = user.getBirthDate();

                    txtFirstName.setText(user.getFirstName());
                    txtLastName.setText(user.getLastName());
                    txtUsername.setText(user.getUserName());
                    try {
                        txtPassword.setText(pc.decrypt(new String(user.getPassword())).replace("+", ""));
                    } catch (Exception ex)
                    {
                    JOptionPane.showMessageDialog(null,"Passwordi i shkruar nuk lejohet");

                    }
                    txtEmail.setText(contactUser.getEmail1());
                    txtPhoneNo.setText(contactUser.getPhoneNo1());
                    txtEmail2.setText(contactUser.getEmail2());
                    txtPhone2.setText(contactUser.getPhoneNo2());
                    txtDay.setSelectedIndex(date.getDate());
                    txtMonth.setSelectedIndex(date.getMonth()+1);
                    txtYear.setSelectedIndex((2017-(date.getYear()+1900))+1);

                    txtEmail2.setText(contactUser.getEmail2());
                    if(user.getGender() == 'F')
                    {
                        checkF.setEnabled(true);
                        checkF.setSelected(true);
                        checkM.setEnabled(false);
                        checkM.setSelected(false);
                    }    
                    else
                    {
                        checkM.setEnabled(true);
                        checkM.setSelected(true);
                        checkF.setEnabled(false);
                        checkF.setSelected(false);
                    }


                    txtCountry.setSelectedItem(city.getCountryID());
                    txtCountry.repaint();

                    txtCity.setSelectedItem(city);
                    txtCity.repaint();

                    cmbRole.setSelectedItem(user.getRoleID());
                    cmbRole.repaint();

                }
            }
        });
    }
   
      
    public void emptyObject()
    {
        
        tabela.clearSelection();
        txtFirstName.setText("");
        txtLastName.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        txtEmail.setText("");
        txtEmail2.setText("");
        txtDay.setSelectedIndex(0);
        txtMonth.setSelectedIndex(0);
        txtYear.setSelectedIndex(0);
        checkF.setSelected(false);
        checkM.setSelected(false);
        txtPhoneNo.setText("");
        txtPhone2.setText("");
        txtCountry.setSelectedItem(null);
        txtCity.setSelectedItem(null);
        cmbRole.setSelectedItem(null);
        lblFirstNameS.setText("");
        txtSearchName.setText("");
        
    }
      
      
      
      
      /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnDeleteUser = new javax.swing.JButton();
        btnSaveUser = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtUsername = new javax.swing.JTextField();
        txtPhoneNo = new javax.swing.JTextField();
        checkF = new javax.swing.JCheckBox();
        checkM = new javax.swing.JCheckBox();
        txtCountry = new javax.swing.JComboBox<>();
        txtCity = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtYear = new javax.swing.JComboBox<>();
        txtDay = new javax.swing.JComboBox<>();
        txtMonth = new javax.swing.JComboBox<>();
        txtEmail2 = new javax.swing.JTextField();
        txtPhone2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblEmail1 = new javax.swing.JLabel();
        lblEmail2 = new javax.swing.JLabel();
        lblPhone1 = new javax.swing.JLabel();
        lblPhone2 = new javax.swing.JLabel();
        lblEmri = new javax.swing.JLabel();
        lblMbiemri = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblBirthdate = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblPassw = new javax.swing.JLabel();
        cmbRole = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        btnGenerateExel = new javax.swing.JButton();
        btnGenerateWord = new javax.swing.JButton();
        txtSearchName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lblFirstNameS = new javax.swing.JLabel();

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
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel5.setText("First Name:");

        jLabel6.setText("Last Name:");

        jLabel7.setText("Username:");

        jLabel8.setText("Phone No:");

        btnDeleteUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteUser.setText("Delete User");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        btnSaveUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveUser.setText("Save User");
        btnSaveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveUserActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancel.setText("Clear");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
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
        jScrollPane2.setViewportView(tabela);

        jLabel1.setText("Password:");

        jLabel2.setText("Birthdate:");

        jLabel3.setText("Gender:");

        jLabel12.setText("Email:");

        txtFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFirstNameKeyPressed(evt);
            }
        });

        txtLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLastNameKeyPressed(evt);
            }
        });

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });

        txtPhoneNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhoneNoKeyPressed(evt);
            }
        });

        checkF.setText("Female");
        checkF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkFActionPerformed(evt);
            }
        });

        checkM.setText("Male");
        checkM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMActionPerformed(evt);
            }
        });

        txtCountry.setToolTipText("");
        txtCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCountryActionPerformed(evt);
            }
        });

        txtCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityActionPerformed(evt);
            }
        });

        jLabel9.setText("City:");

        jLabel10.setText("Country");

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

        txtEmail2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmail2ActionPerformed(evt);
            }
        });

        txtPhone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhone2ActionPerformed(evt);
            }
        });
        txtPhone2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhone2KeyPressed(evt);
            }
        });

        jLabel11.setText("Email2:");

        jLabel13.setText("Phone2:");

        lblEmail1.setForeground(new java.awt.Color(255, 0, 0));

        lblEmail2.setForeground(new java.awt.Color(255, 51, 0));

        lblPhone1.setForeground(new java.awt.Color(255, 51, 0));

        lblPhone2.setForeground(new java.awt.Color(255, 51, 0));

        lblEmri.setForeground(new java.awt.Color(255, 0, 0));

        lblMbiemri.setForeground(new java.awt.Color(255, 0, 51));

        lblUsername.setForeground(new java.awt.Color(255, 0, 51));

        lblBirthdate.setForeground(new java.awt.Color(255, 0, 0));

        lblCountry.setForeground(new java.awt.Color(255, 0, 51));

        lblGender.setForeground(new java.awt.Color(255, 0, 0));

        lblPassw.setForeground(new java.awt.Color(255, 0, 0));

        jLabel14.setText("Role:");

        btnGenerateExel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGenerateExel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Excel-2-icon.png"))); // NOI18N
        btnGenerateExel.setText("Generate");
        btnGenerateExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateExelActionPerformed(evt);
            }
        });

        btnGenerateWord.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGenerateWord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ButtonImages/Word-2-icon.png"))); // NOI18N
        btnGenerateWord.setText("Generate");
        btnGenerateWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateWordActionPerformed(evt);
            }
        });

        txtSearchName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchNameActionPerformed(evt);
            }
        });
        txtSearchName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchNameKeyTyped(evt);
            }
        });

        jLabel15.setText("Search First Name");

        lblFirstNameS.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblBirthdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblCountry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(141, 141, 141)
                                        .addComponent(checkF)
                                        .addGap(10, 10, 10)
                                        .addComponent(checkM))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(110, 110, 110)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(51, 51, 51)
                                .addComponent(jLabel10)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel9)
                                .addGap(92, 92, 92)
                                .addComponent(jLabel11)
                                .addGap(194, 194, 194)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(65, 65, 65))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblEmri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblMbiemri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblPassw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(lblEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(67, 67, 67)
                                        .addComponent(jLabel14))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnSaveUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeleteUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel15))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(68, 68, 68)
                                        .addComponent(btnGenerateExel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnGenerateWord))
                                    .addComponent(lblFirstNameS, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel12)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblEmri, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblMbiemri, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPassw, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14))
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(checkM)
                                .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkF)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeleteUser)
                            .addComponent(btnSaveUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancel)
                            .addComponent(btnGenerateExel)
                            .addComponent(btnGenerateWord)
                            .addComponent(txtSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(lblFirstNameS, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveUserActionPerformed
        try {
            
            EmailValidator emV = new EmailValidator();
            
            int row = tabela.getSelectedRow();
            if (txtFirstName.getText().equals("") || txtLastName.getText().equals("") || txtEmail.getText().equals("") 
                    ||txtEmail2.getText().equals("") ||txtDay.getSelectedIndex()==0 || !(checkF.isSelected() || checkM.isSelected()) 
                    || (txtDay.getSelectedIndex() == 0  || txtMonth.getSelectedIndex() == 0 || txtYear.getSelectedIndex() == 0) 
                    || txtCountry.getSelectedItem() == null || txtCountry.getSelectedItem() == null
                    || !emV.validateEmail(txtEmail.getText()) || !emV.validateEmail(txtEmail2.getText()) || txtPhoneNo.getText().equals("") || !emV.validate(txtPhoneNo.getText())) 
            {
                JOptionPane.showMessageDialog(this, "Ju lutem Mbusheni gjitha kolonat :", "Error", JOptionPane.ERROR_MESSAGE);
                if(txtDay.getSelectedIndex() == 0  || txtMonth.getSelectedIndex() == 0 || txtYear.getSelectedIndex() == 0)
                    lblBirthdate.setText("Ju selektoni te gjitha te dhenat!");
                if(!(checkF.isSelected() || checkM.isSelected() ))
                    lblGender.setText("Selektoni njeren!");
                if( txtCountry.getSelectedItem() == null || txtCountry.getSelectedItem() == null)
                    lblCountry.setText("Selektoni nje shtet/qytet!");
                if(!emV.validateEmail(txtEmail.getText()))
                    lblEmail1.setText("Email Gabim!");
                if(!emV.validateEmail(txtEmail2.getText()))
                    lblEmail2.setText("Email Gabim!");
                if(!emV.validate(txtPhoneNo.getText()))
                    lblPhone1.setText("Phone gabim!");
                
            }
            else{
                
                lblCountry.setText("");
                lblGender.setText("");
                lblBirthdate.setText("");
                lblEmail2.setText("");
                lblEmail1.setText("");
               
                if(row == -1)
                {
                    
                    Users user = new Users();
                    ContactUser co = new ContactUser();
                    City city = (City)txtCity.getSelectedItem();
                    String pass = pc.encrypt(new String(txtPassword.getPassword()));
                    Role role = (Role)cmbRole.getSelectedItem();
                    user.setRoleID(role);
                    
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    String dateInString = txtDay.getSelectedIndex() + "-" + txtMonth.getSelectedIndex() + "-" + (2017-(txtYear.getSelectedIndex()-1));
                    date = sdf.parse(dateInString);
                    user.setFirstName(txtFirstName.getText());
                    user.setLastName(txtLastName.getText());
                    user.setUserName(txtUsername.getText());
                    user.setBirthDate(date);
                    user.setPassword(pass);
                    if(checkF.isSelected())
                        user.setGender('F');
                    else
                        user.setGender('M');
 
                    
                    co.setEmail1( txtEmail.getText());
                    co.setEmail2(txtEmail2.getText());
                    co.setPhoneNo1(txtPhoneNo.getText());
                    co.setPhoneNo2(txtPhone2.getText());
                    
                    user.setCityID(city);
                    userRepository.create(user);
                    co.setUserID(user);
                    cUser.create(co);

                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses !");
                } 
                else 
                {
                    Users user = this.userTableForm.getUser(row);

                    ContactUser co = cUser.finnByUserID(user);
                    City city = (City)txtCity.getSelectedItem();
                    Role role = (Role)cmbRole.getSelectedItem();
                    user.setRoleID(role);
                    String pass = pc.encrypt(new String(txtPassword.getPassword()));
                    Date date = new Date();
                    int year = Integer.parseInt((String) txtYear.getSelectedItem());
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    String dateInString = txtDay.getSelectedIndex() + "-" + txtMonth.getSelectedIndex() + "-" + year;
                    date = sdf.parse(dateInString);
                    user.setFirstName(txtFirstName.getText());
                    user.setLastName(txtLastName.getText());
                    user.setUserName(txtUsername.getText());
                    user.setBirthDate(date);
                    user.setPassword(pass);
                    if(checkF.isSelected())
                        user.setGender('F');
                    else
                        user.setGender('M');
 
                    
                    co.setEmail1( txtEmail.getText());
                    co.setEmail2(txtEmail2.getText());
                    co.setPhoneNo1(txtPhoneNo.getText());
                    co.setPhoneNo2(txtPhone2.getText());
                    
                    user.setCityID(city);
                    
                    userRepository.edit(user);
                    co.setUserID(user);
                    cUser.edit(co);
                    JOptionPane.showMessageDialog(this, "E dhëna u editua me sukses");
                }
                emptyObject();
                tabelaLoad();
            }
              
        } catch (UserException | ContactUserException |  RoleException | ParseException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }   catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        
    }//GEN-LAST:event_btnSaveUserActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        try{
            lblCountry.setText("");
            lblGender.setText("");
            lblBirthdate.setText("");
            int row = tabela.getSelectedRow();
            if(row > -1){
                Object [] ob = {"Po","Jo"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0){
                    Users user = this.userTableForm.getUser(row);
                    ContactUser co = cUser.finnByUserID(user);
                    
                    cUser.remove(co);
                    userRepository.remove(user);

                 
                    tabelaLoad();
                    emptyObject();
                    JOptionPane.showMessageDialog(this, "E dhëna është fshir me sukses !");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Nuk keni selektuar asgjë për të fshir !");
            }
        }catch(UserException  e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }   catch (ContactUserException ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void txtYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYearActionPerformed

    private void txtMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonthActionPerformed
        
    }//GEN-LAST:event_txtMonthActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
       
        emptyObject();
        
        
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtEmail2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmail2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmail2ActionPerformed

    private void txtCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCountryActionPerformed
        addToCityCombo((Country)txtCountry.getSelectedItem());
    }//GEN-LAST:event_txtCountryActionPerformed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityActionPerformed

    private void txtFirstNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFirstNameKeyPressed
 
         char c = evt.getKeyChar();
        if(isAlphabetic(c) || c == KeyEvent.VK_BACKSPACE || evt.isControlDown() || evt.isShiftDown() || evt.isAltDown())
        {
            txtFirstName.setEditable(true);
            lblEmri.setText("");
            
         }
        else
        { txtFirstName.setEditable(false);
            lblEmri.setText("Emri eshte gabim!");
        }
    }//GEN-LAST:event_txtFirstNameKeyPressed

    private void txtLastNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastNameKeyPressed
          char c = evt.getKeyChar();
        if(isAlphabetic(c) || c == KeyEvent.VK_BACKSPACE || evt.isControlDown() || evt.isShiftDown())
        {
            txtLastName.setEditable(true);
            lblMbiemri.setText("");
        } 
        else
        {
            txtLastName.setEditable(false);
            lblMbiemri.setText("Mbiemri eshte gabim!");
        }
    }//GEN-LAST:event_txtLastNameKeyPressed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
          char c = evt.getKeyChar();
        if(isAlphabetic(c) || c == KeyEvent.VK_BACKSPACE || isDigit(c) || evt.isControlDown() || evt.isShiftDown())
        {
            txtUsername.setEditable(true);
            lblUsername.setText("");
        }
        else
        {
            txtUsername.setEditable(false);
            lblUsername.setText("Username eshte gabim!");
        }
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void txtPhoneNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNoKeyPressed
         char c = evt.getKeyChar();
         if(c == '+' || isDigit(c) || c == KeyEvent.VK_BACKSPACE)
         {
             lblPhone1.setText("");
             txtPhoneNo.setEditable(true);
         }
         else
         {
             lblPhone1.setText("Gabim numri");
             txtPhoneNo.setEditable(false);
         }
    }//GEN-LAST:event_txtPhoneNoKeyPressed

    private void txtPhone2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhone2KeyPressed
        char c = evt.getKeyChar();
         if(c == '+' || isDigit(c) || c == KeyEvent.VK_BACKSPACE)
         {
             lblPhone2.setText("");
             txtPhone2.setEditable(true);
         }
        else
        {
             lblPhone2.setText("Gabim");
             txtPhone2.setEditable(false);
        }  
    }//GEN-LAST:event_txtPhone2KeyPressed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        char c = evt.getKeyChar();
        if(isAlphabetic(c) || isDigit(c) || evt.isShiftDown() || c == KeyEvent.VK_BACKSPACE)
        {
            lblPassw.setText("");
            txtPassword.setEditable(true);
         }
        else
        {
            lblPassw.setText("Gabim");
            txtPassword.setEditable(false);
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void checkFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkFActionPerformed
        if(checkF.isSelected())
            checkM.setEnabled(false);
        else
            checkM.setEnabled(true);
    }//GEN-LAST:event_checkFActionPerformed

    private void checkMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMActionPerformed
        if(checkM.isSelected())
            checkF.setEnabled(false);
        else
            checkF.setEnabled(true);
        

    }//GEN-LAST:event_checkMActionPerformed

    private void txtPhone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhone2ActionPerformed

    private void btnGenerateWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateWordActionPerformed
        List<Users> uList = userRepository.findAll();
        StringBuilder sb = new StringBuilder();
        WriteInNote writeIn;
        JFileChooser jc = new JFileChooser();
        jc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int res = jc.showOpenDialog(this);
        String path;
        if(res == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                path = jc.getSelectedFile().getAbsolutePath()+"\\users.doc";
                if(uList == null)
                    sb.append("Nuk kishte asnje user!!!!");
                else
                {
                    sb.append("Ne total jan " + uList.size() + " usera: " + System.lineSeparator() + System.lineSeparator());
                    int count = 0;
                    for(Users u : uList)
                    {
                        if(!(u.getRoleID().getType().equals("Admin")))
                            sb.append(++count + ": " +u.toString() + System.lineSeparator() );
                    }

                }
                writeIn = new WriteInNote(sb.toString(),path);
                writeIn.write();
                JOptionPane.showMessageDialog(this, "File-i users.doc u rajt me sukses");
            }catch(WriteInNoteException | IOException e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        
        
        
    }//GEN-LAST:event_btnGenerateWordActionPerformed

    private void btnGenerateExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateExelActionPerformed
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Userat");
        List<Users> uList = userRepository.findAll();
        
        Row r = sheet.createRow(0);
        Cell c = r.createCell(0);
        Cell c1 = r.createCell(1);
        
  
        c.setCellValue("Emri");
        c1.setCellValue("Mbiemri");
        
        int rowCount = 1;
        Row row;
        JFileChooser jc = new JFileChooser();
        jc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int res = jc.showOpenDialog(this);
        String path;
        if(res == JFileChooser.APPROVE_OPTION)   
        {
            path = jc.getSelectedFile().getAbsolutePath();
            for(int i = 0;i<uList.size();i++)
            {
                row = sheet.createRow(rowCount++);
                Cell c2 = row.createCell(0);
                Cell c3 = row.createCell(1);

                c2.setCellValue(uList.get(i).getFirstName());
                c3.setCellValue(uList.get(i).getLastName());
            }
                try {
                    FileOutputStream outputStream = new FileOutputStream(path + "\\user.xls");
                    workbook.write(outputStream);
                    workbook.close();
                    JOptionPane.showMessageDialog(this,"Excel-i u ruajt me sukses.");

                } catch (FileNotFoundException ex) {
                    System.out.println(ex.getMessage());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
        }
            

    }//GEN-LAST:event_btnGenerateExelActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtSearchNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchNameKeyTyped
        filter();
    }//GEN-LAST:event_txtSearchNameKeyTyped

    private void txtSearchNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchNameActionPerformed
             

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnGenerateExel;
    private javax.swing.JButton btnGenerateWord;
    private javax.swing.JButton btnSaveUser;
    private javax.swing.JCheckBox checkF;
    private javax.swing.JCheckBox checkM;
    private javax.swing.JComboBox<Role> cmbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBirthdate;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblEmail1;
    private javax.swing.JLabel lblEmail2;
    private javax.swing.JLabel lblEmri;
    private javax.swing.JLabel lblFirstNameS;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblMbiemri;
    private javax.swing.JLabel lblPassw;
    private javax.swing.JLabel lblPhone1;
    private javax.swing.JLabel lblPhone2;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tabela;
    private javax.swing.JComboBox<City> txtCity;
    private javax.swing.JComboBox<Country> txtCountry;
    private javax.swing.JComboBox<String> txtDay;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmail2;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JComboBox<String> txtMonth;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone2;
    private javax.swing.JTextField txtPhoneNo;
    private javax.swing.JTextField txtSearchName;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JComboBox<String> txtYear;
    // End of variables declaration//GEN-END:variables
}
