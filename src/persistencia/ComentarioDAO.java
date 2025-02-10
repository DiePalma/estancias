package persistencia;

import entidades.Comentario;

import java.util.ArrayList;
import java.util.List;

public class ComentarioDAO extends DAO{
    public void create(Comentario comentario){
        String sql="INSERT INTO comentarios (id_casa, comentario) VALUES ("+
                comentario.getIdCasa()+", '"+comentario.getComentario()+"');";
        try{
            insertarModificarEliminarDataBase(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Comentario> findAll(){
        String sql = "SELECT * FROM comentarios;";
        List<Comentario> comentarios = new ArrayList<>();
        try {
            consultarDataBase(sql);
            while (resultSet.next()){
                Comentario comentario = new Comentario();
                comentario.setIdComentario(resultSet.getInt("id_comentario"));
                comentario.setIdCasa(resultSet.getInt("id_casa"));
                comentario.setComentario(resultSet.getString("comentario"));
                comentarios.add(comentario);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return comentarios;
    }
    public Comentario findById(int idComentario){
        String sql = "SELECT * FROM comentarios where id_comentario = "+ idComentario+";";
        try{
            consultarDataBase(sql);
            Comentario comentario = new Comentario();
            while(resultSet.next()){
                comentario.setIdComentario(resultSet.getInt("id_comentario"));
                comentario.setIdCasa((resultSet.getInt("id_casa")));
                comentario.setComentario((resultSet.getString("comentario")));
            }
            return comentario;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int idComentario){
        String sql = "DELETE FROM comentario WHERE id_comentario= "+ idComentario+";";
        try{
            insertarModificarEliminarDataBase(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
