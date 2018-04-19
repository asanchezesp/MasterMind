import Teclado.Teclado;

public class Usuario extends Jugador {

	public Usuario(ModoJuego modo) {
		super(modo);
	}
	
	public void introducirCasillas() {
		boolean resultado;
		
		for(int i=0; i<getTablero().getResultado().getCeldas().length;i++) {
			resultado = false;
				
			while(!resultado) {
				getTablero().getResultado().setCeldas(getColores().elegirColor(Teclado.cadena()), i);
			
				if(getTablero().getResultado().getValorCelda(i).equals(null))
					System.out.println("Error, color no disponible, introduzca otro color: ");
				else 
					resultado = true;
				}
			}
		
	//Metodo para introducir los aciertos
	// Metodo para introducir la combinación secreta
	
	
	
	}
	
	
	
	
	

}
