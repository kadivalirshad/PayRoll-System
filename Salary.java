
package payroll_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Salary extends JFrame implements ActionListener {
  JLabel l2,l3,l4,l5,l6,l7;
  JTextField t2,t3,t4,t5,t6,t7;
  JButton b1,b2;
  Choice c2;
    public Salary() {
        super("Set Salary");
        setLayout(new GridLayout(8,2,20,20));
        c2=new Choice();
           try{
                 Conn c1=new Conn();
                 ResultSet rs=c1.s.executeQuery("select *from employee");
                while(rs.next())
                {
                  c2.add(rs.getString("No"));
                }    
              }
        catch(Exception ef){}
       add((new JLabel("Select Emp No")));
       add(c2);
       
       l2=new JLabel("HRA");
       add(l2);
       t2=new JTextField(15);
       add(t2);
       
        l3=new JLabel("DA");
       add(l3);
       t3=new JTextField(15);
       add(t3);
       
        l4=new JLabel("MED");
       add(l4);
       t4=new JTextField(15);
       add(t4);
       
        l5=new JLabel("PF");
       add(l5);
       t5=new JTextField(15);
       add(t5);
       
        l6=new JLabel("Basic Salary");
       add(l6);
       t6=new JTextField(15);
       add(t6);
       
       b1=new JButton("Submit");
       b1.setBackground(Color.black);
       b1.setForeground(Color.white);
       add(b1);
       
       b2=new JButton("Cancel");
       b2.setBackground(Color.black);
       b2.setForeground(Color.white);
       add(b2);
       
       b1.addActionListener(this);
       b2.addActionListener(this);
        setResizable(false);
       setSize(500,400);
       setVisible(true);
       getContentPane().setBackground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      String s1=c2.getSelectedItem();
      String s2=t2.getText();
      String s3=t3.getText();
      String s4=t4.getText();
      String s5=t5.getText();
      String s6=t6.getText();
      
      
      String q="insert into salary values("+s1+","+s2+","+s3+","+s4+","+s5+","+s6+");";
      if(e.getSource()==b1)
      {   
      try{
           Conn c1=new Conn();
           c1.s.executeUpdate(q);
           JOptionPane.showMessageDialog(null,"Succesfull added salary");
            t2.setText("");
           t3.setText("");
           t4.setText("");
           t5.setText("");
           t6.setText("");
         }
      catch(Exception ef)
      {
        ef.printStackTrace();
      }    
    }
      else if(e.getSource()==b2)
     {
       t2.setText("");
       t3.setText("");
       t4.setText("");
       t5.setText("");
       t6.setText("");
      this.setVisible(false);
     }    
     
     
     
   }

       
       
}
