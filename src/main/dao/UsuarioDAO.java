package com.miempresa.gestionasistencia.dao;

import com.miempresa.gestionasistencia.model.Usuario;
import java.util.List;

public interface UsuarioDAO {
    boolean agregarUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorId(int id);
    Usuario obtenerUsuarioPorNombre(String nombre);
    List<Usuario> obtenerTodosUsuarios();
    boolean actualizarUsuario(Usuario usuario);
    boolean eliminarUsuario(int id);
}
