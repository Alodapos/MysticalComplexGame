package MysticalComplexGame.Commands;

import MysticalComplexGame.Character;
import MysticalComplexGame.Items.LiquidContainer;
import MysticalComplexGame.Scene;
import java.util.Map;

public class DrinkCommand implements ICommand
{

    private String name;
    private String missingArgument;
    private String itemMissing;
    private String invalidArgument;
    private String tag;

    public DrinkCommand()
    {
        name = "drink";
        missingArgument = "You have to specify what do you want to drink!";
        invalidArgument = "This is not something that i can drink from...idiot...";
        itemMissing = "You don't have something like this with you.";
        tag = "drink";
    }
    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void executeCommand(Character character, String argument, Map<String, Scene> scenes)
    {
        if (argument.isEmpty()) System.out.println(missingArgument);
        else if (character.getInventory().get(argument)== null) System.out.println(itemMissing);
        else if (!character.getInventory().get(argument).getTags().contains(tag)) System.out.println(invalidArgument);
        else
        {
            LiquidContainer item = (LiquidContainer)character.getInventory().get(argument);
            item.drink(character);
        }
    }
}
