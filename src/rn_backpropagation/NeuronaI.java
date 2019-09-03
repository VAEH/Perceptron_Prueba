
package Perceptron;

/**
 *
 * @author Yohary Pabon
 */
public class NeuronaI {
   double [] datosEntrada;
  
      
    NeuronaI()
    {
    datosEntrada= new double [71];
    }
   
    double[] procesarDatosEntrada() {
    datosEntrada[0]= 0.001;
    datosEntrada[1]= 0.101;
    datosEntrada[2]= 0.201;
    datosEntrada[3]= 0.301;
    datosEntrada[4]=0.401;
    datosEntrada[5]=0.501;
    datosEntrada[6]=0.601;
    datosEntrada[7]=0.701;
    datosEntrada[8]=0.801;
    datosEntrada[9]=0.901;
    datosEntrada[10]=1.001;
    datosEntrada[11]=1.101;
    datosEntrada[12]=1.201;
    datosEntrada[13]=1.301;
    datosEntrada[14]=1.401;
    datosEntrada[15]=1.501;
    datosEntrada[16]=1.601;
    datosEntrada[17]=1.701;
    datosEntrada[18]=1.801;
    datosEntrada[19]=1.901;
    datosEntrada[20]=2.001;
    datosEntrada[21]=2.101;
    datosEntrada[22]=2.201;
    datosEntrada[23]=2.301;
    datosEntrada[24]=2.401;
    datosEntrada[25]=2.501;
    datosEntrada[26]=2.601;
    datosEntrada[27]=2.701;
    datosEntrada[28]=2.801;
    datosEntrada[29]=2.901;
    datosEntrada[30]=3.001;
    datosEntrada[31]=3.101;
    datosEntrada[32]=3.201;
    datosEntrada[33]=3.301;
    datosEntrada[34]=3.401;
    datosEntrada[35]=3.501;
    datosEntrada[36]=3.601;
    datosEntrada[37]=3.701;
    datosEntrada[38]=3.801;
    datosEntrada[39]=3.901;
    datosEntrada[40]=4.001;
    datosEntrada[41]=4.101;
    datosEntrada[42]=4.201;
    datosEntrada[43]=4.301;
    datosEntrada[44]=4.401;
    datosEntrada[45]=4.501;
    datosEntrada[46]=4.601;
    datosEntrada[47]=4.701;
    datosEntrada[48]=4.801;
    datosEntrada[49]=4.901;
    datosEntrada[50]=5.001;
    datosEntrada[51]=5.101;
    datosEntrada[52]=5.201;
    datosEntrada[53]=5.301;
    datosEntrada[54]=5.401;
    datosEntrada[55]=5.501;
    datosEntrada[56]=5.601;
    datosEntrada[57]=5.701;
    datosEntrada[58]=5.801;
    datosEntrada[59]=5.901;
    datosEntrada[60]=6.001;
    datosEntrada[61]=6.101;
    datosEntrada[62]=6.201;
    datosEntrada[63]=6.301;
    datosEntrada[64]=6.401;
    datosEntrada[65]=6.501;
    datosEntrada[66]=6.601;
    datosEntrada[67]=6.701;
    datosEntrada[68]=6.801;
    datosEntrada[69]=6.901;
    datosEntrada[70]=7.001;
    
    return datosEntrada;
    }

    void imprimirDatos() {
            System.out.println("DATOS DE LA CAPA ENTRADA ");
        for(int i=0;i<71;i++){
            System.out.println(datosEntrada[i]);
        }
    }
    
    
    
}
