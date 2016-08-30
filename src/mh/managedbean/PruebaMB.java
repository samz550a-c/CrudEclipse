package mh.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mh.modelo.entidades.Prueba1;
import mh.negocio.Prueba_LEJBLocal;

@ManagedBean
@ViewScoped
public class PruebaMB {

	@EJB Prueba_LEJBLocal Prueba_LEJBLocal;
	
	
	public List<Prueba1> listar()
	{
		List<Prueba1> lista = null;
		try {
			lista = this.Prueba_LEJBLocal.listarPrueba();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return lista;
	}
	
	
}
