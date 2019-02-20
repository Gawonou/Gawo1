
# Construction du fichier HTML de sortie
  
 
  Dans ce travail, nous lirons un fichier (entree) texte représentant un texte roomaji (pronociation syllabique) (lecture de gauche à droite et de haut en bas)
  
  Pour produire un autre fichier (sortie)  représentant sa coresponance en caractère japonais. (lecture droite à gauche et de haut en bas )
  
  
 # PROCESSUS
  
 ## Le programme effectura trois opérations
  
 ### Chargement de la table de traduction

 ### Lecture du fichier externe (dans le meme temps, il va creer le texte roomaji avec les données trouvé)
  
 ### ƒcrite du fichier externe correspondant a un fichier HTML
  
  
  STRUCURE
  
   - La structure est la suivante
   
   
   Kanas  : représente une structure qui contient les informations d'un kana 
   	  	 ou l'on retrouve 
   
   		 hiragana
   		 unicode1
   		 unicode2 
   
   TableTraduction : représente un Array du Kanas  (Destiné a contenir tout les unicodes des kanas)
  
 
  Roomaji	: représente une stucture qui contient les syllabes lu dans le texte roomaji
 			  ou l'on retrouve
 
 			 kanas : le texte lu
 			 ligne : ligne dans le fichier ou la syllabe a été trouvé
 			 numero: le rang (position) dans laquelle la syllabe a été trouvé dans la ligne
 			 estPoint : détermine si cette syllabe est suivi d'un point 
 
  TexteRoomaji	: représente un Array de Roomadi (Destiné à contenir le texte Roomaji)
  
  Roomaji2html.java : comprend le programme principal main
  
  
  		Instructions
  
 		   1. Le programme vous invite a entrer le nom du fichier d'entrer pour le texte en Roomaji.
  		   ainsi que le nom du fichier de sortie pour le fichier en html")
  
  		2. Une fois le programme terminer, rendez vous dans le repertoire par defaut de votre ordinateur
  		   et vous trouvez le fichier de sortie  avec le résultat en (Hiragana) caractère japonais (le nom du fichier a été spécifié par       l'usager).
  
  		  Informations supplémentaires ....
  
  		Si le programme ne trouve pas le fichier entré par l'usager, un message d'erreur s'affichera et
  		  et dans ce cas, le fichier  sera vide.
  		Il est très important que le fichier  respecte les définitions syntaxiques 
  		  des syllabes Roomajis pour avoir les rŽsultats désirés.
  		
 
 	 
 
  
##  RESTRICTIONS
  
 - Aucun control n'est effectué sur la validité syntaxique des kanas pour la table de traduction
    
  - Aucun control n'est effectu sur les données dans le fichier d'entrée.
    Nous supposons que les données entrées soient conformes à syntaxe des syllabes Roomaji.
    
  - Toutefois, un X sera placé dans le fichier de sortie HTLM a tout syllabe du texte ne correspondant à aucun kanas dans la table de traduction.
   
   
  
 
