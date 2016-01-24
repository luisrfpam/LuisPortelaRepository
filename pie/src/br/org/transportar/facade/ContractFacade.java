/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.facade;

import br.org.transportar.entities.Tbcontract;
import br.org.transportar.messages.FacesMessageUtil;
import br.org.transportar.services.ContractService;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;

/**
 *
 * @author LUISPORTELA
 */
public class ContractFacade {

    ContractService contractService;
    
    public ContractFacade() {
        contractService = new ContractService();
    }
    
    public void saveContract(Tbcontract contract){
        try {
            contractService.saveContract(contract);
            FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_contrato", null), null);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void updateContract(Tbcontract contract){
        try {
            contractService.updateContract(contract);
            FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_contrato", null), null);
            
        } catch (Exception e) {
            
        }
        
    }
    
    public void removeContract(Tbcontract contract){
        
    }
    
    public List<Tbcontract> listContracts(){
        List<Tbcontract> contracts = null;
        
        try {
            contracts = contractService.getAllContracts();
            
        } catch (NoResultException nre) {
            //
        }
        
        return contracts;
    }

    public ContractService getContractService() {
        return contractService;
    }

    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }
    
}
