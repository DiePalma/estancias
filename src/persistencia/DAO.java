package persistencia;

import java.sql.*;

public abstract class DAO {
    protected Connection conexion = null;
    protected ResultSet resultSet = null;
    protected Statement statement = null;
    private final String HOST = "127.0.0.1";
    private final String PORT = "3306";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "estancias_exterior";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    protected void connectarDataBase() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE+"?useSSL=false";
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    protected void desconectarDataBase() throws SQLException, ClassNotFoundException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    protected void insertarModificarEliminarDataBase (String sql)throws Exception{
        try{
            connectarDataBase();
            statement = conexion.createStatement();
            statement.executeUpdate(sql);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
          //  desconectarDataBase();
        }

    }
    protected void consultarDataBase (String sql)throws Exception{
        try{
            connectarDataBase();
            statement = conexion.createStatement();
            resultSet=statement.executeQuery(sql);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
          //  desconectarDataBase();
        }

    }
}
