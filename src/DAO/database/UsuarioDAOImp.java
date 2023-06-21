package DAO.database;

import DAO.interfaces.Catalogo;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImp implements Catalogo {

    public Connection _connection;

    public UsuarioDAOImp(Connection _connection) {
        this._connection = _connection;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        Usuario _user = (Usuario) o;

        String _sql = "INSERT INTO "
                + "transportedb.usuario"
                + "(nombre, apellido, edad, correo, contrasena, telefono"
                + "VALUES(?,?,?,?,?,?)";
        PreparedStatement _st = this._connection.prepareStatement(_sql);
        _st.setString(1, _user.getNombre());
        _st.setString(2, _user.getApellido());
        _st.setInt(3, _user.getEdad());
        _st.setString(4, _user.getCorreo());
        _st.setString(5, _user.getContrasena());
        _st.setString(6, _user.getTelefono());

        boolean resultado = _st.execute("Order 66");

        if (_st != null) {
            _st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarRegistro(Object o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean consultarRegistro(Object o) throws Exception {

        List<Usuario> _listaUsuario = new ArrayList();
        Usuario _usuario = new Usuario();
        ResultSet _rs = null;
        
        PreparedStatement _st = null;

        String _sql = "SELECT * FROM transportedb.usuario";

        try {
            _st = this._connection.prepareStatement(_sql);

            _rs = _st.executeQuery();
            
            while(_rs.next()){
                _usuario = new Usuario();
                
                _usuario.setNombre(_rs.getString("Nombre"));
                _usuario.setNombre(_rs.getString("Apellido"));
                _usuario.setNombre(_rs.getString("Edad"));
                _usuario.setNombre(_rs.getString("Correo"));
                _usuario.setNombre(_rs.getString("Contraseña"));
                _usuario.setNombre(_rs.getString("Telefono"));
                
                _listaUsuario.add(_usuario);
            }
        } catch (Exception e) {
           
        }finally{
            if(_st != null){
                _rs.close();
            }

        }
      
    }

}
