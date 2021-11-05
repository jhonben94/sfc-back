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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author kahani
 */
@Entity
@Table(name = "asignacion_puntos")
@NamedQueries({
    @NamedQuery(name = "AsignacionPuntos.findAll", query = "SELECT a FROM AsignacionPuntos a")})
public class AsignacionPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "asignacion_punto")
    private Integer asignacionPunto;
    @Basic(optional = false)
    @Column(name = "limite_inferior")
    private int limiteInferior;
    @Basic(optional = false)
    @Column(name = "limite_superior")
    private int limiteSuperior;
    @Basic(optional = false)
    @Column(name = "monto_equivalencia")
    private int montoEquivalencia;

    public AsignacionPuntos() {
    }

    public AsignacionPuntos(Integer asignacionPunto) {
        this.asignacionPunto = asignacionPunto;
    }

    public AsignacionPuntos(Integer asignacionPunto, int limiteInferior, int limiteSuperior, int montoEquivalencia) {
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

    public int getLimiteInferior() {
        return limiteInferior;
    }

    public void setLimiteInferior(int limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public int getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(int limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public int getMontoEquivalencia() {
        return montoEquivalencia;
    }

    public void setMontoEquivalencia(int montoEquivalencia) {
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


    
}
