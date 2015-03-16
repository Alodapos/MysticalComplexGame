package MysticalComplexGame.Scenes;

public interface IScene
{

    String getNextScene(int nxt);

    void setNextScene(String[] nextScene);

    String getSceneName();

    void printDescription();

}
