package MysticalComplexGame.Commands;

import MysticalComplexGame.Character;
import MysticalComplexGame.GameContent;
import MysticalComplexGame.Items.LiquidContainer;


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
    public void executeCommand(Character character, String argument, GameContent content)
    {
        LiquidContainer itemArgument = (LiquidContainer)character.getInventory().get(argument);
        if (argument.isEmpty()) System.out.println(missingArgument);
        else if (itemArgument == null) System.out.println(itemMissing);
        else if (!itemArgument.getTags().contains(tag)) System.out.println(invalidArgument);
        else itemArgument.drink(character);

    }
}
