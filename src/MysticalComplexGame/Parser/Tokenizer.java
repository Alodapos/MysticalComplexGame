package MysticalComplexGame.Parser;

import java.util.*;

public class Tokenizer
{
    private Map<String,Token> tokenInfo;
    private TokenStream tokens;

    public Tokenizer()
    {
        tokenInfo = new HashMap<String, Token>();
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
        for (String str:tokens)
        {
            this.tokens.add(str, tokenInfo.get(str));
        }
        return this.tokens;
    }
}