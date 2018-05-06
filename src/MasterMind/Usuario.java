package MasterMind;

import Teclado.Teclado;

/**
 * Esta clase almacena los métodos usados por el jugador en caso de que sea un usuario el que juegue
 * @author Alejandro Sánchez
 * @version 1.0
 * @since 1.0
 * @see Jugador
 *
 */

public class Usuario extends Jugador {

	/** 
	 * Llama al constructor del padre con el modo de juego introducido por parámetro
	 * @see Jugador#Jugador(ModoJuego)
	 * @see ModoJuego
	 * @param modo Modo de juego desde el que se iniciará 
	 */
	public Usuario(ModoJuego modo) {
		super(modo);
	}
	
	/**
	 * Pide al usuario que introduzca entre los colores disponibles los que desee en la combinación 
	 * @see Colores
	 */
	public void introducirCasillas() {
		int eleccion;
		
		for(int i=0; i<getTablero().getCombinacion().getCeldas().length;i++) {

			eleccion = Teclado.numeroEntreLimites(1, getTablero().getNumColores(), Teclado.Limite.BOTH_IN, Teclado.TipoNumero.INT)-1;
			super.getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(colores[eleccion]), i);
	
		}
	}
	
	/**
	 * Introduce la combinación secreta del otro jugador dado por parámtero
	 * @param jugador Jugador al cual se le asignará la combinación introducida
	 * @see Tablero#setCombinacionSecreta(Combinacion)
	 */
	public void introducirCombSecreta(Jugador jugador) {
		int longitud, eleccion;
		boolean resultado;
		longitud = jugador.getTablero().getcombSecreta().getCeldas().length;
		Combinacion combinacion = new Combinacion(longitud);
		
		do {
			for(int i=0; i<getTablero().getCombinacion().getCeldas().length;i++) {

				eleccion = Teclado.numeroEntreLimites(1, getTablero().getNumColores(), Teclado.Limite.BOTH_IN, Teclado.TipoNumero.INT)-1;
				combinacion.colocarCeldas(Colores.elegirColor(colores[eleccion]), i);
			}
			resultado = isRepetido(combinacion);
			if(resultado)
				System.out.println("Error, no puede haber colores repetidos, introduzca otra secuencia de colores: ");
			
		}while(resultado);
		
		jugador.getTablero().setCombinacionSecreta(combinacion);
	}
	//Metodo para introducir los aciertos
	
	/**
	 * El usuario introducirá las respuestas del otro jugador, al que una vez comprobado que el
	 * usuario no ha introducido una respuesta incorrecta (para evitar así trampas) se le introducirá la respuesta de su combinación
	 * @param jugador Jugador al cual se le introducirá las respuestas de su combinación
	 * @see CombinacionRespuesta#introducirRespuesta(int, int)
	 */
	public void introducirRespuesta(Jugador jugador) {
		int rojos, blancos;
		boolean resultado = true;
		
		do {
			System.out.print("Introduzca el número de colores acertados correctamente: ");
			rojos = Teclado.numero(Teclado.TipoNumero.INT);
			System.out.print("Introduzca el número de colores acertados que no están en sus casillas correctas: ");
			blancos = Teclado.numero(Teclado.TipoNumero.INT);
			
			if(rojos + blancos <= 0 || rojos + blancos > getTablero().getCombinacion().getCeldas().length) {
				resultado = false;
				System.out.println("Error, el número total de respuesta no corresponde con la cantidad de colores disponible");
			}
			
			if(!jugador.compararAcertados(rojos, blancos)) {
				System.out.println("Error, la respuesta no es correcta, por favor, introduzca la respuesta correcta sin hacer trampas: ");
				resultado = false;
			}
			
		}while(!resultado);
		
		jugador.getTablero().getCombinacion().introducirRespuesta(rojos, blancos);
		
	}
	
	
}
