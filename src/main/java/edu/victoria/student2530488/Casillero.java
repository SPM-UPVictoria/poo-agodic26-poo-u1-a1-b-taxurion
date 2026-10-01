package edu.victoria.student2530488;


public class Casillero {
    private String idCasillero;
    private String tamano;
    private boolean ocupado;
    private int codigoSeguridad;
    private double tarifaPorHora;
    private Paquete paqueteActual;

    public Casillero(String idCasillero, String tamano, double tarifaPorHora) {
        this.idCasillero = idCasillero;
        this.tamano = tamano;
        this.tarifaPorHora = tarifaPorHora;
        this.ocupado = false;
        this.paqueteActual = null;
        this.codigoSeguridad = -1;
    }

    public boolean depositarPaquete(Paquete paquete, int codigoSeguridad) {
        if (this.ocupado) {
            System.out.println("ERROR [" + idCasillero + "]: El casillero ya está ocupado.");
            return false;
        }
        if (paquete == null) {
            System.out.println("ERROR [" + idCasillero + "]: Paquete inválido.");
            return false;
        }

        this.paqueteActual = paquete;
        this.codigoSeguridad = codigoSeguridad;
        this.ocupado = true;
        System.out.println("DEPÓSITO EXITOSO [" + idCasillero + "]: Paquete " + paquete.getNumeroGuia() + " ingresado.");
        return true;
    }

    public Paquete retirarPaquete(int codigoIngresado, int horasEstadia) {
        if (!this.ocupado) {
            System.out.println("ERROR [" + idCasillero + "]: El casillero está vacío.");
            return null;
        }

        if (this.codigoSeguridad != codigoIngresado) {
            System.out.println("ACCESO DENEGADO [" + idCasillero + "]: Código de seguridad incorrecto.");
            return null;
        }

        double costoTotal = horasEstadia * tarifaPorHora;
        Paquete paqueteRetirado = this.paqueteActual;

        this.paqueteActual = null;
        this.codigoSeguridad = -1;
        this.ocupado = false;

        System.out.println("\n--------------------------------------------------");
        System.out.println("RETIRO EXITOSO [" + idCasillero + "]");
        System.out.println("Paquete entregado: " + paqueteRetirado);
        System.out.println("Horas de estadía: " + horasEstadia + " hrs");
        System.out.println("Tarifa/hora: $" + tarifaPorHora);
        System.out.println("TOTAL A COBRAR: $" + costoTotal);
        System.out.println("--------------------------------------------------\n");

        return paqueteRetirado;
    }

    public void mostrarFichaInformativa() {
        System.out.println("\n========= FICHA INFORMATIVA CASILLERO =========");
        System.out.println("ID Casillero : " + idCasillero);
        System.out.println("Tamaño       : " + tamano);
        System.out.println("Estado       : " + (ocupado ? "OCUPADO " : "LIBRE "));
        System.out.println("Tarifa/Hora  : $" + tarifaPorHora);
        if (ocupado) {
            System.out.println("Paquete      : " + paqueteActual);
        } else {
            System.out.println("Paquete      : N/A");
        }
        System.out.println("================================================");
    }

    public String getIdCasillero() { return idCasillero; }
    public String getTamano() { return tamano; }
    public boolean isOcupado() { return ocupado; }
    public double getTarifaPorHora() { return tarifaPorHora; }
}