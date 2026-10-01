package edu.victoria.student2530488;


public class Paquete {
    private String numeroGuia;
    private String destinatario;
    private double pesoKg;

    public Paquete(String numeroGuia, String destinatario, double pesoKg) {
        this.numeroGuia = numeroGuia;
        this.destinatario = destinatario;
        this.pesoKg = pesoKg;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    @Override
    public String toString() {
        return "Guía: " + numeroGuia + " | Destinatario: " + destinatario + " | Peso: " + pesoKg + " kg";
    }
}