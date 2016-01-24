/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.controllers;

import br.org.transportar.entities.Tbuser;
import br.org.transportar.facade.UserFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author LUISPORTELA
 */
@ManagedBean(name = "homeBean")
@ViewScoped
public class HomeBean implements Serializable {
    
    static final long serialVersionUID = 1L;
    
    private final String LOGIN = "home?faces-redirect=true";
    
    private String login;

    private String senha;
    
    private Tbuser usuario;
    
    private UserFacade facade;
    
    @PostConstruct
    public void init() {
        this.facade = new UserFacade();
        this.login = "";
        this.senha = "";
    }
    
    public String doLogin(){
        
        if (facade.validateLoginUser(this.login, this.senha) != null) {
            return LOGIN;
        } else {
            return "";
        }
       
    }   

    public Tbuser getUsuario() {
        return usuario;
    }

    public void setUsuario(Tbuser usuario) {
        this.usuario = usuario;
    }  
   
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UserFacade getFacade() {
        return facade;
    }

    public void setFacade(UserFacade facade) {
        this.facade = facade;
    }
    
}
