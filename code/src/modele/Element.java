package modele;

/** Modelise un element du jeu */
public abstract class Element {

    private int coordx;
    private int coordy;

    /**
     * Un element prend une coordonnee en x et en y
     * 
     * @param coordx : coordonnee x de l'element
     * @param coordy : coordonnee x de l'element
     */
    public Element(int coordx, int coordy) {
        this.coordx = coordx;
        this.coordy = coordy;
    }

    /**
     * Accesseur a la coordonnee x de l'element
     * 
     * @return la coordonnee x de l'element
     */
    public int getCoordx() {
        return coordx;
    }

    /**
     * Accesseur a la coordonnee y de l'element
     * 
     * @return la coordonnee y de l'element
     */
    public int getCoordy() {
        return coordy;
    }

    /**
     * Setter de la coordonnee x de l'element
     * 
     * @param x : la coordonnee x de l'element
     */
    public void setCoordx(int x) {
        coordx = x;
    }

    /**
     * Setter de la coordonnee y de l'element
     * 
     * @param x : la coordonnee y de l'element
     */
    public void setCoordy(int y) {
        coordy = y;
    }

    /**
     * Verifie si l'element est un mur (false de base)
     * 
     * @return false
     */
    public boolean estMur() {
        return false;
    }

    /**
     * Verifie si l'element a une caisse sur lui
     * 
     * @return false
     */
    public boolean aCaisse() {
        return false;
    }

    /**
     * Verifie si l'element a un joueur sur lui
     * 
     * @return false
     */
    public boolean aJoueur() {
        return false;
    }

    /**
     * Vérifie si l'élement est fixe (c'est a dire c'est un mur ou le vide)
     * 
     * @return false
     */
    public boolean estFixe() {
        return false;
    }

    public void setJoueur(boolean bool) {
    }

    public void setCaisse(boolean bool) {
    }
}
