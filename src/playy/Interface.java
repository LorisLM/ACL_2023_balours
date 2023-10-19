package playy;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.Color;

public class Interface extends JPanel {
	public void paint(Graphics g){
		int taille_laby = 50;
		int pos_x = 700;
		int pos_y = 700;
	    g.setColor(new Color(0, 128, 0));
		g.drawRect(500, 250, 10 * taille_laby, 10 * taille_laby);
		g.fillRect(500, 250, 10 * taille_laby, 10 * taille_laby);
	    g.setColor(new Color(135, 206, 235));
		g.fillOval(pos_x, pos_y, 10, 10);
	}
	public static void main(String[] args) {
		JFrame fen = new JFrame("Jeu");
		fen.setSize(1000, 900);
	    fen.setVisible(true);

	    // Création des boutons de difficultés
        JPanel panel = new JPanel();
        JButton btn1 = new JButton("Facile");
        JButton btn2 = new JButton("Moyen");
        JButton btn3 = new JButton("Diffcile"); 
        fen.add(btn1); 
        fen.add(btn2);
        fen.add(btn3);
        fen.add(panel);
        
        fen.getContentPane().add(new Interface());
        
        // Affichage de l'interface
        fen.pack();
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fen.setVisible(true);
	}
}
