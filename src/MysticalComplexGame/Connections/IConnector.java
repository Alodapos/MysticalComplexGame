package MysticalComplexGame.Connections;

import MysticalComplexGame.Character;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Scene;
import MysticalComplexGame.State;

public interface IConnector
{

    Scene getNextScene();

    String getDescription();

    State getState();

    void changeState(State state);

    boolean isOpen();

    void openConnection(Character character, IItem key);
}
