/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.controllers;

import br.org.transportar.entities.Tbactivite;
import br.org.transportar.entities.Tblancamentoelementoimport;
import br.org.transportar.entities.Tblancamentoservicoimport;
import br.org.transportar.entities.Tblancamentoshorasimport;
import br.org.transportar.entities.Tbproject;
import br.org.transportar.entities.Tbshift;
import br.org.transportar.entities.Tbuser;
import br.org.transportar.facade.LancamentoElementoImportFacade;
import br.org.transportar.messages.FacesMessageUtil;
import br.org.transportar.util.CsvUtil;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author LUISPORTELA
 */
@ManagedBean(name = "importBean")
@ViewScoped
public class ImportBean implements Serializable {
    
    static final long serialVersionUID = 1L;
    
    private final String BACK = "";
    
    public static final String NOME_CORTE = "CORTE";
    
    public static final String NOME_SOLDA = "SOLDA";
    
    public static final String NOME_MONTAGEM = "MONTAGEM";    
    
    public UploadedFile file;
    
    public String tipoImport;
    
    public String periodoImport;
    
    public Tbproject projeto;
    
    public Set<Tbuser> funcionarios;
    
    public Set<Tbproject> projetos;
    
    public Set<Tbactivite> atividades;
    
    public Set<Tbshift> turnos;
    
    public Tblancamentoelementoimport lancamentoElementoImport;
    
    public Tblancamentoservicoimport lancamentoServicoImport;
    
    public Tblancamentoshorasimport lancamentoHorasImport;
    
    public LancamentoElementoImportFacade facade;
    
    @PostConstruct
    public void init() {
        this.tipoImport = "H";
        this.periodoImport = "M";   
        this.facade = new LancamentoElementoImportFacade();
    }
    
