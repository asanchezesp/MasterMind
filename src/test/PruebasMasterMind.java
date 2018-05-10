package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import MasterMind.Colores;
import MasterMind.Combinacion;
import MasterMind.Jugador;
import MasterMind.Maquina;
import MasterMind.ModoJuego;


@DisplayName("Test de JUnit para probar las respuestas")
class PruebasMasterMind {
	
	ModoJuego modoFacil,modoMedio,modoDificil;
	
	Jugador jugadorFacil = new Jugador(modoFacil = new ModoJuego(1));
	Jugador jugadorMedio = new Jugador(modoMedio = new ModoJuego(2));
	Maquina jugadorDificil = new Maquina(modoMedio = new ModoJuego(3));
	
	//Función para añadirle una combinación secreta para probar
	Combinacion colocarCombSecreta(int longitud) {
		Combinacion secreta = new Combinacion(longitud);
		String colores[] = {"negro","rojo","verde","amarillo","azul","morado","celeste","verde claro","celeste oscuro","turquesa"};
		
		for(int i=0; i<longitud;i++)
			secreta.colocarCeldas(Colores.elegirColor(colores[i]), i);
		
		return secreta;
	}
	
	@Test
	@DisplayName("Prueba '1 rojo 0 blancos', '0 rojos 1 blanco' y '1 rojo 2 blancos' en modo fácil")
	void colocarRespuestaFacil() {
		String combinacion1[] = {"negro","azul","morado","celeste"};
		String combinacion2[] = {"azul","negro","morado","celeste"};
		String combinacion3[] = {"negro","verde","rojo","celeste}"};
		jugadorFacil.getTablero().setCombinacionSecreta(colocarCombSecreta(combinacion1.length));
		
		for(int i=0; i< combinacion1.length;i++)
			jugadorFacil.getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(combinacion1[i]),i);
		assertTrue(jugadorFacil.compararAcertados(1, 0)); // Prueba de 1 rojo 0 blancos
			
		for(int i=0; i< combinacion1.length;i++)
			jugadorFacil.getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(combinacion2[i]),i);
		assertTrue(jugadorFacil.compararAcertados(0, 1)); //Prueba de 0 rojos 1 blanco
		
		for(int i=0; i<combinacion1.length;i++)
			jugadorFacil.getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(combinacion3[i]),i);
		assertTrue(jugadorFacil.compararAcertados(1, 2)); //Prueba de 1 rojo 2 blancos
	}
	
	@Test
	@DisplayName("Prueba '4 rojos 0 blancos' y '0 rojos 3 blancos' y '2 rojos 2 blancos' en modo medio")
	void colocarRespuestaMedio() {
		String combinacion1[] = {"negro","rojo","verde","amarillo","verde claro"};
		String combinacion2[] = {"morado","verde","amarillo","rojo","celeste"};
		String combinacion3[] = {"negro","verde","rojo","amarillo","celeste"};
		jugadorMedio.getTablero().setCombinacionSecreta(colocarCombSecreta(combinacion1.length));
		
		for(int i=0; i< combinacion1.length;i++)
			jugadorMedio.getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(combinacion1[i]),i);
		assertTrue(jugadorMedio.compararAcertados(4, 0)); // Prueba de 4 rojos 0 blancos
			
		for(int i=0; i< combinacion1.length;i++)
			jugadorMedio.getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(combinacion2[i]),i);
		assertTrue(jugadorMedio.compararAcertados(0, 3)); //Prueba de 0 rojos 3 blancos
		
		for(int i=0; i< combinacion1.length;i++)
			jugadorMedio.getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(combinacion3[i]),i);
		assertTrue(jugadorMedio.compararAcertados(2, 2)); //Prueba de 2 rojos 2 blancos
	}
	
	@Test
	@DisplayName("Prueba '7 rojos 0 blancos' y '0 rojos 7 blancos' en modo medio")
	void colocarRespuestaDificil() {
		//"negro","rojo","verde","amarillo","azul","morado","celeste","verde claro","celeste oscuro","turquesa"
		String combinacion1[] = {"negro","rojo","verde","amarillo","azul","morado","turquesa","verde claro"};
		String combinacion2[] = {"rojo","negro","amarillo","verde","morado","azul","verde claro","turquesa"};
		jugadorDificil.getTablero().setCombinacionSecreta(colocarCombSecreta(combinacion1.length));
		
		for(int i=0; i< combinacion1.length;i++)
			jugadorDificil.getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(combinacion1[i]),i);
		assertTrue(jugadorDificil.compararAcertados(7, 0)); // Prueba de 7 rojos 0 blancos
			
		for(int i=0; i< combinacion1.length;i++)
			jugadorDificil.getTablero().getCombinacion().colocarCeldas(Colores.elegirColor(combinacion2[i]),i);
		assertTrue(jugadorDificil.compararAcertados(0, 7)); //Prueba de 0 rojos 1 blanco

	}
	
	
	

}
