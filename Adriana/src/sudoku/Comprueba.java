
/**
 * Write a description of class Sudoku here.
 * 
 * @author (Salvatore Pulino) 
 * @version (1.0)
 */
public class Comprueba
{
    private final static int TAMAÑO=9;
    
    
    
    public static boolean esSatifacible(Tabla tabla, int contador, int valor){
            return ((esSatColumna(tabla,contador,valor))&&(esSatLinea(tabla,contador,valor))&&(esSatCubo(tabla,contador,valor)));
    }
    
    private static boolean esSatColumna(Tabla tabla, int contador, int valor){
        for(int i=0; i<TAMAÑO; i++){
            if ((tabla.getCelda(i,contador%TAMAÑO).getStringCelda().compareTo(String.valueOf(valor))==0)){
                return false;
            }
        }
        return true;
    }
    

     private static boolean esSatLinea(Tabla tabla, int contador, int valor){
        for(int i=0; i<TAMAÑO; i++){
            if ((tabla.getCelda(contador/TAMAÑO,i).getStringCelda().compareTo(String.valueOf(valor))==0)){
                return false;
            }
        }
        return true;
     }
   
    private static boolean esSatCubo(Tabla tabla, int contador, int valor){
        int cuboLinea= ((contador%TAMAÑO)/3)*3;
        int cuboColumna= ((contador/TAMAÑO)/3)*3;
        
        
        for (int y=cuboColumna; y<cuboColumna+3;y++ ){
            for (int x=cuboLinea; x<cuboLinea+3;x++ ){
                if ((tabla.getCelda(y,x).getStringCelda().compareTo(String.valueOf(valor))==0)){
                return false;
                }
        
            }        
        }
        return true;
    }
    
    public static boolean combruebaTabla(Tabla tabla){
        for(int i=0; i<81; i++)
        {
            if(!(tabla.getCelda(i/TAMAÑO,i%TAMAÑO).getStringCelda().compareTo("-")==0))
            {         
                if((esSatifacible(tabla,i, Integer.parseInt(tabla.getCelda(i/TAMAÑO,i%TAMAÑO).getStringCelda().toString()))))
                {
                    return false;
                }
            }
        }
        return true;
    }
   
}
