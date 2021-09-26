package model;

public class LexicalError extends AnalysisError
{
    public LexicalError(String msg, int position, int line)
	 {
        super(msg, position, line);
    }

    public LexicalError(String msg)
    {
        super(msg);
    }
}
