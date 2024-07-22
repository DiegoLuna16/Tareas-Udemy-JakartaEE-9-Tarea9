package org.diegovelu.apiservlet.webapp.bbdd.tarea9.services;

import org.diegovelu.apiservlet.webapp.bbdd.tarea9.models.Curso;
import org.diegovelu.apiservlet.webapp.bbdd.tarea9.repositories.CursoRepositoryImpl;
import org.diegovelu.apiservlet.webapp.bbdd.tarea9.repositories.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoServiceImpl implements CursoService{
    private Repository<Curso> repository;

    public CursoServiceImpl(Connection conn) {
        this.repository = new CursoRepositoryImpl(conn);
    }

    @Override
    public List<Curso> listar() {
        try{
            return repository.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage());
        }
    }

    @Override
    public List<Curso> porNombre(String nombre) {
        try{
            return repository.porNombre(nombre);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage());
        }
    }
}
