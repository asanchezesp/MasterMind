import Teclado.Teclado;

public class Usuario extends Jugador {

	public Usuario(ModoJuego modo) {
		super(modo);
	}
	
	public void introducirCasillas() {
		int eleccion;
		
		for(int i=0; i<getTablero().getCombinacion().getCeldas().length;i++) {

			eleccion = Teclado.numeroEntreLimites(1, 8, Teclado.Limite.BOTH_IN, Teclado.TipoNumero.INT)-1;
			super.getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(colores[eleccion]), i);
	
		}
	}	
	//Metodo para introducir los aciertos
	// Metodo para introducir la combinación secreta
	
	
}
