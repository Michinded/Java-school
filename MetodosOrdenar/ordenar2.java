package MetodosOrdenar;

import java.util.Scanner;

import static java.util.Arrays.sort;

public class ordenar2 {

    public static void main(String[] args) {
        // Defines tu arreglo
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = sc.nextInt();
        long[] arreglo = new long[n];

        // Llena tu arreglo
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (long) (Math.random() * (20000 - 10000) + 10000);
        }

        // Usas los metodos para ordenar y mides el tiempo
        long inicio = System.nanoTime();
        Insercion(arreglo);
        long fin = System.nanoTime();
        long tiempo = fin - inicio;
        System.out.println("Tiempo de ejecución de ordenamiento por inserción: ");
        System.out.println("Tiempo de ejecución: " + tiempo + " nanosegundos");
        System.out.println("Tiempo de ejecución: " + tiempo/1000000 + " milisegundos");

        System.out.println("********************************************************************");

        //Se repite lo mismo para los siguientes metodos de ordenamiento


        //Ordenamiento por QuickSort
        long inicio1 = System.nanoTime();
        sort(arreglo, 0, arreglo.length - 1);
        long fin1 = System.nanoTime();
        long tiempo1 = fin1 - inicio1;
        System.out.println("Tiempo de ejecución de ordenamiento por QuickSort: ");
        System.out.println("Tiempo de ejecución: " + tiempo1 + " nanosegundos");
        System.out.println("Tiempo de ejecución: " + tiempo1/1000000 + " milisegundos");


    }
    public static void Insercion(long A[]) {
        long p, j;
        long aux;
        for (p = 1; p < A.length; p++){
            aux = A[(int) p];
            j = p - 1;
            while ((j >= 0) && (aux < A[(int) j])){
                // valor de aux sea menor que los
                A[(int) (j + 1)] = A[(int) j];
                j--;
            }
            A[(int) (j + 1)] = aux;
        }
    }

}
