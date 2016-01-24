/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.controllers;

import br.org.transportar.entities.Tbrole;
import br.org.transportar.facade.RoleFacade;
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
@ManagedBean(name = "roleBean")
@ViewScoped
public class RoleBean implements Serializable {
    
    static final long serialVersionUID = 1L;
    
    private final String BACK = "";
        
    private Tbrole cargo;
    
    private List<Tbrole> cargos;
    
    private RoleFacade facade;
    
    @PostConstruct
    public void init() {
        this.facade = new RoleFacade();
        this.cargo = new Tbrole();       
    }
    
    public void saveRole(Tbrole role){
        facade.saveRole(role);       
        this.cargo = new Tbrole();
    }
    
    public void findRole(Tbrole role){
        //facade.findRole(role);        
    }
    
    //public String removeRole(Tbrole role){
        
    //}

    public Tbrole getCargo() {
        return cargo;
    }

    public void setCargo(Tbrole cargo) {
        this.cargo = cargo;
    }

    public List<Tbrole> getCargos() {
        return facade.listRoles();
    }

    public void setCargos(List<Tbrole> cargos) {
        this.cargos = cargos;
    }

    public RoleFacade getFacade() {
        return facade;
    }

    public void setFacade(RoleFacade facade) {
        this.facade = facade;
    }

}
