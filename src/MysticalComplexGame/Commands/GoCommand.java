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
        if (!connector.isClosed())
        {
            player.setPreviousScene(player.getLocation());
            player.setLocation(connector.getNextScene());
            player.getLocation().printDescription();
            player.setThirstLevel(player.getThirstLevel()-1);
        }
        else GameEngine.textOutput(connector.getDescription());
    }
}
