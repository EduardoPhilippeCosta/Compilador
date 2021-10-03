package controller;

import java.util.ArrayList;

import model.Constants;
import model.LexicalError;
import model.Token;

public class Lexico implements Constants
{
    private int position;
    private String input;
    private ArrayList<Integer> lineAnalyzer = new ArrayList<Integer>();

    public Lexico()
    {
        this("", new ArrayList<Integer>());
    }

    public Lexico(String input, ArrayList<Integer> lineAnalyzer)
    {
        setInput(input, lineAnalyzer);
    }

    public void setInput(String input, ArrayList<Integer> lineAnalyzer)
    {
        this.input = input;
        this.lineAnalyzer = lineAnalyzer;
        setPosition(0);
    }

    public void setPosition(int pos)
    {
        position = pos;
    }

    public Token nextToken() throws LexicalError
    {
        if ( ! hasInput() )
            return null;

        int start = position;

        int state = 0;
        int lastState = 0;
        int endState = -1;
        int end = -1;

        while (hasInput())
        {
            lastState = state;
            state = nextState(nextChar(), state);

            if (state < 0)
                break;

            else
            {
                if (tokenForState(state) >= 0)
                {
                    endState = state;
                    end = position;
                }
            }
        }
        if (endState < 0 || (endState != state && tokenForState(lastState) == -2)) {
        	int line = this.getLine(start);
        	
        	throw new LexicalError(input.substring(start, start+1) + " " + SCANNER_ERROR[lastState], start, line);
        }

        position = end;

        int token = tokenForState(endState);

        if (token == 0)
            return nextToken();
        else
        {
            String lexeme = input.substring(start, end);
            token = lookupToken(token, lexeme);
            
            if(token == 2) {
            	int line = this.getLine(start);
            	
            	throw new LexicalError(input.substring(start, end) + " palavra reservada inválida", start, line);
            }
            
            return new Token(token, lexeme, start);
        }
    }

    public int getLine(int position) {
    	int linhaErro = 0;
		
		for (int i = 0; i < this.lineAnalyzer.size(); i++) {
			if (position <= this.lineAnalyzer.get(i)) {
				linhaErro = i + 1;
				break;
			} else if (position == this.lineAnalyzer.get(i)) {
				linhaErro = i + 1;
				break;
			} else if (this.lineAnalyzer.size() - 1 == i) {
				linhaErro = this.lineAnalyzer.size();
				break;
			}
		}
		
		return linhaErro;
    }
    
    private int nextState(char c, int state)
    {
        int start = SCANNER_TABLE_INDEXES[state];
        int end   = SCANNER_TABLE_INDEXES[state+1]-1;

        while (start <= end)
        {
            int half = (start+end)/2;

            if (SCANNER_TABLE[half][0] == c)
                return SCANNER_TABLE[half][1];
            else if (SCANNER_TABLE[half][0] < c)
                start = half+1;
            else  //(SCANNER_TABLE[half][0] > c)
                end = half-1;
        }

        return -1;
    }

    private int tokenForState(int state)
    {
        if (state < 0 || state >= TOKEN_STATE.length)
            return -1;

        return TOKEN_STATE[state];
    }

    public int lookupToken(int base, String key)
    {
        int start = SPECIAL_CASES_INDEXES[base];
        int end   = SPECIAL_CASES_INDEXES[base+1]-1;

        while (start <= end)
        {
            int half = (start+end)/2;
            int comp = SPECIAL_CASES_KEYS[half].compareTo(key);

            if (comp == 0)
                return SPECIAL_CASES_VALUES[half];
            else if (comp < 0)
                start = half+1;
            else  //(comp > 0)
                end = half-1;
        }

        return base;
    }

    private boolean hasInput()
    {
        return position < input.length();
    }

    private char nextChar()
    {
        if (hasInput())
            return input.charAt(position++);
        else
            return (char) -1;
    }
}
