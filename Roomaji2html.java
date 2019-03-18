
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Roomaji2html {

	private static final String ENTREE_MSG = "     Veuillez choisir un nom pour le fichier d'ENTREE (texte roomaji).";
	private static final String SORTIE_MSG = "     Veuillez choisir un nom pour le fichier de SORTIE. il doit se terminer par l'extention .html ";
	private static final String INVALIDE_MSG = "     Le nom du fichier entré est invalide";
	
	/**
	 * Affiche ˆ l'écran un message de bienvenue
	 * 
	 * 
	 */
	public static void affichePresentation () {

		System.out.println ("Bienvenue dans le traitement et la mise en page de caratère japonais");
		System.out.println ("");
		System.out.println ("Ce programme recois un texte écrit de gauche ˆ droite et de haut en bas en syllabe roomoji");
		System.out.println ("pour produire un texte lisible de haut en bas de droite ˆ gauche écriture japonaise, des hiragana ");
		System.out.println ("");
		
		System.out.println ("          3 ETAPES");
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
	*  @param FileWriter : Le fichier externe dans lequel écrire
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
	*  @param FileWriter : Le fichier externe dans lequel écrire
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
		System.out.print("     >> Entrer le nom du fichier (au moins un caractère): ");
		tempStr = sc.nextLine();

		while (tempStr.length() == 0) {
			System.out.println(INVALIDE_MSG);
			System.out.println(s);
			System.out.print("     >> Entrer le nom du fichier (au moins un caractère): ");
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
		
		// Début du programme
		
		// Affiche la prŽsentation et les instructions
		affichePresentation ();
		
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		// Chargement de la table de traduction des kanas
		System.out.println("\nChargement de la table des kanas");
		tableHiragana.chargementTableHiragana(); 
		
		
		// vérification si le chargement c'est bien effecté
		if (tableHiragana.size() != 0) {
			System.out.println("   ... Le chargement de la table a été effectué avec succès. \n");
		}
		else {
			System.out.println("   x   il y a eu un problème lors du chargement de la table. \n");
			
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
				System.out.println("   LE FICHIER " + fichierEntree  +" N'A PAS ÉTÉ TROUVÉ DANS LE RÉPERTOIRE PAR DÉFAUT !");	
		}catch (IOException ioe) {	
					System.out.println("Erreur d'entree/sortie !");
		}
		
		// vŽrification si la lecture et la construction des roomagis ce sont bien effectŽ
		if (texteJaponais.size() != 0 ) {
			System.out.println("   ... Le fichier a ÉtÉ lu avec succès, le texte roomagi a ÉtÉ construit avec succès.\n");
		}
		else {
			System.out.println("   x   un problème est survenu lors de la lecture du fichier et la construction du texte roomaji \n");
		}
	
		fichierSortie = entrerNomFichier(SORTIE_MSG);
		System.out.println("\nƒcriture du fichier (" + fichierSortie + ") ..\n");
		// ----------------- ECRITURE DANS LE FICHIER HTML
		
		FileWriter sortie;
		try {
			
			sortie = new FileWriter(fichierSortie); //IOException
			if (texteJaponais.size() != 0 ) {
				
				// écriture dans le fichier externe
				ecrireEnteteHtml(sortie);
				texteJaponais.ecrireLigneHtml (tableHiragana, sortie);
				ecrirePiedPageHtm(sortie);  	
				
				System.out.println("   ... écriture du fichier a été complètée avec succès");
				
				// vérifi si la table de traduction est bien chargé
				if (tableHiragana.size() == 0) {
					System.out.println("       ATTENTION UN PROBLéME EST SURVENU LORS DU CHARGEMENT DE LA TABLE DE TRADUCTION");
					System.out.println("       L'AFFICHAGE DES CARACTéRES JAPONAIS SONT COROMPU .\n");
				}
				else {
					System.out.println("");
				}
			}
			else{
				System.out.println("   x   Aucune donnée n'a été trouvé. \n");
			}
			
			sortie.close();
			} catch (IOException ioe) {
			System.out.println("Erreur d'entree/sortie !");
		}

		System.out.println("FIN NORMAL DU PROGRAMME DE ECRITURE FICHIER");
		System.out.println ("Merci de l'utilisation de ce programme");		

	}
}
