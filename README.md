Indiana Jones à la conquête de l'Europe
==========================================================================================

Vous savez quoi, Indiana Jones reprend du service ! Et pour sa mission la plus périlleuse (si si) : il doit
parcourir l'Europe en train (c'est le côté dangereux de l'aventure) à la recherche d'anciennes reliques.
Mais Indiana a vieilli et il est devenu un aventurier organisé. Il souhaite maintenant préparer ses
itinéraires afin d'optimiser les trajets à travers le continent.
Pour chaque voyage à réaliser, il sait dans quelle ville il se trouvera et à quelle heure, et dans quelle ville
il doit se rendre. Il possède également une liste d'horaires de train lui permettant d'aller de sa ville de
départ à sa ville d'arrivée.
Par exemple, Indiana sait qu'il sera à Paris à 08:20 et qu'il doit aller à Berlin, et possède la liste d'horaires
suivante :
Ville de départ Ville d'arrivée Heure de départ Durée du trajet
Paris Amsterdam 09:20 03:20
Paris Bruxelles 08:30 01:20
Bruxelles Amsterdam 10:00 02:10
Amsterdam Berlin 12:30 06:10
Bruxelles Berlin 11:30 09:20


Grâce à ces informations, il est en mesure de déterminer quel est l'itinéraire lui permettant d'atteindre
le plus tôt possible la ville d'arrivée. Dans l'exemple ci-dessus, l'itinéraire que doit prendre Indiana pour
arriver à Berlin est le suivant :
Prendre le Paris-Bruxelles de 08:30, arrivée à 09:50
Prendre le Bruxelles-Amsterdam de 10:00, arrivée à 12:10
Prendre le Amsterdam-Berlin de 12:30, arrivée à 18:40
Indiana Jones sera capable d'arriver à Berlin au mieux à 18:40.

Vous devez écrire un programme permettant, à partir des informations transmises, de déterminer à
quelle heure au plus tôt Indiana Jones pourra atteindre la ville d'arrivée.
Les temps de changement de trains sont considérés comme négligeables : si Indiana arrive à 14:30 dans
une ville, il pourra prendre un train à partir de 14:30 inclus.
Entrée de la fonction
La première ligne contient : ? L'heure H à laquelle Indiana est à la ville de départ sous la forme HH:MM ? La ville de départ VD ? La ville d'arrivée VA
Les informations vous sont transmises au format H;VD;VA
La deuxième ligne contient un nombre entier N indiquant le nombre d'horaires qui vont vous être
transmis
S'en suit N lignes représentant les horaires sous la forme suivante : ? L'horaire HD de départ du train sous la forme HH:MM ? La ville V1 de départ du train ? La ville V2 d'arrivée du train ? La durée D du trajet sous la forme HH:MM
Les informations vous sont transmises au format HD;V1;V2;D
Tous les horaires et durées sont affichées sous la forme HH:DD avec HH compris entre 00 et 23 inclus et
DD compris entre 00 et 59 inclus.
Sortie de la fonction Votre fonction doit déterminer l'heure au plus tôt à laquelle Indiana Jones pourra être à la ville d'arrivée,
au format HH:DD, avec HH compris entre 00 et 23 inclus et DD compris entre 00 et 59 inclus.
Les heures et les minutes devront obligatoirement être affichées sur 2 caractères. Par exemple, il ne faut
pas afficher 9:5, mais 09:05



Exemple:
Entrée
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