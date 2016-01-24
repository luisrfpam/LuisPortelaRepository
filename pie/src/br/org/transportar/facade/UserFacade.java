/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.facade;

import br.org.transportar.entities.Tbuser;
import br.org.transportar.messages.FacesMessageUtil;
import br.org.transportar.services.UserService;
import br.org.transportar.util.SessionContext;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author LUISPORTELA
 */
public class UserFacade {

    UserService userService;
    
    public UserFacade() {
        userService = new UserService();
    }
    
    public void saveUser(Tbuser user){
        try {
            userService.saveUser(user);
            if (user.getIsFuncionario()) {
                FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_funcionario", null), null);
            } else{
                FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_usuario", null), null);
            }            
            
        } /*    
        catch (PersistenceException | MySQLIntegrityConstraintViolationException e) {
            
            if (FacesContext.getCurrentInstance().getViewRoot().getViewId().contains("user")) {
                FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_cpf_ja_cadastrado", null), null);
            } else if (FacesContext.getCurrentInstance().getViewRoot().getViewId().contains("worker")) {
                FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_matricula_ja_cadastrado", null), null);
            }
            
        }  */      
        catch (Exception e) {
            
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
            
        }
        
    }
    
    public void updateUser(Tbuser user){
        try {
            userService.updateUser(user);
            if (user.getIsFuncionario()) {
                FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_funcionario", null), null);
            } else{
                FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_usuario", null), null);
            }            
            
        } catch (Exception e) {
            
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
            
        }
        
    }
    
    public void removeUser(Tbuser user){
        
        try {
            
        } catch (Exception e) {
            
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
            
        }
        
    }
    
    /*
    public List<Tbuser> findUser(Tbuser user){
    
        List<Tbuser> usuarios = null;
        
        try {
            usuarios = userService.getAllUsersByParams(user);
            
        } catch (NoResultException nre) {
            //
        }
        
        return usuarios;
        
    }
    */
    
    public List<Tbuser> listUsers(){
        List<Tbuser> usuarios = null;
        
        try {
            usuarios = userService.getAllUsers();
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
        return usuarios;
    }
    
    public List<Tbuser> listWorkers(){
        List<Tbuser> workers = null;
        
        try {
            workers = userService.getWorkers();
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
        return workers;
    }
    
    public boolean validateLoginUser(String login){
        Tbuser usuario = null;
        List<Tbuser> usuarios = null;
                       
        try {
            
            usuarios = userService.getUsers(login.toLowerCase());
            
            if (usuarios != null && !usuarios.isEmpty() ) {
                
                FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_login_ja_cadastrado", null), null);
                
                return true;
                //FacesContext.getCurrentInstance().validationFailed();                  
                
            }                      
            
        } catch (Exception e) {            
            
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();            
            
        }
        
        return false;

    }
    
    public boolean hasCPF(String cpf){
        Tbuser usuario = null;
        List<Tbuser> usuarios = null;
                       
        try {
            
            usuarios = userService.getUsersByCPF(cpf);
            
            if (usuarios != null && !usuarios.isEmpty() ) {
                
                FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_cpf_ja_cadastrado", null), null);
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
    
    public boolean hasMatricula(String matricula){
        Tbuser usuario = null;
        List<Tbuser> usuarios = null;
                       
        try {
            
            usuarios = userService.getUsersByMatricula(matricula);
            
            if (usuarios != null && !usuarios.isEmpty() ) {
                
                FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_matricula_ja_cadastrado", null), null);
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
    
    public Tbuser validateLoginUser(String login, String senha){
        Tbuser usuario = null;
        List<Tbuser> usuarios = null;
                       
        try {
            
            usuarios = userService.getUsers(login.toLowerCase());
            
            if (usuarios != null && !usuarios.isEmpty() ) {
                usuario = usuarios.get(0);
                
                if (!usuario.getUserStatus()) {                
                    FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_nao_habilitado_usuario", null), null);
                    FacesContext.getCurrentInstance().validationFailed();  
                    usuario = null;
                } else {

                    if (!usuario.getUserPass().equals(senha)) {
                        FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_erro_login", null), null);
                        FacesContext.getCurrentInstance().validationFailed();  
                        usuario = null;
                    } else {
                        SessionContext.addContextUser(usuario);
                    }

                }
            } else {
                FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_usuario_nao_encontrado", null), null);
                FacesContext.getCurrentInstance().validationFailed();  
            }                        
            
        } catch (Exception e) {            
            
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
            return null;
            
        }
        
        return usuario;

    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
           
}
