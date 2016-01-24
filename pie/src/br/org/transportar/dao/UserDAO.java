/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.dao;

import br.org.transportar.entities.Tbuser;
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
public class UserDAO implements DAO<Tbuser>{

    @Override
    public Tbuser recuperarPorId(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    @Override
    public void salvar(Tbuser entidade) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();        
        if (entidade.getId()== null) {
            em.persist(entidade);
        } else {
            em.merge(entidade);
        }       
        JpaUtil.evictCache(em, Tbuser.LISTAR_DESTAQUES);
    }

    @Override
    public void excluir(Tbuser entidade) {
        EntityManager em = JpaUtil.getEntityManager();
        em.remove(entidade);
    }

    @Override
    public List<Tbuser> listarTodos() {
        return JpaUtil.getEntityManager().createNamedQuery(Tbuser.LISTAR_DESTAQUES, Tbuser.class).getResultList();
    }

    @Override
    public List<Tbuser> listar(String queryString, Map<String, Object> params) {
        //JpaUtil.getEntityManager().createQuery(queryString, Tbuser.class);
        TypedQuery<Tbuser> query = JpaUtil.getEntityManager().createQuery(queryString, Tbuser.class);
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query.getResultList();
    }

    @Override
    public Tbuser recuperarEntidadePorNamedQuery(String namedQuery, Map<String, Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tbuser> recuperarListaPorNamedQuery(String namedQuery, Map<String, Object> params) {
        Query query = JpaUtil.getEntityManager().createNamedQuery(namedQuery, Tbuser.class);         
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query.getResultList();
    }

    @Override
    public void atualizar(Tbuser entidade) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        em.merge(entidade);
        JpaUtil.evictCache(em, Tbuser.LISTAR_DESTAQUES);
    }

    @Override
    public List<Tbuser> recuperarListaPorNamedQuery(String namedQuery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tbuser recuperarEntidadePorNamedQuery(String namedQuery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(String queryString, Map<String, Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
