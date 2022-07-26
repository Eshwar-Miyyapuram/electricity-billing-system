import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class CustomerDetails extends JFrame implements ActionListener{

    Choice meternumber,cmonth;
    JTable table;
    JButton search,print;
    CustomerDetails(){

        super("Customer Details");

        setBounds(50,0,1200,650);

        table=new JTable();

        try{
            Connectivity c=new Connectivity();
            ResultSet rs=c.s.executeQuery("select * from customer");

            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane sp=new JScrollPane(table);
        add(sp);

        print =new JButton("Print");
        print.setBackground(Color.green);
        print.addActionListener(this);
        add(print, "South");







        setVisible(true);



    }

    public void actionPerformed(ActionEvent ae){
             try{
                 table.print();
             } catch(Exception e){
                e.printStackTrace();
             }
    }
    public static void main(String[] args) {
        new CustomerDetails();
    }
    
}