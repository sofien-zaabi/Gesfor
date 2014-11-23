/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphique;
import javax.swing.* ;
import java.sql.*;

/**
 *
 * @author zied_2
 */

public class connexion_bd {
Connection conn=null;
   public static Connection connexion()
    {
        try{
	      Class.forName("com.mysql.jdbc.Driver");
	      String dbUrl = "jdbc:mysql://localhost:3306/gesfor";
String user = "root", password = ""  ;

Connection conn ;
conn = DriverManager.getConnection(dbUrl, user, password);

return conn;

	    }
	    	catch(Exception c){
	    		 JOptionPane.showMessageDialog(null,c.getMessage());
return null;
	    	}

    }

}
