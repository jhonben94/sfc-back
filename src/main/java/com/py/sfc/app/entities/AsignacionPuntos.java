/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.py.sfc.app.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author kahani
 */
@Entity
@Table(name = "asignacion_puntos")
@NamedQueries({
    @NamedQuery(name = "AsignacionPuntos.findAll", query = "SELECT a FROM AsignacionPuntos a")})
public class AsignacionPuntos implements Serializable {

    @Column(name = "dias_vigencia")
    private Integer diasVigencia;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "asignacion_punto")
    private Integer asignacionPunto;
    @Basic(optional = false)
    @Column(name = "limite_inferior")
    private Integer limiteInferior;
    @Basic(optional = false)
    @Column(name = "limite_superior")
    private Integer limiteSuperior;
    @Basic(optional = false)
    @Column(name = "monto_equivalencia")
    private Integer montoEquivalencia;

    public AsignacionPuntos() {
    }

    public AsignacionPuntos(Integer asignacionPunto) {
        this.asignacionPunto = asignacionPunto;
    }

    public AsignacionPuntos(Integer asignacionPunto, Integer limiteInferior, Integer limiteSuperior, Integer montoEquivalencia) {
        this.asignacionPunto = asignacionPunto;
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        this.montoEquivalencia = montoEquivalencia;
    }

    public Integer getAsignacionPunto() {
        return asignacionPunto;
    }

    public void setAsignacionPunto(Integer asignacionPunto) {
        this.asignacionPunto = asignacionPunto;
    }

    public Integer getLimiteInferior() {
        return limiteInferior;
    }

    public void setLimiteInferior(Integer limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public Integer getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(Integer limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public Integer getMontoEquivalencia() {
        return montoEquivalencia;
    }

    public void setMontoEquivalencia(Integer montoEquivalencia) {
        this.montoEquivalencia = montoEquivalencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asignacionPunto != null ? asignacionPunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionPuntos)) {
            return false;
        }
        AsignacionPuntos other = (AsignacionPuntos) object;
        if ((this.asignacionPunto == null && other.asignacionPunto != null) || (this.asignacionPunto != null && !this.asignacionPunto.equals(other.asignacionPunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.AsignacionPuntos[ asignacionPunto=" + asignacionPunto + " ]";
    }

    public Integer getDiasVigencia() {
        return diasVigencia;
    }

    public void setDiasVigencia(Integer diasVigencia) {
        this.diasVigencia = diasVigencia;
    }
    
}
