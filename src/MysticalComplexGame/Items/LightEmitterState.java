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

enum LightEmitterState2
{
    CAMPSITE("a steady post.");

    private final String spot;

    LightEmitterState2(String spot)
    {
        this.spot = spot;
    }

    public String getSpot()
    {
        return this.spot;
    }
}
