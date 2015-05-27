package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.GatewayItem;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Player;

public class EnterCommand extends ICommandVerbItem
{
    private String itemMissing;
    private String invalidArgument;

    public EnterCommand()
    {
        key = "enter";
        invalidArgument = "This is not something that you can "+this.key+".";
        itemMissing = "You don't see such a place.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {

        if (!player.getLocation().getItems().containsValue(item))
            GameEngine.textOutput(itemMissing);
        else if (!(item instanceof GatewayItem))
            GameEngine.textOutput(invalidArgument);
        else
        {
            if(!player.canExitScene())
                player.setPreviousScene(player.getLocation());
            ((GatewayItem) item).enter(player);

        }

    }
}
