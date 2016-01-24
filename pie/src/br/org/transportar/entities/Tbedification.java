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
@Table(name = "tbedification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbedification.findAll", query = "SELECT t FROM Tbedification t"),
    @NamedQuery(name = "Tbedification.findById", query = "SELECT t FROM Tbedification t WHERE t.id = :id"),
    @NamedQuery(name = "Tbedification.findByCheckEdification", query = "SELECT t FROM Tbedification t WHERE t.checkEdification = :checkEdification"),
    @NamedQuery(name = "Tbedification.findByDtCreated", query = "SELECT t FROM Tbedification t WHERE t.dtCreated = :dtCreated")})
public class Tbedification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "checkEdification")
    private Boolean checkEdification;
    @Column(name = "dtCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @JoinColumn(name = "idBlock", referencedColumnName = "id")
    @ManyToOne
    private Tbblock idBlock;
    @JoinColumn(name = "idPanel", referencedColumnName = "id")
    @ManyToOne
    private Tbpanel idPanel;

    public Tbedification() {
    }

    public Tbedification(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCheckEdification() {
        return checkEdification;
    }

    public void setCheckEdification(Boolean checkEdification) {
        this.checkEdification = checkEdification;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public Tbblock getIdBlock() {
        return idBlock;
    }

    public void setIdBlock(Tbblock idBlock) {
        this.idBlock = idBlock;
    }

    public Tbpanel getIdPanel() {
        return idPanel;
    }

    public void setIdPanel(Tbpanel idPanel) {
        this.idPanel = idPanel;
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
        if (!(object instanceof Tbedification)) {
            return false;
        }
        Tbedification other = (Tbedification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbedification[ id=" + id + " ]";
    }
    
}
