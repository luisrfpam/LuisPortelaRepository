/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tbservico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbservico.findAll", query = "SELECT t FROM Tbservico t"),
    @NamedQuery(name = "Tbservico.findById", query = "SELECT t FROM Tbservico t WHERE t.id = :id"),
    @NamedQuery(name = "Tbservico.findByDescricaoServico", query = "SELECT t FROM Tbservico t WHERE t.descricaoServico = :descricaoServico"),
    @NamedQuery(name = "Tbservico.findByDtCreated", query = "SELECT t FROM Tbservico t WHERE t.dtCreated = :dtCreated"),
    @NamedQuery(name = "Tbservico.findByDtModified", query = "SELECT t FROM Tbservico t WHERE t.dtModified = :dtModified")})
public class Tbservico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricaoServico")
    private String descricaoServico;
    @Column(name = "dtCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @Column(name = "dtModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtModified;
    @OneToMany(mappedBy = "idServico")
    private Set<Tblancamentoservico> tblancamentoservicoSet;

    public Tbservico() {
    }

    public Tbservico(Long id) {
        this.id = id;
    }

    public Tbservico(Long id, String descricaoServico) {
        this.id = id;
        this.descricaoServico = descricaoServico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
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
    public Set<Tblancamentoservico> getTblancamentoservicoSet() {
        return tblancamentoservicoSet;
    }

    public void setTblancamentoservicoSet(Set<Tblancamentoservico> tblancamentoservicoSet) {
        this.tblancamentoservicoSet = tblancamentoservicoSet;
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
        if (!(object instanceof Tbservico)) {
            return false;
        }
        Tbservico other = (Tbservico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbservico[ id=" + id + " ]";
    }
    
}
