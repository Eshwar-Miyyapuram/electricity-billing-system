import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Project extends JFrame implements ActionListener{

    String meter;
    
    Project(String atype, String meter){

        this.meter=meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        JLabel i3= new JLabel(new ImageIcon(i2));
        add(i3);
        
        JMenuBar mb= new JMenuBar();
        setJMenuBar(mb);

        JMenu master = new JMenu("Master");
        master.setForeground(Color.BLUE);

        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced", Font.PLAIN, 12));
        newcustomer.setBackground(Color.WHITE);
        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image i5=i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(i5));
        newcustomer.addActionListener(this);
        master.add(newcustomer);

        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        customerdetails.setBackground(Color.WHITE);
        ImageIcon i6= new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image i7=i6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(i7));
        customerdetails.addActionListener(this);
        master.add(customerdetails);

        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        depositdetails.setBackground(Color.WHITE);
        ImageIcon i8= new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image i9=i8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(i9));
        depositdetails.addActionListener(this);
        master.add(depositdetails);

        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced", Font.PLAIN, 12));
        calculatebill.setBackground(Color.WHITE);
        ImageIcon i10= new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image i11=i10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(i11));
        calculatebill.addActionListener(this);
        master.add(calculatebill);


        JMenu info = new JMenu("Information");
        info.setForeground(Color.BLUE);
        

        JMenuItem updateinformation = new JMenuItem("Update Information");
        updateinformation.setFont(new Font("monospaced", Font.PLAIN, 12));
        updateinformation.setBackground(Color.WHITE);
        ImageIcon i12= new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image i13=i12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateinformation.setIcon(new ImageIcon(i13));
        updateinformation.addActionListener(this);
        info.add(updateinformation);

        JMenuItem viewinformation = new JMenuItem("View Information");
        viewinformation.setFont(new Font("monospaced", Font.PLAIN, 12));
        viewinformation.setBackground(Color.WHITE);
        ImageIcon i14= new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image i15=i14.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinformation.setIcon(new ImageIcon(i15));
        viewinformation.addActionListener(this);
        info.add(viewinformation);


        JMenu user = new JMenu("User");
        user.setForeground(Color.BLUE);
        

        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced", Font.PLAIN, 12));
        paybill.setBackground(Color.WHITE);
        ImageIcon i16= new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image i17=i16.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(i17));
        paybill.addActionListener(this);
        user.add(paybill);

        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        billdetails.setBackground(Color.WHITE);
        ImageIcon i18= new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image i19=i18.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(i19));
        billdetails.addActionListener(this);
        user.add(billdetails);

        JMenu report = new JMenu("Report");
        report.setForeground(Color.BLUE);
        

        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("monospaced", Font.PLAIN, 12));
        generatebill.setBackground(Color.WHITE);
        ImageIcon i20= new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image i21=i20.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(i21));
        generatebill.addActionListener(this);
        report.add(generatebill);


        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced", Font.PLAIN, 12));
        notepad.setBackground(Color.WHITE);
        ImageIcon i22= new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image i23=i22.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(i23));
        notepad.addActionListener(this);
        utility.add(notepad);


        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced", Font.PLAIN, 12));
        calculator.setBackground(Color.WHITE);
        ImageIcon i24= new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image i25=i24.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(i25));
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);

        JMenuItem exitt=new JMenuItem("EXIT  X");
        exitt.addActionListener(this);
        exit.add(exitt);



        // mb.add(master);
        if(atype.equals("Admin"))
        {
            mb.add(master);
        }else{
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        mb.add(utility);
        mb.add(exit);

        // JMenuItem mexit = new JMenuItem("Exit");
        // mexit.setFont(new Font("monospaced", Font.PLAIN, 12));
        // mexit.setBackground(Color.WHITE);
        // mexit i26= new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        // Image i27=i26.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        // mexit.setIcon(new ImageIcon(i27));
        // utility.add(mexit);


        setLayout(new FlowLayout());

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
         String msg =ae.getActionCommand();
         if(msg.equals("New Customer")){

               new NewCustomer();

         }else if(msg.equals("Customer Details")){
         
            new CustomerDetails();
        
        }else if(msg.equals("Deposit Details")){

            new DepositDetails();

        }else if(msg.equals("Calculate Bill")){
         
            new CalculateBill();
        
        }else if(msg.equals("View Information")){
            new ViewInformation(meter);
        }
        else if(msg.equals("Update Information")){
            new UpdateInformation(meter);
        }else if(msg.equals("Bill Details")){
            new BillDetails(meter);
        }else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
               e.printStackTrace();
            }
        }else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            }

        } else if(msg.equals("EXIT  X")){
            setVisible(false);
            new Login();
        }
        else if(msg.equals("Pay Bill")){
            new PayBill(meter);
        }
        else if(msg.equals("Generate Bill")){
            new GenerateBill(meter);
        }
    }

    public static void main(String[] args) {
        new Project("","");
    }
}
