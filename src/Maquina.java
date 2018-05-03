import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Maquina extends Jugador {
	
	//private HashMap<Combinacion,Integer> combinaciones = new HashMap<>(); // La clave es la combinación y el valor la respuesta
	private Random rnd = new Random();

	public Maquina(ModoJuego modo) {
		super(modo);
		
	}
	
	public Combinacion introducirCombSecreta(){
	Combinacion combinacion = new Combinacion(super.getTablero().getCombinacion().getCeldas().length);
	ArrayList<String> colores_disp = new ArrayList<>(Arrays. asList(colores));
	int posicion; // Posición del ArrayList
	// Hacer switch dependiendo del modo

	//Modo fácil
	for(int i=0; i<combinacion.getCeldas().length;i++) {
		posicion = rnd.nextInt(colores_disp.size());
		combinacion.setCeldas(Colores.elegirColor(colores_disp.get(posicion)), i);
		//Colores.elegirColor(colores[eleccion]), i
		colores_disp.remove(posicion);
		}

		
		return combinacion;
		
	}

	public boolean isRepetido(Combinacion casillas) {
		boolean resultado = false;
		int i,j;
		
		while(!resultado) {
			for(i=0; i<casillas.getCeldas().length-1 && !resultado;i++) {
				for(j=0; j<casillas.getCeldas().length-1 && !resultado;j++)
					if(casillas.getValorCelda(i).equals(casillas.getValorCelda(j)))
						resultado = true;
			}
		}
		return resultado;
		}
	
	//Metodo para introducir la combinación secreta dependiendo del tipo de juego // Implementado modo fácil.

	//Metodo para introducir las repsuestas
	
	public void introducirRespuestas(Jugador jugador) {
		int rojos=0, blancos=0, longitud = super.getTablero().getCombinacion().getCeldas().length;
		boolean comparacion;
		
		for(int i=0; i< longitud;i++)
			for(int j=0; j<longitud; j++) {
				comparacion = jugador.getTablero().getcombSecreta().getValorCelda(i).equals(jugador.getTablero().getCombinacion().getValorCelda(j));
				if(comparacion && i==j)
					rojos++;
				else
					if(comparacion)
						blancos++;
			}
		
		jugador.getTablero().getCombinacion().setRespuesta(rojos, blancos);
	}
	//Metodo para intentar adivinar la combinación secreta dependiendo del tipo de juego
	
	
	
	
	
	

}
