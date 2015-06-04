package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.AttackableItem;
import MysticalComplexGame.Player;

public class AttackCommand extends ICommandVerbWithItem
{
    private final String itemMissing;
    private final String invalidArgument;

    public AttackCommand()
    {
        key = "attack";
        invalidArgument = "This is not something that you can attack.";
        itemMissing = "You don't see such a thing.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {

        if (!player.getLocation().getItems().containsValue(item))
            GameEngine.textOutput(itemMissing);
        else if (!(item instanceof AttackableItem))
            GameEngine.textOutput(invalidArgument);
        else
        {
            AttackableItem toAttack = (AttackableItem)item;
            if(!toAttack.isAlive())
                GameEngine.textOutput("The "+item.getName()+" is already dead!");
            else if(player.getEquippedWeapon() == null)
                GameEngine.textOutput("You need a weapon equipped to attack!");
            else
                toAttack.attack(player);
        }
    }
}
