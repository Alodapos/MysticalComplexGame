package MysticalComplexGame.Commands;

import MysticalComplexGame.Connector;
import MysticalComplexGame.Direction;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class GazeCommand extends ICommandVerbDirection
{
      public GazeCommand()
    {
        key = "gaze";
    }

    @Override
    public void executeCommand(Direction direction)
    {
        Connector connector = Player.getLocation().getConnection(direction);
        if (connector.getNextScene() != null) GameEngine.textOutput("You can see the "+connector.getNextScene().getName());
        else GameEngine.textOutput(connector.getDescription());
    }
}
