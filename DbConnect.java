/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xproject;
import java.sql.*;
public class DbConnect {
    public static Connection getConnection(){
		Connection con=null;
		try{
	
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema","root","root");
                    System.out.println("Connected to database");
		}
                catch(ClassNotFoundException | SQLException e){System.out.println(e);}
		return con;
	}
} 