package smartDevice;

public class SmartWatch extends SmartDevice {
    private String materialCorrea;
    private boolean isResistenteAgua;
    private int duracionBateria;

    public SmartWatch() {
    }

    public SmartWatch(String marca, String modelo, String versionSO, Double precio, String materialCorrea, boolean isResistenteAgua, int duracionBateria) {
        super(marca, modelo, versionSO, precio);
        this.materialCorrea = materialCorrea;
        this.isResistenteAgua = isResistenteAgua;
        this.duracionBateria = duracionBateria;
    }

    @Override
    public String toString() {
        return "SmartWatch{" +
                "materialCorrea='" + materialCorrea + '\'' +
                ", isResistenteAgua=" + isResistenteAgua +
                ", duracionBateria=" + duracionBateria +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", versionSO='" + versionSO + '\'' +
                ", precio=" + precio +
                '}';
    }
}
