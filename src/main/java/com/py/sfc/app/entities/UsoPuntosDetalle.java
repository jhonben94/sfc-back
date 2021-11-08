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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author kahani
 */
@Entity
@Table(name = "uso_puntos_detalle")
@NamedQueries({
    @NamedQuery(name = "UsoPuntosDetalle.findAll", query = "SELECT u FROM UsoPuntosDetalle u")})
public class UsoPuntosDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uso_punto_detalle")
    private Integer usoPuntoDetalle;
    @Basic(optional = false)
    @Column(name = "puntaje_utilizado")
    private Integer puntajeUtilizado;
    @JoinColumn(name = "bolsa_punto", referencedColumnName = "bolsa_punto")
    @ManyToOne(optional = false)
    private BolsaPuntos bolsaPunto;
    @JoinColumn(name = "uso_punto", referencedColumnName = "uso_punto")
    @ManyToOne(optional = false)
    private UsoPuntos usoPunto;

    public UsoPuntosDetalle() {
    }

    public UsoPuntosDetalle(Integer usoPuntoDetalle) {
        this.usoPuntoDetalle = usoPuntoDetalle;
    }

    public UsoPuntosDetalle(Integer usoPuntoDetalle, Integer puntajeUtilizado) {
        this.usoPuntoDetalle = usoPuntoDetalle;
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Integer getUsoPuntoDetalle() {
        return usoPuntoDetalle;
    }

    public void setUsoPuntoDetalle(Integer usoPuntoDetalle) {
        this.usoPuntoDetalle = usoPuntoDetalle;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(int puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public BolsaPuntos getBolsaPunto() {
        return bolsaPunto;
    }

    public void setBolsaPunto(BolsaPuntos bolsaPunto) {
        this.bolsaPunto = bolsaPunto;
    }

    public UsoPuntos getUsoPunto() {
        return usoPunto;
    }

    public void setUsoPunto(UsoPuntos usoPunto) {
        this.usoPunto = usoPunto;
    }

    @Override
    public int hashCode() {
        Integer hash = 0;
        hash += (usoPuntoDetalle != null ? usoPuntoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsoPuntosDetalle)) {
            return false;
        }
        UsoPuntosDetalle other = (UsoPuntosDetalle) object;
        if ((this.usoPuntoDetalle == null && other.usoPuntoDetalle != null) || (this.usoPuntoDetalle != null && !this.usoPuntoDetalle.equals(other.usoPuntoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.UsoPuntosDetalle[ usoPuntoDetalle=" + usoPuntoDetalle + " ]";
    }
    
}
