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
@Table(name = "tbunit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbunit.findAll", query = "SELECT t FROM Tbunit t"),
    @NamedQuery(name = "Tbunit.findById", query = "SELECT t FROM Tbunit t WHERE t.id = :id"),
    @NamedQuery(name = "Tbunit.findByDescricao", query = "SELECT t FROM Tbunit t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "Tbunit.findBySigla", query = "SELECT t FROM Tbunit t WHERE t.sigla = :sigla"),
    @NamedQuery(name = "Tbunit.findByDtCreated", query = "SELECT t FROM Tbunit t WHERE t.dtCreated = :dtCreated"),
    @NamedQuery(name = "Tbunit.findByDtModified", query = "SELECT t FROM Tbunit t WHERE t.dtModified = :dtModified")})
public class Tbunit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "sigla")
    private String sigla;
    @Column(name = "dtCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @Column(name = "dtModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtModified;
    @OneToMany(mappedBy = "idUnit")
    private Set<Tbrawmaterial> tbrawmaterialSet;

    public Tbunit() {
    }

    public Tbunit(Long id) {
        this.id = id;
    }

    public Tbunit(Long id, String descricao, String sigla) {
        this.id = id;
        this.descricao = descricao;
        this.sigla = sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
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
    public Set<Tbrawmaterial> getTbrawmaterialSet() {
        return tbrawmaterialSet;
    }

    public void setTbrawmaterialSet(Set<Tbrawmaterial> tbrawmaterialSet) {
        this.tbrawmaterialSet = tbrawmaterialSet;
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
        if (!(object instanceof Tbunit)) {
            return false;
        }
        Tbunit other = (Tbunit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbunit[ id=" + id + " ]";
    }
    
}
