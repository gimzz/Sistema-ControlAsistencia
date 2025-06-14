package com.miempresa.gestionasistencia.service;

import com.miempresa.gestionasistencia.dao.AsistenciaDAO;
import com.miempresa.gestionasistencia.dao.AsistenciaDAOImpl;
import com.miempresa.gestionasistencia.model.Asistencia;

import java.util.List;

public class AsistenciaService {

    private AsistenciaDAO asistenciaDAO = new AsistenciaDAOImpl();

    public boolean agregarAsistencia(Asistencia asistencia) {
        if (asistencia.getUsuarioId() <= 0) {
            throw new IllegalArgumentException("HUBO UN FALLO AL ENCONTRAR LA ASISTENCIA DEL USUARIO");
        }
        try {
            return asistenciaDAO.agregarAsistencia(asistencia);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Asistencia obtenerAsistenciaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de asistencia inválido");
        }
        Asistencia asistencia = asistenciaDAO.obtenerAsistenciaPorId(id);
        if (asistencia == null) {
            throw new RuntimeException("Asistencia no encontrada para el ID: " + id);
        }
        return asistencia;
    }
 
    public List<Asistencia> obtenerTodasAsistencias() {
        try {
            return asistenciaDAO.obtenerTodasAsistencias();
        } catch (Exception e) {
            throw new IllegalArgumentException("FALLIDO AL LISTAR TODAS LAS ASISTENCIAS");
        }
    }

    public boolean actualizarAsistencia(Asistencia asistencia) {
        if (asistencia.getNombre() == null || asistencia.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario es obligatorio");
        }
        try {
            return asistenciaDAO.actualizarAsistencia(asistencia);
        } catch (Exception e) {
            throw new IllegalArgumentException("ERROR PARA ACTUALIZAR ASISTENCIA");
        }
    }

    public boolean eliminarAsistencia(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para eliminar asistencia");
        }
        try {
            return asistenciaDAO.eliminarAsistencia(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("ERROR AL ELIMINAR ASISTENCIA");
        }
    }
}
