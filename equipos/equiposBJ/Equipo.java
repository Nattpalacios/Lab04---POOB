import java.util.ArrayList;

public class Equipo{
    private ArrayList<Persona> personas = new ArrayList<Persona>();
    
    /**
     * Crea un equipo dado el nombre de sus miembros
     * @param nombres nombres de los miembros del equipo
     */    
    public Equipo(String [] nombres){
        personas= new ArrayList<Persona>();
        for (int i=0; i< nombres.length;i++){
            personas.add(new Persona(nombres[i]));
        }    
    }

    /**
     * Calcula el valor hora de un equipo
     */
    public int valorHora() throws EquipoExcepcion{
        int suma=0;
        if (personas.size()==0) throw new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);
        for (int i=0; i<personas.size(); i++){
            suma+= personas.get(i).valorHora();
        }
        return suma;
    }
    
    /**
     * Calcula el valor hora estimado de un equipo.
     * El valor estimado de una persona a la que no se conoce su valor es la
     * media de los valores conocidos
     * Más del 75% del equipo debe tener valores conocidos 
     * @return el valor hora del equipo
     * @throws EquipoException si en el equipo hay una persona desconocida
     * o si no es posible calular el valor estimado
     */
    public int valorHoraEstimado() throws EquipoExcepcion{
        int valorHoraEstimado = 0; int valorConocido = 0;
        double setentaYCinco = personas.size() * 0.75;
        int pC = personasConocidas();
        if(pC <= setentaYCinco) throw new EquipoExcepcion(EquipoExcepcion.VALOR_DESCONOCIDO);
        else{
            for(int i = 0; i < personas.size(); i++){
                try{
                    valorHoraEstimado += personas.get(i).valorHora();
                }catch(EquipoExcepcion e){
                    if(e.getMessage().equals(EquipoExcepcion.PERSONA_DESCONOCIDA)){
                        throw new EquipoExcepcion(EquipoExcepcion.PERSONA_DESCONOCIDA);
                    }
                    valorHoraEstimado += 0;
                }
            }            
            if(valorHoraEstimado == 0) throw new EquipoExcepcion(EquipoExcepcion.VALOR_DESCONOCIDO);
            return valorHoraEstimado;
        }
    }   
     
    /**
     * Calcula el numero de personas de las cuales se conoce su valorHora.
     * @return el numero de personas de las cuales se conoce su valorHora.
     */
    private int personasConocidas(){
        int valorConocido = 0;
        for(int i = 0; i<personas.size(); i++){
            try{
                if(personas.get(i) != null && personas.get(i).valorHora() != 0){
                    valorConocido += 1;
                }
            }catch(EquipoExcepcion a){
                continue;
            }
        }
        return valorConocido;
    }

    /** 
     * Calcula el valorHora de las personas de las cuales no se conoce su valorHora.
     * @return el valorHora de las personas de las cuales no se conoce su valorHora.
     */
    private int promedioDeLosDemas(){
        int casiPromedio = valorHora();
        int valorConocido = personasConocidas();
        int promedioDesconocidas = casiPromedio / valorConocido;
        return promedioDesconocidas;        
    }
    
}
