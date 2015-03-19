package MysticalComplexGame.Scenes;

import MysticalComplexGame.Items.IItem;

import java.util.ArrayList;

public class CampsiteScene implements IScene
{

    //north,south,east,west,up,down
    private String[] nextScene= new String[4];
    private String description;
    private String sceneName;
    private ArrayList<IItem> itemsList = new ArrayList<IItem>();


    public CampsiteScene(String north, String south, String east, String west,IItem... items)
    {
        this.nextScene[0] = north;
        this.nextScene[1] = south;
        this.nextScene[2] = east;
        this.nextScene[3] = west;
        this.sceneName = "Campsite";
        this.description = "You grab your stuff and begin traveling to the NORTH,\n" +
                "while the night offers you the perfect cover from prying eyes.\n" +
                "You plan to arrive at Serenoth within 20 days,\n" +
                "unless something unexpected happens.\n" +
                "Are you ready to leave the camp?";
        for (IItem item:items) itemsList.add(item);
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
    public ArrayList<IItem> getItemsList()
    {
        return this.itemsList;
    }

}

