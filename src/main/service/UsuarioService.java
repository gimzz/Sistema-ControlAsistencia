package com.miempresa.gestionasistencia.service;

import com.miempresa.gestionasistencia.dao.UsuarioDAO;
import com.miempresa.gestionasistencia.dao.UsuarioDAOImpl;
import com.miempresa.gestionasistencia.model.Usuario;

import java.util.List;

public class UsuarioService {
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    public boolean registrarUsuario(Usuario usuario) {
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            throw new IllegalArgumentException("FALLO AL REGISTRAR USUARIO");
        }
        return usuarioDAO.agregarUsuario(usuario);
    }

    public Usuario obtenerUsuarioPorId(int id) {
        return usuarioDAO.obtenerUsuarioPorId(id);
    }

    public Usuario obtenerUsuarioPorNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("NO HAY REGISTROS");
        }
        return usuarioDAO.obtenerUsuarioPorNombre(nombre);
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioDAO.obtenerTodosUsuarios();
    }

    public boolean actualizarUsuario(Usuario usuario) {
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            throw new IllegalArgumentException("ERROR PARA ACTUALIZAR");
        }
        try {
            return usuarioDAO.actualizarUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
