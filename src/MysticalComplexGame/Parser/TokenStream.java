package MysticalComplexGame.Parser;

import java.util.LinkedList;
import java.util.List;

public class TokenStream
{
    private List<String> textStream;
    private List<Token> tokenStream;

    public TokenStream()
    {
        textStream = new LinkedList<String>();
        tokenStream = new LinkedList<Token>();
    }

    public String getText(int index)
    {
        return textStream.get(index);
    }

    public Token popToken()
    {
        return tokenStream.remove(0);
    }

    public Token getToken(int index)
    {
     return tokenStream.get(index);
    }

    public void clear()
    {
        textStream.clear();
        tokenStream.clear();
    }

    public void add(String text,Token token)
    {
        textStream.add(text);
        tokenStream.add(token);
    }

    public List<String> texts()
    {
        return textStream;
    }

    public List<Token> tokens()
    {
        return tokenStream;
    }

    public boolean isEmpty()
    {
        return tokenStream.isEmpty();
    }
}
