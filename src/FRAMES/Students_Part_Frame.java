/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;

import BeanClasses.BatchBean;
import BeanClasses.DepartmentBean;
import BeanClasses.FacultyBean;
import BeanClasses.PartBean;
import BeanClasses.ProgramsBean;
import BeanClasses.StudPartBean;
import BeanClasses.StudentsBean;
import DatabaseManager.DBManager;
import DatabaseManager.Encode;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class Students_Part_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Students_Part_Frame
     */
    public Students_Part_Frame() {
        initComponents();
        getFaculty();
        getDepartment();
        getProgram();
        getStudentsPart();
        getStudRollNo();
       part();
        java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        this.setBounds(0,0,d.width,d.height);
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
    
   
    
   private void getStudentsPart(){
     // BatchBean selectedBean = (BatchBean) this.batchComboBox.getSelectedItem();
      //if(selectedBean==null)return;  
      try {
            //int batchId = selectedBean.getBatchId();
            Vector v = DBManager.getStudPart();   
            this.rollNoList.setListData(v);
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   private void getStudRollNo(){
   
          BatchBean selectedBean = (BatchBean) this.batchComboBox.getSelectedItem();
        if(selectedBean==null)return;  
      try {
            int batchId = selectedBean.getBatchId();
            Vector v = DBManager.getStudent(batchId);   
           
            for(int i=0; i<v.size(); i++){
            this.studComboBox.addItem(v.elementAt(i));
            }
           }
         catch (Exception ex) {
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
   
   
  private void clear(){
  
      this.remarksTextArea.setText(" ");
  
  }   
    
    
    
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        rollNoList = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        shiftComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        batchComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        groupComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        pastButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        studComboBox = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        partComboBox1 = new javax.swing.JComboBox();
        partComboBox2 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox();
        clearButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("STUDENTS PART REGISTRATON");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 540, 40));

        departmentComboBox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        departmentComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departmentComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 680, 40));

        rollNoList.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rollNoList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                rollNoListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(rollNoList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 90, 350, 550));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("FACULTY");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 130, 40));

        facultyComboBox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        facultyComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facultyComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 680, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("DEPARTMENT");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 150, 30));

        shiftComboBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        shiftComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MORNING", "EVENING", "NOON" }));
        getContentPane().add(shiftComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 110, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("SHIFT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 60, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("PROGRAM");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 150, 30));

        programComboBox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        programComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                programComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(programComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 680, 40));

        batchComboBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        batchComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                batchComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(batchComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 110, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("BATCH YEAR");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 120, 40));

        groupComboBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MEDICAL", "ENGINEERING", "COMMERCE", "GENERAL" }));
        getContentPane().add(groupComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 100, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("GROUP");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 80, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("REMARKS");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 100, -1));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 670, 220));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("STUDENTS");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 120, 40));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 670, 200, 50));

        addButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 680, 120, 40));

        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 680, 130, 40));

        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 680, 120, 40));

        pastButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        pastButton.setText("PAST");
        pastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pastButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 680, 120, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ROLL-NO");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(997, 30, 240, -1));

        studComboBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        studComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                studComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(studComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 160, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("PART");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 80, 50));

        partComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(partComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 130, 40));

        partComboBox2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        partComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        getContentPane().add(partComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 130, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("STATUS");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 100, 40));

        statusComboBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TEMPORARY", "PERMANENT" }));
        statusComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statusComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(statusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 340, 160, 40));

        clearButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        clearButton2.setText("CLEAR");
        clearButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 680, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void rollNoListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_rollNoListValueChanged
  
        
