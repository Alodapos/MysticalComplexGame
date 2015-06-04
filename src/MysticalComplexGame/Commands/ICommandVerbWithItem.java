package MysticalComplexGame.Commands;

import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Player;

public abstract class ICommandVerbWithItem implements ICommand
{
    public abstract void executeCommand(Player player,IItem item);

    protected String key;

    @Override
    public String getKey()
    {
        return key;
    }
}
