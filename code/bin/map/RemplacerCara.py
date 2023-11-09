#Ouverture du fichier en mode lecture
with open("all.txt", "r") as f:
    #Lecture de toutes les lignes du fichier
    lines = f.readlines()

#Parcours de chaque ligne et remplacement des caractères
for i in range(len(lines)):
    lines[i] = lines[i].replace("X", "#").replace("*", "$").replace("&", "*")

#Ouverture du fichier en mode écriture
with open("all.txt", "w") as f:
    #Écriture des lignes modifiées dans le fichier
    f.writelines(lines)