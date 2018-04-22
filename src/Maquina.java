import java.util.HashMap;
import java.util.Random;

public class Maquina extends Jugador {
	
	//private HashMap<Combinacion,Integer> combinaciones = new HashMap<>(); // La clave es la combinación y el valor la respuesta
	private String colores[] = {"negro","rojo","verde","amarillo","azul","morado","celeste","GREEN","BLUE","CYAN"};

	public Maquina(ModoJuego modo) {
		super(modo);
		
	}
	
	public Combinacion introducirCombSecreta(){
		Random rnd = new Random();
		Combinacion combinacion = new Combinacion(super.getTablero().getCombinacion().getCeldas().length);
		
		//Hacer switch dependiendo del modo
		do {
			for(int i=0; i<combinacion.getCeldas().length-1;i++) {
				combinacion.setCeldas(colores[rnd.nextInt(combinacion.getCeldas().length)+1], i);
			}
		}while(isRepetido(combinacion));
		
		return combinacion;
		
	}
	
	public boolean isRepetido(Combinacion casillas) {
		boolean resultado = false;
		int i,j;
		
		while(!resultado) {
			for(i=0; i<casillas.getCeldas().length-1 && !resultado;i++) {
				for(j=0; i<casillas.getCeldas().length-1;j++)
					if(casillas.getValorCelda(i).equals(casillas.getValorCelda(j)))
						resultado = true;
			}
		}
		return resultado;
		}
	
	//Metodo para introducir la combinación secreta dependiendo del tipo de juego
	//Metodo para introducir las repsuestas
	//Metodo para intentar adivinar la combinación secreta dependiendo del tipo de juego
	
	
	
	
	
	

}
