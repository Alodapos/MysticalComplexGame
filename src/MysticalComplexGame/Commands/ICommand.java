package MysticalComplexGame.Commands;

import MysticalComplexGame.Characters.ICharacter;
import MysticalComplexGame.Scenes.IScene;

import java.util.ArrayList;

/**
 * Created by sakis on 09-Mar-15.
 */
public interface ICommand
{
    String getName();

    String getActionFailed();

    void executeCommand(ICharacter character, String argument,  ArrayList<IScene> scenes);

}
