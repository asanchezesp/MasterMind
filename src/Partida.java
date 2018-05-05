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
						if(jugador1.getTablero().compararCombinaciones())
							fin_partida = true;
						System.out.println();
					}
					//Saco el mensaje de fin de partida con el ganador
					if(fin_partida)
						System.out.println(mensaje_fin + "1");
					else {
						System.out.println(mensaje_fin + "2");
					}
				}
				else { // Si es la máquina quien juega: 
					
					//1.Enseño los colores disponibles
					Colores.ensenharColores(jugador1.getTablero().getNumColores());
					System.out.println("Introduzca la combinación secreta para la máquina elegiendo entre los colores disponibles usando los números del 1 al 8:");
					
					for(int i=1; i<=jugador1.getTablero().getIntentos() && !fin_partida ;i++) {
						//2.Pido la combinacion secreta al jugador y la introduzco en el tablero de la máquina
						((Usuario)jugador1).introducirCombSecreta(jugador2);
						//3. La máquina genera una combinación
						jugador2.getTablero().nuevaCombinacion();
						((Maquina)jugador2).introducirCombinacion();
						//4. Muestro la combinación de la máquina al usuario y le pregunto cuantos ha acertado correctamente y los que ha acertado fallando la posición
						System.out.println("La combinación de la máquina es:");
						jugador2.getTablero().getCombinacion().dibujar();
						((Usuario)jugador1).introducirRespuesta(jugador2);
						//5. Añado la combinación a la lista y muestro el tablero
						jugador2.getTablero().colocarCombinacionLista(jugador2.getTablero().getCombinacion());
						jugador2.getTablero().dibujar(i);
						System.out.println();
						//6. Compruebo si ha acertado correctamente la combinación
						if(jugador2.getTablero().compararCombinaciones())
							fin_partida = true;
					}
					if(fin_partida)
						System.out.println(mensaje_fin + "2");
					else {
						System.out.println(mensaje_fin + "1");
					}
				}
				break;
		
			case MEDIO:
			
}

}



}
