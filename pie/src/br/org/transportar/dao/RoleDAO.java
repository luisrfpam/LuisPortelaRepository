/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.dao;

import br.org.transportar.entities.Tbrole;
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
public class RoleDAO implements DAO<Tbrole>{

    @Override
    public Tbrole recuperarPorId(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Tbrole entidade) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        if (entidade.getId() == null) {
            em.persist(entidade);
        } else {
            em.merge(entidade);
        }       
        JpaUtil.evictCache(em, Tbrole.LISTAR_DESTAQUES);
    }

    @Override
    public void excluir(Tbrole entidade) {
        EntityManager em = JpaUtil.getEntityManager();
        em.remove(entidade);
    }

    @Override
    public List<Tbrole> listarTodos() {
        return JpaUtil.getEntityManager().createNamedQuery(Tbrole.LISTAR_DESTAQUES, Tbrole.class).getResultList();
    }

    @Override
    public List<Tbrole> listar(String queryString, Map<String, Object> params) {
        //JpaUtil.getEntityManager().createQuery(queryString, Tbrole.class);
        TypedQuery<Tbrole> query = JpaUtil.getEntityManager().createQuery(queryString, Tbrole.class);
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query.getResultList();
    }

    @Override
    public List<Tbrole> recuperarListaPorNamedQuery(String namedQuery, Map<String, Object> params) {
        Query query = JpaUtil.getEntityManager().createNamedQuery(namedQuery, Tbrole.class);         
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query.getResultList();
    }

    @Override
    public Tbrole recuperarEntidadePorNamedQuery(String namedQuery, Map<String, Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Tbrole entidade) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        em.merge(entidade);
        JpaUtil.evictCache(em, Tbrole.LISTAR_DESTAQUES);
    }

    @Override
    public List<Tbrole> recuperarListaPorNamedQuery(String namedQuery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tbrole recuperarEntidadePorNamedQuery(String namedQuery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(String queryString, Map<String, Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
