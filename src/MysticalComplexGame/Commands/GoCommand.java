package MysticalComplexGame.Commands;

import MysticalComplexGame.Connector;
import MysticalComplexGame.Direction;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class GoCommand extends ICommandVerbWithDirection
{
    public GoCommand()
    {
        key = "go";
    }

    @Override
    public void executeCommand(Player player, Direction direction)
    {
        Connector connector = player.getLocation().getConnection(direction);
        if (!connector.isClosed())
        {
            player.setPreviousScene(player.getLocation());
            player.setLocation(connector.getNextScene());
            player.getLocation().printDescription();
            player.setThirstLevel(player.getThirstLevel()-1);
        }
        else
            GameEngine.textOutput(connector.getDescription());
    }
}
