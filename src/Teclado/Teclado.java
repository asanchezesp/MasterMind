package Teclado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {
	
	static Scanner teclado = new Scanner(System.in);
	
	static public void Close() {
		
		teclado.close();
	}
	
	static public char caracter() {
		
		char caracter = 0;

		caracter = teclado.next().charAt(0);

		return caracter;
	}
	
	static public String cadena() {
		String cadena;
		
		do {
			cadena = teclado.nextLine();
			if(cadena.length()==0)
				System.out.print("Cadena vacía, introducir cadena: ");
			
		}while(cadena.length()==0);

		return cadena;
		
	}
	
	public static boolean boolMenu(String mensaje1, String mensaje2, String mensaje3) {
		final int OPCION_UNO=1, OPCION_DOS=2;
		int opcion=0;
		boolean isopcion = false;
		
		System.out.printf("%s:\n\t1.-%s\n\t2.-%s\n",mensaje1,mensaje2,mensaje3);
		
		do {
			try {
				opcion = teclado.nextInt();
				if(opcion != OPCION_UNO && opcion != OPCION_DOS){
					System.out.print("Error,valor no válido\n");
					isopcion = false;
				}
				else 
					isopcion = true;
				
			}catch(InputMismatchException e) {
				teclado.nextLine();
				System.out.print("Error,valor no válido\n");
			}
		}while(!isopcion);
		
		teclado.nextLine();
		return (opcion == OPCION_UNO);

		
	}
	
	static public boolean pregunta(String pregunta) {
		final char SI='s', NO='n';
		char respuesta=0;
		boolean isrespuesta = false;
		
		System.out.printf("%s\nSI ---> s\t NO ---> n\n",pregunta);
		
		while(!isrespuesta) {
			
			try {
				respuesta = teclado.nextLine().toLowerCase().charAt(0);
				
				if(respuesta != SI && respuesta != NO) {
					System.out.print("Error,valor no válido\n");
					isrespuesta = false;
				}
					
				else isrespuesta = true;
				
			}catch(InputMismatchException e) {
				teclado.nextLine();
				System.out.print("Error, valor no válido\n");
			}
			
		}
		
		return (respuesta == SI);
	}
	
	static public enum TipoNumero{
		BYTE, INT, FLOAT, SHORT, DOUBLE, LONG;
	}
	
	@SuppressWarnings("unchecked")
	static public <T> T numero(TipoNumero tipo){
		T numero = null;
		boolean isnumero=false;
		
		while(!isnumero){
			try{
				switch(tipo) {
					case BYTE: 
						numero =  (T) Byte.valueOf(teclado.nextByte());
					break;
					
					case INT:
						numero = (T) Integer.valueOf(teclado.nextInt());
					break;
					
					case FLOAT:
						numero = (T) Float.valueOf(teclado.nextFloat());
					break;
					
					case SHORT:
						numero = (T) Short.valueOf(teclado.nextShort());
					break;
					
					case DOUBLE:
						numero = (T) Double.valueOf(teclado.nextDouble());
					break;
					
					case LONG:
						numero = (T) Long.valueOf(teclado.nextLong());
					break;
				}
				
			}catch(InputMismatchException e){
				System.out.print("Error, valor no válido\n");
			}finally{
				teclado.nextLine();
			}
			isnumero=true;
		}
		
		return numero;
	}

	
	static public enum Operador {
		MAYORIGUAL, MENORIGUAL, MAYOR, MENOR, IGUAL	;
	}
	
	static public <T> T igualacionNumeros(T limite, Operador operador, TipoNumero tipo){
		T numero;
		int resultado = 0;
		boolean condicion=false;
		
		numero = numero(tipo);
		
		do{
			switch(tipo) {
				case BYTE:  
					resultado = Byte.compare((byte)numero, (byte)limite);
					//resultado = ((Byte) numero).compareTo((Byte) limite);
				break;
			
				case INT:
					resultado = Integer.compare((int)numero, (int)limite);
				break;
			
				case FLOAT:
					resultado = Float.compare((float)numero, (float)limite);
				break;
			
				case SHORT:
					resultado = Short.compare((short)numero, (short)limite);
				break;
			
				case DOUBLE:
					resultado = Double.compare((double)numero, (double)limite);
				break;
			
				case LONG:
					resultado =	Long.compare((long)numero, (long)limite);
				break;
			}
			switch(operador){
			
				case IGUAL:
					condicion=(resultado==0)?true:false;
				
				case MAYOR:
					condicion=(resultado>0)?true:false;
				break;
				
				case MENOR:
					condicion=(resultado<0)?true:false;
				break;
			}
			
			if(!condicion)
				System.out.print("Error, condición no verdadera\n");
			
		}while(!condicion);
		
		return numero;
		
	}
	
	static public enum Limite {
		BOTH_IN, BOTH_OUT, ONLY_MIN, ONLY_MAX;
	}
	
	static public <T> T numeroEntreLimites(T limite_menor, T limite_mayor, Limite limite, TipoNumero tipo){
		
		T numero;
		int resultado = 0;
		boolean dentro=true;

		/*if(limite_menor > limite_mayor){
			throw new IllegalArgumentException("Error, rango menor mayor que el rango mayor\n");
		}*/
		
		do{
			numero = numero(tipo);
			
			switch(tipo) {
			case BYTE:  
				resultado = Byte.compare((byte)numero, (byte)limite_menor);
				resultado += Byte.compare((byte)numero, (byte)limite_mayor);
			break;
		
			case INT:
				resultado = Integer.compare((int)numero, (int)limite_menor);
				resultado += Integer.compare((int)numero, (int)limite_mayor);
			break;
		
			case FLOAT:
				resultado = Float.compare((float)numero, (float)limite_menor);
				resultado += Float.compare((float)numero, (float)limite_mayor);
			break;
		
			case SHORT:
				resultado = Short.compare((short)numero, (short)limite_menor);
				resultado += Short.compare((short)numero, (short)limite_mayor);
			break;
		
			case DOUBLE:
				resultado = Double.compare((double)numero, (double)limite_menor);
				resultado += Double.compare((double)numero, (double)limite_mayor);
			break;
		
			case LONG:
				resultado =	Long.compare((long)numero, (long)limite_menor);
				resultado += Long.compare((long)numero, (long)limite_mayor);
			break;
		}
			
				switch(limite) {
		
					case BOTH_IN:
						dentro=(resultado>=-1 && resultado<=1);
					break;
			
					case BOTH_OUT:
						dentro=(resultado==0);
					break;
			
					case ONLY_MIN:
						dentro=(resultado==-1 || resultado==0);
					break;
			
					case ONLY_MAX:
						dentro=(resultado==0 || resultado==1);
					break;
				
				}
				if(!dentro) {
					System.out.println("Error, el valor no está dentro del rango\nIntroduzca otro valor: ");
				}
			
		}while(!dentro);
		
		return numero;
	}
	

	
}
