package playy;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Interface extends JFrame {

    private int[][] PlateauJeu;

    public Interface(int[][] PlateauJeu) {
        this.PlateauJeu = PlateauJeu;
        setTitle("Jeu du chat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
    }
    
    
    public void MAJPlateauJeu(int[][] updatedPlateauJeu) {
        this.PlateauJeu = updatedPlateauJeu;
    }

    
    public void AfficherJeu() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(1, 1, 1, 1);
        int TailleCarre = 20;

        
        for (int i = 0; i < PlateauJeu.length; i++) {
            for (int j = 0; j < PlateauJeu[i].length; j++) {
                JPanel carre = new JPanel();
                carre.setPreferredSize(new Dimension(TailleCarre, TailleCarre));

                
                switch (PlateauJeu[i][j]) {
                    case -1: // Mur
                        carre.setBackground(new Color(139, 69, 19));
                        break;
                    case 0: // Terre
                        carre.setBackground(new Color(210, 180, 140));
                        break;
                    case 2: // Heros
                        carre.setBackground(Color.WHITE);
                        break;
                    case 9: // Monstre
                        carre.setBackground(Color.BLACK);
                        break;
                    case 4: // Malus
                        carre.setBackground(Color.YELLOW);
                        break;
                    case 5: // Epee
                        carre.setBackground(Color.RED);
                        break;
                    case 6: // Soins
                        carre.setBackground(Color.GREEN);
                        break;
                    case 7: // Tresor
                        carre.setBackground(Color.CYAN);
                        break;
                    default:
                        break;
                }

                constraints.gridx = j;
                constraints.gridy = i;
                panel.add(carre, constraints);
            }
        }

        getContentPane().removeAll();
        add(panel);
        revalidate();
        repaint();
        setVisible(true);
    }
}