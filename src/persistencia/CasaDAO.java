package persistencia;

import entidades.Casa;

import java.util.ArrayList;
import java.util.List;

public class CasaDAO extends DAO{
    public void create(Casa casa){
        String sql = "INSERT INTO casas ("+
                "calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta"+
                "tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda VALUES('"+
                casa.getCalle()+"', "+ casa.getNumero()+",'"+ casa.getCodigoPostal()+"', '"+
                casa.getCiudad()+"', '"+casa.getPais()+"', '"+casa.getFechaDesde()+"', '"+
                casa.getFechaHasta()+"', "+casa.getTiempoMinimo()+", "+casa.getTiempoMaximo()+
                ", "+casa.getPrecioHabitacion()+", '"+casa.getTipoVivienda()+"');";
        try{
            insertarModificarEliminarDataBase(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Casa>findAll(){
        String sql = "SELECT * FROM casas;";
        List<Casa> casas = new ArrayList<>();
        try{
            consultarDataBase(sql);
            while (resultSet.next()){
                Casa casa = new Casa();
                casa.setIdCasa(resultSet.getInt("id_casa"));
                casa.setCalle(resultSet.getString("calle"));
                casa.setCodigoPostal(resultSet.getString("codigo_postal"));
                casa.setCiudad(resultSet.getString("ciudad"));
                casa.setPais(resultSet.getString("pais"));
                casa.setFechaDesde(resultSet.getDate("fecha_desde").toLocalDate());
                casa.setFechaHasta(resultSet.getDate("fecha_hasta").toLocalDate());
                casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
                casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
                casa.setPrecioHabitacion(resultSet.getDouble("precio_habitacion"));
                casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));
                casas.add(casa);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return casas;
    }
    public Casa findById(int idCasa){
        String sql = "SELECT * FROM casas where id_casa = "+idCasa+";";
        try{
            consultarDataBase(sql);
            Casa casa = new Casa();
            while (resultSet.next()){
                casa.setIdCasa(resultSet.getInt("id_casa"));
                casa.setCalle(resultSet.getString("calle"));
                casa.setCodigoPostal(resultSet.getString("codigo_postal"));
                casa.setCiudad(resultSet.getString("ciudad"));
                casa.setPais(resultSet.getString("pais"));
                casa.setFechaDesde(resultSet.getDate("fecha_desde").toLocalDate());
                casa.setFechaHasta(resultSet.getDate("fecha_hasta").toLocalDate());
                casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
                casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
                casa.setPrecioHabitacion(resultSet.getDouble("precio_habitacion"));
                casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));
            }
            return casa;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int idCasa){
        String sql = "DELETE FROM casas WHERE id_casa = "
        +idCasa+";";
        try {
            insertarModificarEliminarDataBase(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
