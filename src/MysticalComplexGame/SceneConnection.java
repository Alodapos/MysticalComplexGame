package MysticalComplexGame;

public class SceneConnection
{
    private State state;
    private String description;
    private Scene nextScene;

    public SceneConnection(State state, String description, Scene nextScene)
    {
        this.state = state;
        this.description = description;
        this.nextScene = nextScene;
    }

    public Scene getNextScene() {
        return nextScene;
    }

    public String getDescription() {
        return description;
    }

    public State getState() {
        return state;
    }
    public void changeState(State state)
    {
        this.state = state;
    }
    public boolean isOpen()
    {
        if (state == State.OPEN) return true;
        else return false;
    }
}
