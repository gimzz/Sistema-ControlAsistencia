package com.miempresa.gestionasistencia.dao;

import com.miempresa.gestionasistencia.model.Asistencia;
import com.miempresa.gestionasistencia.enums.EstadoAsistencia;
import com.miempresa.gestionasistencia.util.ConexionBD;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AsistenciaDAOImpl implements AsistenciaDAO {

    @Override
    public boolean agregarAsistencia(Asistencia asistencia) {
        String sql = "INSERT INTO asistencias (usuarioid, fecha, estado) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, asistencia.getUsuarioId());
            ps.setDate(2, new java.sql.Date(asistencia.getDate().getTime()));
            ps.setString(3, asistencia.getEstado().name());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Asistencia obtenerAsistenciaPorId(int id) {
        String sql = "SELECT * FROM asistencias WHERE id = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Asistencia asistencia = new Asistencia();
                asistencia.setId(rs.getInt("id"));
                asistencia.setUsuarioId(rs.getInt("usuarioid"));
                asistencia.setDate(rs.getDate("fecha"));
                asistencia.setEstado(EstadoAsistencia.valueOf(rs.getString("estado").toUpperCase())); // String a enum
                return asistencia;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Asistencia> obtenerTodasAsistencias() {
        List<Asistencia> listaasistencias = new ArrayList<>();
        String sql = "SELECT * FROM asistencias";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Asistencia asistencia = new Asistencia();
                asistencia.setId(rs.getInt("id"));
                asistencia.setUsuarioId(rs.getInt("usuarioid"));
                asistencia.setDate(rs.getDate("fecha"));
                asistencia.setEstado(EstadoAsistencia.valueOf(rs.getString("estado").toUpperCase()));
                listaasistencias.add(asistencia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaasistencias;
    }

    @Override
    public boolean actualizarAsistencia(Asistencia asistencia) {
        String sql = "UPDATE asistencias SET usuarioid = ?, fecha = ?, estado = ? WHERE id = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, asistencia.getUsuarioId());
            ps.setDate(2, new java.sql.Date(asistencia.getDate().getTime()));
            ps.setString(3, asistencia.getEstado().name());
            ps.setInt(4, asistencia.getId());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminarAsistencia(int id) {
        String sql = "DELETE FROM asistencias WHERE id = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar la asistencia con id " + id);
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Asistencia> obtenerAsistenciasPorUsuario(int usuarioId) {
        List<Asistencia> lista = new ArrayList<>();
        String sql = "SELECT * FROM asistencias WHERE usuarioid = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, usuarioId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Asistencia asistencia = new Asistencia();
                asistencia.setId(rs.getInt("id"));
                asistencia.setUsuarioId(rs.getInt("usuarioid"));
                asistencia.setDate(rs.getDate("fecha"));
                asistencia.setEstado(EstadoAsistencia.valueOf(rs.getString("estado").toUpperCase()));
                lista.add(asistencia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
