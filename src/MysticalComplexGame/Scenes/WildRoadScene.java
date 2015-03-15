package MysticalComplexGame.Scenes;

import MysticalComplexGame.Items.IItem;

import java.util.ArrayList;

public class WildRoadScene implements IScene
{

    //north,south,east,west,up,down
    private String[] nextScene= new String[4];
    private String description;
    private String sceneName;
    private ArrayList<IItem> itemsList = new ArrayList<IItem>();


    public WildRoadScene(String north, String south, String east, String west, IItem... items)
    {
        this.nextScene[0] = north;
        this.nextScene[1] = south;
        this.nextScene[2] = east;
        this.nextScene[3] = west;
        //Scene name in caps please
        this.sceneName = "Wild Road";
        this.description = "As you walk the east road, you begin to perceive a blurry landscape which,\n" +
                "as it seems, consists by some kind of structures surrounded by tall trees.\n" +
                "The closer you get, the clearer it becomes. It seems you have arrived at a small, remote, yet peaceful village.\n" +
                "At the end of the path you see a sign reading \"Felrock Village\".\n" +
                "Do you want to proceed entering the village or you want to try another path?";

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


}

