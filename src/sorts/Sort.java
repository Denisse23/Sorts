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
public class Sort {
    private boolean bubbleSortVar;
    private boolean selectionSortVar;
    private boolean insertSortVar;
    private boolean mergeSortVar;
    private boolean quickSortVar;
    private boolean heapSortVar;
    private boolean radixSortVar;
    
    private ArrayList<String> bubbleSortList;
    private ArrayList<String> selectionSortList;
    private ArrayList<String> insertSortList;
    private ArrayList<String> mergeSortList;
    private ArrayList<String> quickSortList;
    private ArrayList<String> heapSortList;
    private ArrayList<String> radixSortList;
    
    public Sort(){
        bubbleSortVar = false;
        selectionSortVar = false;
        insertSortVar = false;
        mergeSortVar = false;
        quickSortVar = false;
        heapSortVar = false;
        radixSortVar = false;
        bubbleSortList = new ArrayList();
        selectionSortList = new ArrayList();
        insertSortList = new ArrayList();
        mergeSortList = new ArrayList();
        quickSortList = new ArrayList();
        heapSortList = new ArrayList();
        radixSortList = new ArrayList();
        
    }
    
    
    public ArrayList<String> getBubbleSortList() {
        return bubbleSortList;
    }

    public ArrayList<String> getSelectionSortList() {
        return selectionSortList;
    }

    public ArrayList<String> getInsertSortList() {
        return insertSortList;
    }


    public ArrayList<String> getMergeSortList() {
        return mergeSortList;
    }

    public ArrayList<String> getQuickSortList() {
        return quickSortList;
    }

    public ArrayList<String> getHeapSortList() {
        return heapSortList;
    }

    public ArrayList<String> getRadixSortList() {
        return radixSortList;
    }
    
    
    
    public boolean isBubbleSortVar() {
        return bubbleSortVar;
    }

    public void setBubbleSortVar(boolean bubbleSortVar) {
        this.bubbleSortVar = bubbleSortVar;
    }
    
    
    public boolean isSelectionSortVar() {
        return selectionSortVar;
    }

    public void setSelectionSortVar(boolean selectionSortVar) {
        this.selectionSortVar = selectionSortVar;
    }

    public boolean isInsertSortVar() {
        return insertSortVar;
    }

    public void setInsertSortVar(boolean insertSortVar) {
        this.insertSortVar = insertSortVar;
    }

    public boolean isMergeSortVar() {
        return mergeSortVar;
    }

    public void setMergeSortVar(boolean mergeSortVar) {
        this.mergeSortVar = mergeSortVar;
    }

    public boolean isQuickSortVar() {
        return quickSortVar;
    }

    public void setQuickSortVar(boolean quickSortVar) {
        this.quickSortVar = quickSortVar;
    }

    public boolean isHeapSortVar() {
        return heapSortVar;
    }

    public void setHeapSortVar(boolean heapSortVar) {
        this.heapSortVar = heapSortVar;
    }

    public boolean isRadixSortVar() {
        return radixSortVar;
    }

    public void setRadixSortVar(boolean radixSortVar) {
        this.radixSortVar = radixSortVar;
    }
    
    
    
    
    
    public void  bubbleSort(int[] a){
        long startTime = System.nanoTime();
        for (int i=a.length-1; i>=0 ; i--){
            for(int j=0 ; j<i; j++){
                if(a[j]>a[j+1])
                    swap(a, j, j+1);
            }
        }
        long endTime = System.nanoTime();
        bubbleSortList.add("Nanosegundos: "+(endTime - startTime));
    }
    
    
    public void selectionSort(int []a){
        long startTime = System.nanoTime();
        for (int i=0; i<a.length-1; i++){
            int min = i;
            for(int j=i+1 ; j<a.length; j++){
                if(a[j]<a[min])
                    min=j;
            }
            swap(a, i, min);
        }
        long endTime = System.nanoTime();
        selectionSortList.add( "Nanosegundos: "+(endTime - startTime));
    }
    public  void insertSort(int []a){
        long startTime = System.nanoTime();
        for (int i=1; i<a.length ; i++){
            int j=i;
            while(j>0 && (a[j]<a[j-1])){
                swap(a, j, j-1);
                j=j-1;
            }
        }
        long endTime = System.nanoTime();
        insertSortList.add("Nanosegundos: "+(endTime - startTime));
    }
    
    public  void mergeSort(int []A){
        long startTime = System.nanoTime();
        mergeSortIn(A, A.length);
        long endTime = System.nanoTime();
        mergeSortList.add("Nanosegundos: "+(endTime - startTime));
    }
    
    private void mergeSortIn(int A[], int n ){
        if(n <=1)
            return;
        int m = n/2;
        int []B = new int[m];
        int []C = new int[n-m];
        copiarParteDeA(A, B, 0, m);
        copiarParteDeA(A, C, m, n);
        mergeSortIn(B, m);
        mergeSortIn(C, n-m);
        int b=0,  c=0;
        
        for(int a=0; a<n; a++){
            if(b<m && c<n-m){
                if(B[b] < C[c]){
                    A[a] = B[b];
                    b++;  
                }else{
                    A[a] = C[c];
                    c++;
                }
            }else if(b < m){
                A[a] = B[b];
                b++;
            }else{
                A[a] = C[c];
                c++;
            }
        }
    }
    
    public void quickSort(int []a){
        long startTime = System.nanoTime();
        quickSortIn(a, 0, a.length-1);
        long endTime = System.nanoTime();
        quickSortList.add("Nanosegundos: "+(endTime - startTime));
    }
    
    private void quickSortIn(int []a, int izq, int der){
        int pivote=a[izq]; 
        int i=izq;
        int j=der; 
 
        while(i<j){            
            while(a[i]<=pivote && i<j) 
                i++; 
            while(a[j]>pivote) 
                j--;       
            if (i<j)
                swap(a, i, j);
            
        }    
        a[izq]=a[j];
        a[j]=pivote; 
        if(izq<j-1)
            quickSortIn(a,izq,j-1); 
        if(j+1 <der)
            quickSortIn(a,j+1,der); 
        
    }
    
    private int N;
    
    public void heapSort(int []a){
        long startTime = System.nanoTime();
        heapify(a);        
        for (int i = N; i > 0; i--){
            swap(a,0, i);
            N = N-1;
            maxheap(a, 0);
        }
        long endTime = System.nanoTime();
        heapSortList.add("Nanosegundos: "+(endTime - startTime));
    }
    
    private void heapify(int []a){
        N = a.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(a, i);  
    }
    
    private void maxheap(int a[], int i){ 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && a[left] > a[i])
            max = left;
        if (right <= N && a[right] > a[max])        
            max = right;
 
        if (max != i){
            swap(a, i, max);
            maxheap(a, max);
        }
    } 
    
    public void radixSort(int a[]){
        long startTime = System.nanoTime();
        int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[n];
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        while (m / exp > 0){
            int[] bucket = new int[10];
 
            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            for (i = 0; i < n; i++)
                a[i] = b[i];
            exp *= 10;        
        }
        long endTime = System.nanoTime();
        radixSortList.add("Nanosegundos: "+(endTime - startTime));
    }
    
    private void copiarParteDeA(int []A, int []B, int a, int b){
        int c=0;
        for(int i=a; i<b; i++){
            B[c] = A[i];
            c++;
        }
    }
    private  void swap(int []a, int pos1, int pos2){
        int temp = a[pos1];
        a[pos1] = a[pos2];
        a[pos2] = temp;
    }
    
    
}
