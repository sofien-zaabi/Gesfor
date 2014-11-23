/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * projets.java
 *
 * Created on 21 mars 2014, 14:39:09
 */

package graphique;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import net.proteanit.sql.DbUtils ;

/**
 *
 * @author zied_2
 */
public class projets extends javax.swing.JFrame {
    ResultSet rs , rs2 , rs3,rs4;
    Connection conn=connexion_bd.connexion();

    /** Creates new form projets */
    public projets() {
        initComponents();
         update_seance();
         update_projet();
         ajouter_prjet();
        modifier_projet();
        supprime_projet();
        annuler();
        recherche_projet();
        update_formateur();
        update_etudiant();
        update_proj();
        
        ajout_seance();
        supprime_seance();
        modifier_seance();
        annuler_seance();
       

        conn=connexion_bd.connexion();
        this.setTitle("Gestionnaire de projets");
    }
    //affichage formateur dans jcombobox
     private void imprime ()
    {
        try
        {
    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"C:\\Users\\zied_2\\Documents\\NetBeansProjects\\Gesfor\\dist\\encadrement.pdf");
        }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }
    }
       private void imprimeat ()
    {
        try
        {
    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"C:\\Users\\zied_2\\Documents\\NetBeansProjects\\Gesfor\\dist\\attest.pdf");
        }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }
    }
    private void  update_formateur(){
     try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("select cin_formateur from formateur");

          rs = pstmt1.executeQuery();

while(rs.next())
{
    String cinf=rs.getString("cin_formateur");
    jComboBox1.addItem(cinf);
}

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
    }
   
    //affichage projet dans table projet
    private void update_projet(){
           try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from projet");

          rs = pstmt1.executeQuery();

table_projet.setModel(DbUtils.resultSetToTableModel(rs));

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
    }
    //code ajout projet
    private void ajouter_prjet(){
     try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("insert into projet (sujet,cin_formateur,date_debut,date_fin) values (?,?,?,?)");
String form=jComboBox1.getSelectedItem().toString();

         pstmt1.setString(1,sujet.getText());
         pstmt1.setString(3,((JTextField)dd.getDateEditor().getUiComponent()).getText());
          pstmt1.setInt(2,Integer.parseInt(form));
       pstmt1.setString(4,((JTextField)df.getDateEditor().getUiComponent()).getText());
java.util.Date d1=dd.getDate();
                java.util.Date d2=df.getDate();
                if (d1.after(d2))
                {
               JOptionPane.showMessageDialog(null,"date de fin doit ètre après la date de debut");
                }
                else{

         int resultat = pstmt1.executeUpdate();



	    		 JOptionPane.showMessageDialog(null,"projet ajouter");
                }
	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
         update_projet();
    }
    //code modif projet
    private void   modifier_projet(){
      try{
              int row=table_projet.getSelectedRow();
 String ID=(table_projet.getModel().getValueAt(row, 0).toString());
           int id ;
           id=Integer.parseInt(ID);
String form=jComboBox1.getSelectedItem().toString();
int formateur=Integer.parseInt(form);
String suje=sujet.getText();
String d1=((JTextField)dd.getDateEditor().getUiComponent()).getText();
String d2=((JTextField)df.getDateEditor().getUiComponent()).getText();



        PreparedStatement pstmt1 = conn.prepareStatement("update  projet set sujet='"+suje+"',cin_formateur='"+formateur+"' , date_debut='"+d1+"',date_fin='"+d2+"' where id_projet= '"+id+"' ");

java.util.Date ddb=dd.getDate();
                java.util.Date ddf=df.getDate();
                if (ddb.after(ddf))
                {
               JOptionPane.showMessageDialog(null,"date de fin doit ètre après la date de debut");
                }
                else{


         int resultat = pstmt1.executeUpdate();


	    		 JOptionPane.showMessageDialog(null,"mise à jour effectuer");


                }

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
         update_projet ();



    }
    //code supprime projet
    private void supprime_projet(){
      try{

           int row=table_projet.getSelectedRow();
           String ID=(table_projet.getModel().getValueAt(row, 0).toString());
           int id ;
           id=Integer.parseInt(ID);

	    		PreparedStatement pstmt1 = conn.prepareStatement("delete  from projet where id_projet= '"+id+"' ");

         int resultat= pstmt1.executeUpdate();

JOptionPane.showMessageDialog(null,"projet supprimer avec succes");

}


	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
         update_projet ();

    }
    // code pour vider les champs
    private void annuler(){
    sujet.setText("");
    dd.setDate(null);
    df.setDate(null);
    }
    private void recherche_projet(){}
///////****************************seance d'encadrement****************************
    private void update_seance()
    {
         try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from seance_encadrement ");

          rs = pstmt1.executeQuery();

jTable1.setModel(DbUtils.resultSetToTableModel(rs));

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
    }

    private void supprime_seance(){

    }
     private void ajout_seance(){
try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("insert into seance_encadrement (projet,cin_etudiant,nb_heures,prix_heure,date) values (?,?,?,?,?)");
String proj=projet.getSelectedItem().toString();
String cine=cin_etudiant.getSelectedItem().toString();

         pstmt1.setString(1,proj);
          pstmt1.setInt(2,Integer.parseInt(cine));
         pstmt1.setInt(3,Integer.parseInt(nbheures.getText()));
         pstmt1.setInt(4,Integer.parseInt(prixheure.getText()));

       pstmt1.setString(5,((JTextField)dateseance.getDateEditor().getUiComponent()).getText());


         int resultat = pstmt1.executeUpdate();



	    		 JOptionPane.showMessageDialog(null,"seance enregistrer");
	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
         update_seance();
    }
      private void modifier_seance(){

    }
     //affichage projet dans jcombobox
    private void update_proj(){
        try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("select sujet from projet");

          rs = pstmt1.executeQuery();

while(rs.next())
{
    String cinf=rs.getString("sujet");
    projet.addItem(cinf);
}

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
    
    }
    //affichage etudiant dans jcombobox
    private void update_etudiant() {
          try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("select cin_etudiant from etudiant");

          rs = pstmt1.executeQuery();

while(rs.next())
{
    int cine=rs.getInt("cin_etudiant");
    cin_etudiant.addItem(Integer.toString(cine));
}

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}

    }
    private void annuler_seance()
    {
    nbheures.setText("");
    prixheure.setText("");
    dateseance.setDate(null);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table_projet = new javax.swing.JTable();
        sujet = new javax.swing.JTextField();
        dd = new com.toedter.calendar.JDateChooser();
        df = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        nbheures = new javax.swing.JTextField();
        prixheure = new javax.swing.JTextField();
        cin_etudiant = new javax.swing.JComboBox();
        projet = new javax.swing.JComboBox();
        dateseance = new com.toedter.calendar.JDateChooser();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        panel3 = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setLayout(null);

        table_projet.setModel(new javax.swing.table.DefaultTableModel(
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
        table_projet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_projetMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_projet);

        panel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 130, 650, 300);
        panel1.add(sujet);
        sujet.setBounds(130, 10, 190, 40);

        dd.setDateFormatString("yyyy-MM-dd");
        panel1.add(dd);
        dd.setBounds(460, 70, 170, 40);

        df.setDateFormatString("yyyy-MM-dd");
        panel1.add(df);
        df.setBounds(130, 70, 200, 40);

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/supprimer-icone-7248-32.png"))); // NOI18N
        jButton3.setText("annuler");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel1.add(jButton3);
        jButton3.setBounds(370, 490, 140, 40);

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/ajouter-crayon-icone-4828-32.png"))); // NOI18N
        jButton1.setText("ajouter");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel1.add(jButton1);
        jButton1.setBounds(370, 440, 140, 40);

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/kedit-icone-8843-32.png"))); // NOI18N
        jButton4.setText("modifier");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panel1.add(jButton4);
        jButton4.setBounds(200, 440, 150, 40);

        jButton5.setBackground(new java.awt.Color(204, 204, 255));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/supprimer-icone-4878-32.png"))); // NOI18N
        jButton5.setText("supprimer");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panel1.add(jButton5);
        jButton5.setBounds(20, 440, 160, 40);

        jTextField3.setText("recherche par sujet");
        panel1.add(jTextField3);
        jTextField3.setBounds(20, 490, 160, 40);

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/recherche-icone-4239-32.png"))); // NOI18N
        jButton2.setText("recherche");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel1.add(jButton2);
        jButton2.setBounds(200, 490, 150, 40);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "            " }));
        panel1.add(jComboBox1);
        jComboBox1.setBounds(460, 10, 170, 40);

        jLabel9.setText("Sujet:");
        panel1.add(jLabel9);
        jLabel9.setBounds(40, 20, 70, 20);

        jLabel10.setText("Formateur:");
        panel1.add(jLabel10);
        jLabel10.setBounds(350, 20, 90, 20);

        jLabel11.setText("Date fin:");
        panel1.add(jLabel11);
        jLabel11.setBounds(350, 80, 80, 14);

        jLabel12.setText("Date debut:");
        panel1.add(jLabel12);
        jLabel12.setBounds(40, 80, 80, 14);

        getContentPane().add(panel1);
        panel1.setBounds(670, 160, 680, 540);

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        panel2.add(jScrollPane2);
        jScrollPane2.setBounds(20, 270, 600, 300);

        nbheures.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nbheuresMouseClicked(evt);
            }
        });
        panel2.add(nbheures);
        nbheures.setBounds(100, 210, 130, 40);

        prixheure.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prixheureMouseClicked(evt);
            }
        });
        prixheure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prixheureActionPerformed(evt);
            }
        });
        panel2.add(prixheure);
        prixheure.setBounds(310, 210, 130, 40);

        cin_etudiant.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "         " }));
        panel2.add(cin_etudiant);
        cin_etudiant.setBounds(100, 150, 130, 40);

        projet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "     " }));
        panel2.add(projet);
        projet.setBounds(310, 150, 170, 40);

        dateseance.setDateFormatString("yyyy-MM-dd");
        panel2.add(dateseance);
        dateseance.setBounds(480, 210, 150, 40);

        jButton7.setBackground(new java.awt.Color(204, 204, 255));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/ajouter-crayon-icone-4828-32.png"))); // NOI18N
        jButton7.setText("ajouter");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        panel2.add(jButton7);
        jButton7.setBounds(380, 580, 150, 40);

        jButton8.setBackground(new java.awt.Color(204, 204, 255));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/supprimer-icone-4878-32.png"))); // NOI18N
        jButton8.setText("supprimer");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        panel2.add(jButton8);
        jButton8.setBounds(20, 580, 150, 40);

        jButton9.setBackground(new java.awt.Color(204, 204, 255));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/kedit-icone-8843-32.png"))); // NOI18N
        jButton9.setText("modifier");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        panel2.add(jButton9);
        jButton9.setBounds(200, 580, 150, 40);

        jButton10.setBackground(new java.awt.Color(204, 204, 255));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/supprimer-icone-7248-32.png"))); // NOI18N
        jButton10.setText("annuler");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        panel2.add(jButton10);
        jButton10.setBounds(200, 630, 150, 40);

        jButton12.setBackground(new java.awt.Color(204, 204, 255));
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_print.png"))); // NOI18N
        jButton12.setText("Imprimer");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
        });
        panel2.add(jButton12);
        jButton12.setBounds(20, 630, 150, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24));
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Gestionnaire De Séances D'encadrement");
        panel2.add(jLabel2);
        jLabel2.setBounds(100, 40, 430, 40);

        jLabel4.setText("Cin_étudiant:");
        panel2.add(jLabel4);
        jLabel4.setBounds(10, 160, 80, 14);

        jLabel5.setText("Projet:");
        panel2.add(jLabel5);
        jLabel5.setBounds(230, 160, 70, 20);

        jLabel6.setText("Nombre d'heures:");
        panel2.add(jLabel6);
        jLabel6.setBounds(10, 220, 120, 14);

        jLabel7.setText("Prix d'heure:");
        panel2.add(jLabel7);
        jLabel7.setBounds(230, 220, 100, 14);

        jLabel8.setText("Date:");
        panel2.add(jLabel8);
        jLabel8.setBounds(440, 220, 80, 14);

        jButton6.setBackground(new java.awt.Color(204, 204, 255));
        jButton6.setText("Attestation stage");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        panel2.add(jButton6);
        jButton6.setBounds(380, 630, 150, 40);

        getContentPane().add(panel2);
        panel2.setBounds(20, 20, 640, 680);

        panel3.setBackground(new java.awt.Color(255, 255, 255));
        panel3.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24));
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Gestionnaire De Projets");
        panel3.add(jLabel3);
        jLabel3.setBounds(220, 40, 280, 40);

        getContentPane().add(panel3);
        panel3.setBounds(670, 20, 680, 130);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/logooo copie.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1400, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        ajouter_prjet();
        annuler();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        modifier_projet();
         annuler();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        supprime_projet();
         annuler();
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        annuler();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        recherche_projet();
    }//GEN-LAST:event_jButton2MouseClicked

    private void table_projetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_projetMouseClicked
        // TODO add your handling code here:
     
      try{

           int row=table_projet.getSelectedRow();
           String ID=(table_projet.getModel().getValueAt(row, 0).toString());
           int id ;
           id=Integer.parseInt(ID);

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from projet where id_projet= '"+id+"' ");

          rs = pstmt1.executeQuery();

int cinf=0;
while (rs.next())
{
    
int cin=rs.getInt("cin_formateur") ;

Date d1=rs.getDate("date_debut");
Date d2=rs.getDate("date_fin");
String suje=rs.getString("sujet");
sujet.setText(suje);
dd.setDate(d1);
df.setDate(d2);

cinf=cin;

}
  
 
	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
    }//GEN-LAST:event_table_projetMouseClicked

    private void prixheureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prixheureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prixheureActionPerformed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
       ajout_seance();
    }//GEN-LAST:event_jButton7MouseClicked

    private void nbheuresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nbheuresMouseClicked
        // TODO add your handling code here:
        nbheures.setText("");
    }//GEN-LAST:event_nbheuresMouseClicked

    private void prixheureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prixheureMouseClicked
        // TODO add your handling code here:
        prixheure.setText("");
    }//GEN-LAST:event_prixheureMouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // TODO add your handling code here:
        modifier_seance();
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
        supprime_seance();
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        // TODO add your handling code here:
        annuler_seance();
    }//GEN-LAST:event_jButton10MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         try{

           int row=jTable1.getSelectedRow();
           String ID=(jTable1.getModel().getValueAt(row, 0).toString());
           int id ;
           id=Integer.parseInt(ID);

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from seance_encadrement where id_seance= '"+id+"' ");

          rs = pstmt1.executeQuery();


