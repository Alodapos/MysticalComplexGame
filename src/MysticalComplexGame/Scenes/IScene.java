package MysticalComplexGame.Scenes;

/**
 * Created by sakis on 08-Mar-15.
 */
public interface IScene
{

    void setSceneId(int id);

    int getSceneId();

    int[] getNextScene();

    int getNextScene(int nxt);

    void setNextScene(int[] nextScene);

    String getDescription();

    void changeScene(int nextSceneId);

    String getSceneName();


}
