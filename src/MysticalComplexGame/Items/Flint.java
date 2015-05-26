package MysticalComplexGame.Items;

public class Flint extends IItem implements KeyItem
{
    public Flint()
    {
        name = "flint";
        description = "A flint stone sits on the same barrel.";
        inventoryDescription = "A flint stone.";
        pickable = true;
    }
}
