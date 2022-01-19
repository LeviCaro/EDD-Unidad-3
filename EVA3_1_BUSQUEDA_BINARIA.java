/**
 *
 * @author Daniel Levi Caro Alvarado
 */
package EVA3_1_BUSQUEDA_BINARIA;

import java.util.Scanner;


public class EVA3_1_BUSQUEDA_BINARIA {

    
    public static void main(String[] args) {
        
        int[] datos = new int[20];
        llenar(datos);//envio el arreglo a llenar con valores aleatorios
        imprimir(datos);
        selectionSort(datos);
        imprimir(datos);
        Scanner input = new Scanner(System.in);
        System.out.println("Valor a buscar: ");
        int valor = input.nextInt();
        int iResu = binarySearch(datos, valor);
        System.out.println("El elemento esta en la posicion: " + iResu);
    }
    
    //LLENADO DE ARREGLO CON VALORES ALEATORIOS 0 - 99
    public static void llenar(int[] datos){
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int)(Math.random() * 100);
            
        }
    }
    
    //COPIA DE ARREGLO
    //IMPRIMIR ARREGLO
     public static void imprimir(int[] datos){
        for (int i = 0; i < datos.length; i++) {
            System.out.print("[" + datos[i] + "]");
        }
        System.out.println("");
    }   
    
     //EFICIENCIA O(N^2)
     public static void selectionSort(int[] datos){
         for (int i = 0; i < datos.length; i++) {
             int iMin = i;//EMPIEZA EL ALGORITMO, EL MINIMO ES EL PRIMER ELEMENTO
             for (int j = i + 1; j < datos.length; j++) {//BUSCAR LA POSICION DEL VALOR MAS PEQUEÑO
                 //COMPARAR
                 //valor [j] vs valor [min]
                 if(datos[j] < datos[iMin]){//COMPARANDO ACTUAL VS EL MINIMO ACTUAL
                     iMin = j;
                 }
             }
             //INTERCAMBIO
             if(i != iMin){
                 //3 PASOS
                 //RESPALDAR UN VALOR
                 int iTemp = datos[i];
                 //INTERCAMBIAR UN VALOR
                 datos[i] = datos[iMin];
                 //REPONER EL VALOR RESPALDADO
                 datos[iMin] = iTemp;
            }
        } 
     } 
     
     //LA BUSQUEDA BINARIA ES RECURSIVA
     //O(logN)
     public static int binarySearch(int[] datos, int valBuscar){
         return binarySearchRecu(datos, valBuscar, 0, datos.length - 1);
     }
     
    private static int binarySearchRecu(int[] datos, int valBuscar, int ini, int fin){
        int iMid, iResu;
        iMid = ini + ((fin - ini) / 2);//posicion a la mitad de la busqueda
        iResu = -1;//SI EL VALOR NO EXISTE, REGRESAMOS -1
        if(fin >= ini){//buscamos
             if(valBuscar == datos[iMid]){//EL VALOR ESTA A LA MITAD
                 iResu = iMid;//aqui esta el valor, y lo regresamos
            }else if(valBuscar < datos[iMid]){//NO ESTA A LA MITAD, PERO ESTA A LA IZQ
                //llamamos recursivamente a la busqueda binaria
                iResu = binarySearchRecu(datos, valBuscar, ini, iMid - 1);
            }else{//NO ESTA, PERO PUEDE ESTAR A LA DER
                iResu = binarySearchRecu(datos, valBuscar, iMid + 1, fin);
            }
        }//se detiene el proceso
    
        return iResu;
    }
}
