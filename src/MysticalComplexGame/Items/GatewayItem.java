package MysticalComplexGame.Items;

import MysticalComplexGame.ConnectionState;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;
import MysticalComplexGame.Scene;

public class GatewayItem extends IItem
{
    private Scene targetScene;
    private ConnectionState lockState;
    private String passageClosedText;
    private String openText;
    private String newDescription;

    public GatewayItem(String name,String description,Scene targetScene)
    {
        this.targetScene = targetScene;
        lockState = ConnectionState.OPEN;
        openText = "";
        passageClosedText = "";
        this.name = name;
        this.description = description;
        pickable = false;
    }

    public GatewayItem(String name, String description,Scene targetScene,String passageClosedText,String openText,String newDescription)
    {
        this.targetScene = targetScene;
        lockState = ConnectionState.CLOSED;
        this.openText = openText;
        this.passageClosedText = passageClosedText;
        this.name = name;
        this.description = description;
        this.newDescription = newDescription;
        pickable = false;
    }

    public void enter(Player player)
    {
        if (lockState == ConnectionState.CLOSED)
            GameEngine.textOutput(passageClosedText);
        else
        {
            player.setLocation(targetScene);
            player.getLocation().printDescription();
            player.setCanExitScene(true);
        }
    }

    public void exit(Player player)
    {
        player.setLocation(player.getPreviousScene());
        player.getLocation().printDescription();
    }

    public void openGateway()
    {
        if (lockState == ConnectionState.CLOSED)
        {
            lockState = ConnectionState.OPEN;
            GameEngine.textOutput(openText);
            this.description = newDescription;
        }
    }
}
