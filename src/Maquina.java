import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Esta clase almacena los métodos usados por el jugador en caso de que sea una máquina la que juegue
 * @author Alejandro Sánchez
 * @since 1.0
 * @see Jugador
 *
 */
public class Maquina extends Jugador {
	 /**
	  * Generación de números aleatorios para introducir las combinaciones
	  */
	private Random rnd = new Random();
	
	/**
	 * Llama al constructor del padre con el modo de juego introducido por parámetro
	 * @see Jugador#Jugador(ModoJuego)
	 * @param modo mModo de juego generado dependiendo de la elección del usuario
	 * @see ModoJuego
	 */
	public Maquina(ModoJuego modo) {
		super(modo);
		
	}
	
	/**
	 * Dependiendo de la dificultad seleccionada, la máquina generará una combinación secreta, la cual deberá de adivinar el otro jugador
	 * @return La combinación secreta que será introducida al otro jugador
	 * @see Dificultad
	 * @see Colores
	 */
	public Combinacion introducirCombSecreta(){
	Combinacion combinacion = new Combinacion(super.getTablero().getCombinacion().getCeldas().length);
	ArrayList<String> colores_disp = new ArrayList<>(Arrays. asList(colores));
	int posicion; // Posición del ArrayList

	switch(getTablero().getModo().getDificultad()) {
	
		case DIFICIL:
			for(int i=0; i<combinacion.getCeldas().length;i++) {
				posicion = rnd.nextInt(combinacion.getCeldas().length) +1;
				combinacion.colocarCeldas(Colores.elegirColor(colores_disp.get(posicion)), i);
			}
		break;
		
		//Modos Fácil y Medio
		default:
			for(int i=0; i<combinacion.getCeldas().length;i++) {
				posicion = rnd.nextInt(combinacion.getCeldas().length) +1;
				combinacion.colocarCeldas(Colores.elegirColor(colores_disp.get(posicion)), i);
				colores_disp.remove(posicion);
			}
		break;
	}
		return combinacion;
		
	}
	
	//Metodo para introducir la combinación secreta dependiendo del tipo de juego // Implementado modo fácil.
	
	/**
	 * Dependiendo de si el modo de juego deja repetir colores o no, la máquina generará una combinación para intentar adivinar su combinación secreta
	 * asignada
	 * @see Tablero#isRepeticion()
	 * @see Combinacion#colocarCeldas(String, int)
	 * @see Colores
	 */
	public void introducirCombinacion() {
		ArrayList<String> colores_disp = new ArrayList<>(Arrays. asList(colores));
		int eleccion, longitud = getTablero().getCombinacion().getCeldas().length;
		
		if(!getTablero().isRepeticion()) {
			for(int i=0; i<longitud;i++) {
				eleccion = rnd.nextInt(longitud) +1;
				getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(colores_disp.get(eleccion)), i);
			}
		}
		else {
			for(int i=0; i<longitud;i++) {
				eleccion = rnd.nextInt(longitud) +1;
				getTablero().getCombinacion().colocarCeldas(colores_disp.get(eleccion), i);
			}
		}
	}

	//Metodo para introducir las repsuestas
	
	/**
	 * La máquina, dependiendo de la dificultad asignada, comprobará cuantos colores ha acertado el otro jugador de su combinación secreta e introducirá su respuesta
	 * @param jugador Jugador al que será comprobado su combinación dada
	 * @see Dificultad
	 * @see Tablero #getcombSecreta()
	 * @see CombinacionRespuesta#introducirRespuesta(int, int)
	 */
	public void introducirRespuestas(Jugador jugador) {
		int rojos=0, blancos=0, longitud = super.getTablero().getCombinacion().getCeldas().length, contador = getTablero().getcombSecreta().getCeldas().length;
		boolean comparacion,color_dificil;
		ArrayList<Casilla> combinacion = new ArrayList<>(Arrays.asList(jugador.getTablero().getCombinacion().getCeldas()));
		
		switch(getTablero().getModo().getDificultad()) {
		
			case DIFICIL:
				while(contador!=0) {
					color_dificil=false;
					for(int i=0; i< longitud && !color_dificil;i++)
						for(int j=0; j<combinacion.size() && !color_dificil; j++) {
							comparacion = jugador.getTablero().getcombSecreta().getValorCelda(i).equals(combinacion.get(j));
							if(comparacion && i==j) {
								rojos++;
								color_dificil = true;
								combinacion.remove(j);
							}
							else
								if(comparacion) {
									blancos++;
									color_dificil = true;
									combinacion.remove(j);
								}
						}
					contador--;
				}
			break;

			default:
				for(int i=0; i< longitud;i++)
					for(int j=0; j<longitud; j++) {
						comparacion = jugador.getTablero().getcombSecreta().getValorCelda(i).equals(jugador.getTablero().getCombinacion().getValorCelda(j));
						if(comparacion && i==j)
							rojos++;
						else
							if(comparacion)
								blancos++;
					}
			break;
		}
		
		jugador.getTablero().getCombinacion().introducirRespuesta(rojos, blancos);
	}
	//Metodo para intentar adivinar la combinación secreta dependiendo del tipo de juego
	
	
	
	
	
	

}
