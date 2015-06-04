package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class ExitCommand extends ICommandVerbSolo
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
            player.setCanExitScene(false);
        }
        else
            GameEngine.textOutput("You are not indoors.");
    }
}
