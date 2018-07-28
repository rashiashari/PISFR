/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisfr_DL;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rashini_Ashari
 */
public class AdminDataBase {
    public ResultSet login(Admin obj)
    {
        ResultSet rs=null;
        try
        {
            String SQL="select*from logindetails where userName='"+obj.getUsername()+"' and password='"+obj.getPassword()+"'";
            DB mycon=new DB();
            rs=mycon.getValues(SQL);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    
    public int addUser(Admin obj)
    {
        int row=0;
        try
        {
            String SQL="insert into loginDetails values(null,'"+obj.getUsername()+"','"+obj.getPassword()+"')";
            DB mycon=new DB();
            row=mycon.addValues(SQL);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return row;
    }
    
    public DefaultTableModel adminTable()/*method to view the book table*/
    {
        DefaultTableModel objtable=new DefaultTableModel();
        try
        {
            String SQL="select*from loginDetails";
            DB mycon=new DB();
            objtable=mycon.getTables(SQL);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return objtable;
    }
    
    
    public ResultSet getAlldetails()
    {
        ResultSet rs=null;
        try
        {
            String SQL="select*from loginDetails";
            DB mycon=new DB();
            rs=mycon.getValues(SQL);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    
}
