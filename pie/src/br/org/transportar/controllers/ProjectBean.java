/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.controllers;

import br.org.transportar.entities.Tbcontract;
import br.org.transportar.entities.Tbproject;
import br.org.transportar.entities.Tbshiptype;
import br.org.transportar.facade.ProjectFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author LUISPORTELA
 */
@ManagedBean(name = "projectBean")
@ViewScoped
public class ProjectBean implements Serializable {
    
    static final long serialVersionUID = 1L;
    
    private final String BACK = "";
        
    private Tbproject projeto;
    
    private List<Tbproject> projetos;
    
    private List<Tbproject> projetosFiltrados;
    
    private String busca;
        
    private Tbshiptype tipoEmbarcacao; //utilitario para buscar os cargos (combo em cascata)
    
    private Tbcontract contrato;
    
    private ProjectFacade facade;
    
    private boolean filtroAtivo;
    
    @PostConstruct
    public void init() {
        this.facade = new ProjectFacade();
        this.projeto = new  Tbproject();
        this.tipoEmbarcacao = null;
        this.filtroAtivo = false;
    }
    
    public void saveProject(Tbproject project){      
        facade.saveProject(project);  
        project.setIdShipType(this.tipoEmbarcacao);
        project.setIdContract(this.contrato);
        this.projeto = new  Tbproject();
        this.tipoEmbarcacao = null;
        this.contrato = null;
    }
    
    public void clearFindProject(ActionEvent event){
        this.projetos = null;
        this.busca = null;       
    }
    
    public void findProject(ActionEvent event){        
        this.projetosFiltrados = facade.listProjects(this.busca);  
        this.busca = null;
        this.filtroAtivo = true;
    }
       
    //public String removeProject(Tbproject project){
        
    //}

    public Tbproject getProjeto() {
        return projeto;
    }

    public void setProjeto(Tbproject projeto) {
        this.projeto = projeto;
    }

    public List<Tbproject> getProjetos() { 
        /*
        if (filtroAtivo) {
            return this.projetos;
        } else {
            return facade.listProjects();
        } 
        */        
        //return facade.listProjects(this.busca);  
        return facade.listProjects();
    }

    public void setProjetos(List<Tbproject> projetos) {
        this.projetos = projetos;
    }

    public Tbshiptype getTipoEmbarcacao() {
        return tipoEmbarcacao;
    }

    public void setTipoEmbarcacao(Tbshiptype tipoEmbarcacao) {
        this.tipoEmbarcacao = tipoEmbarcacao;
    }

    public ProjectFacade getFacade() {
        return facade;
    }

    public void setFacade(ProjectFacade facade) {
        this.facade = facade;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }    

    public Tbcontract getContrato() {
        return contrato;
    }

    public void setContrato(Tbcontract contrato) {
        this.contrato = contrato;
    }

    public List<Tbproject> getProjetosFiltrados() {
        return projetosFiltrados;
    }

    public void setProjetosFiltrados(List<Tbproject> projetosFiltrados) {
        this.projetosFiltrados = projetosFiltrados;
    }

    public boolean isFiltroAtivo() {
        return filtroAtivo;
    }

    public void setFiltroAtivo(boolean filtroAtivo) {
        this.filtroAtivo = filtroAtivo;
    }  
        
}
