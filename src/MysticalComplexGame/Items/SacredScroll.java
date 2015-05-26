package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class SacredScroll extends IItem implements ReadableItem
{
    private String text;

    public SacredScroll()
    {
        name = "sacred scroll";
        inventoryDescription = "A sacred scroll of ancient times. Fate or luck, it is now at your hands.";
        description = "A very old scroll, widely opened, is kept within a, seemingly unlocked, glass lid.";
        text = "\"The language in which this scripture is written is unknown to you.\n" +
                "Although, you may find someone who possesses the knowledge to read it.\"";
        pickable = true;
    }

    @Override
    public void read(Player player)
    {
        GameEngine.textOutput("You read the scroll:\n"+text+"");
    }
}
