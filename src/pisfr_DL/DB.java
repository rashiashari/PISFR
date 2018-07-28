/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisfr_DL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rashini_Ashari
 */
public class DB {
      public Connection createConnection()//method to create connection
    {
        Connection con=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/pisfr?verifyServerCertificate=false&useSSL=true","root","");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
    
    public int addValues(String SQL)//method to add values to add to database
    {
        int row=0;
        try
        {
            Connection con=createConnection();
            Statement stat=con.createStatement();
            row=stat.executeUpdate(SQL);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return row;
    }
    
    public ResultSet getValues(String SQL)// method to retrieve values from the database
    {
        ResultSet rs=null;
        try
        {
            Connection con=createConnection();
            Statement stat=con.createStatement();
            rs=stat.executeQuery(SQL);
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        return rs;
    }
    
    
    public DefaultTableModel getTables(String SQL)//to view the  table
    {
        DefaultTableModel objtable=new DefaultTableModel();
        try
        {
            Connection con=createConnection();
            Statement stat=con.createStatement();
            ResultSet rs=stat.executeQuery(SQL);
            ResultSetMetaData rsmeta=rs.getMetaData();
            int columns=rsmeta.getColumnCount();
            
            Vector Columnname=new Vector();
            for(int i=1;i<=columns;i++)
            {
                Columnname.addElement(rsmeta.getColumnName(i));
            }
            
            objtable.setColumnIdentifiers(Columnname);
            Vector DataRows=new Vector();
            while(rs.next())
            {
                DataRows=new Vector();
                for(int r=1;r<=columns;r++)
                {
                    DataRows.addElement(rs.getString(r));
                }
                objtable.addRow(DataRows);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error connecting to database"+e);
        }
        return objtable;
    }
    
}
