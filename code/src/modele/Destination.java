package modele;

/**
 * Modelise une destination dans le jeu, elle peut avoir le joueur (robot)
 * dessus ou une caisse
 */
public class Destination extends Element {

    boolean aJoueur;
    boolean aCaisse;

    /**
     * Constructeur d'une destination
     * 
     * @param coordx : coordonnee x de l'element
     * @param coordy : coordonnee y de l'element
     */
    public Destination(int coordx, int coordy, boolean aJoueur, boolean aCaisse) {
        super(coordx, coordy);
        this.aJoueur = aJoueur;
        this.aCaisse = aCaisse;
    }

    /**
     * Accesseur au boolean aJoueur
     * 
     * @return bool selon si il y a le joueur ou non
     */
    public boolean aJoueur() {
        return aJoueur;
    }

    /**
     * Accesseur au boolean aCaisse
     * 
     * @return bool selon si il y a une caisse ou non
     */
    public boolean aCaisse() {
        return aCaisse;
    }

    /**
     * Setter au boolean aJoueur
     * 
     * @param bool : le nouveau boolean a mettre
     */
    public void setJoueur(boolean bool) {
        aJoueur = bool;
    }

    /**
     * Setter au boolean aCaisse
     * 
     * @param bool : le nouveau boolean a mettre
     */
    public void setCaisse(boolean bool) {
        aCaisse = bool;
    }

    /**
     * Methode toString du vide
     * 
     * @return le symbole du sol selon si il y a rien, le joueur ou la caisse
     */
    public String toString() {
        if (aJoueur) {
            return "+";
        } else if (aCaisse) {
            return "*";
        }
        return ".";
    }
}