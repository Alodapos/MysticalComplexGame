package MysticalComplexGame.Commands;

import MysticalComplexGame.Character;
import MysticalComplexGame.GameContent;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.LiquidContainer;
import MysticalComplexGame.Items.ReadableItem;

import java.util.HashMap;
import java.util.Map;


public class ReadCommand implements ICommand
{

    private String name;
    private String missingArgument;
    private String itemMissing;
    private String invalidArgument;

    public ReadCommand()
    {
        name = "read";
        missingArgument = "You have to specify what do you want to read!";
        invalidArgument = "This is not something that you can read...";
        itemMissing = "You don't see or have such a thing.";
    }
    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void executeCommand(Character character, String argument, GameContent content)
    {

        Map<String,IItem> allItems = new HashMap<String,IItem>();
        allItems.putAll(character.getInventory());
        allItems.putAll(character.getLocation().getItems());
        if (argument.isEmpty()) System.out.println(missingArgument);
        else if (allItems.get(argument) == null) System.out.println(itemMissing);
        else if (!(allItems.get(argument) instanceof ReadableItem)) System.out.println(invalidArgument);
        else
        {
            ReadableItem itemArgument = (ReadableItem)allItems.get(argument);
            itemArgument.read(character);
        }
    }
}
