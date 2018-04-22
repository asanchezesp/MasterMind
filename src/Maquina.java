import java.util.HashMap;
import java.util.Random;

public class Maquina extends Jugador {
	
	//private HashMap<Combinacion,Integer> combinaciones = new HashMap<>(); // La clave es la combinación y el valor la respuesta
	private String colores[] = {"negro","rojo","verde","amarillo","azul","morado","celeste","verde claro","celeste oscuro","turquesa"};
	private Random rnd = new Random();

	public Maquina(ModoJuego modo) {
		super(modo);
		
	}
	
	public Combinacion introducirCombSecreta(){
		Combinacion combinacion = new Combinacion(super.getTablero().getCombinacion().getCeldas().length);
		

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
		
		for(int i=0; i< longitud;i++)
			for(int j=0; j<longitud; j++)
				if(super.getTablero().getCombinacion().getValorCelda(i).equals(super.getTablero().getcombSecreta().getValorCelda(j)) && i==j)
					rojos++;
				else
					if(super.getTablero().getCombinacion().getValorCelda(j).equals(super.getTablero().getcombSecreta().getValorCelda(j)))
						blancos++;
		
		jugador.getTablero().getCombinacion().setNumAcertados(rojos, blancos);
	}
	//Metodo para intentar adivinar la combinación secreta dependiendo del tipo de juego
	
	
	
	
	
	

}
