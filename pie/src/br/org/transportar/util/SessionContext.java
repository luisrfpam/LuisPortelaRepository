/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.util;

import java.util.Enumeration;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LUISPORTELA
 */
public class SessionContext {
    
    public static final String KEY = "userContext";
    
     public static HttpSession getSession(boolean create) {
         
         if (FacesContext.getCurrentInstance() != null) {
             ExternalContext extCon = FacesContext.getCurrentInstance().getExternalContext();
             return (HttpSession) extCon.getSession(create);
         } else {
             return null;
         }
        
    }
     
    public static void addContextUser(Object object) {
        if (getSession(true) != null) {
            getSession(true).setAttribute(SessionContext.KEY, object);
        }         
    }

    public static void addAttribute(String key, Object object) {
        if (getSession(true) != null) {
            getSession(true).setAttribute(key, object); 
        }        
    }
    
    public static void removeAttribute(String key) {
        if (getSession(false) != null) {
            getSession(false).removeAttribute(key);
        }        
    }
    
    public static void removeContextUser() {
        if (getSession(false) != null) {
            if (getSession(false).getAttribute(SessionContext.KEY) != null){
                getSession(false).setAttribute(SessionContext.KEY, null);
            }    
        }               
    }
    
    public static void removeOthersAttributes(){
        if (getSession(false) != null) {
            Enumeration<String> vals = SessionContext.getSession(false).getAttributeNames();         
            while(vals.hasMoreElements()){
                getSession(false).removeAttribute(vals.nextElement());
            }
        }            
    }
    
    public static void logoutContext(){
        removeContextUser();
        removeOthersAttributes();
        if (getSession(false) != null) {
            getSession(false).invalidate();
        }        
    }
    
}
