/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Denisse
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    
    
   
    public static void main(String[] args) {
        int tamano = 10;
        int [] arreglo = new int[tamano];
        Sort sort = new Sort();
        for(int i=0; i<10; i++){
            while(sort.getBubbleSortList().size()<i
                  || sort.getSelectionSortList().size()<i 
                  || sort.getInsertSortList().size()<i
                  || sort.getMergeSortList().size()<i
                  || sort.getQuickSortList().size()<i
                  || sort.getHeapSortList().size()<i
                  || sort.getRadixSortList().size()<i){System.out.print("");}
            llenarArreglo(arreglo);
            Runnable bubbleSortR = new Runnable(){
                public void run(){
                    try{
                        int [] bubbleSortArreglo = new int[tamano];
                        copiarArreglo(arreglo,bubbleSortArreglo);
                        sort.bubbleSort(bubbleSortArreglo);
                        if(sort.getBubbleSortList().size()==10){
                            sort.setBubbleSortVar(true);
                        }
                            
                    }catch(Exception x){
                        x.printStackTrace();
                    }
                }
            };
            Thread bubbleSortthread = new Thread(bubbleSortR);
            bubbleSortthread.start();
            
            Runnable selectionSortR = new Runnable(){
                public void run(){
                    try{
                        int [] selectionSortArreglo = new int[tamano];
                        copiarArreglo(arreglo, selectionSortArreglo);
                        sort.selectionSort(selectionSortArreglo);
                        if(sort.getSelectionSortList().size()==10){
                            sort.setSelectionSortVar(true);
                        }
                            
                    }catch(Exception x){
                        x.printStackTrace();
                    }
                }
            };
            Thread selectionSortthread = new Thread(selectionSortR);
            selectionSortthread.start();
            
            Runnable insertSortR = new Runnable(){
                public void run(){
                    try{
                        int [] insertSortArreglo = new int[tamano];
                        copiarArreglo(arreglo, insertSortArreglo);
                        sort.insertSort(insertSortArreglo);
                        if(sort.getInsertSortList().size()==10){
                            sort.setInsertSortVar(true);
                        }
                    }catch(Exception x){
                        x.printStackTrace();
                    }
                }
            };
            Thread insertSortthread = new Thread(insertSortR);
            insertSortthread.start();
            
            Runnable mergeSortR = new Runnable(){
                public void run(){
                    try{
                        int [] mergeSortArreglo = new int[tamano];
                        copiarArreglo(arreglo, mergeSortArreglo);
                        sort.mergeSort(mergeSortArreglo);
                        if(sort.getMergeSortList().size()==10){
                            sort.setMergeSortVar(true);
                        }
                    }catch(Exception x){
                        x.printStackTrace();
                    }
                }
            };
            Thread mergeSortthread = new Thread(mergeSortR);
            mergeSortthread.start();
            
            Runnable quickSortR = new Runnable(){
                public void run(){
                    try{
                        int [] quickSortArreglo = new int[tamano];
                        copiarArreglo(arreglo, quickSortArreglo);
                        sort.quickSort(quickSortArreglo);
                        if(sort.getQuickSortList().size()==10){
                            sort.setQuickSortVar(true);
                        }
                    }catch(Exception x){
                        x.printStackTrace();
                    }
                }
            };
            Thread quickSortthread = new Thread(quickSortR);
            quickSortthread.start();
            
            Runnable heapSortR = new Runnable(){
                public void run(){
                    try{
                        int [] heapSortArreglo = new int[tamano];
                        copiarArreglo(arreglo, heapSortArreglo);
                        sort.heapSort(heapSortArreglo);
                        if(sort.getHeapSortList().size()==10){
                            sort.setHeapSortVar(true);
                        }
                    }catch(Exception x){
                        x.printStackTrace();
                    }
                }
            };
            Thread heapSortthread = new Thread(heapSortR);
            heapSortthread.start();
            
            Runnable radixSortR = new Runnable(){
                public void run(){
                    try{
                        int [] radixSortArreglo = new int[tamano];
                        copiarArreglo(arreglo, radixSortArreglo);
                        sort.radixSort(radixSortArreglo);
                        if(sort.getRadixSortList().size()==10){
                            sort.setRadixSortVar(true);
                        }
                    }catch(Exception x){
                        x.printStackTrace();
                    }
                }
            };
            Thread radixSortthread = new Thread(radixSortR);
            radixSortthread.start();
        
        }
        
        while(sort.isBubbleSortVar()==false ||
              sort.isSelectionSortVar()==false || 
              sort.isInsertSortVar()==false ||
              sort.isMergeSortVar()==false ||
              sort.isQuickSortVar()==false ||
              sort.isHeapSortVar()==false ||
              sort.isRadixSortVar()==false  ){System.out.print("");}
        imprimirListaResultados(sort.getBubbleSortList(), "Bubble Sort", tamano);
        imprimirListaResultados(sort.getSelectionSortList(), "Selection Sort", tamano);
        imprimirListaResultados(sort.getInsertSortList(), "Insert Sort", tamano);
        imprimirListaResultados(sort.getMergeSortList(), "Merge Sort", tamano);
        imprimirListaResultados(sort.getQuickSortList(), "Quick Sort", tamano);
        imprimirListaResultados(sort.getHeapSortList(), "Heap Sort", tamano);
        imprimirListaResultados(sort.getRadixSortList(), "Radix Sort", tamano);
        
    }
    
    public static void imprimirListaResultados(ArrayList<String> lista, String algoritmo, int n){
        System.out.println("Algoritmo: "+algoritmo+", Nº elementos: "+n);
        for(int i=0; i<lista.size(); i++){
            System.out.println(lista.get(i));
        }
    }
    
    public static void llenarArreglo(int []a){
        ArrayList<Integer> lista = new ArrayList();
        for(int i=0 ; i<a.length; i++)
            lista.add(i);
        Collections.shuffle(lista);
        for(int i=0; i<a.length; i++)
            a[i] = lista.get(i);
    }
    
    public static void imprimirArreglo(int []a){
        for(int i=0; i < a.length; i++)
            System.out.print(a[i]+",");
    }
    
    public static void copiarArreglo(int []a, int []b){
        for(int i=0; i<a.length; i++)
           b[i] = a[i]; 
    }
    
    
}
