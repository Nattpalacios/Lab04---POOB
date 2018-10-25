package excepcion;

public class IemoisExcepcion extends Exception{
	
	public static final String NO_DISTRIBUIDOR = "El distribuidor no es conocido";
	
	
	public IemoisExcepcion(String message) {
		super(message);
	}
}