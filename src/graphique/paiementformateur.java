/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * paiementformateur.java
 *
 * Created on 20 févr. 2014, 22:36:12
 */

package graphique;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import net.proteanit.sql.DbUtils ;

/**
 *
 * @author kalb
 */
public class paiementformateur extends javax.swing.JFrame {
    ResultSet rs ,rs2;
    Connection conn=connexion_bd.connexion();

    /** Creates new form paiementformateur */
    public paiementformateur() {
        initComponents();
         paiement();
         annule();
         modifier();
         recherche();
         conn=connexion_bd.connexion();
    update_paiement();
    }
    private void imprime () throws IOException
    {
        try
        {
    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"C:\\Users\\zied_2\\Documents\\NetBeansProjects\\Gesfor\\dist\\paiement_formateur.pdf");
        }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }
    }
   private void update_paiement(){
    try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from paiement_formateur  ");

          rs = pstmt1.executeQuery();

paief.setModel(DbUtils.resultSetToTableModel(rs));

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
   }
    private void  paiement(){
        try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("insert into paiement_formateur (cin_formateur,montant,date) values (?,?,?)");



  pstmt1.setInt(1,Integer.parseInt(cinformateur.getText()));
   pstmt1.setInt(2,Integer.parseInt(montant.getText()));
   pstmt1.setString(3,((JTextField)datepaie.getDateEditor().getUiComponent()).getText());


         int resultat = pstmt1.executeUpdate();



	    		 JOptionPane.showMessageDialog(null,"paiement enregistrer");
	    }
	    	catch(Exception c){
	    		

	    	}

    update_paiement();
    }
    private void annule(){
    cinformateur.setText("Cin formateur");
    montant.setText("Montant");
    datepaie.setDate(null);
    }
    private void modifier(){
    try{
              int row=paief.getSelectedRow();
 String ID=(paief.getModel().getValueAt(row, 0).toString());
           int id ;
           id=Integer.parseInt(ID);

String cinfor=cinformateur.getText();
int cinf=Integer.parseInt(cinfor);
String montanp=montant.getText();
int montan=Integer.parseInt(montanp);
String datep=((JTextField)datepaie.getDateEditor().getUiComponent()).getText();




        PreparedStatement pstmt1 = conn.prepareStatement("update  paiement_formateur set cin_formateur='"+cinf+"',montant='"+montan+"',date='"+datep+"'  where id_paiement= '"+id+"' ");




         int resultat = pstmt1.executeUpdate();


	    		 JOptionPane.showMessageDialog(null,"mise à jour effectuer");




	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
    update_paiement();
    }
    private void recherche(){}

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
        paief = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        datepaie = new com.toedter.calendar.JDateChooser();
        montant = new javax.swing.JTextField();
        cinformateur = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1070, 650));
        getContentPane().setLayout(null);

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setLayout(null);

        paief.setModel(new javax.swing.table.DefaultTableModel(
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
        paief.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paiefMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(paief);

        panel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 90, 660, 450);

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/supprimer-icone-7248-32.png"))); // NOI18N
        jButton1.setText("annuler paiement");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        panel1.add(jButton1);
        jButton1.setBounds(730, 480, 180, 50);

        jButton2.setBackground(new java.awt.Color(153, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/kedit-icone-8843-32.png"))); // NOI18N
        jButton2.setText("modifier paiement");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        panel1.add(jButton2);
        jButton2.setBounds(730, 410, 180, 50);

        jButton6.setBackground(new java.awt.Color(153, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_print.png"))); // NOI18N
        jButton6.setText("imprimer paiement");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        panel1.add(jButton6);
        jButton6.setBounds(730, 340, 180, 50);

        jButton4.setBackground(new java.awt.Color(153, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/correct.png"))); // NOI18N
        jButton4.setText("enregistrer paiement");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        panel1.add(jButton4);
        jButton4.setBounds(730, 270, 180, 50);

        datepaie.setDateFormatString("yyyy-MM-dd");
        datepaie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datepaieMouseClicked(evt);
            }
        });
        panel1.add(datepaie);
        datepaie.setBounds(730, 210, 180, 40);

        montant.setText("Montant");
        montant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                montantMouseClicked(evt);
            }
        });
        panel1.add(montant);
        montant.setBounds(730, 150, 180, 40);

        cinformateur.setText("Cin formateur");
        cinformateur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cinformateurMouseClicked(evt);
            }
        });
        panel1.add(cinformateur);
        cinformateur.setBounds(730, 90, 180, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24));
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Gestionnaire De Paiement  Formateur");
        panel1.add(jLabel2);
        jLabel2.setBounds(240, 40, 440, 30);

        getContentPane().add(panel1);
        panel1.setBounds(40, 10, 970, 590);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/logooo copie.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1080, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        paiement();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        annule();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        modifier();
    }//GEN-LAST:event_jButton2MouseClicked

    private void cinformateurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cinformateurMouseClicked
