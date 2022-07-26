
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class ViewInformation extends JFrame implements ActionListener{


    JButton cancel;
    String meter;
    ViewInformation(String meter){

        this.meter=meter;

        setBounds(200,20,850,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel heading = new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(250,0,500,40);
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(70,80,100,20);
        add(lblname);

        JLabel name = new JLabel("");
        name.setBounds(250,80,100,20);
        add(name);

        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(70,140,100,20);
        add(lblmeternumber);

        JLabel meternumber = new JLabel(meter);
        meternumber.setBounds(250,140,100,20);
        add(meternumber);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(70,200,100,20);
        add(lbladdress);

        JLabel address = new JLabel("");
        address.setBounds(250,200,100,20);
        add(address);

        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(70,260,100,20);
        add(lblcity);

        JLabel city = new JLabel("");
        city.setBounds(250,260,100,20);
        add(city);


        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(500,80,100,20);
        add(lblstate);

        JLabel state = new JLabel("");
        state.setBounds(580,80,100,20);
        add(state);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(500,140,100,20);
        add(lblemail);

        JLabel email = new JLabel("");
        email.setBounds(580,140,200,20);
        add(email);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(500,200,100,20);
        add(lblphone);

        JLabel phone = new JLabel("");
        phone.setBounds(580,200,100,20);
        add(phone);

        try{
           Connectivity c=new Connectivity();
           ResultSet rs=c.s.executeQuery("select * from customer where meter_no ='"+meter+"'");

           while(rs.next())
           {
                name.setText(rs.getString("name"));
                address.setText(rs.getString("address"));
                city.setText(rs.getString("city"));
                state.setText(rs.getString("state"));
                email.setText(rs.getString("email"));
                phone.setText(rs.getString("phone"));      
           }
           
        } catch(Exception e){
            e.printStackTrace();
        }


        cancel=new JButton("Cancel");
        cancel.setBounds(320,320,150,30);
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.white);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        JLabel image=new JLabel(new ImageIcon(i2));
        image.setBounds(20,350,600,300);
        add(image);



        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        dispose();
    }
    public static void main(String[] args) {
        new ViewInformation("");
    }
}
