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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author kahani
 */
@Entity
@Table(name = "concepto_puntos")
@NamedQueries({
    @NamedQuery(name = "ConceptoPuntos.findAll", query = "SELECT c FROM ConceptoPuntos c")})
public class ConceptoPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "concepto_punto")
    private Integer conceptoPunto;
    @Basic(optional = false)
    @Column(name = "descripcion_concepto")
    private String descripcionConcepto;
    @Basic(optional = false)
    @Column(name = "puntos_requeridos")
    private Integer  puntosRequeridos;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conceptoPunto")
    private List<UsoPuntos> usoPuntosList;

    public ConceptoPuntos() {
    }

    public ConceptoPuntos(Integer conceptoPunto) {
        this.conceptoPunto = conceptoPunto;
    }

    public ConceptoPuntos(Integer conceptoPunto, String descripcionConcepto, Integer  puntosRequeridos) {
        this.conceptoPunto = conceptoPunto;
        this.descripcionConcepto = descripcionConcepto;
        this.puntosRequeridos = puntosRequeridos;
    }

    public Integer getConceptoPunto() {
        return conceptoPunto;
    }

    public void setConceptoPunto(Integer conceptoPunto) {
        this.conceptoPunto = conceptoPunto;
    }

    public String getDescripcionConcepto() {
        return descripcionConcepto;
    }

    public void setDescripcionConcepto(String descripcionConcepto) {
        this.descripcionConcepto = descripcionConcepto;
    }

    public Integer  getPuntosRequeridos() {
        return puntosRequeridos;
    }

    public void setPuntosRequeridos(int puntosRequeridos) {
        this.puntosRequeridos = puntosRequeridos;
    }

    public List<UsoPuntos> getUsoPuntosList() {
        return usoPuntosList;
    }

    public void setUsoPuntosList(List<UsoPuntos> usoPuntosList) {
        this.usoPuntosList = usoPuntosList;
    }

    @Override
    public int  hashCode() {
        Integer  hash = 0;
        hash += (conceptoPunto != null ? conceptoPunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConceptoPuntos)) {
            return false;
        }
        ConceptoPuntos other = (ConceptoPuntos) object;
        if ((this.conceptoPunto == null && other.conceptoPunto != null) || (this.conceptoPunto != null && !this.conceptoPunto.equals(other.conceptoPunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.ConceptoPuntos[ conceptoPunto=" + conceptoPunto + " ]";
    }
    
}
