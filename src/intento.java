import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;



public class naour_01 {
    static Scanner keyboard = new Scanner(System.in);
    private static long time0, time1, time2, time3, time4;

    public static void main (String [] args ){
        int dim;
        dim = dimValidation();

        int [] vector1 = new int [dim];

        fillVector(vector1);
        ShowVector(vector1," Vector con números al azar", time0);

        int [] vector2 = new int [dim];

        vector2 = sortlesttogreatest(vector1);

        ShowVector(vector2," vector ordenado de menor a mayor", time1);

        int [] vector3 = new int [dim];

        vector3 = sortgreatesttoleast(vector1);

        ShowVector(vector3, " Vector ordenado de mayor a menor",time2);
        int [] vector4 = new int[dim];
        vector4 = vector1;

        arraySort (vector4);

        ShowVector(vector4, "vector ordenado de menor a mayor.", time3);

        int[] vector5 = new int[dim];

        vector5 = vector4;

        arrayReverse (vector5);

        ShowVector(vector5, "vector ordenado de mayor a menor.",time4);
    }



    private static int Readnumber(){
        int num=0;
        System.out.println("ingrese la cantidad de números para el arreglo");
        do{
            try{
                num=keyboard.nextInt();
            }
            catch(InputMismatchException ime){
                System.out.println("Solo puedes insertar números enteros");
                keyboard.next();
                num=-1;
            }
        }
        while(num<0);
        return num;
    }

    private static int dimValidation(){
        int d=0;

        while(d<1 ){
            d = Readnumber();
            if(d<1 ){
                System.out.println("La dimensión solo puede ser un entero mayor o igual a 1");
            }
        }

        return d;
    }

    private static void fillVector(int vec[]){
        long startTime= System.nanoTime();
        Random azar = new Random();
        int i=0;
        while (i<vec.length) {
            vec[i]=azar.nextInt(100);
            i++;
        }
        long endTime = System.nanoTime();
        time0= endTime-startTime;
    }



    private static int [] sortlesttogreatest(int[] vec){
        long startTime= System.nanoTime();

        int c , d, length, swap;
        length = vec.length;

        for (c = 0; c < ( length - 1 ); c++) {
            for (d = 0; d < length - c - 1; d++) {
                if (vec[d] >  vec[d+1])
                {
                    swap       = vec[d];
                    vec[d]   = vec[d+1];
                    vec[d+1] = swap;
                }
            }
        }
        long endTime = System.nanoTime();
         time1 = endTime-startTime;
        return vec;
    }

    public static int [] sortgreatesttoleast(int [] vec){
        long startTime= System.nanoTime();


        int c , d, length, swap;
        length = vec.length;

        for (c = 0; c < ( length - 1 ); c++) {
            for (d = 0; d < length - c - 1; d++) {
                if (vec[d] <  vec[d+1])
                {
                    swap       = vec[d];
                    vec[d]   = vec[d+1];
                    vec[d+1] = swap;
                }
            }
        }
        long endTime = System.nanoTime();
        time2= endTime-startTime;
        return vec;
    }

    public static void arraySort(int[] vec) {
        long startTime= System.nanoTime();
        Arrays.sort(vec);
        long endTime = System.nanoTime();
        time3= endTime-startTime;

    }

     private static void arrayReverse(int[] vec) {
        long startTime= System.nanoTime();
        Arrays.sort(vec , Collections.reverseOrder());
        long endTime = System.nanoTime();
        time4= endTime-startTime;
        }

    private static void ShowVector(int[] vec, String txt, long time) {
        System.out.println( "\n"+ txt);
        System.out.println(Arrays.toString(vec));
        System.out.println(" El tiempo de ejecución fue de "+ time +" nanosegundos.");
    }

}







