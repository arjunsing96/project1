import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Ryan
 */
public class Food_conn {
    Connection conn ;
    
    public static Connection food_connection(){
        
        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
	    	 Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
}
