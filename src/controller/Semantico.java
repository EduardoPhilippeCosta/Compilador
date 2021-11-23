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
	
	
    public void executeAction(int action, Token token)	throws SemanticError
    {
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
    	codigo.append("\n");
    	codigo.append("ldc.i8 ").append(token.getLexeme());
    	codigo.append("\n").append("conv.r8");
    }
    
    public void acao6(Token token) {
    	pilha_tipos.add(Tipo.FLOAT);
    	codigo.append("\n");
    	codigo.append("ldc.r8 ").append(token.getLexeme());
    }
    
    public void acao14() {
    	Tipo tipo = pilha_tipos.pop();
    	codigo.append("\n");
    	if (tipo.equals(Tipo.INT)) {
    		codigo.append("conv.i8");
    	} else {
    		codigo.append("call void [mscorlib]System.Console::Write(").append(tipo.getTipo()).append(")");
    	}
    }
    
    public void acao15() {
    	codigo.append("código.adiciona(\r\n"
    			+ "    .assembly extern mscorlib {}\r\n"
    			+ "    .assembly _codigo_objeto{}\r\n"
    			+ "    .module   _codigo_objeto.exe\r\n"
    			+ "\r\n"
    			+ "    .class public _UNICA{ \r\n"
    			+ "    .method static public void _principal() {\r\n"
    			+ "      .entrypoint \r\n"
    			+ "  )");
    }
    
    public void acao16() {
    	codigo.append("código.adiciona(\r\n"
    			+ "       ret\r\n"
    			+ "       }\r\n"
    			+ "    }\r\n"
    			+ "  )");
    }
}