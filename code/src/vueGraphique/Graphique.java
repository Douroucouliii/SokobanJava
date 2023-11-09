package vueGraphique;

import modele.EDirection;
import modele.Carte;

import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** modelise le graphique du Sokoban (partie jeu) */
public class Graphique extends JFrame implements KeyListener {

    public static final Map<String, ImageIcon> lesImages = new HashMap<String, ImageIcon>();
    private int nbLignes;
    private int nbColonnes;
    private Carte carte;
    private Container cont;
    private JToolBar toolBar;
    private JPanel centre;
    private JPanel gauche;
    private JPanel sud;
    private JLabel[][] imagesLabel;
    private JButton retour;
    private JButton recommencer;
    private JButton menu;
    private JLabel nombreMouvement;
    private FinDePartie fin;
    private Menu menuPrincipal;

    public Graphique(Carte carte) {

        // On met comme titre le nom du niveau
        super("NIVEAU " + carte.getNomfichier().charAt(11)
                + (carte.getNomfichier().charAt(12) != '.' ? carte.getNomfichier().charAt(12) : ""));

        this.carte = carte;
        this.nbLignes = carte.getNbLignes();
        this.nbColonnes = carte.getNbColonnes();
        remplirLesImages();

        setDefaultCloseOperation(3);

        // On crée les components
        this.cont = getContentPane();

        this.toolBar = new JToolBar();

        this.centre = new JPanel();
        this.centre.setLayout(new GridLayout(nbLignes, nbColonnes));

        this.gauche = new JPanel();
        this.gauche.setLayout(new GridLayout(3, 1));

        this.sud = new JPanel();
        this.sud.setLayout(new GridLayout(1, 1));

        // On affiche la grille du jeu sur la map, les boutons à gauche, les
        // statistiques en bas
        imagesLabel = new JLabel[nbLignes][nbColonnes];
        initMap();
        initBoutonsGauche();
        initStatistiques();
        JLabel commandes = new JLabel("deplacement : ZQSD/fleches, retour en arriere : retour");

        cont.add(centre, BorderLayout.CENTER);
        cont.add(gauche, BorderLayout.WEST);
        cont.add(sud, BorderLayout.SOUTH);
        cont.add(commandes, BorderLayout.NORTH);

        // On active l'écoute d'évènement des keys
        addKeyListener(this);
        this.setFocusable(true);

        pack();
        setLocationRelativeTo(null);

        setVisible(true);

    }

