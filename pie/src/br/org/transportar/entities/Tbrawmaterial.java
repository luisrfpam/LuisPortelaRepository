/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LUISPORTELA
 */
@Entity
@Table(name = "tbrawmaterial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbrawmaterial.findAll", query = "SELECT t FROM Tbrawmaterial t"),
    @NamedQuery(name = "Tbrawmaterial.findById", query = "SELECT t FROM Tbrawmaterial t WHERE t.id = :id"),
    @NamedQuery(name = "Tbrawmaterial.findByDescricao", query = "SELECT t FROM Tbrawmaterial t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "Tbrawmaterial.findByDimensaoComprimento", query = "SELECT t FROM Tbrawmaterial t WHERE t.dimensaoComprimento = :dimensaoComprimento"),
    @NamedQuery(name = "Tbrawmaterial.findByDimensaoAltura", query = "SELECT t FROM Tbrawmaterial t WHERE t.dimensaoAltura = :dimensaoAltura"),
    @NamedQuery(name = "Tbrawmaterial.findByDimensaoLargura", query = "SELECT t FROM Tbrawmaterial t WHERE t.dimensaoLargura = :dimensaoLargura")})
public class Tbrawmaterial implements Serializable {
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dimensaoComprimento")
    private BigDecimal dimensaoComprimento;
    @Column(name = "dimensaoAltura")
    private BigDecimal dimensaoAltura;
    @Column(name = "dimensaoLargura")
    private BigDecimal dimensaoLargura;
    @JoinColumn(name = "idMaterialType", referencedColumnName = "id")
    @ManyToOne
    private Tbmaterialtype idMaterialType;
    @JoinColumn(name = "idUnit", referencedColumnName = "id")
    @ManyToOne
    private Tbunit idUnit;

    public Tbrawmaterial() {
    }

    public Tbrawmaterial(Long id) {
        this.id = id;
    }

    public Tbrawmaterial(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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

    public BigDecimal getDimensaoComprimento() {
        return dimensaoComprimento;
    }

    public void setDimensaoComprimento(BigDecimal dimensaoComprimento) {
        this.dimensaoComprimento = dimensaoComprimento;
    }

    public BigDecimal getDimensaoAltura() {
        return dimensaoAltura;
    }

    public void setDimensaoAltura(BigDecimal dimensaoAltura) {
        this.dimensaoAltura = dimensaoAltura;
    }

    public BigDecimal getDimensaoLargura() {
        return dimensaoLargura;
    }

    public void setDimensaoLargura(BigDecimal dimensaoLargura) {
        this.dimensaoLargura = dimensaoLargura;
    }

    public Tbmaterialtype getIdMaterialType() {
        return idMaterialType;
    }

    public void setIdMaterialType(Tbmaterialtype idMaterialType) {
        this.idMaterialType = idMaterialType;
    }

    public Tbunit getIdUnit() {
        return idUnit;
    }

    public void setIdUnit(Tbunit idUnit) {
        this.idUnit = idUnit;
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
        if (!(object instanceof Tbrawmaterial)) {
            return false;
        }
        Tbrawmaterial other = (Tbrawmaterial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tbrawmaterial[ id=" + id + " ]";
    }
    
}
