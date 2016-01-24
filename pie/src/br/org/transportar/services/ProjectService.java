/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.services;

import br.org.transportar.dao.ProjectDAO;
import br.org.transportar.entities.Tbproject;
import br.org.transportar.generics.AbstractService;
import br.org.transportar.generics.DAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LUISPORTELA
 */
public class ProjectService extends AbstractService<Tbproject>{
    
    private DAO<Tbproject> dao;

    @Override
    public DAO<Tbproject> getDAO() {
        if (dao == null) {
            dao = new ProjectDAO();
        }
        return dao;
    }    
    
    public void saveProject(Tbproject project) throws Exception {
        getDAO().salvar(project);
    }
    
    public void updateProject(Tbproject project) throws Exception {
        getDAO().atualizar(project);
    }
    
    public List<Tbproject> getAllProjects(){
        return getDAO().listarTodos();
    }    
    
    public List<Tbproject> getProjectsWLike(String nomeProjeto){        
        Map<String, Object> params = new HashMap<>();
        if (nomeProjeto == null) {
            nomeProjeto = new String();
        }
        nomeProjeto = "%"+nomeProjeto+"%";       
        params.put("nomeProjeto", nomeProjeto);        
        return getDAO().recuperarListaPorNamedQuery(Tbproject.LISTAR_POR_LIKE_NOME, params);
    }
    
}
