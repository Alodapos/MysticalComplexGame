package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class ExitCommand extends ICommandVerbAlone
{
    public ExitCommand()
    {
        key = "exit";
    }

    @Override
    public void executeCommand(Player player)
    {
        if (player.canExitScene())
        {
            player.setLocation(player.getPreviousScene());
            player.getLocation().printDescription();
        }
        else
            GameEngine.textOutput("You are not indoors.");
    }
}
