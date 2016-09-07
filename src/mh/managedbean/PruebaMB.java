package mh.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.jboss.logging.Logger;

import mh.modelo.entidades.Prueba1;
import mh.negocio.Prueba_LEJBLocal;

@ManagedBean
@ViewScoped
public class PruebaMB {

	@EJB Prueba_LEJBLocal Prueba_LEJBLocal;
	
	private static final Logger LOG = Logger.getLogger(PruebaMB.class.getName());
	
	private String nombre;
	
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

	public void registrarListener()
	{
		LOG.info("Entrando a registrar");
		
		LOG.info("Valor nombre= " + this.nombre);
		
		Prueba1 prueba1 = new Prueba1();
		prueba1.setNombre( this.nombre );
		this.Prueba_LEJBLocal.guardar(prueba1);
		
		LOG.info("debería haber grabado.");
	}
	//----------------------------------------------
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
