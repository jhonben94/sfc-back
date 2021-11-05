/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.py.sfc.app.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kahani
 */
@Entity
@Table(name = "vencimiento_puntos")
@NamedQueries({
    @NamedQuery(name = "VencimientoPuntos.findAll", query = "SELECT v FROM VencimientoPuntos v")})
public class VencimientoPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vencimiento_punto")
    private Integer vencimientoPunto;
    @Basic(optional = false)
    @Column(name = "fecha_inicio_validez")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioValidez;
    @Basic(optional = false)
    @Column(name = "fecha_fin_validez")
    @Temporal(TemporalType.DATE)
    private Date fechaFinValidez;
    @Basic(optional = false)
    @Column(name = "dias_validez")
    private int diasValidez;

    public VencimientoPuntos() {
    }

    public VencimientoPuntos(Integer vencimientoPunto) {
        this.vencimientoPunto = vencimientoPunto;
    }

    public VencimientoPuntos(Integer vencimientoPunto, Date fechaInicioValidez, Date fechaFinValidez, int diasValidez) {
        this.vencimientoPunto = vencimientoPunto;
        this.fechaInicioValidez = fechaInicioValidez;
        this.fechaFinValidez = fechaFinValidez;
        this.diasValidez = diasValidez;
    }

    public Integer getVencimientoPunto() {
        return vencimientoPunto;
    }

    public void setVencimientoPunto(Integer vencimientoPunto) {
        this.vencimientoPunto = vencimientoPunto;
    }

    public Date getFechaInicioValidez() {
        return fechaInicioValidez;
    }

    public void setFechaInicioValidez(Date fechaInicioValidez) {
        this.fechaInicioValidez = fechaInicioValidez;
    }

    public Date getFechaFinValidez() {
        return fechaFinValidez;
    }

    public void setFechaFinValidez(Date fechaFinValidez) {
        this.fechaFinValidez = fechaFinValidez;
    }

    public int getDiasValidez() {
        return diasValidez;
    }

    public void setDiasValidez(int diasValidez) {
        this.diasValidez = diasValidez;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vencimientoPunto != null ? vencimientoPunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VencimientoPuntos)) {
            return false;
        }
        VencimientoPuntos other = (VencimientoPuntos) object;
        if ((this.vencimientoPunto == null && other.vencimientoPunto != null) || (this.vencimientoPunto != null && !this.vencimientoPunto.equals(other.vencimientoPunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.VencimientoPuntos[ vencimientoPunto=" + vencimientoPunto + " ]";
    }
    
}
