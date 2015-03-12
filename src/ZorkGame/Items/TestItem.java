package ZorkGame.Items;

/**
 * Created by sakis on 12-Mar-15.
 */
public class TestItem implements IItem {
    private String name;
    private String description;
    private boolean canBeUsed;
    private boolean canBePicked;

    public TestItem(){
        name = "a test item";
        description= "loooook at me i'm an item!!";
        canBeUsed = false;
        canBePicked = true;
    }

    @Override
    public boolean isCanBePicked() {
        return canBePicked;
    }

    @Override
    public void setCanBePicked(boolean canPick) {
        this.canBePicked = canPick;
    }

    @Override
    public boolean isUseable() {
        return canBeUsed;
    }

    @Override
    public void setUseable(boolean canUse) {
        this.canBeUsed = canUse;
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

    private void useItem (){
        //TODO on-use effect
    }
}
