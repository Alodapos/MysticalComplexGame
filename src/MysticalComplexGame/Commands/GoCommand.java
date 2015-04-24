package MysticalComplexGame.Commands;

import MysticalComplexGame.*;

public class GoCommand extends ICommandVerbDirection
{
    public GoCommand()
    {
        key = "go";
    }

    @Override
    public void executeCommand(Direction direction)
    {
        Connector connector = Player.getLocation().getConnection(direction);
        if (connector.getState() == ConnectionState.PASSIVE && Player.getInventory().containsValue(connector.getKey()))
            connector.changeState(ConnectionState.OPEN);
        if (connector.isOpen()) movePlayer(connector.getNextScene());
        else GameEngine.textOutput(connector.getDescription());
    }
    private void movePlayer(Scene scene)
    {
        Player.setLocation(scene);
        Player.getLocation().printDescription();
        Player.setThirstLevel(Player.getThirstLevel()-1);
    }
}
