import java.util.ArrayList;

public class Tablero implements Dibujable2{
	private ArrayList<CombinacionRespuesta> combinaciones_respuestas = new ArrayList<>(); 
	private int numIntentos, numColores;
	private boolean repeticion;
	private CombinacionRespuesta casillas;
	private Combinacion combSecreta; //La combinación secreta que se guardará será la del adversario
	
	public Tablero(ModoJuego modo) {
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
	
	public void setCombinacionLista(CombinacionRespuesta combinacion,int pocicion) {

		combinaciones_respuestas.add(combinacion);
	}
	
	public ArrayList<CombinacionRespuesta> getCombinaciones(){
		return combinaciones_respuestas;
	}
	
	public void setModo(ModoJuego modo) {
	
		numIntentos = modo.getDificultad().getNumIntentos();
		repeticion = modo.getDificultad().isRepeticion();
		casillas = new CombinacionRespuesta(modo.getDificultad().getNumCasillas());
		combSecreta = new Combinacion(modo.getDificultad().getNumCasillas());
		numColores = modo.getDificultad().getNumColores();

	}
	
	public boolean isRepetido() {
		boolean resultado = false;
		int i,j;
		
		while(!resultado) {
			for(i=0; i<casillas.getCeldas().length-1 && !resultado;i++) {
				j = i+1;
				
				if(casillas.getValorCelda(i).equals(casillas.getValorCelda(j)))
					resultado = true;
			}
		}
		return resultado;
		}

	public void dibujar(int intentos_restantes) {
		
		for(int i=1; i<=combinaciones_respuestas.size();i++) {
			System.out.print(i + "| ");
			combinaciones_respuestas.get(i-1).dibujar();
			if(i==1)
				System.out.print("  Intentos restantes: " + (numIntentos-intentos_restantes));
		}
	}
	

	
}
