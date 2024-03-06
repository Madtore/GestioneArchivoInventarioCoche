   
/**
 * Write a description of class CopyOfSudoku here.
 * 
 * @author (Salvatore Pulino) 
 * @version (a version number or a date)
 */
public class Sudoku
{
    
    private static int TAMAÑO=9; 
    private Tabla tabla;
    private boolean traza=false;
    private StringBuilder trazaString=new StringBuilder();
    private static int soluzione=0;
    
    
    public Sudoku (Tabla t, boolean traza){
        this.traza=traza;
        
        soluzionaSudoku(0,t);
        
    }
    
    
    
    public void setTraza(boolean traza){
        this.traza=traza;
    }
    

    private void soluzionaSudoku(int contador, Tabla tabla){
        
        if(contador+1<=81)
        {
            
            if((tabla.getCelda(contador/TAMAÑO, contador%TAMAÑO).getStringCelda().compareTo("-")==0))
            {
                
                for(int valor=1; valor<=9; valor++)
                {
                    
                
                    if(Comprueba.esSatifacible(tabla, contador, valor))
                    {
                        tabla.getCelda(contador/TAMAÑO, contador%TAMAÑO).setStringCelda(String.valueOf(valor));
                        if(traza){
                            trazaString.append("Se esta evaluando la celda linea:"+((contador/TAMAÑO)+1)+" columna:"+ ((contador%TAMAÑO)+1)+" con valor :"+valor+ "\n");
                        }
                        
                        soluzionaSudoku(contador+1,tabla);
                        
                        
                        tabla.getCelda(contador/TAMAÑO, contador%TAMAÑO).setStringCelda("-");
                        
                    }
                }
                
            }else
            {
                soluzionaSudoku(contador+1,tabla);
            }
 
        }else
        {
        System.out.println(trazaString);    
        soluzione++;
        System.out.println("Soluzione n : "+soluzione);
        tabla.printTabla();
        System.exit(0);
        
        }
    }


    

    
    
    public Tabla getTabla(){
        return tabla;
    
    }
    
    
  }

