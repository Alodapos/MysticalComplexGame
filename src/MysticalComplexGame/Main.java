package MysticalComplexGame;

import MysticalComplexGame.Items.*;
import MysticalComplexGame.Commands.*;
import java.util.Scanner;

class Main
{

    static String textNameCampsite;
    static String textNameCrossroads;
    static String textNameCrystalLake;
    static String textNameWildernessRoad;
    static String textNameFelrockVillage;
    static String textNameFelrockTempleExterior;
    static String textNameFelrockTempleInterior;
    static String textNameFelrockTownHallExterior;
    static String textNameFelrockTownHallInteriorGroundFloor;
    static String textNameFelrockTownHallInteriorLobby;
    static String textNameFelrockTownHallInteriorFirstFloor;
    static String textNameFelrockTownHallInteriorSecondFloor;
    static String textNameCaveOfAnguishExterior;
    static String textNameCaveOfAnguishInterior;
    static String textNameClearing;
    static String textNameIceblueRiver;
    static String textNameGardenOfCorruption;
    static String textNameGardenOfRadiance;

    static String textDescriptionCampsite;
    static String textDescriptionCrossroads;
    static String textDescriptionCrystalLake;
    static String textDescriptionWildernessRoad;
    static String textDescriptionFelrockVillage;
    static String textDescriptionFelrockTempleExterior;
    static String textDescriptionFelrockTempleInterior;
    static String textDescriptionFelrockTownHallExterior;
    static String textDescriptionFelrockTownHallInteriorGroundFloor;
    static String textDescriptionFelrockTownHallInteriorLobby;
    static String textDescriptionFelrockTownHallInteriorFirstFloor;
    static String textDescriptionFelrockTownHallInteriorSecondFloor;
    static String textDescriptionCaveOfAnguishExterior;
    static String textDescriptionCaveOfAnguishInterior;
    static String textDescriptionClearing;
    static String textDescriptionIceblueRiver;
    static String textDescriptionGardenOfCorruption;
    static String textDescriptionGardenOfRadiance;

    //Campsite
    static String textCampsiteSouth;
    static String textCampsiteEast;
    static String textCampsiteWest;
    //Crossroads
    static String textCrossroadsNorth;
    static String textCrossroadsWest;
    //Crystal Lake
    static String textCrystalLakeSouth;
    static String textCrystalLakeEast;
    static String textCrystalLakeWest;
    //Wilderness Road
    static String textWildernessRoadNorth;
    static String textWildernessRoadSouth;
    //Felrock Village
    static String textFelrockVillageNorth;
    //Felrock TempleExterior
    static String textFelrockTempleExteriorSouth;
    static String textFelrockTempleExteriorEast;
    static String textFelrockTempleExteriorWest;
    //Felrock TempleInterior
    static String textFelrockTempleInteriorNorth;
    static String textFelrockTempleInteriorSouth;
    static String textFelrockTempleInteriorEast;
    static String textFelrockTempleInteriorWest;
    //Felrock Town Hall Exterior
    static String textFelrockTownHallExteriorNorth;
    static String textFelrockTownHallExteriorEast;
    static String textFelrockTownHallExteriorWest;
    //Felrock Town Hall Interior Ground Floor
    static String textFelrockTownHallInteriorGroundFloorNorth;
    static String textFelrockTownHallInteriorGroundFloorSouth;
    static String textFelrockTownHallInteriorGroundFloorWest;
    static String textFelrockTownHallInteriorGroundFloorEast;
    //Felrock Town Hall Interior Lobby
    static String textFelrockTownHallInteriorLobbyNorth;
    static String textFelrockTownHallInteriorLobbySouth;
    static String textFelrockTownHallInteriorLobbyWest;
    static String textFelrockTownHallInteriorLobbyEast;
    //Felrock Town Hall Interior First Floor
    static String textFelrockTownHallInteriorFirstFloorNorth;
    static String textFelrockTownHallInteriorFirstFloorSouth;
    static String textFelrockTownHallInteriorFirstFloorWest;
    static String textFelrockTownHallInteriorFirstFloorEast;
    //Felrock Town Hall Interior Second Floor
    static String textFelrockTownHallInteriorSecondFloorNorth;
    static String textFelrockTownHallInteriorSecondFloorSouth;
    static String textFelrockTownHallInteriorSecondFloorWest;
    static String textFelrockTownHallInteriorSecondFloorEast;
    //Cave Of Anguish Exterior
    static String textCaveOfAnguishExteriorNorth;
    static String textCaveOfAnguishExteriorEast;
    static String textCaveOfAnguishExteriorWest;
    //Cave Of Anguish Interior
    static String textCaveOfAnguishInteriorNorth;
    static String textCaveOfAnguishInteriorSouth;
    static String textCaveOfAnguishInteriorEast;
    static String textCaveOfAnguishInteriorWest;
    //Clearing
    static String textClearingNorth;
    static String textClearingEast;
    //Iceblue River
    static String textIceblueRiverEast;
    //Garden Of Corruption
    static String textGardenOfCorruptionNorth;
    static String textGardenOfCorruptionSouth;
    static String textGardenOfCorruptionEast;
    //Garden Of Radiance
    static String textGardenOfRadianceNorth;
    static String textGardenOfRadianceSouth;
    static String textGardenOfRadianceEast;

