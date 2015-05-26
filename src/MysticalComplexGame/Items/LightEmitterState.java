package MysticalComplexGame.Items;

public enum LightEmitterState
{
    LIT("lit"),
    QUENCHED("quenched"),
    POSTED("post"),
    ATTACHED("wall");

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
