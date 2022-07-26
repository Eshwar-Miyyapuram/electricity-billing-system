import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class PayBill extends JFrame implements ActionListener{
    
    JButton pay,back;
    Choice cmonth;
    String meter;
    PayBill(String meter){
      this.meter=meter;
      setLayout(null);
      setBounds(150,50,900,600);

      JLabel heading = new JLabel("Electricity Bill");
      heading.setFont(new Font("Tahoma",Font.BOLD,24));
      heading.setBounds(120,5,400,30);
      add(heading);

      JLabel lblmeternumber = new JLabel("Meter Number");
      lblmeternumber.setBounds(35,80,200,20);
      add(lblmeternumber);

      JLabel meternumber = new JLabel("");
      meternumber.setBounds(300,80,200,20);
      add(meternumber);


      JLabel lblname = new JLabel("Name");
      lblname.setBounds(35,140,200,20);
      add(lblname);

      JLabel name = new JLabel("");
      name.setBounds(300,140,200,20);
      add(name);

      JLabel lblmonth = new JLabel("Month");
      lblmonth.setBounds(35,200,200,20);
      add(lblmonth);

      cmonth = new Choice();
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
        cmonth.setBounds(300,200,200,20);
        add(cmonth);

        JLabel lblunits = new JLabel("Units");
        lblunits.setBounds(35,260,200,20);
      add(lblunits);

      JLabel units = new JLabel("");
      units.setBounds(300,260,200,20);
      add(units);

      JLabel lbltotalbill = new JLabel("Total Bill");
      lbltotalbill.setBounds(35,320,200,20);
      add(lbltotalbill);

      JLabel totalbill = new JLabel("");
      totalbill.setBounds(300,320,200,20);
      add(totalbill);

      JLabel lblstatus = new JLabel("Status");
      lblstatus.setBounds(35,380,200,20);
      add(lblstatus);

      JLabel status = new JLabel("");
      status.setBounds(300,380,200,20);
      status.setForeground(Color.RED);
      add(status);

      try {
        Connectivity c=new Connectivity();
        ResultSet rs= c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
        if(rs.next())
        {
            meternumber.setText(rs.getString("meter_no"));
            name.setText(rs.getString("name"));
        }
        ResultSet rs2= c.s.executeQuery("select * from bill where meter_no = '"+meter+"' and month='January'");
        if(rs.next())
        {
            units.setText(rs2.getString("units"));
            totalbill.setText(rs2.getString("totalbill"));
            status.setText(rs2.getString("status"));
        }
      }catch(Exception e){

        e.printStackTrace();
      }

      cmonth.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent ae){
            try {
                Connectivity c=new Connectivity();
                ResultSet rs2= c.s.executeQuery("select * from bill where meter_no = '"+meter+"' and month='"+cmonth.getSelectedItem()+"'");
                if(rs2.next())
                {
                    units.setText(rs2.getString("units"));
                    totalbill.setText(rs2.getString("totalbill"));
                    status.setText(rs2.getString("status"));
                }
              }catch(Exception e){
        
                e.printStackTrace();
              }
        }
      });
         
      pay = new JButton("Pay");
      pay.setBackground(Color.BLACK);
      pay.setForeground(Color.WHITE);
      pay.setBounds(100,460,100,25);
      pay.addActionListener(this);
      add(pay);

      back = new JButton("Cancel");
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.setBounds(300,460,100,25);
      back.addActionListener(this);
      add(back);
      
      getContentPane().setBackground(Color.WHITE);

      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
      Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
      JLabel image= new JLabel(new ImageIcon(i2));
      image.setBounds(400,120,600,300);
      add(image);
      setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==pay){

            try{

                Connectivity c= new Connectivity();
                c.s.executeUpdate("update bill set status = 'Paid' where meter_no = '"+meter+"' and month='"+cmonth+"'");

            }catch (Exception e){
                e.printStackTrace();
            }
            setVisible(false);
            new Paytm(meter);

        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new PayBill("");
    }
}
