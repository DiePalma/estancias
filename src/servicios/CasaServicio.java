package servicios;
import entidades.Casa;
import persistencia.CasaDAO;
import persistencia.ClienteDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CasaServicio {
    private CasaDAO cd;
    public CasaServicio() {
        this.cd = new CasaDAO();
    }

    public Casa crearNuevaCasa(String calle, int numero, String codigoPostal, String ciudad, String pais, LocalDate fechaDesde, LocalDate fechaHasta, int tiempoMinimo, int tiempoMaximo, double precioHabitacion, String tipoVivienda) throws Exception {
        // Validaciones - Pueden estar metodo independiente.
        validacionesCasa(ciudad, pais, fechaDesde, fechaHasta, tiempoMinimo, tipoVivienda);

        Casa casa = new Casa(calle, numero, codigoPostal, ciudad, pais, fechaDesde, fechaHasta, tiempoMinimo, tiempoMaximo, precioHabitacion, tipoVivienda);
        cd.create(casa);
        return casa;
    }

    public void validacionesCasa( String ciudad, String pais, LocalDate fechaDesde, LocalDate fechaHasta, int tiempoMinimo, String tipoVivienda) throws Exception {

        if(ciudad == null || pais == null || tipoVivienda == null){
            throw new Exception("El campo no puede ser nulo");
        }
        if (tiempoMinimo <=0){
            throw new Exception("El tiempo mínimo debe ser mayor a  0");
        }
        if (fechaHasta.isBefore(fechaDesde)){
            throw new Exception("La fecha de inicio no puede ser anterior a la fecha de fin");
        }
    }
    public List<Casa> ejercicioDos(){
        List<Casa>allCasas = cd.findAll();
        List<Casa> filtradas = new ArrayList<>();
        for(Casa c: allCasas){
            if(c.getPais().equalsIgnoreCase("reino unido")){
                if(c.getFechaDesde().isEqual(LocalDate.parse("2020-08-01"))&&(c.getFechaHasta().isEqual(LocalDate.parse("2020-08-31")))){
                    filtradas.add(c);
                }
            }
        }
        return filtradas;
    }
    public List<Casa> ejercicioCuatro(LocalDate fecha, long dias){
        List<Casa> filtradas = new ArrayList<>();
        for(Casa c: cd.findAll()){
            if(c.getFechaDesde().isBefore(fecha) && c.getFechaHasta().isAfter(fecha.plusDays(dias))){

                    filtradas.add(c);


            }
        }
        return filtradas;
    }
}
