/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gesfor;

import graphique.connexion;

/**
 *
 * @author kalb
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 connexion appel=new connexion();
                 appel.setLocationRelativeTo(null);
                appel.setVisible(true);
            }
        });

        
    }

}
