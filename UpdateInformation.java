import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class UpdateInformation extends JFrame implements ActionListener{


    JTextField state,email,phone,city,address;

    JButton update,cancel;

    String meter;

    UpdateInformation(String meter){

           this.meter=meter;

          setBounds(130,150,1050,450);
          getContentPane().setBackground(Color.WHITE);
          setLayout(null);

        JLabel heading = new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setBounds(110,0,400,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,70,100,20);
        add(lblname);

        JLabel name = new JLabel("");
        name.setBounds(230,70,200,20);
        add(name);

        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(30,110,100,20);
        add(lblmeternumber);

        JLabel meternumber = new JLabel("");
        meternumber.setBounds(230,110,200,20);
        add(meternumber);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30,150,100,20);
        add(lbladdress);

        address = new JTextField("");
        address.setBounds(230,150,200,20);
        add(address);

        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(30,190,100,20);
        add(lblcity);

        city = new JTextField("");
        city.setBounds(230,190,200,20);
        add(city);


        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(30,230,100,20);
        add(lblstate);

        state = new JTextField("");
        state.setBounds(230,230,200,20);
        add(state);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30,270,100,20);
        add(lblemail);

        email = new JTextField("");
        email.setBounds(230,270,200,20);
        add(email);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,310,100,20);
        add(lblphone);

        phone = new JTextField("");
        phone.setBounds(230,310,200,20);
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
                meternumber.setText(rs.getString("meter_no"));

           }
           
        } catch(Exception e){
            e.printStackTrace();
        }
        update=new JButton("Update");
        update.setBounds(70,360,100,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        add(update);
        update.addActionListener(this);

        cancel=new JButton("Cancel");
        cancel.setBounds(230,360,100,25);
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.white);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        JLabel image=new JLabel(new ImageIcon(i2));
        image.setBounds(20,350,600,300);
        add(image);

        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i4=i3.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        JLabel image2=new JLabel(new ImageIcon(i4));
        image2.setBounds(550,50,400,300);
        add(image2);
        
        setVisible(true);

    }
    


    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==update){

            String uaddress=address.getText();
            String ucity=city.getText();
            String ustate=state.getText();
            String uemail=email.getText();
            String uphone=phone.getText();


            try{

            Connectivity c=new Connectivity();
            System.out.print(7);
            String query= "update customer set address = '"+uaddress+"', city= '"+ucity+"', state = '"+ustate+"', email = '"+uemail+"', phone='"+uphone+"' where meter_no = '"+meter+"'";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "User Information Updated Successfully");
            setVisible(false);

            } catch(Exception e){
                 e.printStackTrace();
            }

        }
        else{
            dispose();
        }
    }


    public static void main(String[] args) {
        new UpdateInformation("");
    }
}
