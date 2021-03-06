
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.chart.Chart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class RenBar extends javax.swing.JFrame {

    /**
     * Creates new form RenBar
     */
    public RenBar() {
        initComponents(); 
        this.loadDriver() ; 
        this.bar();
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
       void loadDriver() { 
		   try { 
			   Class.forName("com.mysql.jdbc.Driver"); 
		   }catch(ClassNotFoundException e) { 
			   e.printStackTrace();
		   }
	   }    
       
       public void bar(){ 
            Connection conn = null;    
            DefaultCategoryDataset dataset = new  DefaultCategoryDataset();
            
		try{
			conn=newConnection();
			Statement st = (Statement) conn.createStatement();
			String query = "SELECT Rent FROM projets"; 
                     
			ResultSet rs = st.executeQuery(query); 
                      int k=1;
                      while(rs.next()){ 
                                   dataset.setValue(Double.parseDouble(rs.getString(1)),"Marks","Projet"+"'"+k+"'");  
                                   k=k+1;
                                   
                         }
                   JFreeChart chart = ChartFactory.createBarChart("Rentabilité","Les projets", "% de la Rentabilité", dataset);  
                   CategoryPlot p  = chart.getCategoryPlot(); 
                   p.setRangeGridlinePaint(Color.black);   
                  
                   ChartFrame frame = new ChartFrame("Barchart for projects",chart);  
                   frame.setVisible(true); 
                   frame.setSize(450,450); 
                
                   
                   
                   
                  
		}catch(SQLException e){
			e.printStackTrace(); 
                        
		}   
       }       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 831, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RenBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RenBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RenBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RenBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RenBar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
