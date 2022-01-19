/**
 *
 * @author Daniel Levi Caro Alvarado
 */
package EVA3_1_ORDENAMIENTOSS;

import java.util.Arrays;


public class EVA3_1_ORDENAMIENTOS {

    public static void main(String[] args) {
        
        //ORDENAMIENTO ARREGLO(INT)
        int[] datos = new int[10];
        int[] copiaSel = new int[datos.length];
        int[] copiaIns = new int[datos.length];
        int[] copiaBubble = new int[datos.length];
        int[] copiaQuickS = new int[datos.length];
        
        long iniT, finT;
        llenar(datos);//envio el arreglo a llenar con valores aleatorios
        System.out.println("PRUEBA CON ARRAYS SORT: ");
        duplicar(datos, copiaSel);
        //imprimir(copiaSel);//imprimir contenido
        iniT = System.nanoTime();//tiempo anes de empezar el metodo
        Arrays.sort(copiaSel);
        finT = System.nanoTime();//tiempo anes de empezar el metodo
        //imprimir(copiaSel);//imprimir contenido
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
        
        //imprimir(copiaSel);//imprimir contenido
        /*System.out.println("PRUEBA CON SELECTION SORT: ");
        duplicar(datos, copiaSel);
        //imprimir(copiaSel);//imprimir contenido
        iniT = System.nanoTime();//tiempo anes de empezar el metodo
        selectionSort(copiaSel);
        finT = System.nanoTime();//tiempo anes de empezar el metodo
        //imprimir(copiaSel);//imprimir contenido
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
        
        System.out.println("PRUEBA CON INSERTION SORT: ");
        duplicar(datos,copiaIns);
        //imprimir(copiaIns);//imprimir contenido
        iniT = System.nanoTime();//tiempo anes de empezar el metodo
        insertionSort(copiaIns);
        finT = System.nanoTime();//tiempo anes de empezar el metodo
        //imprimir(copiaIns);//imprimir contenido
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
        
        System.out.println("PRUEBA CON BUBBLE SORT: ");
        duplicar(datos,copiaBubble);
        //imprimir(copiaBubble);//imprimir contenido
        iniT = System.nanoTime();//tiempo anes de empezar el metodo
        bubbleSort(copiaBubble);
        finT = System.nanoTime();//tiempo anes de empezar el metodo
        //imprimir(copiaBubble);//imprimir contenido
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
        
        System.out.println("PRUEBA CON QUICK SORT: ");
        duplicar(datos,copiaQuickS);
        //imprimir(copiaQuickS);//imprimir contenido
        iniT = System.nanoTime();//tiempo anes de empezar el metodo
        quickSort(copiaQuickS);
        finT = System.nanoTime();//tiempo anes de empezar el metodo
        //imprimir(copiaQuickS);//imprimir contenido
        System.out.println("Tiempo en ordenar: " + (finT - iniT));*/
        
    }
    //LLENADO DE ARREGLO CON VALORES ALEATORIOS 0 - 99
    public static void llenar(int[] datos){
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int)(Math.random() * 100);
            
        }
    }
    
    //DUPLICAR ARREGLO (arreglos del mismo tamaño)
    public static void duplicar(int[] datos, int[] copia){
        for (int i = 0; i < datos.length; i++) {
            copia[i] = datos[i];
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
     
     public static void insertionSort(int[] datos){ 
         for (int i = 1; i < datos.length; i++) {
             int temp = datos[i];//valor a insertar
             int insP = i;//posicion donde vamos a insertar
             for (int prev = i - 1; prev >= 0; prev--) {
                 if(datos[prev] > temp){
                     datos[insP] = datos[prev];//movemos valor de prev a la posicion de insP
                     insP--;//retrocede una posicion
                 }else{
                     break;
                 }
             }
             //insertamos
             datos[insP] = temp;
         }
    }
    //EFICIENCIA O(N^2)
    public static void bubbleSort(int[] datos){
        for (int i = 0; i < datos.length; i++) {//PASADAS
            for(int j = 0; j < (datos.length - 1); j++){//COMPARA E INTERCAMBIA
                if(datos[j] > datos[j + 1]){//comparamos j vs j + 1
                    //intercambiamos
                    int temp = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = temp;
                }
            }
        }
    }
    
    //QUICKSORT DE ARANQUE
    //O(NlogN) Logaritmo base 2
    public static void quickSort (int[] datos){
        quickSortRecu(datos, 0, datos.length - 1);//quicksorta todo el arreglo
    }
    
    private static void quickSortRecu(int[] datos, int ini, int fin){
        int iPivote;//inicio
        int too_big;//busca a los mas grandes que el pivote
        int too_small;// busca a los mas pequeños que el pivote 
        boolean stopBig = false, stopSmall = false;
        
        //controlar la recursividad
        int tama = fin - ini + 1;
        if(tama > 1){//¿Cundo SI puedo realizar un quicksort?
            iPivote = ini;
            too_big = ini + 1;
            too_small = fin;
            for(int i = ini + 1; i <= fin; i++) {//numero de veces a recorrer
               if((datos[too_big] <= datos[iPivote]) && (!stopBig)){//avanzo
                    too_big++;//avanzo
                }else{
                    stopBig = true;//me detengo cuando encuentro uno mas grande
                }
                
                if((datos[too_small]) >= datos[iPivote] && (!stopSmall)){//retrocedo
                    too_small--;//retrocedo
                }else{
                    stopSmall = true;//me detengo cuando encuentro uno mas grande
                }
                
                if(stopBig && stopSmall){//ambos indices se detuvieron
                    if(too_big < too_small){//intercambio SWAP
                        int temp = datos[too_big];
                        datos[too_big] = datos[too_small];
                        datos[too_small] = temp;
                        stopBig = false;//seguir avanzando
                        stopSmall = false;//seguir avanzando
                    }else
                        break;//termino el ciclo
                }
            }
            //intercambio el pivote
            int temp = datos[iPivote];
            datos[iPivote] = datos[too_small];
            datos[too_small] = temp;  
            iPivote = too_small;//TAMBIEN CAMBIA LA POSICION DEL PIVOTE
            //quicksort (izq)
            quickSortRecu(datos, ini, iPivote - 1);
            //quicksort (der)
            quickSortRecu(datos, iPivote + 1, fin);
            
        }            
    }
}

