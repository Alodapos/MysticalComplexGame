package MysticalComplexGame.Items;

import MysticalComplexGame.Player;

public class GoldenArtifact extends IItem implements KeyItem, AttachableItem
{
    private final GatewayItem toOpen;

    public GoldenArtifact(GatewayItem toOpen)
    {
        pickable = true;
        name = "golden artifact";
        description = "A strange, golden artifact, hidden in the vase a moment ago, now lies on the altar.\n" +
                "It has a very particular shape that reminds you of a specific point of the engraves you saw earlier on the flat wall.";
        inventoryDescription = "A strange, golden artifact.";
        this.toOpen = toOpen;
    }

    @Override
    public void attach(Player player)
    {
        player.removeFromInventory(this);
        toOpen.openGateway();
    }
}
