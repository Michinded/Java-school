package MetodosOrdenar;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.sort;

public class COrdenar {

    public static void division(){
        System.out.println();
        System.out.println();
        for (int i = 0; i <= 100; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException{
        long a = 10000, b = 20000;
        String metodo1 = "Inserción", metodo2 = "Burbuja", metodo3 = "Selección", metodo4 = "QuickSort";
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = sc.nextInt();
        long[] arreglo = new long[n];
        System.out.println();
        llenarArray(a, b, arreglo);
        long arreglo1[] = arreglo.clone();
        long arreglo2[] = arreglo.clone();
        long arreglo3[] = arreglo.clone();
        long arreglo4[] = arreglo.clone();
        division();

        //Ordenar Insercion
         OrdenarInsercion(arreglo);
         imprimirArray(arreglo, metodo1);
         division();

        //Ordenar Burbuja
        OrdenarBurbuja(arreglo1);
        imprimirArray(arreglo1, metodo2);
        division();

        //Ordenar por Seleccion
        OrdenarSeleccion(arreglo2);
        imprimirArray(arreglo2, metodo3);
        division();

        //Ordenar por QuickSort
        CallQuickSort(arreglo3);
        imprimirArray(arreglo3, metodo4);
        division();

        //QuickSort API
        QuickSortApi(arreglo3);
        imprimirArray(arreglo4, metodo4);


    }

    public static void llenarArray(long a, long b, long array[]) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (long) (Math.random() * (b - a) + a);
        }
    }
    public static void imprimirArray(long arreglo[], String metodo) {
        long cont = arreglo.length;
        System.out.println();
        System.out.println("Arreglo ordenado por "+metodo+": ");
        System.out.println("Cantidad de elementos: " + cont);
        System.out.println("Primeros 20 elementos: ");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]+", ");
            if (i >20) {
                break;
            }
        }

    }
    public static void Tiempo() throws InterruptedException{
        long inicio = System.nanoTime();
        TimeUnit.SECONDS.sleep(5);
        long fin = System.nanoTime();
        long tiempo = fin - inicio;
        System.out.println("Tiempo de ejecución: " + tiempo + " nanosegundos");
        System.out.println("Tiempo de ejecución: " + tiempo/1000000 + " milisegundos");
    }

    //Ordenar por Insercion
    public static void OrdenarInsercion(long array[]){
        //Ordenamiento por inserción
        long inicio = System.nanoTime();
        long aux;
        int j;
        for (int i = 1; i < array.length; i++) {
            aux = array[i];
            j = i - 1;
            while ((j >= 0) && (aux < array[j])) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = aux;
        }
        long fin = System.nanoTime();
        long tiempo = fin - inicio;
        System.out.println("Tiempo de ejecución de ordenamiento por inserción: ");
        System.out.println("Tiempo de ejecución: " + tiempo + " nanosegundos");
        System.out.println("Tiempo de ejecución: " + tiempo/1000000 + " milisegundos");
    }

    //Ordenamiento por burbuja
    public static void OrdenarBurbuja(long array[]){
        //Ordenamiento por burbuja
        long inicio = System.nanoTime();
        long aux;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
        long fin = System.nanoTime();
        long tiempo = fin - inicio;
        System.out.println("Tiempo de ejecución de ordenamiento por burbuja: ");
        System.out.println("Tiempo de ejecución: " + tiempo + " nanosegundos");
        System.out.println("Tiempo de ejecución: " + tiempo/1000000 + " milisegundos");
    }

    //Ordenamiento por seleccion
    public static void OrdenarSeleccion(long array[]){
        //Ordenamiento por selección
        long inicio = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    long aux = array[j];
                    array[j] = array[i];
                    array[i] = aux;
                }
            }
        }
        long fin = System.nanoTime();
        long tiempo = fin - inicio;
        System.out.println("Tiempo de ejecución de ordenamiento por selección: ");
        System.out.println("Tiempo de ejecución: " + tiempo + " nanosegundos");
        System.out.println("Tiempo de ejecución: " + tiempo/1000000 + " milisegundos");
    }

    public static void CallQuickSort(long array[]){
        long inicio = System.nanoTime();
        OrdenarQuickSort(array, 0, array.length-1);
        long fin = System.nanoTime();
        long tiempo = fin - inicio;
        System.out.println("Tiempo de ejecución de ordenamiento por QuickSort: ");
        System.out.println("Tiempo de ejecución: " + tiempo + " nanosegundos");
        System.out.println("Tiempo de ejecución: " + tiempo/1000000 + " milisegundos");
    }


    public static void OrdenarQuickSort(long array[],long inicio, long fin){
        long pivote = array[(int) inicio];
        long i = inicio;
        long j = fin;
        long aux;
        while(i<j)
        {
            while (array[(int) i] <= pivote && i < j)
                i++;

            while (array[(int) j] > pivote)
                j--;

            if (i<j)
            {
                aux = array[(int) i];
                array[(int) i]= array[(int) j];
                array[(int) j]=aux;
            }
        }
        array[(int) inicio] = array[(int) j];
        array[(int) j] = pivote;

        if (inicio < j-1)
            OrdenarQuickSort(array,inicio,j-1);

        if (j+1 < fin)
            OrdenarQuickSort(array,j+1,fin);
    }
    public static void QuickSortApi(long array[]){
        long inicio1 = System.nanoTime();
        sort(array, 0, array.length - 1);
        long fin1 = System.nanoTime();
        long tiempo1 = fin1 - inicio1;
        System.out.println("Tiempo de ejecución de ordenamiento por QuickSort API: ");
        System.out.println("Tiempo de ejecución: " + tiempo1 + " nanosegundos");
        System.out.println("Tiempo de ejecución: " + tiempo1/1000000 + " milisegundos");
    }
}
