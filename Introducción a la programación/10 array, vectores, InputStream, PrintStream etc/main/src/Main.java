import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        System.out.println("Escribe el código que devuelva una cadena al revés. Por ejemplo, la cadena hola mundo, debe retornar odnum aloh.");
        System.out.println(reverse("hola mundo"));

        System.out.println("1. Crea un array unidimensional de Strings y recórrelo, mostrando únicamente sus valores.");
        String[] arrayString = new String[]{ "matias", "dante", "martinez"};

        for(String array: arrayString) {
            System.out.println(array);
        }

        System.out.println("2. Crea un array bidimensional de enteros y recórrelo, mostrando la posición y el valor de cada elemento en ambas dimensiones.");
        int[][] arrayBidimInt = new int[][]{
                {1,20,30},
                {40,50,60},
                {40,50}
        };
        for(int j=0; j < arrayBidimInt.length; j++) {
            for(int k=0; k  < arrayBidimInt[j].length; k++) {
                System.out.println("posicion: " + j + " "  + k +  " valor: "+ arrayBidimInt[j][k]);
            }
        }

        System.out.println("3. Crea un Vector del tipo de dato que prefieras, y añádele 5 elementos. Elimina el 2o y 3er elemento y muestra el resultado final.");
        Vector <String> vectorString = new Vector<>();
        vectorString.add("Matias");
        vectorString.add("Dante");
        vectorString.add("Martinez");
        vectorString.add("Jose");
        vectorString.add("David");

        vectorString.remove(2);
        vectorString.remove(3);

        for(String vector: vectorString){
            System.out.println(vector);
        }

        /*4. Indica cuál es el problema de utilizar un Vector con la capacidad por defecto: Si tuviésemos 1000 elementos para ser añadidos al mismo.
        el problema que presenta seria que ocuparia muchos recursos, memoria y disco, por que al sobrepasar el valor por defecto del vector que es 10
        se crea una copia del array, es recomendable especificar una capacidad inicial adecuada al crear el Vector, de manera que se reserve suficiente espacio
        en memoria desde el principio*/

        System.out.println("5. Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList. Recorre ambos mostrando únicamente el valor de cada elemento.");

        ArrayList<String> arrayListString = new ArrayList<>();
        arrayListString.add("Hola");
        arrayListString.add(" Como");
        arrayListString.add(" estas");
        arrayListString.add("?");

        LinkedList<String> LinkedListListString = new  LinkedList<>(arrayListString);
        System.out.println("Contenido con el ArrayList");
        for (String arrayList: arrayListString) {
            System.out.println(arrayList);
        }

        System.out.println("Contenido con el LinkedList");
        for (String linkedList: LinkedListListString) {
            System.out.println(linkedList);
        }

        System.out.println("6. Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10. A continuación, con otro bucle, recórrelo y elimina los numeros pares.\n" +
                "Por último, vuelve a recorrerlo y muestra el ArrayList final Si te atreves, puedes hacerlo en menos pasos, siempre y cuando cumplas el primer for de relleno.");

        ArrayList<Integer> arrayListInteger = new ArrayList<>();

        for(int i = 1; i < 10;i++){
            arrayListInteger.add(i);
        }

        for (int i = arrayListInteger.size() - 1; i >= 0; i--) {
            if (arrayListInteger.get(i) % 2 == 0) {
                arrayListInteger.remove(i);
            }else{
                System.out.println(arrayListInteger.get(i));
            }
        }


        System.out.println("Crea una función DividePorCero. Esta, debe generar una excepción (\"throws\") a su llamante del tipo ArithmeticException que será capturada por su llamante (desde \"main\", por ejemplo). " +
                "\nSi se dispara la excepción, mostraremos el mensaje \"Esto no puede hacerse\". Finalmente, mostraremos en cualquier caso: \"Demo de código\".");

        try {
            DividePorCero(1, 0);
        } catch (ArithmeticException e) {
            System.out.println("Esto no puede hacerse");
        } finally {
            System.out.println("Demo de código");
        }

        System.out.println("8. Utilizando InputStream y PrintStream, crea una función que reciba dos parámetros: \"fileIn\" y \"fileOut\". " +
                "\nLa tarea de la función será realizar la copia del fichero dado en el parámetro \"fileIn\" al fichero dado en \"fileOut\".");

        String inputFile = "archivo.txt";
        String outputFile = "copia.txt";

        copiarFichero(inputFile, outputFile);

        System.out.println("9. Sorpréndenos creando un programa de tu elección que utilice InputStream, PrintStream, excepciones, un HashMap y un ArrayList, LinkedList o array.");
        System.out.println("a concluir");

    }
    public static String reverse(String texto){
        StringBuilder textreverse = new StringBuilder();
        for(int i = texto.length()-1; i >= 0; i--) {
            textreverse.append(texto.charAt(i));
        }
        return textreverse.toString();
    }

    public static int DividePorCero(int dividendo, int divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException();
        }
        int resultado = dividendo / divisor;
        System.out.println("El resultado de la división es: " + resultado);
        return resultado;
    }

    public static void copiarFichero(String fileIn, String fileOut) {
        try {
            FileInputStream fis = new FileInputStream(fileIn);
            PrintStream ps = new PrintStream(new FileOutputStream(fileOut));

            int data;
            while ((data = fis.read()) != -1) {
                ps.write(data);
            }

            fis.close();
            ps.close();
            System.out.println("Copia de archivo completada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

