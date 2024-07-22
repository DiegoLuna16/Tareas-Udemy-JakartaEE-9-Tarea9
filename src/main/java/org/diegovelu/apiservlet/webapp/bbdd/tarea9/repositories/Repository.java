package org.diegovelu.apiservlet.webapp.bbdd.tarea9.repositories;

import org.diegovelu.apiservlet.webapp.bbdd.tarea9.models.Curso;

import java.sql.SQLException;
import java.util.List;

public interface Repository <T>{
    List<Curso> listar() throws SQLException;
    List<Curso> porNombre(String id) throws SQLException;
}
