/**
 *  Esta clase almacenará el color introducido por el jugador
 * @author Alejandro sánchez
 * @version 1.0
 * @since 1.0
 *
 */
public class Casilla {

	private String color;
	
	public Casilla(String color) {
		this.color = color;
	}
	
	public String toString() {
		return color;
	}
	
	
	public boolean equals(Object obj) {
		boolean resultado = false;
		if(obj instanceof Casilla && color.equals(((Casilla)obj).color))
			resultado = true;
		
			return resultado;
	}
	
}
