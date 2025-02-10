package servicios;

import entidades.Cliente;
import persistencia.ClienteDAO;

public class ClienteServicio {
    private ClienteDAO cd;
    public ClienteServicio() {
        this.cd = new ClienteDAO();
    }

    public Cliente crearNuevoCliente(String nombre, String calle, int numero, String codigoPostal, String ciudad, String pais, String email) throws Exception {
        // Validaciones - Pueden estar metodo independiente.
        validacionesNyE(nombre, email);

        Cliente cliente = new Cliente(nombre, calle, numero, codigoPostal, ciudad, pais, email);
        cd.create(cliente);
        return cliente;
    }

    public void validacionesNyE(String nombre, String email) throws Exception {
        if (nombre == null) {
            throw new Exception("El nombre del contacto no puede ser nulo.");
        }
        if (email == null) {
            throw new Exception("El apellido del contacto no puede ser nulo.");
        }
    }
}
