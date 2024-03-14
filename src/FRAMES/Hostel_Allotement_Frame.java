/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;

import BeanClasses.BatchBean;
import BeanClasses.DepartmentBean;
import BeanClasses.FacultyBean;
import BeanClasses.HostelAllotementBean;
import BeanClasses.HostelBean;
import BeanClasses.PartBean;
import BeanClasses.ProgramsBean;
import BeanClasses.StudentsBean;
import DatabaseManager.DBManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author Dell
 */
public class Hostel_Allotement_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Hostel_Allotement_Frame
     */
    public Hostel_Allotement_Frame() throws Exception {
        initComponents();
         java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        this.setBounds(0,0,d.width,d.height);
        
        getFaculty();
        getDepartment();
        getProgram();
        rollNo();
        getHostelAllotement();
        part();
        getHostel();
    }


     private void getFaculty(){
    
      try {
            Vector v = DBManager.getFaculty();   
            
            for(int i = 0; i<v.size(); i++){
                this.facultyComboBox.addItem(v.elementAt(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } 
    
      private void  getDepartment(){
     try {
            Vector v = DBManager.getDepartment();   
            
            for(int i = 0; i<v.size(); i++){
                this.departmentComboBox.addItem(v.elementAt(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
      
    private void  getProgram(){
    try {
            Vector v = DBManager.getProgram();   
            
            for(int i = 0; i<v.size(); i++){
                this.programComboBox.addItem(v.elementAt(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    
     
   private void part(){
     try {             
          Vector v = DBManager.getPart();
          this.partComboBox1.removeAllItems();
          for(int i=0; i<v.size(); i++){
            partComboBox1.addItem(v.elementAt(i));
          }
            
         } catch (Exception ex) {
             Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
         }
   
   }
   
   
    private void  getHostelAllotement(){
    try {
            Vector v = DBManager.getHostelAllotement();
            hostelList.setListData(v);
           
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
    
    
     private void getHostel(){
     try {
            Vector v = DBManager.getHostel();
             this.hostelComboBox1.removeAllItems();
             for(int i=0; i<v.size(); i++){
            hostelComboBox1.addItem(v.elementAt(i));
          }
           
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   private void rollNo() throws Exception{
   
    try {  
             
          Vector v = DBManager.getStudent();
          this.studComboBox.removeAllItems();
          for(int i=0; i<v.size(); i++){
            studComboBox.addItem(v.elementAt(i));
          }
    }catch(Exception e){e.printStackTrace();}
   } 
  
   
    private void addRecord(){
           
          String date = (String)this.dateOfAllotementTextField.getText();
               
           String challan =(String) this.challanNoTextField.getText();
           String dateChallan = (String) this.dateChallanTextField.getText();
           String amout = (String) this.amoutTextField.getText();
          
           StudentsBean ba=(StudentsBean)studComboBox.getSelectedItem();
           if(ba==null)return;
          
           String washroom=(String)romNoComboBox.getSelectedItem();   
           String remarks =(String) this.remarksTextArea.getText();
           
           
           HostelBean hb=(HostelBean)hostelComboBox1.getSelectedItem();
           if(hb==null)return;
           
            PartBean  partbeans = (PartBean) partComboBox1.getSelectedItem(); 
            if(partbeans==null)return;  
           
           
           int c=Integer.parseInt(challan);
           int w=Integer.parseInt(washroom);
           int a=Integer.parseInt(amout);
 
           
           //System.out.println(hb.geHostelId());
           //System.out.println(partbeans.getBatchId());
         //  System.out.println(date);
           //System.out.println(c);
           //System.out.println(dateChallan);
           //System.out.println(a);
           //System.out.println(w);
           //System.out.println(remarks);
           
        try {
            int row = DBManager.addHostelAllotement(hb.getHostelId(),partbeans.getBatchId(),partbeans.getPart(),ba.getRollNo(),date,c ,dateChallan,a,w,remarks);
          // JOptionPane.showMessageDialog(null,row);
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
         getHostelAllotement();
         clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"This way is valid Date  (Month/Date/Year) \n BUT This way is Unvalid Date (Date-Month-Year)");
            //Logger.getLogger(FacultyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
   private void updateRecord(){
      
      HostelAllotementBean  bean = (HostelAllotementBean) hostelList.getSelectedValue();  
       
        if(bean==null)return;
        
            // String al= AllotementTextField6.getText();
 //         String rollNo= (String) studComboBox.getSelectedItem();
             String date = this.dateOfAllotementTextField.getText();
           String cN = this.challanNoTextField.getText();
           String dC = this.dateChallanTextField.getText();
           String amout = this.amoutTextField.getText();
           String room = (String) this.romNoComboBox.getSelectedItem();
           String remarks = this.remarksTextArea.getText();
           
           
           int c=Integer.parseInt(cN);
           int w=Integer.parseInt(room);
           int a=Integer.parseInt(amout);
           
           
           //System.out.println(hb.geHostelId());
           System.out.println(date);
           System.out.println(c);
          
            System.out.println(a);
           System.out.println(w);
           System.out.println(remarks);
           
        
        try {
             //int row = DBManager.updateFaculty(bean.getFacId());
            int row = DBManager.updateHostelAllotement(bean.geAllotementId(),bean.getRollNo(),date,c,dC,a,w,remarks);
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
            getHostelAllotement();
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
           // Logger.getLogger(FacultyFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"This way is valid Date  (Month/Date/Year) \n BUT This way is Unvalid Date (Date-Month-Year)");
        }
    
    
    }
   
   
    private void deleteRecord(){
      
        HostelAllotementBean  bean = (HostelAllotementBean) hostelList.getSelectedValue();  
       
        if(bean==null)return;
        
        try {
            
            int row = DBManager.deleteHostelAllotement(bean.geAllotementId());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
              getHostelAllotement();
              clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(FacultyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    private void clear(){
    
      //HostelAllotementBean  bean = (HostelAllotementBean) hostelList.getSelectedValue();
        //if(bean==null)return;
        
        this.AllotementTextField6.setText(" ");
        this.dateOfAllotementTextField.setText(" ");
        this.challanNoTextField.setText(" ");
        this.dateChallanTextField.setText(" ");
        this.amoutTextField.setText(" ");
        this.romNoComboBox.addItem(" ");
    
    }
    
   
   
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        hostelComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        hostelList = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        batchComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        shiftComboBox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        groupComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        partComboBox1 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        fatherNameTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        surNameTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        AllotementTextField6 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        dateOfAllotementTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        challanNoTextField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        amoutTextField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        dateChallanTextField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        romNoComboBox = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cellNoextField1 = new javax.swing.JTextField();
        studComboBox = new javax.swing.JComboBox();
        saveButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("   HOSTEL ROLL-NO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1010, 20, 250, 48);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("SELECT HOSTEL");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 70, 140, 40);

        hostelComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(hostelComboBox1);
        hostelComboBox1.setBounds(280, 70, 680, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("FACULTY");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 120, 80, 30);

        facultyComboBox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        facultyComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facultyComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(facultyComboBox);
        facultyComboBox.setBounds(280, 120, 680, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("DEPARTMENT");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 160, 130, 30);

        departmentComboBox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        departmentComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departmentComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(departmentComboBox);
        departmentComboBox.setBounds(280, 160, 680, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("PROGRAM");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(170, 200, 100, 30);

        programComboBox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        programComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                programComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(programComboBox);
        programComboBox.setBounds(280, 200, 680, 30);

        hostelList.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        hostelList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                hostelListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(hostelList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(970, 70, 370, 670);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("BATCH YEAR");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(150, 240, 120, 30);

        batchComboBox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        batchComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                batchComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(batchComboBox);
        batchComboBox.setBounds(280, 240, 140, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("SHIFT");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(460, 240, 100, 30);

        shiftComboBox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        shiftComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MORNING", "EVENING", "NOON" }));
        shiftComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                shiftComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(shiftComboBox);
        shiftComboBox.setBounds(530, 240, 170, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("GROUP");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(720, 240, 90, 30);

        groupComboBox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MEDICAL", "ENGINEERING", "COMMERCE", "GENERAL" }));
        groupComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                groupComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(groupComboBox);
        groupComboBox.setBounds(820, 240, 140, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("NAME");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(190, 320, 70, 40);

        partComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        partComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                partComboBox1ItemStateChanged(evt);
            }
        });
        getContentPane().add(partComboBox1);
        partComboBox1.setBounds(280, 280, 140, 30);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("ROLL-NO");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(440, 280, 90, 30);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("PART");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(200, 280, 70, 30);

        nameTextField.setEditable(false);
        nameTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nameTextField.setToolTipText("");
        getContentPane().add(nameTextField);
        nameTextField.setBounds(280, 320, 250, 30);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("FNAME");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(190, 360, 70, 40);

        fatherNameTextField.setEditable(false);
        fatherNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fatherNameTextField.setToolTipText("");
        getContentPane().add(fatherNameTextField);
        fatherNameTextField.setBounds(280, 360, 250, 30);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("SURNAME");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(170, 400, 90, 40);

        surNameTextField.setEditable(false);
        surNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        surNameTextField.setToolTipText("");
        getContentPane().add(surNameTextField);
        surNameTextField.setBounds(280, 400, 250, 30);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        AllotementTextField6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AllotementTextField6.setToolTipText("");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("ALLOTEMTNT ID");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("DATE OF ALLOTEMENT");

        dateOfAllotementTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dateOfAllotementTextField.setToolTipText("");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("DATE CHALAN");

        challanNoTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        challanNoTextField.setToolTipText("");
        challanNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                challanNoTextFieldActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("CHALAN-NO");

        amoutTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        amoutTextField.setToolTipText("");
        amoutTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amoutTextFieldActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("AMOUNT");

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("REMARKS");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        dateChallanTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dateChallanTextField.setToolTipText("");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("ROOM NO");

        romNoComboBox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        romNoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        romNoComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                romNoComboBoxItemStateChanged(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("UPDATE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setText("CLEAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(AllotementTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel17))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(jLabel19)))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dateOfAllotementTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(challanNoTextField))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(amoutTextField)
                            .addComponent(dateChallanTextField)
                            .addComponent(romNoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AllotementTextField6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateOfAllotementTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(amoutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(romNoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(challanNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateChallanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(170, 480, 670, 330);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("   HOSTEL ALLOTEMENT");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(370, 0, 559, 48);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("CELL-NO");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(170, 440, 90, 40);

        cellNoextField1.setEditable(false);
        cellNoextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cellNoextField1.setToolTipText("");
        getContentPane().add(cellNoextField1);
        cellNoextField1.setBounds(280, 440, 250, 30);

        studComboBox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        studComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                studComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(studComboBox);
        studComboBox.setBounds(530, 280, 170, 31);

        saveButton6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        saveButton6.setText("SAVE.CSV");
        saveButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(saveButton6);
        saveButton6.setBounds(1080, 760, 160, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void facultyComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facultyComboBoxItemStateChanged
       FacultyBean selectedBean = (FacultyBean) this.facultyComboBox.getSelectedItem();
        try {
            Vector vec = DBManager.getDepartment(selectedBean.getFacId());
            this.departmentComboBox.removeAllItems();
            for(int i = 0; i<vec.size(); i++){
                System.out.println(vec.elementAt(i));
                this.departmentComboBox.addItem(vec.elementAt(i));
            }

        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_facultyComboBoxItemStateChanged

    private void departmentComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departmentComboBoxItemStateChanged
        // TODO add your handling code here:
         DepartmentBean selectedBean = (DepartmentBean) this.departmentComboBox.getSelectedItem();
        if(selectedBean==null) return;
        try {
            Vector vec = DBManager.getProgram(selectedBean.getDeptId());
            this.programComboBox.removeAllItems();
            for(int i = 0; i<vec.size(); i++){
                System.out.println(vec.elementAt(i));
                this.programComboBox.addItem(vec.elementAt(i));
            }

        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_departmentComboBoxItemStateChanged

    private void programComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_programComboBoxItemStateChanged
        // TODO add your handling code here:
        
        ProgramsBean selectedBean = (ProgramsBean) this.programComboBox.getSelectedItem();

        if(selectedBean==null)return;
        try {
            Vector v = DBManager.getBatch(selectedBean.getProgId());
            this.batchComboBox.removeAllItems();
            for(int i = 0; i<v.size(); i++){
                this.batchComboBox.addItem(v.elementAt(i));
            }
        }catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_programComboBoxItemStateChanged

    private void batchComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchComboBoxItemStateChanged
        // TODO add your handling code here:
           BatchBean selectedBean = (BatchBean) this.batchComboBox.getSelectedItem();

        if(selectedBean==null)return;
        shiftComboBox.setSelectedItem(DatabaseManager.Decoder.shiftDecode(selectedBean.getShift()));
        groupComboBox.setSelectedItem(DatabaseManager.Decoder.groupDecode(selectedBean
            .getGroupDesc()));
    
         try {  
             
          Vector v = DBManager.getStudent(selectedBean.getBatchId());
          this.studComboBox.removeAllItems();
          for(int i=0; i<v.size(); i++){
            studComboBox.addItem(v.elementAt(i));
          }
            
         } catch (Exception ex) {
             Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    }//GEN-LAST:event_batchComboBoxItemStateChanged

    
    
    
    
    private void shiftComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_shiftComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_shiftComboBoxItemStateChanged

    private void groupComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_groupComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_groupComboBoxItemStateChanged

    private void partComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_partComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_partComboBox1ItemStateChanged

    private void romNoComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_romNoComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_romNoComboBoxItemStateChanged

    private void challanNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_challanNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_challanNoTextFieldActionPerformed

    private void studComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_studComboBoxItemStateChanged
        // TODO add your handling code here:
        
     StudentsBean  bean = (StudentsBean) studComboBox.getSelectedItem(); 
       if(bean==null)return;  
       //this.studentIdTextField.setText(""+bean.getStudId());
       this.nameTextField.setText(bean.getStudName());
       this.fatherNameTextField.setText(bean.getFname());
       this.surNameTextField.setText(bean.getSurName());
       //tis.rollNoTextField.setText(bean.getRollNo());
       this.remarksTextArea.setText(bean.getRemarks());
       cellNoextField1.setText(bean.getcellNo());
    }//GEN-LAST:event_studComboBoxItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        addRecord();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         updateRecord();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void hostelListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_hostelListValueChanged
        // TODO add your handling code here:
        
        
        HostelAllotementBean  bean = (HostelAllotementBean) hostelList.getSelectedValue();
        if(bean==null)return;
        
        this.AllotementTextField6.setText(""+bean.geAllotementId());
        
        
        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("dd/MM/yyyy");
        String dateStr=f.format(bean.getDateOfAllotement());
        String date=f.format(bean.gsetChallanDate());
        
        this.dateOfAllotementTextField.setText(""+dateStr);
        
        
        this.challanNoTextField.setText(""+bean.getChallanNo());
        this.dateChallanTextField.setText(""+date);
        this.amoutTextField.setText(""+bean.getChallanAmout());
        this.romNoComboBox.addItem(bean.getRoomNo());
        
         
    }//GEN-LAST:event_hostelListValueChanged

    private void amoutTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amoutTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amoutTextFieldActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        deleteRecord();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void saveButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton6ActionPerformed
         //TODO add your handling code here:
        
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(null);
        
      if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
        try {   
                FileWriter fw = new FileWriter(fileToSave);
                BufferedWriter bw = new BufferedWriter(fw);
                  
             
                     Vector v = DBManager.getHostelAllotement();
                   // this.studComboBox.removeAllItems();
                 for(int i=0; i<v.size(); i++){
                    bw.write(v.elementAt(i).toString());
                     bw.newLine();
                   }
                   
                   
                      
               bw.close();
                    fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                Logger.getLogger(Hostel_Allotement_Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
                JOptionPane.showMessageDialog(null, "Selected file to save: " + fileToSave.getAbsolutePath());
        }/// end of if 
        
    }//GEN-LAST:event_saveButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hostel_Allotement_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hostel_Allotement_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hostel_Allotement_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hostel_Allotement_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Hostel_Allotement_Frame().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Hostel_Allotement_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AllotementTextField6;
    private javax.swing.JTextField amoutTextField;
    private javax.swing.JComboBox batchComboBox;
    private javax.swing.JTextField cellNoextField1;
    private javax.swing.JTextField challanNoTextField;
    private javax.swing.JTextField dateChallanTextField;
    private javax.swing.JTextField dateOfAllotementTextField;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JTextField fatherNameTextField;
    private javax.swing.JComboBox groupComboBox;
    private javax.swing.JComboBox hostelComboBox1;
    private javax.swing.JList hostelList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JComboBox partComboBox1;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JComboBox romNoComboBox;
    private javax.swing.JButton saveButton6;
    private javax.swing.JComboBox shiftComboBox;
    private javax.swing.JComboBox studComboBox;
    private javax.swing.JTextField surNameTextField;
    // End of variables declaration//GEN-END:variables

    private class departmentComboBox {

        public departmentComboBox() {
        }
    }
}
