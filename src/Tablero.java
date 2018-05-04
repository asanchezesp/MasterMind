import java.util.ArrayList;
import java.util.Arrays;

public class Tablero implements Dibujable2{
	private ModoJuego modo;
	private ArrayList<CombinacionRespuesta> combinaciones_respuestas = new ArrayList<>(); 
	private int numIntentos, numColores;
	private boolean repeticion;
	private CombinacionRespuesta casillas;
	private Combinacion combSecreta;
	private Casilla[] celdas;
	
	public Tablero(ModoJuego modo) {
		this.modo = modo;
		setModo(modo);
	}
	
	public CombinacionRespuesta getCombinacion() {
		return casillas;
	}
	
	public int getIntentos() {
		return numIntentos;
	}	
	
	public Combinacion getcombSecreta() {
		return combSecreta;
	}
	
	public int getNumColores() {
		return numColores;
	}
	
	public void setCombinacionSecreta(Combinacion combSecreta) {
		this.combSecreta = combSecreta;
	}
	
	public void colocarCombinacionLista(CombinacionRespuesta combinacion) {

		combinaciones_respuestas.add(combinacion);

	}
	
	public ArrayList<CombinacionRespuesta> getCombinaciones(){
		return combinaciones_respuestas;
	}
	
	public void nuevaCombinacion() {
		casillas = new CombinacionRespuesta(modo.getDificultad().getNumCasillas());
	}
	
	public boolean compararCombinaciones() {
		Casilla combinacionUsuario[] = casillas.getCeldas();
		Casilla combinacionSecreta[] = combSecreta.getCeldas();
		return Arrays.equals(combinacionUsuario, combinacionSecreta);
	}
	
	public void setModo(ModoJuego modo) {
	
		numIntentos = modo.getDificultad().getNumIntentos();
		repeticion = modo.getDificultad().isRepeticion();
		casillas = new CombinacionRespuesta(modo.getDificultad().getNumCasillas());
		combSecreta = new Combinacion(modo.getDificultad().getNumCasillas());
		numColores = modo.getDificultad().getNumColores();

	}

	public void dibujar(int intentos_restantes) {
		
		for(int i=combinaciones_respuestas.size()-1; i>=0;i--) {
			System.out.println();
			if(i+1==10)
				System.out.print(i+1 + "| ");
			else
				System.out.print(i+1 + " | ");
			combinaciones_respuestas.get(i).dibujar();
			if(i==0)
				System.out.print("Intentos restantes: " + (numIntentos-intentos_restantes) + "\n");
		}
	}
	

	
}
