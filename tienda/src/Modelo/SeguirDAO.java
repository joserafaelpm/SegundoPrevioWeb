package Modelo;

import Util.GenericDAO;
import Util.Conexion;
import Entidades.Seguir;

public class SeguirDAO extends Conexion<Seguir> implements GenericDAO<Seguir> {
 
	 public SeguirDAO() { 
		 super(Seguir.class);
	 }
}