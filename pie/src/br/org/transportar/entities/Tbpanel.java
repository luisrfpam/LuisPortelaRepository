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
@Table(name = "tbpanel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbpanel.findAll", query = "SELECT t FROM Tbpanel t"),
    @NamedQuery(name = "Tbpanel.findById", query = "SELECT t FROM Tbpanel t WHERE t.id = :id"),
    @NamedQuery(name = "Tbpanel.findByDescricao", query = "SELECT t FROM Tbpanel t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "Tbpanel.findByPesoPanel", query = "SELECT t FROM Tbpanel t WHERE t.pesoPanel = :pesoPanel"),
    @NamedQuery(name = "Tbpanel.findByDtCreated", query = "SELECT t FROM Tbpanel t WHERE t.dtCreated = :dtCreated"),
    @NamedQuery(name = "Tbpanel.findByDtModified", query = "SELECT t FROM Tbpanel t WHERE t.dtModified = :dtModified")})
public class Tbpanel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pesoPanel")
    private BigDecimal pesoPanel;
    @Column(name = "dtCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @Column(name = "dtModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtModified;
    @JoinTable(name = "tbpart_has_tbpanel", joinColumns = {
        @JoinColumn(name = "idPanel", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "idPart", referencedColumnName = "id")})
    @ManyToMany
    private Set<Tbpart> tbpartSet;
    @ManyToMany(mappedBy = "tbpanelSet")
    private Set<Tbblock> tbblockSet;
    @OneToMany(mappedBy = "idPanel")
    private Set<Tbedification> tbedificationSet;
    @OneToMany(mappedBy = "idPanel")
    private Set<Tbassembly> tbassemblySet;
    @OneToMany(mappedBy = "idPanel")
    private Set<Tbplancuts> tbplancutsSet;
    @JoinColumn(name = "idBordo", referencedColumnName = "id")
    @ManyToOne
    private Tbside idBordo;

    public Tbpanel() {
    }

    public Tbpanel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPesoPanel() {
        return pesoPanel;
    }

    public void setPesoPanel(BigDecimal pesoPanel) {
        this.pesoPanel = pesoPanel;
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
    public Set<Tbpart> getTbpartSet() {
        return tbpartSet;
    }

    public void setTbpartSet(Set<Tbpart> tbpartSet) {
        this.tbpartSet = tbpartSet;
    }

    @XmlTransient
    public Set<Tbblock> getTbblockSet() {
        return tbblockSet;
    }

    public void setTbblockSet(Set<Tbblock> tbblockSet) {
        this.tbblockSet = tbblockSet;
    }

    @XmlTransient
    public Set<Tbedification> getTbedificationSet() {
        return tbedificationSet;
    }

    public void setTbedificationSet(Set<Tbedification> tbedificationSet) {
        this.tbedificationSet = tbedificationSet;
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

    public Tbside getIdBordo() {
        return idBordo;
    }

    public void setIdBordo(Tbside idBordo) {
        this.idBordo = idBordo;
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
        if (!(object instanceof Tbpanel)) {
            return false;
        }
        Tbpanel other = (Tbpanel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbpanel[ id=" + id + " ]";
    }
    
}
