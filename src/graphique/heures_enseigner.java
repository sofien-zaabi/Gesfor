/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * heures_enseigner.java
 *
 * Created on 23 avr. 2014, 20:58:45
 */

package graphique;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author zied_2
 */
public class heures_enseigner extends javax.swing.JFrame {
     ResultSet rs , rs2;
    Connection conn=connexion_bd.connexion();

    /** Creates new form heures_enseigner */
    public heures_enseigner() {
        initComponents();
        update_formateur();
        update_matiere();
        update_matiereenseigner();
        ajout_matiereenseigner();
        liste();
        modifier();
    }
private void liste()
{
    DefaultListModel m=new  DefaultListModel();
    m.addElement("coeffecient"+"     "+"matière");
    try{
    int formation=Integer.parseInt(form.getText());
    PreparedStatement pstmt1 = conn.prepareStatement("select * from heures_enseignee where id_formation='"+formation+"' ");

          rs = pstmt1.executeQuery();
          while (rs.next())
          {
          String matier=rs.getString("matiere");
          int coef=rs.getInt("coeffecient");
          String coeffecient=Integer.toString(coef);
          m.addElement(""+coeffecient+"" +"                        "+matier+"");
          }
          jList1.setModel(m);
    }
    catch(Exception e)
    {
    System.out.println(e.getMessage());
    }
}
    private void  update_formateur()

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
        private void update_matiere()
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
        private void update_matiereenseigner()
        {
try{

	    		PreparedStatement pstmt1 = conn.prepareStatement("select * from heures_enseignee ");

          rs = pstmt1.executeQuery();

heure_enseigner.setModel(DbUtils.resultSetToTableModel(rs));

	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
        }
        private void ajout_matiereenseigner()
        {
              try
     {
                   int formation=Integer.parseInt(form.getText());
                   String matier=matiere.getSelectedItem().toString();

    PreparedStatement pstmt2 = conn.prepareStatement("select * from heures_enseignee where id_formation='"+formation+"' and matiere='"+matier+"' ");

          rs = pstmt2.executeQuery();
          if(rs.next())
          {
           JOptionPane.showMessageDialog(null,"matière enseignée déja enregistré");
          }
          else{
         PreparedStatement pstmt1=conn.prepareStatement("insert into heures_enseignee (id_formation,matiere,cin_formateur,nbheures_par_mois,coeffecient) values (?,?,?,?,?)");

int format=Integer.parseInt(formateur.getSelectedItem().toString());

pstmt1.setInt(1,Integer.parseInt(form.getText()));
pstmt1.setString(2,matier);
pstmt1.setInt(3,format);
pstmt1.setInt(4,Integer.parseInt(nbhpm.getText()));
pstmt1.setInt(5,Integer.parseInt(coeff.getText()));

      int resultat = pstmt1.executeUpdate();
       JOptionPane.showMessageDialog(null,"matière enregistrer");
     }}
     catch(Exception e)
     {
    System.out.println(e.getMessage());

	    	}
         update_matiereenseigner();

        }
        private void modifier()
        {

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
        heure_enseigner = new javax.swing.JTable();
        nbhpm = new javax.swing.JTextField();
        form = new javax.swing.JTextField();
        coeff = new javax.swing.JTextField();
        formateur = new javax.swing.JComboBox();
        matiere = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 660));
        setResizable(false);
        getContentPane().setLayout(null);

