package MysticalComplexGame.Scenes;

import MysticalComplexGame.Items.IItem;

import java.util.ArrayList;
import java.util.Collections;

public class CaveOfAnguishExteriorScene implements IScene
{

    //north,south,east,west
    private String[] nextScene= new String[4];
    private final String description;
    private final String sceneName;
    private final ArrayList<IItem> itemsList = new ArrayList<IItem>();


    public CaveOfAnguishExteriorScene(String north, String south, String east, String west, IItem... items)
    {
        this.nextScene[0] = north;
        this.nextScene[1] = south;
        this.nextScene[2] = east;
        this.nextScene[3] = west;
        this.sceneName = "Cave of Anguish: Exterior";
        this.description = "From the roads leading away from the village you take the northern.\n" +
                "It's a relatively short road, not very wide, but neither too slim.\n" +
                "Unlike the village's scenery, here lies a barren landscape, with no trees, no flowers, no water either.\n" +
                "As the road seems to be coming to its end, you begin to sense an unsettling aura filling the space around you.\n" +
                "But what you witness further ahead is far worse.\n" +
                "The whole place is surrounded by a thick fog and an increased humidity fills the atmosphere.\n" +
                "A dark, blackish, rocky and extremely huge entrance stands before you.\n" +
                "It's been dug out by men, probably many, many years ago and it bears a sign, which is too clean to be older than a month, that tells:\n" +
                "\"WARNING!\n" +
                "You are about to enter the Cave of Anguish.\n" +
                "Death awaits all those who enter and all who have entered did not return.\n" +
                "Proceed at your own risk.\n" +
                "WARNING!\"\n" +
                "There are also two medium sized torches placed on each side of the cave's entrance that burn bright.\n" +
                "Now you can clearly feel dark energies emanating from the cave's insides.\n" +
                "Vision is blocked beyond the threshold of the entrance and since the mountain is massive you can't see past it,\n" +
                "for it spreads far to the east and a dense forest extends to the west.";

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
    public ArrayList<IItem> getItemsList()
    {
        return this.itemsList;
    }
}

