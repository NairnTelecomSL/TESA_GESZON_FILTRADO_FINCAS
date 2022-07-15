package DataClass;

/**
 *
 * @author Álvaro Rofa Aranda
 */
public class Registro {
    private final String cobertura;
    private final String ftth_fx;
    private final String ctomin;      //PUEDE SER VACÍO
    private final String plcProyecto; //PUEDE SER VACÍO
    private final String ia2_proyecto;//PUEDE SER VACÍO
    private final String proyecto;    //PUEDE SER VACÍO
    private final String ia2_central; //PUEDE SER VACÍO
    
    
    public Registro (String ftth_fx,String cobertura,String ctomin,String plcProyecto,String ia2_proyecto,String proyecto,String ia2_central){
        this.cobertura = cobertura;
        this.ftth_fx = ftth_fx;
        this.ctomin = ctomin;
        this.ia2_central = ia2_central;
        this.ia2_proyecto = ia2_proyecto;
        this.proyecto = proyecto;
        this.plcProyecto = plcProyecto;
    }

    public String getCobertura() {
        return cobertura;
    }
    
    public String getFtth_fx() {
        return ftth_fx;
    }

    public String getCtomin() {
        return ctomin;
    }

    public String getPlcProyecto() {
        return plcProyecto;
    }

    public String getIa2_proyecto() {
        return ia2_proyecto;
    }

    public String getProyecto() {
        return proyecto;
    }

    public String getIa2_central() {
        return ia2_central;
    }
    
    
    @Override
    public String toString(){
        return "Ftth_fx: " + this.ftth_fx +
                " -  Cobertura: " + this.cobertura +
                " - CTOMIN: " + this.ctomin +
                " - PLCPROYECTO: " + this.plcProyecto + 
                " - IA2PROYECTO: " + this.ia2_proyecto + 
                " - PROYECTO: " + this.proyecto + 
                " - IA2CENTRAL: " + this.ia2_central;
    }
}
