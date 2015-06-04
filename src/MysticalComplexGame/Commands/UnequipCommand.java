package MysticalComplexGame.Commands;

import MysticalComplexGame.Player;

public class UnequipCommand extends ICommandVerbSolo
{
    public UnequipCommand()
    {
        key = "unequip";
    }

    @Override
    public void executeCommand(Player player)
    {
        player.getEquippedWeapon().unequip(player);
    }
}
