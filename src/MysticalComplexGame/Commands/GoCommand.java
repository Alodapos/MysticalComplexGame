package MysticalComplexGame.Commands;

import MysticalComplexGame.Character;
import MysticalComplexGame.Connections.ConnectionPassive;
import MysticalComplexGame.Direction;
import MysticalComplexGame.GameContent;
import MysticalComplexGame.Scene;

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
        else if ((!character.getLocation().getConnection(desiredDirection).isOpen()) && (character.getLocation().getConnection(desiredDirection) instanceof ConnectionPassive))
        {
            character.getLocation().getConnection(desiredDirection).openConnection(character,null);
            if (character.getLocation().getConnection(desiredDirection).isOpen()) moveCharacter(character,character.getLocation().getConnection(desiredDirection).getNextScene());
            else System.out.println( character.getLocation().getConnection(desiredDirection).getDescription());
        }
        else if (!character.getLocation().getConnection(desiredDirection).isOpen()) System.out.println( character.getLocation().getConnection(desiredDirection).getDescription());
        else moveCharacter(character,character.getLocation().getConnection(desiredDirection).getNextScene());
    }
    private void moveCharacter(Character character, Scene scene)
    {
        character.setLocation(scene);
        character.getLocation().printDescription();
        character.setThirstLevel(character.getThirstLevel()-1);
    }
}
