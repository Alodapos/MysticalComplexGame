package MysticalComplexGame.Commands;

import MysticalComplexGame.Characters.ICharacter;
import MysticalComplexGame.Scenes.IScene;

import java.util.ArrayList;

public interface ICommand
{
    String getName();

    void executeCommand(ICharacter character, String argument,  ArrayList<IScene> scenes);

}
