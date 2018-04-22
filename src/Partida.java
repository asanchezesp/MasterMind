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
				jugadorModoFacil = (Teclado.boolMenu("Elija quien será el jugador", "Usuario", "Máquina")?1:2); //Si es 1 el jugador será el usuario, si no será la máquina
				modo = new ModoJuego(opcion1); // Inicializa valores para el modo fácil
				jugador1 = new Usuario(modo);
				jugador2 = new Maquina(modo);
			
				// Si es el usuario quien juega 
				if(jugadorModoFacil == 1) {
					
					//jugador1.getColores(); ¿?
					//1.La máquina introduce la combinación secreta
					jugador1.getTablero().setCombinacionSecreta(((Maquina)jugador2).introducirCombSecreta());
					//2.Enseño colores disponibles
					Colores.ensenharColores(jugador1.getTablero().getNumColores());
					//3.El usuario introduce los colores en la combinación
					for(int i=1; i<=jugador1.getTablero().getIntentos() && !fin_partida ;i++) {
						System.out.println("\n\nIntroduzca la secuencia de colores usando los colores disponibles:\n");
						((Usuario)jugador1).introducirCasillas();
						//Añadir Comprobación de la combinación y la colocación de la respuesta (Lo hace la máquina)
						((Maquina)jugador2).introducirRespuestas(jugador1);
						//Añado la combinación a la lista de combinaciones
						jugador1.getTablero().setCombinacionLista(jugador1.getTablero().getCombinacion(), i);
						//Imprimo el tablero
						jugador1.getTablero().dibujar(i);
						
						//Compruebo si el jugador a acertado la combinación
						if(jugador1.getTablero().getCombinacion().getCeldas().equals(jugador1.getTablero().getcombSecreta()))
							fin_partida = true;
					}
					//Saco el mensaje de fin de partida con el ganador
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
