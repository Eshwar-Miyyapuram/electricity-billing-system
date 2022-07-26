import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class CalculateBill extends JFrame implements ActionListener{
    

    JTextField tfname,tfunits,tfstate,tfemail,tfphone;
    JButton next,exit;
    JLabel lblname,labeladdress;
    Choice meternumber, cmonth;
    CalculateBill(){
        setSize(700,500);
        setLocation(250,130);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(160,10,300,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN, 24));
        p.add(heading);

        JLabel lblmeternumber= new JLabel("Meter Number");
        lblmeternumber.setBounds(100,80,100, 20);
        p.add(lblmeternumber);

        meternumber= new Choice();
        try{
              Connectivity c=new Connectivity();
              ResultSet rs =c.s.executeQuery("select * from customer");
              while(rs.next()){
                meternumber.add(rs.getString("meter_no"));
              }

        }catch(Exception e){
              e.printStackTrace();
        }
        meternumber.setBounds(240,80,200, 20);
        p.add(meternumber);

        JLabel lblmeterno= new JLabel("Name");
        lblmeterno.setBounds(100,120,100, 20);
        p.add(lblmeterno);

        lblname= new JLabel("");
        lblname.setBounds(240,120,100, 20);
        p.add(lblname);

        
        JLabel lbladdress= new JLabel("Address");
        lbladdress.setBounds(100,160,100, 20);
        p.add(lbladdress);

        labeladdress= new JLabel("");
        labeladdress.setBounds(240,160,200,20);
        p.add(labeladdress);
        

        try{
            Connectivity c=new Connectivity();
            ResultSet rs = c.s.executeQuery("Select * from customer where meter_no ='"+meternumber.getSelectedItem()+"'");
           while(rs.next()){
            lblname.setText(rs.getString("name"));
            labeladdress.setText(rs.getString("address"));

           }
            
        }catch(Exception e){

            e.printStackTrace();
        }

        meternumber.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Connectivity c=new Connectivity();
                    ResultSet rs = c.s.executeQuery("Select * from customer where meter_no ='"+meternumber.getSelectedItem()+"'");
                   while(rs.next()){
                    lblname.setText(rs.getString("name"));
                    labeladdress.setText(rs.getString("address"));
        
                   }
                    
                }catch(Exception e){
        
                    e.printStackTrace();
                } 
            }
        });

        JLabel lblcity= new JLabel("Units Consumed");
        lblcity.setBounds(100,200,100, 20);
        p.add(lblcity);

        tfunits= new JTextField();
        tfunits.setBounds(240,200,200,20);
        p.add(tfunits);

        JLabel lblstate= new JLabel("Month");
        lblstate.setBounds(100,240,100, 20);
        p.add(lblstate);

        cmonth= new Choice();
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");

        cmonth.setBounds(240,240,200,20);
        p.add(cmonth);


        next= new JButton("Submit");
        next.setBounds(120,350,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);


        exit= new JButton("Cancel");
        exit.setBounds(290,350,100,25);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        p.add(exit);
        
        setLayout(new BorderLayout());
        add(p,"Center");

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2=i1.getImage().getScaledInstance(150,300, Image.SCALE_DEFAULT);
        JLabel image =new JLabel(new ImageIcon(i2));
        add(image,"West");
        getContentPane().setBackground(Color.WHITE);
        


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==next){
            String meter=meternumber.getSelectedItem();
            String units=tfunits.getText();
            String month=cmonth.getSelectedItem();

            int totalbill=0;
            int units_consumed=Integer.parseInt(units);

            String query ="select * from tax";
              
            try{
                Connectivity c=new Connectivity();
                ResultSet rs= c.s.executeQuery(query);

                while(rs.next()){
                    totalbill+=units_consumed*Integer.parseInt(rs.getString("cost_per_unit"));
                    totalbill+=Integer.parseInt(rs.getString("meter_rent"));
                    totalbill+=Integer.parseInt(rs.getString("service_charge"));
                    totalbill+=Integer.parseInt(rs.getString("service_tax"));
                    totalbill+=Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    totalbill+=Integer.parseInt(rs.getString("fixed_tax"));
                }

                
            } catch (Exception e){
                e.getStackTrace();
            }

            String query2 = "insert into bill values('"+meter+"', '"+month+"', '"+units+"', '"+totalbill+"', 'Not Paid');";

            try{
                Connectivity c=new Connectivity();
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false);


            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==exit){
              dispose();
        }
    }

    public static void main(String[] args) {
        new CalculateBill();
    }
}
