package MysticalComplexGame.Parser;

import java.util.*;

public class Tokenizer
{
    private Map<String,Token> tokenInfo;
    private List<Token> tokens;

    public Tokenizer()
    {
        this.tokenInfo = new HashMap<String, Token>();
        this.tokens = new LinkedList<Token>();
    }

    public void addToken(String token,Token tokenType)
    {
        this.tokenInfo.put(token, tokenType);
    }

    public List<Token> tokenize(String input)
    {
        tokens.clear();
        String tokens[] = input.split(" ");
        Token token;
        for (String str:tokens)
        {
            token = this.tokenInfo.get(str);
            this.tokens.add(token);
        }
        return this.tokens;
    }
}