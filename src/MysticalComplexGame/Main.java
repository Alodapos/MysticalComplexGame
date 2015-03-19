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

        InputHandler handler = new InputHandler();
        //items to use
        IItem shinyRock = new ShinyRock();
        //scene initializer , sceneID, northScene, south, east, west, up, down, negative or zero for no-go
        //scenes to use
        IScene campsite = new CampsiteScene("Crossroads","the path is blocked","hills of masochism","hills of sadism");
        IScene crossroads = new CrossroadsScene("nothing at all","Lake","Wild Road","a shitty forest",shinyRock);
        IScene lake = new LakeScene("Crossroads","nothing","nothing","nothing");
        IScene wildRoad = new WildRoadScene("nothing at all","nothing at all","Felrock Village","Crossroads");
        IScene felrockVillage = new FelrockVillageScene("nothing","a fucking forest","Cave of Anguish","Wild Road");
        IScene felrockTempleExterior = new FelrockTempleExteriorScene("Felrock Village","nothing","residencies","trees");
        IScene felrockTempleInterior = new FelrockTempleInteriorScene("U wot mate, you wanna travel in da temple?","U wot mate, you wanna travel in da temple?",
                                                                      "U wot mate, you wanna travel in da temple?","U wot mate, you wanna travel in da temple?");
        IScene felrockTownHallExterior = new FelrockTownHallExteriorScene("residencies","residencies","nothing","fountain");
        IScene felrockTownHallInteriorGroundFloor = new FelrockTownHallInteriorGroundFloorScene("U wot mate, you wanna travel in da temple?","U wot mate, you wanna travel in da temple?",
                                                                          "U wot mate, you wanna travel in da temple?","U wot mate, you wanna travel in da temple?");
        IScene felrockTownHallInteriorFirstFloor = new FelrockTownHallInteriorFirstFloorScene("","","","");
        IScene felrockTownHallInteriorSecondFloor = new FelrockTownHallInteriorSecondFloorScene("","","","");
        IScene caveOfAnguishExterior = new CaveOfAnguishExteriorScene("nothing","forest","nothing at all", "Felrock Village");
        IScene caveOfAnguishInterior = new CaveOfAnguishInteriorScene("U wot mate, you wanna travel in da temple?","U wot mate, you wanna travel in da temple?",
                                                                      "U wot mate, you wanna travel in da temple?","U wot mate, you wanna travel in da temple?");
        IScene clearing = new ClearingScene("","","","");
        IScene iceblueRiver = new IceblueRiverScene("","","","");
        IScene gardenOfCorruption = new GardenOfCorruptionScene("","","","");
        IScene gardenOfRadiance = new GardenOfRadianceScene("","","","");
        handler.addScene(campsite);
        handler.addScene(crossroads);
        handler.addScene(lake);
        handler.addScene(wildRoad);
        handler.addScene(felrockVillage);
        handler.addScene(felrockTempleExterior);
        handler.addScene(felrockTempleInterior);
        handler.addScene(felrockTownHallExterior);
        handler.addScene(felrockTownHallInteriorGroundFloor);
        handler.addScene(felrockTownHallInteriorFirstFloor);
        handler.addScene(felrockTownHallInteriorSecondFloor);
        handler.addScene(caveOfAnguishExterior);
        handler.addScene(caveOfAnguishInterior);
        handler.addScene(clearing);
        handler.addScene(iceblueRiver);
        handler.addScene(gardenOfCorruption);
        handler.addScene(gardenOfRadiance);

        //commands to use
        ICommand go = new GoCommand();
        ICommand look = new LookCommand();
        ICommand pick = new PickCommand();
        ICommand cry = new CryCommand();
        handler.addCommand(go);
        handler.addCommand(look);
        handler.addCommand(pick);
        handler.addCommand(cry);
        //player character
        ICharacter player = new PlayerCharacter();
        player.setCurrentLocation(campsite);


        //initializing some more stuff
        String userInputString;
        Scanner userInput;

        //-----INTRO-----
        System.out.println("ACT I - The Sage\n");
        System.out.println("As the sun sets, the nightfall finds you getting ready for the upcoming journey to the far land of Serenoth.");
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
