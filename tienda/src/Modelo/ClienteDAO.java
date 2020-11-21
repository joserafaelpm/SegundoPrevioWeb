package Modelo;

import Util.GenericDAO;
import Util.Conexion;
import Entidades.Cliente;

public class ClienteDAO extends Conexion<Cliente> implements GenericDAO<Cliente> {
 
	 public ClienteDAO() { 
		 super(Cliente.class);
	 }
}