//       StudPartBean  bean = (StudPartBean) rollNoList.getSelectedValue();  
//        if(bean==null)return;   
//         try {  
//             
//          Vector v = DBManager.getPart(bean.getBatchId());
//          partComboBox1.removeAllItems();
//          for(int i=0; i<v.size(); i++){
//          
//              partComboBox1.addItem(v.elementAt(i));
//          }
//            
//         } catch (Exception ex) {
//             Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
//         }  
        
       StudPartBean  bean = (StudPartBean) rollNoList.getSelectedValue();  
        if(bean==null)return;   
       
        this.remarksTextArea.setText(bean.getRemarks());
        

    }//GEN-LAST:event_rollNoListValueChanged

    private void facultyComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facultyComboBoxItemStateChanged
        // TODO add your handling code here:
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.hide();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        try{
            addRecord();
        }catch(NullPointerException e){e.printStackTrace();}
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        updateRecord();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
       deleteRecord();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void pastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastButtonActionPerformed
        try {
            // TODO add your handling code here:
            past();
        } catch (Exception ex) {
            Logger.getLogger(Students_Part_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pastButtonActionPerformed

    private void studComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_studComboBoxItemStateChanged
        // TODO add your handling code here:
        
//         BatchBean selectedBean = (BatchBean) this.batchComboBox.getSelectedItem();
//      if(selectedBean==null)return;  
//      try {
//            int batchId = selectedBean.getBatchId();
//            Vector v = DBManager.getStudent(batchId);   
//            for(int i=0; i<v.size(); i++){      
//            this.studComboBox.addItem(v.elementAt(i));
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
 
    }//GEN-LAST:event_studComboBoxItemStateChanged

    private void statusComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statusComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboBoxItemStateChanged

    private void clearButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Students_Part_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Students_Part_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Students_Part_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Students_Part_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Students_Part_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox batchComboBox;
    private javax.swing.JButton clearButton2;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JComboBox groupComboBox;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JComboBox partComboBox1;
    private javax.swing.JComboBox partComboBox2;
    private javax.swing.JButton pastButton;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JList rollNoList;
    private javax.swing.JComboBox shiftComboBox;
    private javax.swing.JComboBox statusComboBox;
    private javax.swing.JComboBox studComboBox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private void addRecord() {
       BatchBean selectedBean = (BatchBean)this.batchComboBox.getSelectedItem();
        if(selectedBean==null)return;
        
          int batchId = selectedBean.getBatchId();

               
          PartBean pab=(PartBean)partComboBox1.getSelectedItem(); 
           StudentsBean bea=(StudentsBean)studComboBox.getSelectedItem();
           String remarks = remarksTextArea.getText();
           String stbean=(String)statusComboBox.getSelectedItem(); 
          
        try {
            int row = DBManager.addStudPart(batchId,pab.getPart(),bea.getRollNo(),remarks,stbean);
           
           
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
           getStudentsPart();
           clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
      
    
    
    
    }

    private void updateRecord() {
       PartBean  bean = (PartBean) partComboBox1.getSelectedItem();  
         StudentsBean bea=(StudentsBean)studComboBox.getSelectedItem();
         BatchBean batchbean=(BatchBean)batchComboBox.getSelectedItem();
         
        if(bea==null)return;        
        try {
           
            int row = DBManager.updateStudPart(bean.getPart(),bea.getRollNo(),remarksTextArea.getText());
            
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
              getStudentsPart();
              clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(FacultyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void deleteRecord() {
                 
      PartBean  beans = (PartBean) partComboBox1.getSelectedItem(); 
       if(beans==null)return;
              
        try {
            
            int row = DBManager.deleteStudPart(beans.getPart());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
              getStudentsPart();
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(FacultyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
    
    
    
    
    private void past(){
           PartBean  partbeans = (PartBean) partComboBox1.getSelectedItem(); 
            if(partbeans==null)return;                
            int rows=0;
            int count=studComboBox.getItemCount();

          for(int i=0; i<count; i++){
              
              String remarks = remarksTextArea.getText();
             String stbean=(String)statusComboBox.getSelectedItem();
             StudentsBean studBean = (StudentsBean)studComboBox.getItemAt(i); 
             try{
               rows+= DBManager.addStudPart(partbeans.getBatchId(),partbeans.getPart(),studBean.getRollNo(),remarks,stbean);   
             }catch(Exception e){
               e.printStackTrace();
             }
             
             }
                     
           if(rows>0){
               JOptionPane.showMessageDialog(null,rows+"PAST RECORD  SUCCESSFULLY");
               getStudentsPart();
            //clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
    }
    
    
    
    
    

   

    private class partYearTextField {

        public partYearTextField() {
        }
    }
}
