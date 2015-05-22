package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.AttackableItem;
import MysticalComplexGame.Player;

import java.util.ArrayList;
import java.util.List;


public class AttackCommand extends ICommandVerbItem
{
    private String itemMissing;
    private String invalidArgument;

    public AttackCommand()
    {
        key = "attack";
        invalidArgument = "This is not something that you can attack...";
        itemMissing = "You don't see or have such a thing.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {

        List<IItem> localItems = new ArrayList<IItem>();
        localItems.addAll(player.getInventory().values());
        localItems.addAll(player.getLocation().getItems().values());

        if (!localItems.contains(item)) GameEngine.textOutput(itemMissing);
        else if (!(item instanceof AttackableItem)) GameEngine.textOutput(invalidArgument);
        else
        {
            AttackableItem toAttack = (AttackableItem)item;
            toAttack.attack(player);
        }
    }
}
