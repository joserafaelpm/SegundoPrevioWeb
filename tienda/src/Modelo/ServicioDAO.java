package Modelo;

import Util.GenericDAO;
import Util.Conexion;
import Entidades.Servicio;

public class ServicioDAO extends Conexion<Servicio> implements GenericDAO<Servicio> {
 
	 public ServicioDAO() { 
		 super(Servicio.class);
	 }
}