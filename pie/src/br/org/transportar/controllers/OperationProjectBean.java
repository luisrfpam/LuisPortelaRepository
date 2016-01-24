/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.controllers;

import br.org.transportar.entities.Tblancamentoelementoimport;
import br.org.transportar.entities.Tblancamentoservicoimport;
import br.org.transportar.entities.Tbproject;
import br.org.transportar.facade.LancamentoElementoImportFacade;
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
@ManagedBean(name = "operationProjectBean")
@ViewScoped
public class OperationProjectBean implements Serializable {
    
    static final long serialVersionUID = 1L;
    
    private final String BACK = "";
           
    private LancamentoElementoImportFacade facade;
    
    private Tbproject projeto;
    
    private List<Tblancamentoelementoimport> lancamentosElementosMontagensImport;
    
    private List<Tblancamentoelementoimport> lancamentosElementosCortesImport;
    
    private List<Tblancamentoservicoimport> lancamentosServicosImport;
    
    private Tblancamentoelementoimport lancamentoElementoMontagemImport;
    
    @PostConstruct
    public void init() {
        this.facade = new LancamentoElementoImportFacade();
    }
      
    public void checkLancamentoMontagemEPCG(boolean check){  
        this.lancamentoElementoMontagemImport.setIsEPCG(check);
        this.facade.saveLancamentoElementoImport(this.lancamentoElementoMontagemImport);  
        this.lancamentosElementosMontagensImport = this.facade.listLancamentosMontagensImport(this.projeto.getNomeProjeto());
    }
    
    public void checkLancamentoMontagemPCPP(boolean check){  
        this.lancamentoElementoMontagemImport.setIsPCPP(check);
        this.facade.saveLancamentoElementoImport(this.lancamentoElementoMontagemImport);      
        this.lancamentosElementosMontagensImport = this.facade.listLancamentosMontagensImport(this.projeto.getNomeProjeto());
    }    
       
    public void findLancamentosElementosMontagens(){     
        this.lancamentosElementosMontagensImport = this.facade.listLancamentosMontagensImport(this.projeto.getNomeProjeto());
    }
    
    public void findLancamentosElementosCortes(){        
        this.lancamentosElementosCortesImport = this.facade.listLancamentosCortesImport(this.projeto.getNomeProjeto());
    }
    
    public void findLancamentosSoldas(){        
        this.lancamentosServicosImport = this.facade.listLancamentosServicosImport(this.projeto.getNomeProjeto());
    }

    public LancamentoElementoImportFacade getFacade() {
        return facade;
    }

    public void setFacade(LancamentoElementoImportFacade facade) {
        this.facade = facade;
    }

    public Tbproject getProjeto() {
        return projeto;
    }

    public void setProjeto(Tbproject projeto) {
        this.projeto = projeto;
    }

    public List<Tblancamentoelementoimport> getLancamentosElementosMontagensImport() {
        return lancamentosElementosMontagensImport;
    }

    public void setLancamentosElementosMontagensImport(List<Tblancamentoelementoimport> lancamentosElementosMontagensImport) {
        this.lancamentosElementosMontagensImport = lancamentosElementosMontagensImport;
    }

    public List<Tblancamentoelementoimport> getLancamentosElementosCortesImport() {
        return lancamentosElementosCortesImport;
    }

    public void setLancamentosElementosCortesImport(List<Tblancamentoelementoimport> lancamentosElementosCortesImport) {
        this.lancamentosElementosCortesImport = lancamentosElementosCortesImport;
    }

    public List<Tblancamentoservicoimport> getLancamentosServicosImport() {
        return lancamentosServicosImport;
    }

    public void setLancamentosServicosImport(List<Tblancamentoservicoimport> lancamentosServicosImport) {
        this.lancamentosServicosImport = lancamentosServicosImport;
    }

    public Tblancamentoelementoimport getLancamentoElementoMontagemImport() {
        return lancamentoElementoMontagemImport;
    }

    public void setLancamentoElementoMontagemImport(Tblancamentoelementoimport lancamentoElementoMontagemImport) {
        this.lancamentoElementoMontagemImport = lancamentoElementoMontagemImport;
    }    
        
}
