
public class Jugador {
	private Tablero tablero;
	protected Colores color = new Colores();
	protected ModoJuego modo;
	protected String colores[] = {"negro","rojo","verde","amarillo","azul","morado","celeste","verde claro","celeste oscuro","turquesa"};
	
	public Jugador(ModoJuego modo) {
		tablero = new Tablero(modo);
		this.modo = modo;
	}
	
	public Colores getColores() {
		return color;
	}
	
	public Tablero getTablero() {
		return tablero;
	}
	
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
			tablero.getCombinacion().setRespuesta(rojos, blancos);
		else 
			resultado = false;
			
				
		return resultado;
	}
	
	public boolean isRepetido(Combinacion casillas) {
		boolean resultado = false;
		int i,j;
		
		for(i=0; i<casillas.getCeldas().length-1 && !resultado;i++) 
			for(j=i+1; j<casillas.getCeldas().length-1 && !resultado;j++)
				if(casillas.getValorCelda(i).equals(casillas.getValorCelda(j)))
					resultado = true;
		
		return resultado;
	}
	
	
	

	
}
