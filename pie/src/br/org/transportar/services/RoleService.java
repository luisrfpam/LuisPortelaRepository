/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.services;

import br.org.transportar.dao.RoleDAO;
import br.org.transportar.entities.Tbrole;
import br.org.transportar.generics.AbstractService;
import br.org.transportar.generics.DAO;
import java.util.List;

/**
 *
 * @author LUISPORTELA
 */
public class RoleService extends AbstractService<Tbrole>{
    
    private DAO<Tbrole> dao;

    @Override
    public DAO<Tbrole> getDAO() {
        if (dao == null) {
            dao = new RoleDAO();
        }
        return dao;
    }    
    
    public void saveRole(Tbrole role) throws Exception {
        getDAO().salvar(role);
    }
    
    public void updateRole(Tbrole role) throws Exception {
        getDAO().atualizar(role);
    }
    
    public List<Tbrole> getAllRoles(){
        return getDAO().listarTodos();
    }    
    
}
