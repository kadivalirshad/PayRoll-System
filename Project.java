
package payroll_system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;      
public class Project extends JFrame implements ActionListener {
     JMenuBar mb;
     JLabel l1;
     JMenu m1,m2,m3,m4,m5,m6;
     Project()
     {
        setVisible(true);
        setSize(2000,1100);
        setDefaultCloseOperation(3);
        setLayout(new FlowLayout());
        setTitle("PayRoll System");
        getContentPane().setBackground(Color.white);  
       
        ImageIcon ig=new ImageIcon(ClassLoader.getSystemResource("Image/payroll.jpg"));
        Image i0=ig.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        l1=new JLabel(new ImageIcon(i0));
        add(l1);
        
         mb=new JMenuBar();
         setJMenuBar(mb);
        
         m1=new JMenu("Master");
         m2=new JMenu("Upadate");
         m3=new JMenu("Report");
         m4=new JMenu("Utility");
         m5=new JMenu("Exit");
         
         m1.setForeground(Color.BLUE);
         m2.setForeground(Color.CYAN);
         m3.setForeground(Color.ORANGE);
         m4.setForeground(Color.GREEN);
         m5.setForeground(Color.MAGENTA);
         
        JMenuItem mt1=new JMenuItem("New Employee");
        mt1.setFont(new Font("monospaced",Font.PLAIN,15));
        mt1.setMnemonic('N');
        mt1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        mt1.setBackground(Color.white);
        
        JMenuItem mt2=new JMenuItem("Salary");
        mt2.setFont(new Font("monospaced",Font.PLAIN,15));
        mt2.setMnemonic('U');
        mt2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
        mt2.setBackground(Color.white);
        
        JMenuItem mt3=new JMenuItem("List Employee");
        mt3.setFont(new Font("monospaced",Font.PLAIN,15));
        mt3.setMnemonic('D');
        mt3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        mt3.setBackground(Color.white);
        
         JMenuItem u1=new JMenuItem("Update Salary");
         u1.setFont(new Font("monospaced",Font.PLAIN,15));
         u1.setMnemonic('B');
         u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
         u1.setBackground(Color.white);
         
         JMenuItem u2=new JMenuItem("Update Employee");
         u2.setFont(new Font("monospaced",Font.PLAIN,15));
         u2.setMnemonic('C');
         u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
         u2.setBackground(Color.white);
         
         JMenuItem u3=new JMenuItem("Take Attendance");
         u3.setFont(new Font("monospaced",Font.PLAIN,15));
         u3.setMnemonic('L');
         u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
         u3.setBackground(Color.white);
         
        
        
         JMenuItem r1=new JMenuItem("Generate PaySlip");
         r1.setFont(new Font("monospaced",Font.PLAIN,15));
         r1.setMnemonic('G');
         r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
         r1.setBackground(Color.white);
         
         JMenuItem r2=new JMenuItem("List Attendence");
         r2.setFont(new Font("monospaced",Font.PLAIN,15));
         r2.setMnemonic('R');
         r2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
         r2.setBackground(Color.white);
          
         JMenuItem ut1=new JMenuItem("Notepad");
         ut1.setFont(new Font("monospaced",Font.PLAIN,15));
         ut1.setMnemonic('N');
         ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
         ut1.setBackground(Color.white);
         
         JMenuItem ut2=new JMenuItem("Web Browser");
         ut2.setFont(new Font("monospaced",Font.PLAIN,15));
         ut2.setMnemonic('W');
         ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
         ut2.setBackground(Color.white);
         
         JMenuItem ut3=new JMenuItem("Calculator");
         ut3.setFont(new Font("monospaced",Font.PLAIN,15));
         ut3.setMnemonic('S');
         ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
         ut3.setBackground(Color.white);
         
         JMenuItem ex=new JMenuItem("Exit");
         ex.setFont(new Font("monospaced",Font.PLAIN,15));
         ex.setMnemonic('E');
         ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
         ex.setBackground(Color.white);
         
        
         
         m1.add(mt1);
         m1.add(mt2);
         m1.add(mt3);
         m2.add(u1);
         m2.add(u2);
         m2.add(u3);
         m3.add(r1);
         m3.add(r2);
         m4.add(ut1);
         m4.add(ut2);
         m4.add(ut3);
         m5.add(ex);
         
         mb.add(m1);
         mb.add(m2);
         mb.add(m3);
         mb.add(m4); 
         mb.add(m5);
       
        mt1.addActionListener(this);
        mt2.addActionListener(this);
        mt3.addActionListener(this);
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);
        ut1.addActionListener(this);
        ut2.addActionListener(this);
        ut3.addActionListener(this);
        r1.addActionListener(this);
        r2.addActionListener(this);
        ex.addActionListener(this);
     }
     
    public static void main(String[] args)
    {
         Project pb=new Project();
    }

   
     @Override
    public void actionPerformed(ActionEvent e) {
       String msg=e.getActionCommand();
     
           if(msg.equals("New Employee"))
           {
              new New_Employee().setVisible(true);
           }
           else if(msg.equals("Salary"))
           {
             new Salary().setVisible(true);
           }
           else if(msg.equals("Update Salary"))
           {
              new Update_Salary().setVisible(true);
           }
           else if(msg.equals("Update Employee"))
           {
              new Update_Employee().setVisible(true);
           }
           else if(msg.equals("Take Attendance"))
           {
             new Take_Attendance().setVisible(true);
           } 
           else if(msg.equals("Generate PaySlip"))
           {
             new Generate_PaySlip().setVisible(true);
           } 
           else if(msg.equals("List Attendence"))
           {
             new List_Attendence().setVisible(true);
           }  
          else if(msg.equals("List Employee"))
          {
             new List_Employee().setVisible(true);
          } 
         else if(msg.equals("Notepad"))
         {
          try{Runtime.getRuntime().exec("notepad.exe");}
          catch(Exception ef)
          {
           System.out.println(ef);
          }    
         }
          else if(msg.equals("Calculator"))
          {
            try{Runtime.getRuntime().exec("calc.exe");}
            catch(Exception ef)
           {
             System.out.println(ef);
           }
          }
        else if(msg.equals("Web Browser"))
        {
          try{Runtime.getRuntime().exec("D:\\Chrome\\Application\\Chrome.exe");}
          catch(Exception f)
          {
              System.out.println(f);
          } 
        }
       else if(msg.equals("Exit"))
       {
          System.exit(0);
       }
      
    
  }    
}

