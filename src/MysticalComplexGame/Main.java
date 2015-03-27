package MysticalComplexGame;

import MysticalComplexGame.Items.*;
import MysticalComplexGame.Commands.*;
import java.util.Scanner;

class Main
{

    static String textNameCampsite;
    static String textNameCrossroads;
    static String textNameCrystalLake;

    static String textDescriptionCampsite;

    static String textCampsiteSouth;
    static String textCampsiteEast;
    static String textCampsiteWest;
    public static void main(String[] args)
    {
        InitializeComponents();
        InputHandler handler = new InputHandler();
        //items init
        IItem shinyRock = new ShinyRock("pick","drop");
        IItem flask = new Flask("pick","drop");
        //scene init
        Scene campsite = new Scene(textNameCampsite,textDescriptionCampsite, textNameCrossroads,textCampsiteSouth,textCampsiteEast,textCampsiteWest, flask);
        Scene crossroads = new Scene("Crossroads","The moment you leave the campsite you see the, one and only, road leading upwards, so you take it.\n" +
                "After a while you are facing a large crossroads and must decide which way to go.","Not yet made","Crystal Lake","Wild Road", "There is a pine forest to your west.", shinyRock);
        /*
        Scene crystalLake = new CrystalLakeScene("Crossroads","You can see the campsite from here but you can't reach it, it's on a higher ground.",
                                           "A dense forest, with short but many trees expands to your east.",
                                           "To your west you can barely see the road connecting the Campsite with the Crossroads point.");
        Scene wildernessRoad = new WildernessRoadScene("Not yet made","You now have a panoramic view of the dense forest.","Felrock Village","Crossroads");
        Scene felrockVillage = new FelrockVillageScene("More trees forming another huge forest.","The dense forest of short trees continues to more south-eastern parts of the area.",
                                                        "Cave Of Anguish: Exterior","Wild Road");
        Scene felrockTempleExterior = new FelrockTempleExteriorScene("The village's stone fountain is located right in the middle of the plateau.",
                                                                      "The dense forest completely surrounds the village, providing a good defence at the same time.",
                                                                      "To your east are neatly built some residencies.",
                                                                      "To your west there are some trees and, further, the road which you came from.");
        Scene felrockTempleInterior = new FelrockTempleInteriorScene("U wot mate, you wanna travel in da temple?","U wot mate, you wanna travel in da temple?",
                                                                      "U wot mate, you wanna travel in da temple?","U wot mate, you wanna travel in da temple?");
        Scene felrockTownHallExterior = new FelrockTownHallExteriorScene("Some more residencies are neatly built here.","Nothing more than a few houses there.",
                                                                          "There's one weird road leading away from the village to your east.",
                                                                          "The village's stone fountain is located right in the middle of the plateau.");
        Scene felrockTownHallInteriorGroundFloor = new FelrockTownHallInteriorGroundFloorScene("U wot mate, you wanna travel in da town hall?","U wot mate, you wanna travel in da town hall?",
                                                                                                "U wot mate, you wanna travel in da town hall?","U wot mate, you wanna travel in da town hall?");
        Scene felrockTownHallInteriorLobby = new FelrockTownHallInteriorLobbyScene("U wot mate, you wanna travel in da town hall?","U wot mate, you wanna travel in da town hall?",
                                                                                    "U wot mate, you wanna travel in da town hall?","U wot mate, you wanna travel in da town hall?");
        Scene felrockTownHallInteriorFirstFloor = new FelrockTownHallInteriorFirstFloorScene("U wot mate, you wanna travel in da town hall","U wot mate, you wanna travel in da town hall",
                                                                                              "U wot mate, you wanna travel in da town hall","U wot mate, you wanna travel in da town hall");
        Scene felrockTownHallInteriorSecondFloor = new FelrockTownHallInteriorSecondFloorScene("U wot mate, you wanna travel in da town hall","U wot mate, you wanna travel in da town hall",
                                                                                                "U wot mate, you wanna travel in da town hall","U wot mate, you wanna travel in da town hall");
        Scene caveOfAnguishExterior = new CaveOfAnguishExteriorScene("The cave's dark hollow stands before you. Will you dare pass through?",
                                                                      "A massive forest is all you can see to your south.",
                                                                      "There is nothing but rocks and hills there.","Felrock Village");
        Scene caveOfAnguishInterior = new CaveOfAnguishInteriorScene("U wot mate, you wanna travel in da cave?","U wot mate, you wanna travel in da cave?",
                                                                      "U wot mate, you wanna travel in da cave?","U wot mate, you wanna travel in da cave?");
        Scene clearing = new ClearingScene("Iceblue River","Cave of Anguish: Interior","A steep cliff to your east creates a waterfall as the river falls below.",
                                            "To your west goes a trail of dirt, splitting in half, one part going north and the other south.");
        Scene iceblueRiver = new IceblueRiverScene("Forward, there stands a wooden bridge connecting the river's bank with the Garden of Corruption.",
                                                    "You can still see the Clearing you left behind.",
                                                    "The Iceblue River flows fiercely and fast.","not yet made");
        Scene gardenOfCorruption = new GardenOfCorruptionScene("There's nothing you can see beyond this point.",
                                                                "The Iceblue River flows fiercely, you can tell from the loud sound.",
                                                                "The Tree of Eternity is truly magnificent!",
                                                                "On your left, still stands the wooden bridge.");
        Scene gardenOfRadiance = new GardenOfRadianceScene("There's nothing you can see beyond this point.",
                                                            "The Iceblue River flows fiercely, you can tell from the loud sound.",
                                                            "The Tree of Eternity is truly magnificent!",
                                                            "On your left, still stands the wooden bridge."); */
        handler.addScene(campsite);
        handler.addScene(crossroads);
        /*
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
        //handler.addScene(gardenOfRadiance); */

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
        Character player = new Character("player",campsite);
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
        player.getLocation().printDescription();
        //-----GAME LOOP-----
        do
        {
            userInput = new Scanner(System.in);
            userInputString = userInput.nextLine().trim();
            handler.handleInput(userInputString, player);
        } while (!player.getLocation().getName().equals("The Sage"));
        System.out.println("\n\n\nYou have completed ACT I, ACT II is under development, stay tuned for more...\n");
    }

    private static  void InitializeComponents()
    {
        textNameCampsite = "Campsite";
        textNameCrossroads = "Crossroads";

        textDescriptionCampsite = "You grab your stuff and begin traveling to the NORTH, while the night offers you the perfect cover from prying eyes.\nYou plan to arrive at Serenoth within 20 days,\nunless something unexpected happens.";
        textCampsiteEast = "nothing!";
        textCampsiteSouth = "notign";
        textCampsiteWest = "nooooothing";
    }


}
