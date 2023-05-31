package smartDevice;

public class SmartDevice {
    String marca;
    String modelo;
    String versionSO;
    Double precio;

    public SmartDevice() {
    }

    public SmartDevice(String marca, String modelo, String versionSO, Double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.versionSO = versionSO;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "SmartDevice{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", versionSO='" + versionSO + '\'' +
                ", precio=" + precio +
                '}';
    }
}
