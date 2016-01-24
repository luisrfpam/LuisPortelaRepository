/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tblancamentoelemento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblancamentoelemento.findAll", query = "SELECT t FROM Tblancamentoelemento t"),
    @NamedQuery(name = "Tblancamentoelemento.findByIdLancamentoElemento", query = "SELECT t FROM Tblancamentoelemento t WHERE t.idLancamentoElemento = :idLancamentoElemento"),
    @NamedQuery(name = "Tblancamentoelemento.findByDescricaoGrupo", query = "SELECT t FROM Tblancamentoelemento t WHERE t.descricaoGrupo = :descricaoGrupo"),
    @NamedQuery(name = "Tblancamentoelemento.findByDtPrevisaoCorte", query = "SELECT t FROM Tblancamentoelemento t WHERE t.dtPrevisaoCorte = :dtPrevisaoCorte"),
    @NamedQuery(name = "Tblancamentoelemento.findByDtRealizadoCorte", query = "SELECT t FROM Tblancamentoelemento t WHERE t.dtRealizadoCorte = :dtRealizadoCorte"),
    @NamedQuery(name = "Tblancamentoelemento.findByValorCG", query = "SELECT t FROM Tblancamentoelemento t WHERE t.valorCG = :valorCG"),
    @NamedQuery(name = "Tblancamentoelemento.findByValorDimensao", query = "SELECT t FROM Tblancamentoelemento t WHERE t.valorDimensao = :valorDimensao"),
    @NamedQuery(name = "Tblancamentoelemento.findByIsImport", query = "SELECT t FROM Tblancamentoelemento t WHERE t.isImport = :isImport")})
public class Tblancamentoelemento implements Serializable {
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
    @JoinColumn(name = "idBloco", referencedColumnName = "id")
    @ManyToOne
    private Tbblock idBloco;
    @JoinColumn(name = "idElemento", referencedColumnName = "id")
    @ManyToOne
    private Tbelemento idElemento;
    @JoinColumn(name = "idPeca", referencedColumnName = "id")
    @ManyToOne
    private Tbpart idPeca;
    @JoinColumn(name = "idBordo", referencedColumnName = "id")
    @ManyToOne
    private Tbside idBordo;

    public Tblancamentoelemento() {
    }

    public Tblancamentoelemento(Long idLancamentoElemento) {
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

    public Tbblock getIdBloco() {
        return idBloco;
    }

    public void setIdBloco(Tbblock idBloco) {
        this.idBloco = idBloco;
    }

    public Tbelemento getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Tbelemento idElemento) {
        this.idElemento = idElemento;
    }

    public Tbpart getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(Tbpart idPeca) {
        this.idPeca = idPeca;
    }

    public Tbside getIdBordo() {
        return idBordo;
    }

    public void setIdBordo(Tbside idBordo) {
        this.idBordo = idBordo;
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
        if (!(object instanceof Tblancamentoelemento)) {
            return false;
        }
        Tblancamentoelemento other = (Tblancamentoelemento) object;
        if ((this.idLancamentoElemento == null && other.idLancamentoElemento != null) || (this.idLancamentoElemento != null && !this.idLancamentoElemento.equals(other.idLancamentoElemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tblancamentoelemento[ idLancamentoElemento=" + idLancamentoElemento + " ]";
    }
    
}
