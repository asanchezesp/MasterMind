
public class Jugador {
	private Tablero tablero;
	private Colores color = new Colores();
	//private ArrayList<CombinacionRespuesta> combinaciones_respuestas = new ArrayList<>(); 
	public Jugador(ModoJuego modo) {
		tablero = new Tablero(modo);
	}
	
	public Colores getColores() {
		return color;
	}
	
	public Tablero getTablero() {
		return tablero;
	}
	

	
}
