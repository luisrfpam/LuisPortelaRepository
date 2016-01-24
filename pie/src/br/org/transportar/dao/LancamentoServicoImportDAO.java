/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.dao;

import br.org.transportar.entities.Tblancamentoservicoimport;
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
public class LancamentoServicoImportDAO implements DAO<Tblancamentoservicoimport>{

    @Override
    public Tblancamentoservicoimport recuperarPorId(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Tblancamentoservicoimport entidade) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        if (entidade.getIdLancamentoServico()== null) {
            em.persist(entidade);
        } else {
            em.merge(entidade);
        }       
        JpaUtil.evictCache(em, Tblancamentoservicoimport.LISTAR_DESTAQUES);
    }

    @Override
    public void excluir(Tblancamentoservicoimport entidade) {
        EntityManager em = JpaUtil.getEntityManager();
        em.remove(entidade);
    }

    @Override
    public List<Tblancamentoservicoimport> listarTodos() {
        return JpaUtil.getEntityManager().createNamedQuery(Tblancamentoservicoimport.LISTAR_DESTAQUES, Tblancamentoservicoimport.class).getResultList();
    }

    @Override
    public List<Tblancamentoservicoimport> listar(String queryString, Map<String, Object> params) {
        //JpaUtil.getEntityManager().createQuery(queryString, Tblancamentoservicoimport.class);
        TypedQuery<Tblancamentoservicoimport> query = JpaUtil.getEntityManager().createQuery(queryString, Tblancamentoservicoimport.class);
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query.getResultList();
    }

    @Override
    public List<Tblancamentoservicoimport> recuperarListaPorNamedQuery(String namedQuery, Map<String, Object> params) {
        Query query = JpaUtil.getEntityManager().createNamedQuery(namedQuery, Tblancamentoservicoimport.class);         
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query.getResultList();
    }

    @Override
    public Tblancamentoservicoimport recuperarEntidadePorNamedQuery(String namedQuery, Map<String, Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Tblancamentoservicoimport entidade) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        em.merge(entidade);
        JpaUtil.evictCache(em, Tblancamentoservicoimport.LISTAR_DESTAQUES);
    }

    @Override
    public List<Tblancamentoservicoimport> recuperarListaPorNamedQuery(String namedQuery) {
        Query query = JpaUtil.getEntityManager().createNamedQuery(namedQuery, Tblancamentoservicoimport.class); 
        return query.getResultList();
    }

    @Override
    public Tblancamentoservicoimport recuperarEntidadePorNamedQuery(String namedQuery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(String queryString, Map<String, Object> params) {
        Query query = JpaUtil.getEntityManager().createQuery(queryString);
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        query.executeUpdate();
    }

    
}
