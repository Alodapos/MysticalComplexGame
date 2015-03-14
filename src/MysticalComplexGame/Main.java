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
        IScene one = new FirstScene(100,0,0,200,0,0,0,testItem);
        IScene two = new SecondScene(200,300,0,0,100,0,0);
        IScene three = new ThirdScene(300,0,200,0,0,0,0);
        handler.addScene(one);
        handler.addScene(two);
        handler.addScene(three);
        //verbs to use
        ICommand go = new GoCommand();
        handler.addVerbs(go);
        //player character
        ICharacter player = new PlayerCharacter();
        player.setCurrentLocation(one);


        //initializing some more stuff
        String userInputString;
        Scanner userInput;

        //-----INTRO-----
        //System.out.println("Intro text here");
        //TODO INTRO

        //print dis scene
        player.getCurrentLocation().printDescription();

        //-----GAME LOOP-----
        for (int i=0;i<9999;i++)
        {
            userInput = new Scanner(System.in);
            userInputString = userInput.nextLine();
            handler.handle(userInputString, player);
        }


    }
}
