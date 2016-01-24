/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.facade;

import br.org.transportar.entities.Tbcustomer;
import br.org.transportar.messages.FacesMessageUtil;
import br.org.transportar.services.CustomerService;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author LUISPORTELA
 */
public class CustomerFacade {

    CustomerService customerService;
    
    public CustomerFacade() {
        customerService = new CustomerService();
    }
    
    public boolean hasCustomerPF(String cpf) {
        List<Tbcustomer> clientes = null; 
       
        try {
            
            if (cpf != null) {
                
                clientes = this.customerService.getCustomersPF(cpf);
                if (clientes != null && !clientes.isEmpty() ) {
                    FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_cpf_ja_cadastrado", null), null);
                    FacesContext.getCurrentInstance().validationFailed();
                    return true;
                }                  

            }  
            
        } catch (Exception e) {
            
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
            
        }
        
        return false;
    }
    
    public boolean hasCustomerPJ(String cnpj) {
        
       List<Tbcustomer> clientes = null; 
       
        try {
            
            if (cnpj != null) {
                
                clientes = this.customerService.getCustomersPJ(cnpj);
                if (clientes != null && !clientes.isEmpty() ) {
                    FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_cnpj_ja_cadastrado", null), null);
                    FacesContext.getCurrentInstance().validationFailed();
                    return true;
                }                  

            }  
            
        } catch (Exception e) {
            
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
            
        }
        
        return false;
        
    }
    
    public void saveCustomer(Tbcustomer customer){
        
        try {
            
            customerService.saveCustomer(customer);
            FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_cliente", null), null);
            
        } /*catch (PersistenceException | MySQLIntegrityConstraintViolationException e) {
            if (customer.getCpf() != null) {
                FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_cpf_ja_cadastrado", null), null);
                FacesContext.getCurrentInstance().validationFailed();
            } else if (customer.getCnpj() !=null) {
                FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_cnpj_ja_cadastrado", null), null);
                FacesContext.getCurrentInstance().validationFailed();
            }            
        } */
        catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
    }
    
    public void updateCustomer(Tbcustomer customer){
        try {
            customerService.updateCustomer(customer);
            FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_cliente", null), null);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
    }
    
    public void removeCustomer(Tbcustomer customer){
        
    }
    
    public List<Tbcustomer> listCustomers(String tipoCliente){
        List<Tbcustomer> customers = null;
        
        try {
            switch (tipoCliente) {
                case "F":
                    customers = customerService.getAllCustomersFisica();
                    break;
                case "J":            
                    customers = customerService.getAllCustomersJuridica();
                    break;
            }

        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
        return customers;
    }
    
    

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
 
           
}
