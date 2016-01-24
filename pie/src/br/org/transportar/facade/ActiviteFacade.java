/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.facade;

import br.org.transportar.entities.Tbactivite;
import br.org.transportar.messages.FacesMessageUtil;
import br.org.transportar.services.ActiviteService;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author LUISPORTELA
 */
public class ActiviteFacade {

    ActiviteService activiteService;
    
    public ActiviteFacade() {
        activiteService = new ActiviteService();
    }
    
    public void saveActivite(Tbactivite activite){
        try {
            activiteService.saveActivite(activite);
            FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_atividade", null), null);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
    }
    
    public void updateRole(Tbactivite activite){
        try {
            activiteService.updateActivite(activite);
            FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_atividade", null), null);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
    }
    
    public void removeActivite(Tbactivite activite){
        
    }
    
    public List<Tbactivite> listActivities(){
        List<Tbactivite> activities = null;
        
        try {
            activities = activiteService.getAllActivities();
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
        return activities;
    }

    public ActiviteService getActiviteService() {
        return activiteService;
    }

    public void setActiviteService(ActiviteService activiteService) {
        this.activiteService = activiteService;
    }
       
}
