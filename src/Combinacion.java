

public class Combinacion implements Dibujable{
	private Casilla celdas[];
	
	public Combinacion(int tamanio) {
		celdas = new Casilla[tamanio];
	}

	public Casilla[] getCeldas() {
		return celdas;
	}
	
	public Casilla getValorCelda(int posicion) {
		return celdas[posicion];
	}
	
	public void colocarCeldas(String valor,int posicion) {
		celdas[posicion] = new Casilla(valor);
	}

	@Override
	public void dibujar() {
		
		for(int i=0;i<celdas.length;i++)
			System.out.printf("%s    %s ",celdas[i], Colores.RESET);
	}

}
