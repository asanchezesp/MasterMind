package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import MasterMind.Colores;
import MasterMind.Combinacion;
import MasterMind.CombinacionRespuesta;
import MasterMind.Jugador;
import MasterMind.ModoJuego;
import MasterMind.Jugador;


@DisplayName("Test de JUnit para probar las respuestas")
class PruebasMasterMind {
	
	ModoJuego modoFacil,modoMedio;
	
	Jugador jugadorFacil = new Jugador(modoFacil = new ModoJuego(1));
	Jugador jugadorMedio = new Jugador(modoMedio = new ModoJuego(2));
	
	//Función para añadirle una combinación secreta para probar
	Combinacion colocarCombSecreta(int longitud) {
		Combinacion secreta = new Combinacion(longitud);
		String colores[] = {"negro","rojo","verde","amarillo","azul","morado","celeste","verde claro","celeste oscuro","turquesa"};
		
		for(int i=0; i<longitud;i++)
			secreta.colocarCeldas(Colores.elegirColor(colores[i]), i);
		
		return secreta;
	}
	
	
	//Pruebas de modo fácil
	/*void colocarCombinacionFacil() {
		//La combinación secreta en modo fácil será {"negro","rojo","verde","amarillo"}
		String combinacion1[] = {"negro","azul","morado","celeste"};
		String combinacion2[] = {"azul","negro","morado","celeste"};
		//Introduzco una combianción secreta para añadirle 
		for(int i=0; i< combinacion1.length;i++)
			combinacionFacil.colocarCeldas(Colores.elegirColor(combinacion1[i]),i);
	}*/
	
	@Test
	@DisplayName("Prueba '1 rojo 0 blancos' y '0 rojos 1 blanco' en modo fácil")
	void colocarRespuestaFacil() {
		String combinacion1[] = {"negro","azul","morado","celeste"};
		String combinacion2[] = {"azul","negro","morado","celeste"};
		jugadorFacil.getTablero().setCombinacionSecreta(colocarCombSecreta(combinacion1.length));
		
		for(int i=0; i< combinacion1.length;i++)
			jugadorFacil.getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(combinacion1[i]),i);
		assertTrue(jugadorFacil.compararAcertados(1, 0)); // Prueba de 1 rojo 0 blancos
			
		for(int i=0; i< combinacion1.length;i++)
			jugadorFacil.getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(combinacion2[i]),i);
		assertTrue(jugadorFacil.compararAcertados(0, 1)); //Prueba de 0 rojos 1 blanco
		
	}
	
	@Test
	@DisplayName("Prueba '4 rojo 0 blancos' y '2 rojos 3 blancos' en modo medio")
	void colocarRespuestaMedio() {
		String combinacion1[] = {"negro","rojo","verde","amarillo","verde claro"};
		String combinacion2[] = {"negro","verde","amarillo","rojo","azul"};
		jugadorMedio.getTablero().setCombinacionSecreta(colocarCombSecreta(combinacion1.length));
		
		for(int i=0; i< combinacion1.length;i++)
			jugadorMedio.getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(combinacion1[i]),i);
		assertTrue(jugadorMedio.compararAcertados(4, 0)); // Prueba de 1 rojo 0 blancos
			
		for(int i=0; i< combinacion1.length;i++)
			jugadorMedio.getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(combinacion2[i]),i);
		assertTrue(jugadorMedio.compararAcertados(2, 3)); //Prueba de 0 rojos 1 blanco
		
	}

}
