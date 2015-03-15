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
        IScene campsite = new CampsiteScene("Crossroads","nothing","hills of masochism","hills of sadism");
        IScene crossroads = new CrossroadsScene("nothing at all","lake of sperm","Wild Road","forest");
        IScene wildRoad = new WildRoadScene("nothing","nothing","Felrock Village","Crossroads");
        IScene felrockVillage = new FelrockVillageScene("nothing","a fucking forest","Cave Of Anguish","Wild Road");
        IScene caveOfAnguish = new CaveOfAnguishScene("river of sperm","absolutely nothing","nothing", "Felrock Village");
        handler.addScene(campsite);
        handler.addScene(crossroads);
        handler.addScene(wildRoad);
        handler.addScene(felrockVillage);
        handler.addScene(caveOfAnguish);
        //verbs to use
        ICommand go = new GoCommand();
        handler.addVerbs(go);
        //player character
        ICharacter player = new PlayerCharacter();
        player.setCurrentLocation(campsite);


        //initializing some more stuff
        String userInputString;
        Scanner userInput;

        //-----INTRO-----
        System.out.println("ACT I - The Sage\n");
        System.out.println("As the sun set, the nightfall finds you getting ready for the upcoming journey to the far land of Serenoth.");
        System.out.println("You must reach this region in order to find a great sage, who is the personal advisor of king Ecthelion, son of Exelion.");
        System.out.println("This great sage often goes by many names, but one is more common to the people of Dal'aron, Zenthar");
        System.out.println("He is against all the strife of the two kingdoms, for he knows what really happened two hundred years ago.");
        System.out.println("But the two kings care for nothing than the dominion of their own might all over the world.");
        System.out.println("This is why you need his help to convince king Ecthelion to cease his actions and withdraw his armies before its too late to stop this madness.");
        System.out.println("Therefore...\n");
        player.getCurrentLocation().printDescription();

        //-----GAME LOOP-----
        do
        {
            userInput = new Scanner(System.in);
            userInputString = userInput.nextLine();
            handler.handle(userInputString, player);
        } while (!player.getCurrentLocation().getSceneName().equals("The Sage"));
        System.out.println("You have completed ACT I, ACT II is under development, stay tuned for more...");
    }
}
