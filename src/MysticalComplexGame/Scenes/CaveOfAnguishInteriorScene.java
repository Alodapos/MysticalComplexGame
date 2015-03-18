package MysticalComplexGame.Scenes;

import MysticalComplexGame.Items.IItem;

import java.util.ArrayList;

public class CaveOfAnguishInteriorScene implements IScene
{

    //north,south,east,west
    private String[] nextScene= new String[4];
    private String description;
    private String sceneName;
    private ArrayList<IItem> itemsList = new ArrayList<IItem>();


    public CaveOfAnguishInteriorScene(String north, String south, String east, String west, IItem... items)
    {
        this.nextScene[0] = north;
        this.nextScene[1] = south;
        this.nextScene[2] = east;
        this.nextScene[3] = west;
        this.sceneName = "Cave of Anguish: Interior";
        this.description = "descr";

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
        return this.sceneName;
    }

    @Override
    public void printDescription()
    {
        System.out.println("\t\t\t\t\""+this.sceneName+"\""+"\n");
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

