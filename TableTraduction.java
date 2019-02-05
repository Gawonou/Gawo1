
import java.util.ArrayList;

public class TableTraduction extends ArrayList <Kanas>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	* 
	* Parcours la table de traduction jusqu'à ce qu'il trouve le kanas correspondant à la valeur recherché
	*
	* @param Valeur de la syllabe recherché
	* 		 
	* @return Retourne le Kanas correspondant avec la syllabe recherché
	* 	      s'il ne trouve pas il retournera null
	* 
	*/	
	public Kanas chercheHiragana (String syllabeChercher) {
		Kanas hiraganaChercher = null;
		int i = 0;
		boolean estDansTable = false;
		// Parcours la table table de traduction jusqu'à ce qu'il trouve une corresponance ou qu'il arrive a la fin.
		while(i <= (this.size()-1) && !estDansTable) {
			// si il trouve la syllabe placé en paramettre dans la table de traduction
			if (this.get(i).get_hiragana().compareTo(syllabeChercher) == 0)  {
				// indique que le syllabe recherché est dans la table
				estDansTable = true;
				hiraganaChercher = this.get(i);
			}
			// prochain élément de la liste
			i++;
		}
		// retourne null s'il ne trouve pas de correspondance
		return hiraganaChercher;
	}

	
	/**
	* Ajoute une definition sous forme de kanas dans la table de traduction
	* Associe un kanas avec une valeur unicode sous forme numérique
	*
	* @param str		: valeur de la syllabe kanas
	* 		 unicode1	: valeur de l'unicode 1 
	*/
	private void ajouteKanas(String str, int unicode1) {
		
		Kanas k = new Kanas(str.toLowerCase(),unicode1);
		this.add(k);
}

	/**
	* Ajoute une definition sous forme de kanas dans la table de traduction
	* Associe un kanas avec deux valeurs unicodes sous forme numérique
	*
	* @param str		: valeur de la syllabe kanas
	* 		 unicode1	: valeur de l'unicode 1 
	* 		 unicode2	: valeur de l'unicode 2
	* 
	*/
	private void ajouteKanas(String str, int unicode1,int unicode2) {
		
		Kanas k = new Kanas(str.toLowerCase(),unicode1,unicode2);
		this.add(k);
	}	
	
	
	/**
	* Charge la table de traduction avec les kanas et leurs correspondances unicodes
 	*
	* @param s:  Kanas a associé
	* 		 u1	: Unicode 1
	* 		 u2 : Unicode 2
	* 
	*/	
	public void chargementTableHiragana () {
		
		this.ajouteKanas("A",12354);
		this.ajouteKanas("I",12356);
		this.ajouteKanas("U",12358);
		this.ajouteKanas("E",12360);
		this.ajouteKanas("O",12362);
		this.ajouteKanas("Ka",12363);
		this.ajouteKanas("Ki",12365);
		this.ajouteKanas("Ku",12367);
		this.ajouteKanas("Ke",12369);
		this.ajouteKanas("Ko",12371);
		this.ajouteKanas("Sa",12373);
		this.ajouteKanas("Shi",12375);
		this.ajouteKanas("Su",12377);
		this.ajouteKanas("Se",12379);
		this.ajouteKanas("So",12381);
		this.ajouteKanas("Ta",12383);
		this.ajouteKanas("Chi",12385);
		this.ajouteKanas("Tsu",12388);
		this.ajouteKanas("Te",12390);
		this.ajouteKanas("To",12392);
		this.ajouteKanas("Na",12394);
		this.ajouteKanas("Ni",12395);
		this.ajouteKanas("Nu",12396);
		this.ajouteKanas("Ne",12397);	
		this.ajouteKanas("No",12398);
		this.ajouteKanas("Ha",12399);
		this.ajouteKanas("Hi",12402);
		this.ajouteKanas("Fu",12405);
		this.ajouteKanas("He",12408);
		this.ajouteKanas("Ho",12411);
		this.ajouteKanas("Ma",12414);	
		this.ajouteKanas("Mi",12415);
		this.ajouteKanas("Mu",12416);
		this.ajouteKanas("Me",12417);
		this.ajouteKanas("Mo",12418);
		this.ajouteKanas("Ya",12420);
		this.ajouteKanas("Yu",12422);
		this.ajouteKanas("Yo",12424);
		this.ajouteKanas("Ra",12425);
		this.ajouteKanas("Ri",12426);
		this.ajouteKanas("Ru",12427);	
		this.ajouteKanas("Re",12428);
		this.ajouteKanas("Ro",12429);
		this.ajouteKanas("Wa",12431);
		this.ajouteKanas("Wi",12432);
		this.ajouteKanas("We",12433);	
		this.ajouteKanas("Wo",12434);
		this.ajouteKanas("Ga",12364);
		this.ajouteKanas("Gi",12366);	
		this.ajouteKanas("Gu",12368);
		this.ajouteKanas("Ge",12370);
		this.ajouteKanas("Go",12372);
		this.ajouteKanas("Za",12374);
		this.ajouteKanas("ji",12376);	
		this.ajouteKanas("Zu",12378);
		this.ajouteKanas("Ze",12380);
		this.ajouteKanas("Zo",12382);	
		this.ajouteKanas("Da",12384);
		this.ajouteKanas("Di",12386);
		this.ajouteKanas("Dzu",12389);
		this.ajouteKanas("De",12391);
		this.ajouteKanas("Do",12393);	
		this.ajouteKanas("Ba",12400);
		this.ajouteKanas("Bi",12403);
		this.ajouteKanas("Bu",12406);	
		this.ajouteKanas("Be",12409);
		this.ajouteKanas("Bo",12412);
		this.ajouteKanas("Pa",12401);
		this.ajouteKanas("Pi",12404);
		this.ajouteKanas("Pu",12407);	
		this.ajouteKanas("Pe",12410);
		this.ajouteKanas("Po",12413);

		this.ajouteKanas("n'",12435);
		
		
		this.ajouteKanas("Kya",12365,12419);
		this.ajouteKanas("Kyu",12365,12421);
		this.ajouteKanas("Kyo",12365,12423);

		this.ajouteKanas("Sha",12375,12419);
		this.ajouteKanas("Shu",12375,12421);
		this.ajouteKanas("Sho",12375,12423);
		
		this.ajouteKanas("Cha",12385,12419);
		this.ajouteKanas("Chu",12385,12421);
		this.ajouteKanas("Cho",12385,12423);
		
		this.ajouteKanas("Nya",12395,12419);
		this.ajouteKanas("Nyu",12395,12421);
		this.ajouteKanas("Nyo",12395,12423);
		
		
		this.ajouteKanas("Hya",12402,12419);
		this.ajouteKanas("Hyu",12402,12421);
		this.ajouteKanas("Hyo",12402,12423);
		
		this.ajouteKanas("Mya",12415,12419);
		this.ajouteKanas("Myu",12415,12421);
		this.ajouteKanas("Myo",12415,12423);

		
		this.ajouteKanas("Rya",12426,12419);
		this.ajouteKanas("Ryu",12426,12421);
		this.ajouteKanas("Ryo",12426,12423);

		
		this.ajouteKanas("Gya",12466,12419);
		this.ajouteKanas("Gyu",12466,12421);
		this.ajouteKanas("Gyo",12466,12423);

		this.ajouteKanas("ja",12376,12419);
		this.ajouteKanas("ju",12376,12421);
		this.ajouteKanas("jo",12376,12423);
	
		this.ajouteKanas("dja",12386,12419);
		this.ajouteKanas("dju",12386,12421);
		this.ajouteKanas("djo",12386,12423);
		
		this.ajouteKanas("Bya",12403,12419);
		this.ajouteKanas("Byu",12403,12421);
		this.ajouteKanas("Byo",12403,12423);
		
		this.ajouteKanas("Pya",12404,12419);
		this.ajouteKanas("Pyu",12404,12421);
		this.ajouteKanas("Pyo",12404,12423);
		
	}	
}






