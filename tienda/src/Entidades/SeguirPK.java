package Entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the seguir database table.
 * 
 */
@Embeddable
public class SeguirPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int cliente;

	@Column(insertable=false, updatable=false)
	private int tienda;

	public SeguirPK() {
	}
	public int getCliente() {
		return this.cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	public int getTienda() {
		return this.tienda;
	}
	public void setTienda(int tienda) {
		this.tienda = tienda;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SeguirPK)) {
			return false;
		}
		SeguirPK castOther = (SeguirPK)other;
		return 
			(this.cliente == castOther.cliente)
			&& (this.tienda == castOther.tienda);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cliente;
		hash = hash * prime + this.tienda;
		
		return hash;
	}
}