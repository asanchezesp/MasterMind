
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
		boolean resultado = true;
		int rojos=0, blancos=0;
		
		for(int i=0; i< tablero.getCombinacion().getCeldas().length; i++)
			for(int j=0; j<tablero.getCombinacion().getCeldas().length; j++)
				if(tablero.getCombinacion().getValorCelda(i).equals(tablero.getcombSecreta().getValorCelda(j)) && i==j)
					rojos++;
				else
					if(tablero.getCombinacion().getValorCelda(j).equals(tablero.getcombSecreta().getValorCelda(j)))
						blancos++;
		
		if((rojos-blancos)==(adivinados_pos-adivinados))
			tablero.getCombinacion().setRespuesta(rojos, blancos);
		else 
			resultado = false;
			
				
		return resultado;
	}
	
	
	

	
}
