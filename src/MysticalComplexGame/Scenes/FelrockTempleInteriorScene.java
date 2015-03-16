package MysticalComplexGame.Scenes;

import MysticalComplexGame.Items.IItem;

import java.util.ArrayList;

public class FelrockTempleInteriorScene implements IScene
{

    //north,south,east,west,up,down
    private String[] nextScene= new String[4];
    private String description;
    private String sceneName;
    private ArrayList<IItem> itemsList = new ArrayList<IItem>();


    public FelrockTempleInteriorScene(String north, String south, String east, String west, IItem... items)
    {
        this.nextScene[0] = north;
        this.nextScene[1] = south;
        this.nextScene[2] = east;
        this.nextScene[3] = west;
        //Scene name in caps please
        this.sceneName = "Felrock Village - Temple: Interior";
        this.description = "You get in front of the gate and with a strong push you open it wide.\n" +
                "What you encounter is a bit more than surprising.\n" +
                "It seems like this temple has not been visited or used in any way for a long time.\n" +
                "Cobwebs in every corner, dusty benches and rusted metal candlesticks lie on the floor.\n" +
                "Further inside, there is an altar, with a pile of scriptures on top.\n" +
                "On the leftmost section of the hall is a wide, flat surface on the wall\n" +
                "that looks, weirdly enough, untouched by time or decay.\n" +
                "Also, on some points, you can detect some vertical, possibly man-made, engraves\n" +
                "but you can't seem to understand their purpose.";
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

