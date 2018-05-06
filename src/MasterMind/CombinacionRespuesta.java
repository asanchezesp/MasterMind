package MasterMind;

import java.util.Arrays;

/**
 * Esta clase almacenará la combinación introducida por el usuario junto a su respuesta
 * @author Alejandro Sánchez
 * @since 1.0 
 * @version 1.0
 * @see Combinacion
 *
 */

public class CombinacionRespuesta extends Combinacion implements Dibujable {
	/**
	 * Forma que tomará la respuesta en el tablero
	 */
	private final char ROMBO = 9670;
	/**
	 * Array con las respuestas de la combinación
	 */
	private String respuestas[];

	public int acertados, acertados_posicion;

	/** 
	 * Generará una nueva combinación cuya longitud será la introducida por parámetro
	 * @param tamanio El número de colores y respuestas que tendrá la combinación
	 * @see Combinacion#Combinacion(int)
	 */
	public CombinacionRespuesta(int tamanio) {
		super(tamanio);
		respuestas = new String[tamanio];
		Arrays.fill(respuestas, " ");
	}

	/**
	 * Introducirá las respuestas dependiendo del color del rombo.
	 * Si es rojo es que habrá acertado el color y su posición y si es celeste es que solo ha acertado el color
	 * @param acertados_posicion Colores acertados en su posición
	 * @param acertados Colores acertados pero en la posición incorrecta
	 * @see Colores
	 */
	public void introducirRespuesta(int acertados_posicion, int acertados) {
		this.acertados = acertados;
		this.acertados_posicion = acertados_posicion;
		
		for(int i=0;i<acertados_posicion;i++)
			respuestas[i] = String.format("%s", Colores.ROJO_ROMBO + ROMBO + Colores.RESET); // Acertados correctamente

		for(int i=0;i<acertados;i++)
			respuestas[acertados_posicion+i] = String.format("%s", Colores.CELESTE_ROMBO + ROMBO + Colores.RESET); //Solo colores acertados

	}
	
	public String[] getRespuestas() {
		return respuestas;
	}

	/**
	 * Dibuja la combinación
	 * @see Dibujable
	 */
	@Override
	public void dibujar() {
		
		for(int i=0;i<getCeldas().length;i++)
			System.out.printf("%s    %s ",getValorCelda(i), Colores.RESET);
		
	}
	
	/**
	 * Dibuja la combinación junto a su respuesta
	 * @see Dibujable
	 */
	public void dibujarRespuesta() {
		for(int i=0; i<2; i++) {
			if(i==1)
				System.out.print("  | ");
			dibujar();
			System.out.print("|");
			if(i==0)
				for(int j = 0; j<respuestas.length/2; j++)
					System.out.printf("%s ", respuestas[j]);
			else
				for(int j = respuestas.length/2; j<respuestas.length; j++)
					System.out.printf("%s ", respuestas[j]);
			System.out.println();
		}
	}

}
