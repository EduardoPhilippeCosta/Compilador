package model;

public enum Operador {
	EQUAL("=="),
	DIFFERENT("<>"),
	GREATERTHAN(">"),
	LOWERTHAN("<");
	
	private final String operador;
	
	private Operador(String operador) {
		this.operador = operador;
	}
	
	public String getOperador() {
		return this.operador;
	}
}
