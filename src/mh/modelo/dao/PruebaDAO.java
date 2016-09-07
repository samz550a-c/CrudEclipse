package mh.modelo.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import mh.modelo.entidades.*;

/**
 * Session Bean implementation class prueba_LEJB
 */
@Stateless
@LocalBean
public class PruebaDAO {

	//@PersistenceContext(unitName = "PlantillaPU")
	@PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;
	
	private static final Logger LOG = Logger.getLogger(PruebaDAO.class.getName());
	
    public PruebaDAO() {
        // TODO Auto-generated constructor stub
    }

    public List<Prueba1> listarPrueba() throws Exception {
        try {
            Query query = em.createNamedQuery("Prueba1.findAll");

            //query.setParameter("idPerson", idPerson);
            
            List<Prueba1> list = (List<Prueba1>)query.getResultList();

            return list;
            
        } catch (NoResultException e) {
            LOG.log(Level.WARNING, "No se encontraron resultados.", e);
            return null;
        } catch (Exception e) {
            throw new Exception("Error - public List<Prueba1> listarIdPerson(int idPerson) throws LogicalTireException", e);
        }
    }
    
    //=====================================================================================
    private int ultimoId()
    {
    	Query query = em.createQuery("select MAX(p.id) from Prueba1 p");
    	
    	Number numero = (Number) query.getSingleResult();
    	
    	int respuesta = -1;
    	if(numero != null)
    	{
    		respuesta = numero.intValue();
    	}
    	
    	return respuesta;
    }
    
    public void crear(Prueba1 prueba1)
    {
    	prueba1.setId( this.ultimoId() + 1);
    	em.persist(prueba1);
    }
}
