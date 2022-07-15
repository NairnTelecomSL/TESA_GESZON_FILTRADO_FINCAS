/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Applications;

import DataClass.Registro;
import Exceptions.NoFilesException;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Developer
 */
public class FilesReader {
    /**
     * Lee el fichero CSV pasádo por parámetro
     * @param csvFile
     * @return 
     * @throws Exceptions.NoFilesException 
     */
    public static ArrayList<Registro> readCSVData(String csvFile) throws NoFilesException{
        BufferedReader br = null;
        ArrayList<Registro> registros = new ArrayList<>();
        int numFila = 1, REG = 0;
        try {
            br = new BufferedReader(new java.io.FileReader(csvFile));
            String line = br.readLine(), ftth_fx, cobertura, ctomin, plcproyecto, ia2proyecto, proyecto,ia2central;
            line = br.readLine();
            while (line != null) {
                String[] fields = line.split(";");    
                //System.out.println("Hemos encontrado " + fields.length + " columnas");
                //ctomin = " "; plcproyecto = " "; ia2proyecto = " " ; proyecto =  " "; ia2central = " ";
                /*//Registro(String numero_SUC, String miga, String estado, String identificador, String uso, String cable, String elementoPasivo, String ipid_id)
                if (csvFile.contains("W49")) {
                    identificacion = fields[9];
                    uso = fields[10];
                    switch (fields.length) {
                        case 14:
                            cable = fields[11];
                            elemento = fields[12];
                            ipid = fields[13];
                            break;
                        case 13:
                            cable = fields[11];
                            elemento = fields[12];
                            break;
                        case 12:
                            cable = fields[11];
                            break;
                        default:
                            break;
                    }
                }else{
                    //System.out.println("leemos fila " + (numFila++) + " El tamaño de la actual es " + fields.length);
                    //System.out.println("Añadimos de actual");
                    //System.out.println("Tamaño encontrado: " + fields.length);
                    switch (fields.length) {
                        case 16:
                            /**
                             * CUENTA CON TODOS LOS DATOS
                             */
                            /*uso = fields[10];
                            identificacion = fields[9];
                            cable = fields[11];
                            elemento = fields[14];
                            ipid = fields[15];
                            break;
                        case 12:
                             //SIN ID NI ELEMENTO PASIVO
                            uso = fields[10];
                            identificacion = fields[9];
                            cable = fields[11];
                            
                            break;
                        case 11:    
                             //SIN ID NI ELEMENTO PASIVO, SIN CABLE, SIN ID, SIN IDENTIFICACIÓN
                            uso = fields[9];
                            break;
                        default:
                            break;
                    }
                    ++REG;
                }                
                Registro newReg = new Registro(fields[0], fields[1], fields[5], identificacion, uso, cable, elemento, ipid);
                
                if(fields.length >= 11){
                    registros.add(newReg);
                    numFila++;
                }*/
                             
                ftth_fx = fields[2];        ftth_fx = ftth_fx.replace("\"", "");                 
                cobertura = fields[4];      cobertura = cobertura.replace("\"", "");
                ctomin = fields[5];         ctomin = ctomin.replace("\"", "");
                plcproyecto = fields[6];    plcproyecto = plcproyecto.replace("\"", "");
                ia2proyecto = fields[10];   ia2proyecto = ia2proyecto.replace("\"", "");
                proyecto = fields[13];      proyecto = proyecto.replace("\"", "");
                ia2central = fields[19];    ia2central = ia2central.replace("\"", "");
                
                Registro registro = new Registro(ftth_fx, cobertura, ctomin, plcproyecto, ia2proyecto, proyecto, ia2central);
                registros.add(registro);
                
                numFila++;
                 
                line = br.readLine();
            }            
        } catch (IOException e) {
            System.out.println("Ha surgido un error: " + e.getMessage() + ". En la fila " + numFila);
            throw new NoFilesException();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException ex) {
                    System.out.println("Ha surgido un error: " + ex.getMessage() + ". En la fila " + numFila);
                }
            }
        } 
        System.out.println("Se han introducido un total de " + numFila + " en el archivo " + csvFile);
        return registros;
    }
}
