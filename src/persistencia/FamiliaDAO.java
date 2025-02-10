package persistencia;

import entidades.Familia;

import java.util.ArrayList;
import java.util.List;

public class FamiliaDAO extends DAO{
    public void create(Familia familia){
        String sql = "INSERT INTO familias (" +
                "nombre, edad_minima, edad_maxima, num_hijos, email, id_casa_familia" +
                ")" +
                "VALUES ('" + familia.getNombre() +  "', " +familia.getEdadMinima()+
                ", " + familia.getEdadMaxima()+ ", " + familia.getNumHijos() + ", '" +
                familia.getEmail() + ");";

        try {
            insertarModificarEliminarDataBase(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public List<Familia> findAll(){
        String sql = "SELECT id_familia, nombre, edad_minima, edad_maxima, num_hijos, email, id_casa_familia FROM familias;";
        List<Familia> familias = new ArrayList<>();
        try {
            consultarDataBase(sql);
            while (resultSet.next()){
                Familia familia = new Familia();
                familia.setIdFamilia(resultSet.getInt("id_familia"));
                familia.setNombre(resultSet.getString("nombre"));
                familia.setEdadMinima(resultSet.getInt("edad_minima"));
                familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
                familia.setNumHijos(resultSet.getInt("num_hijos"));
                familia.setEmail(resultSet.getString("email"));
                familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));
                familias.add(familia);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return familias;
    }
    public Familia findById(int idFamilia){
        String sql = "SELECT * FROM familias WHERE id_familia = " + idFamilia + ";";

        try {
            consultarDataBase(sql);

            Familia familia = new Familia();
            while (resultSet.next()){
                familia.setIdFamilia(resultSet.getInt("id_familia"));
                familia.setNombre(resultSet.getString("nombre"));
                familia.setEdadMinima(resultSet.getInt("edad_minima"));
                familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
                familia.setNumHijos(resultSet.getInt("num_hijos"));
                familia.setEmail(resultSet.getString("email"));
                familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));

            }

            return familia;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
     public void delete(int idFamilia){
        String sql = "DELETE FROM familias WHERE id_familia = "+  idFamilia+ ";";
        try{
            insertarModificarEliminarDataBase(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
     }
}
