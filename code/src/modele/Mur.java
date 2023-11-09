package modele;

/** Modelise le mur */
public class Mur extends Element {

    /**
     * Constructeur du mur
     * 
     * @param coordx : coordonnee x de l'element
     * @param coordy : coordonnee y de l'element
     */
    public Mur(int coordx, int coordy) {
        super(coordx, coordy);
    }

    /**
     * Surchage de la methode d'element pour dire que cet element est un mur
     * 
     * @return true
     */
    public boolean estMur() {
        return true;
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
     * Methode toString du mur
     * 
     * @return le symbole du mur
     */
    public String toString() {
        return "#";
    }
}