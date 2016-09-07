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

	@EJB Prueba_LEJBLocal prueba_LEJBLocal;
	
	private static final Logger LOG = Logger.getLogger(PruebaMB.class.getName());
	
	private String nombre;
	
	private Prueba1 registroSeleccionado;
	
	private String origen = null;
	
	public List<Prueba1> listar()
	{
		List<Prueba1> lista = null;
		try {
			lista = this.prueba_LEJBLocal.listarPrueba();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return lista;
	}

	
	
	public void inicializarRegistro()
	{
		LOG.info("inicializarRegistro()");
		this.registroSeleccionado = new Prueba1();
		this.origen = "agregar";
	}
	
	public void preparandoRegistro()
	{
		LOG.info("preparandoRegistro()2");
		LOG.info("this.registroSeleccionado = " + this.registroSeleccionado);
		this.origen = "modificar";
	}
	
	public void registrarListener()
	{
		LOG.info("Entrando a registrar");
		
		LOG.info("Valor nombre= " + this.registroSeleccionado.getNombre());
		
		/*Prueba1 prueba1 = new Prueba1();
		prueba1.setNombre( this.nombre );*/
		
		if( origen.equals("agregar") )
		{
			this.prueba_LEJBLocal.guardar(this.registroSeleccionado);
		}
		else if( origen.equals("modificar") )
		{
			this.prueba_LEJBLocal.modificar(this.registroSeleccionado);
		}
		
		LOG.info("debería haber grabado.2");
		this.registroSeleccionado = null;
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

	public Prueba1 getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(Prueba1 registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	
}
