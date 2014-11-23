/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * gainmenseul.java
 *
 * Created on 20 févr. 2014, 22:36:45
 */

package graphique;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author kalb
 */
public class caisse extends javax.swing.JFrame {
    ResultSet rs;
     DefaultListModel m=new  DefaultListModel();
    Connection conn=connexion_bd.connexion();
int total=0;
    /** Creates new form gainmenseul */
    public caisse() {
        initComponents();
         affiche_recette();
        affiche_encadrement();
        affiche_depense();
        affiche_paief();
        affiche_total();
    }
private void affiche_recette()
   {
         int rec=0;
          try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("select montant_payer from inscription ");

          rs = pstmt1.executeQuery();

          while (rs.next())
          {
              int mp=rs.getInt("montant_payer");

              rec=rec+mp;

          }
 m.addElement("total recette du formation pour ce mois           :"+" "+rec+"");
jList1.setModel(m);
total=total+rec;
	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
   }
    private void affiche_encadrement()
    {
         int encadrement=0;


        try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("select nb_heures,prix_heure from seance_encadrement  ");

          rs = pstmt1.executeQuery();

          while (rs.next())
          {
              int nbh=rs.getInt("nb_heures");
              int ph=rs.getInt("prix_heure");
              int montan=nbh*ph ;
              encadrement=encadrement+montan;

          }
 m.addElement("total encadrement pour ce mois                        :"+" "+encadrement+"");
jList1.setModel(m);
total=total+encadrement;
	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}

    }
    private void affiche_depense(){
      int depense=0;
    

        try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from paiement_formateur  ");

          rs = pstmt1.executeQuery();

          while (rs.next())
          {
              int montan=rs.getInt("montant");
              depense=depense+montan;

          }
 m.addElement("total paiement aux formateurs pour ce mois :"+" "+depense+"");
jList1.setModel(m);
total=total-depense;
	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}

    }
   
    private void affiche_paief(){
     int paie=0;
     

        try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from depenses  ");

          rs = pstmt1.executeQuery();

          while (rs.next())
          {
              int montan=rs.getInt("montant");
              paie=paie+montan;

          }
 m.addElement("total depenses pour ce mois                              :"+" "+paie+"");
jList1.setModel(m);
total=total-paie;

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}

}
    private void affiche_total()
    {
 m.addElement("total de opérations financières                          :"+" "+total+"");
jList1.setModel(m);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        panel2 = new java.awt.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1070, 650));
        getContentPane().setLayout(null);

        panel1.setLayout(null);

        jButton4.setText("recette encadrement");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        panel1.add(jButton4);
        jButton4.setBounds(20, 20, 180, 60);

        jButton3.setText("recette formation");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        panel1.add(jButton3);
        jButton3.setBounds(220, 20, 180, 60);

        jButton2.setText("paiement formateur");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        panel1.add(jButton2);
        jButton2.setBounds(220, 100, 180, 60);

        jButton1.setText("consulter depenses");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        panel1.add(jButton1);
        jButton1.setBounds(20, 100, 180, 60);

        jButton5.setText("Récape générale");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        panel1.add(jButton5);
        jButton5.setBounds(410, 20, 150, 140);

        getContentPane().add(panel1);
        panel1.setBounds(190, 70, 580, 170);

        panel2.setLayout(null);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        panel2.add(jScrollPane1);
        jScrollPane1.setBounds(30, 50, 530, 170);

        getContentPane().add(panel2);
        panel2.setBounds(190, 250, 580, 260);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/logooo copie.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-20, 0, 1100, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
     depense  appelfenetre=new  depense();
         appelfenetre.setLocationRelativeTo(null);
        appelfenetre.setVisible(true) ;
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
          paiementformateur  appelfenetre=new  paiementformateur();
        appelfenetre.setLocationRelativeTo(null);
        appelfenetre.setVisible(true) ;
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        String type=jList1.toString();

    }//GEN-LAST:event_jList1MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
       projets  appelfenetre=new  projets();
        appelfenetre.setExtendedState(appelfenetre.MAXIMIZED_BOTH);
        appelfenetre.setVisible(true) ;
       
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
         recape  appelfenetre=new  recape();
        appelfenetre.setLocationRelativeTo(null);
        appelfenetre.setVisible(true) ;
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        inscription  appelfenetre=new  inscription();
        appelfenetre.setLocationRelativeTo(null);
        appelfenetre.setVisible(true) ;
    }//GEN-LAST:event_jButton3MouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new caisse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    // End of variables declaration//GEN-END:variables

}
