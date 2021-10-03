package model;

public class LexicalError extends AnalysisError
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LexicalError(String msg, int position, int line)
	 {
        super(msg, position, line);
    }

    public LexicalError(String msg)
    {
        super(msg);
    }
}
