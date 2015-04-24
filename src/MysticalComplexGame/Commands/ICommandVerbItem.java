package MysticalComplexGame.Commands;

import MysticalComplexGame.Items.IItem;

public abstract class ICommandVerbItem implements ICommand
{
    public abstract void executeCommand(IItem item);

    protected String key;

    @Override
    public String getKey()
    {
        return key;
    }
}
