
public enum Dificultad {
	FACIL(10,false,4,8), MEDIO(15,false,5,8), DIFICIL(-1,true,8,10);
	
	private int eleccion, numIntentos, numCasillas, numColores;
	private boolean repeticion;
	
	
	Dificultad(int numIntentos,boolean repeticion, int numCasillas, int numColores) {
		this.numIntentos = numIntentos;
		this.numCasillas = numCasillas;
		this.numColores = numColores;
		this.repeticion = repeticion;
	}

	public int getDificultad() {
		return eleccion;
	}

	public int getNumIntentos() {
		return numIntentos;
	}


	public int getNumCasillas() {
		return numCasillas;
	}


	public int getNumColores() {
		return numColores;
	}


	public boolean isRepeticion() {
		return repeticion;
	}

}
