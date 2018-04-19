import Teclado.Teclado;

public class Partida {
	
	final int FACIL=1, MEDIO=2, DIFICIL=3, SALIR = -1;
	private ModoJuego modo;
	int opcion1, jugadorModoFacil;
	private Jugador jugador1, jugador2;
	
	
	public Partida(int opcion1) {
		this.opcion1 = opcion1;
	}
	
	public void comenzarPartida() {
		boolean fin_partida = false;
		String mensaje_fin = "Fin de la partida, el ganador es el jugador ";
		
		switch(opcion1) {
			case FACIL:
				jugadorModoFacil = (Teclado.boolMenu("Elija quien será el jugador: ", "Usuario", "Máquina")?1:2); //Si es 1 el jugador será el usuario, si no será la máquina
				modo = new ModoJuego(opcion1); // Inicializa valores para el modo fácil
				jugador1 = new Usuario(modo);
				jugador2 = new Maquina(modo);
			
				if(jugadorModoFacil == 1) {
					
					jugador1.getColores();
					//jugador1.setCombinacionSecreta(Función de la máquina que coloque la combinación);
					Colores.ensenharColores(jugador1.getTablero().getNumColores());
					for(int i=1; i<=jugador1.getTablero().getIntentos() && !fin_partida ;i++) {
						System.out.println("\n\nIntroduzca la secuencia de colores usando los colores disponibles:\n");
						((Usuario)jugador1).introducirCasillas();
						// Comprobación de la combinación y la colocación de la respuesta (Lo hace la máquina)
						jugador1.getTablero().setCombinacionLista(jugador1.getTablero().getResultado(), i);
						jugador1.getTablero().dibujar(i);
						
						if(jugador1.getTablero().getResultado().getCeldas().equals(jugador1.getTablero().getcombSecreta()))
							fin_partida = true;
					}
					
					if(fin_partida)
						System.out.println(mensaje_fin + "1");
					else 
						System.out.println(mensaje_fin + "2");
				}
				break;
		
			case MEDIO:
			
}

}


}
