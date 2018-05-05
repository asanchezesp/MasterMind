import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Maquina extends Jugador {
	
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
		posicion = rnd.nextInt(combinacion.getCeldas().length) +1;
		combinacion.colocarCeldas(Colores.elegirColor(colores_disp.get(posicion)), i);
		colores_disp.remove(posicion);
		}

		
		return combinacion;
		
	}
	
	//Metodo para introducir la combinación secreta dependiendo del tipo de juego // Implementado modo fácil.
	
	public void introducirCombinacion() {
		ArrayList<String> colores_disp = new ArrayList<>(Arrays. asList(colores));
		int eleccion, longitud = getTablero().getCombinacion().getCeldas().length;
		
		if(!getTablero().isRepeticion()) {
			for(int i=0; i<longitud;i++) {
				eleccion = rnd.nextInt(longitud) +1;
				getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(colores_disp.get(eleccion)), i);
				colores_disp.remove(eleccion);
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
