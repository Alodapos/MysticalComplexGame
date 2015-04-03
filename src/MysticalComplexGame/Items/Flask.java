package MysticalComplexGame.Items;

import MysticalComplexGame.Character;
import MysticalComplexGame.Scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Flask implements IItem,LiquidContainer
{
    private String name;
    private String description;
    private String inventoryDescription;
    private List<String> tags;
    private LiquidContainerState fullness;
    private String containerEmpty;
    private String drinkSuccess;
    private String fillSuccess;
    private String fillFailed;
    private String noWaterSource;
    private int power;

    public Flask(int power,LiquidContainerState fullness, String... tags)
    {
        name = "flask";
        this.fullness = fullness;
        setDescription(fullness);
        this.tags = new ArrayList<String>();
        Collections.addAll(this.tags, tags);
        containerEmpty = "This is empty, i cannot drink from it.";
        drinkSuccess = "You drink from the " + this.name + " and quench your thirst.";
        fillSuccess = "You fill your flask with water.";
        fillFailed = "The flask is already filled.";
        noWaterSource = "There is no water source nearby to fill this.";
        this.power = power;
    }

    @Override
    public void drink(Character character)
    {
        if (fullness == LiquidContainerState.FILLED)
        {
            character.setThirstLevel(power);
            System.out.println(drinkSuccess);
            setDescription(fullness);
            this.fullness = LiquidContainerState.EMPTY;
        }
        else System.out.println(containerEmpty);

    }

    @Override
    public void fill(Character character)
    {
        if (fullness == LiquidContainerState.FILLED) System.out.println(fillFailed);
        else if (character.getLocation().getItems().containsKey("water"))
        {
            this.fullness = LiquidContainerState.FILLED;
            System.out.println(fillSuccess);
            setDescription(fullness);
        }
        else System.out.println(noWaterSource);
    }

    @Override
    public String getDescription()
    {
        return  this.description;
    }

    @Override
    public String getName()
    {
        return this.name;
    }
    @Override
    public void setName(String name)
    {
        this.name = name;
    }
    @Override
    public String getInventoryDescription()
    {
        return this.inventoryDescription;
    }

    @Override
    public List<String> getTags()
    {
        return this.tags;
    }

    private void setDescription(LiquidContainerState state)
    {
        this.description= "There is a small sized," + state.getFullness() +" leather flask on a wooden table.";
        this.inventoryDescription = "A small "+ state.getFullness() + " flask";
    }
}
