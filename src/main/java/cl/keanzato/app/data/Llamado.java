/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.keanzato.app.data;

/**
 *
 * @author k.zambrano.torres
 */
public class Llamado {
    
    private long id;
    private String asunto;
    private String mensage;
    private String estado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Llamado(long id, String asunto, String mensage, String estado) {
        this.id = id;
        this.asunto = asunto;
        this.mensage = mensage;
        this.estado = estado;
    }
    
    public Llamado(String asunto, String mensage, String estado) {
        this.asunto = asunto;
        this.mensage = mensage;
        this.estado = estado;
    }

    public Llamado() {
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Llamado other = (Llamado) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Llamado{" + "id=" + id + ", asunto=" + asunto + ", mensage=" + mensage + ", estado=" + estado + '}';
    }

    
    
}
