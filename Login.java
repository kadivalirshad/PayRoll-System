
package payroll_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,l4;
    JPasswordField pass;
    JTextField t1;
    JButton b1,b2;
    JPanel p1,p2,p3,p4;
    Login()
    {
      l1=new JLabel("UserName");
      l4=new JLabel("   ");
      l2=new JLabel("Password");
      pass=new JPasswordField(15);
      t1=new JTextField(15);
     
     
      
      ImageIcon c1=new ImageIcon("D:\\logo.jpeg");
      Image i1=c1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
      b1 =new JButton("Login",new ImageIcon(i1));
      b1.addActionListener(this);
       ImageIcon c2=new ImageIcon("D:\\close.jpeg");
      Image i2=c2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
      b2=new JButton("Cancel",new ImageIcon(i2));
       b2.addActionListener(this);
       
     
        ImageIcon c3=new ImageIcon(ClassLoader.getSystemResource("Image/Login.png"));
        Image i3=c3.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        ImageIcon i4=new ImageIcon(i3);
        l3=new JLabel(i4);
       
      setLayout(new BorderLayout());
      
      p1=new JPanel();  
      p2=new JPanel();
      p4=new JPanel();
      
      add(l3,BorderLayout.WEST);
      p2.add(l1);
      p2.add(t1);
      p2.add(l2);
      p2.add(pass);
      add(p2,BorderLayout.CENTER);
      
      p4.add(b1);
      p4.add(b2);
      add(p4,BorderLayout.SOUTH);
     
      p1.add(l4);
      add(p1,BorderLayout.NORTH);
      p2.setBackground(Color.white);
      p4.setBackground(Color.white);
      p1.setBackground(Color.white);
      //Dimension sa=Toolkit.getDefaultToolkit().getScreenSize();
     setSize(450,250);
      setLocation(100,100);
      setVisible(true);
       setResizable(false);
      getContentPane().setBackground(Color.white);
      setDefaultCloseOperation(3);
    }
    
    public static void main(String[] args)
    {
      new Login().setVisible(true);
    }        

   
    public void actionPerformed(ActionEvent e) 
    {
         try{
             if(e.getSource()==b1)
             {
             Conn c=new Conn();
             String a=t1.getText();
             String b=pass.getText();
             String q="select * from login where userid='"+a+"' and password='"+b+"' ";
             ResultSet rs=c.s.executeQuery(q);
             if(rs.next())
             {
                new Project().setVisible(true);
                this.setVisible(false);
             }    
             else
             {
               JOptionPane.showMessageDialog(null,"Invalid UserName or Password");
              
             }
            }
             else if(e.getSource()==b2)
             {
               System.exit(0);
             }    
         }  
        catch(Exception ef)
        {
        
        }
    }
}

