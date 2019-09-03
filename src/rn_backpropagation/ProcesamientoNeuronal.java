
package rn_backpropagation;

/**
 *
 * @author Víctor Echavarrpia - Yesica Tobon
 */
public class ProcesamientoNeuronal {
     //Funcion De Transferencia: Tangente Inversa Hiperbolica
    //Los datos de entrada los recibe de la clase NeuronaI
    
     double [] O1;
     double [] O2;
     double [] O3;
     double [] O4;
     double [] salida;
     
    NeuronaI datos= new NeuronaI(); 
    
     ProcesamientoNeuronal()
     {
     O1= new double [71];
     O2= new double [71];
     O3= new double [71];
     O4= new double [71];
     salida= new double [71];
     }
     
    public double[] procesarNeuronaO1(double w)
    {
     double f;
    O1 = datos.procesarDatosEntrada();
    
       for (int i=0;i<71;i++){
           
       f= O1[i]*w; 
       O1[i]= Math.tanh(f);
       }
        
     return O1;
    }
    
     public void imprimirNO1() {
        
        System.out.println("DATOS DE LA NEURONA 1");
        for(int i=0;i<71;i++){
            System.out.println(O1[i]);
        }
    }
    
    public double[] procesarNeuronaO2(double w)
    {
        double f;
    O2 = datos.procesarDatosEntrada();
    
       for (int i=0;i<71;i++){
           
       f= O2[i]*w; 
       O2[i]= Math.tanh(f);
       }

     return O2;
    }
    
      public void imprimirNO2() {
        
        System.out.println("DATOS DE LA NEURONA 2");
        for(int i=0;i<71;i++){
            System.out.println(O2[i]);
        }
    }
    
    public double[] procesarNeuronaO3(double wO11,double wO21)
    {
        double f;
      
        for (int i=0;i<71;i++){
       f= O1[i]*wO11 + O2[i]*wO21; 
       O3[i]= Math.tanh(f);
       }
 
     return O3;
    }
      
    
    public void imprimirNO3() {
        
        System.out.println("DATOS DE LA NEURONA 3");
        for(int i=0;i<71;i++){
            System.out.println(O3[i]);
        }
    }
      
      
     public double[] procesarNeuronaO4(double wO12, double wO22)
    {
         double f;
      
        for (int i=0;i<71;i++){
       f= O1[i]*wO12 + O2[i]*wO22; 
       O4[i]= Math.tanh(f);
       }
     return O4;
    }
     
     
    public void imprimirNO4() {
        
        System.out.println("DATOS DE LA NEURONA 4");
        for(int i=0;i<71;i++){
            System.out.println(O4[i]);
        }
    }
    
     public double[] procesarNeuronaSalida(double wO3,double wO4)
    {
        
        //salida es -1 y 1 entonces multiplico por 8 o -6 para normalizar los datos
        double f;
      
        for (int i=0;i<71;i++){
       f= O3[i]*wO3 + O4[i]*wO4; 
       salida[i]= Math.tanh(f);
       
       if(salida[i]>0)
       {
       salida[i]=salida[i]*7;
       
       }
       else{
       salida[i]=salida[i]*-5;
       }
    
        }
        
             return salida;
    }
    
    public void imprimirSalida() {
        
        System.out.println("DATOS DE LA CAPA DE SALIDA");
        for(int i=0;i<71;i++){
            System.out.println(salida[i]);
        }
    }
    
 
    
    public void imprimirTODO() {
        
        System.out.println("_______________________________");
        System.out.println("DATOS DE LA NEURONA 1");
        for(int i=0;i<71;i++){
            System.out.println(O1[i]);
        }
        System.out.println("_______________________________");
         System.out.println("DATOS DE LA NEURONA 2");
        for(int i=0;i<71;i++){
            System.out.println(O2[i]);
        }
        System.out.println("_______________________________");
         System.out.println("DATOS DE LA NEURONA 3");
        for(int i=0;i<71;i++){
            System.out.println(O3[i]);
        }
        System.out.println("_______________________________");
         System.out.println("DATOS DE LA NEURONA 4");
        for(int i=0;i<71;i++){
            System.out.println(O4[i]);
        }
        System.out.println("_________________________________");
         System.out.println("DATOS DE LA CAPA DE SALIDA");
        for(int i=0;i<71;i++){
            System.out.println(salida[i]);
        }
    }
}
