package modele;

/**
 * Enumeration des direction ainsi que l'incremention en abcisse et en ordonnee
 * pour chaque direction
 */
public enum EDirection {

    HAUT("haut", -1, 0),
    BAS("bas", 1, 0),
    GAUCHE("gauche", 0, -1),
    DROITE("droite", 0, 1);

    private String nomDirection;
    private int incrAbcisse;
    private int incrOrdonnee;

    /**
     * Constructeur d'une direction
     * 
     * @param nomDirection : le nom de la direction
     * @param incrAbcisse  : l'incrementation en abcisse de la direction
     * @param incrOrdonnee : l'incrementation en ordonnee de la direction
     */
    private EDirection(String nomDirection, int incrAbcisse, int incrOrdonnee) {
        this.nomDirection = nomDirection;
        this.incrAbcisse = incrAbcisse;
        this.incrOrdonnee = incrOrdonnee;
    }

    /**
     * Accesseur au nom de la direction
     * 
     * @return nom de la direction
     */
    public String getDirection() {
        return nomDirection;
    }

    /**
     * Accesseur a l'incrementation en abcisse de la direction
     * 
     * @return l'incrementation en abcisse de la direction
     */
    public int getIncrAbcisse() {
        return incrAbcisse;
    }

    /**
     * Accesseur a l'incrementation en ordonnee de la direction
     * 
     * @return l'incrementation en ordonnee de la direction
     */
    public int getIncrOrdonnee() {
        return incrOrdonnee;
    }
}
