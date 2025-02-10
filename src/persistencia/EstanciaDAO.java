package persistencia;

import entidades.Estancia;

import java.util.ArrayList;
import java.util.List;

public class EstanciaDAO extends DAO{
    public void create(Estancia estancia){
        String sql = "INSERT INTO estancias(id_cliente, id_casa, nombre_huesped,"+
                "fecha_desde, fecha_hasta) VALUES ("+
                estancia.getIdCliente()+", "+estancia.getIdCasa()+", '"+estancia.getNombreHuesped()+
                "', '"+ estancia.getFechaDesde()+"', '"+estancia.getFechaHasta()+"';";
        try {
            insertarModificarEliminarDataBase(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Estancia> findAll(){
        String sql = "SELECT * FROM estancias";
        List<Estancia> estancias = new ArrayList<>();
        try{
            consultarDataBase(sql);
            while(resultSet.next()){
                Estancia estancia = new Estancia();
                estancia.setIdEstancia(resultSet.getInt("id_estancia"));
                estancia.setIdCliente(resultSet.getInt("id_cliente"));
                estancia.setIdCasa(resultSet.getInt("id_casa"));
                estancia.setNombreHuesped(resultSet.getString("nombre_huesped"));
                estancia.setFechaDesde(resultSet.getDate("fecha_desde").toLocalDate());
                estancia.setFechaHasta(resultSet.getDate("fecha_hasta").toLocalDate());
                estancias.add(estancia);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return estancias;
    }
    public Estancia findById(int idEstancia){
        String sql= "SELECT * FROM estancias WHERE id_estancia = "+idEstancia+";";
        try{
            consultarDataBase(sql);
            Estancia estancia = new Estancia();
            while(resultSet.next()){
                estancia.setIdEstancia(resultSet.getInt("id_estancia"));
                estancia.setIdCliente(resultSet.getInt("id_cliente"));
                estancia.setIdCasa(resultSet.getInt("id_casa"));
                estancia.setNombreHuesped(resultSet.getString("nombre_huesped"));
                estancia.setFechaDesde(resultSet.getDate("fecha_desde").toLocalDate());
                estancia.setFechaHasta(resultSet.getDate("fecha_hasta").toLocalDate());
            }
            return estancia;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int idEstancia){
        String sql = "DELETE FROM estancias WHERE id_estancia = "+  idEstancia+ ";";
        try{
            insertarModificarEliminarDataBase(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
