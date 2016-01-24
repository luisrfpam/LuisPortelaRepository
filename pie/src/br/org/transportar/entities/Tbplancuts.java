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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LUISPORTELA
 */
@Entity
@Table(name = "tbplancuts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbplancuts.findAll", query = "SELECT t FROM Tbplancuts t"),
    @NamedQuery(name = "Tbplancuts.findByDtCortePlanejado", query = "SELECT t FROM Tbplancuts t WHERE t.dtCortePlanejado = :dtCortePlanejado"),
    @NamedQuery(name = "Tbplancuts.findByQtPecaPlanejado", query = "SELECT t FROM Tbplancuts t WHERE t.qtPecaPlanejado = :qtPecaPlanejado"),
    @NamedQuery(name = "Tbplancuts.findByCheckIsCortado", query = "SELECT t FROM Tbplancuts t WHERE t.checkIsCortado = :checkIsCortado"),
    @NamedQuery(name = "Tbplancuts.findByCheckIsQualidade", query = "SELECT t FROM Tbplancuts t WHERE t.checkIsQualidade = :checkIsQualidade"),
    @NamedQuery(name = "Tbplancuts.findByDtCorteRealizado", query = "SELECT t FROM Tbplancuts t WHERE t.dtCorteRealizado = :dtCorteRealizado"),
    @NamedQuery(name = "Tbplancuts.findById", query = "SELECT t FROM Tbplancuts t WHERE t.id = :id"),
    @NamedQuery(name = "Tbplancuts.findByDtCreated", query = "SELECT t FROM Tbplancuts t WHERE t.dtCreated = :dtCreated")})
public class Tbplancuts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "dtCortePlanejado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCortePlanejado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qtPecaPlanejado")
    private BigDecimal qtPecaPlanejado;
    @Column(name = "checkIsCortado")
    private Boolean checkIsCortado;
    @Column(name = "checkIsQualidade")
    private Boolean checkIsQualidade;
    @Column(name = "dtCorteRealizado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCorteRealizado;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "dtCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlanCuts")
    private Set<Tbrealcuts> tbrealcutsSet;
    @JoinColumn(name = "idBlock", referencedColumnName = "id")
    @ManyToOne
    private Tbblock idBlock;
    @JoinColumn(name = "idPanel", referencedColumnName = "id")
    @ManyToOne
    private Tbpanel idPanel;
    @JoinColumn(name = "idPart", referencedColumnName = "id")
    @ManyToOne
    private Tbpart idPart;
    @JoinColumn(name = "idProject", referencedColumnName = "id")
    @ManyToOne
    private Tbproject idProject;

    public Tbplancuts() {
    }

    public Tbplancuts(Long id) {
        this.id = id;
    }

    public Date getDtCortePlanejado() {
        return dtCortePlanejado;
    }

    public void setDtCortePlanejado(Date dtCortePlanejado) {
        this.dtCortePlanejado = dtCortePlanejado;
    }

    public BigDecimal getQtPecaPlanejado() {
        return qtPecaPlanejado;
    }

    public void setQtPecaPlanejado(BigDecimal qtPecaPlanejado) {
        this.qtPecaPlanejado = qtPecaPlanejado;
    }

    public Boolean getCheckIsCortado() {
        return checkIsCortado;
    }

    public void setCheckIsCortado(Boolean checkIsCortado) {
        this.checkIsCortado = checkIsCortado;
    }

    public Boolean getCheckIsQualidade() {
        return checkIsQualidade;
    }

    public void setCheckIsQualidade(Boolean checkIsQualidade) {
        this.checkIsQualidade = checkIsQualidade;
    }

    public Date getDtCorteRealizado() {
        return dtCorteRealizado;
    }

    public void setDtCorteRealizado(Date dtCorteRealizado) {
        this.dtCorteRealizado = dtCorteRealizado;
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

    @XmlTransient
    public Set<Tbrealcuts> getTbrealcutsSet() {
        return tbrealcutsSet;
    }

    public void setTbrealcutsSet(Set<Tbrealcuts> tbrealcutsSet) {
        this.tbrealcutsSet = tbrealcutsSet;
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

    public Tbpart getIdPart() {
        return idPart;
    }

    public void setIdPart(Tbpart idPart) {
        this.idPart = idPart;
    }

    public Tbproject getIdProject() {
        return idProject;
    }

    public void setIdProject(Tbproject idProject) {
        this.idProject = idProject;
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
        if (!(object instanceof Tbplancuts)) {
            return false;
        }
        Tbplancuts other = (Tbplancuts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbplancuts[ id=" + id + " ]";
    }
    
}
