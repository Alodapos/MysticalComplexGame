package MysticalComplexGame.Parser;

import MysticalComplexGame.Commands.ICommandVerbAlone;
import MysticalComplexGame.Commands.ICommandVerbDirection;
import MysticalComplexGame.Commands.ICommandVerbItem;
import MysticalComplexGame.Direction;
import MysticalComplexGame.GameContent;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class Parser
{
    Boolean parseSuccess;
    String textCommandNotFound;
    String textWrongGrammar;
    String textWrongDirection;
    String textWrongItem;
    TokenStream stream;
    GameContent content;
    Player player;

    public Parser()
    {
        parseSuccess = false;
        textCommandNotFound = "This is not a command that i recognize!";
        textWrongGrammar = "I understood as far as you wanted to ";
        textWrongDirection = " somewhere.";
        textWrongItem = " something.";
        stream = new TokenStream();

    }

    public void parse(TokenStream input, GameContent content,Player player)
    {
        parseSuccess = false;
        stream = input;
        this.content = content;
        this.player = player;

        verbSoloParse();
        if (!parseSuccess) verbDirectionParse();
        if (!parseSuccess) verbItemParse();
        if (!parseSuccess) GameEngine.textOutput(textCommandNotFound);
        stream.clear();
    }

    private void verbSoloParse()
    {
        if (stream.getToken(0) == Token.VERBSOLO)
        {
            stream.popToken();
            parseSuccess = true;
            verbSoloExec();
        }
    }

    private void verbSoloExec()
    {
        if (stream.isEmpty())
        {
            ICommandVerbAlone command;
            command = (ICommandVerbAlone)content.getCommand(stream.getText(0));
            command.executeCommand(player);
        }
        else outputWrongGrammar("");
    }

    private void verbDirectionParse()
    {
        if (stream.getToken(0) == Token.VERBDIRECTION)
        {
            stream.popToken();
            parseSuccess = true;
            verbDirectionArg();
        }
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
            ICommandVerbDirection command;
            command = (ICommandVerbDirection)content.getCommand(stream.getText(0));
            command.executeCommand(player,Direction.fromString(stream.getText(1)));
        }
        else outputWrongGrammar(stream.getText(1));
    }

    private void verbItemParse()
    {
        if (stream.getToken(0) == Token.VERBITEM)
        {
            stream.popToken();
            parseSuccess = true;
            verbItemArg();
        }
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
            ICommandVerbItem command;
            command = (ICommandVerbItem)content.getCommand(stream.getText(0));
            command.executeCommand(player,content.stringToItem(stream.getText(1)));
        }
        else outputWrongGrammar(stream.getText(1));
    }

    private void outputWrongGrammar(String extraText)
    {
        GameEngine.textOutput(textWrongGrammar + stream.getText(0) + " " + extraText);
    }
}
