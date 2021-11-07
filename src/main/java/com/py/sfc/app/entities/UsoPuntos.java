/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.py.sfc.app.entities;

import java.io.Serializable;
import java.util.List;
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

/**
 *
 * @author kahani
 */
@Entity
@Table(name = "uso_puntos")
@NamedQueries({
    @NamedQuery(name = "UsoPuntos.findAll", query = "SELECT u FROM UsoPuntos u")})
public class UsoPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uso_punto")
    private Integer usoPunto;
    @Basic(optional = false)
    @Column(name = "puntaje_utilizado")
    private int puntajeUtilizado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usoPunto")
    private List<UsoPuntosDetalle> usoPuntosDetalleList;
    @JoinColumn(name = "cliente", referencedColumnName = "cliente")
    @ManyToOne(optional = false)
    private Clientes cliente;
    @JoinColumn(name = "concepto_punto", referencedColumnName = "concepto_punto")
    @ManyToOne(optional = false)
    private ConceptoPuntos conceptoPunto;

    public UsoPuntos() {
    }

    public UsoPuntos(Integer usoPunto) {
        this.usoPunto = usoPunto;
    }

    public UsoPuntos(Integer usoPunto, int puntajeUtilizado) {
        this.usoPunto = usoPunto;
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Integer getUsoPunto() {
        return usoPunto;
    }

    public void setUsoPunto(Integer usoPunto) {
        this.usoPunto = usoPunto;
    }

    public int getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(int puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public List<UsoPuntosDetalle> getUsoPuntosDetalleList() {
        return usoPuntosDetalleList;
    }

    public void setUsoPuntosDetalleList(List<UsoPuntosDetalle> usoPuntosDetalleList) {
        this.usoPuntosDetalleList = usoPuntosDetalleList;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public ConceptoPuntos getConceptoPunto() {
        return conceptoPunto;
    }

    public void setConceptoPunto(ConceptoPuntos conceptoPunto) {
        this.conceptoPunto = conceptoPunto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usoPunto != null ? usoPunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsoPuntos)) {
            return false;
        }
        UsoPuntos other = (UsoPuntos) object;
        if ((this.usoPunto == null && other.usoPunto != null) || (this.usoPunto != null && !this.usoPunto.equals(other.usoPunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.UsoPuntos[ usoPunto=" + usoPunto + " ]";
    }
    
}
