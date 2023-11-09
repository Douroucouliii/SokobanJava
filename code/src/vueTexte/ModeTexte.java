package vueTexte;

import modele.EDirection;
import modele.Carte;

/** Modelise la version texte du jeu */
public class ModeTexte {

    private Carte carte;
    private char gauche = 'g';
    private char droite = 'd';
    private char haut = 'h';
    private char bas = 'b';

    /**
     * On construit le modele version texte avec la carte
     * 
     * @param carte : carte du jeu (modele)
     */
    public ModeTexte(Carte carte) {
        this.carte = carte;
        lancerPartie();

    }

    /**
     * Demande un caractere a l'utilisateur tant qu'il n'entre pas un caractere
     * valide
     * 
     * @return le caractere valide entre par l'utilisateur
     */
    private char demanderCaractere() {
        char caractere = Outil.lireCaractere();
        while (caractere != gauche && caractere != droite && caractere != haut && caractere != bas) {
            caractere = Outil.lireCaractere();
        }
        return caractere;
    }

    /**
     * Lance la partie en version texte, tant que ce n'est pas la fin de la partie,
     * on demande un caractere a l'utilisateur et on deplace notre robot (et les
     * caisses)
     */
    private void lancerPartie() {

        System.out.println("Voici la carte de base :");
        System.out.println(carte.toString());

        while (!carte.finDePartie()) {
            System.out.println("Haut : h, Gauche : g, Droite : d, Bas : b ?");
            char caractere = demanderCaractere();
            if (caractere == gauche) {
                System.out.println("\nOn deplace le robot a gauche :");
                carte.deplaceRobot(EDirection.GAUCHE);
                System.out.println(carte.toString());
            } else if (caractere == droite) {
                System.out.println("\nOn deplace le robot a droite :");
                carte.deplaceRobot(EDirection.DROITE);
                System.out.println(carte.toString());
            } else if (caractere == haut) {
                System.out.println("\nOn deplace le robot en haut :");
                carte.deplaceRobot(EDirection.HAUT);
                System.out.println(carte.toString());
            } else if (caractere == bas) {
                System.out.println("\nOn deplace le robot en bas :");
                carte.deplaceRobot(EDirection.BAS);
                System.out.println(carte.toString());
            }
        }

        System.out.println("Fin de la partie ! Bien joue !");

    }
}
