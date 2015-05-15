package MysticalComplexGame.Items;

public enum LiquidContainerState {
    FILLED("filled"),
    EMPTY("empty");

    private final String fullness;
    LiquidContainerState(String fullness)
    {
        this.fullness = fullness;
    }

    public String getFullness()
    {
        return this.fullness;
    }
}
