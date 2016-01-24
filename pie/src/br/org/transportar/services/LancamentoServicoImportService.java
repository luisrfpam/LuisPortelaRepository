/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.services;

import br.org.transportar.dao.LancamentoServicoImportDAO;
import br.org.transportar.entities.Tblancamentoservicoimport;
import br.org.transportar.generics.AbstractService;
import br.org.transportar.generics.DAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LUISPORTELA
 */
public class LancamentoServicoImportService extends AbstractService<Tblancamentoservicoimport>{
    
    private DAO<Tblancamentoservicoimport> dao;

    @Override
    public DAO<Tblancamentoservicoimport> getDAO() {
        if (dao == null) {
            dao = new LancamentoServicoImportDAO();
        }
        return dao;
    }    
    
    public void saveLancamentoServicoImport(Tblancamentoservicoimport lancamentoServicoImport) throws Exception {
        getDAO().salvar(lancamentoServicoImport);
    }
    
    public void updateLancamentoServicoImport(Tblancamentoservicoimport lancamentoServicoImport) throws Exception {
        getDAO().atualizar(lancamentoServicoImport);
    }
    
    public List<Tblancamentoservicoimport> getAllLancamentosServicosImport(){
        return getDAO().listarTodos();
    }    
    
    public void removeLancamentosImportByProjeto(String nomeProjeto, String idBloco){
        Map<String, Object> params = new HashMap<>(); 
        String q = "DELETE FROM Tblancamentoservicoimport t WHERE t.nomeProjeto= :nomeProjeto ";
        
        if (idBloco != null) {
            params.put("idBloco", idBloco);
            q = q + " AND t.descricaoBloco= :idBloco";
        }
        if (nomeProjeto != null) {
            params.put("nomeProjeto", nomeProjeto);
        }
        
        getDAO().excluir(q, params);
    }
    
    public List<Tblancamentoservicoimport> getAllLancamentosImportSoldasWLike(String nomeProjeto){        
        Map<String, Object> params = new HashMap<>();
        if (nomeProjeto == null) {
            nomeProjeto = new String();
        }
        nomeProjeto = "%"+nomeProjeto+"%";       
        params.put("nomeProjeto", nomeProjeto);        
        return getDAO().recuperarListaPorNamedQuery(Tblancamentoservicoimport.LISTAR_SOLDAS_BY_PROJETO, params);
    }
    
}
