/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p7;

/**
 *
 * @author hp
 */
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class registration implements ActionListener{
    private JFrame frame;
    private JTextField usernameBox;
    private JTextField emailBox;
    private JTextField mobileNoBox;
    private JCheckBox termsBox;
    public registration()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setLayout( new GridLayout(10,10,10,10));
        JLabel usernameL = new JLabel("Username");
        usernameBox = new JTextField();
        JLabel emailL = new JLabel("email");
        emailBox = new JTextField();
        JLabel mobileL = new JLabel("Mobile No");
        mobileNoBox = new JTextField();
        termsBox = new JCheckBox(" I agree the terms and conditions");
        JButton submit = new JButton("Submit");
        submit.addActionListener(this);
        frame.add(usernameL);
        frame.add(usernameBox);
        frame.add(emailL);
        frame.add(emailBox);
        frame.add(mobileL);  
        frame.add(mobileNoBox);
        frame.add(termsBox);
        frame.add(submit);
        frame.add(new JLabel());
        frame.setVisible(true);
        
    }
    
    private boolean insertUser(String username,String email, String mobile)
    {
         String DB_Url = "jdbc:mysql://localhost:3306/mydb2";
         String user = "root";
         String pass = "Dj1234";
         String query = " INSERT INTO users(username , email,mobile) VALUES (?,?,?);";
         try 
         {
             Connection conn = DriverManager.getConnection(DB_Url,user,pass);
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, username);
             ps.setString(2, email);
             ps.setString(3,mobile);
             int rows = ps.executeUpdate();
             return (rows>0);
         }
         catch(Exception e )
         {
             System.out.println(e);
             return false;
         }
    }
    
    private void clearForm()
    {
        usernameBox.setText("");
        emailBox.setText("");
        mobileNoBox.setText("");
        termsBox.setSelected(false);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(termsBox.isSelected())
        {
            String username = usernameBox.getText();
            String email = emailBox.getText();
            String mobile = mobileNoBox.getText();
            if(insertUser(username,email,mobile))
            {
                JOptionPane.showMessageDialog(frame, "User Registered successfully ");
                clearForm();
            }
            else
            {
                JOptionPane.showMessageDialog(frame, " Error occured while registering user  ");
            }
        }
            else
            {
                JOptionPane.showMessageDialog(frame, " Please accept the terms and conditions  ");    
            }
        
    }
  
   public static void main(String Args[])   
   {
      new registration();
   }
}
