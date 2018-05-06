/**
 * Esta clase almacena las combinaciones que serán introducidas por el jugador
 * @author Alejandro Sánchez
 * @since 1.0
 * @version 1.0
 *
 */

public class Combinacion{
	/**
	 * Array que almacenará los colores que introduzca el jugador
	 * @see Casilla
	 */
	private Casilla celdas[];
	
	public Combinacion(int tamanio) {
		celdas = new Casilla[tamanio];
	}

	public Casilla[] getCeldas() {
		return celdas;
	}
	
	public Casilla getValorCelda(int posicion) {
		return celdas[posicion];
	}
	
	/**
	 * Introduce en el array el valor pasado por parámetro en la posición indicada
	 * @param valor Color elejido por el usuario
	 * @param posicion Posición de la combinación en la que se almacenará el color elegido
	 * @see Casilla
	 */
	public void colocarCeldas(String valor,int posicion) {
		celdas[posicion] = new Casilla(valor);
	}

}
