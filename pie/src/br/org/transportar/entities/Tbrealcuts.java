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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LUISPORTELA
 */
@Entity
@Table(name = "tbrealcuts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbrealcuts.findAll", query = "SELECT t FROM Tbrealcuts t"),
    @NamedQuery(name = "Tbrealcuts.findById", query = "SELECT t FROM Tbrealcuts t WHERE t.id = :id"),
    @NamedQuery(name = "Tbrealcuts.findByDtCreated", query = "SELECT t FROM Tbrealcuts t WHERE t.dtCreated = :dtCreated")})
public class Tbrealcuts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "dtCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @JoinColumn(name = "idPlanCuts", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tbplancuts idPlanCuts;

    public Tbrealcuts() {
    }

    public Tbrealcuts(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public Tbplancuts getIdPlanCuts() {
        return idPlanCuts;
    }

    public void setIdPlanCuts(Tbplancuts idPlanCuts) {
        this.idPlanCuts = idPlanCuts;
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
        if (!(object instanceof Tbrealcuts)) {
            return false;
        }
        Tbrealcuts other = (Tbrealcuts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbrealcuts[ id=" + id + " ]";
    }
    
}
