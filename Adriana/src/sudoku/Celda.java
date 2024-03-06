
/**
 * Write a description of class Celda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Celda
{
    // instance variables - replace the example below with your own
    private String valorString;
    private int lin;
    private int col;

    /**
     * Constructor for objects of class Celda
     */
    

    public Celda(String valorString, int lin , int col){
        this.lin=lin;
        this.col=col;
        this.valorString=valorString;
    }
     
    
    public void setStringCelda(String valorString){
        this.valorString=valorString;
    }
    
    public String getStringCelda(){
        return valorString;
    }
    
    
    
}
