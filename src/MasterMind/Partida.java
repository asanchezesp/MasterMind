package MasterMind;

import Teclado.Teclado;

/**
 * Esta clase, será la responsable de llamar a los métodos necesarios para la partida dependiendo del modo de juego
 * @author Alejandro Sánchez
 * @version 1.0
 * @since 1.0
 *
 */
public class Partida {
	
	/**
	 * Tipo de modo de juego que será elegido por el usuario
	 */
	final int FACIL=1, MEDIO=2, DIFICIL=3;
	/**
	 * Modo de juego genaro por la elección del usuario
	 */
	private ModoJuego modo;
	int opcion, jugadorModoFacil, contador_dificil=0;
	/**
	 * Jugadores que jugarán la partida. Dependiendo del modo de juego serán usuario o máquina
	 * @see Usuario
	 * @see Maquina
	 */
	private Jugador jugador1, jugador2;
	
	/**
	 * Genera la partida con la opción del usuario
	 * @param opcion Opcion de modo de juego que será pedida al usuario
	 */
	public Partida(int opcion) {
		this.opcion = opcion;
	}
	
	/**
	 * Comienza la partida dependiendo del modo de juego introducido y no se terminará hasta que uno de los jugadores gane
	 */
	public void comenzarPartida() {
		boolean fin_partida = false;
		String mensaje_fin = "Fin de la partida, el ganador es el jugador ";
		
		switch(opcion) {
			case FACIL:
				jugadorModoFacil = (Teclado.boolMenu("Elija quien será el jugador", "Usuario", "Máquina")?1:2); //Si es 1 el jugador será el usuario, si no será la máquina
				modo = new ModoJuego(opcion); // Inicializa valores para el modo fácil
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
				modo = new ModoJuego(opcion); // Inicializa valores para el modo medio
				jugador1 = new Usuario(modo);
				jugador2 = new Maquina(modo);
				
				//1.La máquina introduce la combinación secreta del usuario
				jugador1.getTablero().setCombinacionSecreta(((Maquina)jugador2).introducirCombSecreta());
				//2.El usuario introduce la combinación secreta de la máquina
				Colores.ensenharColores(jugador1.getTablero().getNumColores());
				System.out.println("Introduzca la combinación secreta para la máquina elegiendo entre los colores disponibles usando los números del 1 al 8:");
				((Usuario)jugador1).introducirCombSecreta(jugador2);
				System.out.println("Va a comenzar la partida:\n");
				
				for(int i=1; i<=jugador1.getTablero().getIntentos() && !fin_partida ;i++) {
					//3.Inicializo las combinaciones a introducir
					jugador1.getTablero().nuevaCombinacion();
					jugador2.getTablero().nuevaCombinacion();
					//4.El usuario y la máquina introducen la combinación
					Colores.ensenharColores(jugador1.getTablero().getNumColores());
					System.out.println("\n\nIntroduzca la secuencia de colores usando los colores disponibles usando los números del 1 al 8 para tu tablero");
					((Usuario)jugador1).introducirCasillas();
					((Maquina)jugador2).introducirCombinacion();
					//5.El usuario y la máquina colocan las respuestas
					System.out.println("La combinación de la máquina es:");
					jugador2.getTablero().getCombinacion().dibujar();
					((Usuario)jugador1).introducirRespuesta(jugador2);
					((Maquina)jugador2).introducirRespuestas(jugador1);
					//6.Añado las combinaciones a sus respectivas listas
					jugador1.getTablero().colocarCombinacionLista(jugador1.getTablero().getCombinacion());
					jugador2.getTablero().colocarCombinacionLista(jugador2.getTablero().getCombinacion());
					//7.Dibujo los tableros
					System.out.println("Tablero de la máquina: ");
					jugador2.getTablero().dibujar(i);
					System.out.println("\nTablero del usuario: ");
					jugador1.getTablero().dibujar(i);
					
					//8.Compruebo las combinaciones
					if(jugador1.getTablero().compararCombinaciones() ||jugador2.getTablero().compararCombinaciones())
						fin_partida = true;
					
					System.out.println("\n");
				}
				
				if(jugador1.getTablero().compararCombinaciones())
					System.out.println(mensaje_fin + "1");
				else 
					if(jugador2.getTablero().compararCombinaciones())
						System.out.println(mensaje_fin + "1");
				else
					System.out.println("Fin de la partida, el resultado es de empate");

			break;
			
			case DIFICIL:
				modo = new ModoJuego(opcion); // Inicializa valores para el modo medio
				jugador1 = new Maquina(modo);
				jugador2 = new Maquina(modo);
				
				//Introduzco las combinaciones secretas de las máquinas
				jugador1.getTablero().setCombinacionSecreta(((Maquina)jugador2).introducirCombSecreta());
				jugador2.getTablero().setCombinacionSecreta(((Maquina)jugador1).introducirCombSecreta());
				
				while(!fin_partida) {
					contador_dificil++;
					//1.Inicializo las combinaciones a introducir 
					jugador1.getTablero().nuevaCombinacion();
					jugador2.getTablero().nuevaCombinacion();
					//2.Las máquinas introducen sus combinaciones
					((Maquina)jugador1).introducirCombinacion();
					((Maquina)jugador2).introducirCombinacion();
					//3.Las máquinas introducen la respuesta
					((Maquina)jugador2).introducirRespuestas(jugador1);
					((Maquina)jugador1).introducirRespuestas(jugador2);
					//4.Añado las combinaciones a las listas
					jugador1.getTablero().colocarCombinacionLista(jugador1.getTablero().getCombinacion());
					jugador2.getTablero().colocarCombinacionLista(jugador2.getTablero().getCombinacion());
					//5.Muestro los tableros de las máquinas
					System.out.println("\nMovimiento nº: " + contador_dificil + "\n-------------------------------------------------------");
					System.out.println("Tablero de la máquina 1");
					jugador1.getTablero().dibujar(0);
					System.out.println("\nTablero de la máquina 2");
					jugador1.getTablero().dibujar(0);
					
					//6.Compruebo las combinaciones
					if(jugador1.getTablero().compararCombinaciones() ||jugador2.getTablero().compararCombinaciones())
						fin_partida = true;
					
					try{ 
						Thread.sleep(3000); 
						} catch(InterruptedException e) {
							System.out.println();
						}
				}
				
				if(jugador1.getTablero().compararCombinaciones())
					System.out.println(mensaje_fin + "1");
				else 
					if(jugador2.getTablero().compararCombinaciones())
						System.out.println(mensaje_fin + "1");
			break;
}

}



}
