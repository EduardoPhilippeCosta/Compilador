package model;

public class SyntaticError extends AnalysisError
{
	
	private String token;
    public SyntaticError(String msg, int position, int linha, String token)
	 {
        super(msg, position, linha);
        this.token = token;
    }

    public SyntaticError(String msg)
    {
        super(msg);
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
    
    
}
