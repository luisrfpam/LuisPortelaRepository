/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.dao;

import br.org.transportar.entities.Tblancamentoelementoimport;
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
public class LancamentoElementoImportDAO implements DAO<Tblancamentoelementoimport>{

    @Override
    public Tblancamentoelementoimport recuperarPorId(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Tblancamentoelementoimport entidade) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        if (entidade.getIdLancamentoElemento()== null) {
            em.persist(entidade);
        } else {
            em.merge(entidade);
        }       
        JpaUtil.evictCache(em, Tblancamentoelementoimport.LISTAR_DESTAQUES);
    }

    @Override
    public void excluir(Tblancamentoelementoimport entidade) {
        EntityManager em = JpaUtil.getEntityManager();
        em.remove(entidade);
    }

    @Override
    public List<Tblancamentoelementoimport> listarTodos() {
        return JpaUtil.getEntityManager().createNamedQuery(Tblancamentoelementoimport.LISTAR_DESTAQUES, Tblancamentoelementoimport.class).getResultList();
    }

    @Override
    public List<Tblancamentoelementoimport> listar(String queryString, Map<String, Object> params) {
        //JpaUtil.getEntityManager().createQuery(queryString, Tblancamentoelementoimport.class);
        TypedQuery<Tblancamentoelementoimport> query = JpaUtil.getEntityManager().createQuery(queryString, Tblancamentoelementoimport.class);
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query.getResultList();
    }

    @Override
    public List<Tblancamentoelementoimport> recuperarListaPorNamedQuery(String namedQuery, Map<String, Object> params) {
        Query query = JpaUtil.getEntityManager().createNamedQuery(namedQuery, Tblancamentoelementoimport.class);         
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query.getResultList();
    }

    @Override
    public Tblancamentoelementoimport recuperarEntidadePorNamedQuery(String namedQuery, Map<String, Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Tblancamentoelementoimport entidade) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        em.merge(entidade);
        JpaUtil.evictCache(em, Tblancamentoelementoimport.LISTAR_DESTAQUES);
    }

    @Override
    public List<Tblancamentoelementoimport> recuperarListaPorNamedQuery(String namedQuery) {
        Query query = JpaUtil.getEntityManager().createNamedQuery(namedQuery, Tblancamentoelementoimport.class); 
        return query.getResultList();
    }

    @Override
    public Tblancamentoelementoimport recuperarEntidadePorNamedQuery(String namedQuery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(String queryString, Map<String, Object> params) {
        Query query = JpaUtil.getEntityManager().createQuery(queryString);
        for (Map.Entry<String, Object> param : params.entrySet()) {            
            query.setParameter(param.getKey(), new Integer(param.getValue().toString()));
        }
        query.executeUpdate();
    }

    
}
