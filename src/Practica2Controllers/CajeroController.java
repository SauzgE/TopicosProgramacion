package Practica2Controllers;

import java.util.Scanner;
import Practica2Models.Usuario;
import Practica2View.CajeroView;

public class CajeroController {

    private Usuario[] usuarios;
    private CajeroView view;
    private Scanner scanner;

    public CajeroController() {
        usuarios = new Usuario[]{
                new Usuario("1234", "Juan", 1000),
                new Usuario("5678", "Maria", 2500)
        };
        view = new CajeroView();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        view.mostrarBienvenida();
        Usuario usuario = autenticar();

        if (usuario == null) {
            view.mostrarMensaje("Demasiados intentos fallidos. Adiós ....");
            return;
        }

        view.mostrarMensaje("Bienvenido, " + usuario.getNombre());
        menu(usuario);
    }

    private Usuario autenticar() {
        int intentos = 0;

        while (intentos < 3) {
            view.pedirPin();
            String pin = scanner.nextLine();

            for (Usuario u : usuarios) {
                if (u.validarPin(pin)) {
                    return u;
                }
            }

            view.mostrarMensaje("PIN incorrecto.");
            intentos++;
        }
        return null;
    }

    private void menu(Usuario usuario) {
        boolean salir = false;

        while (!salir) {
            view.mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    view.mostrarMensaje("Saldo: $" + usuario.getSaldo());
                    break;
                case 2:
                    view.mostrarMensaje("Cantidad a retirar:");
                    double retiro = scanner.nextDouble();
                    if (usuario.retirar(retiro)) {
                        view.mostrarMensaje("Retiro exitoso.");
                    } else {
                        view.mostrarMensaje("Fondos insuficientes.");
                    }
                    break;
                case 3:
                    view.mostrarMensaje("Cantidad a depositar:");
                    double deposito = scanner.nextDouble();
                    usuario.depositar(deposito);
                    view.mostrarMensaje("Depósito exitoso.");
                    break;
                case 4:
                    salir = true;
                    view.mostrarMensaje("Gracias por usar el cajero.");
                    break;
                default:
                    view.mostrarMensaje("Opción inválida.");
            }
        }
    }
}

