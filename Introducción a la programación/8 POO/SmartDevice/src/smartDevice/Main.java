package smartDevice;

public class Main {
    public static void main(String[] args) {
        SmartPhone samsungJ7 = new SmartPhone("Samsung", "J7", "android 7", 79999.99, 5.5, 50);

        SmartWatch amazfit = new SmartWatch("amazfit", "Bip 3", "android 6", 39999.99, "cuero", true, 40);

        System.out.println(samsungJ7.toString());
        System.out.println(amazfit.toString());
    }



}
