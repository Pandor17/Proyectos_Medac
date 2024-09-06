public class Quicksort {
public static void quicksort(int[] A,int izquierdo,int derecho){
    int pivote = A[izquierdo];
    int i = izquierdo;
    int j = derecho;
    int aux;

    while(i<j){
        while(A[i]<=pivote && i<j){i++;}
        while(A[j]>pivote){j--;}
        if(i<j){
            aux = A[i];
            A[i] = A[j];
            A[j] = aux;
        }
    }

    A[izquierdo]=A[j];
    A[j]=pivote;

    if(izquierdo<j-1){
        quicksort(A,izquierdo,j-1);
    }
    if(j+1<derecho){
        quicksort(A,j+1,derecho);
    }
}
}
