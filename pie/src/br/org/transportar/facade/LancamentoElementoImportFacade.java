/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.facade;

import br.org.transportar.entities.Tblancamentoelementoimport;
import br.org.transportar.entities.Tblancamentoservicoimport;
import br.org.transportar.messages.FacesMessageUtil;
import br.org.transportar.services.LancamentoElementoImportService;
import br.org.transportar.services.LancamentoServicoImportService;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author LUISPORTELA
 */
public class LancamentoElementoImportFacade {

    LancamentoElementoImportService lancamentoElementoImportService;
    LancamentoServicoImportService lancamentoServicoImportService;
    
    
    public LancamentoElementoImportFacade() {
        lancamentoElementoImportService = new LancamentoElementoImportService();
        lancamentoServicoImportService = new LancamentoServicoImportService();
    }
    
    public void saveLancamentoElementoImport(Tblancamentoelementoimport lancamentoElementoImport){
        try {
            lancamentoElementoImportService.saveLancamentoElementoImport(lancamentoElementoImport);
            //FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_importacao_lancamento_elemento", null), null);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
    }
    
    public void saveLancamentoServicoImport(Tblancamentoservicoimport lancamentoServicoImport){
        try {
            lancamentoServicoImportService.saveLancamentoServicoImport(lancamentoServicoImport);
            //FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_importacao_lancamento_elemento", null), null);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
    }
    
    public void updateLancamentoElementoImport(Tblancamentoelementoimport lancamentoElementoImport){
        try {
            lancamentoElementoImportService.updateLancamentoElementoImport(lancamentoElementoImport);
            //FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_importacao_lancamento_elemento", null), null);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
    }
    
    public void removeLancamentoElementoImport(Tblancamentoelementoimport lancamentoElementoImport){
        
    }
    
    public List<Tblancamentoelementoimport> listLancamentosElementosImport(){
        List<Tblancamentoelementoimport> lancamentosElementosImports = null;
        
        try {
            lancamentosElementosImports = lancamentoElementoImportService.getAllLancamentosElementosImport();
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
        return lancamentosElementosImports;
    }
    
    public List<Tblancamentoelementoimport> listLancamentosMontagensImport(){
        List<Tblancamentoelementoimport> lancamentosElementosImports = null;
        
        try {
            lancamentosElementosImports = lancamentoElementoImportService.getAllLancamentosImportMontagens();
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
        return lancamentosElementosImports;
    }
    
    public List<Tblancamentoelementoimport> listLancamentosMontagensImport(String nomeProjeto){
        List<Tblancamentoelementoimport> lancamentosElementosImports = null;
        
        try {
            lancamentosElementosImports = lancamentoElementoImportService.getAllLancamentosImportMontagensWLike(nomeProjeto);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
        return lancamentosElementosImports;
    }
    
    public List<Tblancamentoelementoimport> listLancamentosCortesImport(){
        List<Tblancamentoelementoimport> lancamentosElementosImports = null;
        
        try {
            lancamentosElementosImports = lancamentoElementoImportService.getAllLancamentosImportCortes();
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
        return lancamentosElementosImports;
    }
    
    public List<Tblancamentoelementoimport> listLancamentosCortesImport(String nomeProjeto){
        List<Tblancamentoelementoimport> lancamentosElementosImports = null;
        
        try {
            lancamentosElementosImports = lancamentoElementoImportService.getAllLancamentosImportCortesWLike(nomeProjeto);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
        return lancamentosElementosImports;
    }
    
    public List<Tblancamentoservicoimport> listLancamentosServicosImport(){
        List<Tblancamentoservicoimport> lancamentosServicosImports = null;
        
        try {
            lancamentosServicosImports = lancamentoServicoImportService.getAllLancamentosServicosImport();
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
        return lancamentosServicosImports;
    }
    
    public List<Tblancamentoservicoimport> listLancamentosServicosImport(String nomeProjeto){
        List<Tblancamentoservicoimport> lancamentosServicosImports = null;
        
        try {
            lancamentosServicosImports = lancamentoServicoImportService.getAllLancamentosImportSoldasWLike(nomeProjeto);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
        return lancamentosServicosImports;
    }
    
    public void removeLancamentoElementoImportByProjeto(String nomeProjeto){
        try {
            lancamentoElementoImportService.removeLancamentosImportByProjeto(nomeProjeto);
            //FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_importacao_lancamento_elemento", null), null);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
    }
    
    public void removeLancamentoServicoImportByProjeto(String nomeProjeto, String idBloco){
        try {
            lancamentoServicoImportService.removeLancamentosImportByProjeto(nomeProjeto, idBloco);
            //FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_importacao_lancamento_elemento", null), null);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
    }
    
    public void removeLancamentoElementoImportByDate(String mes, String ano){
        try {
            lancamentoElementoImportService.removeLancamentosImportByDate(mes, ano);
            //FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_importacao_lancamento_elemento", null), null);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
    }
    
    public void removeLancamentoElementoImportByDate(String dia, String mes, String ano){
        try {
            lancamentoElementoImportService.removeLancamentosImportByDate(dia, mes, ano);
            //FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_importacao_lancamento_elemento", null), null);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
    }

    public LancamentoElementoImportService getLancamentoElementoImportService() {
        return lancamentoElementoImportService;
    }

    public void setLancamentoElementoImportService(LancamentoElementoImportService lancamentoElementoImportService) {
        this.lancamentoElementoImportService = lancamentoElementoImportService;
    }

    public LancamentoServicoImportService getLancamentoServicoImportService() {
        return lancamentoServicoImportService;
    }

    public void setLancamentoServicoImportService(LancamentoServicoImportService lancamentoServicoImportService) {
        this.lancamentoServicoImportService = lancamentoServicoImportService;
    }
       
}
