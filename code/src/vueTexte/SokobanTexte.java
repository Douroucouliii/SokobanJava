package vueTexte;

import modele.Carte;
import modele.Lecture;

/** Classe qui permet de lancer la vue textuel du Sokoban */
public class SokobanTexte {

    public static void main(String[] args) {

        Carte carte = new Carte(new Lecture("bin/map/map1.txt"));

        ModeTexte lancerPartie = new ModeTexte(carte);

    }
}
