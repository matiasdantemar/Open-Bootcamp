package smartDevice;

public class SmartPhone extends SmartDevice{
    private double tamañoPantalla;
    private int capacidadAlmacenamiento;


    public SmartPhone() {
    }

    public SmartPhone(String marca, String modelo, String versionSO, Double precio, double tamañoPantalla, int capacidadAlmacenamiento) {
        super(marca, modelo, versionSO, precio);
        this.tamañoPantalla = tamañoPantalla;
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "tamañoPantalla=" + tamañoPantalla +
                ", capacidadAlmacenamiento=" + capacidadAlmacenamiento +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", versionSO='" + versionSO + '\'' +
                ", precio=" + precio +
                '}';
    }
}
