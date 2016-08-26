
package mh.managedbean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;



/**
 *
 * @author harlap
 */
@ManagedBean
public class PrincipalMB implements Serializable {
	private String saludo;

	private String bandera = "mierda";
	
	private static final Logger LOG = Logger.getLogger(PrincipalMB.class.getName());
	
	public PrincipalMB()
	{
		LOG.info(".....");
		saludo = "saludo desde PrincipalMB";
	}
	
	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	/**
	 * @return the bandera
	 */
	public String getBandera() {
		return bandera;
	}

	/**
	 * @param bandera the bandera to set
	 */
	public void setBandera(String bandera) {
		this.bandera = bandera;
	}
}
