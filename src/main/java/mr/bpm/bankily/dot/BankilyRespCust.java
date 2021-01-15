package mr.bpm.bankily.dot;

import java.io.Serializable;

public class BankilyRespCust implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int nombre;
	String item;
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	



	
}
