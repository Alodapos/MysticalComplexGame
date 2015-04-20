package MysticalComplexGame.Connections;

import MysticalComplexGame.Player;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Scene;
import MysticalComplexGame.State;

public interface IConnector
{

    Scene getNextScene();

    String getDescription();

    void changeState(State state);

    boolean isOpen();

    void openConnection(IItem key);
}
