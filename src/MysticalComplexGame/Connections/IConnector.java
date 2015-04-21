package MysticalComplexGame.Connections;

import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Scene;

public interface IConnector
{

    Scene getNextScene();

    String getDescription();

    void changeState(State state);

    boolean isOpen();

    void openConnection(IItem key);
}
