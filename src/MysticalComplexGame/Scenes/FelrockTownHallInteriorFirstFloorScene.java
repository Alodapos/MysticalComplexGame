/*package MysticalComplexGame.Scenes;

import MysticalComplexGame.Items.IItem;

import java.util.ArrayList;
import java.util.Collections;

public class FelrockTownHallInteriorFirstFloorScene implements Scene
{

    //north,south,east,west,up,down
    private String[] nextScene= new String[4];
    private final String description;
    private final String sceneName;
    private final ArrayList<IItem> itemsList = new ArrayList<IItem>();


    public FelrockTownHallInteriorFirstFloorScene(String north, String south, String east, String west, IItem... items)
    {
        this.nextScene[0] = north;
        this.nextScene[1] = south;
        this.nextScene[2] = east;
        this.nextScene[3] = west;
        this.sceneName = "Felrock Village - Town Hall: Interior - First Floor";
        this.description = "descr";
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