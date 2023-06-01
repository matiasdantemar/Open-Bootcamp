package Interfaz;

public class main {

    public static void main(String[] args) {
        CocheCRUD cocheCrud = new CocheCRUDImpl();
        cocheCrud.save();
        cocheCrud.delete();
        cocheCrud.findAll();
    }
}