    public static void main(String[] args)
    {
        InitializeComponents();
        InputHandler handler = new InputHandler();
        //items init
        IItem shinyRock = new ShinyRock("pick","drop");
        IItem flask = new Flask("pick","drop");
        //scene init
        Scene campsite = new Scene(textNameCampsite,textDescriptionCampsite, textNameCrossroads,textCampsiteSouth,textCampsiteEast,textCampsiteWest, flask);
        Scene crossroads = new Scene(textNameCrossroads,textDescriptionCrossroads,textCrossroadsNorth,textNameCrystalLake,textNameFelrockVillage,textCrossroadsWest,shinyRock);
        Scene crystalLake = new Scene(textNameCrystalLake,textDescriptionCrystalLake,textNameCrossroads,textCrystalLakeSouth,textCrystalLakeEast,textCrystalLakeWest);
        Scene wildernessRoad = new Scene(textNameWildernessRoad,textDescriptionWildernessRoad,textWildernessRoadNorth,textWildernessRoadSouth,textNameFelrockVillage,textNameCrossroads);
        /*
        Scene felrockVillage = new Scene("More trees forming another huge forest.","The dense forest of short trees continues to more south-eastern parts of the area.", "Cave Of Anguish: Exterior","Wild Road");
        Scene felrockTempleExterior = new Scene("The village's stone fountain is located right in the middle of the plateau.",
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
        handler.addScene(gardenOfRadiance);

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
        textNameCrystalLake = "Crystal Lake";
        textNameWildernessRoad = "Wilderness Road";
        textNameFelrockVillage = "Felrock Village";
        textNameFelrockTempleExterior = "Felrock Temple Exterior";
        textNameFelrockTempleInterior = "Felrock Temple Interior";
        textNameFelrockTownHallExterior = "Felrock Town Hall Exterior";
        textNameFelrockTownHallInteriorGroundFloor = "Felrock Town Hall Interior Ground Floor";
        textNameFelrockTownHallInteriorLobby = "Felrock Town Hall Interior Lobby";
        textNameFelrockTownHallInteriorFirstFloor = "Felrock Town Hall Interior First Floor";
        textNameFelrockTownHallInteriorSecondFloor = "Felrock Town Hall Interior Second Floor";
        textNameCaveOfAnguishExterior = "Cave Of Anguish Exterior";
        textNameCaveOfAnguishInterior = "Cave Of Anguish Interior";
        textNameClearing = "Clearing";
        textNameIceblueRiver = "Iceblue River";
        textNameGardenOfCorruption = "Garden Of Corruption";
        textNameGardenOfRadiance = "Garden Of Radiance";

        textDescriptionCampsite = "You grab your stuff and begin traveling to the NORTH,\n" +
                "while the night offers you the perfect cover from prying eyes.\n" +
                "You plan to arrive at Serenoth within 20 days,\n" +
                "unless something unexpected happens.";
        textCampsiteSouth = "You can't return home yet. The war still rages and the world needs a hero. Will you not be the one?";
        textCampsiteEast = "The Campsite is located in a rather rocky and mountainous scenery \n" +
                "so the only thing to see are some really big hills blocking your view to the far east.";
        textCampsiteWest = "Not much to see to the west, for the mighty hills hinder your sight \n" +
                "and the western part of this area remains unknown.";

        textDescriptionCrossroads = "The moment you leave the campsite you see the, one and only, road leading upwards, so you take it. \n" +
                "After a while you are facing a large crossroads and must decide which way to go.";
        textCrossroadsNorth = "There is nothing up to the north.";
        textCrossroadsWest = "A dimly lit and steep trail leads to a dark forest to the west. \n" +
                "It would, probably, be a good idea not to follow that road.";

        textDescriptionCrystalLake = "You head south following a downhill which leads you to a clearing. \n" +
                "A fairly big lake is located in the center of a, 10-feet diameter, overgrown field. \n" +
                "The water seems clean enough to be considered drinkable. \n" +
                "Coincidentally, you start feeling thirsty. \n" +
                "Seeing the abundance of water makes you think you could fill your flask from the lake.";
        textCrystalLakeSouth = "You can clearly see the Campsite from down here, despite being at a lower level. \n" +
                "Unfortunately, there is a steep slope that prevents you from going back that way.";
        textCrystalLakeEast = "There is nothing to see but trees and mountainsides.";
        textCrystalLakeWest = "The road that you took when you left the campsite is visible from here too.";
    }


}
