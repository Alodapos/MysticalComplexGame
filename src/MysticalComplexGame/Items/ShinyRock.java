package MysticalComplexGame.Items;

import MysticalComplexGame.Characters.ICharacter;
import MysticalComplexGame.Scenes.IScene;

import java.util.ArrayList;


public class ShinyRock implements IItem
{
    private String name;
    private String description;
    private String inventoryDescription;
    private boolean usable;
    private boolean pickable;
    private boolean dropable;
    private boolean pullable;
    private boolean pushable;
    private boolean enterable;

    public ShinyRock()
    {
        name = "rock";
        description= "A gold , shiny rock lies on the floor...its...dazzling...";
        inventoryDescription = "A dazzling-shiny rock.";
        usable = false;
        pickable = true;
        dropable = true;
        pushable = false;
        pullable = false;
        enterable = false;
    }
    @Override
    public void useItem(ICharacter player, ArrayList<IScene> scenes)
    {
        //TODO use item
    }

    @Override
    public boolean isEnterable() {
        return enterable;
    }

    @Override
    public void setEnterable(boolean enterable) {
        this.enterable = enterable;
    }

    @Override
    public boolean isPushable() {
        return pushable;
    }

    @Override
    public void setPushable(boolean pushable) {
        this.pushable = pushable;
    }

    @Override
    public boolean isPullable() {
        return pullable;
    }

    @Override
    public void setPullable(boolean pullable) {
        this.pullable = pullable;
    }

    @Override
    public boolean isDropable() {
        return dropable;
    }

    @Override
    public void setDropable(boolean dropable) {
        this.dropable = dropable;
    }

    @Override
    public boolean isPickable() {
        return pickable;
    }

    @Override
    public void setPickable(boolean pickable) {
        this.pickable = pickable;
    }

    @Override
    public boolean isUsable() {
        return usable;
    }

    @Override
    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    @Override
    public String getInventoryDescription() {
        return inventoryDescription;
    }

    @Override
    public void setInventoryDescription(String inventoryDescription) {
        this.inventoryDescription = inventoryDescription;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
