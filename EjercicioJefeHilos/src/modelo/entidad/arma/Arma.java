package modelo.entidad.arma;

public abstract class Arma{
	
	private Integer dañoBase;

	public Arma(Integer dañoBase) {
		super();
		this.dañoBase = dañoBase;
	}
	
	public Integer usar() {
		return this.getDañoBase();
	}
	
	public Integer getDañoBase() {
		return dañoBase;
	}
	
	public void setDañoBase(Integer dañoBase) {
		this.dañoBase = dañoBase;
	}

}
