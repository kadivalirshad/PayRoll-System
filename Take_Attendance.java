
package payroll_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Take_Attendance extends JFrame implements ActionListener {
 JLabel l1,l2;
 JButton b1,b2;
 Choice c2,fh,sh;
 
    public Take_Attendance() {
         super("Take Attendance");
        setLayout(new GridLayout(4,2,10,10));
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
        JLabel emp=new JLabel("Employee ID");
        add(emp);
        add(c2);
        
        l1=new JLabel("First Half");
        add(l1);
        fh=new Choice();
        fh.add("Present");
        fh.add("Absent");
        fh.add("Leave");
        add(fh);
        
        l2=new JLabel("Second Half");
        add(l2);
        sh=new Choice();
         sh.add("Present");
         sh.add("Absent");
         sh.add("Leave");
         add(sh);
         
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
       
       setSize(400,300);
       setLocation(200,200);
       setVisible(true);
        setResizable(false);
       getContentPane().setBackground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==b1)
      {
         String s1=c2.getSelectedItem();
         String s2=fh.getSelectedItem();
         String s3=sh.getSelectedItem();
         String dt=new java.util.Date().toString();
         
         String q="insert into attandence values("+s1+",'"+dt+"','"+s2+"','"+s3+"')";
         
        try{
            Conn c1=new Conn();
            c1.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"Attendence Success");
           }
        catch(Exception ef)
        {
          ef.printStackTrace();
        } 
           
      }
       else if(e.getSource()==b2)
       {
          this.setVisible(false);
        }
    }
    
      
}
