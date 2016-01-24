/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.controllers;

import br.org.transportar.entities.Tbshiptype;
import br.org.transportar.facade.ShipTypeFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author LUISPORTELA
 */
@ManagedBean(name = "shipTypeBean")
@ViewScoped
public class ShipTypeBean implements Serializable {
    
    static final long serialVersionUID = 1L;
    
    private final String BACK = "";
        
    private Tbshiptype tipoEmbarcacao;
    
    private List<Tbshiptype> tiposEmbarcacoes;
    
    private ShipTypeFacade facade;
    
    @PostConstruct
    public void init() {
        this.facade = new ShipTypeFacade();
        this.tipoEmbarcacao = new Tbshiptype();
    }
    
    public void saveShipType(Tbshiptype shipType){   
        if (!this.facade.hasShipType(shipType.getDescricao())){
            facade.saveShipType(shipType);  
            this.tipoEmbarcacao = new Tbshiptype();
        }        
    }
    
    public void findShipType(Tbshiptype shipType){
        //facade.findShipType(shipType);        
    }
    
    //public String removeShipType(Tbshiptype shipType){
        
    //}

    public Tbshiptype getTipoEmbarcacao() {
        return tipoEmbarcacao;
    }

    public void setTipoEmbarcacao(Tbshiptype tipoEmbarcacao) {
        this.tipoEmbarcacao = tipoEmbarcacao;
    }

    public List<Tbshiptype> getTiposEmbarcacoes() {
        return this.facade.listShipsType();
    }

    public void setTiposEmbarcacoes(List<Tbshiptype> tiposEmbarcacoes) {
        this.tiposEmbarcacoes = tiposEmbarcacoes;
    }

    public ShipTypeFacade getFacade() {
        return facade;
    }

    public void setFacade(ShipTypeFacade facade) {
        this.facade = facade;
    }
        
}
