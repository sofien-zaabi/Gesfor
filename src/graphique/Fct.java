/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AjoutF.java
 *
 * Created on 29 avr. 2014, 13:58:34
 */

package graphique;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils ;

/**
 *
 * @author zied_2
 */
public class Fct extends javax.swing.JFrame {
Connection conn =connexion_bd.connexion();
ResultSet rs;
    /** Creates new form AjoutF */
    public Fct() {
        initComponents();
 conn =connexion_bd.connexion();
 
 

 modif_fct();
 update_fct();
 matiere();
 formateur();
 annule_f();
 
 this.setTitle("formation à cout terme");
 

    }
  ///////************gestion formation Court Terme*********************
 
  private void modif_fct()
  {

  }
  private void  update_fct()
  {
try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from formation_ct ");

          rs = pstmt1.executeQuery();

fct.setModel(DbUtils.resultSetToTableModel(rs));

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
  }
 
  private void formateur()
  {
 try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("select cin_formateur from formateur");

          rs = pstmt1.executeQuery();

while(rs.next())
{
    String cinf=rs.getString("cin_formateur");
    formateur.addItem(cinf);
}

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
  }
  private void matiere()
  {
 try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("select nom_matiere from matiere");

          rs = pstmt1.executeQuery();

while(rs.next())
{
    String cinf=rs.getString("nom_matiere");
    matiere.addItem(cinf);
    
}

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
  }
  /////*********vider les champs de tous les formulaire***************
  private void annule_f()
  {
  ph.setText("");
  nbh.setText("");
  nf.setText("");
 
  dd.setDate(null);
  df.setDate(null);
  jTextField1.setText("Nom_Formation");
  
  
  }




    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nbh = new javax.swing.JTextField();
        ph = new javax.swing.JTextField();
        df = new com.toedter.calendar.JDateChooser();
        dd = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        fct = new javax.swing.JTable();
        matiere = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        formateur = new javax.swing.JComboBox();
        panel2 = new java.awt.Panel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        ajout = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        nf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1070, 650));
        getContentPane().setLayout(null);

        nbh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nbhMouseClicked(evt);
            }
        });
        nbh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nbhKeyTyped(evt);
            }
        });
        getContentPane().add(nbh);
        nbh.setBounds(860, 220, 170, 40);

        ph.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phMouseClicked(evt);
            }
        });
        ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phKeyTyped(evt);
            }
        });
        getContentPane().add(ph);
        ph.setBounds(860, 320, 170, 40);

        df.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(df);
        df.setBounds(860, 420, 170, 40);

        dd.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(dd);
        dd.setBounds(860, 370, 170, 40);

        fct.setModel(new javax.swing.table.DefaultTableModel(
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
        fct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fctMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(fct);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 730, 450);

        matiere.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        getContentPane().add(matiere);
        matiere.setBounds(860, 170, 170, 40);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "    ", "niveau 1", "niveau 2", "niveau 3", "niveau 4", "professionel" }));
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(860, 70, 170, 40);

        formateur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "          " }));
        getContentPane().add(formateur);
        formateur.setBounds(860, 270, 170, 40);

        panel2.setBackground(new java.awt.Color(51, 255, 255));
        panel2.setLayout(null);

        jButton3.setBackground(new java.awt.Color(-3355393,true));
        jButton3.setForeground(new java.awt.Color(-1,true));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/supprimer-icone-4878-32.png"))); // NOI18N
        jButton3.setText("Supprimer");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        panel2.add(jButton3);
        jButton3.setBounds(200, 20, 130, 40);

        jButton4.setBackground(new java.awt.Color(-3355393,true));
        jButton4.setForeground(new java.awt.Color(-1,true));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/kedit-icone-8843-32.png"))); // NOI18N
        jButton4.setText("Modifier ");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        panel2.add(jButton4);
        jButton4.setBounds(340, 20, 140, 40);

        ajout.setBackground(new java.awt.Color(-3355393,true));
        ajout.setForeground(new java.awt.Color(-1,true));
        ajout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/ajouter-crayon-icone-4828-32.png"))); // NOI18N
        ajout.setText("Ajouter formation");
        ajout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajoutMouseClicked(evt);
            }
        });
        panel2.add(ajout);
        ajout.setBounds(20, 20, 160, 40);

        jButton6.setBackground(new java.awt.Color(-3355393,true));
        jButton6.setForeground(new java.awt.Color(-1,true));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/supprimer-icone-7248-32.png"))); // NOI18N
        jButton6.setText("Annuler");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        panel2.add(jButton6);
        jButton6.setBounds(490, 20, 160, 90);

        jButton7.setBackground(new java.awt.Color(-3355393,true));
        jButton7.setForeground(new java.awt.Color(-1,true));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/recherche-icone-4239-32.png"))); // NOI18N
        jButton7.setText("Chercher");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        panel2.add(jButton7);
        jButton7.setBounds(340, 70, 140, 40);

        jTextField1.setText("Nom_formation");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        panel2.add(jTextField1);
        jTextField1.setBounds(20, 70, 160, 40);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "niveau 1", "niveau 2", "niveau 3", "niveau 4", "professionel" }));
        panel2.add(jComboBox1);
        jComboBox1.setBounds(200, 70, 130, 40);

        getContentPane().add(panel2);
        panel2.setBounds(10, 480, 1030, 120);

        nf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nfMouseClicked(evt);
            }
        });
        nf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nfKeyTyped(evt);
            }
        });
        getContentPane().add(nf);
        nf.setBounds(860, 120, 170, 40);

        jLabel3.setText("Niveau:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(770, 80, 80, 30);

        jLabel2.setText("Formation:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(770, 130, 90, 30);

        jLabel4.setText("Prix_heure:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(770, 330, 80, 30);

        jLabel5.setText("Date debut:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(770, 380, 80, 30);

        jLabel6.setText("Date fin:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(770, 430, 80, 30);

        jLabel7.setText("Matière:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(770, 180, 80, 20);

        jLabel8.setText("Nb_heures:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(770, 224, 80, 30);

        jLabel9.setText("Formateur:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(770, 274, 80, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/a_p.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-290, -70, 1360, 740);

        pack();
    }// </editor-fold>//GEN-END:initComponents
///***************Action sur bouttons et apel du fonctions***********************

    private void nfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nfMouseClicked
        // TODO add your handling code here:
        nf.setText("");
    }//GEN-LAST:event_nfMouseClicked

    private void nbhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nbhMouseClicked
        // TODO add your handling code here:
        nbh.setText("");
    }//GEN-LAST:event_nbhMouseClicked

    private void phMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phMouseClicked
        // TODO add your handling code here:
        ph.setText("");
    }//GEN-LAST:event_phMouseClicked

    private void ajoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutMouseClicked
        // TODO add your handling code here:
          
 try
     {
     String form=nf.getText();
     String niv=jComboBox2.getSelectedItem().toString();

     PreparedStatement pstmt2 = conn.prepareStatement("select * from formation_ct where nom_formation= '"+form+"' and niveau='"+niv+"' ");
     rs=pstmt2.executeQuery();
     if (rs.next())
     {
          JOptionPane.showMessageDialog(null,"formation existe déja");
     }
     else
     {
         PreparedStatement pstmt1=conn.prepareStatement("insert into formation_ct (niveau,nom_formation,matiere,cin_formateur,nb_heures,prix_heure,date_debut,date_fin) values (?,?,?,?,?,?,?,?)");

pstmt1.setString(1,niv);
pstmt1.setString(2,nf.getText());
pstmt1.setString(3,matiere.getSelectedItem().toString());
            pstmt1.setInt(4,Integer.parseInt(formateur.getSelectedItem().toString()));
            pstmt1.setInt(5,Integer.parseInt(nbh.getText()));
            pstmt1.setInt(6,Integer.parseInt(ph.getText()));
      pstmt1.setString(7,((JTextField)dd.getDateEditor().getUiComponent()).getText());
       pstmt1.setString(8,((JTextField)df.getDateEditor().getUiComponent()).getText());
       java.util.Date d1=dd.getDate();
                java.util.Date d2=df.getDate();
                if (d1.after(d2))
                {
               JOptionPane.showMessageDialog(null,"date de fin doit ètre après la date de debut");
                }
                else{
      int resultat = pstmt1.executeUpdate();
       JOptionPane.showMessageDialog(null,"formation enregistrer");
                }
     }
     }
     catch(Exception e)
     {
    System.out.println(e.getMessage());

	    	}
         update_fct();
         annule_f();
        
    }//GEN-LAST:event_ajoutMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
           
try{
              int row=fct.getSelectedRow();
 String ID=(fct.getModel().getValueAt(row, 0).toString());
           int idf ;
           idf=Integer.parseInt(ID);

 String nive=(fct.getModel().getValueAt(row, 1).toString());
           String form=(fct.getModel().getValueAt(row, 2).toString());
           String tp="FCT";

PreparedStatement pstmt2 = conn.prepareStatement("select * from  inscription   where formation= '"+form+"' and niveau='"+nive+"' and type_formation='"+tp+"' ");
rs=pstmt2.executeQuery();
if(rs.next())

{
 JOptionPane.showMessageDialog(null,"Erreur de modification, il'y a des étudiants qui ont inscrivé");
}
else
{
String niv=jComboBox2.getSelectedItem().toString();
String nomf=nf.getText();
String matier=matiere.getSelectedItem().toString();
int formateu=Integer.parseInt(formateur.getSelectedItem().toString());
int nbheure=Integer.parseInt(nbh.getText());
int prixheure=Integer.parseInt(ph.getText());
String dated=((JTextField)dd.getDateEditor().getUiComponent()).getText();
String datef=((JTextField)df.getDateEditor().getUiComponent()).getText();



        PreparedStatement pstmt1 = conn.prepareStatement("update  formation_ct set niveau='"+niv+"',nom_formation='"+nomf+"' , matiere='"+matier+"',cin_formateur='"+formateu+"',nb_heures='"+nbheure+"', prix_heure='"+prixheure+"',date_debut='"+dated+"',date_fin='"+datef+"'  where id_form= '"+idf+"' ");

java.util.Date d1=dd.getDate();
                java.util.Date d2=df.getDate();
                if (d1.after(d2))
                {
               JOptionPane.showMessageDialog(null,"date de fin doit ètre après la date de debut");
                }
                else{


         int resultat = pstmt1.executeUpdate();


	    		 JOptionPane.showMessageDialog(null,"mise à jour effectuer");
                }

}

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
         update_fct ();


       
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
annule_f();

    }//GEN-LAST:event_jButton6MouseClicked

    private void fctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fctMouseClicked
        // TODO add your handling code here:

      try{

           int row=fct.getSelectedRow();
           String ID=(fct.getModel().getValueAt(row, 0).toString());
           int id ;
           id=Integer.parseInt(ID);

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from formation_ct where id_form= '"+id+"' ");

          rs = pstmt1.executeQuery();


while (rs.next())
{

int cine=rs.getInt("cin_formateur") ;
Date d1=rs.getDate("date_debut");
Date d2=rs.getDate("date_fin");
dd.setDate(d1);
df.setDate(d2);
String niv=rs.getString("niveau");
String nomf=rs.getString("nom_formation");
nf.setText(nomf);

int nbhr=rs.getInt("nb_heures");
int phr=rs.getInt("prix_heure");
nbh.setText(Integer.toString(nbhr));
ph.setText(Integer.toString(phr));




}


	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
    }//GEN-LAST:event_fctMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        int c=JOptionPane.showConfirmDialog(null,"tu veux supprimer"," supprime",JOptionPane.YES_NO_OPTION);
        if(c==0){
        try{
              int row=fct.getSelectedRow();
 String ID=(fct.getModel().getValueAt(row, 0).toString());
           int idf ;
           idf=Integer.parseInt(ID);
            String niv=(fct.getModel().getValueAt(row, 1).toString());
           String form=(fct.getModel().getValueAt(row, 2).toString());
           String tp="FCT";

PreparedStatement pstmt2 = conn.prepareStatement("select * from  inscription   where formation= '"+form+"' and niveau='"+niv+"' and type_formation='"+tp+"' ");
rs=pstmt2.executeQuery();
if(rs.next())

{
 JOptionPane.showMessageDialog(null,"Erreur suppression, il'y a des étudiants qui ont inscrivé");
}

else
{

        PreparedStatement pstmt1 = conn.prepareStatement("delete from  formation_ct    where id_form= '"+idf+"' ");




         int resultat = pstmt1.executeUpdate();


	    		 JOptionPane.showMessageDialog(null,"suppression effectuer");



}
	    }
	    	catch(Exception e){
	    		System.out.println(e.getMessage());

	    	}}
         update_fct ();

    }//GEN-LAST:event_jButton3MouseClicked

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
        String nomf=jTextField1.getText();
        String niv=jComboBox1.getSelectedItem().toString();
        try
        {
         PreparedStatement pstmt1 = conn.prepareStatement("select * from formation_ct where nom_formation='"+nomf+"' and niveau='"+niv+"'");
          rs = pstmt1.executeQuery();
         if (rs.next())
         {
           int cine=rs.getInt("cin_formateur") ;
Date d1=rs.getDate("date_debut");
Date d2=rs.getDate("date_fin");
dd.setDate(d1);
df.setDate(d2);
String nivea=rs.getString("niveau");
String nomfor=rs.getString("nom_formation");
nf.setText(nomfor);

int nbhr=rs.getInt("nb_heures");
int phr=rs.getInt("prix_heure");
nbh.setText(Integer.toString(nbhr));
ph.setText(Integer.toString(phr));
         }
          else
{
 JOptionPane.showMessageDialog(null,"Formation n'existe pas");
}
        }
        catch(Exception e)
        {
System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton7MouseClicked

    private void nfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nfKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) || c==KeyEvent.VK_PERIOD || c==KeyEvent.VK_SPACE  || c==KeyEvent.VK_BACK_SPACE ))
        {
          JOptionPane.showMessageDialog(null,"type non valide");
        }
    }//GEN-LAST:event_nfKeyTyped

    private void nbhKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nbhKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_PERIOD || c==KeyEvent.VK_BACK_SPACE ))
        {
          JOptionPane.showMessageDialog(null,"type non valide");
        }
    }//GEN-LAST:event_nbhKeyTyped

    private void phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_PERIOD || c==KeyEvent.VK_BACK_SPACE ))
        {
          JOptionPane.showMessageDialog(null,"type non valide");
        }
    }//GEN-LAST:event_phKeyTyped

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajout;
    private com.toedter.calendar.JDateChooser dd;
    private com.toedter.calendar.JDateChooser df;
    private javax.swing.JTable fct;
    private javax.swing.JComboBox formateur;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox matiere;
    private javax.swing.JTextField nbh;
    private javax.swing.JTextField nf;
    private java.awt.Panel panel2;
    private javax.swing.JTextField ph;
    // End of variables declaration//GEN-END:variables

}