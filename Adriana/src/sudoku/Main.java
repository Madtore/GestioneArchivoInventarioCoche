import java.io.*;
import java.util.*;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{ 
    
    
    public static void main (String arg[]){
        boolean error=false;
        boolean traza=false;
        Tabla tabla= new Tabla(); 
        
        if(arg.length==0){
            System.err.println("No hay argumentos");
            System.exit(0);
        
        } 
        
        for(int i=0;i<arg.length; i++)
        {
            if(arg[i].equalsIgnoreCase("-h"))
            {
                System.out.println("PARAMETROS POR ARGUMENTOS");
                System.out.println("-h                       impreme esta pantalla de ayda");
                System.out.println("-t                       traza los paramentros de la llamadas recursiva imprimendo por pantalla las cordinadas de la casilla que se esta evaluando");
                System.out.println("-nomeArchivo.txt          se puede pasar por argumento un file de formato txt de una tabla que tiene il seguente formato valores de 1 a 9 o - para \n\t\t\t valor no asignado");
                System.out.println("                         --- --1 --2 456");
                System.out.println("                         --- -1- --- 987");
                System.out.println("                         --- --- --- ---");
                System.out.println("                         --- --- --- ---");
                System.out.println("                         --- --- --- ---");
                System.out.println("                         --- --- --- ---");
                System.out.println("-Valores da console      insertar los valor de las 81 celdas seguidas ponendo espacios entre una y otra es.");
                System.out.println("                         - - - - - - 1 - - 2 4 5 6 - - - - 1 - - - - 9 8 7 ....");
                System.exit(0);
            }
            
            if(arg[i].equalsIgnoreCase("-t"))
            {
                traza=true;
                System.out.println("Traza de llamada recursiva activo");
            }
            File fichero= new File(arg[i]);
            if(fichero.isFile())
            {
                String tablaSudoku=arg[i];
                try
                {
                  BufferedReader inTablaSudoku = new BufferedReader(new InputStreamReader(new FileInputStream(tablaSudoku), "UTF-8"));  
                  String linea;
                  
                  int lin=0;
                    while((linea=inTablaSudoku.readLine())!=null){
                        linea=linea.replace(" ","");
                        char[] arrayLinea= linea.toCharArray();
                    
                            for(int col=0; col<9;col++)
                            {
                                
                                String valor = String.valueOf(arrayLinea[col]);
                                
                                    if(valor.matches("[1-9]")||valor.matches("-"))
                                    {
                                        tabla.addCelda(valor, lin, col);
                                    }else
                                    {
                                        System.err.print("error en linea :"+ lin+ " columna :" +col);
                                        error=true;
                                    }
                            
                            }
                    lin++;
                    
                    }
                    
                    
                  
                  
                }catch(IOException e)
                {
                    System.err.println("Error ");
                }

            }
            if(arg.length>2){
                Vector<String> tablaArg= new Vector<String>();
                        for(int x=0;x<arg.length;x++)
                        {
                            if(!arg[x].equalsIgnoreCase("-t"))
                            {
                                if(arg[x].matches("[1-9]")||arg[x].matches("-"))
                                {   
                                    tablaArg.add(arg[x]);
                                }
                            }
                        }
                        if(tablaArg.size()==81)
                            {
                             for(int pos=0; pos<tablaArg.size();pos++)
                             {
                                tabla.addCelda(tablaArg.get(pos), pos/9, pos%9);
                             }  
                            }else{
                               System.err.print("Argomento errato"); 
                               System.exit(0);
                            }
                    
                    }
            
        }
        if(error)
        {
           System.err.print("Se ha producido algun error en el cargamento de la tabla" );
           System.exit(0);
        }else
        {
            if (tabla.verificaTabla()){
                    Sudoku sudoku=new Sudoku(tabla, traza);
                
            }else{
                System.err.print("Se ha producido algun error en el cargamento de la tabla" );
                System.exit(0);
            }

        }
    }
    
    
}



