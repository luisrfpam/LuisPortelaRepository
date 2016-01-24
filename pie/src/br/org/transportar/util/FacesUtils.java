/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.util;

import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class FacesUtils {

	private final FacesContext facesContext;

	public FacesUtils(FacesContext facesContext) {
		this.facesContext = facesContext;
	}
	
	public void adicionaMensagemDeErro(String msg) {
		facesContext.addMessage(null, 
			new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	}

	public void adicionaMensagemDeInformacao(String msg) {
		facesContext.addMessage(null, 
			new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}

	public boolean possuiMensagem(String msg) {
		Iterator<FacesMessage> messages = facesContext.getMessages();
		while (messages.hasNext()) {
			FacesMessage message = messages.next();
			boolean confere = message.getDetail().equals(msg);
			if (confere)
				return true;
		}
		return false;
	}
	
	/**
     * Limpa os dados dos componentes de edição e de seus filhos,
     * recursivamente. Checa se o componente é instância de EditableValueHolder
     * e 'reseta' suas propriedades.
     * <p>
     * Quando este método, por algum motivo, não funcionar, parta para ignorância
     * e limpe o componente assim:
     * <p><blockquote><pre>
     * component.getChildren().clear()
     * </pre></blockquote>
     * :-)
     * 
     * Método fornecido por Rafael Pontes.
     * 
     * Alterado Por: Danilo Magrini
     */
    public static void cleanSubmittedValues(UIComponent component){
        if (component instanceof EditableValueHolder) {
            EditableValueHolder evh = (EditableValueHolder) component;
            evh.setSubmittedValue(null);
            evh.setValue(null);
            evh.setLocalValueSet(false);
            evh.setValid(true);
        }
        // Dependendo de como se implementa um Composite Component, ele retorna ZERO
        // na busca por filhos. Nesse caso devemos iterar sobre os componentes que o 
        // compõe de forma diferente.
        if(UIComponent.isCompositeComponent(component)) {
            Iterator i = component.getFacetsAndChildren();
            while(i.hasNext()) {
                UIComponent comp = (UIComponent) i.next();

                //TODO: isolar em um método?
                if (comp.getChildCount() > 0) {
                    for (UIComponent child : comp.getChildren()) {
                        cleanSubmittedValues(child);
                    }
                }
            }
        }
        //TODO: isolar em um método?
        if (component.getChildCount() > 0) {
            for (UIComponent child : component.getChildren()) {
                cleanSubmittedValues(child);
            }
        }
    }
	
}