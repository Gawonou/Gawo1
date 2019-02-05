
class Kanas {
	
	private String _hiragana;
	private int	_unicode1 = 0;
	private int _unicode2 = 0;
	
	
	// Getter
	
	/**
	 * 
	 * @return the _hiragana
	 */
	public String get_hiragana() {
		return _hiragana;
	}

	/**
	 * @return the _unicode1
	 */
	public int get_unicode1() {
		return _unicode1;
	}

	/**
	 * @return the _unicode2
	 */
	public int get_unicode2() {
		return _unicode2;
	}

	// Constructeur

	/**
	 * @param _hiragana
	 * @param _unicode1
	 */
	public Kanas(String _hiragana, int _unicode1) {
		super();
		this._hiragana = _hiragana;
		this._unicode1 = _unicode1;
	}
  
	/**
	 * @param _hiragana
	 * @param _unicode1
	 * @param _unicode2
	 */
	public Kanas(String _hiragana, int _unicode1, int _unicode2) {
		super();
		this._hiragana = _hiragana;
		this._unicode1 = _unicode1;
		this._unicode2 = _unicode2;
	}

	// Methode
	
	/**
	* 
	* Retourne si le Kanas est un Biographe
	* 
	* @return  boolean : retourne true s'il y a une valeur autre que 0 dans _unicode2, 
	* 					 retourne false si la valeur est Žgale 0
	*/
	public boolean estBigraphe () {
		return (_unicode2 != 0 );
	}	
	
	/**
	* 
	* Retourne la reprŽsentation en format HTML des unicodes du Kanas qui ne sont pas Žgale ˆ 0
	*	 
	* @return   "&#" + _unicode1 + ";" "&#" + _unicode2 + ";" 
	*		     si _unicode est Žgalse a 0, il ne retournera pas la deuxime partie
	* 			
	*/	
	public String toString() {
		String unicode2 = "";
		
		// Calcul de l'unicode2
		if (estBigraphe()) {
			unicode2 = "&#" + this._unicode2 + ";" ;
		}
			
		   // retourne la reprŽsentation des unicodes qui ne sont pas Žgale ˆ 0
		   return "&#" + this._unicode1 + ";" + unicode2 ;
		}
	
	
}