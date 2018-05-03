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
					
					//1.La máquina introduce la combinación secreta
					jugador1.getTablero().setCombinacionSecreta(((Maquina)jugador2).introducirCombSecreta());

					for(int i=1; i<=jugador1.getTablero().getIntentos() && !fin_partida ;i++) {
						//2.Enseño colores disponibles
						Colores.ensenharColores(jugador1.getTablero().getNumColores());
						//3.El usuario introduce los colores en la combinación
						System.out.println("\n\nIntroduzca la secuencia de colores usando los colores disponibles usando los números ");
						jugador1.getTablero().nuevaCombinacion();
						((Usuario)jugador1).introducirCasillas();
						//4.La máquina comprueba los colores acertados y coloca las respuestas
						((Maquina)jugador2).introducirRespuestas(jugador1);
						//5.Añado la combinación a la lista de combinaciones
						jugador1.getTablero().colocarCombinacionLista(jugador1.getTablero().getCombinacion());
						//6.Imprimo el tablero
						jugador1.getTablero().dibujar(i);
						
						//7.Compruebo si el jugador a acertado la combinación
						if(jugador1.getTablero().getCombinacion().getCeldas().equals(jugador1.getTablero().getcombSecreta()))
							fin_partida = true;
						System.out.println();
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