    public void upload() throws IOException {
        
        boolean encontrouErroPlanilha = false;
        boolean estruturaInvalida = false;  
        String nomeProjeto = null;
        String idBloco = null;
        String dia = null;
        String mes = null;
        String ano = null;
        
        int coluna;
        int linha = 0;
        
        if (!file.getFileName().isEmpty()) {
            
            if (this.tipoImport.equals("C")) {
                if (!file.getFileName().toUpperCase().startsWith(NOME_CORTE)) {
                    FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_erro_importacao", null), null);
                    FacesContext.getCurrentInstance().validationFailed();  
                }
            } else if (this.tipoImport.equals("S")) {
                if (!file.getFileName().toUpperCase().startsWith(NOME_SOLDA)) {
                    FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_erro_importacao", null), null);
                    FacesContext.getCurrentInstance().validationFailed();  
                }            
            } else if (this.tipoImport.equals("P")){
                if (!file.getFileName().toUpperCase().startsWith(NOME_MONTAGEM)) {
                    FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_erro_importacao", null), null);
                    FacesContext.getCurrentInstance().validationFailed();  
                }
            }

            //if (this.tipoImport.equals("C") || this.tipoImport.equals("S") || this.tipoImport.equals("P")) {
            if (this.tipoImport.equals("C")) {
                String[] values = file.getFileName().split("_");
                if (values.length != 2) {
                    FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_erro_importacao", null), null);
                    FacesContext.getCurrentInstance().validationFailed();  
                } else if (values.length == 2) {
                    if (this.periodoImport.equals("M")) {                    
                        if (values[1].length() != 10) {
                            FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_erro_importacao", null), null);
                            FacesContext.getCurrentInstance().validationFailed();  
                        } 
                    } else if (this.periodoImport.equals("D")) {
                        if (values[1].length() != 12) {
                            FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_erro_importacao", null), null);
                            FacesContext.getCurrentInstance().validationFailed();  
                        }  
                    }                
                    if (this.periodoImport.equals("M") || this.periodoImport.equals("D")){
                        try {                        

                            SimpleDateFormat formatter = null;

                            Date date = null;

                            if (this.periodoImport.equals("M")) {
                                mes = values[1].substring(0, 2);
                                ano = values[1].substring(2, 6);
                                formatter = new SimpleDateFormat("MM/yyyy");
                                formatter.parse(mes + "/" + ano);
                            } else if (this.periodoImport.equals("D")) {
                                dia = values[1].substring(0, 2);
                                mes = values[1].substring(2, 4);
                                ano = values[1].substring(4, 8);
                                formatter = new SimpleDateFormat("dd/MM/yyyy");
                                formatter.parse(dia + "/" + mes + "/" + ano);
                            } 

                        } catch (ParseException e) {
                            FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_erro_importacao", null), null);
                            FacesContext.getCurrentInstance().validationFailed();  
                        }
                    }
                }
            }       

            if (this.tipoImport.equals("P")) {
                String[] valuesCSV = file.getFileName().toLowerCase().split(".csv");   
                String[] values = valuesCSV[0].split("_");   
                if (values.length != 2) {
                    FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_erro_importacao", null), null);
                    FacesContext.getCurrentInstance().validationFailed();  
                } else if (values.length == 2) {   
                    if (!this.projeto.getNomeProjeto().equalsIgnoreCase(values[1].toUpperCase())){
                        FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_erro_importacao_nome_projeto", null), null);
                        FacesContext.getCurrentInstance().validationFailed();  
                    } else {
                        nomeProjeto = values[1].toUpperCase();
                    }                    
                }
            }

            if (this.tipoImport.equals("S")) {
                String[] valuesCSV = file.getFileName().toLowerCase().split(".csv");   
                String[] values = valuesCSV[0].split("_");            
                if (values.length != 3) {
                    FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_erro_importacao", null), null);
                    FacesContext.getCurrentInstance().validationFailed();  
                } else if (values.length == 3) { 
                    
                    if (!this.projeto.getNomeProjeto().equalsIgnoreCase(values[1].toUpperCase())){
                        FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_erro_importacao_nome_projeto", null), null);
                        FacesContext.getCurrentInstance().validationFailed();  
                    } else {
                        nomeProjeto = values[1].toUpperCase();
                        idBloco = values[2].toUpperCase();
                    }  
                    
                }
            }

            List<List<String>> csvList = CsvUtil.parseCsv(file.getInputstream(), ';');

            if (this.tipoImport.equals("C")) {

                if (this.periodoImport.equals("M")) {
                    this.facade.removeLancamentoElementoImportByDate(mes, ano);
                } else if (this.periodoImport.equals("D")) {
                    this.facade.removeLancamentoElementoImportByDate(dia, mes, ano);
                }

                for (Iterator<List<String>> iterator = csvList.iterator(); iterator.hasNext();) {
                    List<String> next = iterator.next(); 

                    this.lancamentoElementoImport = new Tblancamentoelementoimport();

                    for (Iterator<String> iterator1 = next.iterator(); iterator1.hasNext();) {
                        String next1 = iterator1.next();
                        coluna = next.indexOf(next1); 

                        if (linha == 13) {                    

                            //ARQUIVO	PART No.	ESPESSURA (mm)	ÍTEM	QTDE	PESO DA PEÇA (Kg)	PESO TOTAL(Kg)	OBRA	TURNO	DATA
                            switch (coluna) {
                                case 2:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("part")){
                                            estruturaInvalida = true;
                                        }
                                    }                            
                                    break;

                                case 3:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("esp")){
                                            estruturaInvalida = true;
                                        }
                                    }                             
                                    break;

                                /*
                                case 4:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("tem")){
                                            estruturaInvalida = true;
                                        }
                                    } 
                                    break;
                                */
                                case 4:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("qtd")){
                                            estruturaInvalida = true;
                                        }
                                    }                            
                                    break;

                                case 5:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("peso")){
                                            estruturaInvalida = true;
                                        }
                                    }                             
                                    break;

                                case 7:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("obra")){
                                            estruturaInvalida = true;
                                        }
                                    } 
                                    break;

                                case 9:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("data")){
                                            estruturaInvalida = true;
                                        }
                                    } 
                                    break;
                            }

                        }

                        if (linha >= 14 && !csvList.get(linha).get(2).isEmpty()) {

                            switch (coluna) {
                                case 2:
                                    this.lancamentoElementoImport.setIdPeca(next1);
                                    break;

                                case 3:
                                    if (!next1.isEmpty()) {
                                        try {
                                            this.lancamentoElementoImport.setValorEsp(new BigDecimal(next1.replace(".", "").replace(",", ".")));
                                        } catch (Exception e) {
                                            encontrouErroPlanilha = true;
                                            e.printStackTrace();
                                        }                                    
                                    }                            
                                    break;
                                
                                /*
                                case 4:
                                    this.lancamentoElementoImport.setNomeItem(next1);
                                    break;
                                */
                                //5
                                case 4:
                                    if (!next1.isEmpty()) {
                                        try {
                                            this.lancamentoElementoImport.setQtUtilizado(new BigDecimal(next1.replace(".", "").replace(",", ".")));
                                        } catch (Exception e) {
                                            encontrouErroPlanilha = true;
                                            e.printStackTrace();
                                        }                                     
                                    }                            
                                    break;
                                //6
                                case 5:
                                    if (!next1.isEmpty()) {
                                        try {
                                            this.lancamentoElementoImport.setPesoPeca(new BigDecimal(next1.replace(".", "").replace(",", ".")));
                                        } catch (Exception e) {
                                            encontrouErroPlanilha = true;
                                            e.printStackTrace();
                                        }                                     
                                    }                            
                                    break;
                                //8
                                case 7:
                                    if (!next1.isEmpty()) {  
                                        this.lancamentoElementoImport.setNomeProjeto(next1);
                                    } else {
                                        encontrouErroPlanilha = true;
                                    }
                                    break;
                                //10
                                case 9:
                                    if (!next1.isEmpty()) {
                                        try {
                                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                            this.lancamentoElementoImport.setDtRealizadoCorte(formatter.parse(next1));
                                        } catch (ParseException e) {
                                            encontrouErroPlanilha = true;
                                            e.printStackTrace();
                                        }
                                    } else {
                                        encontrouErroPlanilha = true;
                                    }
                                    break;
                            }

                        }

                    }

                    if (linha >= 14 && !csvList.get(linha).get(2).isEmpty()) {
                        if (!encontrouErroPlanilha) {
                            this.facade.saveLancamentoElementoImport(lancamentoElementoImport);
                        }
                    }

                    linha = linha + 1;
                    encontrouErroPlanilha = false;

                }

            }

            if (this.tipoImport.equals("P")) {

                this.facade.removeLancamentoElementoImportByProjeto(nomeProjeto);

                for (Iterator<List<String>> iterator = csvList.iterator(); iterator.hasNext();) {
                    List<String> next = iterator.next(); 

                    this.lancamentoElementoImport = new Tblancamentoelementoimport();

                    for (Iterator<String> iterator1 = next.iterator(); iterator1.hasNext();) {
                        String next1 = iterator1.next();
                        coluna = next.indexOf(next1); 

                        if (linha == 5) {                    

                            // Bloco	Elementos	L (m)	b (m)	e (m)	Área [m2]	kg/m2	Peso [kg]	Xg[m]	Mom. Xg	Yg[m]	Mom. Yg	zg [m]	Mom. zg	EPCG	PCPP
                            switch (coluna) {
                                case 0:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("bloco")){
                                            estruturaInvalida = true;
                                        }
                                    }                            
                                    break;

                                case 1:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("elemento")){
                                            estruturaInvalida = true;
                                        }
                                    }                             
                                    break;

                                case 7:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("peso")){
                                            estruturaInvalida = true;
                                        }
                                    } 
                                    break;

                                case 14:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("epcg")){
                                            estruturaInvalida = true;
                                        }
                                    }                            
                                    break;

                                case 15:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("pcpp")){
                                            estruturaInvalida = true;
                                        }
                                    }                             
                                    break;                            
                            }

                        }

                        if (linha >= 6 && !csvList.get(linha).get(1).isEmpty()) {

                            switch (coluna) {
                                case 0:
                                    if (!next1.isEmpty()) {  
                                        this.lancamentoElementoImport.setIdBloco(next1);
                                    } else {
                                        encontrouErroPlanilha = true;
                                    }
                                    break;

                                case 1:
                                    if (!next1.isEmpty()) {  
                                        this.lancamentoElementoImport.setIdElemento(next1);
                                    } else {
                                        encontrouErroPlanilha = true;
                                    }
                                    break;

                                case 7:
                                    if (!next1.isEmpty()) {
                                        try {
                                            this.lancamentoElementoImport.setPesoPeca(new BigDecimal(next1.replace(".", "").replace(",", ".")));
                                        } catch (NumberFormatException e) {
                                            encontrouErroPlanilha = true;
                                            e.printStackTrace();
                                        }                                    
                                    }
                                    break;

                                case 14:
                                    if (!next1.isEmpty()) {
                                        if (next1.toLowerCase().equals("ok")) {
                                            this.lancamentoElementoImport.setIsEPCG(true);
                                        } else {
                                            this.lancamentoElementoImport.setIsEPCG(false);
                                        }
                                    }                            
                                    break;

                                case 15:
                                    if (next1.toLowerCase().equals("ok")) {
                                            this.lancamentoElementoImport.setIsPCPP(true);
                                        } else {
                                            this.lancamentoElementoImport.setIsPCPP(false);
                                        }                           
                                    break;

                            }

                        }

                    }

                    if (linha >= 6 && !csvList.get(linha).get(1).isEmpty()) {
                        if (!encontrouErroPlanilha) {
                            this.lancamentoElementoImport.setNomeProjeto(nomeProjeto);
                            this.facade.saveLancamentoElementoImport(this.lancamentoElementoImport);
                        }
                    }

                    linha = linha + 1;
                    encontrouErroPlanilha = false;

                }

            }
            
            if (this.tipoImport.equals("S")) {

                this.facade.removeLancamentoServicoImportByProjeto(nomeProjeto, idBloco);

                for (Iterator<List<String>> iterator = csvList.iterator(); iterator.hasNext();) {
                    List<String> next = iterator.next(); 

                    this.lancamentoServicoImport = new Tblancamentoservicoimport();

                    for (Iterator<String> iterator1 = next.iterator(); iterator1.hasNext();) {
                        String next1 = iterator1.next();
                        coluna = next.indexOf(next1); 

                        if (linha == 8) {                    

                            //  CAV	Descrição	Bordo	Região	Tipo de solda	Posição	Espaço	Comp. (mm)	Qnt	Comp. total da solda (mm)	Status	Controle de Qualidade	

                            switch (coluna) {
                                case 1:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("descri")){
                                            estruturaInvalida = true;
                                        }
                                    }                            
                                    break;

                                case 2:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("bordo")){
                                            estruturaInvalida = true;
                                        }
                                    }                             
                                    break;

                                case 3:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("regi")){
                                            estruturaInvalida = true;
                                        }
                                    } 
                                    break;

                                case 4:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("tipo")){
                                            estruturaInvalida = true;
                                        }
                                    }                            
                                    break;

                                case 5:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("posi")){
                                            estruturaInvalida = true;
                                        }
                                    }                             
                                    break;     
                                    
                                case 6:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("espa")){
                                            estruturaInvalida = true;
                                        }
                                    }                             
                                    break;
                                
                                case 7:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("comp")){
                                            estruturaInvalida = true;
                                        }
                                    }                             
                                    break;
                                    
                                case 8:
                                    if (!next1.isEmpty()) {
                                        if(!next1.toLowerCase().contains("qnt")){
                                            estruturaInvalida = true;
                                        }
                                    }                             
                                    break;
                            }

                        }

                        if (linha >= 10 && !csvList.get(linha).get(1).isEmpty()) {

                            switch (coluna) {
                                case 1:
                                    if (!next1.isEmpty()) {  
                                        this.lancamentoServicoImport.setDescricaoCaverna(next1);
                                    } else {
                                        encontrouErroPlanilha = true;
                                    }
                                    break;

                                case 2:
                                    if (!next1.isEmpty()) {  
                                        this.lancamentoServicoImport.setIdBordo(next1);
                                    } else {
                                        encontrouErroPlanilha = true;
                                    }
                                    break;
                                    
                                case 3:
                                    if (!next1.isEmpty()) {  
                                        this.lancamentoServicoImport.setIdRegiao(next1);
                                    } else {
                                        encontrouErroPlanilha = true;
                                    }
                                    break;
                                    
                                case 4:
                                    if (!next1.isEmpty()) {  
                                        if (next1.contains("ngulo")) {
                                            this.lancamentoServicoImport.setIdTipoSolda("Ângulo");
                                        }
                                        this.lancamentoServicoImport.setIdTipoSolda(next1);
                                    } else {
                                        encontrouErroPlanilha = true;
                                    }
                                    break;
                                 
                                case 5:
                                    if (!next1.isEmpty()) {  
                                        this.lancamentoServicoImport.setIdPosicao(next1);
                                    } else {
                                        encontrouErroPlanilha = true;
                                    }
                                    break;
                                    
                                case 6:
                                    if (!next1.isEmpty()) {  
                                        this.lancamentoServicoImport.setIdEspaco(next1);
                                    } else {
                                        encontrouErroPlanilha = true;
                                    }
                                    break;                                   

                                case 7:
                                    if (!next1.isEmpty()) {
                                        try {
                                            this.lancamentoServicoImport.setValorComprimento(new BigDecimal(next1.replace(".", "").replace(",", ".")));
                                        } catch (NumberFormatException e) {
                                            encontrouErroPlanilha = true;
                                            e.printStackTrace();
                                        }                                    
                                    }
                                    break;

                                case 8:
                                    if (!next1.isEmpty()) {
                                        try {
                                            this.lancamentoServicoImport.setQtdUtilizado(new Integer(next1));
                                        } catch (NumberFormatException e) {
                                            encontrouErroPlanilha = true;
                                            e.printStackTrace();
                                        }                                    
                                    }
                                    break;

                            }

                        }

                    }

                    if (linha >= 10 && !csvList.get(linha).get(1).isEmpty()) {
                        if (!encontrouErroPlanilha) {
                            this.lancamentoServicoImport.setNomeProjeto(nomeProjeto);
                            this.lancamentoServicoImport.setDescricaoBloco(idBloco);
                            this.facade.saveLancamentoServicoImport(this.lancamentoServicoImport);
                        }
                    }

                    linha = linha + 1;
                    encontrouErroPlanilha = false;

                }

            }
            
            if (estruturaInvalida) {
                FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_erro_importacao_lancamento", null), null);
                FacesContext.getCurrentInstance().validationFailed();
            }
            
            if (!encontrouErroPlanilha) {
                FacesMessageUtil.addInfoMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_sucesso_importacao", null), null);  
            } else {
                FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_msg_erro_importacao_lancamento_elemento", null), null);
                FacesContext.getCurrentInstance().validationFailed();
            }
                      
        } else {
            FacesMessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "msgsGrowl", FacesMessageUtil.getMessage("label_required_arquivo_importacao", null), null);
            FacesContext.getCurrentInstance().validationFailed();            
        }       
                             
        this.file = null;        
    }    
    
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getTipoImport() {
        return tipoImport;
    }

    public void setTipoImport(String tipoImport) {
        this.tipoImport = tipoImport;
    }

    public Tbproject getProjeto() {
        return projeto;
    }

    public void setProjeto(Tbproject projeto) {
        this.projeto = projeto;
    }

    public String getPeriodoImport() {
        return periodoImport;
    }

    public void setPeriodoImport(String periodoImport) {
        this.periodoImport = periodoImport;
    }   

    public Set<Tbuser> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<Tbuser> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Set<Tbproject> getProjetos() {
        return projetos;
    }

    public void setProjetos(Set<Tbproject> projetos) {
        this.projetos = projetos;
    }

    public Set<Tbactivite> getAtividades() {
        return atividades;
    }

    public void setAtividades(Set<Tbactivite> atividades) {
        this.atividades = atividades;
    }

    public Set<Tbshift> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Tbshift> turnos) {
        this.turnos = turnos;
    }

    public Tblancamentoelementoimport getLancamentoElementoImport() {
        return lancamentoElementoImport;
    }

    public void setLancamentoElementoImport(Tblancamentoelementoimport lancamentoElementoImport) {
        this.lancamentoElementoImport = lancamentoElementoImport;
    }

    public LancamentoElementoImportFacade getFacade() {
        return facade;
    }

    public void setFacade(LancamentoElementoImportFacade facade) {
        this.facade = facade;
    }    

    public Tblancamentoservicoimport getLancamentoServicoImport() {
        return lancamentoServicoImport;
    }

    public void setLancamentoServicoImport(Tblancamentoservicoimport lancamentoServicoImport) {
        this.lancamentoServicoImport = lancamentoServicoImport;
    }

    public Tblancamentoshorasimport getLancamentoHorasImport() {
        return lancamentoHorasImport;
    }

    public void setLancamentoHorasImport(Tblancamentoshorasimport lancamentoHorasImport) {
        this.lancamentoHorasImport = lancamentoHorasImport;
    }
    
               
}
