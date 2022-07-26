import java.awt.*;

import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;


public class BillDetails extends JFrame{
    
    BillDetails(String meter){

       setBounds(250,20,700,650);

       getContentPane().setBackground(Color.WHITE);

       JTable table = new JTable();

       try{
        Connectivity c=new Connectivity();
        String query ="select * from bill where meter_no ='"+meter+"'";
        ResultSet rs= c.s.executeQuery(query);
        table.setModel(DbUtils.resultSetToTableModel(rs));

       }catch (Exception e){
         e.printStackTrace();
       }

       JScrollPane sp= new JScrollPane(table);
       sp.setBounds(0,0,700,650);
       add(sp);

       setVisible(true);
   
    }

    public static void main(String[] args) {
        new BillDetails("");
    }
}
