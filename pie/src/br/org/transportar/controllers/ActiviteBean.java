/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.controllers;

import br.org.transportar.entities.Tbactivite;
import br.org.transportar.facade.ActiviteFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author LUISPORTELA
 */
@ManagedBean(name = "activiteBean")
@ViewScoped
public class ActiviteBean implements Serializable {
    
    static final long serialVersionUID = 1L;
    
    private final String BACK = "";
        
    private Tbactivite atividade;
    
    private List<Tbactivite> atividades;
    
    private ActiviteFacade facade;
    
    @PostConstruct
    public void init() {
        this.facade = new ActiviteFacade();
        this.atividade = new Tbactivite();       
    }
    
    public void saveActivite(Tbactivite activite){
        facade.saveActivite(activite);       
        this.atividade = new Tbactivite();
    }
    
    public void findActivite(Tbactivite activite){
        //facade.findActivite(activite);        
    }
    
    //public String removeActivite(Tbactivite activite){
        
    //}

    public Tbactivite getAtividade() {
        return atividade;
    }

    public void setAtividade(Tbactivite atividade) {
        this.atividade = atividade;
    }

    public List<Tbactivite> getAtividades() {
        return this.facade.listActivities();
    }

    public void setAtividades(List<Tbactivite> atividades) {
        this.atividades = atividades;
    }

    public ActiviteFacade getFacade() {
        return facade;
    }

    public void setFacade(ActiviteFacade facade) {
        this.facade = facade;
    }
   
}
