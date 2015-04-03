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

    public DrinkCommand()
    {
        name = "drink";
        missingArgument = "You have to specify what do you want to drink!";
        invalidArgument = "This is not something that i can drink from...";
        itemMissing = "You don't have something like this with you.";
    }
    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void executeCommand(Character character, String argument, GameContent content)
    {

        if (argument.isEmpty()) System.out.println(missingArgument);
        else if (character.getInventory().get(argument) == null) System.out.println(itemMissing);
        else if (!(character.getInventory().get(argument) instanceof LiquidContainer)) System.out.println(invalidArgument);
        else
        {
            LiquidContainer itemArgument = (LiquidContainer)character.getInventory().get(argument);
            itemArgument.drink(character);
        }
    }
}
