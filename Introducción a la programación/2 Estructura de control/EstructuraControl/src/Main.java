public class Main {
    public static void main(String[] args) {
        int numeroIf = -1;

        if (numeroIf == 0) System.out.println("es igual a 0");
        else if (numeroIf > 0) System.out.println("es positivo");
        else System.out.println("es negativo");


        int numeroWhile = 0;

        while (numeroWhile < 3){
            System.out.println(++numeroWhile);
        }

        do{
            System.out.println(++numeroWhile);
        }while (numeroWhile > 4);{
            System.out.println(numeroWhile);
        }

        for(int numeroFor  = 0; numeroFor <= 3; numeroFor++){
            System.out.println(numeroFor);
        }


        String estacion = "INVIERNO".toLowerCase();

        switch (estacion){
            case "verano":
                System.out.println(estacion);
                break;
            case "invierno":
                System.out.println(estacion);
                break;
            case "primavera":
                System.out.println(estacion);
                break;
            case "oroño":
                System.out.println(estacion);
                break;
            default:
                System.out.println("Estacion incorrecta");
        }


    }
}