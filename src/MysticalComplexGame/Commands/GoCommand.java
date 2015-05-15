package MysticalComplexGame.Commands;

import MysticalComplexGame.*;

public class GoCommand extends ICommandVerbDirection
{
    public GoCommand()
    {
        key = "go";
    }

    @Override
    public void executeCommand(Player player,Direction direction)
    {
        Connector connector = player.getLocation().getConnection(direction);
        if (connector.getState() == ConnectionState.PASSIVE && player.getInventory().containsValue(connector.getKey()))
            connector.changeState(ConnectionState.OPEN);
        if (connector.isOpen())
        {
            player.setLocation(connector.getNextScene());
            player.getLocation().printDescription();
            player.setThirstLevel(player.getThirstLevel()-1);
        }
        else GameEngine.textOutput(connector.getDescription());
    }
}
