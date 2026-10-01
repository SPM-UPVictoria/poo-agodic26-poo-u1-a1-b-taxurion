package edu.victoria.student2530488;

public class App {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA SMARTLOCKER EXPRESS ===\n");

        Casillero casillero1 = new Casillero("L-101", "Mediano", 25.0);
        Casillero casillero2 = new Casillero("L-102", "Grande", 40.0);

        Paquete paquete1 = new Paquete("MX-8821", "Carlos Gómez", 3.5);
        Paquete paquete2 = new Paquete("MX-9943", "Ana Martínez", 8.2);

        casillero1.mostrarFichaInformativa();

        System.out.println("\n--- SIMULACIÓN DE DEPÓSITO ---");
        int pinSeguridad = 4821;
        casillero1.depositarPaquete(paquete1, pinSeguridad);

        casillero1.depositarPaquete(paquete2, 1234);

        casillero1.mostrarFichaInformativa();

        System.out.println("\n--- SIMULACIÓN DE INTENTO FALLIDO DE RETIRO ---");
        int pinIncorrecto = 1111;
        casillero1.retirarPaquete(pinIncorrecto, 5);

        casillero1.mostrarFichaInformativa();

        System.out.println("\n--- SIMULACIÓN DE RETIRO EXITOSO ---");
        int horasEstadia = 6;
        Paquete paqueteEntregado = casillero1.retirarPaquete(pinSeguridad, horasEstadia);

        casillero1.mostrarFichaInformativa();
    }
}