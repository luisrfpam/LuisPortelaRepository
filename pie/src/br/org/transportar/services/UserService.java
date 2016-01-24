/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.services;

import br.org.transportar.dao.UserDAO;
import br.org.transportar.entities.Tbuser;
import br.org.transportar.generics.AbstractService;
import br.org.transportar.generics.DAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LUISPORTELA
 */
public class UserService extends AbstractService<Tbuser>{
    
    private DAO<Tbuser> dao;

    @Override
    public DAO<Tbuser> getDAO() {
        if (dao == null) {
            dao = new UserDAO();
        }
        return dao;
    }    
    
    public void saveUser(Tbuser user) throws Exception {
        getDAO().salvar(user);
    }
    
    public void updateUser(Tbuser user) throws Exception {
        getDAO().atualizar(user);
    }
    
    /*
    public List<Tbuser> getAllUsersByParams(Tbuser user){
        Map<String, Object> params = new HashMap<>();
        String queryString = "SELECT t FROM Tbuser t WHERE where 1=1";
        if (user.getNomeUsuario() != null) {
            queryString += " AND t.nomeUsuario like :nomeUsuario";
            params.put("nomeUsuario", user.getNomeUsuario());
        }        
        return getDAO().listar(queryString, params);
    }
    */
    
    public List<Tbuser> getWorkers(){        
        Map<String, Object> params = new HashMap<>(); 
        
        params.put("isFuncionario", true);
           
        return getDAO().recuperarListaPorNamedQuery(Tbuser.LISTAR_FUNCIONARIOS, params);
    }
    
    public List<Tbuser> getAllUsers(){
        return getDAO().listarTodos();
    }
    
    public List<Tbuser> getUsers(String login){        
        Map<String, Object> params = new HashMap<>(); 
        
        if (login != null) {
            params.put("userLogin", login);
        }
        
        return getDAO().recuperarListaPorNamedQuery(Tbuser.FIND_POR_LOGIN, params);
    }
    
    public List<Tbuser> getUsersByCPF(String cpf){        
        Map<String, Object> params = new HashMap<>(); 
        
        if (cpf != null) {
            params.put("cpf", cpf);
        }
        
        return getDAO().recuperarListaPorNamedQuery(Tbuser.FIND_BY_CPF, params);
    }
    
    public List<Tbuser> getUsersByMatricula(String matricula){        
        Map<String, Object> params = new HashMap<>(); 
        
        if (matricula != null) {
            params.put("matricula", matricula);
        }
        
        return getDAO().recuperarListaPorNamedQuery(Tbuser.FIND_BY_MATRICULA, params);
    }
    
}
