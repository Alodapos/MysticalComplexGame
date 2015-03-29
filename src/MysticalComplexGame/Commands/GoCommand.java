package MysticalComplexGame.Commands;

import MysticalComplexGame.Character;
import MysticalComplexGame.Direction;
import MysticalComplexGame.GameContent;

public class GoCommand implements ICommand
{
    private String missingArgument;
    private String invalidArgument;
    private String name;

    public GoCommand()
    {
        name = "go";
        missingArgument = "You'll have to say which compass direction to go in.";
        invalidArgument = "You can't see any such place.";
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void executeCommand(Character character, String argument, GameContent content)
    {
        Direction desiredDirection = Direction.fromString(argument);
        if (argument.matches("")) System.out.println(missingArgument);
        else if (desiredDirection == null) System.out.println(invalidArgument);
        else if (!character.getLocation().getConnection(desiredDirection).isOpen()) System.out.println(character.getLocation().getConnection(desiredDirection));
        else
        {
            character.setLocation(character.getLocation().getConnection(desiredDirection).getNextScene());
            character.getLocation().printDescription();
            character.setThirstLevel(character.getThirstLevel()-1);
        }
    }
}
