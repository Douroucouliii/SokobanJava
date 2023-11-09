#Ouverture du fichier en mode lecture
with open("all.txt", "r") as f:
    #Lecture de toutes les lignes du fichier
    lines = f.readlines()

#Liste pour stocker les lignes valides
valid_lines = []

#Parcours de chaque ligne
for line in lines:
    #Compteur du nombre de "X" dans la ligne
    count = line.count("X")
    #Si la ligne contient au moins deux "X", elle est valide
    if count >= 2:
        valid_lines.append(line)

#Ouverture du fichier en mode écriture
with open("all.txt", "w") as f:
    #Écriture des lignes valides dans le fichier
    f.writelines(valid_lines)