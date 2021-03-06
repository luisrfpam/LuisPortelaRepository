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
@Table(name = "tbmaterialtype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbmaterialtype.findAll", query = "SELECT t FROM Tbmaterialtype t"),
    @NamedQuery(name = "Tbmaterialtype.findById", query = "SELECT t FROM Tbmaterialtype t WHERE t.id = :id"),
    @NamedQuery(name = "Tbmaterialtype.findByDescricaoTipoMaterial", query = "SELECT t FROM Tbmaterialtype t WHERE t.descricaoTipoMaterial = :descricaoTipoMaterial"),
    @NamedQuery(name = "Tbmaterialtype.findByDtCreated", query = "SELECT t FROM Tbmaterialtype t WHERE t.dtCreated = :dtCreated"),
    @NamedQuery(name = "Tbmaterialtype.findByDtModified", query = "SELECT t FROM Tbmaterialtype t WHERE t.dtModified = :dtModified")})
public class Tbmaterialtype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricaoTipoMaterial")
    private String descricaoTipoMaterial;
    @Column(name = "dtCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @Column(name = "dtModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtModified;
    @OneToMany(mappedBy = "idMaterialType")
    private Set<Tbrawmaterial> tbrawmaterialSet;

    public Tbmaterialtype() {
    }

    public Tbmaterialtype(Long id) {
        this.id = id;
    }

    public Tbmaterialtype(Long id, String descricaoTipoMaterial) {
        this.id = id;
        this.descricaoTipoMaterial = descricaoTipoMaterial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoTipoMaterial() {
        return descricaoTipoMaterial;
    }

    public void setDescricaoTipoMaterial(String descricaoTipoMaterial) {
        this.descricaoTipoMaterial = descricaoTipoMaterial;
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
        if (!(object instanceof Tbmaterialtype)) {
            return false;
        }
        Tbmaterialtype other = (Tbmaterialtype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbmaterialtype[ id=" + id + " ]";
    }
    
}
