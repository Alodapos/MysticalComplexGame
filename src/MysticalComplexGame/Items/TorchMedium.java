package MysticalComplexGame.Items;

import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;

public class TorchMedium extends IItem implements LightEmitter
{
    public LightEmitterState burning;
    public LightEmitterPlace spot;
    private String emitterBurning;
    private String lightSuccess;
    private String noFireSource;
    private String attachSuccess;
    private String attachFailed;
    private String quenchSuccess;
    private String isAlreadyQuenched;
    private String fire;

    public TorchMedium(LightEmitterState burning)
    {
        pickable = true;
        name = "medium torch";
        this.burning = burning;
        setDescription(burning, spot);
        emitterBurning = "This is already burning, you can't relight it.";
        lightSuccess = "You light the " + name + " and your surroundings are shrouded in light.";
        attachSuccess = "You attach your " + name + " to a steady spot.";
        attachFailed = "You can't find a proper spot to attach your " + name + ".";
        noFireSource = "There is no fire source nearby to light this.";
        quenchSuccess = "You shove the " + name + " to the ground and gray smoke fills the air around you.";
        isAlreadyQuenched = "You cannot quench that, it is already quenched.";
        fire = "fire";
    }

    @Override
    public void attach(Player player, IItem item)
    {
        if (!player.getInventory().containsValue(item)) GameEngine.textOutput(attachFailed);
        else
        {
            GameEngine.textOutput(attachSuccess);
            player.removeFromInventory(item);
        }

    }

    @Override
    public void light(Player player, IItem item)
    {
        if (burning == LightEmitterState.LIT) GameEngine.textOutput(emitterBurning);
        else if (player.getLocation().getItems().get(fire)!=null)
        {
            this.burning = LightEmitterState.LIT;
            GameEngine.textOutput(lightSuccess);
            setDescription(burning, spot);
        }
        else GameEngine.textOutput(noFireSource);
    }

    @Override
    public void quench()
    {
        if (burning == LightEmitterState.QUENCHED) GameEngine.textOutput(isAlreadyQuenched);
        else
        {
            burning = LightEmitterState.QUENCHED;
            setDescription(burning, spot);
            GameEngine.textOutput(quenchSuccess);
        }
    }

    private void setDescription(LightEmitterState state, LightEmitterPlace place)
    {
        this.description= "There is a " + state.getBurning() + "," + " medium sized torch attached on " + place.getSpot();
        this.inventoryDescription = "A medium "+ state.getBurning() + " torch.";
    }
}

