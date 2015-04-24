package MysticalComplexGame.Commands;

import MysticalComplexGame.Direction;

public abstract class ICommandVerbDirection implements ICommand
{
    public abstract void executeCommand(Direction direction);

    protected String key;

    @Override
    public String getKey()
    {
        return key;
    }
}
