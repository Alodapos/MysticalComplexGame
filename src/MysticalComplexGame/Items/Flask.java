package MysticalComplexGame.Items;

import MysticalComplexGame.Connector;
import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;

public class Flask extends IItem implements LiquidContainer,KeyItem
{
    private LiquidContainerState fullness;
    private String containerEmpty;
    private String drinkSuccess;
    private String fillSuccess;
    private String fillFailed;
    private String noWaterSource;
    private String isAlreadyEmpty;
    private String water;
    private Connector toOpen;

    public Flask(LiquidContainerState fullness, Connector toUnlock)
    {
        pickable = true;
        name = "leather flask";
        this.fullness = fullness;
        setDescription(fullness);
        containerEmpty = "This is empty, i cannot drink from it.";
        drinkSuccess = "You drink from the " + name + " and quench your thirst.";
        fillSuccess = "You fill your flask with water.";
        fillFailed = "The flask is already filled.";
        noWaterSource = "There is no water source nearby to fill this.";
        isAlreadyEmpty = "You cannot empty that, it is already empty.";
        water = "water";
        this.toOpen = toUnlock;
    }

    @Override
    public void drink(Player player)
    {
        if (fullness == LiquidContainerState.FILLED)
        {
            player.setThirstLevel(15);
            GameEngine.textOutput(drinkSuccess);
            setDescription(fullness);
            this.fullness = LiquidContainerState.EMPTY;
        }
        else GameEngine.textOutput(containerEmpty);

    }

    @Override
    public void fill(Player player)
    {
        if (fullness == LiquidContainerState.FILLED) GameEngine.textOutput(fillFailed);
        else if (player.getLocation().getItems().get(water)!=null)
        {
            this.fullness = LiquidContainerState.FILLED;
            GameEngine.textOutput(fillSuccess);
            setDescription(fullness);
        }
        else GameEngine.textOutput(noWaterSource);
    }

    @Override
    public void empty()
    {
        if (fullness == LiquidContainerState.EMPTY) GameEngine.textOutput(isAlreadyEmpty);
        else
        {
            fullness = LiquidContainerState.EMPTY;
            setDescription(fullness);
            GameEngine.textOutput("You pour the water to the ground till the " + name + " is completely empty.");
        }
    }

    private void setDescription(LiquidContainerState state)
    {
        this.description= "There is a small sized, " + state.getFullness() + ", leather flask on a wooden table.";
        this.inventoryDescription = "A small "+ state.getFullness() + " flask.";
    }

    @Override
    public void pick(Player player)
    {
        super.pick(player);
        toOpen.openConnection();
    }
}
