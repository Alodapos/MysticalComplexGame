/*package MysticalComplexGame.Scenes;

import MysticalComplexGame.Items.IItem;

import java.util.ArrayList;
import java.util.Collections;

public class FelrockTownHallInteriorGroundFloorScene implements Scene
{

    //north,south,east,west,up,down
    private String[] nextScene= new String[4];
    private final String description;
    private final String sceneName;
    private final ArrayList<IItem> itemsList = new ArrayList<IItem>();


    public FelrockTownHallInteriorGroundFloorScene(String north, String south, String east, String west, IItem... items)
    {
        this.nextScene[0] = north;
        this.nextScene[1] = south;
        this.nextScene[2] = east;
        this.nextScene[3] = west;
        this.sceneName = "Felrock Village - Town Hall: Interior - Ground Floor";
        this.description = "Surprisingly, the door requires a bit above than average force to open,\n" +
                "but with a tight grip and a strong push you manage to shove it aside.\n" +
                "Before you spreads a long hallway, ending up in a grand lobby. \n" +
                "On your left, a staircase extends all the way up, to the top of the Town Hall. \n" +
                "As far as you can see there are three floors, including the ground floor. \n" +
                "On your right and left there are several rooms, probably offices and storerooms. \n" +
                "While you examine your surroundings and trying to see what's on the top floors, a low voice is heard in the distance, \n" +
                "but the only words you can make out are: \"cave\" and \"corruption\". \n" +
                "At once, a different voice replies and you can only hear the words: \"dying\" and \"leave\". \n" +
                "The conversation continues...";
        Collections.addAll(itemsList, items);

    }


    @Override
    public String getNextScene(int nxt)
    {
        return nextScene[nxt];
    }

    @Override
    public void setNextScene(String[] nextScene)
    {
        this.nextScene = nextScene;
    }

    @Override
    public String getSceneName()
    {
        return sceneName;
    }

    @Override
    public void printDescription()
    {
        System.out.println("\t\t\t\t\t\""+this.sceneName+"\""+"\n");
        System.out.println(this.description);
        for (IItem item : itemsList)
        {
            System.out.println(item.getDescription());
        }

    }

    @Override
    public void addItem(IItem item)
    {
        this.itemsList.add(item);
    }
    @Override
    public void removeItem(int itemIndex)
    {
        this.itemsList.remove(itemIndex);
        itemsList.trimToSize();
    }
    @Override
    public ArrayList<IItem> getItems()
    {
        return this.itemsList;
    }
}
/*/
