package MysticalComplexGame.Parser;

import MysticalComplexGame.Commands.ICommand;
import MysticalComplexGame.Commands.ICommandVerbAlone;
import MysticalComplexGame.Commands.ICommandVerbDirection;
import MysticalComplexGame.Commands.ICommandVerbItem;
import MysticalComplexGame.Direction;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Player;

public class ParsedCommand
{
    private ICommand commandToExecute;
    private IItem itemArgument;
    private Direction directionArgument;

    public void setCommand(ICommand command)
    {
        commandToExecute = command;
    }

    public void setItemArgument(IItem itemArgument)
    {
        this.itemArgument = itemArgument;
    }

    public void setDirectionArgument(Direction directionArgument)
    {
        this.directionArgument = directionArgument;
    }

    public void executeCommand(Player player)
    {
        if (commandToExecute instanceof ICommandVerbAlone)
        {
            ICommandVerbAlone command = (ICommandVerbAlone)commandToExecute;
            command.executeCommand(player);
        }
        else if (commandToExecute instanceof ICommandVerbDirection)
        {
            ICommandVerbDirection command = (ICommandVerbDirection)commandToExecute;
            command.executeCommand(player,directionArgument);
        }
        else
        {
            ICommandVerbItem command = (ICommandVerbItem)commandToExecute;
            command.executeCommand(player,itemArgument);
        }
    }

    public boolean exists()
    {
        return commandToExecute != null;
    }
}
