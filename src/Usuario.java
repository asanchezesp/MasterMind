import Teclado.Teclado;

public class Usuario extends Jugador {

	public Usuario(ModoJuego modo) {
		super(modo);
	}
	
	public void introducirCasillas() {
		int eleccion;
		
		for(int i=0; i<getTablero().getCombinacion().getCeldas().length;i++) {

			eleccion = Teclado.numeroEntreLimites(1, getTablero().getNumColores(), Teclado.Limite.BOTH_IN, Teclado.TipoNumero.INT)-1;
			super.getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(colores[eleccion]), i);
	
		}
	}
	
	public void introducirCombSecreta(Jugador jugador) {
		int longitud, eleccion;
		boolean resultado;
		longitud = jugador.getTablero().getcombSecreta().getCeldas().length;
		Combinacion combinacion = new Combinacion(longitud);
		
		do {
			for(int i=0; i<getTablero().getCombinacion().getCeldas().length;i++) {

				eleccion = Teclado.numeroEntreLimites(1, getTablero().getNumColores(), Teclado.Limite.BOTH_IN, Teclado.TipoNumero.INT)-1;
				combinacion.colocarCeldas(Colores.elegirColor(colores[eleccion]), i);
			}
			resultado = isRepetido(combinacion);
			if(resultado)
				System.out.println("Error, no puede haber colores repetidos, introduzca otra secuencia de colores: ");
			
		}while(resultado);
		
		jugador.getTablero().setCombinacionSecreta(combinacion);
	}
	//Metodo para introducir los aciertos
	
	public void introducirRespuesta(Jugador jugador) {
		int rojos, blancos;
		boolean resultado = true;
		
		do {
			System.out.print("Introduzca el número de colores acertados correctamente: ");
			rojos = Teclado.numero(Teclado.TipoNumero.INT);
			System.out.print("Introduzca el número de colores acertados que no están en sus casillas correctas: ");
			blancos = Teclado.numero(Teclado.TipoNumero.INT);
			
			if(rojos + blancos <= 0 || rojos + blancos > getTablero().getCombinacion().getCeldas().length) {
				resultado = false;
				System.out.println("Error, el número total de respuesta no corresponde con la cantidad de colores disponible");
			}
			
			if(!jugador.compararAcertados(rojos, blancos)) {
				System.out.println("Error, la respuesta no es correcta, por favor, introduzca la respuesta correcta sin hacer trampas: ");
				resultado = false;
			}
			
		}while(!resultado);
		
		jugador.getTablero().getCombinacion().setRespuesta(rojos, blancos);
		
	}
	
	// Metodo para introducir la combinación secreta
	
	
}
