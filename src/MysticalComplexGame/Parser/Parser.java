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

    public Parser()
    {
        textCommandNotFound = "This is not a command that i recognize!";
        textWrongGrammar = "I understood as far as you wanted to ";
        textWrongDirection = " somewhere.";
        textWrongItem = " something.";
        stream = new TokenStream();
        command = new ParsedCommand();

    }

    public ParsedCommand parse(TokenStream input, GameContent content,Player player)
    {
        stream = input;
        this.content = content;
        this.player = player;

        if (stream.getToken(0) == Token.VERBSOLO) verbSoloParse();
        else if (stream.getToken(0) == Token.VERBDIRECTION) verbDirectionParse();
        else if (stream.getToken(0) == Token.VERBITEM) verbItemParse();
        else GameEngine.textOutput(textCommandNotFound);
        stream.clear();
        return command;
    }

    private void verbSoloParse()
    {
        stream.popToken();
        verbSoloExec();
    }

    private void verbSoloExec()
    {
        if (stream.isEmpty()) command.setCommand(content.getCommand(stream.getText(0)));
        else outputWrongGrammar("");
    }

    private void verbDirectionParse()
    {
        stream.popToken();
        verbDirectionArg();
    }

    private void verbDirectionArg()
    {
        if (stream.popToken() == Token.DIRECTION)
            verbDirectionExec();
        else outputWrongGrammar(textWrongDirection);
    }

    private void verbDirectionExec()
    {
        if (stream.isEmpty())
        {
            command.setCommand(content.getCommand(stream.getText(0)));
            command.setDirectionArgument(Direction.fromString(stream.getText(1)));
        }
        else outputWrongGrammar(stream.getText(1));
    }

    private void verbItemParse()
    {
        stream.popToken();
        verbItemArg();
    }

    private void verbItemArg()
    {
        if (stream.popToken() == Token.ITEM)
            verbItemExec();
        else outputWrongGrammar(textWrongItem);
    }

    private void verbItemExec()
    {
        if (stream.isEmpty())
        {
            this.command.setCommand(content.getCommand(stream.getText(0)));
            this.command.setItemArgument(content.stringToItem(stream.getText(1)));
        }
        else outputWrongGrammar(stream.getText(1));
    }

    private void outputWrongGrammar(String extraText)
    {
        GameEngine.textOutput(textWrongGrammar + stream.getText(0) + " " + extraText);
    }
}
