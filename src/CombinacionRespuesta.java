import java.util.Arrays;

public class CombinacionRespuesta extends Combinacion implements Dibujable {
	private final char ROMBO = 9670;
	private String respuestas[];
	public int acertados, acertados_posicion;

	public CombinacionRespuesta(int tamanio) {
		super(tamanio);
		respuestas = new String[tamanio];
		Arrays.fill(respuestas, " ");
	}
	
	/*public void setNumAcertados(int acertados_posicion, int acertados) {
		this.acertados = acertados;
		this.acertados_posicion = acertados_posicion;
		setRespuesta();
	}*/
	
	public void setRespuesta(int acertados_posicion, int acertados) {
		this.acertados = acertados;
		this.acertados_posicion = acertados_posicion;
		
		for(int i=0;i<acertados_posicion;i++)
			respuestas[i] = String.format("%s", Colores.ROJO_ROMBO + ROMBO + Colores.RESET); // Acertados correctamente

		for(int i=acertados_posicion;i<acertados;i++)
			respuestas[i] = String.format("%s", Colores.CELESTE_ROMBO + ROMBO + Colores.RESET); //Solo colores acertados

	}
	
	public String[] getRespuestas() {
		return respuestas;
	}

	@Override
	public void dibujar() {
		for(int i=0; i<2; i++) {
			if(i==1)
				System.out.print(" | ");
			super.dibujar();
			System.out.print("|");
			if(i==0)
				for(int j = 0; j<respuestas.length/2; j++)
					System.out.printf("%s ", respuestas[j]);
			else
				for(int j = respuestas.length/2; j<respuestas.length; j++)
					System.out.printf("%s ", respuestas[j]);
			System.out.println();
		}
	}

}
