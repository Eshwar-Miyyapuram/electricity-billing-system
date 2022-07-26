import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.*;

public class SignUp extends JFrame implements ActionListener{

    JButton exit,create;
    Choice accountType;
    JTextField username,name,password,lblmeterno;
    SignUp(){


        setSize(700,400);
        setLocation(350,150);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel panel= new JPanel();
        panel.setBounds(30, 30, 650,300);
        panel.setBorder(new TitledBorder(new LineBorder(Color.CYAN), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, Color.CYAN));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));
        add(panel);


        JLabel heading = new JLabel("Create Account As");
        heading .setBounds(100,50,140,20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading);

        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260,50,150,20);
        panel.add(accountType);

        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100,90,140,20);
        lblmeter.setForeground(Color.GRAY);
        lblmeter.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblmeter.setVisible(false);
        panel.add(lblmeter);

        lblmeterno= new JTextField();
        lblmeterno.setBounds(260,90, 150, 20);
        panel.add(lblmeterno);
        lblmeterno.setVisible(false);

        
        //username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100,130,140,20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblusername);

        username= new JTextField();
        username.setBounds(260,130, 150, 20);
        panel.add(username);

 
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100,170,140,20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblname);

        name= new JTextField();
        name.setBounds(260,170, 150, 20);
        panel.add(name);

        lblmeterno.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent fe){}

            public void focusLost(FocusEvent fe){
               try{

                   Connectivity c= new Connectivity();
                   ResultSet rs=c.s.executeQuery("select * from login where meter_no = '"+lblmeterno.getText()+"'");
                   while(rs.next())
                   {
                       name.setText(rs.getString("name"));
                   }
                   
               }catch(Exception ae){
                   ae.printStackTrace();
               }
            }
       });

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100,210,140,20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblpassword);

        password= new JTextField();
        password.setBounds(260,210, 150, 20);
        panel.add(password);

        accountType.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                String user=accountType.getSelectedItem();
                if(user.equals("Customer"))
                {
                    lblmeter.setVisible(true);
                    lblmeterno.setVisible(true);
                    name.setEditable(false);
                }
                else{
                    lblmeter.setVisible(false);
                    lblmeterno.setVisible(false);
                    name.setEditable(true);
                }
            }
        });


        create = new JButton("CREATE");
        create.setBounds(140,260,120,25);
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.addActionListener(this);
        panel.add(create);


        exit = new JButton("EXIT");
        exit.setBounds(280,260,120,25);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        panel.add(exit);


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2=i1.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(415,30,250,250);
        panel.add(image);



        setVisible(true);


    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == create)
        {
             String atype=accountType.getSelectedItem();
             String custusername=username.getText();
             String custname=name.getText();
             String custpassword=password.getText();
             String custmeter=lblmeterno.getText();

             try{
                  Connectivity c = new Connectivity();
                  String query = null;
                  if(atype.equals("Admin"))
                  {
                    query="insert into login values('"+custmeter+"', '"+custusername+"', '"+custname+"', '"+custpassword+"', '"+atype+"')";
                  }else{
                    
                    query="update login set username = '"+custusername+"', password= '"+custpassword+"', user = '"+atype+"' where meter_no = '"+custmeter+"'";
                  }
                  c.s.executeUpdate(query);
                  JOptionPane.showMessageDialog(null, "Account Created Successfully");
                  setVisible(false);
                   new Login();
             } catch (Exception e){
                e.printStackTrace();
             }
        }
        else if(ae.getSource() == exit)
        {
               dispose();
               new Login();
        }

    }
    
    public static void main(String[] args) {
        new SignUp();
    }
}
