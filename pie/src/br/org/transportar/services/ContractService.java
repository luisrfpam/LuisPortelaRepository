/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.services;

import br.org.transportar.dao.ContractDAO;
import br.org.transportar.entities.Tbcontract;
import br.org.transportar.generics.AbstractService;
import br.org.transportar.generics.DAO;
import java.util.List;

/**
 *
 * @author LUISPORTELA
 */
public class ContractService extends AbstractService<Tbcontract>{
    
    private DAO<Tbcontract> dao;

    @Override
    public DAO<Tbcontract> getDAO() {
        if (dao == null) {
            dao = new ContractDAO();
        }
        return dao;
    }    
    
    public void saveContract(Tbcontract contract) throws Exception {
        getDAO().salvar(contract);
    }
    
    public void updateContract(Tbcontract contract) throws Exception {
        getDAO().atualizar(contract);
    }
    
    public List<Tbcontract> getAllContracts(){
        return getDAO().listarTodos();
    }    
    
}
