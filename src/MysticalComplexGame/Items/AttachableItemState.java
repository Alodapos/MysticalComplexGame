package MysticalComplexGame.Items;

public enum AttachableItemState
{
    ATTACHED("attached"),
    DETACHED("detached");

    private final String state;

    AttachableItemState(String state)
    {
        this.state = state;
    }

    public String getAttached()
    {
        return this.state;
    }
}
