/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.exception;

import java.io.Serializable;

/**
 *
 * @author LUISPORTELA
 */
public class FacadeException extends Exception implements Serializable{
    
    private static final long serialVersionUID = 1L;

    public FacadeException() {
    }

    public FacadeException(String message) {
        super(message);
    }

    public FacadeException(Throwable cause) {
        super(cause);
    }

    public FacadeException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
