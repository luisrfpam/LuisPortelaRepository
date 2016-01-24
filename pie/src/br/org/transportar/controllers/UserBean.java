/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.controllers;

import br.org.transportar.entities.Tbrole;
import br.org.transportar.entities.Tbuser;
import br.org.transportar.facade.UserFacade;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 *
 * @author LUISPORTELA
 */
@ManagedBean(name = "userBean")
@ViewScoped
public class UserBean implements Serializable {
    
    static final long serialVersionUID = 1L;
    
    private final String BACK = "";
        
    private Tbuser usuario;
    
    private List<Tbuser> usuarios;
    
    private List<Tbuser> funcionarios;
    
    private Tbrole cargo; //utilitario para buscar os cargos (combo em cascata)
    
    private UserFacade facade;

    
    @PostConstruct
    public void init() {
        this.facade = new UserFacade();
        this.usuario = new  Tbuser();
        this.cargo = null;
    }
    
    public void limpar() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ArrayList<String> clientIds = new ArrayList<String>();
        clientIds.add("form:textNome");        
        UIViewRoot view = ctx.getViewRoot();    
        view.resetValues(ctx, clientIds); // reseta os componentes da lista
    }
    
    public void saveUser(Tbuser user){
        Date date = Date.from(Instant.now());
        user.setUserRegistered(date);
        if (!this.facade.validateLoginUser(user.getUserLogin()) && !this.facade.hasCPF(user.getCpf())) {
            facade.saveUser(user);  
            this.usuario = new Tbuser();
        }        
    }
    
    public void saveWorker(Tbuser user){
        Date date = Date.from(Instant.now());
        user.setUserRegistered(date);
        user.setIsFuncionario(true);
        user.setIdRole(this.cargo);        
        if (!this.facade.hasMatricula(user.getMatricula())) {
            facade.saveUser(user);   
            this.usuario = new Tbuser();
            this.cargo = null;
        }      
    } 
    
    public void findUser(Tbuser user){
        //facade.findUser(user);        
    }
    
    //public String removeUser(Tbuser user){
        
    //}

    public Tbuser getUsuario() {
        return usuario;
    }

    public void setUsuario(Tbuser usuario) {
        this.usuario = usuario;
    }

    public List<Tbuser> getUsuarios() {
        return facade.listUsers();
    }

    public void setUsuarios(List<Tbuser> usuarios) {
        this.usuarios = usuarios;
    }

    public UserFacade getFacade() {
        return facade;
    }

    public void setFacade(UserFacade facade) {
        this.facade = facade;
    }   

    public List<Tbuser> getFuncionarios() {
        return facade.listWorkers();
    }

    public void setFuncionarios(List<Tbuser> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Tbrole getCargo() {
        return cargo;
    }

    public void setCargo(Tbrole cargo) {
        this.cargo = cargo;
    }
 
}
