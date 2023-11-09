package modele;

/** Modelise le robot */
public class Robot extends Element {

    private EDirection direction = EDirection.HAUT;

    /**
     * Constructeur du robot
     * 
     * @param coordx : coordonnee x de l'element
     * @param coordy : coordonnee y de l'element
     */
    public Robot(int coordx, int coordy) {
        super(coordx, coordy);
    }

    /**
     * Accesseur a la direction du robot
     * 
     * @return la direction du robot
     */
    public EDirection getDirection() {
        return direction;
    }

    /**
     * Setter a la direction du robot
     * 
     * @param dir : la nouvelle direction du robot
     */
    public void setDirection(EDirection dir) {
        direction = dir;
    }
}
