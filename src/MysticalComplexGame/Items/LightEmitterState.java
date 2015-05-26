package MysticalComplexGame.Items;

public enum LightEmitterState
{
    LIT("lit"),
    QUENCHED("quenched");

    private final String state;


    LightEmitterState(String state)
    {
        this.state = state;
    }

    public String getBurning()
    {
        return this.state;
    }
}
