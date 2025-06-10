package com.miempresa.gestionasistencia.service;

import com.miempresa.gestionasistencia.dao.UsuarioDAO;
import com.miempresa.gestionasistencia.dao.UsuarioDAOImpl;
import com.miempresa.gestionasistencia.model.Usuario;

import java.util.List;

import jdk.internal.classfile.instruction.ThrowInstruction;

public class UsuarioService {
    private UsuarioDAO = new UsuarioDAOImpl();


    public boolean registrarUsuario(Usuario usuario){
        if (usuario.getNombre()== null || usuario.get.Nombre().isEmpty()) {
            throw new IllegalArgumentException("FALLO AL REGISTRAR USUARIO");
            
        }
        return UsuarioDAO.agregarUsuario(usuario);
    }
    
}
