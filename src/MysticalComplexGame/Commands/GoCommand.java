package MysticalComplexGame.Commands;

import MysticalComplexGame.*;
import MysticalComplexGame.Connections.ConnectionPassive;

public class GoCommand extends ICommandVerbDirection
{
    public GoCommand()
    {
        key = "go";
    }

    @Override
    public void executeCommand(Direction direction)
    {
        if ((!Player.getLocation().getConnection(direction).isOpen()) && (Player.getLocation().getConnection(direction) instanceof ConnectionPassive))
        {
            Player.getLocation().getConnection(direction).openConnection(null);
            if (Player.getLocation().getConnection(direction).isOpen()) movePlayer(Player.getLocation().getConnection(direction).getNextScene());
            else GameEngine.textOutput(Player.getLocation().getConnection(direction).getDescription());
        }
        else if (!Player.getLocation().getConnection(direction).isOpen()) GameEngine.textOutput(Player.getLocation().getConnection(direction).getDescription());
        else movePlayer(Player.getLocation().getConnection(direction).getNextScene());
    }
    private void movePlayer(Scene scene)
    {
        Player.setLocation(scene);
        Player.getLocation().printDescription();
        Player.setThirstLevel(Player.getThirstLevel()-1);
    }
}
