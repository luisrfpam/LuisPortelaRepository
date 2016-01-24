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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "tbblock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbblock.findAll", query = "SELECT t FROM Tbblock t"),
    @NamedQuery(name = "Tbblock.findById", query = "SELECT t FROM Tbblock t WHERE t.id = :id"),
    @NamedQuery(name = "Tbblock.findByDescricaoBloco", query = "SELECT t FROM Tbblock t WHERE t.descricaoBloco = :descricaoBloco"),
    @NamedQuery(name = "Tbblock.findByDtCreated", query = "SELECT t FROM Tbblock t WHERE t.dtCreated = :dtCreated"),
    @NamedQuery(name = "Tbblock.findByDtModified", query = "SELECT t FROM Tbblock t WHERE t.dtModified = :dtModified")})
public class Tbblock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 45)
    @Column(name = "descricaoBloco")
    private String descricaoBloco;
    @Column(name = "dtCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @Column(name = "dtModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtModified;
    @JoinTable(name = "tbpanel_has_tbblock", joinColumns = {
        @JoinColumn(name = "idBlock", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "idPanel", referencedColumnName = "id")})
    @ManyToMany
    private Set<Tbpanel> tbpanelSet;
    @OneToMany(mappedBy = "idBlock")
    private Set<Tbedification> tbedificationSet;
    @OneToMany(mappedBy = "idBlock")
    private Set<Tbplancuts> tbplancutsSet;
    @JoinColumn(name = "idBordo", referencedColumnName = "id")
    @ManyToOne
    private Tbside idBordo;
    @OneToMany(mappedBy = "idBloco")
    private Set<Tblancamentoelemento> tblancamentoelementoSet;

    public Tbblock() {
    }

    public Tbblock(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoBloco() {
        return descricaoBloco;
    }

    public void setDescricaoBloco(String descricaoBloco) {
        this.descricaoBloco = descricaoBloco;
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
    public Set<Tbedification> getTbedificationSet() {
        return tbedificationSet;
    }

    public void setTbedificationSet(Set<Tbedification> tbedificationSet) {
        this.tbedificationSet = tbedificationSet;
    }

    @XmlTransient
    public Set<Tbplancuts> getTbplancutsSet() {
        return tbplancutsSet;
    }

    public void setTbplancutsSet(Set<Tbplancuts> tbplancutsSet) {
        this.tbplancutsSet = tbplancutsSet;
    }

    public Tbside getIdBordo() {
        return idBordo;
    }

    public void setIdBordo(Tbside idBordo) {
        this.idBordo = idBordo;
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
        if (!(object instanceof Tbblock)) {
            return false;
        }
        Tbblock other = (Tbblock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbblock[ id=" + id + " ]";
    }
    
}
