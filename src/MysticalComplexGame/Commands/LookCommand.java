package MysticalComplexGame.Commands;

import MysticalComplexGame.Player;

public class LookCommand extends ICommandVerbSolo
{
    public LookCommand()
    {
        key = "look";
    }

    @Override
    public void executeCommand(Player player)
    {
        player.getLocation().printDescription();
    }
}
