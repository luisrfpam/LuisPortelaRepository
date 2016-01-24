/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.dao;

import br.org.transportar.entities.Tbcontract;
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
public class ContractDAO implements DAO<Tbcontract>{

    @Override
    public Tbcontract recuperarPorId(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Tbcontract entidade) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        if (entidade.getId()== null) {
            em.persist(entidade);  
        } else {
            em.merge(entidade);
        } 
        JpaUtil.evictCache(em, Tbcontract.LISTAR_DESTAQUES);
    }

    @Override
    public void excluir(Tbcontract entidade) {
        EntityManager em = JpaUtil.getEntityManager();
        em.remove(entidade);
    }

    @Override
    public List<Tbcontract> listarTodos() {
        return JpaUtil.getEntityManager().createNamedQuery(Tbcontract.LISTAR_DESTAQUES, Tbcontract.class).getResultList();
    }

    @Override
    public List<Tbcontract> listar(String queryString, Map<String, Object> params) {
        //JpaUtil.getEntityManager().createQuery(queryString, Tbcontract.class);
        TypedQuery<Tbcontract> query = JpaUtil.getEntityManager().createQuery(queryString, Tbcontract.class);
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query.getResultList();
    }

    @Override
    public List<Tbcontract> recuperarListaPorNamedQuery(String namedQuery, Map<String, Object> params) {
        Query query = JpaUtil.getEntityManager().createNamedQuery(namedQuery, Tbcontract.class);         
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query.getResultList();
    }

    @Override
    public Tbcontract recuperarEntidadePorNamedQuery(String namedQuery, Map<String, Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Tbcontract entidade) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        em.merge(entidade);
        JpaUtil.evictCache(em, Tbcontract.LISTAR_DESTAQUES);
    }

    @Override
    public List<Tbcontract> recuperarListaPorNamedQuery(String namedQuery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tbcontract recuperarEntidadePorNamedQuery(String namedQuery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(String queryString, Map<String, Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
