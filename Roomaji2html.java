
/**
 * I N F 2 1 2 0 - ETE2018 - Groupe 20
 *
 * * --------------------------------------------------------------
 * 
 * Travail fait en Žquipe
 * 
 * ƒquipier 1
 * ----------
 * 
 * PrŽnom  NOM  	:  Ussel SABBAT
 * 
 * Code permanent   : SABU27107001
 *  
 * Email 			: ussels@hotmail.com
 * 
 * 
 * 
 * 
 * ƒquipier 2
 * ----------
 * 
 * PrŽnom NOM   	: Koukou Gawonou N'TSOUAGLO
 * 
 * Code permanent 2 : NTSK11088202
 *  
 * Email 2			: ck391056@ens.uqam.ca
 * 
 * --------------------------------------------------------------
 * 
 * Construction du fichier HTML de sortie
 * 
 * 
 * Dans ce travail, nous lirons un fichier (entree) texte reprŽsentant un texte roomaji (pronociation syllabique) (lecture de gauche ˆ droite et de haut en bas)
 * 
 * Pour produire un autre fichier (sortie)  reprŽsentant sa coresponance en caractre japonais. (lecture droite ˆ gauche et de haut en bas )
 * 
 * 
 * PROCESSUS
 * 
 * Le programme effectura trois opŽrations
 * 
 * - Chargement de la table de traduction
 * 
 * - Lecture du fichier externe (dans le meme temps, il va creer le texte roomaji avec les donnŽes trouvŽ)
 * 
 * - ƒcrite du fichier externe correspondant a un fichier HTML
 * 
 * 
 * STRUCURE
 * 
 *  - La structure est la suivante
 *  
 *  
 *  Kanas  : reprŽsente une structure qui contient les informations d'un kana 
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




import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Roomaji2html {

	private static final String ENTREE_MSG = "     Veuillez choisir un nom pour le fichier d'ENTRƒE (texte roomaji).";
	private static final String SORTIE_MSG = "     Veuillez choisir un nom pour le fichier de SORTIE. il doit se terminer par l'extention .html ";
	private static final String INVALIDE_MSG = "     Le nom du fichier entrŽ est invalide";
	
	/**
	 * Affiche ˆ l'Žcran un message de bienvenue
	 * 
	 * 
	 */
	public static void affichePresentation () {

		System.out.println ("Bienvenue dans le traitement et la mise en page de caratre japonais");
		System.out.println ("");
		System.out.println ("Ce programme recois un texte Žcrit de gauche ˆ droite et de haut en bas en syllabe roomoji");
		System.out.println ("pour produire un texte lisible de haut en bas de droite ˆ gauche Žcriture japonaise, des hiragana ");
		System.out.println ("");
		
		System.out.println ("          3 ƒTAPES");
		System.out.println ("");
		System.out.println ("    +---- CHARGEMENT de la table de traduction des kanas ");
		System.out.println ("");
		System.out.println ("    +---- LECTURE d'un fichier texte et creation du texte en roomaji");
		System.out.println ("");
		System.out.println ("    +---- ƒCRITURE d'un fichier en format HTML ");
		System.out.println ("");
		
	}
	
	
	/**
	* Ecrit l'entete de la page HTML
	*  
	*  
	*  @param FileWriter : Le fichier externe dans lequel Žcrire
	*  
	*  @throws IOException 
	* 
	*/	public static void ecrireEnteteHtml (FileWriter f) throws IOException {
		f.write("<!DOCTYPE html>\n");
		f.write("<html>\n");
		f.write("	<head>\n");
		f.write("		<title>TP1</title>\n");
		f.write("	</head>\n");
		f.write("	<body>\n");
		f.write("		<hr>\n");
		f.write("		<table>\n");
	}


	/**
	*  Ecrit le pied de la page HTML dans un fichier externe
	*  
	*  
	*  @param FileWriter : Le fichier externe dans lequel Žcrire
	*  
	*  @throws IOException 
	* 
	*/
	public static void ecrirePiedPageHtm (FileWriter f) throws IOException {
		f.write("		</table>\n");
		f.write("		<hr>\n");
		f.write("	</body>\n");
		f.write("</html>\n");
	}
	
	public static String entrerNomFichier (String s) {
		String tempStr = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.println(s);
		System.out.print("     >> Entrer le nom du fichier (au moins un caractre): ");
		tempStr = sc.nextLine();

		while (tempStr.length() == 0) {
			System.out.println(INVALIDE_MSG);
			System.out.println(s);
			System.out.print("     >> Entrer le nom du fichier (au moins un caractre): ");
			tempStr = sc.nextLine();
			
		}
		
		
		
		
		return tempStr;
	}

	// MAIN
	
	public static void main(String[] args)  {
		
		// Variables
		TexteRoomaji texteJaponais = new TexteRoomaji ();
		TableTraduction tableHiragana = new TableTraduction ();		
		String ligne = null;
		BufferedReader entree;
		String fichierEntree = "";
		String fichierSortie = "";
		
		// DŽbut du programme
		
		// Affiche la prŽsentation et les instructions
		affichePresentation ();
		
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		// Chargement de la table de traduction des kanas
		System.out.println("\nChargement de la table des kanas");
		tableHiragana.chargementTableHiragana(); 
		
		
		// vŽrification si le chargement c'est bien effectŽ
		if (tableHiragana.size() != 0) {
			System.out.println("   ... Le chargement de la table a ŽtŽ effectuŽ avec succs. \n");
		}
		else {
			System.out.println("   x   il y a eu un problme lors du chargement de la table. \n");
			
		}
		
		// Lecture du Fichier Roomaji
		fichierEntree = entrerNomFichier(ENTREE_MSG);
		System.out.println("\nLecture du fichier (" + fichierEntree  + ") ");
		try {
			entree = new BufferedReader(new FileReader(fichierEntree));			
			while (entree.ready()) {
				ligne = entree.readLine();
			
				if (ligne.trim().length() >= 1) {
					texteJaponais.ajouterLigne (ligne);
				}
			}
			entree.close();
			
		}catch (FileNotFoundException e) {	
				System.out.println("   LE FICHIER " + fichierEntree  +" N'A PAS ƒTƒ TROUVƒ DANS LE RƒPERTOIRE PAR DƒFAUT !");	
		}catch (IOException ioe) {	
					System.out.println("Erreur d'entree/sortie !");
		}
		
		// vŽrification si la lecture et la construction des roomagis ce sont bien effectŽ
		if (texteJaponais.size() != 0 ) {
			System.out.println("   ... Le fichier a ŽtŽ lu avec succs, le texte roomagi a ŽtŽ construit avec succs.\n");
		}
		else {
			System.out.println("   x   un problme est survenu lors de la lecture du fichier et la construction du texte roomaji \n");
		}
	
		fichierSortie = entrerNomFichier(SORTIE_MSG);
		System.out.println("\nƒcriture du fichier (" + fichierSortie + ") ..\n");
		// ----------------- ECRITURE DANS LE FICHIER HTML
		
		FileWriter sortie;
		try {
			
			sortie = new FileWriter(fichierSortie); //IOException
			if (texteJaponais.size() != 0 ) {
				
				// ƒcriture dans le fichier externe
				ecrireEnteteHtml(sortie);
				texteJaponais.ecrireLigneHtml (tableHiragana, sortie);
				ecrirePiedPageHtm(sortie);  	
				
				System.out.println("   ... Žcriture du fichier a ŽtŽ complŽtŽe avec succs");
				
				// vŽrifi si la table de traduction est bien chargŽ
				if (tableHiragana.size() == 0) {
					System.out.println("       ATTENTION UN PROBLéME EST SURVENU LORS DU CHARGEMENT DE LA TABLE DE TRADUCTION");
					System.out.println("       L'AFFICHAGE DES CARACTéRES JAPONAIS SONT COROMPU .\n");
				}
				else {
					System.out.println("");
				}
			}
			else{
				System.out.println("   x   Aucune donnŽe n'a ŽtŽ trouvŽ. \n");
			}
			
			sortie.close();
			} catch (IOException ioe) {
			System.out.println("Erreur d'entree/sortie !");
		}

		System.out.println("FIN NORMAL DU PROGRAMME");
		System.out.println ("Merci de l'utilisation de ce programme");		

	}
}
