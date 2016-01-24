/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.services;

import br.org.transportar.dao.LancamentoHoraDAO;
import br.org.transportar.entities.Tblancamentoshoras;
import br.org.transportar.generics.AbstractService;
import br.org.transportar.generics.DAO;
import java.util.List;

/**
 *
 * @author LUISPORTELA
 */
public class ImportHoraHomemService extends AbstractService<Tblancamentoshoras>{
    
    private DAO<Tblancamentoshoras> dao;

    @Override
    public DAO<Tblancamentoshoras> getDAO() {
        if (dao == null) {
            dao = new LancamentoHoraDAO();
        }
        return dao;
    }    
    
    public void saveLancamentoHoraHomem(Tblancamentoshoras lancHoraHomem) throws Exception {
        getDAO().salvar(lancHoraHomem);
    }
    
    public void updateActivite(Tblancamentoshoras lancHoraHomem) throws Exception {
        getDAO().atualizar(lancHoraHomem);
    }
    
    public List<Tblancamentoshoras> getAllLancamentosHoraHomem(){
        return getDAO().listarTodos();
    }    
    
}
