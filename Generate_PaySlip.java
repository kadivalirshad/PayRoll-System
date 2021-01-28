
package payroll_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Generate_PaySlip extends JFrame implements ActionListener{

  Choice c1;
   JTextArea t1;
   JButton b1,b2;
   JPanel p2;
    public Generate_PaySlip() {
        setSize(800,400);
        setLocation(200,200);
        setVisible(true);
         setResizable(false);
        c1=new Choice();
        try{
             Conn cn=new Conn();
             ResultSet rs=cn.s.executeQuery("select *from employee");
             while(rs.next())
             {
                c1.add(rs.getString("No"));
             }
           }
        catch(Exception ef)
        {
          ef.printStackTrace();
        }    
        setLayout(new BorderLayout());
       JPanel p1=new JPanel();
       p1.add(new JLabel("Select ID"));
       p1.add(c1);
       add(p1,"North");
       
       t1=new JTextArea(100,200);
       JScrollPane js=new JScrollPane(t1);
       p2=new JPanel();
       b1=new JButton("Generate Pay Sleep");
       p2.add(b1);
       add(js,"Center");
       b1.addActionListener(this);
       
       b2=new JButton("Print");
       p2.add(b2);
       b2.addActionListener(this);  
        
      add(p2,"South");
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
             Conn cn=new Conn();
             ResultSet rs=cn.s.executeQuery("select *from employee where No="+c1.getSelectedItem());
             rs.next();
             String name=rs.getString("name");
             rs.close();
             
            ResultSet ss=cn.s.executeQuery("select *from salary where id="+c1.getSelectedItem());
             double gross=0;
             double net=0;
             
             java.util.Date d1=new java.util.Date();
             int month=d1.getMonth();
             int year=d1.getYear();
             t1.setText("---------------------------------Pay Sleep For The Month of"+ month+" "+year+"---------------------------");
             t1.append("\n");
             if(ss.next())
             {
                t1.append("\nEmployee ID:"+ss.getString("id"));
                t1.append("\nEmployee Name:"+name);
                t1.append("\n-------------------------------------------------------------");
                t1.append("\n");
                double hra=ss.getDouble("HRA");
                t1.append("\n      HRA:"+         hra);
                double da=ss.getDouble("DA");
                t1.append("\n      DA:"+          da);
                double med=ss.getDouble("MED");
                t1.append("\n      MED:"+         med);
                double pf=ss.getDouble("PF");
                t1.append("\n      PF:"+          pf);
                double basic=ss.getDouble("BASIC");
                t1.append("\n      BASIC_SALARY:"+basic);
                
             t1.append("\n-----------------------------------------------------------------");
             t1.append("\n");
             
             gross=hra+da+med+pf+basic;
             net=gross-pf;
             
             t1.append("Gross Salary:"           +gross+" \n   Net Salary:"+net);
             t1.append("\n   Tax:  2.1% of Gross Salary"+(gross*2.1/100));
             t1.append("\n");
             t1.append("\n");
             t1.append("\n");
             t1.append("                                   (Signature)");
             }
           }
        catch(Exception ef)
        {
          ef.printStackTrace();
        }
        
        if(e.getSource()==b2)
        {
           try{
                 t1.print();
                 
              }
           catch(Exception ef)
           {
             ef.printStackTrace();
           }
        }
    }
       

}
