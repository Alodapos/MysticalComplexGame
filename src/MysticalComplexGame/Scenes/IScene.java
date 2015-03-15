package MysticalComplexGame.Scenes;

/**
 * Created by sakis on 08-Mar-15.
 */
public interface IScene
{

    String getNextScene(int nxt);

    void setNextScene(String[] nextScene);

    String getSceneName();

    void printDescription();

}
