/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.facade;

import br.org.transportar.entities.Tbrole;
import br.org.transportar.messages.FacesMessageUtil;
import br.org.transportar.services.RoleService;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author LUISPORTELA
 */
public class RoleFacade {

    RoleService roleService;
    
    public RoleFacade() {
        roleService = new RoleService();
    }
    
    public void saveRole(Tbrole role){
        try {
            roleService.saveRole(role);
            FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_cargo", null), null);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
    }
    
    public void updateRole(Tbrole role){
        try {
            roleService.updateRole(role);
            FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_cargo", null), null);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
    }
    
    public void removeRole(Tbrole role){
        
    }
    
    public List<Tbrole> listRoles(){
        List<Tbrole> roles = null;
        
        try {
            roles = roleService.getAllRoles();
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
        return roles;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }   
           
}
