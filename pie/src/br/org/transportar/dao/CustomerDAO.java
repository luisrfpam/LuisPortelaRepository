/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.dao;

import br.org.transportar.entities.Tbcustomer;
import br.org.transportar.generics.DAO;
import br.org.transportar.util.JpaUtil;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author LUISPORTELA
 */
public class CustomerDAO implements DAO<Tbcustomer>{

    @Override
    public Tbcustomer recuperarPorId(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Tbcustomer entidade) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        if (entidade.getId()== null) {
            em.persist(entidade);
        } else {
            em.merge(entidade);
        }       
        JpaUtil.evictCache(em, Tbcustomer.LISTAR_DESTAQUES);
    }

    @Override
    public void excluir(Tbcustomer entidade) {
        EntityManager em = JpaUtil.getEntityManager();
        em.remove(entidade);
    }

    @Override
    public List<Tbcustomer> listarTodos() {
        return JpaUtil.getEntityManager().createNamedQuery(Tbcustomer.LISTAR_DESTAQUES, Tbcustomer.class).getResultList();
    }

    @Override
    public List<Tbcustomer> listar(String queryString, Map<String, Object> params) {
        //JpaUtil.getEntityManager().createQuery(queryString, Tbcustomer.class);
        TypedQuery<Tbcustomer> query = JpaUtil.getEntityManager().createQuery(queryString, Tbcustomer.class);
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query.getResultList();
    }

    @Override
    public List<Tbcustomer> recuperarListaPorNamedQuery(String namedQuery, Map<String, Object> params) {
        Query query = JpaUtil.getEntityManager().createNamedQuery(namedQuery, Tbcustomer.class);         
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query.getResultList();
    }

    @Override
    public Tbcustomer recuperarEntidadePorNamedQuery(String namedQuery, Map<String, Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Tbcustomer entidade) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        em.merge(entidade);
        JpaUtil.evictCache(em, Tbcustomer.LISTAR_DESTAQUES);
    }

    @Override
    public List<Tbcustomer> recuperarListaPorNamedQuery(String namedQuery) {
        Query query = JpaUtil.getEntityManager().createNamedQuery(namedQuery, Tbcustomer.class);        
        return query.getResultList();
    }

    @Override
    public Tbcustomer recuperarEntidadePorNamedQuery(String namedQuery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(String queryString, Map<String, Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
