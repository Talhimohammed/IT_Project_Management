import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane; 
public class Jdbc {   
	  JFrame frame ; 
	
	   public Jdbc(JFrame frame ) { 
		   this.loadDriver(); 
		   //this.listPersons(); 
		   this.frame=frame;
	   }  
        
	   void loadDriver() { 
		   try { 
			   Class.forName("com.mysql.jdbc.Driver"); 
		   }catch(ClassNotFoundException e) { 
			   e.printStackTrace();
		   }
	   } 
	   
	   Connection newConnection() { 
		   final String url = "jdbc:mysql://localhost:3306/projet"; 
		   Connection conn = null ;  
		   try { 
			   conn = DriverManager.getConnection(url,"root","");
		   }catch(SQLException e) { 
			   e.printStackTrace();
		   } 
		   return conn ; 
	   } 
	   
	   public String Test(String f1,String f2) {  
		   Connection conn = null ;   
		   String p="Simo";
		   
		   try { 
			    conn = newConnection(); 
			    Statement st = conn.createStatement(); 
			    java.sql.PreparedStatement  pst = conn.prepareStatement("SELECT Type_Utilisateur FROM utilisateur WHERE Password = ? and Nom = ?"); 
			    pst.setString(1,f1); 
                            pst.setString(2,f2);
			    ResultSet rs = pst.executeQuery();   
			    
			    if(rs.next() ) {
			    String p1 =rs.getString("Type_Utilisateur");    
			   
                p=p1 ; 
			    }else {  
			    	
			    	JOptionPane.showMessageDialog(frame,"invalid name or password");
			    }
			     
			
			    
		   }catch(SQLException e) { 
			    e.printStackTrace(); 
			
			   
		   }
		 return p ; 
		   
		   
	   } 
           
        public void recuperer(String f1,String f2,String f3){  
                Connection conn = null ;    
                   try { 
			    conn = newConnection(); 
			    Statement st = conn.createStatement(); 
			    java.sql.PreparedStatement  pst = conn.prepareStatement("SELECT * FROM utilisateur WHERE Nom = ? and Email = ? and Indication = ?"); 
			    pst.setString(1,f1); 
                            pst.setString(2,f2); 
                            pst.setString(3,f3);
			    ResultSet rs = pst.executeQuery();   
			    
			    if(rs.next() ) {
			    
			                   Confirmer a = new Confirmer();   
                                           a.setVisible(true);
                
			    }else {  
			    	
			    	JOptionPane.showMessageDialog(frame,"invalid informations");
			    }
			     
			
			    
		   }catch(SQLException e) { 
			    e.printStackTrace(); 
			
			   
		   }
		 
            
        }  
  
    

	
	   
	   
	   
	 

}
