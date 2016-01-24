/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.controllers;

import br.org.transportar.entities.Tbcontract;
import br.org.transportar.entities.Tbcustomer;
import br.org.transportar.entities.Tbproject;
import br.org.transportar.facade.ContractFacade;
import br.org.transportar.facade.ProjectFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author LUISPORTELA
 */
@ManagedBean(name = "contractBean")
@ViewScoped
public class ContractBean implements Serializable {
    
    static final long serialVersionUID = 1L;
    
    private final String BACK = "";
        
    private Tbcontract contrato;
    
    private List<Tbcontract> contratos;   
      
    private Tbproject projeto;
    
    private Tbcustomer cliente;
    
    private String tipoCliente;
    
    private String busca;
    
    private ContractFacade facade;
    
    private ProjectFacade facadeProject;
    
    private List<Tbproject> projetosExcluidos;  
        
    @PostConstruct
    public void init() {
        this.facade = new ContractFacade();
        this.contrato = new Tbcontract();
        this.tipoCliente = "F";
        this.facadeProject = new ProjectFacade();
    }
    
    public void saveContract(Tbcontract contract){
        contract.setIdCustomer(this.cliente);

        facade.saveContract(contract);        
                
        // atualiza projeto com id do contrato
        for (Iterator<Tbproject> iterator = contract.getTbprojectSet().iterator(); iterator.hasNext();) {
            Tbproject next = iterator.next();
            facadeProject.saveProject(next);
        }
        
        if (this.projetosExcluidos != null) {
            // atualiza projeto com id null
            for (Iterator<Tbproject> iterator = projetosExcluidos.iterator(); iterator.hasNext();) {
                Tbproject next = iterator.next();
                facadeProject.saveProject(next);
            }  
        }              
        
        this.contrato = new Tbcontract();
        this.cliente = null;
        if (this.projetosExcluidos != null) {
            this.projetosExcluidos.clear();
        }        
        this.projetosExcluidos = null;
        this.tipoCliente = "F";
    }
    
    public void editContract(ActionEvent event){
        if (this.cliente.getCnpj() != null) {
            this.tipoCliente = "J";
        } else if (this.cliente.getCpf() != null) {
            this.tipoCliente = "F";
        }
    }
    
    public void selectProject(ActionEvent event){        
        this.contrato.adicionaProjetos(this.projeto);
    }
    
    public void removeProject(ActionEvent event){        
        this.contrato.removeProjetos(this.projeto);
        this.getProjetosExcluidos().add(this.projeto);
    }
    
    public void findContract(Date dateContract){
        //facade.findContract(dateContract);        
    }
    
    //public String removeUser(Tbuser user){
        
    //}

    public Tbcontract getContrato() {
        return contrato;
    }

    public void setContrato(Tbcontract contrato) {
        this.contrato = contrato;
    }

    public List<Tbcontract> getContratos() {
        return facade.listContracts();
    }

    public void setContratos(List<Tbcontract> contratos) {
        this.contratos = contratos;
    }

    public ContractFacade getFacade() {
        return facade;
    }

    public void setFacade(ContractFacade facade) {
        this.facade = facade;
    }

    public Tbcustomer getCliente() {
        return cliente;
    }

    public void setCliente(Tbcustomer cliente) {
        this.cliente = cliente;
    }        

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Tbproject getProjeto() {
        return projeto;
    }

    public void setProjeto(Tbproject projeto) {
        this.projeto = projeto;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }  

    public ProjectFacade getFacadeProject() {
        return facadeProject;
    }

    public void setFacadeProject(ProjectFacade facadeProject) {
        this.facadeProject = facadeProject;
    }  

    public List<Tbproject> getProjetosExcluidos() {
        if (projetosExcluidos == null) {
            projetosExcluidos = new ArrayList<Tbproject>();
        }
        return projetosExcluidos;
    }

    public void setProjetosExcluidos(List<Tbproject> projetosExcluidos) {
        this.projetosExcluidos = projetosExcluidos;
    }
    
}
