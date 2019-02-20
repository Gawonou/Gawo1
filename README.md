# Gawo1



# Construction du fichier HTML de sortie
  
 
  Dans ce travail, nous lirons un fichier (entree) texte représentant un texte roomaji (pronociation syllabique) (lecture de gauche ˆ droite et de haut en bas)
  
  Pour produire un autre fichier (sortie)  représentant sa coresponance en caractre japonais. (lecture droite ˆ gauche et de haut en bas )
  
  
 # PROCESSUS
  
 ## Le programme effectura trois opérations
  
 ### Chargement de la table de traduction

 ### Lecture du fichier externe (dans le meme temps, il va creer le texte roomaji avec les donnŽes trouvŽ)
  
 ### ƒcrite du fichier externe correspondant a un fichier HTML
  
  
  STRUCURE
  
   - La structure est la suivante
   
   
   Kanas  : représente une structure qui contient les informations d'un kana 
 *  	  	 ou l'on retrouve 
 *  
 *  		 hiragana
 *  		 unicode1
 *  		 unicode2 
 *  
 *  TableTraduction : reprŽsente un Array du Kanas  (DestinŽ a contenir tout les unicodes des kanas)
 * 
 * 
 * Roomaji	: reprŽsente une stucture qui contient les syllabes lu dans le texte roomaji
 *			  ou l'on retrouve
 *
 *			 kanas : le texte lu
 *			 ligne : ligne dans le fichier ou la syllabe a ŽtŽ trouvŽ
 *			 numero: le rang (position) dans laquelle la syllabe a ŽtŽ trouvŽ dans la ligne
 *			 estPoint : dŽtermine si cette syllabe est suivi d'un point 
 * 
 * TexteRoomaji	: reprŽsente un Array de Roomadi (DestinŽ ˆ contenir le texte Roomaji)
 * 
 * Roomaji2html.java : comprend le programme principal main
 * 
 * 
 * 		Instructions
 * 
 * 		1. Le programme vous invite a entrer le nom du fichier d'entrer pour le texte en Roomaji.
 * 		   ainsi que le nom du fichier de sortie pour le fichier en html")
 * 
 * 		2. Une fois le programme terminer, rendez vous dans le repertoire par defaut de votre ordinateur
 * 		   et vous trouvez le fichier de sortie  avec le rŽsultat en (Hiragana) caractre japonais (le nom du fichier a ŽtŽ spŽcifiŽ par l'usager).
 * 
 * 		Informations supplŽmentaires ....
 * 
 * 		Si le programme ne trouve pas le fichier entrŽ par l'usager, un message d'erreur s'affichera et
 * 		  et dans ce cas, le fichier  sera vide.
 * 		Il est trs important que le fichier  respecte les dŽfinitions syntaxiques 
 * 		  des syllabes Roomajis pour avoir les rŽsultats dŽsirŽs.
 * 		
 *
 *	 
 *
 * 
 * RESTRICTIONS
 * 
 * - Aucun control n'est effectuŽ sur la validitŽ syntaxique des kanas pour la table de traduction
 *   
 * - Aucun control n'est effectuŽ sur les donnŽes dans le fichier d'entrŽe.
 *   Nous supposons que les donnŽes entrŽes soient conformes ˆ syntaxe des syllabes Roomaji.
 *   
 * - Toutefois, un X sera placŽ dans le fichier de sortie HTLM a tout syllabe du texte ne correspondant ˆ aucun kanas dans la table de traduction.
 *  
 *  
 * 
 */
