package servicios;

import entidades.Estancia;
import persistencia.EstanciaDAO;

import java.time.LocalDate;

public class EstanciaServicio {
    private EstanciaDAO ed;

    public EstanciaServicio() {
        this.ed = new EstanciaDAO();
    }

    public Estancia crearNuevaEstancia(int idCliente, int idCasa, String nombreHuesped, LocalDate fechaDesde, LocalDate fechaHasta) throws Exception {

        validarDatosEstancia(idCliente, idCasa, nombreHuesped, fechaDesde, fechaHasta);

        Estancia estancia = new Estancia(idCliente, idCasa, nombreHuesped, fechaDesde, fechaHasta);
        ed.create(estancia);
        return estancia;
    }

    private void validarDatosEstancia(int idCliente, int idCasa, String nombreHuesped, LocalDate fechaDesde, LocalDate fechaHasta) throws Exception {
        if (idCliente <= 0) {
            throw new Exception("El ID del cliente no puede ser menor o igual a 0.");
        }
        if (idCasa <= 0) {
            throw new Exception("El ID de la casa no puede ser menor o igual a 0.");
        }
        if (nombreHuesped == null || nombreHuesped.trim().isEmpty()) {
            throw new Exception("El nombre del huésped no puede estar vacío.");
        }
        if (fechaDesde == null || fechaHasta == null) {
            throw new Exception("Las fechas no pueden ser nulas.");
        }
        if (fechaDesde.isAfter(fechaHasta)) {
            throw new Exception("La fecha de inicio debe ser anterior a la fecha de fin.");
        }
    }
}