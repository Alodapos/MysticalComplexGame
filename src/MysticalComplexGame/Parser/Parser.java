package MysticalComplexGame.Parser;

import MysticalComplexGame.Direction;
import MysticalComplexGame.GameContent;
import MysticalComplexGame.GameEngine;

public class Parser
{
    private final String textCommandNotFound;
    private final String textWrongGrammar;
    private final String textWrongDirection;
    private final String textWrongItem;
    private TokenStream stream;
    private GameContent content;
    private final ParsedCommand command;
    private boolean commandNotFound;

    public Parser()
    {
        textCommandNotFound = "This is not a command that i recognize!";
        textWrongGrammar = "I understood as far as you wanted to ";
        textWrongDirection = "somewhere.";
        textWrongItem = "something.";
        stream = new TokenStream();
        command = new ParsedCommand();
    }

    public ParsedCommand parse(TokenStream input, GameContent content)
    {
        stream = input;
        this.content = content;
        command.setCommand(null);
        commandNotFound = true;
        verbSoloParse();
        if (commandNotFound)
            verbDirectionParse();
        if (commandNotFound)
            verbItemParse();
        stream.clear();
        if (commandNotFound)
            GameEngine.textOutput(textCommandNotFound);
        return command;
    }

    private void verbSoloParse()
    {
        if (stream.getNextToken() == Token.VERBSOLO)
        {
            stream.popToken();
            commandNotFound = false;
            if (stream.isEmpty())
                command.setCommand(content.stringToCommand(stream.getText(0)));
            else
                outputWrongGrammar(".");
        }
    }

    private void verbDirectionParse()
    {
        if (stream.getNextToken() == Token.VERBWITHDIRECTION)
        {
            commandNotFound = false;
            stream.popToken();
            if (stream.popToken() == Token.DIRECTION)
                if (stream.isEmpty())
                {
                    command.setCommand(content.stringToCommand(stream.getText(0)));
                    command.setDirectionArgument(Direction.fromString(stream.getText(1)));
                }
                else
                    outputWrongGrammar(stream.getText(1));
            else
                outputWrongGrammar(textWrongDirection);
        }
    }

    private void verbItemParse()
    {
        if (stream.getNextToken() == Token.VERBWITHITEM)
        {
            commandNotFound = false;
            stream.popToken();
            if (stream.popToken() == Token.ITEM)
                if (stream.isEmpty())
                {
                    this.command.setCommand(content.stringToCommand(stream.getText(0)));
                    this.command.setItemArgument(content.stringToItem(stream.getText(1)));
                }
                else
                    outputWrongGrammar(stream.getText(1));
            else
                outputWrongGrammar(textWrongItem);
        }
    }

    private void outputWrongGrammar(String extraText)
    {
        GameEngine.textOutput(textWrongGrammar + stream.getText(0) + " " + extraText);
    }
}
