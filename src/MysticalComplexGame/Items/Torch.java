package MysticalComplexGame.Items;

import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;

public class Torch extends IItem implements LightEmitter
{
    private LightEmitterState burning;
    private String lightSuccess;
    private String noFireSource;
    private String quenchSuccess;
    private String quenchedFailed;
    private IItem firstRequirement;
    private IItem secondRequirement;
    private GatewayItem toOpen;

    public Torch(GatewayItem toOpen,LightEmitterState state,IItem firstRequirement,IItem secondRequirement)
    {
        pickable = true;
        name = "torch";
        description = "There is a " + state.getBurning() + "," + " torch attached on the wall.";
        this.toOpen = toOpen;
        this.firstRequirement = firstRequirement;
        this.secondRequirement = secondRequirement;
        lightSuccess = "You light the " + name + " and your surroundings are shrouded in light.";
        noFireSource = "There is no fire source nearby and you lack the resources to light this.";
        quenchSuccess = "You shove the " + name + " to the ground and gray smoke fills the air around you.";
        quenchedFailed = "You cannot quench that, it is already quenched.";
    }

    @Override
    public void light(Player player)
    {
        if (player.getInventory().containsValue(firstRequirement) && player.getInventory().containsValue(secondRequirement))
        {
            this.burning = LightEmitterState.LIT;
            GameEngine.textOutput(lightSuccess);
            toOpen.openGateway();
        }
        else
            GameEngine.textOutput(noFireSource);
    }

    @Override
    public void quench()
    {
        if (burning == LightEmitterState.QUENCHED)
            GameEngine.textOutput(quenchedFailed);
        else
        {
            this.burning = LightEmitterState.QUENCHED;
            GameEngine.textOutput(quenchSuccess);
        }
    }

    @Override
    public boolean isBurning()
    {
        return (burning == LightEmitterState.LIT);
    }

    @Override
    public void pick(Player player)
    {
        super.pick(player);
        toOpen.openGateway();
    }
}

