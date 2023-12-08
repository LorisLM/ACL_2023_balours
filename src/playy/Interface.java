package playy;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class Interface extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[][] PlateauJeu;
    private ImageIcon MurIcon; // Stockage des icônes pour être plus optimisé
    private ImageIcon TerreIcon;
    private ImageIcon HerosIcon;
    private ImageIcon MonstreIcon;
    private ImageIcon PortailIcon;
    private ImageIcon FantomeIcon;
    private ImageIcon EpeeIcon;
    private ImageIcon SoinIcon;
    private ImageIcon TresorIcon;
    private ImageIcon MalusIcon;
    private boolean isStarted=false;

    public Interface(int[][] PlateauJeu) {
        this.PlateauJeu = PlateauJeu;
        setTitle("Jeu du chat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        MurIcon = createImageIcon("/playy/Images/Wall.jpg");
        TerreIcon = createImageIcon("/playy/Images/grass.png");
        HerosIcon = createImageIcon("/playy/Images/cat.png");
        MonstreIcon = createImageIcon("/playy/Images/monstre.png");
        PortailIcon = createImageIcon("/playy/Images/portail.png");
        SoinIcon = createImageIcon("/playy/Images/soin.png");
        EpeeIcon = createImageIcon("/playy/Images/epee.png");
        TresorIcon = createImageIcon("/playy/Images/tresor.png");
        FantomeIcon = createImageIcon("/playy/Images/fantome.png");
        MalusIcon = createImageIcon("/playy/Images/malus.png");
        
    }

    public void MAJPlateauJeu(int[][] updatedPlateauJeu) {
        this.PlateauJeu = updatedPlateauJeu;
    }

    public void AfficherJeu() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(1, 1, 1, 1);
        
        //Panel pour la difficulté
        JPanel difficultePanel = new JPanel(new GridLayout(3, 1));
        JButton facileButton = new JButton("Facile");
        JButton moyenButton = new JButton("Moyen");
        JButton difficileButton = new JButton("Difficile");

        difficultePanel.add(facileButton);
        difficultePanel.add(moyenButton);
        difficultePanel.add(difficileButton);

        add(difficultePanel);

        facileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Labyrinthe facile affiché");
                remove(difficultePanel); // Supprime le panel de choix de difficulté
                setSize(400, 400); // Nouvelle taille de fenêtre pour le labyrinthe
                isStarted=true;
                afficherLabyrinthe();
            }
        });

        moyenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code pour afficher le labyrinthe moyen
                System.out.println("Labyrinthe moyen affiché");
                remove(difficultePanel);
                setSize(700, 700);
                isStarted=true;
                afficherLabyrinthe();
            }
        });

        difficileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code pour afficher le labyrinthe difficile
                System.out.println("Labyrinthe difficile affiché");
                remove(difficultePanel);
                setSize(1000, 1001);
                isStarted=true;
                afficherLabyrinthe();
            }
        });
        
        setVisible(true);
    }
    
    public void afficherLabyrinthe() {
    	JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 0, 0, 0);
        int TailleCarre = 20;

        for (int i = 0; i < PlateauJeu.length; i++) {
            for (int j = 0; j < PlateauJeu[i].length; j++) {
                JPanel carre = new JPanel();
                carre.setPreferredSize(new Dimension(TailleCarre, TailleCarre));

                switch (PlateauJeu[i][j]) {
                    case -1: // Mur
                        if (MurIcon != null) {
                            JLabel wallLabel = new JLabel(MurIcon);
                            wallLabel.setPreferredSize(new Dimension(20, 20)); // Taille souhaitée
                            addComponent(panel, wallLabel, j, i); // Ajout à la position spécifique
                        }
                        break;
                    case 0: // Terre
                    	if (TerreIcon != null) {
                            JLabel terreLabel = new JLabel(TerreIcon);
                            terreLabel.setPreferredSize(new Dimension(20, 20)); // Taille souhaitée
                            addComponent(panel, terreLabel, j, i); // Ajout à la position spécifique
                        }
                        break;
                    case 2: // Heros
                    	if (HerosIcon != null) {
                            JLabel catLabel = new JLabel(HerosIcon);
                            catLabel.setPreferredSize(new Dimension(20, 20)); // Taille souhaitée
                            addComponent(panel, catLabel, j, i); // Ajout à la position spécifique
                        }
                        break;
                    case 9: // Monstre
                    	if (MonstreIcon != null) {
                            JLabel monstreLabel = new JLabel(MonstreIcon);
                            monstreLabel.setPreferredSize(new Dimension(20, 20)); // Taille souhaitée
                            addComponent(panel, monstreLabel, j, i); // Ajout à la position spécifique
                        }
                        break;
                    case 3: // Fantôme
                    	if (FantomeIcon != null) {
                            JLabel fantomeLabel = new JLabel(FantomeIcon);
                            fantomeLabel.setPreferredSize(new Dimension(20, 20)); // Taille souhaitée
                            addComponent(panel, fantomeLabel, j, i); // Ajout à la position spécifique
                        }
                        break;
                    case 4: // Malus
                    	if (MalusIcon != null) {
                            JLabel malusLabel = new JLabel(MalusIcon);
                            malusLabel.setPreferredSize(new Dimension(20, 20)); // Taille souhaitée
                            addComponent(panel, malusLabel, j, i); // Ajout à la position spécifique
                        }
                        break;
                    case 5: // Epee
                    	if (EpeeIcon != null) {
                            JLabel epeeLabel = new JLabel(EpeeIcon);
                            epeeLabel.setPreferredSize(new Dimension(20, 20)); // Taille souhaitée
                            addComponent(panel, epeeLabel, j, i); // Ajout à la position spécifique
                        }
                        break;
                    case 6: // Soins
                    	if (SoinIcon != null) {
                            JLabel soinLabel = new JLabel(SoinIcon);
                            soinLabel.setPreferredSize(new Dimension(20, 20)); // Taille souhaitée
                            addComponent(panel, soinLabel, j, i); // Ajout à la position spécifique
                        }
                        break;
                    case 7: // Tresor
                    	if (TresorIcon != null) {
                            JLabel tresorLabel = new JLabel(TresorIcon);
                            tresorLabel.setPreferredSize(new Dimension(20, 20)); // Taille souhaitée
                            addComponent(panel, tresorLabel, j, i); // Ajout à la position spécifique
                        }
                        break;
                    case 8: // Portail
                    	if (PortailIcon != null) {
                            JLabel portailLabel = new JLabel(PortailIcon);
                            portailLabel.setPreferredSize(new Dimension(20, 20)); // Taille souhaitée
                            addComponent(panel, portailLabel, j, i); // Ajout à la position spécifique
                        }
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
    }

    private void addComponent(Container container, Component component, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        container.add(component, gbc);
    }

    private ImageIcon createImageIcon(String path) {
        try {
            URL resource = getClass().getResource(path);
            if (resource != null) {
                Image img = ImageIO.read(resource).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                return new ImageIcon(img);
            } else {
                System.out.println("L'image " + path + " n'existe pas.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isStarted() {
        return isStarted;
    }
}
