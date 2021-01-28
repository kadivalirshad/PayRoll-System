
package payroll_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class List_Attendence extends JFrame implements ActionListener {
    JTable t;
    String h[]={"ID","DATE","FIRST_HALF","SECOND_HALF"};
    String d[][]=new String[50][4];
    JButton b1;
    int i=0,j=0;
    public List_Attendence() {
        super("Lsit Of Attendence");
        setSize(700,400);
        setVisible(true);
        setLocation(200,200);
        
         setResizable(false);
        try{ 
             Conn c1=new Conn();
             ResultSet rs=c1.s.executeQuery("select *from attandence");
             while(rs.next())
             {
                d[i][j++]=rs.getString("id");
                d[i][j++]=rs.getString("Date");
                d[i][j++]=rs.getString("First_Half");
                d[i][j++]=rs.getString("Second_Half");
                i++;
                j=0;
             }    
             t=new JTable(d,h);
           }
       catch(Exception ef)
       {
         ef.printStackTrace();
       } 
      b1=new JButton("Print");
      JPanel p2=new JPanel();
      p2.add(b1);
      add(p2,"South");
     
      JScrollPane js=new JScrollPane(t);
     add(js);
      
      b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         try{
               t.print();
            }
         catch(Exception ef)
         {
           ef.printStackTrace();
         }    
    }
   public static void main(String[] args)
   {
     new List_Attendence().setVisible(true);
   }       
}
