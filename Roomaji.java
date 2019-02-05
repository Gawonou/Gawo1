
public class Roomaji {
	
	private String _kanas;
	private int _ligne;
	private int _numero;
	private boolean _existePoint = false;
	
	// Constructeur
	
	/**
	 * @param _kanas
	 * @param _ligne
	 * @param _numero
	 * @param _existePoint
	 */
	public Roomaji(String _kanas, int _ligne, int _numero, boolean _existePoint) {
		super();
		this._kanas = _kanas;
		this._ligne = _ligne;
		this._numero = _numero;
		this._existePoint = _existePoint;
	}

	// Getter
	
	/**
	 * @return the _ligne
	 */
	public int get_ligne() {
		return _ligne;
	}

	/**
	 * @return the _numero
	 */
	public int get_numero() {
		return _numero;
	}
	
	/**
	 * @return the kanas
	 */
	public String get_kanas() {
		return _kanas;
	}

	// Methode

	/**
	 * 
	 * Retourne la valeur existePoit
	 * 
	 * @return the _existePoint
	 */
	public boolean is_existePoint() {
		return _existePoint;
	}
}
