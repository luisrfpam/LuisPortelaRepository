/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.controllers;

import br.org.transportar.entities.Tbshift;
import br.org.transportar.facade.ShiftFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author LUISPORTELA
 */
@ManagedBean(name = "shiftBean")
@ViewScoped
public class ShiftBean implements Serializable {
    
    static final long serialVersionUID = 1L;
    
    private final String BACK = "";
        
    private Tbshift turno;
    
    private List<Tbshift> turnos;
    
    private ShiftFacade facade;
    
    @PostConstruct
    public void init() {
        this.facade = new ShiftFacade();
        this.turno = new  Tbshift();
    }
    
    public void reset() {
        RequestContext.getCurrentInstance().reset("form:pnlGridCadastroTurnos");
    } 
    
    public void saveShift(Tbshift shift){    
        facade.saveShift(shift);  
        this.turno = new Tbshift();
    }
    
    public void findShift(Tbshift shift){
        //facade.findShift(shift);        
    }
    
    //public String removeShift(Tbshift shift){
        
    //}

    public Tbshift getTurno() {
        return turno;
    }

    public void setTurno(Tbshift turno) {
        this.turno = turno;
    }

    public List<Tbshift> getTurnos() {
        return facade.listShifts();
    }

    public void setTurnos(List<Tbshift> turnos) {
        this.turnos = turnos;
    }

    public ShiftFacade getFacade() {
        return facade;
    }

    public void setFacade(ShiftFacade facade) {
        this.facade = facade;
    }
    
}
