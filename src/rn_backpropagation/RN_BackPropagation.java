/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rn_backpropagation;

/**
 *
 * @author Yohary Pabon
 */
public class RN_BackPropagation {

    //LA TASA DE APRENDIZAJE  Y LOS PESOS NO DEBEN DE ESTAR QUEMADOS EN EL CODIGO
  static double [] datosReales = new double [71];
  static double [] error = new double [71];
  static double [] salida;
  static double [] real;

   
    public static void main(String[] args) {
    
     double w1I= Math.random();
     double w2I= Math.random();
     double wO11= Math.random();
     double wO12= Math.random();
     double wO21= Math.random();
     double wO22 = Math.random();
     double wO3 = Math.random();
     double wO4 = Math.random();
     
     double [] O1;
     double [] O2;
     double [] O3;
     double [] O4;
     double [] ent;
   
     double epsilon= 0.0001;
     double erTotal=0;
       
     
      NeuronaI datosEntrada = new NeuronaI();
      ProcesamientoNeuronal dProcesamiento = new ProcesamientoNeuronal();
      
      //DATOS DE ENTRADA
      ent=datosEntrada.procesarDatosEntrada();
      datosEntrada.imprimirDatos();
      
      
      
      //PROCESAMIENTO DE LA CAPA OCULTA Y DE LA CAPA DE SALIDA
      
      O1= dProcesamiento.procesarNeuronaO1(w1I);
      O2= dProcesamiento.procesarNeuronaO2(w2I);
      O3= dProcesamiento.procesarNeuronaO3(wO11, wO21);
      O4= dProcesamiento.procesarNeuronaO4(wO12, wO22);
      salida=dProcesamiento.procesarNeuronaSalida(wO3, wO4);
      dProcesamiento.imprimirSalida();
     
      
     //HALLAR EL ERROR
     //POTENCIA (REAL-SALIDA;2)
  
         real =cargarDatosReales();
          System.out.println("_____________________________________________");
         System.out.println("ERROR ENTRE LOS DATOS DE SALIDA Y LOS REALES");
         for(int i=0; i<71; i++){
         error[i]= Math.pow((real[i]-salida[i]), 2);
          System.out.println(error[i]);
        }
       System.out.println("_____________________________________________");
         System.out.println("ERROR TOTAL");
         
         double e=0;
          for(int i=0; i<71; i++){
         e+=error[i];
         }
          erTotal=e/71;
         System.out.println(erTotal);
        
         System.out.println("PESOS INICIALES");
         
     System.out.println("PESO w1: " +w1I);
     System.out.println("PESO w2: " +w2I);
     System.out.println("PESO wO11: " +wO11);
     System.out.println("PESO wO12: " +wO12);
     System.out.println("PESO wO21: " +wO21);
     System.out.println("PESO wO22: " +wO22);
     System.out.println("PESO w3: " +wO3);
     System.out.println("PESO w4: " +wO4);
         
         
         //CICLO WHILE HASTA QUE EL erTotal = epsilon
         
         double ErrS=0;
         double EO1=0;
         double EO2=0;
         double EO3=0;
         double EO4=0;
         double n=1;// TASA DE APRENDIZAJE
         int contI=0;
        
         double w1=0;
         double w2=0;
         double w11=0;
         double w12=0;
         double w21=0;
         double w22=0;
         double w3=0;
         double w4=0;
         
         
         
         while(erTotal> epsilon )
         {
    
          //Error en la salida
             for(int i=0; i<71; i++){
                ErrS+= (real[i]-salida[i])* salida[i]*(1-salida[i]);
             }
             ErrS=ErrS/71;
                //System.out.println(ErrS);
               
         //Peso wO3->S
         for(int i=0; i<71; i++){
         w3+= wO3+n*ErrS*salida[i];
         }
         w3=w3/71;
         //System.out.println(wO3);
         
           //Peso wO4->S
         for(int i=0; i<71; i++){
         w4+= wO4+n*ErrS*salida[i];
         }
         w4=w4/71;
         //System.out.println(wO4);
         
          //Error en la Neurona 4
             for(int i=0; i<71; i++){
                EO4+= O4[i]*(1-O4[i])*(ErrS*wO4);
             }
             EO4=EO4/71;
                //System.out.println(EO4);
                
           //Error en la Neurona 3
             for(int i=0; i<71; i++){
                EO3+= O3[i]*(1-O3[i])*(ErrS*wO3);
             }
             EO3=EO3/71;
                //System.out.println(EO3);
                
          //Peso wO11->O3
         for(int i=0; i<71; i++){
         w11+= wO11+n*EO3*O1[i];
         }
         w11=w11/71;
         //System.out.println(wO11); 
         
         //Peso wO12->O4
         for(int i=0; i<71; i++){
         w12+= wO12+n*EO4*O1[i];
         }
         w12=w12/71;
         //System.out.println(wO12);  
         
         //Peso wO21->O3
         for(int i=0; i<71; i++){
         w21+= wO21+n*EO3*O2[i];
         }
         w21=w21/71;
         //System.out.println(wO21); 
         
           //Peso wO22->O4
         for(int i=0; i<71; i++){
         w22+= wO22+n*EO4*O2[i];
         }
         w22=w22/71;
         //System.out.println(wO22);  
         
         //Peso w1->O1
         for(int i=0; i<71; i++){
         w1+= w1I+n*EO1*ent[i];
         }
         w1=w1/71;
         //System.out.println(w1I); 
         
          //Peso w2->O2
         for(int i=0; i<71; i++){
         w2+= w2I+n*EO2*ent[i];
         }
         w2=w2/71;
         //System.out.println(w2I); 
          wO3=w3;
          wO4=w4;
          wO11=w11;
          wO12=w12;
          wO21=w21;
          wO22=w22;
          w1I=w1;
          w2I=w2;
        //PROCESAR DATOS NUEVAMENTE   
      O1= dProcesamiento.procesarNeuronaO1(w1I);
      O2= dProcesamiento.procesarNeuronaO2(w2I);
      O3= dProcesamiento.procesarNeuronaO3(wO11, wO21);
      O4= dProcesamiento.procesarNeuronaO4(wO12, wO22);
      salida=dProcesamiento.procesarNeuronaSalida(wO3, wO4);
      
      //ERROR TOTAL PARA HACER LA COMPARACION
      for(int i=0; i<71; i++){
         error[i]= Math.pow((real[i]-salida[i]), 2);
        }
      
       for(int i=0; i<71; i++){
         e+=error[i];
         }
       
       erTotal=e/71;
   
         contI++;
         }
          System.out.println("ERROR TOTAL "+erTotal);
          System.out.println( "ITERACIONES "+contI);
         
          System.out.println("PESO NI->O1 "+w1I); 
          System.out.println("PESO NI->O2 "+w2I); 
          System.out.println("PESO O1->O3 "+wO11); 
          System.out.println("PESO O1->O4 "+wO12); 
          System.out.println("PESO O2->O3 "+wO21); 
          System.out.println("PESO O2->O4 "+wO22); 
          System.out.println("PESO O3->S "+wO3);
          System.out.println("PESO O4->S "+wO4); 
     
    }
    
    
     static double[] cargarDatosReales()
  {
    
    datosReales[0]=0.002;
    datosReales[1]=0.206;
    datosReales[2]=0.416;
    datosReales[3]=0.630;
    datosReales[4]=0.846;
    datosReales[5]=1.062;
    datosReales[6]=1.275;
    datosReales[7]=1.484;
    datosReales[8]=1.686;
    datosReales[9]=1.877;
    datosReales[10]=2.057;
    datosReales[11]=2.223;
    datosReales[12]=2.371;
    datosReales[13]=2.501;
    datosReales[14]=2.609;
    datosReales[15]=2.694;
    datosReales[16]=2.754;
    datosReales[17]=2.787;
    datosReales[18]=2.792;
    datosReales[19]=2.767;
    datosReales[20]=2.712;
    datosReales[21]=2.627;
    datosReales[22]=2.509;
    datosReales[23]=2.361;
    datosReales[24]=2.181;
    datosReales[25]=1.971;
    datosReales[26]=1.732;
    datosReales[27]=1.464;
    datosReales[28]=1.170;
    datosReales[29]=0.851;
    datosReales[30]=0.511;
    datosReales[31]=0.151;
    datosReales[32]=-0.225;
    datosReales[33]=-0.614;
    datosReales[34]=-1.013;
    datosReales[35]=-1.417;
    datosReales[36]=-1.822;
    datosReales[37]=-2.225;
    datosReales[38]=-2.621;
    datosReales[39]=-3.004;
    datosReales[40]=-3.372;
    datosReales[41]=-3.719;
    datosReales[42]=-4.041;
    datosReales[43]=-4.333;
    datosReales[44]=-4.591;
    datosReales[45]=-4.811;
    datosReales[46]=-4.988;
    datosReales[47]=-5.121;
    datosReales[48]=-5.204;
    datosReales[49]=-5.235;
    datosReales[50]=-5.213;
    datosReales[51]=-5.134;
    datosReales[52]=-4.997;
    datosReales[53]=-4.802;
    datosReales[54]=-4.548;
    datosReales[55]=-4.236;
    datosReales[56]=-3.865;
    datosReales[57]=-3.439;
    datosReales[58]=-2.959;
    datosReales[59]=-2.428;
    datosReales[60]=-1.849;
    datosReales[61]=-1.228;
    datosReales[62]=-0.567;
    datosReales[63]=0.126;
    datosReales[64]=0.846;
    datosReales[65]=1.586;
    datosReales[66]=2.340;
    datosReales[67]=3.100;
    datosReales[68]=3.858;
    datosReales[69]=4.606;
    datosReales[70]=5.336;
    
 return datosReales;
  }

     
}
