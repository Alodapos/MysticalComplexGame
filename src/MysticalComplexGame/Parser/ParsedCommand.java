package MysticalComplexGame.Parser;

import MysticalComplexGame.Commands.ICommand;
import MysticalComplexGame.Commands.ICommandVerbSolo;
import MysticalComplexGame.Commands.ICommandVerbWithDirection;
import MysticalComplexGame.Commands.ICommandVerbWithItem;
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
        if (commandToExecute instanceof ICommandVerbSolo)
        {
            ICommandVerbSolo command = (ICommandVerbSolo)commandToExecute;
            command.executeCommand(player);
        }
        else if (commandToExecute instanceof ICommandVerbWithDirection)
        {
            ICommandVerbWithDirection command = (ICommandVerbWithDirection)commandToExecute;
            command.executeCommand(player,directionArgument);
        }
        else
        {
            ICommandVerbWithItem command = (ICommandVerbWithItem)commandToExecute;
            command.executeCommand(player,itemArgument);
        }
    }

    public boolean exists()
    {
        return commandToExecute != null;
    }
}
