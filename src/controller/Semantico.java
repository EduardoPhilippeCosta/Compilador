package controller;

import java.util.Stack;

import model.Constants;
import model.SemanticError;
import model.Tipo;
import model.Token;

public class Semantico implements Constants
{
	
	StringBuilder codigo = new StringBuilder();
	private Stack<Tipo> pilha_tipos = new Stack<>();
	String operador = "";
	
	
    public void executeAction(int action, Token token) throws SemanticError
    {
    	codigo.append("\n");
        try {
			switch (action) {
				case 5:
					acao5(token);
					break;
				case 6:
					acao6(token);
					break;
				case 14:
					acao14();
					break;
				case 15:
					acao15();
					break;
				case 16:
					acao16();
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + action);
			}
		} catch (Exception e) {
			throw new SemanticError(e.getMessage(), token.getPosition(), 0);
		}
    }	
    
    public void acao5(Token token) {
    	pilha_tipos.add(Tipo.INT);
    	codigo.append("ldc.i8 ").append(token.getLexeme());
    	codigo.append("\n").append("conv.r8");
    }
    
    public void acao6(Token token) {
    	pilha_tipos.add(Tipo.FLOAT);
    	codigo.append("ldc.r8 ").append(token.getLexeme());
    }
    
    public void acao14() {
    	Tipo tipo = pilha_tipos.pop();
    	if (tipo.equals(Tipo.INT)) {
    		codigo.append("conv.i8");
    	} else {
    		codigo.append("call void [mscorlib]System.Console::Write(").append(tipo.getTipo()).append(")");
    	}
    }
    
    public void acao15() {
    	codigo.append("código.adiciona(");
    	codigo.append("\n.assembly extern mscorlib {}");
    	codigo.append("\n.assembly _codigo_objeto {} ");
    	codigo.append("\n.module   _codigo_objeto.exe");
    	codigo.append("\n");
    	codigo.append("\n.class public _UNICA{ ");
    	codigo.append("\n.method static public void _principal() { ");
    	codigo.append("\n.entrypoint ");
    	codigo.append("\n)");
    }
    
    public void acao16() {
    	codigo.append("código.adiciona(");
    	codigo.append("\n\t\tret");
    	codigo.append("\n}");
    	codigo.append("\n}");
		codigo.append("\n)");
    }
}