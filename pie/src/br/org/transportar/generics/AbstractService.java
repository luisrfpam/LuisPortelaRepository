    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.generics;

/**
 *
 * @author LUISPORTELA
 */
public abstract class AbstractService<E> {

    public AbstractService() {
    }
    
    public abstract DAO<E> getDAO();
    
    // others services
    
}
