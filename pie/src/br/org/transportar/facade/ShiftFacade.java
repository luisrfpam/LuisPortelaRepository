/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.facade;

import br.org.transportar.entities.Tbshift;
import br.org.transportar.messages.FacesMessageUtil;
import br.org.transportar.services.ShiftService;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author LUISPORTELA
 */
public class ShiftFacade {

    ShiftService shiftService;
    
    public ShiftFacade() {
        shiftService = new ShiftService();
    }
    
    public void saveShift(Tbshift shift){
        try {
            shiftService.saveShift(shift);
            FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_turno", null), null);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();            
        }
        
    }
    
    public void updateShift(Tbshift shift){
        try {
            shiftService.updateShift(shift);
            FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_turno", null), null);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();            
        }
        
    }
    
    public void removeShift(Tbshift shift){
        
    }    
    
    public List<Tbshift> listShifts(){
        List<Tbshift> shifts = null;
        
        try {
            shifts = shiftService.getAllShifts();
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
        return shifts;
    }
    
    public boolean hasShift(String descricao){
        Tbshift shift = null;
        List<Tbshift> turnos = null;
                       
        try {
            
            turnos = shiftService.getShiftByDescription(descricao);
            
            if (turnos != null && !turnos.isEmpty() ) {
                
                FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_turno_ja_cadastrado", null), null);
                FacesContext.getCurrentInstance().validationFailed();
                return true;
                //FacesContext.getCurrentInstance().validationFailed();                  
                
            }                      
            
        } catch (Exception e) {            
            
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();            
            
        }
        
        return false;

    }

    public ShiftService getShiftService() {
        return shiftService;
    }

    public void setShiftService(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

           
}
