package MasterMind;

/**
 * Enum que guarda los valores dependiendo del modo de juego que elija el usuario
 * @see ModoJuego
 * @author Alejandro Sánchez
 * @version 1.0
 * @since 1.0
 *
 */
public enum Dificultad {
	FACIL(10,false,4,8), MEDIO(15,false,5,8), DIFICIL(-1,true,8,10);
	
	private int eleccion, numIntentos, numCasillas, numColores;
	private boolean repeticion;
	
	/**
	 * Genera la dificultad dependiendo del modo
	 * @param numIntentos Número de intentos disponibles
	 * @param repeticion True: La repetición de colores se permite. False: La repetición de colores no se permite
	 * @param numCasillas Número de casillas que tendrá la combinación
	 * @param numColores Número de colores disponibles para la partida
	 */
	Dificultad(int numIntentos,boolean repeticion, int numCasillas, int numColores) {
		this.numIntentos = numIntentos;
		this.numCasillas = numCasillas;
		this.numColores = numColores;
		this.repeticion = repeticion;
	}

	public int getDificultad() {
		return eleccion;
	}

	public int getNumIntentos() {
		return numIntentos;
	}


	public int getNumCasillas() {
		return numCasillas;
	}


	public int getNumColores() {
		return numColores;
	}


	public boolean isRepeticion() {
		return repeticion;
	}

}
