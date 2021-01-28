
package payroll_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class List_Employee extends JFrame implements ActionListener {
     JTable t;
     JButton print;
     String h[]={"EMP ID","NAME","GENDER","ADDRESS","STATE","CITY","EMAIL ID","PHONE"};
     String d[][]=new String[20][8];
     int i=0,j=0;
    public List_Employee() {
        super("List Employee");
        setSize(700,400);
        setLocation(200,200);
         setResizable(false);
        try{
            String q="select *from employee";
             Conn c1=new Conn();
             ResultSet rs=c1.s.executeQuery(q);
             while(rs.next())
             {
               d[i][j++]=rs.getString("No");
               d[i][j++]=rs.getString("name");
               d[i][j++]=rs.getString("gender"); 
               d[i][j++]=rs.getString("address");
               d[i][j++]=rs.getString("state");
               d[i][j++]=rs.getString("city");
               d[i][j++]=rs.getString("email");
               d[i][j++]=rs.getString("phone"); 
               i++;
               j=0;
             }
            t=new JTable(d,h); 
           }
        catch(Exception ef){
        
        }
       print=new JButton("Print");
       add(print,"South");
       JScrollPane s1=new JScrollPane(t);
       add(s1);
       print.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            t.print();
           }
        catch(Exception ef){}
    }
    
}
