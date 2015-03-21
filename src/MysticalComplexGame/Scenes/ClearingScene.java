/*package MysticalComplexGame.Scenes;

import MysticalComplexGame.Items.IItem;

import java.util.ArrayList;
import java.util.Collections;

public class ClearingScene implements Scene
{

    //north,south,east,west,up,down
    private String[] nextScene= new String[4];
    private final String description;
    private final String sceneName;
    private final ArrayList<IItem> itemsList = new ArrayList<IItem>();


    public ClearingScene(String north, String south, String east, String west, IItem... items)
    {
        this.nextScene[0] = north;
        this.nextScene[1] = south;
        this.nextScene[2] = east;
        this.nextScene[3] = west;
        this.sceneName = "Clearing";
        this.description = "The bright light immediately blinds you for a while and now the gushing sound of water is louder.\n" +
                "After your vision is restored, what you see finally gives you peace after the horrors you encountered inside the cave.\n" +
                "Evidently, the noise was due to a fast-current river flowing from the east, continuing to the north and west,\n" +
                "but at some point making an abrupt turn and slipping down a steep cliff, forming a waterfall which falls several feet below.\n" +
                "To the west you see,yet again, some trees forming a sparse forest.\n" +
                "In between the forest and the riverbank is formed a dusty and rocky trail of dirt, splitting in half at some point.\n" +
                "One part is following the river's shore to the north and the other goes south through the forest.";

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