cinformateur.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_cinformateurMouseClicked

    private void montantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_montantMouseClicked
montant.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_montantMouseClicked

    private void datepaieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datepaieMouseClicked
        // TODO add your handling code here:
        datepaie.setDate(null);
    }//GEN-LAST:event_datepaieMouseClicked

    private void paiefMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paiefMouseClicked
        // TODO add your handling code here:
  try{

           int row=paief.getSelectedRow();
           String ID=(paief.getModel().getValueAt(row, 0).toString());
           int id ;
           id=Integer.parseInt(ID);

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from paiement_formateur where id_paiement= '"+id+"' ");

          rs = pstmt1.executeQuery();

if (rs.next())
{
   int cinfor=rs.getInt("cin_formateur");
  cinformateur.setText(Integer.toString(cinfor));
  int montan=rs.getInt("montant");
 montant.setText(Integer.toString(montan));
Date dp=rs.getDate("date");
datepaie.setDate(dp);


}

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}

    }//GEN-LAST:event_paiefMouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
          Font Header3 =FontFactory.getFont("Arial",BaseFont.IDENTITY_H,9,Font.NORMAL);
     Document document = new Document();
     String NomFichierPDF = "paiement_formateur.pdf";

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
document.add(new Paragraph("                                                         Fiche de paie formateur"));
document.add(new Paragraph("                                                                                                    "));
document.add(new Paragraph("                                                                     "+datecurrent+"                "));
document.add(new Paragraph("                                                                        "));

      PdfPTable Table = new PdfPTable(2);

      Table.setWidthPercentage(70f);

      Table.setWidths(new int []{50,50});
          int row=paief.getSelectedRow();
           String ID=(paief.getModel().getValueAt(row, 0).toString());
           int id ;
           id=Integer.parseInt(ID);

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from paiement_formateur where id_paiement= '"+id+"' ");

          rs = pstmt1.executeQuery();
String cinf="";
String montantp="";
String date="";
int cinfo=0;
if (rs.next())
{
   int cinfor=rs.getInt("cin_formateur");
  cinf=Integer.toString(cinfor);
  int montan=rs.getInt("montant");
  montantp=Integer.toString(montan);
Date dp=rs.getDate("date");
date=dp.toString();
cinfo=cinfor;


}
PreparedStatement pstmt2 = conn.prepareStatement("select * from formateur where cin_formateur= '"+cinfo+"' ");

          rs2 = pstmt2.executeQuery();
          String nomf="";  String prnomf="";
          if (rs2.next())
{
  String nomfor=rs2.getString("nom");
  nomf=nomfor;

String prenfor=rs2.getString("prenom");
  prnomf=prenfor;

}

     Table.addCell("Id paiement");
      Table.addCell(ID);
      Table.addCell("Cin_formateur");
      Table.addCell(cinf);
      Table.addCell("Nom formateur");
      Table.addCell(nomf);
      Table.addCell("Prénom formateur");
      Table.addCell(prnomf);
      Table.addCell("Montant payé");
      Table.addCell(montantp);
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

    }//GEN-LAST:event_jButton6MouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new paiementformateur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cinformateur;
    private com.toedter.calendar.JDateChooser datepaie;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField montant;
    private javax.swing.JTable paief;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables

}
