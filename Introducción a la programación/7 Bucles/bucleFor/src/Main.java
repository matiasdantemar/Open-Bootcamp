public class Main {
    public static void main(String[] args) {
        String[] nombres = {"Matias", "Dante", "Martinez", "Ocampos"};
        String nombresConcatenados = "";

        for(String nombre : nombres){
            nombresConcatenados = nombresConcatenados + nombre + " ";
        }
        System.out.println(nombresConcatenados);
    }
}