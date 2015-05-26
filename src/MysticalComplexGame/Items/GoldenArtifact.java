package MysticalComplexGame.Items;

public class GoldenArtifact extends IItem implements KeyItem
{
    public GoldenArtifact()
    {
        name = "golden artifact";
        description = "A strange, golden artifact, hidden in the vase, now lies on the altar.\n" +
                "It has a very particular shape that reminds you of a specific point of the engraves you saw earlier on the flat wall.";
        inventoryDescription = "A strange, golden artifact.";
        pickable = true;
    }
}
