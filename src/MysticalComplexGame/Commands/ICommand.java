package MysticalComplexGame.Commands;

import MysticalComplexGame.Character;
import MysticalComplexGame.Scene;
import java.util.Map;

public interface ICommand
{
    String getName();

    void executeCommand(Character character, String argument,  Map<String, Scene> scenes);

}
