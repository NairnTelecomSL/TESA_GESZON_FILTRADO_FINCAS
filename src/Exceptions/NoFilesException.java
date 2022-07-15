/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Usuario
 */
public class NoFilesException extends Exception{
    public NoFilesException(){
        super("No se ha encontrado ningún fichero. Recuerda introducir en la carpeta Files el fichero: Batch_Informe_Fincas.csv");
    }    
}
