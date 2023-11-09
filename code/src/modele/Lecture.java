package modele;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/** Classe qui modelise la lecture d'un fichier texte */
public class Lecture {

    private String nomFichier;
    private List<String> texte = new ArrayList<String>();
    private int nbLignes;
    private int tailleLignes;

    /**
     * Constructeur de Lecture
     * On lit dans le fichier et on stocke tout dans une liste, puis on affecte nos
     * attribut
     * 
     * @param nomFichier : nom du fichier
     */
    public Lecture(String nomFichier) {
        this.nomFichier = nomFichier;

        int cpt = 0;
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(nomFichier)));
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                texte.add(scanner.next());
                cpt++;
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier : " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        this.nbLignes = cpt;
        this.tailleLignes = texte.get(0).length() - 1;

    }

    /**
     * Accesseur au nom du fichier
     * 
     * @return le nom du fichier
     */
    public String getNomFichier() {
        return nomFichier;
    }

    /**
     * Accesseur au contenu du fichier
     * 
     * @return la liste des chaines de caractère dans le fichier
     */
    public List<String> getTexte() {
        return texte;
    }

    /**
     * Accesseur a la ieme chaine de caractere
     * 
     * @param i : ieme chaine
     * @return la chaine de caractere
     */
    public String getTexteInd(int i) {
        return texte.get(i);
    }

    /**
     * Accesseur au nombre de ligne du fichier
     * 
     * @return le nombre de ligne du fichier
     */
    public int getNbLignes() {
        return nbLignes;
    }

    /**
     * Accesseur a la taille de chaque ligne du fichier
     * 
     * @return la taille de chaque ligne du fichier
     */
    public int getTailleLignes() {
        return tailleLignes;
    }

    /**
     * cherche le caractere a l'emplacement i,j
     * 
     * @param i : coordonnee i
     * @param j : coordonnee j
     * @return le caractere en (i,j)
     */
    public char getCharAt(int i, int j) {
        return texte.get(i).charAt(j);
    }
}
