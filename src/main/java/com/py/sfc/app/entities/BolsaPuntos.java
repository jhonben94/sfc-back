/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.py.sfc.app.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kahani
 */
@Entity
@Table(name = "bolsa_puntos")
@NamedQueries({
    @NamedQuery(name = "BolsaPuntos.findAll", query = "SELECT b FROM BolsaPuntos b")})
public class BolsaPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bolsa_punto")
    private Integer bolsaPunto;
    @Basic(optional = false)
    @Column(name = "fecha_asignacion_puntos")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacionPuntos;
    @Basic(optional = false)
    @Column(name = "fecha_vencimiento_puntos")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimientoPuntos;
    @Basic(optional = false)
    @Column(name = "monto_operacion")
    private Integer montoOperacion;
    @Basic(optional = false)
    @Column(name = "saldo_puntos")
    private Integer saldoPuntos;
    @Basic(optional = false)
    @Column(name = "puntaje_utilizado")
    private Integer puntajeUtilizado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bolsaPunto")
    private List<UsoPuntosDetalle> usoPuntosDetalleList;
    @JoinColumn(name = "cliente", referencedColumnName = "cliente")
    @ManyToOne(optional = false)
    private Clientes cliente;

    public BolsaPuntos() {
    }

    public BolsaPuntos(Integer bolsaPunto) {
        this.bolsaPunto = bolsaPunto;
    }

    public BolsaPuntos(Integer bolsaPunto, Date fechaAsignacionPuntos, Date fechaVencimientoPuntos, int montoOperacion, int saldoPuntos, int puntajeUtilizado) {
        this.bolsaPunto = bolsaPunto;
        this.fechaAsignacionPuntos = fechaAsignacionPuntos;
        this.fechaVencimientoPuntos = fechaVencimientoPuntos;
        this.montoOperacion = montoOperacion;
        this.saldoPuntos = saldoPuntos;
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Integer getBolsaPunto() {
        return bolsaPunto;
    }

    public void setBolsaPunto(Integer bolsaPunto) {
        this.bolsaPunto = bolsaPunto;
    }

    public Date getFechaAsignacionPuntos() {
        return fechaAsignacionPuntos;
    }

    public void setFechaAsignacionPuntos(Date fechaAsignacionPuntos) {
        this.fechaAsignacionPuntos = fechaAsignacionPuntos;
    }

    public Date getFechaVencimientoPuntos() {
        return fechaVencimientoPuntos;
    }

    public void setFechaVencimientoPuntos(Date fechaVencimientoPuntos) {
        this.fechaVencimientoPuntos = fechaVencimientoPuntos;
    }

    public Integer getMontoOperacion() {
        return montoOperacion;
    }

    public void setMontoOperacion(Integer montoOperacion) {
        this.montoOperacion = montoOperacion;
    }

    public Integer getSaldoPuntos() {
        return saldoPuntos;
    }

    public void setSaldoPuntos(Integer saldoPuntos) {
        this.saldoPuntos = saldoPuntos;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bolsaPunto != null ? bolsaPunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BolsaPuntos)) {
            return false;
        }
        BolsaPuntos other = (BolsaPuntos) object;
        if ((this.bolsaPunto == null && other.bolsaPunto != null) || (this.bolsaPunto != null && !this.bolsaPunto.equals(other.bolsaPunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.BolsaPuntos[ bolsaPunto=" + bolsaPunto + " ]";
    }
    
}
