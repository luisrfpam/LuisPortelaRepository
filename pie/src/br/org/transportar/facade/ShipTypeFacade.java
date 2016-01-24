/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.facade;

import br.org.transportar.entities.Tbshiptype;
import br.org.transportar.messages.FacesMessageUtil;
import br.org.transportar.services.ShipTypeService;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author LUISPORTELA
 */
public class ShipTypeFacade {

    ShipTypeService shipTypeService;
    
    public ShipTypeFacade() {
        shipTypeService = new ShipTypeService();
    }
    
    public void saveShipType(Tbshiptype shipType){
        try {
            shipTypeService.saveShipType(shipType);
            FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_tipo_embarcacao", null), null);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();            
        }
        
    }
    
    public void updateShipType(Tbshiptype shipType){
        try {
            shipTypeService.updateShipType(shipType);
            FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_tipo_embarcacao", null), null);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();            
        }
        
    }
    
    public void removeShipType(Tbshiptype shipType){
        
    }
    
    public List<Tbshiptype> listShipsType(){
        List<Tbshiptype> shipsType = null;
        
        try {
            shipsType = shipTypeService.getAllShipsType();
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
        return shipsType;
    }
    
    public boolean hasShipType(String descricao){
        Tbshiptype shipType = null;
        List<Tbshiptype> embarcacoes = null;
                       
        try {
            
            embarcacoes = shipTypeService.getShipTypeByDescription(descricao);
            
            if (embarcacoes != null && !embarcacoes.isEmpty() ) {
                
                FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_embarcacao_ja_cadastrado", null), null);
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

    public ShipTypeService getShipTypeService() {
        return shipTypeService;
    }

    public void setShipTypeService(ShipTypeService shipTypeService) {
        this.shipTypeService = shipTypeService;
    }
 
           
}
