package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

import java.util.Scanner;

public class Papyrus extends IItem implements ReadableItem,WritableItem
{
    private String text;

    public Papyrus()
    {
        pickable = false;
        name = "papyrus";
        inventoryDescription = "A papyrus that you can read and write";
        description = "A rugged papyrus lies on the floor.";
        text = "";
        pickable = true;
    }

    @Override
    public void read(Player player)
    {
        if (text.equals("")) GameEngine.textOutput("The papyrus is blank");
        else GameEngine.textOutput("You read the papyrus:\n\""+text+"\"");
    }

    @Override
    public void write()
    {
        GameEngine.textOutput("Write down some text to the papyrus:");
        Scanner scanner;
        scanner = new Scanner(System.in);
        text= text + "\n"+ scanner.nextLine();
        scanner = new Scanner(System.in);
        GameEngine.textOutput("You write the text on the papyrus.");
    }
}
