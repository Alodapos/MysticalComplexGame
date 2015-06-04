package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class Brazier extends IItem implements LightEmitter
{
    private boolean burning;
    private final String lightSuccess;
    private final String noFireSource;
    private final IItem firstRequirement;
    private final IItem secondRequirement;
    private final GatewayItem toOpen;

    public Brazier(GatewayItem toOpen,IItem firstRequirement,IItem secondRequirement)
    {
        pickable = false;
        name = "brazier";
        burning = false;
        description = "A quenched brazier is located just in front of the entrance, right in the middle of the platform.";
        this.toOpen = toOpen;
        this.firstRequirement = firstRequirement;
        this.secondRequirement = secondRequirement;
        lightSuccess = "You find some tinder and mosses, light the " + name + " and your surroundings are shrouded in light.";
        noFireSource = "You lack the resources to light this.";
    }

    @Override
    public void light(Player player)
    {
        if (player.getInventory().containsValue(firstRequirement) && player.getInventory().containsValue(secondRequirement))
        {
            description = "A lit brazier is located just in front of the entrance, right in the middle of the platform.";
            this.burning = true;
            GameEngine.textOutput(lightSuccess);
            toOpen.openGateway();
        }
        else
            GameEngine.textOutput(noFireSource);
    }

    @Override
    public void quench()
    {
        GameEngine.textOutput("You flip the " + name + " and cinders spread across the ground.");
        description = "A quenched brazier is located just in front of the entrance, right in the middle of the platform.";
    }

    @Override
    public boolean isBurning()
    {
        return burning;
    }
}

