package pruebas;

import aplicacion.*;
import excepcion.IemoisExcepcion;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

/**
 * * The test class IemoisTest.*
 * 
 * @author (Palacios)
 * 
 * @version (24/10/2018)
 */

public class IemoisTest {
	
	/** Default constructor for test class IemoisTest */
	
	public IemoisTest(){
	}
	
	@Before
    public void setUp(){
    }
	
	@Test
	public void deberiaAdicionarUnCurso() throws IemoisExcepcion{
		Iemois iemoi = new Iemois();
		int cant = iemoi.numerocursos();
		iemoi.adicione("Aprendiendo a Programar","Programacion","Aprender a programar en python","python","4");
		assertTrue(cant+1 == iemoi.numerocursos());
		assertEquals(cant+1,iemoi.numerocursos());
	}
	
	@Test
	public void deberiaListar() throws IemoisExcepcion{
		Iemois iemoi = new Iemois();
		String antes = iemoi.toString();
		iemoi.adicione("Aprendiendo a Programar","Programacion","Aprender a programar en python","python","4");
		String despues = iemoi.toString();
		assertFalse(antes == despues);
		assertTrue(antes != despues);
		iemoi.adicione("Modelado","Modelamiento","Aprender a modelar bases de datos","sql","12");
		String superDespues = iemoi.toString();
		assertFalse(superDespues == despues);
		assertTrue(superDespues != despues);
	}
	
	@Test
	public void noDeberiaAdicionarSinDistribuidor() throws IemoisExcepcion{
		Iemois iemoi = new Iemois();
		try {
			iemoi.adicione("Aprendiendo a Programar","Programacion","Aprender a programar en python","","4");
			fail("No lanzo excepcion");
		}catch(IemoisExcepcion e) {
			assertEquals(e.getMessage(), IemoisExcepcion.NO_DISTRIBUIDOR);
		}
	}
	
	/**@Test
	public void noDeberiaAdicionarSiYaExisteElCurso() throws IemoisExcepcion{
		Iemois iemoi = new Iemois();
		try {
			iemoi.adicione("Aprendiendo a Programar","Programacion","Aprender a programar en python","python","4");
			iemoi.adicione("Aprendiendo a Programar","Programacion","Aprender a programar en python","python","4");
			fail("No lanzo excepcion");
		}catch(IemoisExcepcion e) {
			assertEquals(e.getMessage(), IemoisExcepcion.CURSO_REPETIDO);
		}
	}*/
	
	@Test
	public void noDeberiaAdicionarSinNombre() throws IemoisExcepcion{
		Iemois iemoi = new Iemois();
		try {
			iemoi.adicione("","Programacion","Aprender a programar en python","python","4");
			fail("No lanzo excepcion");
		}catch(IemoisExcepcion e) {
			assertEquals(e.getMessage(), IemoisExcepcion.NOMBRE_VACIO);
		}
	}
	
	@Test
	public void noDeberiaAdicionarSinArea() throws IemoisExcepcion{
		Iemois iemoi = new Iemois();
		try {
			iemoi.adicione("Aprendiendo a Programar","","Aprender a programar en python","python","4");
			fail("No lanzo excepcion");
		}catch(IemoisExcepcion e) {
			assertEquals(e.getMessage(), IemoisExcepcion.AREA_VACIA);
		}
	}
	
	@Test
	public void noDeberiaAdicionarSinObjetivo() throws IemoisExcepcion{
		Iemois iemoi = new Iemois();
		try {
			iemoi.adicione("Aprendiendo a Programar","Programacion","","python","4");
			fail("No lanzo excepcion");
		}catch(IemoisExcepcion e) {
			assertEquals(e.getMessage(), IemoisExcepcion.OBJETIVO_VACIO);
		}
	}
	
	@Test
	public void noDeberiaAdicionarSinSemanas() throws IemoisExcepcion{
		Iemois iemoi = new Iemois();
		try {
			iemoi.adicione("Aprendiendo a Programar","Programacion","Aprender a programar en python","python","");
			fail("No lanzo excepcion");
		}catch(IemoisExcepcion e) {
			assertEquals(e.getMessage(), IemoisExcepcion.SEMANAS_VACIO);
		}
	}
	
	@Test
	public void noDeberiaAdicionarSiSemanasNoEsNumero() throws IemoisExcepcion{
		Iemois iemoi = new Iemois();
		try {
			iemoi.adicione("Aprendiendo a Programar","Programacion","Aprender a programar en python","python","b");
			fail("No lanzo excepcion");
		}catch(IemoisExcepcion e) {
			assertEquals(e.getMessage(), IemoisExcepcion.SEMANAS_MAL);
		}
	}
	
	@Test
	public void deberiaFallarBuscar() throws IemoisExcepcion{
		Iemois iemoi = new Iemois();
		iemoi.adicione("Mogramar", "Programacion", "Aprender a programar", "progra", "6");
		iemoi.busque("M");
	}
	
	@After
    public void tearDown(){
    }
}