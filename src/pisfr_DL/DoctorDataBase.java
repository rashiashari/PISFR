/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisfr_DL;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rashini_Ashari
 */
public class DoctorDataBase {
    public int addDoctors(Doctors obj)
    {
        int row=0;
        try
        {
            String SQL="INSERT INTO doctordetails(Doc_Name,Doc_Field,Doc_Cdays,Doc_Mobile,Doc_SCode) VALUES('"+obj.getName()+"','"+obj.getField()+"','"+obj.getChanellingdays()+"',"
                    + "'"+obj.getMobile()+"','"+obj.getSecretCode()+"')";
            DB mycon=new DB();
            row=mycon.addValues(SQL);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return row;
    }
    
  /*  public int addDocdet(Doctors obj)
    {
        int row=0;
        try
        {
            String SQL="INSERT INTO docdetails VALUES((SELECT MAX(ID) FROM doctordetails),"+obj.getDocid()+")";
            DB mycon=new DB();
            row=mycon.addValues(SQL);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return row;
    }*/
    
    public ResultSet getDetails(Doctors obj)
    {
        ResultSet rs=null;
        try
        {
            String SQL="select*from doctordetails where ID="+obj.getID()+"";
            DB mycon=new DB();
            rs=mycon.getValues(SQL);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getDocdetails(Doctors obj)
    {
        ResultSet rs=null;
        try
        {
            String SQL="select*from docdetails where ID="+obj.getID()+"";
            DB mycon=new DB();
            rs=mycon.getValues(SQL);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    

    
    public ResultSet getAlldetails()
    {
        ResultSet rs=null;
        try
        {
            String SQL="select*from doctordetails";
            DB mycon=new DB();
            rs=mycon.getValues(SQL);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
        public ResultSet getLoginDetails(Doctors obj)
    {
        ResultSet rs=null;
        try
        {
            String SQL="select*from doctordetails where ID="+obj.getID()+" and Doc_SCode="+obj.getSecretCode()+"";
            DB mycon=new DB();
            rs=mycon.getValues(SQL);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    public DefaultTableModel doctorTable()
    {
        DefaultTableModel objtable=new DefaultTableModel();
        try
        {
            String SQL="select*from doctordetails";
            DB mycon=new DB();
            objtable=mycon.getTables(SQL);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error connecting database  "+e);
        }
        return objtable;
    }
    
    public DefaultTableModel docdetailsTable()
    {
        DefaultTableModel objtable=new DefaultTableModel();
        try
        {
            String SQL="select*from docdetails";
            DB mycon=new DB();
            objtable=mycon.getTables(SQL);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error connecting database  "+e);
        }
        return objtable;
    }
    
    public int updateDoctors(Doctors obj)
    {
        int row=0;
        try
        {
            String SQL="update doctordetails set Doc_Name='"+obj.getName()+"',Doc_Field='"+obj.getField()+"',Doc_Cdays='"+obj.getChanellingdays()+"',Doc_Mobile='"+obj.getMobile()+"',"
                    + "Doc_SCode="+obj.getSecretCode()+" where ID="+obj.getID()+"";
            DB mycon=new DB();
            row=mycon.addValues(SQL);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return row;
    }
    
    
}
