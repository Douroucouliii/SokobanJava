package modele;

/** Modelise le vide */
public class Vide extends Element {

    /**
     * Constructeur du vide
     * 
     * @param coordx : coordonnee x de l'element
     * @param coordy : coordonnee y de l'element
     */
    public Vide(int coordx, int coordy) {
        super(coordx, coordy);
    }

    /**
     * Verifie si l'element est fixe (c'est a dire c'est un mur ou le vide)
     * 
     * @return true
     */
    public boolean estFixe() {
        return true;
    }

    /**
     * Methode toString du vide
     * 
     * @return le symbole du vide
     */
    public String toString() {
        return "/";
    }
}