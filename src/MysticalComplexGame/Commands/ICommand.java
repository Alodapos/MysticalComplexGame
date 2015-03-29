package MysticalComplexGame.Commands;

import MysticalComplexGame.Character;
import MysticalComplexGame.GameContent;

public interface ICommand
{
    String getName();

    void executeCommand(Character character, String argument, GameContent content);
}
