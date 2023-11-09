package vueGraphique;

import modele.Carte;
import modele.Lecture;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Font;

/** Classe qui modélise le menu du jeu */
public class Menu extends JFrame {

    private Carte carte;
    private String[] lesOptions = new String[61];
    private JComboBox<String> option;
    private JButton jouer;
    private JLabel titre;

    public Menu() {
        super("Menu");
        remplirLesOptions();

        // On centre la fenetre
        Dimension dimEcran = new Dimension(getToolkit().getScreenSize());
        setSize(750, 500);
        setLocation((int) dimEcran.getWidth() / 2 - getWidth() / 2, (int) dimEcran.getHeight() / 2 - getHeight() / 2);

        setDefaultCloseOperation(3);

        titre = new JLabel("SOKOBAN");
        titre.setBounds(210, 20, 500, 50);
        titre.setFont(new Font("Arial", Font.BOLD, 60));

        option = new JComboBox<>(lesOptions);
        option.setBounds(300, 150, 140, 20);

        jouer = new JButton("Jouer");
        jouer.setBounds(325, 200, 90, 20);

        add(titre);
        add(option);
        add(jouer);

        setLayout(null);
        setVisible(true);

        // En appuyant sur jouer, on lance notre graphique pour le jeu
        jouer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                carte = new Carte(new Lecture("bin/map/map" + (option.getSelectedIndex() + 1) + ".txt"));

                Graphique lancerPartie = new Graphique(carte);
                dispose();
            }
        });
    }

    /**
     * Remplit les options de notre JComboBox
     */
    private void remplirLesOptions() {
        for (int i = 0; i < 61; i++) {
            lesOptions[i] = "NIVEAU " + (i + 1);
        }
    }

}
