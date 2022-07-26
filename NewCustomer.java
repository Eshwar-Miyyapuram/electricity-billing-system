import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class NewCustomer extends JFrame implements ActionListener{
    

    JTextField tfname,tfaddress,tfcity,tfstate,tfemail,tfphone;
    JButton next,exit;
    JLabel lblmeter;
    NewCustomer(){
        setSize(700,500);
        setLocation(250,130);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        JLabel heading = new JLabel("New Customer");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.PLAIN, 24));
        p.add(heading);

        JLabel lblname= new JLabel("Customer Name");
        lblname.setBounds(100,80,100, 20);
        p.add(lblname);

        tfname= new JTextField();
        tfname.setBounds(240,80,200,20);
        p.add(tfname);

        JLabel lblmeterno= new JLabel("Meter Number");
        lblmeterno.setBounds(100,120,100, 20);
        p.add(lblmeterno);

        lblmeter= new JLabel("");
        lblmeter.setBounds(240,120,100, 20);
        p.add(lblmeter);

        Random random=new Random();
        long number = random.nextLong() % 1000000;
        lblmeter.setText(""+ Math.abs(number));
        
        JLabel lbladdress= new JLabel("Address");
        lbladdress.setBounds(100,160,100, 20);
        p.add(lbladdress);

        tfaddress= new JTextField();
        tfaddress.setBounds(240,160,200,20);
        p.add(tfaddress);


        JLabel lblcity= new JLabel("City");
        lblcity.setBounds(100,200,100, 20);
        p.add(lblcity);

        tfcity= new JTextField();
        tfcity.setBounds(240,200,200,20);
        p.add(tfcity);

        JLabel lblstate= new JLabel("State");
        lblstate.setBounds(100,240,100, 20);
        p.add(lblstate);

        tfstate= new JTextField();
        tfstate.setBounds(240,240,200,20);
        p.add(tfstate);


        JLabel lblemail= new JLabel("Email");
        lblemail.setBounds(100,280,100, 20);
        p.add(lblemail);

        tfemail= new JTextField();
        tfemail.setBounds(240,280,200,20);
        p.add(tfemail);

        JLabel lblphone= new JLabel("Mobile Number");
        lblphone.setBounds(100,320,100, 20);
        p.add(lblphone);

        tfphone= new JTextField();
        tfphone.setBounds(240,320,200,20);
        p.add(tfphone);

        next= new JButton("NEXT");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);


        exit= new JButton("CANCEL");
        exit.setBounds(290,390,100,25);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        p.add(exit);
        
        setLayout(new BorderLayout());
        add(p,"Center");

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2=i1.getImage().getScaledInstance(150,300, Image.SCALE_DEFAULT);
        JLabel image =new JLabel(new ImageIcon(i2));
        add(image,"West");
        getContentPane().setBackground(Color.WHITE);
        


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==next){

            String name=tfname.getText();
            String meter=lblmeter.getText();
            String address=tfaddress.getText();
            String city=tfcity.getText();
            String state=tfstate.getText();
            String email=tfemail.getText();
            String phone=tfphone.getText();

            String query1 ="insert into customer values('"+name+"', '"+meter+"', '"+address+"', '"+city+"', '"+state+"', '"+email+"', '"+phone+"')";
            String query2 = "insert into login values('"+meter+"', '', '"+name+"', '', '')";
            
            
            try{
                Connectivity c=new Connectivity();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);

                new MeterInfo(meter);

            } catch (Exception e){
                e.getStackTrace();
            }
        }
        else if(ae.getSource()==exit){
              dispose();
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
