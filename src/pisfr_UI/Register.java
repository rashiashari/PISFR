/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisfr_UI;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import pisfr_BLL.Detecting;
import pisfr_BLL.PreProcessing;
import pisfr_BLL.Util;
import pisfr_DL.DoctorDataBase;
import pisfr_DL.Doctors;

/**
 *
 * @author Rashini_Ashari
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
     //private static egister new doctor instance;
     private static final Logger logger = Logger.getLogger(Register.class.getName());
     FileHandler fhandler;
    FrameGrabber grabber;
    opencv_core.IplImage ipimg;
   OpenCVFrameConverter.ToIplImage converter=new OpenCVFrameConverter.ToIplImage();
    BufferedImage bImg,captured,result;
    BufferedImage histImg,custImage[];
    static int i,docid,noi;
    
    //public Register() {
     //   initComponents();
  //  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btncapture = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        labelNoimages = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtfield = new javax.swing.JTextField();
        txtmobile = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdays = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txtscode = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 204));
        setForeground(new java.awt.Color(0, 153, 204));

        jLabel5.setFont(new java.awt.Font("Sitka Banner", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Face Recognition For Patient Information System");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Please note after you have captured the image you have add images to the training and testing by clicking \"Adding for Training\"");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 293));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        btncapture.setBackground(new java.awt.Color(0, 153, 204));
        btncapture.setText("Capturing Face");
        btncapture.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btncapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncaptureActionPerformed(evt);
            }
        });

        btnadd.setBackground(new java.awt.Color(0, 153, 204));
        btnadd.setText("Adding for Training");
        btnadd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        labelNoimages.setText("No.of Images - ");

        jLabel7.setText("Capture 5 images from the user");

        jLabel.setText("Name");

        jLabel1.setText("Field of Specialist");

        jLabel2.setText("Mobile");

        jLabel3.setText("Channelling Days");

        txtdays.setColumns(20);
        txtdays.setRows(5);
        jScrollPane1.setViewportView(txtdays);

        jLabel8.setText("Secret Code");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfield)
                            .addComponent(txtmobile))))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtscode, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtscode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnsave.setBackground(new java.awt.Color(0, 153, 204));
        btnsave.setText("Save");
        btnsave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnnext.setBackground(new java.awt.Color(0, 153, 204));
        btnnext.setText("Next");
        btnnext.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btncapture, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(860, 860, 860)
                        .addComponent(labelNoimages, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btncapture, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(labelNoimages))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  public Register() {//constructor    
        initComponents();
        openWebcam();
        btnadd.setEnabled(false);
        i=0;//for adding to doctorImage
        noi=0;
        custImage=new BufferedImage[3];//the image array
        //txtdocid.setEditable(false);
        docid=newUserid();
        //generateAccount();
         try
        {
            fhandler = new FileHandler("C:\\PISFC\\Logger\\Logger.log", true);
            logger.addHandler(fhandler);
            SimpleFormatter formatter = new SimpleFormatter();  
            fhandler.setFormatter(formatter); 
        }
        catch(IOException e)
        {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }
    private void btncaptureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncaptureActionPerformed
     Detecting fobj=new Detecting();
        PreProcessing pobj=new PreProcessing();
        try 
        {
            captured=bImg;
            result=fobj.detectFace(captured);
            if(result!=null)
            {
                histImg=pobj.histogramEqualization(result);
               
                btnadd.setEnabled(true);
            }
            else
            {
                btnadd.setEnabled(false);
                JOptionPane.showMessageDialog(rootPane,"Try again please","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (HeadlessException e) 
        {
            logger.log(Level.SEVERE, e.getMessage(), e);
            JOptionPane.showMessageDialog(rootPane,"Error capturing "+e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
                                           

    }//GEN-LAST:event_btncaptureActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
 noi=noi+1;//count of images
        try
        {
            if(noi<6)
            {
                
                /*File output=new File(".\\trainingset\\"+uid+"_"+noi+".jpg");
                ImageIO.write(histImg,"jpg",output);
                writeId(uid);//method to write the labels
                labelNoimages.setText("No.of Images - "+noi);*/
                if(noi<=3)
                {
                        File output=new File("C:\\PISFC\\Training\\"+docid+"_"+noi+".jpg");
                    ImageIO.write(histImg,"jpg",output);
                    writeId(docid);//method to write the labels
                    labelNoimages.setText("No.of Images - "+noi);
                }
                else
                {
                    File output=new File("C:\\PISFC\\TestImg\\"+docid+"_"+noi+".jpg");
                    ImageIO.write(histImg,"jpg",output);
                    writeId(docid);//method to write the labels
                    labelNoimages.setText("No.of Images - "+noi);
                }
                if(noi==5)
                    JOptionPane.showMessageDialog(rootPane,"Training images Added","Added",JOptionPane.INFORMATION_MESSAGE);
                //i++;
            }
            else
                JOptionPane.showMessageDialog(rootPane,"You have added the images","Added",JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException | HeadlessException e)
        {
            logger.log(Level.SEVERE, e.getMessage(), e);
            JOptionPane.showMessageDialog(rootPane,"Could not add "+e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_btnaddActionPerformed
   /*private void generateAccount()//generate account number
    {
      
        String acc= "DOC0000";
        String num=String.valueOf(uid);
        txtdocid.setText(acc+num);
        txtdocid.setEditable(false);
    }*/
    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        if(txtname.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane,"Enter Name of the customer","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else if(txtfield.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane,"Enter Doctor Field","ERROR",JOptionPane.ERROR_MESSAGE);
        }
          else if(txtmobile.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane,"Enter Doctor Mobile","ERROR",JOptionPane.ERROR_MESSAGE);
        }
           else if(txtmobile.getText().length()!=10)
        {
            JOptionPane.showMessageDialog(rootPane,"Enter valid mobile no","ERROR",JOptionPane.ERROR_MESSAGE);
        }
            else if(txtdays.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane,"Enter Doctor Channeling Days","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else if(txtscode.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane,"Enter valid mobile no","ERROR",JOptionPane.ERROR_MESSAGE);
        }
       
        else if(noi<5)
        {
            JOptionPane.showMessageDialog(rootPane,"Capture images and add","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            Doctors uobj=new Doctors();
            try
            {
                DoctorDataBase duobj=new DoctorDataBase();
                uobj.setName(txtname.getText());
                uobj.setField(txtfield.getText());
                uobj.setChanellingdays(txtdays.getText());
                
                uobj.setMobile(Integer.parseInt(txtmobile.getText())); 
                uobj.setSecretCode(Integer.parseInt(txtscode.getText()));
                int row=duobj.addDoctors(uobj);
//                int row2=duobj.addDocdet(uobj);
                if(row>0&&row>0)
                {
                    JOptionPane.showMessageDialog(rootPane,"Created successfully","Created user",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(rootPane,"Please train the system","Created user",JOptionPane.INFORMATION_MESSAGE);
                    Trainig aobj=new Trainig();
                    aobj.show();
                    grabber.stop();
                    grabber.close();
                    this.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane,"Could not create user","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException | HeadlessException | FrameGrabber.Exception e)
            {
                logger.log(Level.SEVERE, e.getMessage(), e);
                JOptionPane.showMessageDialog(rootPane,"Could not create user"+e,"ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
       
    }//GEN-LAST:event_btnnextActionPerformed
 class captureImage implements Runnable{
        protected volatile boolean runn = false;
        protected volatile FrameGrabber gr;
        Util uobj=new Util();
        @Override
        public void run() {
            try
            {
                //grabber=new VideoInputFrameGrabber(0);
                grabber=new  OpenCVFrameGrabber(0);
                grabber.start();
                while(runn)
                {
                    Frame frame=grabber.grab();
                    ipimg=converter.convertToIplImage(frame);
                    if(ipimg!=null)
                    {
                        //cvFlip(ipimg, ipimg, 1);
                        bImg=uobj.ipltoBuffered(ipimg);
                        Graphics g=jPanel1.getGraphics();
                        if (g.drawImage(bImg, 0, 0, getWidth(), getHeight() -150 , 0, 0, bImg.getWidth(), bImg.getHeight(), null))
                        if(runn == false)
                        {
                            System.out.println("Going to wait()");
			    this.wait();
                        }
                    }
                }
            }
            catch(FrameGrabber.Exception | InterruptedException e)
            {
                logger.log(Level.WARNING,e.getMessage(),e);
            }
        }    
    }

    /**
     * @param args the command line arguments
     */
  /*public static FrameNewcustomer getInstance() {
        if (instance == null)
            instance = new FrameNewcustomer();

        return instance;
    }*/
    private void openWebcam()//method to show the webcam from the runnable class
    {
        captureImage capt=new captureImage();
        Thread t=new Thread(capt);
        t.setDaemon(true);
        capt.runn=true;
        t.start();
    }   
    private int newUserid()//gets user id for the new user
    {
        ResultSet rs=null;
        int tempid=0,usid=0;
        try
        {
            DoctorDataBase udobj=new DoctorDataBase();
            rs=udobj.getAlldetails();
            if(rs.next() == false)
            {
                System.out.println("Empty");
                usid=1;
            }
            else
            {
                do
                {
                    tempid=rs.getInt(4);
                }
                while(rs.next());
            }
            usid=tempid+1;
        }
        catch(SQLException e)
        {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
        return usid;
    }
      private void writeId(int id)//method to write the id
    {
        try
        {
            String text=String.valueOf(id)+",";
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\PISFC\\Training\\training.txt", true)));
            pw.print(text);
            pw.close();
        }
        catch(IOException e)
        {
           logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }
    
 
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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btncapture;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNoimages;
    private javax.swing.JTextArea txtdays;
    private javax.swing.JTextField txtfield;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtscode;
    // End of variables declaration//GEN-END:variables
}
