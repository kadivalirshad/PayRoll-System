
package payroll_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Update_Salary extends JFrame implements ActionListener,ItemListener{
   JLabel l2,l3,l4,l5,l6,l7;
  JTextField t2,t3,t4,t5,t6;
  JButton b1,b2;
  Choice c2;
  
    public  Update_Salary() {
        super("Update  Salary");
        setLayout(new GridLayout(8,2,20,20));
        c2=new Choice();
           try{
                 Conn c1=new Conn();
                 ResultSet rs=c1.s.executeQuery("select *from salary");
               
                while(rs.next())
                {
                  c2.add(rs.getString("id"));
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
       
       b1=new JButton("Update");
       b1.setBackground(Color.black);
       b1.setForeground(Color.white);
       add(b1);
       
       b2=new JButton("Delete");
       b2.setBackground(Color.black);
       b2.setForeground(Color.white);
       add(b2);
       
       b1.addActionListener(this);
       b2.addActionListener(this);
       c2.addItemListener(this);
       setSize(500,400);
       setLocation(200,200);
       setVisible(true);
       setResizable(false);
       getContentPane().setBackground(Color.white);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
          
           String s2=t2.getText();
           String s3=t3.getText();
           String s4=t4.getText();
           String s5=t5.getText();
           String s6=t6.getText();
         
           
           String q1="Update salary SET hra="+s2+",da="+s3+",med="+s4+",pf="+s5+",basic="+s6+" where id="+c2.getSelectedItem();
           try{
                Conn c1=new Conn();
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Salary Update Succesfull");
              }
           catch(Exception ef){
               ef.printStackTrace();
            }
        }
       if(e.getSource()==b2)
       {
          try{
               Conn c1=new Conn();
               c1.s.executeUpdate("delete from salary where id="+c2.getSelectedItem());
               JOptionPane.showMessageDialog(null,"Delete record Successfull");
             }
          catch(Exception ef)
          {
             ef.printStackTrace();
          }    
       }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        try{
             Conn c1=new Conn();
             ResultSet rs=c1.s.executeQuery("select * from salary where id="+c2.getSelectedItem());
              
             if(rs.next())
             {
                
                t2.setText(rs.getString("hra"));
                t3.setText(rs.getString("da"));
                t4.setText(rs.getString("med"));
                t5.setText(rs.getString("pf"));
                t6.setText(rs.getString("basic"));

             }    
           }
        catch(Exception ef)
        {
           ef.printStackTrace();
        }    
    }
    
    
 
}
