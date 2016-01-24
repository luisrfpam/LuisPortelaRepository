/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LUISPORTELA
 */
@Entity
@Table(name = "tbpart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbpart.findAll", query = "SELECT t FROM Tbpart t"),
    @NamedQuery(name = "Tbpart.findById", query = "SELECT t FROM Tbpart t WHERE t.id = :id"),
    @NamedQuery(name = "Tbpart.findByDescricaoPeca", query = "SELECT t FROM Tbpart t WHERE t.descricaoPeca = :descricaoPeca"),
    @NamedQuery(name = "Tbpart.findByPesoPeca", query = "SELECT t FROM Tbpart t WHERE t.pesoPeca = :pesoPeca"),
    @NamedQuery(name = "Tbpart.findByDtCreated", query = "SELECT t FROM Tbpart t WHERE t.dtCreated = :dtCreated"),
    @NamedQuery(name = "Tbpart.findByDtModified", query = "SELECT t FROM Tbpart t WHERE t.dtModified = :dtModified")})
public class Tbpart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricaoPeca")
    private String descricaoPeca;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pesoPeca")
    private BigDecimal pesoPeca;
    @Column(name = "dtCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @Column(name = "dtModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtModified;
    @ManyToMany(mappedBy = "tbpartSet")
    private Set<Tbpanel> tbpanelSet;
    @OneToMany(mappedBy = "idPart")
    private Set<Tbassembly> tbassemblySet;
    @OneToMany(mappedBy = "idPart")
    private Set<Tbplancuts> tbplancutsSet;
    @OneToMany(mappedBy = "idPeca")
    private Set<Tblancamentoelemento> tblancamentoelementoSet;

    public Tbpart() {
    }

    public Tbpart(Long id) {
        this.id = id;
    }

    public Tbpart(Long id, String descricaoPeca) {
        this.id = id;
        this.descricaoPeca = descricaoPeca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoPeca() {
        return descricaoPeca;
    }

    public void setDescricaoPeca(String descricaoPeca) {
        this.descricaoPeca = descricaoPeca;
    }

    public BigDecimal getPesoPeca() {
        return pesoPeca;
    }

    public void setPesoPeca(BigDecimal pesoPeca) {
        this.pesoPeca = pesoPeca;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public Date getDtModified() {
        return dtModified;
    }

    public void setDtModified(Date dtModified) {
        this.dtModified = dtModified;
    }

    @XmlTransient
    public Set<Tbpanel> getTbpanelSet() {
        return tbpanelSet;
    }

    public void setTbpanelSet(Set<Tbpanel> tbpanelSet) {
        this.tbpanelSet = tbpanelSet;
    }

    @XmlTransient
    public Set<Tbassembly> getTbassemblySet() {
        return tbassemblySet;
    }

    public void setTbassemblySet(Set<Tbassembly> tbassemblySet) {
        this.tbassemblySet = tbassemblySet;
    }

    @XmlTransient
    public Set<Tbplancuts> getTbplancutsSet() {
        return tbplancutsSet;
    }

    public void setTbplancutsSet(Set<Tbplancuts> tbplancutsSet) {
        this.tbplancutsSet = tbplancutsSet;
    }

    @XmlTransient
    public Set<Tblancamentoelemento> getTblancamentoelementoSet() {
        return tblancamentoelementoSet;
    }

    public void setTblancamentoelementoSet(Set<Tblancamentoelemento> tblancamentoelementoSet) {
        this.tblancamentoelementoSet = tblancamentoelementoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbpart)) {
            return false;
        }
        Tbpart other = (Tbpart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbpart[ id=" + id + " ]";
    }
    
}