while (rs.next())
{
 String proj=rs.getString("projet");
int nbh=rs.getInt("nb_heures") ;
int ph=rs.getInt("prix_heure") ;
int cin=rs.getInt("cin_etudiant") ;
Date d1=rs.getDate("date");

nbheures.setText(Integer.toString(nbh));
prixheure.setText(Integer.toString(ph));
dateseance.setDate(d1);




}


	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
 Font Header3 =FontFactory.getFont("Arial",BaseFont.IDENTITY_H,9,Font.NORMAL);
     Document document = new Document();
     String NomFichierPDF = "encadrement.pdf";

            try
      {
      PdfWriter.getInstance(document,new FileOutputStream(NomFichierPDF)).setInitialLeading(13f);
      document.open();
      Calendar cal=new GregorianCalendar() ;
      int Y=cal.get(Calendar.YEAR);
  int M=cal.get(Calendar.MONTH);
  int d=cal.get(Calendar.DAY_OF_MONTH);
  String datecurrent=Y+"-"+(M+1)+"-"+d ;
Image image=Image.getInstance("log.jpg");
      document.add(image);
      document.add(new Paragraph("                                                                                                    "));
      document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                                                         Fiche de paie d'encadrement"));
document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                                                                     "+datecurrent+"                "));
document.add(new Paragraph("                                                                        "));

      PdfPTable Table = new PdfPTable(2);

      Table.setWidthPercentage(70f);

      Table.setWidths(new int []{50,50});
       int row=jTable1.getSelectedRow();
           String ID=(jTable1.getModel().getValueAt(row, 0).toString());
           int id ;
           id=Integer.parseInt(ID);

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from seance_encadrement where id_seance= '"+id+"' ");

          rs = pstmt1.executeQuery();
String proj="";
String montant="";
String prix_h="";
String date="";
String nbheur="";
int cinetud=0;
if (rs.next())
{
   String proje=rs.getString("projet");
  int montan=rs.getInt("prix_heure");
  int nbh=rs.getInt("nb_heures");
   int cine=rs.getInt("cin_etudiant");
    cinetud=cine;
Date dp=rs.getDate("date");
date=dp.toString();
montant=Integer.toString(montan*nbh);
 nbheur=Integer.toString(nbh);
 prix_h=Integer.toString(montan);
}
PreparedStatement pstmt2 = conn.prepareStatement("select * from etudiant where cin_etudiant= '"+cinetud+"' ");

          rs2 = pstmt2.executeQuery();
          String nomf="";  String prnomf="";
          if (rs2.next())
{
  String nomfor=rs2.getString("nom");
  nomf=nomfor;

String prenfor=rs2.getString("prenom");
  prnomf=prenfor;

}


     Table.addCell("Id Encadrement");
      Table.addCell(ID);
      Table.addCell("Cin Etudiant");
      Table.addCell(Integer.toString(cinetud));
      Table.addCell("Nom");
      Table.addCell(nomf);
      Table.addCell("Prénom");
      Table.addCell(prnomf);
      Table.addCell("Prix d'heure");
      Table.addCell(prix_h);
      Table.addCell("Nombre d'heures");
      Table.addCell(nbheur);
      Table.addCell("Montant payé");
      Table.addCell(montant);
      Table.addCell("Date de paie");
      Table.addCell(date);



      document.add(Table);

document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("Centre de la formation professionnel                                           Signature Directrice "));
document.add(new Paragraph("Avenue 14 Janvier Rue Ahmed Aloulou                                                                 "));
document.add(new Paragraph("Imm. Ragheb étage. 2 App. 4 -Sfax                                                                                                   "));

