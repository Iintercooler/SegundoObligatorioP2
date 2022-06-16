package practico_ejercicio8;

public class Practico_ejercicio8 {

    public static void main(String[] args) {
        muestro(5);
    }

    public static void muestro(int n) {
        System.out.println(n);
        
        if (n > 0) {
            muestro(n - 1);
        }
        System.out.println(n);

    }

}
