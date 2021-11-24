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
				case 1:
					acao1();
					break;
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
				case 17:
					acao17(token);
					break;
				default:
					throw new SemanticError("Ação semântica não implementada: " + action);
			}
		} catch (Exception e) {
			throw new SemanticError(e.getMessage(), token.getPosition(), token.getLine());
		}
    }	
    
    public void acao5(Token token) {
    	pilha_tipos.push(Tipo.INT);
    	codigo.append("ldc.i8 ").append(token.getLexeme());
    	codigo.append("\n").append("conv.r8");
    }
    
    public void acao6(Token token) {
    	pilha_tipos.push(Tipo.FLOAT);
    	codigo.append("ldc.r8 ").append(token.getLexeme());
    }
    
    public void acao14() {
    	Tipo tipo = pilha_tipos.pop();
    	if (tipo.equals(Tipo.INT)) {
    		codigo.append("conv.i8");
    	}
    	codigo.append("call void [mscorlib]System.Console::Write(").append(tipo.getTipo()).append(")");
    }
    
    public void acao15() {
    	codigo.append("\n.assembly extern mscorlib {}");
    	codigo.append("\n.assembly _codigo_objeto {} ");
    	codigo.append("\n.module   _codigo_objeto.exe");
    	codigo.append("\n");
    	codigo.append("\n.class public _UNICA{ ");
    	codigo.append("\n.method static public void _principal() { ");
    	codigo.append("\n.entrypoint ");
    }
    
    public void acao16() {
    	codigo.append("\t\tret");
    	codigo.append("\n\t}");
    	codigo.append("\n}");
    }
    

    public void acao1() throws Exception {
    	Tipo tipo1 = pilha_tipos.pop();
    	Tipo tipo2 = pilha_tipos.pop();
    	boolean tipo1Correto = tipo1.equals(Tipo.FLOAT) || tipo1.equals(Tipo.INT);
    	boolean tipo2Correto = tipo2.equals(Tipo.FLOAT) || tipo2.equals(Tipo.INT);
    	if (!tipo1Correto && !tipo2Correto) {
    		throw new Exception("tipos incompatíveis em expressão aritmética.");
    	} else if(!tipo1Correto || !tipo2Correto) {
    		throw new Exception("tipo incompatível em expressão aritmética.");
    	}
    	
    	if (tipo1 == Tipo.FLOAT || tipo2 == Tipo.FLOAT) {
    		pilha_tipos.push(Tipo.FLOAT);
    	} else {
    		pilha_tipos.push(Tipo.INT);
    	}
    	
    	codigo.append("add");
    }

    public void acao17(Token token) {
    	pilha_tipos.push(Tipo.STRING);
    	codigo.append("ldstr ").append(token.getLexeme());
    }
    
    
}






















