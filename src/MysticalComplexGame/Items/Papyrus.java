package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;

public class Papyrus extends IItem implements ReadableItem,WriteableItem
{
    private String text;

    public Papyrus()
    {
        name = "rugged papyrus";
        inventoryDescription = "A papyrus that you can read and write";
        description = "A rugged papyrus lies on the floor.";
        text = "";
        pickable = true;
    }

    @Override
    public void read()
    {
        if (text.equals(""))
            GameEngine.textOutput("The papyrus is blank");
        else
            GameEngine.textOutput("You read the papyrus:\n\""+text+"\"");
    }

    @Override
    public void write()
    {
        GameEngine.textOutput("Write down some text to the papyrus:");
        String text;
        text = GameEngine.textInput();
        this.text = this.text + "\n"+ text;
        GameEngine.textOutput("You write the text on the papyrus.");
    }
}
