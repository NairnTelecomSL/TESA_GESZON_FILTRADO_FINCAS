/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tesa_gescon;

import Applications.FilesReader;
import DataClass.Registro;
import Exceptions.NoFilesException;
import java.util.ArrayList;

/**
 *
 * @author Developer
 */
public class TESA_Gescon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try {
            System.out.println("Bienvenido, comenzamos a leer el fichero\n" +
"            registros = FilesReader.readCSVData(\"Files/Batch_Informe_Fincas.csv\");");
            
            ArrayList<Registro> registros = new ArrayList<>();
            registros = FilesReader.readCSVData("Files/Batch_Informe_Fincas.csv");
                    
            System.out.println("Fichero leido con éxito, pasamos a mostrar los datos");
            System.out.println("Número de datos: " + registros.size());
            for (int i = 0; i < registros.size(); i++) {
                System.out.println(registros.get(i).toString());
            }
            
        } catch (NoFilesException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
