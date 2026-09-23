package datos;

import java.time.LocalDateTime;

public class Bicicletas {
    private int serial;
    private String color;
    private Propietario idpropietario;
    private LocalDateTime horaEntrada;

    public Bicicletas(int serial, String color, Propietario idpropietario) {
        this.serial = serial;
        this.color = color;
        this.idpropietario = idpropietario;
        this.horaEntrada = LocalDateTime.now();
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Propietario getIdpropietario() {
        return idpropietario;
    }

    public void setIdpropietario(Propietario idpropietario) {
        this.idpropietario = idpropietario;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
}