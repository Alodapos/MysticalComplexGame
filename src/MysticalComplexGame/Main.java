package MysticalComplexGame;

import MysticalComplexGame.Characters.*;
import MysticalComplexGame.Items.*;
import MysticalComplexGame.Scenes.*;
import MysticalComplexGame.Commands.*;

import java.util.Scanner;

class Main
{

    public static void main(String[] args)
    {

        InputHandler handler = new InputHandler();
        //items to use
        IItem shinyRock = new ShinyRock();
        IItem flask = new Flask();
        //scene initializer , sceneID, northScene, south, east, west, negative or zero for no-go
        //scenes to use
        IScene campsite = new CampsiteScene("Crossroads","You can't return home just yet.The Sage awaits you.",
                                            "The Barren Hills lie on your east blocking your view.",
                                            "The Barren Hills also lie on your west prohibiting your vision to what's beyond.",flask);
        IScene crossroads = new CrossroadsScene("Not yet made.","Crystal Lake","Wild Road",
                                                "There is a forest of pine trees to your west.",shinyRock);
        IScene crystalLake = new CrystalLakeScene("Crossroads","You can see the campsite from here but you can't reach it, it's on a higher ground.",
                                           "A dense forest, with short but many trees expands to your east.",
                                           "To your west you can barely see the road connecting the Campsite with the Crossroads point.");
        IScene wildernessRoad = new WildernessRoadScene("Not yet made","You now have a panoramic view of the dense forest.","Felrock Village","Crossroads");
        IScene felrockVillage = new FelrockVillageScene("More trees forming another huge forest.","The dense forest of short trees continues to more south-eastern parts of the area.",
                                                        "Cave Of Anguish: Exterior","Wild Road");
        IScene felrockTempleExterior = new FelrockTempleExteriorScene("The village's stone fountain is located right in the middle of the plateau.",
                                                                      "The dense forest completely surrounds the village, providing a good defence at the same time.",
                                                                      "To your east are neatly built some residencies.",
                                                                      "To your west there are some trees and, further, the road which you came from.");
        IScene felrockTempleInterior = new FelrockTempleInteriorScene("U wot mate, you wanna travel in da temple?","U wot mate, you wanna travel in da temple?",
                                                                      "U wot mate, you wanna travel in da temple?","U wot mate, you wanna travel in da temple?");
        IScene felrockTownHallExterior = new FelrockTownHallExteriorScene("Some more residencies are neatly built here.","Nothing more than a few houses there.",
                                                                          "There's one weird road leading away from the village to your east.",
                                                                          "The village's stone fountain is located right in the middle of the plateau.");
        IScene felrockTownHallInteriorGroundFloor = new FelrockTownHallInteriorGroundFloorScene("U wot mate, you wanna travel in da town hall?","U wot mate, you wanna travel in da town hall?",
                                                                          "U wot mate, you wanna travel in da town hall?","U wot mate, you wanna travel in da town hall?");
        IScene felrockTownHallInteriorFirstFloor = new FelrockTownHallInteriorFirstFloorScene("U wot mate, you wanna travel in da town hall","U wot mate, you wanna travel in da town hall",
                                                                                              "U wot mate, you wanna travel in da town hall","U wot mate, you wanna travel in da town hall");
        IScene felrockTownHallInteriorSecondFloor = new FelrockTownHallInteriorSecondFloorScene("U wot mate, you wanna travel in da town hall","U wot mate, you wanna travel in da town hall",
                                                                                                "U wot mate, you wanna travel in da town hall","U wot mate, you wanna travel in da town hall");
        IScene caveOfAnguishExterior = new CaveOfAnguishExteriorScene("The cave's dark hollow stands before you. Will you dare pass through?",
                                                                      "A massive forest is all you can see to your south.",
                                                                      "There is nothing but rocks and hills there.","Felrock Village");
        IScene caveOfAnguishInterior = new CaveOfAnguishInteriorScene("U wot mate, you wanna travel in da cave?","U wot mate, you wanna travel in da cave?",
                                                                      "U wot mate, you wanna travel in da cave?","U wot mate, you wanna travel in da cave?");
        IScene clearing = new ClearingScene("Iceblue River","Cave of Anguish: Interior","A steep cliff to your east creates a waterfall as the river falls below.",
                                            "To your west goes a trail of dirt, splitting in half, one part going north and the other south.");
        IScene iceblueRiver = new IceblueRiverScene("Forward, there stands a wooden bridge connecting the river's bank with the Garden of Corruption.",
                                                    "You can still see the Clearing you left behind.",
                                                    "The Iceblue River flows fiercely and fast.","not yet made");
        IScene gardenOfCorruption = new GardenOfCorruptionScene("There's nothing you can see beyond this point.",
                                                                "The Iceblue River flows fiercely, you can tell from the loud sound.",
                                                                "The Tree of Eternity is truly magnificent!",
                                                                "On your left, still stands the wooden bridge.");
        IScene felrockTownHallInteriorLobby = new FelrockTownHallInteriorLobbyScene("","","","");
        /*IScene gardenOfRadiance = new GardenOfRadianceScene("There's nothing you can see beyond this point.",
                                                            "The Iceblue River flows fiercely, you can tell from the loud sound.",
                                                            "The Tree of Eternity is truly magnificent!",
                                                            "On your left, still stands the wooden bridge."); */
        handler.addScene(campsite);
        handler.addScene(crossroads);
        handler.addScene(crystalLake);
        handler.addScene(wildernessRoad);
        handler.addScene(felrockVillage);
        handler.addScene(felrockTempleExterior);
        handler.addScene(felrockTempleInterior);
        handler.addScene(felrockTownHallExterior);
        handler.addScene(felrockTownHallInteriorGroundFloor);
        handler.addScene(felrockTownHallInteriorLobby);
        handler.addScene(felrockTownHallInteriorFirstFloor);
        handler.addScene(felrockTownHallInteriorSecondFloor);
        handler.addScene(caveOfAnguishExterior);
        handler.addScene(caveOfAnguishInterior);
        handler.addScene(clearing);
        handler.addScene(iceblueRiver);
        handler.addScene(gardenOfCorruption);
        //handler.addScene(gardenOfRadiance);

        //commands to use
        ICommand go = new GoCommand();
        ICommand look = new LookCommand();
        ICommand pick = new PickCommand();
        ICommand cry = new CryCommand();
        ICommand drop = new DropCommand();
        ICommand inventory = new InventoryCommand();
        handler.addCommand(go);
        handler.addCommand(look);
        handler.addCommand(pick);
        handler.addCommand(cry);
        handler.addCommand(drop);
        handler.addCommand(inventory);
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
        System.out.println("\n\n\nYou have completed ACT I, ACT II is under development, stay tuned for more...\n");
    }
}
