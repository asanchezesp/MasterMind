/** 
 * Esta clase almacena los datos de cada jugador
 * 
 * @author Alejandro Sánchez
 * @version 1.0
 * @since 1.0
 *
 */
public class Jugador {
	/**
	 * Tablero con todas las combinaciones  realizadadas por cada jugador y sus respuestas
	 */
	private Tablero tablero;

	/**
	 * Modo de juego generado dependiendo de la elección del usuario
	 * @see ModoJuego
	 * 
	 */
	protected ModoJuego modo;
	protected String colores[] = {"negro","rojo","verde","amarillo","azul","morado","celeste","verde claro","celeste oscuro","turquesa"};
	
	/**
	 * Genera un nuevo jugador y su tablero a través del modo de juego introducido
	 * @param modo El modo de jugo desde el cual se generará el tablero
	 * @since 1.0
	 */
	public Jugador(ModoJuego modo) {
		tablero = new Tablero(modo);
		this.modo = modo;
	}
	
	public Tablero getTablero() {
		return tablero;
	}
	
	/**
	 * Compara los colores acertados correctamente y los colores acertados pero no en sus casillas
	 * con los valores introducidos por el usuario. Si los valores son correctos, introducirá las respuestas en la combinación del otro usuario
	 * @param adivinados_pos Colores que el usuario indica que ha acertado correctamente el otro jugador
	 * @param adivinados Colores que el usuario indica que ha acertado pero no en su casilla correcta el otro juegador
	 * @return True: Si son iguales. False: Si no son iguales
	 * @see CombinacionRespuesta #introducirRespuesta(int, int)
	 * @since 1.0
	 *
	 */
	public boolean compararAcertados(int adivinados_pos, int adivinados) { // La primera variable será el nº de colores acertados en su posición correcta y la segunda solo los colores acertados
		boolean resultado = true, comparacion;
		int rojos=0, blancos=0;
		
		for(int i=0; i< tablero.getCombinacion().getCeldas().length; i++)
			for(int j=0; j<tablero.getCombinacion().getCeldas().length; j++) {
				comparacion = getTablero().getcombSecreta().getValorCelda(i).equals(getTablero().getCombinacion().getValorCelda(j));
				if(comparacion && i==j)
					rojos++;
				else
					if(comparacion)
						blancos++;
			}
		
		if((rojos-blancos)==(adivinados_pos-adivinados))
			tablero.getCombinacion().introducirRespuesta(rojos, blancos);
		else 
			resultado = false;
			
				
		return resultado;
	}
	
	/**
	 * Comprueba que en la cadena dada por parámetro no hayan colores repetidos
	 * @param casillas
	 * @return True: Si algún color se encuentra repetido. False: Si ningún color está repetido
	 * @since 1.0
	 */
	public boolean isRepetido(Combinacion casillas) {
		boolean resultado = false;
		int i,j;
		
		for(i=0; i<casillas.getCeldas().length-1 && !resultado;i++) 
			for(j=0; j<casillas.getCeldas().length-1 && !resultado;j++)
				if(casillas.getValorCelda(i).equals(casillas.getValorCelda(j)) && i!=j)
					resultado = true;
		
		return resultado;
	}
	
	
	

	
}
