package MysticalComplexGame;


import MysticalComplexGame.Characters.*;
import MysticalComplexGame.Items.*;
import MysticalComplexGame.Scenes.*;
import MysticalComplexGame.Commands.*;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {

        //the handler for everything
        InputHandler handler = new InputHandler();
        //items to use
        IItem testItem = new TestItem();
        //scene initializer , sceneID, northScene, south, east, west, up, down, negative or zero for no-go
        //scenes to use
        IScene one = new FirstScene(100,0,0,200,0,0,0);
        IScene two = new SecondScene(200,300,0,0,100,0,0);
        IScene three = new ThirdScene(300,0,200,0,0,0,0);
        handler.addScene(one);
        handler.addScene(two);
        handler.addScene(three);
        //verbs to use
        IVerb go = new GoVerb();
        handler.addVerbs(go);
        //our character
        ICharacter player = new PlayerCharacter();
        player.setCurrentLocation(one);


        //initializing some more shit
        String userInputString;
        String askForInput = "What will you do?";
        System.out.println("Welcome to our text based adventure, have fun!");
        System.out.println("\n\n\n");
        Scanner userInput;

        System.out.println(player.getCurrentLocation().getSceneName());
        System.out.println(player.getCurrentLocation().getDescription());
        System.out.println(askForInput);


        for (int i=0;i<1000;i++)
        {
            userInput = new Scanner(System.in);
            userInputString = userInput.nextLine();
            handler.handle(userInputString, player);
        }


    }
}
