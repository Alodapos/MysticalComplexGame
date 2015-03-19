package MysticalComplexGame.Scenes;

import MysticalComplexGame.Items.IItem;

import java.util.ArrayList;

public class FelrockVillageScene implements IScene
{

    //north,south,east,west,up,down
    private String[] nextScene= new String[4];
    private String description;
    private String sceneName;
    private ArrayList<IItem> itemsList = new ArrayList<IItem>();


    public FelrockVillageScene(String north, String south, String east, String west, IItem... items)
    {
        this.nextScene[0] = north;
        this.nextScene[1] = south;
        this.nextScene[2] = east;
        this.nextScene[3] = west;
        this.sceneName = "Felrock Village";
        this.description = "You slowly and reluctantly enter the village,\n" +
                "quickly throwing your eyes at everything you meet\n" +
                "in order to examine the place and be prepared for any unpleasant surprises.\n" +
                "You can clearly see some residencies and realise that this is a small village with a very few inhabitants.\n" +
                "There is a very big, simple, stone fountain in the middle of the village,\n" +
                "spouting crystal clear water from its holes.\n" +
                "On its south, you can distinguish a great and majestic building which,\n" +
                "judging from the decoration, size and location, must be the village's temple.\n" +
                "On its east, there lies a grand structure, of white and pale shades of brown which,\n" +
                "considering the architecture that's been used and its position, must be the town hall.\n" +
                "Farther to the east, your sight follows a path, quite narrow, leading somewhere far ahead, but you can't see exactly where.";
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

