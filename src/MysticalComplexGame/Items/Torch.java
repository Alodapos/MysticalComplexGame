package MysticalComplexGame.Items;

import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;

public class Torch extends IItem implements LightEmitter
{
    private LightEmitterState burning;
    private String emitterBurning;
    private String lightSuccess;
    private String noFireSource;
    private String quenchSuccess;
    private String quenchedFailed;

    public Torch(LightEmitterState burning)
    {
        pickable = true;
        name = "torch";
        this.burning = burning;
        setDescription(burning);
        emitterBurning = "This is already burning, you can't relight it.";
        lightSuccess = "You light the " + name + " and your surroundings are shrouded in light.";
        noFireSource = "There is no fire source nearby and you lack the resources to light this.";
        quenchSuccess = "You shove the " + name + " to the ground and gray smoke fills the air around you.";
        quenchedFailed = "You cannot quench that, it is already quenched.";
    }

    @Override
    public void light(Player player)
    {
        if (burning == LightEmitterState.LIT)
            GameEngine.textOutput(emitterBurning);
        else if (player.getInventory().containsKey("flint") && player.getInventory().containsKey("steel"))
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
        this.description = "There is a " + state.getBurning() + "," + " torch attached on the wall.";
    }
}

