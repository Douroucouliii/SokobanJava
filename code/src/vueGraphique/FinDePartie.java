package vueGraphique;

import modele.Carte;
import modele.Lecture;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Classe qui modélise la fenetre de fin de partie */
public class FinDePartie extends JFrame {

    private String nomFichier;
    private String nomFichierNiveauSuivant;
    private Menu menu;
    private JLabel titre;
    private JButton quitter;
    private JButton menuBtn;
    private JButton recommencer;
    private JButton niveauSuivant;
    private Carte carte;

    public FinDePartie(String nomFichier) {
        super("Fin du niveau !");
        this.nomFichier = nomFichier;
        nomFichierNiveauSuivant = nomFichier;
        setNomFicherNiveauSuivant();

        // On centre la fenetre
        Dimension dimEcran = new Dimension(getToolkit().getScreenSize());
        setSize(750, 500);
        setLocation((int) dimEcran.getWidth() / 2 - getWidth() / 2, (int) dimEcran.getHeight() / 2 - getHeight() / 2);

        setDefaultCloseOperation(3);

        titre = new JLabel("Bien joue !");
        titre.setBounds(230, 20, 500, 50);
        titre.setFont(new Font("Arial", Font.BOLD, 50));

        quitter = new JButton("Quitter");
        quitter.setBounds(15, 200, 140, 50);
        quitter.setFont(new Font("Arial", Font.BOLD, 17));

        menuBtn = new JButton("Menu");
        menuBtn.setBounds(165, 200, 140, 50);
        menuBtn.setFont(new Font("Arial", Font.BOLD, 17));

        recommencer = new JButton("Recommencer");
        recommencer.setBounds(315, 200, 200, 50);
        recommencer.setFont(new Font("Arial", Font.BOLD, 17));

        niveauSuivant = new JButton("Niveau suivant");
        niveauSuivant.setBounds(525, 200, 200, 50);
        niveauSuivant.setFont(new Font("Arial", Font.BOLD, 17));

        add(titre);
        add(quitter);
        add(menuBtn);
        add(recommencer);
        add(niveauSuivant);

        setLayout(null);
        setVisible(true);

        quitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu = new Menu();
                dispose();
            }
        });

        recommencer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                carte = new Carte(new Lecture(nomFichier));

                Graphique lancerPartie = new Graphique(carte);
                dispose();
            }
        });

        niveauSuivant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                carte = new Carte(new Lecture(nomFichierNiveauSuivant));

                Graphique lancerPartie = new Graphique(carte);
                dispose();
            }
        });
    }

    /**
     * Ajouter 1 au nom du fichier a cote de map (pour pouvoir acceder au prochain
     * niveau)
     * 
     * @return la chaine de caractere modifie
     */
    private void setNomFicherNiveauSuivant() {
        if (nomFichierNiveauSuivant.length() == 16) {
            if (nomFichierNiveauSuivant.charAt(11) == '9') {
                nomFichierNiveauSuivant = "bin/map/map10.txt";
            } else {
                nomFichierNiveauSuivant = "bin/map/map" + (char) (nomFichierNiveauSuivant.charAt(11) + 1) + ".txt";
            }
        } else if (nomFichierNiveauSuivant.length() == 17) {
            if (nomFichierNiveauSuivant.charAt(11) == '9') {
                nomFichierNiveauSuivant = "bin/map/map" + (char) (nomFichierNiveauSuivant.charAt(11) + 1) + "0.txt";
            } else {
                nomFichierNiveauSuivant = "bin/map/map" + (nomFichierNiveauSuivant.charAt(11))
                        + (char) (nomFichierNiveauSuivant.charAt(12) + 1) + ".txt";
            }
        }
    }
}
