package excepcion;

public class IemoisExcepcion extends Exception{
	
	public static final String NO_DISTRIBUIDOR = "El distribuidor no es conocido";
	public static final String CURSO_REPETIDO = "El curso ya existe";
	public static final String NOMBRE_VACIO= "El nombre no es conocido";
	public static final String AREA_VACIA= "El area no es conocida";
	public static final String OBJETIVO_VACIO= "El objetivo no es conocido";
	public static final String SEMANAS_VACIO= "Las semanas no son conocidas";
	
	
	public IemoisExcepcion(String message) {
		super(message);
	}
}