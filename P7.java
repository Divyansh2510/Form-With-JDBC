/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p7;

/**
 *
 * @author hp
 */
import java.sql.*;
public class P7 {

    static String DB_Url = "jdbc:mysql://localhost:3306/mydb2";
    static String user = "root";
    static String pass = "Dj1234";
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Connection conn = DriverManager.getConnection(DB_Url,user,pass);
            Statement stmt = conn.createStatement();
            String Table = " CREATE TABLE  mydb2.users ( username VARCHAR(25), email VARCHAR(25), Mobile  INT(12));";
            stmt.executeUpdate(Table);
            System.out.println("Table users is created ");
    }
        catch(Exception e)
        {
            System.out.println(e);
        }
    
}
}
