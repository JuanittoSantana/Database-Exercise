package DAO.interfaces;

public interface Catalogo {
    
    public boolean agregarRegistro(Object o) throws Exception;
    
    public boolean modificarRegistro(Object o) throws Exception;
    
    public boolean eliminarRegistro(Object o) throws Exception;
    
    public boolean consultarRegistro(Object o) throws Exception;
    
}
