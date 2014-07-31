Indiana Jones � la conqu�te de l'Europe
==========================================================================================

Vous savez quoi, Indiana Jones reprend du service ! Et pour sa mission la plus p�rilleuse (si si) : il doit
parcourir l'Europe en train (c'est le c�t� dangereux de l'aventure) � la recherche d'anciennes reliques.
Mais Indiana a vieilli et il est devenu un aventurier organis�. Il souhaite maintenant pr�parer ses
itin�raires afin d'optimiser les trajets � travers le continent.
Pour chaque voyage � r�aliser, il sait dans quelle ville il se trouvera et � quelle heure, et dans quelle ville
il doit se rendre. Il poss�de �galement une liste d'horaires de train lui permettant d'aller de sa ville de
d�part � sa ville d'arriv�e.
Par exemple, Indiana sait qu'il sera � Paris � 08:20 et qu'il doit aller � Berlin, et poss�de la liste d'horaires
suivante :
Ville de d�part Ville d'arriv�e Heure de d�part Dur�e du trajet
Paris Amsterdam 09:20 03:20
Paris Bruxelles 08:30 01:20
Bruxelles Amsterdam 10:00 02:10
Amsterdam Berlin 12:30 06:10
Bruxelles Berlin 11:30 09:20


Gr�ce � ces informations, il est en mesure de d�terminer quel est l'itin�raire lui permettant d'atteindre
le plus t�t possible la ville d'arriv�e. Dans l'exemple ci-dessus, l'itin�raire que doit prendre Indiana pour
arriver � Berlin est le suivant :
Prendre le Paris-Bruxelles de 08:30, arriv�e � 09:50
Prendre le Bruxelles-Amsterdam de 10:00, arriv�e � 12:10
Prendre le Amsterdam-Berlin de 12:30, arriv�e � 18:40
Indiana Jones sera capable d'arriver � Berlin au mieux � 18:40.

Vous devez �crire un programme permettant, � partir des informations transmises, de d�terminer �
quelle heure au plus t�t Indiana Jones pourra atteindre la ville d'arriv�e.
Les temps de changement de trains sont consid�r�s comme n�gligeables : si Indiana arrive � 14:30 dans
une ville, il pourra prendre un train � partir de 14:30 inclus.
Entr�e de la fonction
La premi�re ligne contient : ? L'heure H � laquelle Indiana est � la ville de d�part sous la forme HH:MM ? La ville de d�part VD ? La ville d'arriv�e VA
Les informations vous sont transmises au format H;VD;VA
La deuxi�me ligne contient un nombre entier N indiquant le nombre d'horaires qui vont vous �tre
transmis
S'en suit N lignes repr�sentant les horaires sous la forme suivante : ? L'horaire HD de d�part du train sous la forme HH:MM ? La ville V1 de d�part du train ? La ville V2 d'arriv�e du train ? La dur�e D du trajet sous la forme HH:MM
Les informations vous sont transmises au format HD;V1;V2;D
Tous les horaires et dur�es sont affich�es sous la forme HH:DD avec HH compris entre 00 et 23 inclus et
DD compris entre 00 et 59 inclus.
Sortie de la fonction Votre fonction doit d�terminer l'heure au plus t�t � laquelle Indiana Jones pourra �tre � la ville d'arriv�e,
au format HH:DD, avec HH compris entre 00 et 23 inclus et DD compris entre 00 et 59 inclus.
Les heures et les minutes devront obligatoirement �tre affich�es sur 2 caract�res. Par exemple, il ne faut
pas afficher 9:5, mais 09:05



Exemple:
Entr�e
08:20;Paris;Berlin
5
09:20;Paris;Amsterdam;03:20
08:30;Paris;Bruxelles;01:20
10:00;Bruxelles;Amsterdam;02:10
12:30;Amsterdam;Berlin;06:10
11:30;Bruxelles;Berlin;09:20

Sortie
18:40

Usage: java -cp [classpath] com.indianajones.contest.PathFinder [input-file-path]

Limitation:
* Handle input error
* Current year is... 1970 !
* Optimize path finder
** Store only best paths when reaching to same Node
** Other implementation of path finder