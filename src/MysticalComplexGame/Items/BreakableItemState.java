package MysticalComplexGame.Items;

public enum BreakableItemState
{
    BROKEN("broken"),
    NOTBROKEN("not broken");

    private final String state;

    BreakableItemState(String state)
    {
        this.state = state;
    }

    public String getBroken()
    {
        return this.state;
    }
}
