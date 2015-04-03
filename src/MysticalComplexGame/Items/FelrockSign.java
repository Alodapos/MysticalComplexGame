package MysticalComplexGame.Items;

import MysticalComplexGame.Character;
import MysticalComplexGame.Connections.ConnectionActive;
import MysticalComplexGame.Connections.IConnector;

import java.util.List;


public class FelrockSign implements IItem,ReadableItem
{
    private String name;
    private String description;
    private String text;

    public FelrockSign()
    {
        name = "sign";
        description = "There is a sign by the end of the path.";
        text = "Welcome to Felrock Village!";
    }
    @Override
    public String getInventoryDescription() {
        return null;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<String> getTags()
    {
        return null;
    }

    @Override
    public void read(Character character)
    {
        System.out.println(text);
        for (IConnector connection : character.getLocation().getConnections())
            if (connection instanceof ConnectionActive)
                if (!connection.isOpen()) connection.openConnection(character,this);
    }
}
