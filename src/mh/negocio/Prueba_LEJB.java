package mh.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mh.modelo.dao.PruebaDAO;
import mh.modelo.entidades.Prueba1;

/**
 * Session Bean implementation class Prueba_LEJB
 */
@Stateless
@LocalBean
public class Prueba_LEJB implements Prueba_LEJBLocal {

    /**
     * Default constructor. 
     */
	
	@EJB PruebaDAO pruebaDAO;
	
    public Prueba_LEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Prueba1> listarPrueba() throws Exception {

		return this.pruebaDAO.listarPrueba();
	}

    public void guardar(Prueba1 prueba1)
    {
    	this.pruebaDAO.crear(prueba1);
    }
}
