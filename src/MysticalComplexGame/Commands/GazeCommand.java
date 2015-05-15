package MysticalComplexGame.Commands;

import MysticalComplexGame.*;

public class GazeCommand extends ICommandVerbDirection
{
    public GazeCommand()
    {
        key = "gaze";
    }

    @Override
    public void executeCommand(Player player,Direction direction)
    {
        Connector connection = player.getLocation().getConnection(direction);
        if (connection.getNextScene() != null) GameEngine.textOutput("You see the "+connection.getNextScene().getName());
        else GameEngine.textOutput(connection.getDescription());
    }
}
