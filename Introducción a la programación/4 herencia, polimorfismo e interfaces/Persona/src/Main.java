public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.edad = "27";
        cliente.nombre = "Matias";
        cliente.telefono = "3874512835";
        cliente.credito = 250.328;
        System.out.println("la edad es: " + cliente.edad + " el nombre es: " + cliente.nombre + " el telefono es: " + cliente.telefono + " el credito es: $" + cliente.credito);
        Trabajador trabajador = new Trabajador();
        trabajador.edad = "28";
        trabajador.nombre = "Dante";
        trabajador.telefono = "387535850";
        trabajador.salario = 150.000;
        System.out.println("la edad es: " + trabajador.edad + " el nombre es: " + trabajador.nombre + " el telefono es: " + trabajador.telefono + " el salario es: $" + trabajador.salario);
    }
}
class Persona{
    public String edad;
    public String nombre;
    public String telefono;

}

class Cliente extends Persona{
    public double credito;
}

class Trabajador extends  Persona{
    public double salario;
}