        heure_enseigner.setModel(new javax.swing.table.DefaultTableModel(
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
        heure_enseigner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                heure_enseignerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(heure_enseigner);

        nbhpm.setText("Nombre d'heures par mois");
        nbhpm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nbhpmMouseClicked(evt);
            }
        });
        nbhpm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nbhpmKeyTyped(evt);
            }
        });

        form.setText("Id Formation");
        form.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        form.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        coeff.setText("Coeffecient");
        coeff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coeffMouseClicked(evt);
            }
        });
        coeff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                coeffKeyTyped(evt);
            }
        });

        formateur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "           " }));

        matiere.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "        " }));

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/supprimer-icone-4878-32.png"))); // NOI18N
        jButton1.setText("Supprimer");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/kedit-icone-8843-32.png"))); // NOI18N
        jButton2.setText("Modifier");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 204, 204));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/supprimer-icone-7248-32.png"))); // NOI18N
        jButton3.setText("annuler");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 204, 204));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/ajouter-crayon-icone-4828-32.png"))); // NOI18N
        jButton4.setText("Ajouter");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24));
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Gestionnaire De Matières de Formation Continue");

        jScrollPane2.setViewportView(jList1);

        jButton5.setBackground(new java.awt.Color(0, 204, 204));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/demande-afficher-la-liste-icone-8709-32.png"))); // NOI18N
        jButton5.setText("Lister matières");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(form, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(matiere, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(formateur, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(coeff, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(nbhpm, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(form, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matiere, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formateur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coeff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbhpm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(panel1);
        panel1.setBounds(130, 30, 840, 560);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/logooo copie.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1400, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        form.setText("");
    }//GEN-LAST:event_formMouseClicked

    private void coeffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coeffMouseClicked
        // TODO add your handling code here:
        coeff.setText("");
    }//GEN-LAST:event_coeffMouseClicked

    private void nbhpmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nbhpmMouseClicked
        // TODO add your handling code here:
        nbhpm.setText("");
    }//GEN-LAST:event_nbhpmMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        ajout_matiereenseigner();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        liste();
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
         DefaultListModel n=new  DefaultListModel();
    n.addElement("");
        form.setText("Id_formation");
        coeff.setText("Coeffecient");
        nbhpm.setText("Nombre d'heures par mois");
        jList1.setModel(n);
    }//GEN-LAST:event_jButton3MouseClicked

    private void heure_enseignerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_heure_enseignerMouseClicked
        // TODO add your handling code here:
        try{

           int row=heure_enseigner.getSelectedRow();
           String IDf=(heure_enseigner.getModel().getValueAt(row, 0).toString());
           String matier=(heure_enseigner.getModel().getValueAt(row, 1).toString());
           String cinf=(heure_enseigner.getModel().getValueAt(row, 2).toString());
           String nbh=(heure_enseigner.getModel().getValueAt(row, 3).toString());
           String coeffec=(heure_enseigner.getModel().getValueAt(row, 4).toString());

 form.setText(IDf);
        coeff.setText(coeffec);
        nbhpm.setText(nbh);
           
	    }
	    	catch(Exception c){
	    		System.out.println(c.getMessage());

	    	}
    }//GEN-LAST:event_heure_enseignerMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        int row=heure_enseigner.getSelectedRow();
           String IDf=(heure_enseigner.getModel().getValueAt(row, 0).toString());
           String matier=(heure_enseigner.getModel().getValueAt(row, 1).toString());
           int idf=Integer.parseInt(IDf);
           int c=JOptionPane.showConfirmDialog(null,"tu veux supprimer"," supprime",JOptionPane.YES_NO_OPTION);
        if(c==0){
         try{

           PreparedStatement pstmt1 = conn.prepareStatement("delete  from heures_enseignee where id_formation='"+idf+"' and matiere='"+matier+"' ");

          int resultat = pstmt1.executeUpdate();

JOptionPane.showMessageDialog(null,"suppression éffectuer");


	    }
	    	catch(Exception e){
	    		System.out.println(e.getMessage());

	    	}}
           update_matiereenseigner();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        int row=heure_enseigner.getSelectedRow();
           String IDf=(heure_enseigner.getModel().getValueAt(row, 0).toString());
           String matier=(heure_enseigner.getModel().getValueAt(row, 1).toString());
           int idf=Integer.parseInt(IDf);
           String matieree=matiere.getSelectedItem().toString();
           int cinf=Integer.parseInt(formateur.getSelectedItem().toString());
           int nbh=Integer.parseInt(nbhpm.getText());
           int coef=Integer.parseInt(coeff.getText());

         try{

           PreparedStatement pstmt1 = conn.prepareStatement("update  heures_enseignee set matiere='"+matieree+"',cin_formateur='"+cinf+"' , nbheures_par_mois='"+nbh+"' , coeffecient='"+coef+"'  where id_formation='"+idf+"' and matiere='"+matier+"' ");

          int resultat = pstmt1.executeUpdate();

JOptionPane.showMessageDialog(null,"mise à jour effectuer");


	    }
	    	catch(Exception e){
	    		System.out.println(e.getMessage());

	    	}
           update_matiereenseigner();

    }//GEN-LAST:event_jButton2MouseClicked

    private void coeffKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coeffKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_PERIOD || c==KeyEvent.VK_BACK_SPACE ))
        {
          JOptionPane.showMessageDialog(null,"type non valide");
        }

    }//GEN-LAST:event_coeffKeyTyped

    private void nbhpmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nbhpmKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_PERIOD || c==KeyEvent.VK_BACK_SPACE ))
        {
          JOptionPane.showMessageDialog(null,"type non valide");
        }

    }//GEN-LAST:event_nbhpmKeyTyped

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_PERIOD || c==KeyEvent.VK_BACK_SPACE ))
        {
          JOptionPane.showMessageDialog(null,"type non valide");
        }

    }//GEN-LAST:event_formKeyTyped

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new heures_enseigner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField coeff;
    private javax.swing.JTextField form;
    private javax.swing.JComboBox formateur;
    private javax.swing.JTable heure_enseigner;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox matiere;
    private javax.swing.JTextField nbhpm;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables

}
