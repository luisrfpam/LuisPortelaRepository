/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.listener;

import br.org.transportar.entities.Tbuser;
import br.org.transportar.util.SessionContext;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LUISPORTELA
 */
public class AutenticacaoPhaseListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent pe) {
        FacesContext fc = pe.getFacesContext();
        ExternalContext ec = fc.getExternalContext();

        if (!fc.getViewRoot().getViewId().contains("login.jsf")) {
            HttpSession session = (HttpSession) ec.getSession(true);
            Tbuser user = (Tbuser) session.getAttribute(SessionContext.KEY);

            if (user == null) {
                try {
                    SessionContext.logoutContext();    
                    ec.redirect(ec.getRequestContextPath() + "/login.jsf");
                } catch (IOException ex) {
                    Logger.getLogger(AutenticacaoPhaseListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
        
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }


}
