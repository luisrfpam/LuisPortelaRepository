/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.services;

import br.org.transportar.dao.LancamentoElementoImportDAO;
import br.org.transportar.entities.Tblancamentoelementoimport;
import br.org.transportar.generics.AbstractService;
import br.org.transportar.generics.DAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LUISPORTELA
 */
public class LancamentoElementoImportService extends AbstractService<Tblancamentoelementoimport>{
    
    private DAO<Tblancamentoelementoimport> dao;

    @Override
    public DAO<Tblancamentoelementoimport> getDAO() {
        if (dao == null) {
            dao = new LancamentoElementoImportDAO();
        }
        return dao;
    }    
    
    public void saveLancamentoElementoImport(Tblancamentoelementoimport lancamentoElementoImport) throws Exception {
        getDAO().salvar(lancamentoElementoImport);
    }
    
    public void updateLancamentoElementoImport(Tblancamentoelementoimport lancamentoElementoImport) throws Exception {
        getDAO().atualizar(lancamentoElementoImport);
    }
    
    public List<Tblancamentoelementoimport> getAllLancamentosElementosImport(){
        return getDAO().listarTodos();
    }    
    
    public List<Tblancamentoelementoimport> getAllLancamentosImportMontagens(){           
        return getDAO().recuperarListaPorNamedQuery(Tblancamentoelementoimport.LISTAR_MONTAGENS);
    }
    
    public List<Tblancamentoelementoimport> getAllLancamentosImportCortes(){        
        return getDAO().recuperarListaPorNamedQuery(Tblancamentoelementoimport.LISTAR_CORTES);
    }
    
    public List<Tblancamentoelementoimport> getAllLancamentosImportCortesWLike(String nomeProjeto){        
        Map<String, Object> params = new HashMap<>();
        if (nomeProjeto == null) {
            nomeProjeto = new String();
        }
        nomeProjeto = "%"+nomeProjeto+"%";       
        params.put("nomeProjeto", nomeProjeto);        
        return getDAO().recuperarListaPorNamedQuery(Tblancamentoelementoimport.LISTAR_CORTES_BY_PROJETO, params);
    }
    
    public List<Tblancamentoelementoimport> getAllLancamentosImportMontagensWLike(String nomeProjeto){        
        Map<String, Object> params = new HashMap<>();
        if (nomeProjeto == null) {
            nomeProjeto = new String();
        }
        nomeProjeto = "%"+nomeProjeto+"%";       
        params.put("nomeProjeto", nomeProjeto);        
        return getDAO().recuperarListaPorNamedQuery(Tblancamentoelementoimport.LISTAR_MONTAGENS_BY_PROJETO, params);
    }
    
    public void removeLancamentosImportByProjeto(String nomeProjeto){
        Map<String, Object> params = new HashMap<>(); 
        String q = "DELETE FROM Tblancamentoelementoimport t WHERE t.nomeProjeto= :nomeProjeto ";

        if (nomeProjeto != null) {
            params.put("nomeProjeto", nomeProjeto);
        }
        
        getDAO().excluir(q, params);
    }
    
    public void removeLancamentosImportByDate(String mes, String ano){
        Map<String, Object> params = new HashMap<>(); 
        String q = "DELETE FROM Tblancamentoelementoimport t WHERE MONTH(t.dtRealizadoCorte)= :mes AND YEAR(t.dtRealizadoCorte)= :ano";
        
        if (mes != null) {         
            params.put("mes", mes);
        }  
        
        if (ano != null) {         
            params.put("ano", ano);
        }
        getDAO().excluir(q, params);
    }
    
    public void removeLancamentosImportByDate(String dia, String mes, String ano){
        Map<String, Object> params = new HashMap<>(); 
        String q = "DELETE FROM Tblancamentoelementoimport t WHERE DAY(t.dtRealizadoCorte)= :dia AND MONTH(t.dtRealizadoCorte)= :mes AND YEAR(t.dtRealizadoCorte)= :ano";
        
        if (dia != null) {         
            params.put("dia", mes);
        }
        
        if (mes != null) {         
            params.put("mes", mes);
        }  
        
        if (ano != null) {         
            params.put("ano", ano);
        }
        getDAO().excluir(q, params);
    }
    
}
