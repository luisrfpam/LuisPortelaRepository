/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.generics;

import java.util.List;
import java.util.Map;

/**
 *
 * @author LUISPORTELA
 */
public interface DAO<E> {
    
    public E recuperarPorId(Object id) ;    
    public void salvar(E entidade) throws Exception;
    public void atualizar(E entidade) throws Exception;
    public void excluir(E entidade);
    public void excluir(String queryString, Map<String, Object> params);
    public List<E> listarTodos();   
    public List<E> recuperarListaPorNamedQuery(String namedQuery, Map<String, Object> params);
    public List<E> recuperarListaPorNamedQuery(String namedQuery);
    public E recuperarEntidadePorNamedQuery(String namedQuery, Map<String, Object> params);
    public E recuperarEntidadePorNamedQuery(String namedQuery);
    public List<E> listar(String queryString, Map<String, Object> params);
    
}
