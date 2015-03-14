package MysticalComplexGame.Scenes;

import MysticalComplexGame.Items.IItem;

import java.util.ArrayList;

/**
 * Created by sakis on 08-Mar-15.
 */
public class CampsiteScene implements IScene
{

    //north,south,east,west,up,down
    private int[] nextScene= new int[6];
    private int sceneId;
    private String description;
    private String sceneName;
    private ArrayList<IItem> itemsList = new ArrayList<IItem>();


    public CampsiteScene(int id, int north, int south, int east, int west, int up, int down, IItem... items)
    {
        this.sceneId = id;
        this.nextScene[0] = north;
        this.nextScene[1] = south;
        this.nextScene[2] = east;
        this.nextScene[3] = west;
        this.nextScene[4] = up;
        this.nextScene[5] = down;
        //Scene name in caps please
        this.sceneName = "Campsite";
        this.description = "You grab your stuff and begin traveling to the EAST,\nwhile the night offers you the perfect cover from prying eyes.\nYou plan to arrive at Renelor within 20 days,\nunless something unexpected happens.\nThe moment you leave the campsite you are facing a large crossroads and must decide which way to go.";
        for (IItem item:items) itemsList.add(item);

    }

    @Override
    public void setSceneId(int id)
    {
        this.sceneId=id;
    }

    @Override
    public int getSceneId()
    {
        return sceneId;
    }

    @Override
    public int[] getNextScene()
    {
        return nextScene;
    }
    @Override
    public int getNextScene(int nxt)
    {
        return nextScene[nxt];
    }

    @Override
    public void setNextScene(int[] nextScene)
    {
        this.nextScene = nextScene;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public String getSceneName()
    {
        return sceneName;
    }

    @Override
    public void printDescription()
    {
        System.out.println(this.sceneName+"\n");
        System.out.println(this.description);
        for (IItem item : itemsList)
        {
            System.out.println(item.getDescription());
        }

    }


}

