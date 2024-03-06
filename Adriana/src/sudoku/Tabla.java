
/**
 * Write a description of class Tabla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tabla
{
    // instance variables - replace the example below with your own
    private Celda[][] tabla;
    private boolean traza=false;

    /**
     * Constructor for objects of class Tabla
     */
    public Tabla()
    {
        this.tabla= new Celda[9][9];
        int i,x;
        
        for(i=0;i<9;i++)
        {
            for(x=0;x<9;x++)
            {
                tabla[i][x]=new Celda("x",i,x);
            }
        }
    }
    
    
    public void addCelda(String valor, int lin , int col)
    {

        tabla[lin][col]= new Celda(valor,lin,col);
    }
    
    public Celda getCelda(int lin, int col){
        return tabla[lin][col];
    }
    
    public boolean verificaTabla(){
     int i,x;   
        for(i=0;i<9;i++)
        {
            for(x=0;x<9;x++)
            {
                if(tabla[i][x].getStringCelda()=="x")
                {
                    return false;
                }
            }
        }
    return true;
    }

    public void  printTabla(){
        int i,x;
        System.out.println("");
        for(i=0;i<9;i++)
        {
            if(i%3==0&& i!=0)
            {
                
                System.out.println("");
            }
            for(x=0;x<9;x++)
            {
                if(x%3==0)
            {
                System.out.print("║ ");
            }
                System.out.print(tabla[i][x].getStringCelda()+" ");
            }
            System.out.print("║");
            System.out.println();
        }
         System.out.println("");
    }
}
