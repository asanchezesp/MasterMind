import java.util.ArrayList;

import Teclado.Teclado; 

public class Menu {

	public static void main(String[] args) {
		
		ArrayList<Partida> partidas = new ArrayList<>();
		final int FACIL=1, MEDIO=2, DIFICIL=3, SALIR = -1;
		String menu1 = "Bienvenido a Master Mind\nPor favor, eliga un modo de juego: \n\t1.- Fácil\n\t2.- Medio\n\t3.- Difícil";
		int opcion;
		boolean finalizar = false;
		
		do {
			System.out.println(menu1);
			opcion = Teclado.numeroEntreLimites(1, 3, Teclado.Limite.BOTH_IN, Teclado.TipoNumero.INT);
			partidas.add(new Partida(opcion));
			partidas.get(partidas.size()-1).comenzarPartida();
			finalizar = Teclado.boolMenu("¿Jugar de nuevo?", "Si", "Salir");
		}while(finalizar);
		
		Teclado.Close();
		System.out.println("\nNúmero de partidas jugadas: " + partidas.size());
	}

}
