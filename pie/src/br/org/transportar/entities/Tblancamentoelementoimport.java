/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LUISPORTELA
 */
@Entity
@Table(name = "tblancamentoelementoimport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Tblancamentoelementoimport.LISTAR_DESTAQUES, query = "SELECT t FROM Tblancamentoelementoimport t"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByIdLancamentoElemento", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.idLancamentoElemento = :idLancamentoElemento"),
    @NamedQuery(name = Tblancamentoelementoimport.LISTAR_CORTES, query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.idPeca IS NOT NULL"),
    @NamedQuery(name = Tblancamentoelementoimport.LISTAR_MONTAGENS, query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.idElemento IS NOT NULL"),    
    @NamedQuery(name = Tblancamentoelementoimport.LISTAR_CORTES_BY_PROJETO, query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.idPeca IS NOT NULL AND t.nomeProjeto LIKE :nomeProjeto"),
    @NamedQuery(name = Tblancamentoelementoimport.LISTAR_MONTAGENS_BY_PROJETO, query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.idElemento IS NOT NULL AND t.nomeProjeto LIKE :nomeProjeto"),    
    @NamedQuery(name = "Tblancamentoelementoimport.findByDescricaoGrupo", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.descricaoGrupo = :descricaoGrupo"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByDtPrevisaoCorte", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.dtPrevisaoCorte = :dtPrevisaoCorte"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByDtRealizadoCorte", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.dtRealizadoCorte = :dtRealizadoCorte"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByValorCG", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.valorCG = :valorCG"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByValorDimensao", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.valorDimensao = :valorDimensao"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByIsImport", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.isImport = :isImport"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByIdElemento", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.idElemento = :idElemento"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByIdBordo", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.idBordo = :idBordo"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByIdPeca", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.idPeca = :idPeca"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByIdBloco", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.idBloco = :idBloco"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByValorEsp", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.valorEsp = :valorEsp"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByQtUtilizado", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.qtUtilizado = :qtUtilizado"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByPesoPeca", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.pesoPeca = :pesoPeca"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByNomeProjeto", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.nomeProjeto = :nomeProjeto"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByNomeItem", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.nomeItem = :nomeItem"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByIsEPCG", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.isEPCG = :isEPCG"),
    @NamedQuery(name = "Tblancamentoelementoimport.findByIsPCPP", query = "SELECT t FROM Tblancamentoelementoimport t WHERE t.isPCPP = :isPCPP")})
public class Tblancamentoelementoimport implements Serializable {
    public static final String LISTAR_DESTAQUES = "Tblancamentoelementoimport.findAll";
    public static final String LISTAR_MONTAGENS = "Tblancamentoelementoimport.findAllMontagens";
    public static final String LISTAR_CORTES = "Tblancamentoelementoimport.findAllCortes";
    public static final String LISTAR_MONTAGENS_BY_PROJETO = "Tblancamentoelementoimport.findAllMontagensByProjeto";
    public static final String LISTAR_CORTES_BY_PROJETO = "Tblancamentoelementoimport.findAllCortesByProjeto";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLancamentoElemento")
    private Long idLancamentoElemento;
    @Size(max = 255)
    @Column(name = "descricaoGrupo")
    private String descricaoGrupo;
    @Column(name = "dtPrevisaoCorte")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPrevisaoCorte;
    @Column(name = "dtRealizadoCorte")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtRealizadoCorte;
    @Size(max = 45)
    @Column(name = "valorCG")
    private String valorCG;
    @Size(max = 45)
    @Column(name = "valorDimensao")
    private String valorDimensao;
    @Column(name = "isImport")
    private Boolean isImport;
    @Size(max = 255)
    @Column(name = "idElemento")
    private String idElemento;
    @Size(max = 255)
    @Column(name = "idBordo")
    private String idBordo;
    @Size(max = 255)
    @Column(name = "idPeca")
    private String idPeca;
    @Size(max = 255)
    @Column(name = "idBloco")
    private String idBloco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorEsp")
    private BigDecimal valorEsp;
    @Column(name = "qtUtilizado")
    private BigDecimal qtUtilizado;
    @Column(name = "pesoPeca")
    private BigDecimal pesoPeca;
    @Size(max = 255)
    @Column(name = "nomeProjeto")
    private String nomeProjeto;
    @Size(max = 255)
    @Column(name = "nomeItem")
    private String nomeItem;
    @Column(name = "isEPCG")
    private Boolean isEPCG;
    @Column(name = "isPCPP")
    private Boolean isPCPP;

    public Tblancamentoelementoimport() {
    }

    public Tblancamentoelementoimport(Long idLancamentoElemento) {
        this.idLancamentoElemento = idLancamentoElemento;
    }

    public Long getIdLancamentoElemento() {
        return idLancamentoElemento;
    }

    public void setIdLancamentoElemento(Long idLancamentoElemento) {
        this.idLancamentoElemento = idLancamentoElemento;
    }

    public String getDescricaoGrupo() {
        return descricaoGrupo;
    }

    public void setDescricaoGrupo(String descricaoGrupo) {
        this.descricaoGrupo = descricaoGrupo;
    }

    public Date getDtPrevisaoCorte() {
        return dtPrevisaoCorte;
    }

    public void setDtPrevisaoCorte(Date dtPrevisaoCorte) {
        this.dtPrevisaoCorte = dtPrevisaoCorte;
    }

    public Date getDtRealizadoCorte() {
        return dtRealizadoCorte;
    }

    public void setDtRealizadoCorte(Date dtRealizadoCorte) {
        this.dtRealizadoCorte = dtRealizadoCorte;
    }

    public String getValorCG() {
        return valorCG;
    }

    public void setValorCG(String valorCG) {
        this.valorCG = valorCG;
    }

    public String getValorDimensao() {
        return valorDimensao;
    }

    public void setValorDimensao(String valorDimensao) {
        this.valorDimensao = valorDimensao;
    }

    public Boolean getIsImport() {
        return isImport;
    }

    public void setIsImport(Boolean isImport) {
        this.isImport = isImport;
    }

    public String getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(String idElemento) {
        this.idElemento = idElemento;
    }

    public String getIdBordo() {
        return idBordo;
    }

    public void setIdBordo(String idBordo) {
        this.idBordo = idBordo;
    }

    public String getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(String idPeca) {
        this.idPeca = idPeca;
    }

    public String getIdBloco() {
        return idBloco;
    }

    public void setIdBloco(String idBloco) {
        this.idBloco = idBloco;
    }

    public BigDecimal getValorEsp() {
        return valorEsp;
    }

    public void setValorEsp(BigDecimal valorEsp) {
        this.valorEsp = valorEsp;
    }

    public BigDecimal getQtUtilizado() {
        return qtUtilizado;
    }

    public void setQtUtilizado(BigDecimal qtUtilizado) {
        this.qtUtilizado = qtUtilizado;
    }

    public BigDecimal getPesoPeca() {
        return pesoPeca;
    }

    public void setPesoPeca(BigDecimal pesoPeca) {
        this.pesoPeca = pesoPeca;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public Boolean getIsEPCG() {
        return isEPCG;
    }

    public void setIsEPCG(Boolean isEPCG) {
        this.isEPCG = isEPCG;
    }

    public Boolean getIsPCPP() {
        return isPCPP;
    }

    public void setIsPCPP(Boolean isPCPP) {
        this.isPCPP = isPCPP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLancamentoElemento != null ? idLancamentoElemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblancamentoelementoimport)) {
            return false;
        }
        Tblancamentoelementoimport other = (Tblancamentoelementoimport) object;
        if ((this.idLancamentoElemento == null && other.idLancamentoElemento != null) || (this.idLancamentoElemento != null && !this.idLancamentoElemento.equals(other.idLancamentoElemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tblancamentoelementoimport[ idLancamentoElemento=" + idLancamentoElemento + " ]";
    }
    
}
