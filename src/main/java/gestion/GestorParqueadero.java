package gestion;

import datos.Bicicletas;
import datos.Pago;
import datos.Propietario;

import java.time.Duration;
import java.time.LocalDateTime;

public class GestorParqueadero {

    private int cupos;
    private double precio;
    private double ingresosTotales;
    private int contadorDeBicicletas;
    private int bicicletasActivas;
    private Bicicletas[] listaBicicletas;
    private LocalDateTime horaSalida;

    public GestorParqueadero() {
        this.cupos = 20;
        this.precio = 10.0;
        this.ingresosTotales = 0.0;
        this.contadorDeBicicletas = 0;
        this.bicicletasActivas = 0;
        this.listaBicicletas = new Bicicletas[20];
    }

    public boolean adicionarBicicleta(int serial, String color, int idpropietario) {

        if (bicicletasActivas >= cupos) {
            System.out.println("No hay cupos disponibles.");
            return false;
        }

        for (int i = 0; i < listaBicicletas.length; i++) {

            if (listaBicicletas[i] == null) {

                Propietario propietario =
                        new Propietario("Propietario " + idpropietario, idpropietario);

                listaBicicletas[i] =
                        new Bicicletas(serial, color, propietario);

                bicicletasActivas++;
                contadorDeBicicletas++;

                return true;
            }
        }

        return false;
    }

    public boolean registroSalidaDeBicicletas(int idPropietario, Pago pago) {

        for (int i = 0; i < listaBicicletas.length; i++) {

            if (listaBicicletas[i] != null &&
                    listaBicicletas[i].getIdpropietario().getIdentificacion()
                            == idPropietario) {

                horaSalida = LocalDateTime.now();

                long minutos =
                        Duration.between(
                                listaBicicletas[i].getHoraEntrada(),
                                horaSalida
                        ).toMinutes();

                if (minutos <= 0) {
                    minutos = 1;
                }

                double totalCobro = minutos * precio;

                ingresosTotales += totalCobro;

                listaBicicletas[i] = null;

                bicicletasActivas--;

                System.out.println(
                        "Salida registrada con exito. " +
                                "Pago realizado con: " + pago +
                                ". Total a pagar: $" + totalCobro
                );

                return true;
            }
        }

        System.out.println(
                "No se encontro ninguna bicicleta con el ID de propietario ingresado."
        );

        return false;
    }

    public Pago opcionPago() {
        return Pago.EFECTIVO;
    }

    public void mostrarReporte() {

        System.out.println("--- REPORTE DEL DIA ---");

        System.out.println(
                "Numero de bicicletas ingresadas hoy: "
                        + contadorDeBicicletas
        );

        System.out.println(
                "Bicicletas actualmente en el parqueadero: "
                        + bicicletasActivas
        );

        System.out.println(
                "Valor total ingresado: $"
                        + ingresosTotales
        );
    }

    public int getCupos() {
        return cupos;
    }

    public double getPrecio() {
        return precio;
    }

    public double getIngresosTotales() {
        return ingresosTotales;
    }

    public int getContadorDeBicicletas() {
        return contadorDeBicicletas;
    }

    public int getBicicletasActivas() {
        return bicicletasActivas;
    }

    public Bicicletas[] getListaBicicletas() {
        return listaBicicletasa;
    }
}