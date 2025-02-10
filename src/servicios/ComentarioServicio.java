package servicios;

import entidades.Comentario;
import persistencia.ComentarioDAO;

import java.sql.SQLException;
import java.util.List;

public class ComentarioServicio {
    CasaServicio casaServicio = new CasaServicio();
    private ComentarioDAO comentarioDAO;
    public ComentarioServicio(){
        this.comentarioDAO= new ComentarioDAO();
    }

    public Comentario crearComentario(int idCasa, String comentario)throws Exception{
        //validar que idCasa exista y el comentario no este vacio
        validarCrearComentario(idCasa, comentario);
        Comentario nuevoComentario = new Comentario(idCasa, comentario);
        comentarioDAO.create(nuevoComentario);
        return nuevoComentario;
    }

    //hace falta un listarComentarios por idCasa
    public List<Comentario> listarComentarios(){
        return comentarioDAO.findAll();
    }
    public Comentario buscarComentarioPorId(int idComentario)throws SQLException {
        return comentarioDAO.findById(idComentario);
    }
    public void eliminarComentarioPorID(int idComentario)throws SQLException{
        comentarioDAO.delete(idComentario);
        System.out.println("Comentario con id "+idComentario+" eliminado con éxito");
    }
    public void validarCrearComentario(int idCasa, String comentario)throws Exception{
       /* if(casaServicio.buscarCasaPorId(idCasa) == null){
           throw new Exception("No existe una casa con id "+idCasa);
        }

        */
        if (comentario == null || comentario.trim().equalsIgnoreCase("")){
            throw new Exception("El comentario no puede estar vacío");
        }
    }
}
