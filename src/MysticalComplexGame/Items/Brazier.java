package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class Brazier extends IItem implements LightEmitter
{
    private LightEmitterState burning;
    private String lightSuccess;
    private String noFireSource;
    private String quenchSuccess;
    private String quenchedFailed;
    private IItem firstRequirement;
    private IItem secondRequirement;
    private GatewayItem toOpen;

    public Brazier(GatewayItem toOpen,LightEmitterState state,IItem firstRequirement,IItem secondRequirement)
    {
        pickable = false;
        name = "brazier";
        description = "A " + state.getBurning() + " brazier is located just in front of the entrance, right in the middle of the platform.";
        this.toOpen = toOpen;
        this.firstRequirement = firstRequirement;
        this.secondRequirement = secondRequirement;
        lightSuccess = "You find some tinder and mosses, light the " + name + " and your surroundings are shrouded in light.";
        noFireSource = "You lack the resources to light this.";
        quenchSuccess = "You flip the " + name + " and cinders spread across the ground.";
        quenchedFailed = "You cannot quench that, it is already quenched.";
    }

    @Override
    public void light(Player player)
    {
        if (player.getInventory().containsValue(firstRequirement) && player.getInventory().containsValue(secondRequirement))
        {
            description = "A lit brazier is located just in front of the entrance, right in the middle of the platform.";
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
}

