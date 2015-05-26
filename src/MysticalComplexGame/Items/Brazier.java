package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class Brazier extends IItem implements LightEmitter
{
    private LightEmitterState burning;
    private String emitterBurning;
    private String lightSuccess;
    private String noFireSource;
    private String quenchSuccess;
    private String quenchedFailed;

    public Brazier(LightEmitterState burning)
    {
        pickable = true;
        name = "brazier";
        this.burning = burning;
        setDescription(burning);
        emitterBurning = "This is already burning, you can't relight it.";
        lightSuccess = "You find some firelighters, light the " + name + " and your surroundings are shrouded in light.\n\n" +
                "A loud sound, some crackling and clinging and finally the temple's entrance is unlocked!";
        noFireSource = "There is no fire source nearby and you lack the resources to light this.";
        quenchSuccess = "You flip the " + name + " to the ground and cinders spread across the ground.";
        quenchedFailed = "You cannot quench that, it is already quenched.";
    }

    @Override
    public void light(Player player)
    {
        if (burning == LightEmitterState.LIT)
            GameEngine.textOutput(emitterBurning);
        else if (player.getInventory().containsKey("flint") && player.getInventory().containsKey("steel") || player.getInventory().containsValue(LightEmitterState.LIT))
        {
            this.burning = LightEmitterState.LIT;
            GameEngine.textOutput(lightSuccess);
            setDescription(burning);
        }
        else GameEngine.textOutput(noFireSource);
    }

    @Override
    public void quench()
    {
        if (burning == LightEmitterState.QUENCHED) GameEngine.textOutput(quenchedFailed);
        else
        {
            this.burning = LightEmitterState.QUENCHED;
            setDescription(burning);
            GameEngine.textOutput(quenchSuccess);
        }
    }

    private void setDescription(LightEmitterState state)
    {
        this.description = "There is a " + state.getBurning() + "," + " brazier just in front of the temple's entrance, in the middle of the floor.";
    }
}

