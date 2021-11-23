package model;

public class Token
{
    private int id;
    private String lexeme;
    private int position;
    private int line;

    public Token(int id, String lexeme, int position, int line)
    {
        this.id = id;
        this.lexeme = lexeme;
        this.position = position;
        this.line = line;
    }

    public final int getId()
    {
        return id;
    }

    public final String getLexeme()
    {
        return lexeme;
    }

    public final int getPosition()
    {
        return position;
    }
    
    public final int getLine()
    {
        return line;
    }

    public String toString()
    {
        return id+" ( "+lexeme+" ) @ "+position;
    };
}
