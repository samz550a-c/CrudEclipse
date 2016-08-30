package mh.modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PRUEBA1 database table.
 * 
 */
@Entity
@Table(name="PRUEBA1")
@NamedQuery(name="Prueba1.findAll", query="SELECT p FROM Prueba1 p")
public class Prueba1 implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;

	public Prueba1() {
	}


	@Id
	@Column(unique=true, nullable=false, precision=7)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}


	@Column(length=200)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
        if (!(object instanceof Prueba1)) {
            return false;
        }
        Prueba1 other = (Prueba1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mh.modelo.entidades.Prueba1[ id=" + id + " ]";
    }
}