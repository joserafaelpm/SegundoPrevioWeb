package Modelo;

import Util.GenericDAO;
import Util.Conexion;
import Entidades.Tienda;

public class TiendaDAO extends Conexion<Tienda> implements GenericDAO<Tienda> {
 
	 public TiendaDAO() { 
		 super(Tienda.class);
	 }
}