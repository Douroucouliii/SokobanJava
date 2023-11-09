package modele;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** Classe qui modelise la carte */
public class Carte {

    private int nbLignes;
    private int nbColonnes;
    private int nbMouvement = 0;
    private Lecture fichier;
    private Robot robot;
    private Element[][] map;

    // Pour la fin de partie
    private List<Element> lesDestinations = new ArrayList<Element>();

    // Pour le bouton retour
    private List<EDirection> lesDernieresDir = new ArrayList<EDirection>();
    private Map<Integer, Element> lesDernieresCaisse = new HashMap<Integer, Element>();

    /**
     * On construit la carte a partir de la lecture d'un fichier
     * 
     * @param fichier : fichier a lire, de type Lecture
     */
    public Carte(Lecture fichier) {
        this.fichier = fichier;

        nbLignes = fichier.getNbLignes();
        nbColonnes = fichier.getTailleLignes();
        map = new Element[nbLignes][nbColonnes];
        initMap();
    }

    /**
     * methode pour initialiser la map
     */
    public void initMap() {
        lesDestinations.clear();
        nbMouvement = 0;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (fichier.getTexteInd(i).charAt(j) == '/') {
                    map[i][j] = new Vide(i, j);
                } else if (fichier.getTexteInd(i).charAt(j) == '#') {
                    map[i][j] = new Mur(i, j);
                } else if (fichier.getTexteInd(i).charAt(j) == ' ') {
                    map[i][j] = new Sol(i, j, false, false);
                } else if (fichier.getTexteInd(i).charAt(j) == '@') {
                    robot = new Robot(i, j);
                    map[i][j] = new Sol(i, j, true, false);
                } else if (fichier.getTexteInd(i).charAt(j) == '$') {
                    map[i][j] = new Sol(i, j, false, true);
                } else if (fichier.getTexteInd(i).charAt(j) == '.') {
                    map[i][j] = new Destination(i, j, false, false);
                    lesDestinations.add(map[i][j]);
                } else if (fichier.getTexteInd(i).charAt(j) == '*') {
                    map[i][j] = new Destination(i, j, false, true);
                    lesDestinations.add(map[i][j]);
                }
            }
        }
    }

    /**
     * Deplace le robot dans une direction si possible
     * 
     * @param direction : la direction ou doit aller le robot
     */
    public void deplaceRobot(EDirection direction) {
        int newCoordx = robot.getCoordx() + direction.getIncrAbcisse();
        int newCoordy = robot.getCoordy() + direction.getIncrOrdonnee();
        if (map[newCoordx][newCoordy].estMur())
            return;
        else if (map[newCoordx][newCoordy].aCaisse()) {
            int newCoordCaissey = newCoordy + direction.getIncrOrdonnee();
            int newCoordCaissex = newCoordx + direction.getIncrAbcisse();
            if (peutDeplacerCaisse(newCoordCaissex, newCoordCaissey)) {
                lesDernieresDir.add(direction);
                lesDernieresCaisse.put(nbMouvement, map[newCoordCaissex][newCoordCaissey]);
                map[newCoordCaissex][newCoordCaissey].setCaisse(true);
                map[newCoordx][newCoordy].setCaisse(false);
                map[newCoordx][newCoordy].setJoueur(true);
                map[robot.getCoordx()][robot.getCoordy()].setJoueur(false);
                robot.setCoordx(newCoordx);
                robot.setCoordy(newCoordy);
                nbMouvement++;
            }
        } else {
            lesDernieresDir.add(direction);
            map[newCoordx][newCoordy].setJoueur(true);
            map[robot.getCoordx()][robot.getCoordy()].setJoueur(false);
            robot.setCoordx(newCoordx);
            robot.setCoordy(newCoordy);
            nbMouvement++;
        }
    }

    /**
     * Verifie si on peut deplacer une caisse
     * 
     * @param coordx : coordonnee x de l'endroit ou deplacer la caisse
     * @param coordy : coordonne y de l'endroit ou deplacer la caisse
     * @return boolean si on peut la deplacer ou non
     */
    private boolean peutDeplacerCaisse(int coordx, int coordy) {
        if (map[coordx][coordy].estMur() || map[coordx][coordy].aCaisse()) {
            return false;
        }
        return true;
    }

    /**
     * Verifie si c'est la fin de la partie (c'est a dire que toute les destinations
     * ont une caisse posé dessus)
     * 
     * @return bool selon si la partie est fini ou non
     */
    public boolean finDePartie() {
        for (int i = 0; i < lesDestinations.size(); i++) {
            if (!lesDestinations.get(i).aCaisse()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Retourne en arriere (remet le robot sur le dernier sol)
     */
    public void retourArriere() {
        if (lesDernieresDir.size() > 0) {
            nbMouvement--;
            if (lesDernieresCaisse.containsKey(nbMouvement)) {
                Element dernierSolCaisse = lesDernieresCaisse.get(nbMouvement);
                map[robot.getCoordx()][robot.getCoordy()].setCaisse(true);
                map[dernierSolCaisse.getCoordx()][dernierSolCaisse.getCoordy()].setCaisse(false);
                lesDernieresCaisse.remove(nbMouvement);

            }
            EDirection ancienneDir = lesDernieresDir.get(lesDernieresDir.size() - 1);
            int newCoordx = robot.getCoordx() - ancienneDir.getIncrAbcisse();
            int newCoordy = robot.getCoordy() - ancienneDir.getIncrOrdonnee();
            robot.setDirection(ancienneDir);
            lesDernieresDir.remove(lesDernieresDir.size() - 1);

            map[newCoordx][newCoordy].setJoueur(true);
            map[robot.getCoordx()][robot.getCoordy()].setJoueur(false);
            robot.setCoordx(newCoordx);
            robot.setCoordy(newCoordy);

        }
    }

    /**
     * Accesseur au nombre de lignes
     * 
     * @return le nombre de lignes
     */
    public int getNbLignes() {
        return nbLignes;
    }

    /**
     * Accesseur au nombre de colonnes
     * 
     * @return le nombre de colonnes
     */
    public int getNbColonnes() {
        return nbColonnes;
    }

    /**
     * Accesseur a la map du jeu
     * 
     * @return la map avec les element
     */
    public Element[][] getMap() {
        return map;
    }

    /**
     * Accesseur au robot du jeu
     * 
     * @return le robot du jeu
     */
    public Robot getRobot() {
        return robot;
    }

    /**
     * Accesseur au fichier
     * 
     * @return le nom du fichier
     */
    public String getNomfichier() {
        return fichier.getNomFichier();
    }

    /**
     * Accesseur au nombre de mouvement
     * 
     * @return le nombre de mouvement
     */
    public int getNbMouvement() {
        return nbMouvement;
    }

    public void setNbMouvement(int nb) {
        nbMouvement = nb;
    }

    /**
     * Accesseur pour la direction du robot (pour l'utiliser dans Graphique)
     * 
     */
    public EDirection getDirection() {
        return robot.getDirection();
    }

    /**
     * Setter pour la direction du robot (pour l'utiliser dans Graphique)
     * 
     * @param direction : la direction du robot qu'on souhaite mettre
     */
    public void setDirection(EDirection direction) {
        robot.setDirection(direction);
    }

    /**
     * Methode toString pour afficher le contenu de la carte
     * 
     * @return la chaine de caractère pour afficher le jeu
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                sb.append(map[i][j].toString());
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}