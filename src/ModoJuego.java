
public class ModoJuego {
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
