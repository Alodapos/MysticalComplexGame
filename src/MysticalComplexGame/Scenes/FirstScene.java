package MysticalComplexGame.Scenes;

import MysticalComplexGame.Items.IItem;

import java.util.ArrayList;

/**
 * Created by sakis on 08-Mar-15.
 */
public class FirstScene implements IScene
{

    //north,south,east,west,up,down
    private int[] nextScene= new int[6];
    private int sceneId;
    private String description;
    private String sceneName;
    private ArrayList<IItem> itemsList = new ArrayList<IItem>();


    public FirstScene(int id, int north, int south, int east, int west, int up, int down, IItem ... items)
    {
        this.sceneId = id;
        this.nextScene[0] = north;
        this.nextScene[1] = south;
        this.nextScene[2] = east;
        this.nextScene[3] = west;
        this.nextScene[4] = up;
        this.nextScene[5] = down;
        this.sceneName = "Intro - Campsite";
        this.description = "Placeholder description for first scene";
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
    public void changeScene(int nextSceneId)
    {

    }


}

