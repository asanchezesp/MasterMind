/**
 * Esta clase genera el modo de juego dependiendo de la elección del usuario
 * @author Alejandro Sánchez
 * @version 1.0
 * @since 1.0
 *
 */
public class ModoJuego {
	/**
	 * Cada modo de juego tiene su dificultad que será generada dependiendo del modo
	 * @see Dificultad
	 */
	private Dificultad dificultad;
	
	public ModoJuego(int modo) {
		switch (modo) {
			case 1:
				dificultad = Dificultad.FACIL;
			break;
			
			case 2:
				dificultad = Dificultad.MEDIO;
			break;
			
			case 3:
				dificultad = Dificultad.DIFICIL;
			break;
		}
	}
	
	public Dificultad getDificultad() {
		return dificultad;
	}

}
