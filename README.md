# Sokoban Java
![jeu](https://github.com/Douroucouliii/SokobanJava/assets/129008147/23d72901-4dcf-48cd-b09d-72b71b05e370)

Projet réalisé en java.
C'est le jeu Sokoban réalisé en Java avec Swing pour la partie graphique.

# Controleur :

* <kbd>←</kbd> <kbd>→</kbd> <kbd>↑</kbd> <kbd>↓</kbd>   
* <kbd>Z</kbd> <kbd>Q</kbd> <kbd>S</kbd> <kbd>D</kbd> : bouger le personnage.
* Flèche retour pour supprimer le dernier mouvement.

# Fonctionnalités :

Toutes les fonctionnalités du sokoban ont été implémenté.   
Un menu interactif pour sélectionner les différents niveaux.   
Un bouton pour recommencer le niveau. Un bouton pour retourner sur le menu.   
Un bouton pour annuler le dernier déplacement (autant qu'on veut), et l'ancienne direction du robot se remet.   
Un menu de fin de partie pour pouvoir accéder au prochain niveau, recommencer le même, accéder au menu ou quitter.   
61 maps implémentés (expliqué plus bas). Les images personnalisées.
Le titre du niveau apparaît en nom de la fenêtre.   
Un compteur de mouvement en bas du niveau. Un label qui explique les commandes.   

# Map :

61 maps et donc 61 niveaux fonctionnels : j'ai trouvé un fichier.txt libre d'utilisation répertoriant des maps de sokoban sur internet, puis j'ai utilisé 4 scripts python afin de tout modifier (un pour enlever les informations inutiles, un pour remplacer touts les caractères par ceux utilisés dans la modélisation, un pour rajouter des "/" en dehors des cartes, et un dernier pour séparer chaque map en sous-fichier de type map[numeromap].txt (j'ai laissé les script python dans le bin/map)    

# Images :
![menu](https://github.com/Douroucouliii/SokobanJava/assets/129008147/8fcd0156-465b-4df9-97ec-4d243401e034)
![jeu](https://github.com/Douroucouliii/SokobanJava/assets/129008147/23d72901-4dcf-48cd-b09d-72b71b05e370)
![fin](https://github.com/Douroucouliii/SokobanJava/assets/129008147/c4189ba8-ccc7-409e-bda8-216456654718)
