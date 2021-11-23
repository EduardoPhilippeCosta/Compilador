package model;

public enum Tipo {
	
	INT("int64"), 
	FLOAT("float64"), 
	BOOL("bool"), 
	STRING("string");
	
	private final String tipo;

	private Tipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
}
