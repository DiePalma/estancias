package servicios;


import entidades.Familia;
import persistencia.FamiliaDAO;

import java.util.ArrayList;
import java.util.List;


public class FamiliaServicio {
    private FamiliaDAO fd;
    public FamiliaServicio() {
        this.fd = new FamiliaDAO();
    }

    public Familia crearNuevaFamilia(String nombre, int edadMinima, int edadMaxima, int numHijos, String email, int idCasaFamilia) throws Exception {
        // Validaciones - Pueden estar metodo independiente.
        validacionesNyE(nombre, email);

        Familia familia = new Familia(nombre, edadMinima, edadMaxima, numHijos, email, idCasaFamilia);
        fd.create(familia);
        return familia;
    }

    public void validacionesNyE(String nombre, String email) throws Exception {
        if (nombre == null) {
            throw new Exception("El nombre del contacto no puede ser nulo.");
        }
        if (email == null) {
            throw new Exception("El apellido del contacto no puede ser nulo.");
        }
    }
    public List<Familia>listarFamiliasConAlMenosTresHijos(){
        List<Familia> familias = fd.findAll();
        List<Familia> filtradas = new ArrayList<>();
        for(Familia f: familias){
            if(f.getNumHijos()>=3){
                if(f.getEdadMaxima()<10){
                    filtradas.add(f);
                }
            }
        }
        return filtradas;
    }
    public List<Familia> familiasHotmail(){
       // List<Familia> familias = fd.findAll();
        List<Familia> filtradas = new ArrayList<>();
        for(Familia f: fd.findAll()){
            if(f.getEmail().contains("@hotmail")){
                filtradas.add(f);
            }
        }
        return filtradas;
    }

}
