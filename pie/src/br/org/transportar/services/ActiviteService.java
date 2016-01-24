/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.services;

import br.org.transportar.dao.ActiviteDAO;
import br.org.transportar.entities.Tbactivite;
import br.org.transportar.generics.AbstractService;
import br.org.transportar.generics.DAO;
import java.util.List;

/**
 *
 * @author LUISPORTELA
 */
public class ActiviteService extends AbstractService<Tbactivite>{
    
    private DAO<Tbactivite> dao;

    @Override
    public DAO<Tbactivite> getDAO() {
        if (dao == null) {
            dao = new ActiviteDAO();
        }
        return dao;
    }    
    
    public void saveActivite(Tbactivite activite) throws Exception {
        getDAO().salvar(activite);
    }
    
    public void updateActivite(Tbactivite activite) throws Exception {
        getDAO().atualizar(activite);
    }
    
    public List<Tbactivite> getAllActivities(){
        return getDAO().listarTodos();
    }    
    
}