    /**
     * Affiche la map avec les images
     */
    private void initMap() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                JLabel label = new JLabel(lesImages.get(carte.getMap()[i][j].toString()));
                imagesLabel[i][j] = label;
                centre.add(label);
            }
        }
    }

    /**
     * Reaffiche la map avec les nouvelles images
     */
    private void reinitMap() {
        changerRobotImage();
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                // On modifie uniquement les element de la map qui peuvent être changé
                if (!carte.getMap()[i][j].estFixe()) {
                    imagesLabel[i][j].setIcon(lesImages.get(carte.getMap()[i][j].toString()));
                }
            }
        }
    }

    private void changerRobotImage() {
        if (carte.getDirection() == EDirection.HAUT) {
            lesImages.replace("@", new ImageIcon(Graphique.class.getResource("../img/Haut.png")));
            lesImages.replace("+", new ImageIcon(Graphique.class.getResource("../img/Haut.png")));
        } else if (carte.getDirection() == EDirection.BAS) {
            lesImages.replace("@", new ImageIcon(Graphique.class.getResource("../img/Bas.png")));
            lesImages.replace("+", new ImageIcon(Graphique.class.getResource("../img/Bas.png")));
        } else if (carte.getDirection() == EDirection.GAUCHE) {
            lesImages.replace("@", new ImageIcon(Graphique.class.getResource("../img/Gauche.png")));
            lesImages.replace("+", new ImageIcon(Graphique.class.getResource("../img/Gauche.png")));
        } else if (carte.getDirection() == EDirection.DROITE) {
            lesImages.replace("@", new ImageIcon(Graphique.class.getResource("../img/Droite.png")));
            lesImages.replace("+", new ImageIcon(Graphique.class.getResource("../img/Droite.png")));
        }
    }

    /**
     * Initialise les boutons à gauche
     */
    private void initBoutonsGauche() {
        retour = new JButton("Retour");
        recommencer = new JButton("Recommencer");
        menu = new JButton("Menu");

        gauche.add(retour);
        gauche.add(recommencer);
        gauche.add(menu);

        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                carte.retourArriere();
                reinitMap();
                nombreMouvement.setText("Nombre de mouvements : " + carte.getNbMouvement());
                requestFocus();
            }
        });

        recommencer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lesImages.replace("@", new ImageIcon(Graphique.class.getResource("../img/Bas.png")));
                carte.initMap();
                reinitMap();
                nombreMouvement.setText("Nombre de mouvements : " + carte.getNbMouvement());
                requestFocus();
            }
        });

        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuPrincipal = new Menu();
                dispose();
            }
        });
    }

    /** Initialise les statistiques du personnage (compteur de mouvement) */
    private void initStatistiques() {
        nombreMouvement = new JLabel("Nombre de mouvements : 0");
        sud.add(nombreMouvement);
    }

    /** remplit le tableau lesImages en associant une image a chaque symbole */
    private void remplirLesImages() {
        lesImages.put("/", new ImageIcon(Graphique.class.getResource("../img/vide.png")));
        lesImages.put("#", new ImageIcon(Graphique.class.getResource("../img/mur.png")));
        lesImages.put(" ", new ImageIcon(Graphique.class.getResource("../img/sol.png")));
        lesImages.put("@", new ImageIcon(Graphique.class.getResource("../img/Bas.png")));
        lesImages.put("$", new ImageIcon(Graphique.class.getResource("../img/caisse1.png")));
        lesImages.put(".", new ImageIcon(Graphique.class.getResource("../img/but.png")));
        lesImages.put("*", new ImageIcon(Graphique.class.getResource("../img/caisse2.png")));
        lesImages.put("+", new ImageIcon(Graphique.class.getResource("../img/Bas.png")));
    }

    /**
     * Lorsque qu'une touche a ete appuye sur le clavier
     */
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            // 8 pour la touche retour en arriere
            case 8:
                carte.retourArriere();
                nombreMouvement.setText("Nombre de mouvements : " + carte.getNbMouvement());
                reinitMap();
                break;
            case KeyEvent.VK_LEFT:
            case 81:
                carte.deplaceRobot(EDirection.GAUCHE);
                nombreMouvement.setText("Nombre de mouvements : " + carte.getNbMouvement());
                carte.setDirection(EDirection.GAUCHE);
                reinitMap();
                break;
            case KeyEvent.VK_RIGHT:
            case 68:
                carte.deplaceRobot(EDirection.DROITE);
                nombreMouvement.setText("Nombre de mouvements : " + carte.getNbMouvement());
                carte.setDirection(EDirection.DROITE);
                reinitMap();
                break;
            case KeyEvent.VK_UP:
            case 90:
                carte.deplaceRobot(EDirection.HAUT);
                nombreMouvement.setText("Nombre de mouvements : " + carte.getNbMouvement());
                carte.setDirection(EDirection.HAUT);
                reinitMap();
                break;
            case KeyEvent.VK_DOWN:
            case 83:
                carte.deplaceRobot(EDirection.BAS);
                nombreMouvement.setText("Nombre de mouvements : " + carte.getNbMouvement());
                carte.setDirection(EDirection.BAS);
                reinitMap();
                break;

        }
        if (carte.finDePartie()) {
            removeKeyListener(this);
            fin = new FinDePartie(carte.getNomfichier());
            dispose();
        }

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

}