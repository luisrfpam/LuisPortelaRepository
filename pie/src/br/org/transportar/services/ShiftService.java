/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.services;

import br.org.transportar.dao.ShiftDAO;
import br.org.transportar.entities.Tbshift;
import br.org.transportar.generics.AbstractService;
import br.org.transportar.generics.DAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LUISPORTELA
 */
public class ShiftService extends AbstractService<Tbshift>{
    
    private DAO<Tbshift> dao;

    @Override
    public DAO<Tbshift> getDAO() {
        if (dao == null) {
            dao = new ShiftDAO();
        }
        return dao;
    }    
    
    public void saveShift(Tbshift shift) throws Exception {
        getDAO().salvar(shift);
    }    
    
    public void updateShift(Tbshift shift) throws Exception {
        getDAO().atualizar(shift);
    }  
       
    public List<Tbshift> getAllShifts(){
        return getDAO().listarTodos();
    }    
    
    public List<Tbshift> getShiftByDescription(String descricao){        
        Map<String, Object> params = new HashMap<>(); 
        
        if (descricao != null) {
            params.put("descricao", descricao);
        }
        
        return getDAO().recuperarListaPorNamedQuery(Tbshift.FIND_BY_DESCRIPTION, params);
    }
    
}
