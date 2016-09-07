package mh.negocio;

import java.util.List;

import javax.ejb.Local;

import mh.modelo.entidades.Prueba1;

@Local
public interface Prueba_LEJBLocal {

	public List<Prueba1> listarPrueba() throws Exception;
	
	public void guardar(Prueba1 prueba1);
}
