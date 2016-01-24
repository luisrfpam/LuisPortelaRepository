/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.services;

import br.org.transportar.dao.ShipTypeDAO;
import br.org.transportar.entities.Tbshiptype;
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
public class ShipTypeService extends AbstractService<Tbshiptype>{
    
    private DAO<Tbshiptype> dao;

    @Override
    public DAO<Tbshiptype> getDAO() {
        if (dao == null) {
            dao = new ShipTypeDAO();
        }
        return dao;
    }    
    
    public void saveShipType(Tbshiptype shipType) throws Exception {
        getDAO().salvar(shipType);
    }
    
    public void updateShipType(Tbshiptype shipType) throws Exception {
        getDAO().atualizar(shipType);
    }
    
    public List<Tbshiptype> getAllShipsType(){
        return getDAO().listarTodos();
    }   
    
    public List<Tbshiptype> getShipTypeByDescription(String descricao){        
        Map<String, Object> params = new HashMap<>(); 
        
        if (descricao != null) {
            params.put("descricao", descricao);
        }
        
        return getDAO().recuperarListaPorNamedQuery(Tbshiptype.FIND_BY_DESCRIPTION, params);
    }
    
}
