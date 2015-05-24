package MysticalComplexGame.Items;

public enum LightEmitterState
{
    LIT("lit"),
    QUENCHED("quenched");

    private final String burning;


    LightEmitterState(String burning)
    {
        this.burning = burning;
    }

    public String getBurning()
    {
        return this.burning;
    }
}
