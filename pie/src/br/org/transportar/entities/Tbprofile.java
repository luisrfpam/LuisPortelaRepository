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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "tbprofile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Tbprofile.LISTAR_DESTAQUES, query = "SELECT t FROM Tbprofile t"),
    @NamedQuery(name = "Tbprofile.findById", query = "SELECT t FROM Tbprofile t WHERE t.id = :id"),
    @NamedQuery(name = "Tbprofile.findByNomeProfile", query = "SELECT t FROM Tbprofile t WHERE t.nomeProfile = :nomeProfile"),
    @NamedQuery(name = "Tbprofile.findByDtCreated", query = "SELECT t FROM Tbprofile t WHERE t.dtCreated = :dtCreated"),
    @NamedQuery(name = "Tbprofile.findByDtModified", query = "SELECT t FROM Tbprofile t WHERE t.dtModified = :dtModified")})
public class Tbprofile implements Serializable {
    public static final String LISTAR_DESTAQUES = "Tbprofile.findAll";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nomeProfile")
    private String nomeProfile;
    @Column(name = "dtCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @Column(name = "dtModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtModified;
    @JoinTable(name = "tbuser_has_tbprofile", joinColumns = {
        @JoinColumn(name = "idProfile", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "idUsuario", referencedColumnName = "id")})
    @ManyToMany
    private Set<Tbuser> tbuserSet;

    public Tbprofile() {
    }

    public Tbprofile(Long id) {
        this.id = id;
    }

    public Tbprofile(Long id, String nomeProfile) {
        this.id = id;
        this.nomeProfile = nomeProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProfile() {
        return nomeProfile;
    }

    public void setNomeProfile(String nomeProfile) {
        this.nomeProfile = nomeProfile;
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
    public Set<Tbuser> getTbuserSet() {
        return tbuserSet;
    }

    public void setTbuserSet(Set<Tbuser> tbuserSet) {
        this.tbuserSet = tbuserSet;
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
        if (!(object instanceof Tbprofile)) {
            return false;
        }
        Tbprofile other = (Tbprofile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbprofile[ id=" + id + " ]";
    }
    
}
