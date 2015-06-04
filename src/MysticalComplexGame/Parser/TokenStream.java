package MysticalComplexGame.Parser;

import java.util.LinkedList;
import java.util.List;

public class TokenStream
{
    private final List<String> textStream;
    private final List<Token> tokenStream;

    public TokenStream()
    {
        textStream = new LinkedList<>();
        tokenStream = new LinkedList<>();
    }

    public String getText(int index)
    {
        return textStream.get(index);
    }

    public Token popToken()
    {
        if (tokenStream.isEmpty()) return  null;
        else return tokenStream.remove(0);
    }

    public Token getNextToken()
    {
     return tokenStream.get(0);
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

    public boolean isEmpty()
    {
        return tokenStream.isEmpty();
    }
}
