package MysticalComplexGame.Parser;

import MysticalComplexGame.GameEngine;

import java.util.*;

public class Tokenizer
{
    private Map<String,Token> tokenInfo;
    private TokenStream tokens;

    public Tokenizer()
    {
        tokenInfo = new HashMap<>();
        tokens = new TokenStream();
    }

    public void addToken(String token,Token tokenType)
    {
        tokenInfo.put(token, tokenType);
    }

    public TokenStream tokenize(String input)
    {
        tokens.clear();
        String tokens[] = input.split(" ");
        for (int i=0;i<tokens.length;i++)
        {
            String str = tokens[i];
            if (tokenInfo.get(str) == Token.PREITEM && i+1<tokens.length)
            {
                this.tokens.add((str+" "+tokens[i+1]), Token.ITEM);
                i++;
            }
            else if (tokenInfo.get(str) == Token.PREITEM)
                this.tokens.add(str, Token.ITEM);
            else
                this.tokens.add(str, tokenInfo.get(str));
        }
        return this.tokens;
    }
}