document.close();

imprime();
      }catch(Exception e)
      {
      System.out.println(e.getMessage());
      }

    }//GEN-LAST:event_jButton12MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        Font Header3 =FontFactory.getFont("Arial",BaseFont.IDENTITY_H,20,Font.NORMAL,Color.LIGHT_GRAY);
     Document document = new Document();
     String NomFichierPDF = "attest.pdf";

            try
      {
      PdfWriter.getInstance(document,new FileOutputStream(NomFichierPDF)).setInitialLeading(13f);
      document.open();
      Calendar cal=new GregorianCalendar() ;
      int Y=cal.get(Calendar.YEAR);
  int M=cal.get(Calendar.MONTH);
  int d=cal.get(Calendar.DAY_OF_MONTH);
  String datecurrent=Y+"-"+(M+1)+"-"+d ;
Image image=Image.getInstance("att.jpg");
image.setAbsolutePosition(0, 0);
      document.add(image);
      document.add(new Paragraph("                                                                                                    "));
      document.add(new Paragraph("                                                                                                    "));
      document.add(new Paragraph("                                                                                                    "));
      document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                                     Attestation Du Stage",Header3));
document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                                                                        "+datecurrent+"                "));
document.add(new Paragraph("                                                                        "));

      
       int row=jTable1.getSelectedRow();
           String ID=(jTable1.getModel().getValueAt(row, 0).toString());
           int id ;
           id=Integer.parseInt(ID);

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from seance_encadrement where id_seance= '"+id+"' ");

          rs = pstmt1.executeQuery();
String proj="";

int cinetud=0;
if (rs.next())
{
   String proje=rs.getString("projet");
  proj=proje;
   int cine=rs.getInt("cin_etudiant");
    cinetud=cine;

}
PreparedStatement pstmt2 = conn.prepareStatement("select * from etudiant where cin_etudiant= '"+cinetud+"' ");

          rs2 = pstmt2.executeQuery();
          String nome="";  String prnome="";
          String mailet="" , nivet=""; int tel=0;
          if (rs2.next())
{
  String nomfor=rs2.getString("nom");
  nome=nomfor;
String maile=rs2.getString("mail");
mailet=maile;
String prenfor=rs2.getString("prenom");
  prnome=prenfor;
  int num=rs2.getInt("num_tel");
  tel=num;
  String niv=rs2.getString("niveau");
  nivet=niv;

}
          PreparedStatement pstmt3 = conn.prepareStatement("select * from projet where sujet= '"+proj+"' ");

          rs3 = pstmt3.executeQuery();
          String dated="";  String datef="";
          int cinf=0 ;
          if (rs3.next())
{
  int cin=rs3.getInt("cin_formateur");
  cinf=cin;
Date d1=rs3.getDate("date_debut");
dated=d1.toString();
Date d2=rs3.getDate("date_fin");
  datef=d2.toString();
  

}
          PreparedStatement pstmt4 = conn.prepareStatement("select * from formateur where cin_formateur= '"+cinf+"' ");

          rs4 = pstmt4.executeQuery();
          String nomfo="";  String prenfo="";

          if (rs4.next())
{
  int cin=rs4.getInt("cin_formateur");
  cinf=cin;
String n=rs4.getString("nom");
nomfo=n;
String pnf=rs4.getString("prenom");
  prenfo=pnf;


}
            PreparedStatement pstmt5 = conn.prepareStatement("select * from attestation where cin_etudiant= '"+cinetud+"' and projet='"+proj+"' ");

          rs = pstmt5.executeQuery();


          if (rs.next())
{



}
          else {
              PreparedStatement pstmt6 = conn.prepareStatement("insert into attestation (cin_etudiant , projet) values (?,?) ");
              pstmt6.setInt(1,cinetud);
pstmt6.setString(2,proj);
int res=pstmt6.executeUpdate();

          }



    

document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                Entreprise:                                                                            "));
document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                Entreprise:Centre de la formation professionnel Formaplus                             "));
document.add(new Paragraph("                Adresse   :Avenue 14 Janvier Rue Ahmed Aloulou ,Imm. Ragheb étage. 2 App.4"));
document.add(new Paragraph("                Ville         :Sfax        Téléphone1: 25363712          téléphone2:93813436"));
document.add(new Paragraph("                Fax          :.......................  Courriel:kawther.formaplus@gmail.com"));
document.add(new Paragraph("                Activités  :spécialisé dans l'enseignement de thèmes administratif , ainsi que la "));
document.add(new Paragraph("                suivi de la certification ISO"));
document.add(new Paragraph("                                                                                                  "));

document.add(new Paragraph("                Etudiant:                                                                                    "));
document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                Nom     : "+nome+"                                                                  "));
document.add(new Paragraph("                Prénom: "+prnome+"                                                                 "));
document.add(new Paragraph("                CIN      : "+cinetud+""));
document.add(new Paragraph("                Adresse email   : "+mailet+"             Téléphone: "+tel+"                       "));
document.add(new Paragraph("                Niveau d'étude  : "+nivet+"                                                       "));
document.add(new Paragraph("                                                                                                  "));
document.add(new Paragraph("                                                                                                  "));
document.add(new Paragraph("                Stage:                                                                                    "));
document.add(new Paragraph("                                                                                                    "));

document.add(new Paragraph("                Sujet de projet   : "+proj+"                      "));
document.add(new Paragraph("                Encadré par       : "+nomfo+" "+prenfo+"                       "));
document.add(new Paragraph("                Avis encadreur  : ........................................................................           "));
document.add(new Paragraph("                ....................................................................................................                      "));
document.add(new Paragraph("                Note (/20)          :                                                                                    "));
document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                Date de début: "+dated+"                                                Date de fin:"+datef+"                            "));

document.close();

imprimeat();
      }catch(Exception e)
      {
      System.out.println(e.getMessage());
      }


    }//GEN-LAST:event_jButton6MouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new projets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cin_etudiant;
    private com.toedter.calendar.JDateChooser dateseance;
    private com.toedter.calendar.JDateChooser dd;
    private com.toedter.calendar.JDateChooser df;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField nbheures;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private javax.swing.JTextField prixheure;
    private javax.swing.JComboBox projet;
    private javax.swing.JTextField sujet;
    private javax.swing.JTable table_projet;
    // End of variables declaration//GEN-END:variables

}
