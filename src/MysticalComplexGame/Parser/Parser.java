package MysticalComplexGame.Parser;

import MysticalComplexGame.Direction;
import MysticalComplexGame.GameContent;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class Parser
{
    String textCommandNotFound;
    String textWrongGrammar;
    String textWrongDirection;
    String textWrongItem;
    TokenStream stream;
    GameContent content;
    Player player;
    ParsedCommand command;
    boolean commandNotFound;

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
        this.player = content.getPlayer();
        command.setCommand(null);
        commandNotFound = true;
        verbSoloParse();
        verbDirectionParse();
        verbItemParse();
        stream.clear();
        if (commandNotFound)
            GameEngine.textOutput(textCommandNotFound);
        return command;
    }

    private void verbSoloParse()
    {
        if (stream.getToken(0) == Token.VERBSOLO)
        {
            stream.popToken();
            commandNotFound = false;
            if (stream.isEmpty())
                command.setCommand(content.getCommand(stream.getText(0)));
            else
                outputWrongGrammar(".");
        }
    }

    private void verbDirectionParse()
    {
        if (stream.getToken(0) == Token.VERBDIRECTION)
        {
            commandNotFound = false;
            stream.popToken();
            if (stream.popToken() == Token.DIRECTION)
                if (stream.isEmpty())
                {
                    command.setCommand(content.getCommand(stream.getText(0)));
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
        if (stream.getToken(0) == Token.VERBITEM)
        {
            commandNotFound = false;
            stream.popToken();
            if (stream.popToken() == Token.ITEM)
                if (stream.isEmpty())
                {
                    this.command.setCommand(content.getCommand(stream.getText(0)));
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
