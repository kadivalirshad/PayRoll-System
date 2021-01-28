
package payroll_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Update_Employee extends JFrame implements ActionListener,ItemListener{

   JLabel l1,l2,l3,l4,l5,l6,l7;
  JTextField t2,t3,t4,t5,t6,t7;
  JButton b1,b2;
  Choice c1,c2;
  
    public  Update_Employee() {
        super("Update  Employee");
        setLayout(new GridLayout(9,2,20,20));
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
       
       l2=new JLabel("Name:");
       add(l2);
       t2=new JTextField(15);
       add(t2);
       
       c1=new Choice();
       c1.add("Male");
       c1.add("Female");
       l1=new JLabel("Gender:");
       add(l1);
       add(c1);
       
       l3=new JLabel("Address");
       add(l3);
       t3=new JTextField(15);
       add(t3);
       
        l4=new JLabel("State");
       add(l4);
       t4=new JTextField(15);
       add(t4);
       
        l5=new JLabel("City:");
       add(l5);
       t5=new JTextField(15);
       add(t5);
       
        l6=new JLabel("Email:");
       add(l6);
       t6=new JTextField(15);
       add(t6);
       
       l7=new JLabel("Phone:");
       add(l7);
       t7=new JTextField(15);
       add(t7);
       
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
            String s1=t2.getText();
            String s2=t3.getText();
            String s3=t4.getText();
            String s4=t5.getText();
            String s5=t6.getText();
            String s6=t7.getText();
           
            
            String q="Update employee SET name='"+s1+"',gender='"+c1.getSelectedItem()+"',address='"+s2+"',state='"+s3+"',city='"+s4+"',email='"+s5+"',phone='"+s6+"'where No="+c2.getSelectedItem();
            try{
                  Conn c1=new Conn();
                  c1.s.executeUpdate(q);
                  JOptionPane.showMessageDialog(null,"Employee Update Succesfull");
                  this.setVisible(false);
               }
            catch(Exception ef)
            {
              ef.printStackTrace();
            }    
        }
        if(e.getSource()==b2)
        {
            try{
                  Conn cn=new Conn();
                  cn.s.executeUpdate("delete from employee where No="+c2.getSelectedItem());
                  JOptionPane.showMessageDialog(null,"Employee delete Succesful");
                  this.setVisible(false);
               }
            catch(Exception ec)
            {
              ec.printStackTrace();
            }
        }    
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        try{
               Conn c1=new Conn();
               ResultSet rs=c1.s.executeQuery("select *from Employee where No="+c2.getSelectedItem());
               if(rs.next())
               {
                  t2.setText(rs.getString("name"));
                  t3.setText(rs.getString("address"));
                  t4.setText(rs.getString("state"));
                  t5.setText(rs.getString("city"));
                  t6.setText(rs.getString("email"));
                  t7.setText(rs.getString("phone"));
               }
           }
        catch(Exception ef)
        {
          ef.printStackTrace();
        }    
    }
      
}
