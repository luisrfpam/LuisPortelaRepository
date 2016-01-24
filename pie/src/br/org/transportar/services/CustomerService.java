/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.services;

import br.org.transportar.dao.CustomerDAO;
import br.org.transportar.entities.Tbcustomer;
import br.org.transportar.generics.AbstractService;
import br.org.transportar.generics.DAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LUISPORTELA
 */
public class CustomerService extends AbstractService<Tbcustomer>{
    
    private DAO<Tbcustomer> dao;

    @Override
    public DAO<Tbcustomer> getDAO() {
        if (dao == null) {
            dao = new CustomerDAO();
        }
        return dao;
    }    
    
    public void saveCustomer(Tbcustomer customer) throws Exception {
        getDAO().salvar(customer);
    }
    
    public void updateCustomer(Tbcustomer customer) throws Exception {
        getDAO().atualizar(customer);
    }
    
    public List<Tbcustomer> getAllCustomers(){
        return getDAO().listarTodos();
    }    
    
    public List<Tbcustomer> getAllCustomersFisica(){          
        return getDAO().recuperarListaPorNamedQuery(Tbcustomer.LISTAR_PESSOA_FISICA);
    }
    
    public List<Tbcustomer> getAllCustomersJuridica(){        
        return getDAO().recuperarListaPorNamedQuery(Tbcustomer.LISTAR_PESSOA_JURIDICA);
    }
    
    public List<Tbcustomer> getCustomersPF(String cpf){        
        Map<String, Object> params = new HashMap<>(); 
        
        if (cpf != null) {
            params.put("cpf", cpf);
        }
        
        return getDAO().recuperarListaPorNamedQuery(Tbcustomer.FIND_BY_CPF, params);
    }
    
    public List<Tbcustomer> getCustomersPJ(String cnpj){        
        Map<String, Object> params = new HashMap<>(); 
        
        if (cnpj != null) {
            params.put("cnpj", cnpj);
        }
        
        return getDAO().recuperarListaPorNamedQuery(Tbcustomer.FIND_BY_CNPJ, params);
    }
    
}
