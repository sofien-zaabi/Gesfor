/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * groupe.java
 *
 * Created on 17 avr. 2014, 09:55:17
 */

package graphique;
import java.sql.*;
import net.proteanit.sql.DbUtils ;
import javax.swing.* ;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author zied_2
 */
public class groupe extends javax.swing.JFrame {
ResultSet rs;
 Connection conn=connexion_bd.connexion();
    /** Creates new form groupe */
    public groupe() {
        initComponents();
        update_groupe();
         conn=connexion_bd.connexion();
         this.setTitle("Gestionnaire de groupes");
    }
    private void update_groupe()
    {
    try{
	      
	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from groupe ORDER BY  `id_groupe` ASC ");

          rs = pstmt1.executeQuery();

groupe_table.setModel(DbUtils.resultSetToTableModel(rs));

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel2 = new java.awt.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        groupe_table = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        groupe = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1070, 650));
        setResizable(false);
        getContentPane().setLayout(null);

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setLayout(null);

        groupe_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        groupe_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                groupe_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(groupe_table);

        panel2.add(jScrollPane1);
        jScrollPane1.setBounds(60, 80, 470, 280);

        jButton5.setBackground(new java.awt.Color(0, 51, 102));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/demande-afficher-la-liste-icone-8709-32.png"))); // NOI18N
        jButton5.setText("Lister étudiant");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        panel2.add(jButton5);
        jButton5.setBounds(340, 20, 190, 40);

        groupe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                groupeMouseClicked(evt);
            }
        });
        groupe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                groupeKeyTyped(evt);
            }
        });
        panel2.add(groupe);
        groupe.setBounds(160, 20, 170, 40);

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/ajouter-crayon-icone-4828-32.png"))); // NOI18N
        jButton1.setText("ajouter");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        panel2.add(jButton1);
        jButton1.setBounds(60, 380, 140, 40);

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/kedit-icone-8843-32.png"))); // NOI18N
        jButton3.setText("modifier");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        panel2.add(jButton3);
        jButton3.setBounds(220, 380, 150, 40);

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/supprimer-icone-4878-32.png"))); // NOI18N
        jButton4.setText("supprimer");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        panel2.add(jButton4);
        jButton4.setBounds(390, 380, 140, 40);

        jLabel2.setText("Libélée groupe:");
        panel2.add(jLabel2);
        jLabel2.setBounds(64, 30, 90, 20);

        getContentPane().add(panel2);
        panel2.setBounds(70, 100, 560, 440);

        jScrollPane2.setViewportView(jList1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(650, 100, 230, 440);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/logooo copie.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-40, -110, 1450, 910);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // code insertion groupe dans db
          try{
	      
	    		PreparedStatement pstmt1 = conn.prepareStatement("insert into groupe (nom_groupe) values (?)");


         pstmt1.setString(1,groupe.getText());


         int resultat = pstmt1.executeUpdate();



	    		 JOptionPane.showMessageDialog(null,"groupe ajouter");
	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
         update_groupe ();
  
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // Code suppression groupe
         try{

           int row=groupe_table.getSelectedRow();
           String ID=(groupe_table.getModel().getValueAt(row, 0).toString());
           int id ;
           id=Integer.parseInt(ID);

           String grp=(groupe_table.getModel().getValueAt(row,1).toString());


	    		PreparedStatement pstmt2 = conn.prepareStatement("select * from etudiant where groupe= '"+grp+"' ");

          rs = pstmt2.executeQuery();

if (rs.next())
{


JOptionPane.showMessageDialog(null,"ce groupe n'est pas vide vous ne pouvez pas le supprimer");



}
else{
               int c=JOptionPane.showConfirmDialog(null,"tu veux supprimer"," supprime",JOptionPane.YES_NO_OPTION);
        if(c==0){
	    		PreparedStatement pstmt1 = conn.prepareStatement("delete  from groupe where id_groupe= '"+id+"' ");

         int resultat= pstmt1.executeUpdate();

JOptionPane.showMessageDialog(null,"groupe supprimer avec succes");
}}
}


	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
         update_groupe ();

    

    }//GEN-LAST:event_jButton4MouseClicked

    private void groupe_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupe_tableMouseClicked
        // TODO add your handling code here:
         try{

           int row=groupe_table.getSelectedRow();
           String ID=(groupe_table.getModel().getValueAt(row, 0).toString());
           int id ;
           id=Integer.parseInt(ID);

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from groupe where id_groupe= '"+id+"' ");

          rs = pstmt1.executeQuery();

if (rs.next())
{



String group=rs.getString("nom_groupe");
groupe.setText(group);


}

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
    }//GEN-LAST:event_groupe_tableMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
          try{
              int row=groupe_table.getSelectedRow();
 String ID=(groupe_table.getModel().getValueAt(row, 0).toString());
           int id ;
           id=Integer.parseInt(ID);

String group=groupe.getText();




        PreparedStatement pstmt1 = conn.prepareStatement("update  groupe set nom_groupe='"+group+"' where id_groupe= '"+id+"' ");




         int resultat = pstmt1.executeUpdate();


	    		 JOptionPane.showMessageDialog(null,"mise à jour effectuer");
          groupe.setText("");



	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
         update_groupe ();



    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
         DefaultListModel m=new  DefaultListModel();
         m.addElement("");
         jList1.setModel(m);
         try{

           int row=groupe_table.getSelectedRow();
           String grp=(groupe_table.getModel().getValueAt(row,1).toString());


	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from etudiant where groupe= '"+grp+"' ");

          rs = pstmt1.executeQuery();

while (rs.next())
{



String ne=rs.getString("nom");
String pr=rs.getString("prenom");
int cine=rs.getInt("cin_etudiant");
String ce=Integer.toString(cine);
 m.addElement(""+ce+" "+" "+ne+"  "+""+pr+"  ");


}

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
    }//GEN-LAST:event_jButton5MouseClicked

    private void groupeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_groupeKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) || c==KeyEvent.VK_PERIOD || c==KeyEvent.VK_SPACE  || c==KeyEvent.VK_BACK_SPACE ))
        {
          JOptionPane.showMessageDialog(null,"type non valide");
        }
    }//GEN-LAST:event_groupeKeyTyped

    private void groupeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupeMouseClicked
        // TODO add your handling code here:
        groupe.setText("");
    }//GEN-LAST:event_groupeMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new groupe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField groupe;
    private javax.swing.JTable groupe_table;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Panel panel2;
    // End of variables declaration//GEN-END:variables

}
