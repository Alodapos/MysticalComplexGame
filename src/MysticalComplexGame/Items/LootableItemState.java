package MysticalComplexGame.Items;

public enum LootableItemState
{
    LOOTED("looted"),
    NOTLOOTED("not looted"),
    EMPTY("empty");

    private final String state;

    LootableItemState(String state)
    {
        this.state = state;
    }

    public String getLooted()
    {
        return this.state;
    }
}
