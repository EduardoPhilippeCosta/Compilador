package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import model.Constants;
import model.SemanticError;
import model.Tipo;
import model.Token;

public class Semantico implements Constants {

	StringBuilder codigo = new StringBuilder();
	private Stack<Tipo> pilha_tipos = new Stack<>();
	private ArrayList<String> lista_id = new ArrayList<String>();
	private Stack<Integer> pilha_rotulos = new Stack<>();
	String operador = "";
	int rotulo = 1;

	public String getCodigo() {
		return this.codigo.toString();
	}

	public void executeAction(int action, Token token) throws SemanticError {
		codigo.append("\n");
		try {
			switch (action) {
			case 1:
				acao1();
				break;
			case 2:
				acao2();
				break;
			case 3:
				acao3();
				break;
			case 4:
				acao4();
				break;
			case 5:
				acao5(token);
				break;
			case 6:
				acao6(token);
				break;
			case 7:
				acao7();
				break;
			case 8:
				acao8();
				break;
			case 9:
				acao9(token);
				break;
			case 10:
				acao10();
				break;
			case 11:
				acao11();
				break;
			case 12:
				acao12();
				break;
			case 13:
				acao13();
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
			case 18:
				acao18();
				break;
			case 19:
				acao19();
				break;
			case 20:
				acao20();
				break;
			case 21:
				acao21();
				break;
			case 22:
				acao22();
				break;
			case 23:
				acao23(token);
				break;
			case 24:
				acao24(token);
				break;
			case 25:
				acao25(token);
				break;
			case 27:
				acao27(token);
				break;
			case 28:
				acao28();
				break;
			case 29:
				acao29();
				break;
			case 30:
				acao30();
				break;
			case 31:
				acao31();
				break;
			case 32:
				acao32();
				break;
			case 33:
				acao33();
				break;
			case 34:
				acao34(token);
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
			codigo.append("conv.i8\n");
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
		} else if (!tipo1Correto || !tipo2Correto) {
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

	public void acao11() {
		pilha_tipos.push(Tipo.BOOL);
		codigo.append("ldc.i4.1");
	}

	public void acao12() {
		pilha_tipos.push(Tipo.BOOL);
		codigo.append("ldc.i4.0");
	}

	public void acao2() throws Exception {
		Tipo tipo1 = pilha_tipos.pop();
		Tipo tipo2 = pilha_tipos.pop();

		boolean tipo1Correto = tipo1.equals(Tipo.FLOAT) || tipo1.equals(Tipo.INT);
		boolean tipo2Correto = tipo2.equals(Tipo.FLOAT) || tipo2.equals(Tipo.INT);
		if (!tipo1Correto && !tipo2Correto) {
			throw new Exception("tipos incompatíveis em expressão aritmética.");
		} else if (!tipo1Correto || !tipo2Correto) {
			throw new Exception("tipo incompatível em expressão aritmética.");
		}

		if (tipo1.equals(Tipo.FLOAT) || tipo2.equals(Tipo.FLOAT)) {
			pilha_tipos.push(Tipo.FLOAT);
		} else {
			pilha_tipos.push(Tipo.INT);
		}

		codigo.append("sub");
	}

	public void acao3() throws Exception {
		Tipo tipo1 = pilha_tipos.pop();
		Tipo tipo2 = pilha_tipos.pop();

		boolean tipo1Correto = tipo1.equals(Tipo.FLOAT) || tipo1.equals(Tipo.INT);
		boolean tipo2Correto = tipo2.equals(Tipo.FLOAT) || tipo2.equals(Tipo.INT);
		if (!tipo1Correto && !tipo2Correto) {
			throw new Exception("tipos incompatíveis em expressão aritmética.");
		} else if (!tipo1Correto || !tipo2Correto) {
			throw new Exception("tipo incompatível em expressão aritmética.");
		}

		if (tipo1.equals(Tipo.FLOAT) || tipo2.equals(Tipo.FLOAT)) {
			pilha_tipos.push(Tipo.FLOAT);
		} else {
			pilha_tipos.push(Tipo.INT);
		}

		codigo.append("mul");
	}

	public void acao4() throws Exception {
		Tipo tipo1 = pilha_tipos.pop();
		Tipo tipo2 = pilha_tipos.pop();

		boolean tipo1Correto = tipo1.equals(Tipo.FLOAT) || tipo1.equals(Tipo.INT);
		boolean tipo2Correto = tipo2.equals(Tipo.FLOAT) || tipo2.equals(Tipo.INT);
		if (!tipo1Correto && !tipo2Correto) {
			throw new Exception("tipos incompatíveis em expressão aritmética.");
		} else if (!tipo1Correto || !tipo2Correto) {
			throw new Exception("tipo incompatível em expressão aritmética.");
		}

		if (tipo1.equals(tipo2)) {
			pilha_tipos.push(tipo1);
		} else {
			throw new Exception("Erro semântica: Tipos incopatíveis ao realizar divisão.");
		}

		codigo.append("div");
	}

	public void acao7() throws Exception {
		Tipo tipo = pilha_tipos.pop();

		boolean tipoCorreto = tipo.equals(Tipo.FLOAT) || tipo.equals(Tipo.INT);
		if (tipoCorreto) {
			pilha_tipos.push(tipo);
		} else {
			throw new Exception("tipos incompatíveis em expressão aritmética.");
		}
	}

	public void acao8() throws Exception {
		Tipo tipo = pilha_tipos.pop();
		boolean tipoCorreto = tipo.equals(Tipo.FLOAT) || tipo.equals(Tipo.INT);

		if (tipoCorreto) {
			pilha_tipos.push(tipo);
		} else {
			throw new Exception("tipos incompatíveis em expressão aritmética.");
		}

		codigo.append("\nldc.i8 -1");
		codigo.append("\nconv.r8");
		codigo.append("\nmul");
	}

	public void acao9(Token token) {
		operador = token.getLexeme();
	}

	public void acao13() throws Exception {
		Tipo tipo = pilha_tipos.pop();

		if (tipo.equals(Tipo.BOOL)) {
			pilha_tipos.push(Tipo.BOOL);
		} else {
			throw new Exception("Tipo incompatível em exprssão lógica.");
		}

		codigo.append("\nldc.i4.1");
		codigo.append("\nxor");
	}

	public void acao18() {
		pilha_tipos.push(Tipo.STRING);
		codigo.append("ldsrt ");
		codigo.append("\"\\n\"");
	}

	public void acao19() {
		pilha_tipos.push(Tipo.STRING);
		codigo.append("ldsrt ");
		codigo.append("\" \"");		
	}

	public void acao20() {
		pilha_tipos.push(Tipo.STRING);
		codigo.append("ldsrt ");
		codigo.append("\"\\t\"");
	}

	public void acao21() throws Exception {
		Tipo tipo1 = pilha_tipos.pop();
		Tipo tipo2 = pilha_tipos.pop();

		boolean tipoCorreto = tipo1.equals(Tipo.BOOL) && tipo2.equals(Tipo.BOOL);

		if (!tipoCorreto) {
			throw new Exception("Tipos incompatível em exprssão lógica.");
		}

		pilha_tipos.push(Tipo.BOOL);
		codigo.append("and");
	}

	public void acao22() throws Exception {
		Tipo tipo1 = pilha_tipos.pop();
		Tipo tipo2 = pilha_tipos.pop();

		boolean tipoCorreto = tipo1.equals(Tipo.BOOL) && tipo2.equals(Tipo.BOOL);

		if (!tipoCorreto) {
			throw new Exception("Tipos incompatíveis em expressão lógica.");
		}

		pilha_tipos.push(Tipo.BOOL);
		codigo.append("or");
	}

	public void acao10() throws Exception {
		Tipo tipo1 = pilha_tipos.pop();
		Tipo tipo2 = pilha_tipos.pop();

		boolean tipoNumeroCorreto = (tipo1.equals(Tipo.FLOAT) || tipo1.equals(Tipo.INT))
				&& (tipo2.equals(Tipo.FLOAT) || tipo2.equals(Tipo.INT));
		boolean tipoStringCorreto = tipo1.equals(Tipo.STRING) && tipo2.equals(Tipo.STRING);

		if (tipoNumeroCorreto || tipoStringCorreto) {
			pilha_tipos.push(Tipo.BOOL);
		} else {
			throw new Exception("Tipos incompatíveis em expressão lógica.");
		}

		switch (operador) {
		case ">":
			codigo.append("cgt");
			break;
		case "<":
			codigo.append("clt");
			break;
		case "==":
			codigo.append("ceq");
			break;
		case "<>":
			codigo.append("ceq");
			codigo.append("\nldc.i4 0");
			codigo.append("\nceq");
			break;
		}

	}

	public void acao34(Token token) {
		codigo.append("ldloc ");
		codigo.append(token.getLexeme());

		Tipo tipo = pegarTipo(token.getLexeme());

		pilha_tipos.push(tipo);

		if (tipo.equals(Tipo.INT)) {
			codigo.append("\nconv.r8");
		}
	}

	public void acao24(Token token) {
		lista_id.add(token.getLexeme());
	}

	public void acao23(Token token) {
		for (int i = 0; i < lista_id.size(); i++) {
			String id = lista_id.get(i);
			Tipo tipo = pegarTipo(token.getLexeme());

			codigo.append(".locals(");
			codigo.append(tipo.getTipo());
			codigo.append(" ");
			codigo.append(id);
			codigo.append(")");
		}
	}

	private Tipo pegarTipo(String lexeme) {
		return lexeme.startsWith("I") ? Tipo.INT
				: lexeme.startsWith("F") ? Tipo.FLOAT : lexeme.startsWith("S") ? Tipo.STRING : Tipo.BOOL;
	}

	public void acao25(Token token) {
		String id = lista_id.remove(lista_id.size() - 1);
		
		Tipo tipo = pegarTipo(id);

		if (tipo.equals(Tipo.INT)) {
			codigo.append("conv.i8\n");
		}
		
		codigo.append("stloc ");
		
		codigo.append(id);
	}

	public void acao27(Token token) {
		Tipo tipo = pegarTipo(token.getLexeme());
		
		codigo.append("call string [mscorlib]System.Console::ReadLine()\n");
		
		if (tipo.equals(Tipo.INT)) {			
			codigo.append("call int64 [mscorlib]System.Int64::Parse(string)");	
		} else if(tipo.equals(Tipo.FLOAT)) {
			codigo.append("call float64 [mscorlib]System.Double::Parse(string)");
		} else if(tipo.equals(Tipo.BOOL)) {
			codigo.append("call bool [mscorlib]System.Boolean::Parse(string)");
		}

		codigo.append("\nstloc ");
		codigo.append(token.getLexeme());
		
		lista_id.clear();
	}

	public void acao28() {
		String rotuloStr = "r" + rotulo;
		codigo.append("brfalse " + rotuloStr);
		pilha_rotulos.push(rotulo);
		this.rotulo = this.rotulo + 1;
	}

	public void acao29() {
		codigo.append("r" + pilha_rotulos.pop() + ":");
	}

	public void acao30() {
		String rotuloStr = "r" + rotulo;
		codigo.append("br " + rotuloStr);
		codigo.append("\nr" + pilha_rotulos.pop() + ":");
		pilha_rotulos.push(rotulo);
		this.rotulo = this.rotulo + 1;
	}

	public void acao31() {
		String rotuloStr = "r" + rotulo;
		codigo.append(rotuloStr+":");
		pilha_rotulos.push(rotulo);
		this.rotulo = this.rotulo + 1;
	}

	public void acao32() {
		String rotuloStr = "r" + rotulo;
		codigo.append("brtrue " + rotuloStr);
		pilha_rotulos.push(rotulo);
		this.rotulo = this.rotulo + 1;
	}

	public void acao33() {
		int rotuloTrue = pilha_rotulos.pop();
		codigo.append("br r" + pilha_rotulos.pop());
		codigo.append("\nr"+rotuloTrue+":");
	}

}
