package org.diegovelu.apiservlet.webapp.bbdd.tarea9.repositories;

import org.diegovelu.apiservlet.webapp.bbdd.tarea9.models.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoRepositoryImpl implements Repository<Curso> {

    private Connection conn;

    public CursoRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Curso> listar() throws SQLException {
        List<Curso> cursos = new ArrayList<>();

        try(Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM cursos")){
            while (rs.next()) {
                Curso c = getCurso( rs);;
                cursos.add(c);
            }
        }
        return cursos;
    }

    private static Curso getCurso( ResultSet rs) throws SQLException {
        Curso c = new Curso();
        c.setId(rs.getInt("id"));
        c.setNombre(rs.getString("nombre"));
        c.setDescripcion(rs.getString("descripcion"));
        c.setInstructor(rs.getString("instructor"));
        c.setDuracion(rs.getDouble("duracion"));
        return c;
    }

    @Override
    public List<Curso> porNombre(String nombre) throws SQLException {
        List<Curso> cursos = new ArrayList<>();

        try ( PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cursos as c where c.nombre like ?")) {
             stmt.setString(1, "%" + nombre + "%");

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                cursos.add(getCurso(rs));
            }
        }
        }

        return cursos;
    }


}
