package MysticalComplexGame.Commands;

import MysticalComplexGame.Direction;
import MysticalComplexGame.Player;

public abstract class ICommandVerbWithDirection implements ICommand
{
    public abstract void executeCommand(Player player,Direction direction);

    protected String key;

    @Override
    public String getKey()
    {
        return key;
    }
}
