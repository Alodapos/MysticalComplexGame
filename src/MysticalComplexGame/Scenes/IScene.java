package MysticalComplexGame.Scenes;

import MysticalComplexGame.Items.IItem;

import java.util.ArrayList;

public interface IScene
{

    String getNextScene(int nxt);

    void setNextScene(String[] nextScene);

    String getSceneName();

    void printDescription();

    void addItem(IItem item);

    void removeItem(int itemIndex);

    ArrayList<IItem> getItemsList();
}
