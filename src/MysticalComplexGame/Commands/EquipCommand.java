package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.WeaponItem;
import MysticalComplexGame.Player;

public class EquipCommand extends ICommandVerbWithItem
{
    private final String itemMissing;
    private final String invalidArgument;

    public EquipCommand()
    {
        key = "equip";
        invalidArgument = "This is not something that you can " + key + ".";
        itemMissing = "You don't have such a thing.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {
        if (!player.getInventory().containsValue(item))
            GameEngine.textOutput(itemMissing);
        else if (!(item instanceof WeaponItem))
            GameEngine.textOutput(invalidArgument);
        else
            ((WeaponItem)item).equip(player);
    }
}
