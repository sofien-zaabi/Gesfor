/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * connexion.java
 *
 * Created on 20 mars 2014, 21:36:47
 */

package graphique;
import java.sql.*;
import javax.swing.*;
import java.awt.event.KeyEvent;



/**
 *
 * @author zied_2
 */
public class connexion extends javax.swing.JFrame {
    ResultSet rs=null ;
    Connection conn=connexion_bd.connexion();
  
    /** Creates new form connexion */
    public connexion() {
        initComponents();
        this.setTitle("Login");
        conn=connexion_bd.connexion();
                       }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        log = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1070, 685));
        setResizable(false);
        getContentPane().setLayout(null);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jTextField1.setText("pseudo");
        jTextField1.setBorder(null);
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(390, 190, 300, 40);

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jPasswordField1.setForeground(new java.awt.Color(102, 102, 102));
        jPasswordField1.setText("............");
        jPasswordField1.setBorder(null);
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseEntered(evt);
            }
        });
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(390, 250, 300, 40);

        log.setBackground(new java.awt.Color(153, 255, 255));
        log.setFont(new java.awt.Font("Tahoma", 0, 12));
        log.setForeground(new java.awt.Color(102, 102, 102));
        log.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boutton/connect.png"))); // NOI18N
        log.setText("Authentifier");
        log.setBorder(new javax.swing.border.SoftBevelBorder(0));
        log.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logMouseClicked(evt);
            }
        });
        getContentPane().add(log);
        log.setBounds(350, 320, 150, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Ges_For V1.0");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(470, 130, 118, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setForeground(new java.awt.Color(0, 204, 204));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(360, 404, 300, 20);

        jButton1.setBackground(new java.awt.Color(-6684673,true));
        jButton1.setForeground(new java.awt.Color(-10066330,true));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boutton/sortir-session-icone-5274-48.png"))); // NOI18N
        jButton1.setText("Quitter");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(0));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(520, 320, 150, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/arp1.jpg"))); // NOI18N
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel1KeyPressed(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1070, 670);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
        jTextField1.setText("") ;
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jPasswordField1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPasswordField1MouseEntered

    private void jPasswordField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseClicked
        // TODO add your handling code here:
        jPasswordField1.setText("") ;
    }//GEN-LAST:event_jPasswordField1MouseClicked

    private void logMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logMouseClicked

            // TODO add your handling code here:
              String loginn=jTextField1.getText();
        String pswd=jPasswordField1.getText();
        try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from admin");

          rs = pstmt1.executeQuery();
          while(rs.next())
      {
          String login=rs.getString("login");
          String psword=rs.getString("pswd");

          if(( pswd.length()>0 &&loginn.length()>0)&&( !psword.equals(pswd) || !login.equals(loginn)))
          {

           
           jLabel3.setText("*verifier vos paramètres");
          }
          else if(( pswd.length()>0 &&loginn.length()>0)&&( psword.equals(pswd) && login.equals(loginn)))
            {

              accueil  appelfenetre=new accueil();
        appelfenetre.setVisible(true) ;

        this.setVisible(false);

            }
          }
     }





	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}



        if
        (jTextField1.getText().length()==0||jPasswordField1.getText().length()==0)
       
        {
        jLabel3.setText("*remplir tous les champs s'il vous plais");
        }
       
    }//GEN-LAST:event_logMouseClicked

    private void jLabel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1KeyPressed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)

    {

        String loginn=jTextField1.getText();
        String pswd=jPasswordField1.getText();
        try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from admin");

          rs = pstmt1.executeQuery();
          while(rs.next())
      {
          String login=rs.getString("login");
          String psword=rs.getString("pswd");

          if(( pswd.length()>0 &&loginn.length()>0)&&( !psword.equals(pswd) || !login.equals(loginn)))
          {

           jLabel3.setText("*verifier vos paramètres ");
          }
          else if(( pswd.length()>0 &&loginn.length()>0)&&( psword.equals(pswd) && login.equals(loginn)))
            {

              accueil  appelfenetre=new accueil();
        appelfenetre.setVisible(true) ;

        this.setVisible(false);

            }
          }
     }





	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}

if
        (jTextField1.getText().length()==0||jPasswordField1.getText().length()==0)

        {
        jLabel3.setText("*remplir tous les champs s'il vous plais");
        }


        }


           
        
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                connexion appel=new connexion();
                 appel.setLocationRelativeTo(null);
                appel.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton log;
    // End of variables declaration//GEN-END:variables

}
