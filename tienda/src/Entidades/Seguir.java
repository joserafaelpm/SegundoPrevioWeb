package Entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seguir database table.
 * 
 */
@Entity
@NamedQuery(name="Seguir.findAll", query="SELECT s FROM Seguir s")
public class Seguir implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SeguirPK id;

	public Seguir() {
	}

	public SeguirPK getId() {
		return this.id;
	}

	public void setId(SeguirPK id) {
		this.id = id;
	}

}