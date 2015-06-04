package MysticalComplexGame.Commands;

import MysticalComplexGame.Connector;
import MysticalComplexGame.Direction;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class GazeCommand extends ICommandVerbWithDirection
{
    public GazeCommand()
    {
        key = "gaze";
    }

    @Override
    public void executeCommand(Player player, Direction direction)
    {
        Connector connection = player.getLocation().getConnection(direction);
        if (connection.getNextScene() != null)
            GameEngine.textOutput("You see the "+connection.getNextScene().getName());
        else
            GameEngine.textOutput(connection.getDescription());
    }
}
