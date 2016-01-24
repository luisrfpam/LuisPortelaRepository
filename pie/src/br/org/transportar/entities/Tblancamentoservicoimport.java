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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LUISPORTELA
 */
@Entity
@Table(name = "tblancamentoservicoimport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Tblancamentoservicoimport.LISTAR_DESTAQUES, query = "SELECT t FROM Tblancamentoservicoimport t"),
    @NamedQuery(name = "Tblancamentoservicoimport.findByIdLancamentoServico", query = "SELECT t FROM Tblancamentoservicoimport t WHERE t.idLancamentoServico = :idLancamentoServico"),
    @NamedQuery(name = Tblancamentoservicoimport.LISTAR_SOLDAS_BY_PROJETO, query = "SELECT t FROM Tblancamentoservicoimport t WHERE t.nomeProjeto LIKE :nomeProjeto"),
    @NamedQuery(name = "Tblancamentoservicoimport.findByDescricaoCaverna", query = "SELECT t FROM Tblancamentoservicoimport t WHERE t.descricaoCaverna = :descricaoCaverna"),
    @NamedQuery(name = "Tblancamentoservicoimport.findByDescricaoBloco", query = "SELECT t FROM Tblancamentoservicoimport t WHERE t.descricaoBloco = :descricaoBloco"),
    @NamedQuery(name = "Tblancamentoservicoimport.findByValorComprimento", query = "SELECT t FROM Tblancamentoservicoimport t WHERE t.valorComprimento = :valorComprimento"),
    @NamedQuery(name = "Tblancamentoservicoimport.findByQtdUtilizado", query = "SELECT t FROM Tblancamentoservicoimport t WHERE t.qtdUtilizado = :qtdUtilizado"),
    @NamedQuery(name = "Tblancamentoservicoimport.findByIsImport", query = "SELECT t FROM Tblancamentoservicoimport t WHERE t.isImport = :isImport"),
    @NamedQuery(name = "Tblancamentoservicoimport.findByIdBordo", query = "SELECT t FROM Tblancamentoservicoimport t WHERE t.idBordo = :idBordo"),
    @NamedQuery(name = "Tblancamentoservicoimport.findByIdRegiao", query = "SELECT t FROM Tblancamentoservicoimport t WHERE t.idRegiao = :idRegiao"),
    @NamedQuery(name = "Tblancamentoservicoimport.findByIdPosicao", query = "SELECT t FROM Tblancamentoservicoimport t WHERE t.idPosicao = :idPosicao"),
    @NamedQuery(name = "Tblancamentoservicoimport.findByIdServico", query = "SELECT t FROM Tblancamentoservicoimport t WHERE t.idServico = :idServico"),
    @NamedQuery(name = "Tblancamentoservicoimport.findByIdEspaco", query = "SELECT t FROM Tblancamentoservicoimport t WHERE t.idEspaco = :idEspaco"),
    @NamedQuery(name = "Tblancamentoservicoimport.findByIdTipoSolda", query = "SELECT t FROM Tblancamentoservicoimport t WHERE t.idTipoSolda = :idTipoSolda"),
    @NamedQuery(name = "Tblancamentoservicoimport.findByNomeProjeto", query = "SELECT t FROM Tblancamentoservicoimport t WHERE t.nomeProjeto = :nomeProjeto")})
public class Tblancamentoservicoimport implements Serializable {
    public static final String LISTAR_DESTAQUES = "Tblancamentoservicoimport.findAll";
    public static final String LISTAR_SOLDAS_BY_PROJETO = "Tblancamentoservicoimport.findAllLancamentoSoldaByProjeto";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLancamentoServico")
    private Long idLancamentoServico;
    @Size(max = 255)
    @Column(name = "descricaoCaverna")
    private String descricaoCaverna;
    @Size(max = 255)
    @Column(name = "descricaoBloco")
    private String descricaoBloco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorComprimento")
    private BigDecimal valorComprimento;
    @Column(name = "qtdUtilizado")
    private Integer qtdUtilizado;
    @Column(name = "isImport")
    private Boolean isImport;
    @Size(max = 255)
    @Column(name = "idBordo")
    private String idBordo;
    @Size(max = 255)
    @Column(name = "idRegiao")
    private String idRegiao;
    @Size(max = 255)
    @Column(name = "idPosicao")
    private String idPosicao;
    @Size(max = 255)
    @Column(name = "idServico")
    private String idServico;
    @Size(max = 255)
    @Column(name = "idEspaco")
    private String idEspaco;
    @Size(max = 255)
    @Column(name = "idTipoSolda")
    private String idTipoSolda;
    @Size(max = 255)
    @Column(name = "nomeProjeto")
    private String nomeProjeto;

    public Tblancamentoservicoimport() {
    }

    public Tblancamentoservicoimport(Long idLancamentoServico) {
        this.idLancamentoServico = idLancamentoServico;
    }

    public Long getIdLancamentoServico() {
        return idLancamentoServico;
    }

    public void setIdLancamentoServico(Long idLancamentoServico) {
        this.idLancamentoServico = idLancamentoServico;
    }

    public String getDescricaoCaverna() {
        return descricaoCaverna;
    }

    public void setDescricaoCaverna(String descricaoCaverna) {
        this.descricaoCaverna = descricaoCaverna;
    }

    public String getDescricaoBloco() {
        return descricaoBloco;
    }

    public void setDescricaoBloco(String descricaoBloco) {
        this.descricaoBloco = descricaoBloco;
    }

    public BigDecimal getValorComprimento() {
        return valorComprimento;
    }

    public void setValorComprimento(BigDecimal valorComprimento) {
        this.valorComprimento = valorComprimento;
    }

    public Integer getQtdUtilizado() {
        return qtdUtilizado;
    }

    public void setQtdUtilizado(Integer qtdUtilizado) {
        this.qtdUtilizado = qtdUtilizado;
    }

    public Boolean getIsImport() {
        return isImport;
    }

    public void setIsImport(Boolean isImport) {
        this.isImport = isImport;
    }

    public String getIdBordo() {
        return idBordo;
    }

    public void setIdBordo(String idBordo) {
        this.idBordo = idBordo;
    }

    public String getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(String idRegiao) {
        this.idRegiao = idRegiao;
    }

    public String getIdPosicao() {
        return idPosicao;
    }

    public void setIdPosicao(String idPosicao) {
        this.idPosicao = idPosicao;
    }

    public String getIdServico() {
        return idServico;
    }

    public void setIdServico(String idServico) {
        this.idServico = idServico;
    }

    public String getIdEspaco() {
        return idEspaco;
    }

    public void setIdEspaco(String idEspaco) {
        this.idEspaco = idEspaco;
    }

    public String getIdTipoSolda() {
        return idTipoSolda;
    }

    public void setIdTipoSolda(String idTipoSolda) {
        this.idTipoSolda = idTipoSolda;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLancamentoServico != null ? idLancamentoServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblancamentoservicoimport)) {
            return false;
        }
        Tblancamentoservicoimport other = (Tblancamentoservicoimport) object;
        if ((this.idLancamentoServico == null && other.idLancamentoServico != null) || (this.idLancamentoServico != null && !this.idLancamentoServico.equals(other.idLancamentoServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.transportar.entities.Tblancamentoservicoimport[ idLancamentoServico=" + idLancamentoServico + " ]";
    }
    
}
