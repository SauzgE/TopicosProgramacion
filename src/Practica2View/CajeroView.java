package Practica2View;
public class CajeroView {

    public void mostrarBienvenida() {
        System.out.println("=== Bienvenido ===");
    }

    public void pedirPin() {
        System.out.print("Ingrese su PIN: ");
    }

    public void mostrarMenu() {
        System.out.println("\n1. Ver saldo");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Depositar dinero");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
