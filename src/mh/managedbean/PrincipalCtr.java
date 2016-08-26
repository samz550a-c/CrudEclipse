
package mh.managedbean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.faces.bean.ManagedBean;



/**
 *
 * @author harlap
 */
@ManagedBean
public class PrincipalCtr implements Serializable {
    private String bandera;
    
    private String hora;
    
    private String saludo;
    
    private SimpleDateFormat simpleDateFormat;
    
    
    
    public PrincipalCtr()
    {
        bandera = "MMMfin2";
        
        saludo = "pedito";
        simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
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

    /**
     * @return the hora
     */
    public String getHora() {
        return simpleDateFormat.format(new Date());
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

	/**
	 * @return the saludo
	 */
	public String getSaludo() {
		return saludo;
	}

	/**
	 * @param saludo the saludo to set
	 */
	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
}
