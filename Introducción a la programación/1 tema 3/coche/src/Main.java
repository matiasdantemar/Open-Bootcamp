// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Coche peugot = new Coche();
        peugot.incrementPuertas();
        peugot.incrementPuertas();
        System.out.println(peugot.numPuertas);
    }
}
    class Coche{
    int numPuertas = 0;

    public void incrementPuertas(){
        this.numPuertas++;
    }
}
