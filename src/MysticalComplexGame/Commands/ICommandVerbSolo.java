package MysticalComplexGame.Commands;

import MysticalComplexGame.Player;

public abstract class ICommandVerbSolo implements ICommand
{
    public abstract void executeCommand(Player player);
    protected String key;

    @Override
    public String getKey()
    {
        return key;
    }
}
