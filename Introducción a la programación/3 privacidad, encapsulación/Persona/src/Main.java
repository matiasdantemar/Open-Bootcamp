public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setNombre("Matias");
        persona.setTelefono("3875358711");
        persona.setEdad("27");
        System.out.println("nombre: " + persona.getNombre() + " telefono: " + persona.getTelefono()
                + " edad: " + persona.getEdad());
    }
}
class Persona{
        private String edad;
        private String nombre;
        private String telefono;

        public void setEdad(String edad){
            this.edad = edad;
        }

        public String getEdad(){
            return this.edad;
        }

        public void setNombre(String nombre){
            this.nombre = nombre;
        }

        public String getNombre(){
            return this.nombre;
        }

        public void setTelefono(String telefono){
            this.telefono = telefono;
        }

        public String getTelefono(){
            return  this.telefono;
        }
        
}

