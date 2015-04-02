package MysticalComplexGame.Commands;

import MysticalComplexGame.Character;
import MysticalComplexGame.GameContent;
import MysticalComplexGame.Items.LiquidContainer;


public class FillCommand implements ICommand
{

    private String name;
    private String missingArgument;
    private String itemMissing;
    private String invalidArgument;

    public FillCommand()
    {
        name = "fill";
        missingArgument = "You have to specify what do you want to fill!";
        invalidArgument = "This is not something that i can fill";
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
            itemArgument.fill(character);
        }
    }
}
