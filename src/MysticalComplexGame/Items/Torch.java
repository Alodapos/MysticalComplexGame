package MysticalComplexGame.Items;

import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;

public class Torch extends IItem implements LightEmitter,KeyItem
{
    private final GatewayItem toOpen;

    public Torch(GatewayItem toOpen)
    {
        pickable = true;
        name = "torch";
        description = "There is a lit torch attached on the wall.";
        inventoryDescription = "You hold a lit torch in your left hand.";
        this.toOpen = toOpen;
    }

    @Override
    public void light(Player player)
    {}

    @Override
    public void quench()
    {
        GameEngine.textOutput("If you quench this torch you won't be able to see anything down there.");
    }

    @Override
    public boolean isBurning()
    {
        return true;
    }

    @Override
    public void pick(Player player)
    {
        super.pick(player);
        toOpen.openGateway();
    }
}

