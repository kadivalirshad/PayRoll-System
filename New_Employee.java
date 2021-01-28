
package payroll_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class New_Employee extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6;
    Choice ch;
    JPanel p1;
    JButton b1,b2;
   New_Employee() {
      super("New_Employee");
      p1=new JPanel();
      add(p1);
      p1.setLayout(new GridLayout(8,2,10,40));
      
      l1=new JLabel("Name");
      p1.add(l1);
      t1=new JTextField(15);
      p1.add(t1);
      
      l2=new JLabel("Gender");
      p1.add(l2);
      ch=new Choice();
      ch.add("Male");
      ch.add("Femal");
      p1.add(ch);
      
      
      l3=new JLabel("Address");
      p1.add(l3);
      t2=new JTextField(15);
      p1.add(t2);
      
      l4=new JLabel("State");
      p1.add(l4);
      t3=new JTextField(15);
      p1.add(t3);
      
      l5=new JLabel("City");
      p1.add(l5);
      t4=new JTextField(15);
      p1.add(t4);
      
      l6=new JLabel("Email");
      p1.add(l6);
      t5=new JTextField(15);
      p1.add(t5);
      
      l7=new JLabel("Phone");
      p1.add(l7);
      t6=new JTextField(15);
      p1.add(t6);
      
      b1=new JButton("Submit");
      b1.setBackground(Color.BLACK);
      b1.setForeground(Color.white);
      b2=new JButton("Cancel"); 
      b2.setBackground(Color.black);
      b2.setForeground(Color.white);
      p1.add(b1);
      p1.add(b2);
    
     b1.addActionListener(this);
     b2.addActionListener(this);
     
       setSize(600,500);
       setLocation(100,200);
       setVisible(true);
        setResizable(false);
       getContentPane().setBackground(Color.white);

   }

    @Override
    public void actionPerformed(ActionEvent e) {
          if(e.getSource()==b1)
          {
           String s1=t1.getText();
           String s2=ch.getSelectedItem();
           String s3=t2.getText();
           String s4=t3.getText();
           String s5=t4.getText();
           String s6=t5.getText();
           String s7=t6.getText();
           String q="insert into employee values(null,'"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"');";
          try{
             Conn c1=new Conn();
             c1.s.executeUpdate(q);
             JOptionPane.showMessageDialog(null,"Employee add Succesfull");
             t1.setText("");
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
     if(e.getSource()==b2)
     {
            t1.setText("");
             t2.setText("");
             t3.setText("");
             t4.setText("");
             t5.setText("");
             t6.setText("");
           this.setVisible(false);
     }
    }
  
}
