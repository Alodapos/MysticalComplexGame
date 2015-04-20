package MysticalComplexGame.Commands;

public abstract class ICommandVerbAlone implements ICommand
{
    public abstract void executeCommand();
    protected String key;

    @Override
    public String getKey()
    {
        return key;
    }
}
