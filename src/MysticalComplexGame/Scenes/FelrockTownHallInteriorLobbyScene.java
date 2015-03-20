package MysticalComplexGame.Scenes;

import MysticalComplexGame.Items.IItem;

import java.util.ArrayList;
import java.util.Collections;

public class FelrockTownHallInteriorLobbyScene implements IScene
{

    //north,south,east,west
    private String[] nextScene= new String[4];
    private final String description;
    private final String sceneName;
    private final ArrayList<IItem> itemsList = new ArrayList<IItem>();


    public FelrockTownHallInteriorLobbyScene(String north, String south, String east, String west, IItem... items)
    {
        this.nextScene[0] = north;
        this.nextScene[1] = south;
        this.nextScene[2] = east;
        this.nextScene[3] = west;
        this.sceneName = "Felrock Village - Town Hall: Interior - Lobby";
        this.description = "Reluctantly, you get closer to the room and the voices are getting clearer.\n" +
                "The two men hear your footsteps and stop at once.\n" +
                "When you reveal yourself they look at you with shirred eyes and a concerned expression.\n" +
                "Now one of them is approaching you. He is tall, wearing some kind of armour and holds a stick in his right hand. \n" +
                "You sense that he could be a very strict character and probably a high-ranked member of the village's army. \n" +
                "He greets you with a brief introduction, telling you his name: <General \"name of tall man\"> and asking for yours. \n" +
                "...<user name input>... \n" +
                "You kindly introduce yourself to both and ask to learn who the other man is. \n" +
                "He is significantly shorter than <name of tall man> and wears neat and elegant clothes making him very prestigious. \n" +
                "He holds a small case in his hands. His name is <name of short man>. \n" +
                "He tells you that he is the mayor's advisor.";
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

