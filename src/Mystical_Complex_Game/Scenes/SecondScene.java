package Mystical_Complex_Game.Scenes;

import Mystical_Complex_Game.Items.IItem;

import java.util.ArrayList;

/**
 * Created by sakis on 08-Mar-15.
 */
public class SecondScene implements IScene {


    //north,south,east,west,up,down
    private int[] nextScene= new int[6];
    private int sceneId;
    private String description;
    private String sceneName;
    ArrayList<IItem> itemsList = new ArrayList<IItem>();


    public SecondScene(int id, int north, int south, int east, int west, int up, int down,IItem...items){
        this.sceneId = id;
        this.nextScene[0] = north;
        this.nextScene[1] = south;
        this.nextScene[2] = east;
        this.nextScene[3] = west;
        this.nextScene[4] = up;
        this.nextScene[5] = down;
        this.sceneName = "Placeholder name #2st scene; woot?";
        this.description = "Placeholder description for THE SECOND scene";
        for (IItem item:items) itemsList.add(item);
    }

    @Override
    public void setSceneId(int id){
        this.sceneId=id;
    }

    @Override
    public int getSceneId() {
        return sceneId;
    }

    @Override
    public int[] getNextScene() {
        return nextScene;
    }
    @Override
    public int getNextScene(int nxt) {
        return nextScene[nxt];
    }

    @Override
    public void setNextScene(int[] nextScene) {
        this.nextScene = nextScene;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getSceneName() {
        return sceneName;
    }

    @Override
    public void changeScene(int nextSceneId){

    }
}
