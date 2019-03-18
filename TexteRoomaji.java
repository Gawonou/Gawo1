
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TexteRoomaji  extends ArrayList<Roomaji> {

	
	// Liste des voyelle permise dans les kanas (dŽlimite la fin d'une syllabe roomaji)
	private static final char [] VOYELLE   = {'a', 'e', 'i', 'o', 'u' };
	
	// syllabe spŽciale correspondant ˆ : '  (dŽlimite la fin d'une syllabe roomaji le : n')
	private static final char  SPECIAL  =  39 ;
	
	// Les balises ouvrante et fermante pour le fichier HTML
	private static final String BALISE_TR_OUVRANTE  = "			<tr>";
	private static final String BALISE_TR_FERMANTE  = "</tr> \n";
	private static final String BALISE_TD_OUVRANTE  = "<td>";
	private static final String BALISE_TD_FERMANTE  = "</td>";
	
	// Caractre pour si le les kanas sont invalides
	private static final String SYLLABE_INEXISTANT  = "X";

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4167140850154957956L;

	private static int _maxLigne = 0;
	private static int _maxNumero = 0;
		
		
	/**
	 * @return the _maxLigne
	 */
	public int get_maxLigne() {
		return _maxLigne;
	}

	/**
	 * @return the _maxNumero
	 */
	public int get_maxNumero() {
		return _maxNumero;
	}	
	
	/**
	 * 
	 * Retourne le Roomaji situŽ a une ligne et une colonne prŽcise.
	 * 
	 * @param int : 
	 * 
	 * @return the Roomaji
	 */
	public Roomaji trouveSyllabeRoomaji (int ligneHTML, int colonneHTML) {
		// indice
		int i = 0;
		
		Roomaji r = null;
		
		// Parcours du texte a la recherche de la ligne et la colonne spécifié dans les parametres
		while ( i <= this.size() -1)  {
			if ((this.get(i).get_ligne() == colonneHTML) && (this.get(i).get_numero() == ligneHTML)) {		
				r = this.get(i);
			}
			i++;
		}
		return r;
	}
	
	
	/**
	* 
	* Parcour toute ligne du fichier html (structure du texte) afin ecrire chaque colonne dans le format HTML
	* 
	* @param Table de traductio
	* @param Ficher externe
	* 
	* @throws IOException 
	*/
	public void ecrireLigneHtml (TableTraduction table, FileWriter f) throws IOException {	
		
		Roomaji syllabeJaponais;
		Kanas hiragana;
		// Parcours tout les lignes du HTML
		for (int ligneHtml=1; ligneHtml<= this.get_maxNumero() ;ligneHtml++) {
			f.write(BALISE_TR_OUVRANTE);
			
			// Parcours les colonnes du fichier HTML
			for (int colonneHtml=this.get_maxLigne(); colonneHtml>=1;colonneHtml--) { 
				// Balise ouvrante
				f.write(BALISE_TD_OUVRANTE);
				
				// Cherche le syllabe a imprimer dans le html dans le texte Roomaji 
				syllabeJaponais = this.trouveSyllabeRoomaji(ligneHtml,colonneHtml);
				
				// s'il a trouvŽ
				if (syllabeJaponais != null) {
					// recherche de la correspondance en Hiragana
					hiragana = table.chercheHiragana(syllabeJaponais.get_kanas());
					
					// s'il a trouvŽ
					if (hiragana != null) {
						// ƒcris les hiragana simple ou double selon les cas en format HTML
						f.write( " " + hiragana );
						
						// Si il y a un point dans le texte, alors il Žcris un point dans le fichier html
						if (syllabeJaponais.is_existePoint()) {
							f.write( ".");
						}
					}
					else {
						// Syllabe non trouvé dans dans la table de correspondance
						f.write(SYLLABE_INEXISTANT);
					}
				}
				// Balise fermante
				f.write(BALISE_TD_FERMANTE);
			}
			// Balise fermante
			f.write(BALISE_TR_FERMANTE);
		}
	}


	/**
	* 
	* Ajoute dans le texte chaque Roomaji (en fonction des règles syntaxique des Roomaji) trouvé dans la ligne placé en paramettre
	* 
	* 
	* @param String			:  
	* 					
	*/
	public void ajouterLigne ( String s) {
		
		int i=0;
		String tmpKanas = "";
		Roomaji r = null;
		int num = 0;
		boolean estPoint = false;
		
		// nombre de ligne lu dans le fichier externe
		_maxLigne ++;
		
		// Tant qu'il n'a pa lu tout la ligne
		while ( i <= (s.length() - 1) ){
			estPoint = false;
			if (s.charAt(i) != ' ' ) {
				
				// Ne tient pas compte du point pour la formation des kanas
				if (s.charAt(i) != '.') {
					tmpKanas = tmpKanas + s.charAt(i);
				}
				
			
				if (   (estInclus(s.charAt(i),VOYELLE))  || (s.charAt(i) == SPECIAL)  ){
					
					// Verifie si le prochain caractere est un point
					if ( (i <= (s.length() -2) ) &&  (s.charAt(i+1) == '.') ){
						
						// Indique ˆ la structure que ce Roomaji est suivi d'un point
						estPoint = true;
					}
					// va au prochain caractere
					num++;
					
					// Cherche la ligne ou il y aura plus de Roomagi 
					if (_maxNumero < num) {
						_maxNumero = num;
					}
					
					r = new Roomaji(tmpKanas.toLowerCase(),_maxLigne,num,estPoint);
					this.add(r);			
					tmpKanas = "";
				}
			}
			i++;
		}
	}
	
	/**
	* 
	* Verifie si le caractere passé en parametre se trouve dans une liste donné en parametre
	* 
	* 
	* @param char 	 : caractere chercher 
	* @param char [] : Liste a chercher	 
	* 					
	*/
	
    static public boolean estInclus (char c, char [] list ) {
		boolean valideChoix =false;
		int i = 0;
		
		while (i <= (list.length - 1) && !valideChoix) {
			if (list[i] == c) {
				valideChoix = true;
			}  // if
			i = i +1;
		}  // while
		return valideChoix;
	} // isChoixMenu
}


	
	
	
