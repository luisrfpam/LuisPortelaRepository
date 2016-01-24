/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.facade;

import br.org.transportar.entities.Tbproject;
import br.org.transportar.messages.FacesMessageUtil;
import br.org.transportar.services.ProjectService;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author LUISPORTELA
 */
public class ProjectFacade {

    ProjectService projectService;
    
    public ProjectFacade() {
        projectService = new ProjectService();
    }
    
    public void saveProject(Tbproject project){
        try {
            
            projectService.saveProject(project);
            FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_projeto", null), null);
            
        } catch (Exception e) {
            
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
            
        }
        
    }
    
    public void updateProject(Tbproject project){
        try {
            
            projectService.updateProject(project);
            FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_salvar_projeto", null), null);                  
            
        } catch (Exception e) {
            
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
            
        }
        
    }
    
    public void removeProject(Tbproject project){
        
        try {
            
        } catch (Exception e) {
            
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
            
        }
        
    }    
      
    public List<Tbproject> listProjects(){
        List<Tbproject> projetos = null;
        
        try {
            projetos = projectService.getAllProjects();
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
        return projetos;
    }
    
    public List<Tbproject> listProjects(String nomeProjeto){
        List<Tbproject> projetos = null;
        
        try {
            projetos = projectService.getProjectsWLike(nomeProjeto);
            
        } catch (Exception e) {
            FacesMessageUtil.addGlobalErrorMessage(FacesContext.getCurrentInstance(), e.getMessage(), null);
            e.printStackTrace();
        }
        
        return projetos;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }
    
}
