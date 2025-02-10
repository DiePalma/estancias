package persistencia;




import entidades.Cliente;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO  extends DAO{
        public void create(Cliente cliente) throws Exception {
            if(cliente == null){
                throw new Exception("Cliente no puede ser nulo");
            }

            String nombre = cliente.getNombre();
            String calle = cliente.getCalle();
            int numero = cliente.getNumero();
            String codigoPostal = cliente.getCodigoPostal();
            String ciudad = cliente.getCiudad();
            String pais = cliente.getPais();
            String email = cliente.getEmail();

            String sql = String.format("INSERT INTO clientes (nombre, calle, numero, codigo_postal, ciudad, pais, email) VALUES(%s, %s, %d, %s, %s %s, %s);",
                    nombre, calle, numero, codigoPostal,ciudad,pais,email);

            insertarModificarEliminarDataBase(sql);

        }
        public Cliente findById(int id) throws Exception{

            String sql = "SELECT * FROM clientes WHERE id = " + id;

            try{
            Cliente cliente=  new Cliente();
            consultarDataBase(sql);
            while (resultSet.next()) {


                cliente.setIdCliente(resultSet.getInt(("id_cliente")));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setCalle(resultSet.getString("calle"));
                cliente.setNumero(resultSet.getInt("numero"));
                cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
                cliente.setCiudad(resultSet.getString("ciudad"));
                cliente.setPais(resultSet.getString("pais"));
                cliente.setEmail(resultSet.getString("email"));
            }
            return cliente;
            }catch(Exception e){
                throw new Exception("Cliente no encontrado");
            }

        }

        public List<Cliente> findAll() throws Exception{
            List<Cliente> clientes = new ArrayList<>();
            String sql = "SELECT * FROM clientes;";

            try{
            consultarDataBase(sql);
            Cliente cliente = new Cliente();
            while (resultSet.next()) {

                cliente.setIdCliente(resultSet.getInt("id_cliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setCalle(resultSet.getString("calle"));
                cliente.setNumero(resultSet.getInt("numero"));
                cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
                cliente.setCiudad(resultSet.getString("ciudad"));
                cliente.setPais(resultSet.getString("pais"));
                cliente.setEmail(resultSet.getString("email"));
                clientes.add(cliente);
            }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return clientes;
        }
        public void deleteById(int id) throws Exception {
            String sql = "DELETE FROM clientes WHERE id = " + id;
            insertarModificarEliminarDataBase(sql);
        }





    }