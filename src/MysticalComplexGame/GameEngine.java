package MysticalComplexGame;

import MysticalComplexGame.Commands.*;
import MysticalComplexGame.Items.*;
import MysticalComplexGame.Parser.*;

import java.io.*;
import java.util.Scanner;

public class GameEngine
{
    //CONTENT
    private static GameContent content;
    private static final Tokenizer tokenizer = new Tokenizer();
    private static final Parser parser = new Parser();

    public static void startGame()
    {
        //-----INTRO-----
        textOutput("ACT I - The Sage\n");
        textOutput("As the sun sets, the nightfall finds you getting ready for the upcoming journey to the far land of Serenoth.");
        textOutput("You must reach this region in order to find a great sage, who is the personal advisor of king Ecthelion, son of Exelion.");
        textOutput("This great sage often goes by many names, but one is more common to the people of Dal'aron, Zenthar");
        textOutput("He is against all the strife of the two kingdoms, for he knows what really happened two hundred years ago.");
        textOutput("But the two kings care for nothing than the dominion of their own might all over the world.");
        textOutput("This is why you need his help to convince king Ecthelion to cease his actions and withdraw his armies before its too late to stop this madness.");
        textOutput("Therefore...\n");

        content = new GameContent();
        String playerName = getPlayerName();
        File loadFile = new File(playerName.concat(".dat"));
        if (loadFile.isFile()) loadGame(playerName);
        else newGame(playerName);
        initializeConstants();
        //FIRST SCENE
        content.getPlayer().getLocation().printDescription();
        //GAME LOOP
        gameLoop(content.getPlayer());
    }
    private static String getPlayerName()
    {
        String name;
        textOutput("What is your name?");
        name = textInput();
        while(name.contains(":") || name.contains("*") || name.contains("?") || name.contains("\"") || name.contains("<") || name.contains(">") || name.contains("|") || name.contains("/") || name.contains("\\") || name.length()>16)
        {
            textOutput("The name must be up to 16 characters long and it cannot contain any of these characters: \\/:\"?*<>|:\nPlease input a different name:");
            name = textInput();
        }
        return  name;
    }

    private static void gameLoop(Player player)
    {
        //USER INPUT
        String userInputString;
        Scanner userInput;
        TokenStream tokenizedInput = new TokenStream();
        ParsedCommand nextCommand;
        //COMMAND PARSE
        do
        {
            tokenizedInput.clear();
            userInput = new Scanner(System.in);
            userInputString = userInput.nextLine().trim().toLowerCase();
            tokenizedInput = tokenizer.tokenize(userInputString);
            nextCommand = parser.parse(tokenizedInput, content);
            if (nextCommand.exists()) nextCommand.executeCommand(player);
            checkThirst(player);
            saveGame(player.getName());
        } while (!player.getLocation().getName().equals("Cave Of Anguish - Entrance"));
        textOutput("\n\n\nYou have completed ACT I!\n" +
                   "ACT II is under development, stay tuned for more...\n");
    }

    private static void checkThirst(Player player)
    {
        if (player.getThirstLevel() == 5) textOutput("\nYou begin to feel thirsty, you better find some water to drink soon or you'll probably die.");
        else if (player.getThirstLevel() == 0 )
        {
            textOutput("You fall to your knees from dehydration and...slowly.....die...\nRest in peace " + player.getName() + ", your deeds shall be remembered.");
            System.exit(-10);
        }
    }

    public static String textInput()
    {
        Scanner input;
        input = new Scanner(System.in);
        return input.nextLine().trim().toLowerCase();
    }

    public static void textOutput(String output)
    {
        System.out.println(output);
    }

    private static void initializeConstants()
    {
        // <editor-fold defaultstate="collapsed" desc="COMMANDS">
        content.initializeCommands();

        ICommand goCommand = new GoCommand();
        ICommand lookCommand = new LookCommand();
        ICommand pickCommand = new PickCommand();
        ICommand dropCommand = new DropCommand();
        ICommand inventoryCommand = new InventoryCommand();
        ICommand drinkCommand = new DrinkCommand();
        ICommand fillCommand = new FillCommand();
        ICommand readCommand = new ReadCommand();
        ICommand emptyCommand = new EmptyCommand();
        ICommand gazeCommand = new GazeCommand();
        ICommand writeCommand = new WriteCommand();
        ICommand equipCommand = new EquipCommand();
        ICommand unequipCommand = new UnequipCommand();
        ICommand attackCommand = new AttackCommand();
        ICommand lightCommand = new LightCommand();
        ICommand enterCommand = new EnterCommand();
        ICommand exitCommand = new ExitCommand();
        ICommand breakCommand = new BreakCommand();
        ICommand lootCommand = new LootCommand();
        ICommand quenchCommand = new QuenchCommand();
        ICommand attachCommand = new AttachCommand();

        content.addCommand(goCommand);
        content.addCommand(lookCommand);
        content.addCommand(pickCommand);
        content.addCommand(dropCommand);
        content.addCommand(inventoryCommand);
        content.addCommand(drinkCommand);
        content.addCommand(fillCommand);
        content.addCommand(readCommand);
        content.addCommand(emptyCommand);
        content.addCommand(gazeCommand);
        content.addCommand(writeCommand);
        content.addCommand(equipCommand);
        content.addCommand(unequipCommand);
        content.addCommand(attackCommand);
        content.addCommand(lightCommand);
        content.addCommand(enterCommand);
        content.addCommand(exitCommand);
        content.addCommand(breakCommand);
        content.addCommand(lootCommand);
        content.addCommand(quenchCommand);
        content.addCommand(attachCommand);

        tokenizer.addToken("go", Token.VERBWITHDIRECTION);
        tokenizer.addToken("gaze", Token.VERBWITHDIRECTION);

        tokenizer.addToken("look", Token.VERBSOLO);
        tokenizer.addToken("inventory", Token.VERBSOLO);
        tokenizer.addToken("unequip", Token.VERBSOLO);
        tokenizer.addToken("exit", Token.VERBSOLO);

        tokenizer.addToken("pick", Token.VERBWITHITEM);
        tokenizer.addToken("drop", Token.VERBWITHITEM);
        tokenizer.addToken("fill", Token.VERBWITHITEM);
        tokenizer.addToken("drink", Token.VERBWITHITEM);
        tokenizer.addToken("empty",Token.VERBWITHITEM);
        tokenizer.addToken("read",Token.VERBWITHITEM);
        tokenizer.addToken("write",Token.VERBWITHITEM);
        tokenizer.addToken("equip",Token.VERBWITHITEM);
        tokenizer.addToken("attack",Token.VERBWITHITEM);
        tokenizer.addToken("light",Token.VERBWITHITEM);
        tokenizer.addToken("enter",Token.VERBWITHITEM);
        tokenizer.addToken("break",Token.VERBWITHITEM);
        tokenizer.addToken("loot",Token.VERBWITHITEM);
        tokenizer.addToken("quench",Token.VERBWITHITEM);
        tokenizer.addToken("attach",Token.VERBWITHITEM);

        tokenizer.addToken("north",Token.DIRECTION);
        tokenizer.addToken("south",Token.DIRECTION);
        tokenizer.addToken("east",Token.DIRECTION);
        tokenizer.addToken("west",Token.DIRECTION);
        //</editor-fold>
        tokenizer.addToken("rock", Token.ITEM);
        tokenizer.addToken("flask",Token.ITEM);
        tokenizer.addToken("water",Token.ITEM);
        tokenizer.addToken("sign",Token.ITEM);
        tokenizer.addToken("papyrus",Token.ITEM);
        tokenizer.addToken("sword",Token.ITEM);
        tokenizer.addToken("luwin",Token.ITEM);
        tokenizer.addToken("cornelius",Token.ITEM);
        tokenizer.addToken("torch",Token.ITEM);
        tokenizer.addToken("barricade",Token.ITEM);
        tokenizer.addToken("temple",Token.ITEM);
        tokenizer.addToken("chamber",Token.ITEM);
        tokenizer.addToken("passage",Token.ITEM);
        tokenizer.addToken("hall",Token.ITEM);
        tokenizer.addToken("lobby",Token.ITEM);
        tokenizer.addToken("vase",Token.ITEM);
        tokenizer.addToken("coin",Token.ITEM);
        tokenizer.addToken("pebble",Token.ITEM);
        tokenizer.addToken("scroll",Token.ITEM);
        tokenizer.addToken("artifact",Token.ITEM);
        tokenizer.addToken("fountain",Token.ITEM);
        tokenizer.addToken("flint",Token.ITEM);
        tokenizer.addToken("steel",Token.ITEM);
        tokenizer.addToken("brazier",Token.ITEM);
        tokenizer.addToken("pass",Token.ITEM);
        tokenizer.addToken("hodor",Token.ITEM);

        tokenizer.addToken("shiny",Token.PREITEM);
        tokenizer.addToken("leather",Token.PREITEM);
        tokenizer.addToken("rusty",Token.PREITEM);
        tokenizer.addToken("lucky",Token.PREITEM);
        tokenizer.addToken("sacred",Token.PREITEM);
        tokenizer.addToken("rugged",Token.PREITEM);
        tokenizer.addToken("golden",Token.PREITEM);
        tokenizer.addToken("town",Token.PREITEM);
        tokenizer.addToken("secret",Token.PREITEM);
        tokenizer.addToken("hidden",Token.PREITEM);
        tokenizer.addToken("turquoise",Token.PREITEM);
        tokenizer.addToken("pink",Token.PREITEM);
        tokenizer.addToken("general",Token.PREITEM);
        tokenizer.addToken("token",Token.PREITEM);
        tokenizer.addToken("maester",Token.PREITEM);
    }

    private static void newGame(String s)
    {
        // <editor-fold defaultstate="collapsed" desc="SCRIPTS">
        String textNameCampsite = "Campsite";
        String textNameCrossroads = "Crossroads";
        String textNameCrystalLake = "Crystal Lake";
        String textNameWildernessRoad = "Wilderness Road";
        String textNameFelrockVillage = "Felrock Village";
        String textNameFelrockTempleEntrance = "Felrock Temple - Entrance";
        String textNameFelrockTemple = "Felrock Temple";
        String textNameFelrockTempleSecretChamber = "Felrock Temple - Secret Chamber";
        String textNameFelrockTempleHiddenPassage = "Felrock Temple - Hidden Passage";
        String textNameFelrockTownHallEntrance = "Felrock Town Hall - Entrance";
        String textNameFelrockTownHall = "Felrock Town Hall";
        String textNameFelrockTownHallLobby = "Felrock Town Hall - Lobby";
        String textNameFelrockTownHallFirstFloor = "Felrock Town Hall - First Floor";
        String textNameFelrockTownHallSecondFloor = "Felrock Town Hall - Second Floor";
        String textNameFelrockVillageExit = "Felrock Village - Exit";
        String textNameCaveOfAnguishEntrance = "Cave Of Anguish - Entrance";
        String textNameCaveOfAnguish = "Cave Of Anguish";
        String textNameClearing = "Clearing";
        String textNameIceblueRiver = "Iceblue River";
        String textNameBridgeOfSighs = "Bridge Of Sighs";
        String textNameGardenOfCorruption = "Garden Of Corruption";
        String textNameGardenOfRadiance = "Garden Of Radiance";

        String textDescriptionCampsite = "The camp is overwhelmed with deafening silence. \n" +
                "You and your comrades prepare your gear under the moonlight and the brightness of the stars. \n" +
                "You grab your stuff and decide to travel to the NORTH, while the night offers you the perfect cover from prying eyes. \n" +
                "You plan to arrive at Serenoth within the next 20 days.";
        String textCampsiteSouth = "You can't return home yet. The war still rages and the world needs a hero.";
        String textCampsiteNorth = "You better pack up before leaving the camp.";
        String textCampsiteEast = "The Campsite is located in a rather rocky and mountainous scenery \nso the only thing to see are some really big hills blocking your view to the far east.";
        String textCampsiteWest = "Not much to see to the west, for the mighty hills hinder your sight \nand the western part of this area remains unknown.";

        String textDescriptionCrossroads = "The moment you leave the campsite you see the, one and only, road leading upwards, so you take it.\n" +
                "After a while you are facing a large crossroads and must decide which way to go.";
        String textCrossroadsNorth = "A dimly lit and steep trail leads to a dark forest to the north. \nIt would, probably, be a good idea not to follow that road.";
        String textCrossroadsSouth = "The wooden barricade blocks your way and there's no way around.";

        String textDescriptionCrystalLake = "A fairly big lake is located in the center of a, 10-feet diameter, overgrown field.\n" +
                "The water seems clean enough to be considered drinkable. \nCoincidentally, you start feeling thirsty.";
        String textCrystalLakeSouth = "You can clearly see the Campsite from down here, despite being at a lower level. \nUnfortunately, there is a steep slope that prevents you from going back that way.";
        String textCrystalLakeEast = "There is nothing to see but trees and mountainsides.";
        String textCrystalLakeWest = "The road that you took when you left the campsite is visible from here too.";

        String textDescriptionWildernessRoad = "As you walk the east road, you begin to perceive a blurry landscape which, as it seems, consists by some kind of structures surrounded by tall trees.\n" +
                "The closer you get, the clearer it becomes. It seems you have arrived at a small, remote, yet peaceful village.";
        String textWildernessRoadNorth = "Not made yet.";
        String textWildernessRoadEast = "There is a sign, you'd better read it before you go there.";
        String textWildernessRoadSouth = "You can see the Crystal Lake fading away as you keep walking down that road. \nThe trees now block your sight as you leave the Campsite and the Crystal Lake behind.";

        String textDescriptionFelrockVillage = "You can clearly see some residencies and realise that this is a small village with a very few inhabitants.\n" +
                "To the south you can distinguish a great and majestic building which, judging from the decoration, size and location, must be the village's worship temple.\n" +
                "To the north, there lies a grand structure, of white and pale shades of brown which, considering the architecture that's been used and its position, must be the town hall.\n" +
                "To the east, your sight follows a path, quite narrow, leading somewhere far ahead, but you can't see exactly where.";

        String textDescriptionFelrockTempleEntrance = "You now stand in front of the temple.";
        String textFelrockTempleEntranceSouth = "The dense forest completely surrounds the village, providing a good defence at the same time.";
        String textFelrockTempleEntranceEast = "To your east are neatly built some residencies. \nIt's late in the afternoon so it would be a good idea not to disturb the villagers.";
        String textFelrockTempleEntranceWest = "To your west there are some trees and, further, the road which you came from.";

        String textDescriptionFelrockTemple = "You get in front of the gate and with a strong push you open it wide. \n" +
                "What you encounter is a bit more than surprising. \n" +
                "It seems like this temple has not been visited or used in any way for a long time. \n" +
                "Cobwebs in every corner, dusty benches and rusted metal candlesticks lie on the floor.";
        String textFelrockTempleNoPass = "You can't travel while inside the Temple";

        String textDescriptionFelrockTempleSecretChamber = "NOT MADE YET";
        String textFelrockTempleSecretChamberNoPass = "You can't travel inside the Temple";

        String textDescriptionFelrockTempleHiddenPassage = "NOT MADE YET";
        String textFelrockTempleHiddenPassageNoPass = "You can't travel inside the Temple";

        String textDescriptionFelrockTownHallEntrance = "Only by getting closer to the building, you can estimate how magnificent it truly is.";
        String textFelrockTownHallEntranceNorth = "More of a dense growth over there.";
        String textFelrockTownHallEntranceEast = "There's one weird road leading away from the village to your east.";
        String textFelrockTownHallEntranceWest = "Some more residencies are neatly built here.";

        String textDescriptionFelrockTownHall = "Surprisingly, the door requires a bit above than average force to open, \n" +
                "but with a tight grip and a strong push you manage to shove it aside. \n" +
                "On your left, a staircase extends all the way up, to the top of the Town Hall. \n" +
                "As far as you can see there are three floors, including the ground floor. \n" +
                "On your right and left there are several rooms, probably offices and storerooms.";
        String textFelrockTownHallNoPass = "You can't travel while inside the Town Hall.";

        String textDescriptionFelrockTownHallLobby = "Reluctantly, you get closer to the room and the voices are getting clearer.The two men hear your footsteps and stop at once.\n" +
                "When you reveal yourself they look at you with shirred eyes and a concerned expression. Now one of them is approaching you.\n" +
                "He is tall, wearing some kind of armour and holds a stick in his right hand. You sense that he could be a very strict character and probably a high-ranked member of the village's army.\n" +
                "He greets you with a brief introduction, telling you his name: General Patrick Eugene Cornelius and asking for yours.\n" +
                "You kindly introduce yourself to both as a member of the Guild of Resuscitation and ask to learn who the other man is.";
        String textFelrockTownHallLobbyNoPass = "You can't travel while inside the Town Hall.";

        String textDescriptionFelrockTownHallFirstFloor = "NOT MADE YET.";
        String textFelrockTownHallFirstFloorNoPass = "You can't travel while inside the Town Hall.";

        String textDescriptionFelrockTownHallSecondFloor = "You push the door to open but it won't budge. \nIt seems to be locked for the moment, though the right key would unlock it right away.";
        String textFelrockTownHallSecondFloorNoPass = "You can't travel while inside the Town Hall.";

        String textDescriptionFelrockVillageExit = "This is the eastern end of Felrock Village.";
        String textFelrockVillageExitNorth = "The village's outskirts, just trees and a rocky landscape.";
        String textFelrockVillageExitSouth = "The village's outskirts, just trees and a rocky landscape.";
        String textFelrockVillageExitEast = "The road is currently guarded by a husky man that won't let you pass. \"Hodor!\", he shouts.";


        String textDescriptionCaveOfAnguishEntrance = "From the roads leading away from the village you take the northern. \n" +
                "It's a relatively short road, not very wide, but neither too slim. \n" +
                "Unlike the village's scenery, here lies a barren landscape, with no trees, no flowers, no water either. \n" +
                "As the road seems to be coming to its end, you begin to sense an unsettling aura filling the space around you. \n" +
                "But what you witness further ahead is far worse. \n" +
                "The whole place is surrounded by a thick fog and an increased humidity fills the atmosphere. \n" +
                "A dark, blackish, rocky and extremely huge entrance stands before you. \n" +
                "It's been dug out by men, probably many, many years ago and it bears a sign, which is too clean to be older than a month, that tells: \n" +
                "\"WARNING! \n" +
                "You are about to enter the Cave of Anguish. \n" +
                "Death awaits all those who enter and all who have entered did not return. \n" +
                "Proceed at your own risk. \n" +
                "WARNING! \n" +
                "Now you can clearly feel dark energies emanating from the cave's insides. \n" +
                "Vision is blocked beyond the threshold of the entrance and since the mountain is massive you can't see past it, \n" +
                "for it spreads far to the east and a dense forest extends to the west.";
        String textCaveOfAnguishEntranceNorth = "The cave's dark hollow stands before you. Will you dare pass through?";
        String textCaveOfAnguishEntranceSouth = "The dense forest of short trees continues to more south-eastern parts of the area.";
        String textCaveOfAnguishEntranceEast = "There is nothing but rocks and hills there.";

        String textDescriptionCaveOfAnguish = "NOT MADE YET.";
        String textCaveOfAnguishNoPass = "You can't travel while inside the Cave";

        String textDescriptionClearing = "The bright light immediately blinds you for a while and now the gushing sound of water is louder.\n" +
                "After your vision is restored, what you see finally gives you peace after the horrors you encountered inside the cave.\n" +
                "Evidently, the noise was due to a fast-current river flowing from the east, continuing to the north and west,\n" +
                "but at some point making an abrupt turn and slipping down a steep cliff, forming a waterfall which falls several feet below.\n" +
                "To the west you see,yet again, some trees forming a sparse forest.\n" +
                "In between the forest and the riverbank is formed a dusty and rocky trail of dirt, splitting in half at some point.\n" +
                "One part is following the river's shore to the north and the other goes south through the forest.";
        String textClearingEast = "A steep cliff to your east creates a waterfall as the river falls below.";
        String textClearingWest = "To your west goes a trail of dirt, splitting in half, one part going north and the other south.";

        String textDescriptionIceblueRiver = "NOT MADE YET.";
        String textIceblueRiverEast = "The Iceblue River flows fiercely and fast.";
        String textIceblueRiverWest = "NOT MADE YET.";

        String textDescriptionBridgeOfSighs = "NOT MADE YET.";
        String textBridgeOfSighsNorth = "Something.";
        String textBridgeOfSighsSouth = "Something.";
        String textBridgeOfSighsEast = "The bridge is badly damaged and not safe to cross. You better find some resources to rebuild it.";

        String textDescriptionGardenOfCorruption = "NOT MADE YET.";
        String textGardenOfCorruptionNorth = "There's nothing you can see beyond this point.";
        String textGardenOfCorruptionSouth = "The Iceblue River flows fiercely, you can tell from the loud sound.";
        String textGardenOfCorruptionEast = "The Tree of Eternity seems corrupted and sick...";

        String textDescriptionGardenOfRadiance = "NOT MADE YET.";
        String textGardenOfRadianceNorth = "There's nothing you can see beyond this point.";
        String textGardenOfRadianceSouth = "The Iceblue River flows fiercely, you can tell from the loud sound.";
        String textGardenOfRadianceEast = "The Tree of Eternity has regained its radiance and looks truly magnificent!";

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="SCENES">
        Scene sceneCampsite = new Scene(textNameCampsite,textDescriptionCampsite);
        Scene sceneCrossroads = new Scene(textNameCrossroads,textDescriptionCrossroads);
        Scene sceneCrystalLake = new Scene(textNameCrystalLake,textDescriptionCrystalLake);
        Scene sceneWildernessRoad = new Scene(textNameWildernessRoad,textDescriptionWildernessRoad);
        Scene sceneFelrockVillage = new Scene(textNameFelrockVillage,textDescriptionFelrockVillage);
        Scene sceneFelrockTempleEntrance = new Scene(textNameFelrockTempleEntrance,textDescriptionFelrockTempleEntrance);
        Scene sceneFelrockTemple = new Scene(textNameFelrockTemple,textDescriptionFelrockTemple);
        Scene sceneFelrockTempleSecretChamber = new Scene(textNameFelrockTempleSecretChamber,textDescriptionFelrockTempleSecretChamber);
        Scene sceneFelrockTempleHiddenPassage = new Scene(textNameFelrockTempleHiddenPassage,textDescriptionFelrockTempleHiddenPassage);
        Scene sceneFelrockTownHallEntrance = new Scene(textNameFelrockTownHallEntrance,textDescriptionFelrockTownHallEntrance);
        Scene sceneFelrockTownHall = new Scene(textNameFelrockTownHall,textDescriptionFelrockTownHall);
        Scene sceneFelrockTownHallLobby = new Scene(textNameFelrockTownHallLobby,textDescriptionFelrockTownHallLobby);
        Scene sceneFelrockTownHallFirstFloor = new Scene(textNameFelrockTownHallFirstFloor,textDescriptionFelrockTownHallFirstFloor);
        Scene sceneFelrockTownHallSecondFloor = new Scene(textNameFelrockTownHallSecondFloor,textDescriptionFelrockTownHallSecondFloor);
        Scene sceneFelrockVillageExit = new Scene(textNameFelrockVillageExit,textDescriptionFelrockVillageExit);
        Scene sceneCaveOfAnguishEntrance = new Scene(textNameCaveOfAnguishEntrance,textDescriptionCaveOfAnguishEntrance);
        Scene sceneCaveOfAnguish = new Scene(textNameCaveOfAnguish,textDescriptionCaveOfAnguish);
        Scene sceneClearing = new Scene(textNameClearing,textDescriptionClearing);
        Scene sceneIceblueRiver = new Scene(textNameIceblueRiver,textDescriptionIceblueRiver);
        Scene sceneBridgeOfSighs = new Scene(textNameBridgeOfSighs,textDescriptionBridgeOfSighs);
        Scene sceneGardenOfCorruption = new Scene(textNameGardenOfCorruption,textDescriptionGardenOfCorruption);
        Scene sceneGardenOfRadiance = new Scene(textNameGardenOfRadiance,textDescriptionGardenOfRadiance);


        content.addScene(sceneCampsite);
        content.addScene(sceneCrossroads);
        content.addScene(sceneCrystalLake);
        content.addScene(sceneWildernessRoad);
        content.addScene(sceneFelrockVillage);
        content.addScene(sceneFelrockTempleEntrance);
        content.addScene(sceneFelrockTemple);
        content.addScene(sceneFelrockTempleSecretChamber);
        content.addScene(sceneFelrockTempleHiddenPassage);
        content.addScene(sceneFelrockTownHallEntrance);
        content.addScene(sceneFelrockTownHall);
        content.addScene(sceneFelrockTownHallLobby);
        content.addScene(sceneFelrockTownHallFirstFloor);
        content.addScene(sceneFelrockTownHallSecondFloor);
        content.addScene(sceneCaveOfAnguishEntrance);
        content.addScene(sceneCaveOfAnguish);
        content.addScene(sceneClearing);
        content.addScene(sceneIceblueRiver);
        content.addScene(sceneBridgeOfSighs);
        content.addScene(sceneGardenOfCorruption);
        content.addScene(sceneGardenOfRadiance);

        //</editor-fold>
        // <editor-fold defaultstate="collapsed" desc="CONNECTIONS">
        Connector connectionCampsiteNorth = new Connector(sceneCrossroads,textCampsiteNorth,"That was the last of your stuff, you should be ready to go.");
        Connector connectionCampsiteSouth = new Connector(textCampsiteSouth);
        Connector connectionCampsiteEast = new Connector(textCampsiteEast);
        Connector connectionCampsiteWest = new Connector(textCampsiteWest);

        Connector connectionCrossroadsNorth = new Connector(textCrossroadsNorth);
        Connector connectionCrossroadsSouth = new Connector(sceneCrystalLake,textCrossroadsSouth,"The road to the lake is now open!");
        Connector connectionCrossroadsEast = new Connector(sceneWildernessRoad);
        Connector connectionCrossroadsWest = new Connector(sceneCampsite);

        Connector connectionCrystalLakeNorth = new Connector(sceneCrossroads);
        Connector connectionCrystalLakeSouth = new Connector(textCrystalLakeSouth);
        Connector connectionCrystalLakeEast = new Connector(textCrystalLakeEast);
        Connector connectionCrystalLakeWest = new Connector(textCrystalLakeWest);

        Connector connectionWildernessRoadNorth = new Connector(textWildernessRoadNorth);
        Connector connectionWildernessRoadSouth = new Connector(textWildernessRoadSouth);
        Connector connectionWildernessRoadEast = new Connector(sceneFelrockVillage,textWildernessRoadEast,"Maybe you could rest and find useful information at that village.");
        Connector connectionWildernessRoadWest = new Connector(sceneCrossroads);

        Connector connectionFelrockVillageNorth = new Connector(sceneFelrockTownHallEntrance);
        Connector connectionFelrockVillageSouth = new Connector(sceneFelrockTempleEntrance);
        Connector connectionFelrockVillageEast = new Connector(sceneFelrockVillageExit);
        Connector connectionFelrockVillageWest = new Connector(sceneWildernessRoad);

        Connector connectionFelrockTempleEntranceNorth = new Connector(sceneFelrockVillage);
        Connector connectionFelrockTempleEntranceSouth = new Connector(textFelrockTempleEntranceSouth);
        Connector connectionFelrockTempleEntranceEast = new Connector(textFelrockTempleEntranceEast);
        Connector connectionFelrockTempleEntranceWest = new Connector(textFelrockTempleEntranceWest);

        Connector connectionFelrockTemple = new Connector(textFelrockTempleNoPass);

        Connector connectionFelrockTempleSecretChamber = new Connector(textFelrockTempleSecretChamberNoPass);

        Connector connectionFelrockTempleHiddenPassage = new Connector(textFelrockTempleHiddenPassageNoPass);

        Connector connectionFelrockTownHallEntranceNorth = new Connector(textFelrockTownHallEntranceNorth);
        Connector connectionFelrockTownHallEntranceSouth = new Connector(sceneFelrockVillage);
        Connector connectionFelrockTownHallEntranceEast = new Connector(textFelrockTownHallEntranceEast);
        Connector connectionFelrockTownHallEntranceWest = new Connector(textFelrockTownHallEntranceWest);

        Connector connectionFelrockTownHall = new Connector(textFelrockTownHallNoPass);

        Connector connectionFelrockTownHallLobby = new Connector(textFelrockTownHallLobbyNoPass);

        Connector connectionFelrockTownHallFirstFloor = new Connector(textFelrockTownHallFirstFloorNoPass);

        Connector connectionFelrockTownHallSecondFloor = new Connector(textFelrockTownHallSecondFloorNoPass);

        Connector connectionFelrockVillageExitNorth = new Connector(textFelrockVillageExitNorth);
        Connector connectionFelrockVillageExitSouth = new Connector(textFelrockVillageExitSouth);
        Connector connectionFelrockVillageExitEast = new Connector(sceneCaveOfAnguishEntrance,textFelrockVillageExitEast,"This should grant you access through the village's exit.");
        Connector connectionFelrockVillageExitWest = new Connector(sceneFelrockVillage);

        Connector connectionCaveOfAnguishEntranceNorth = new Connector(textCaveOfAnguishEntranceNorth);
        Connector connectionCaveOfAnguishEntranceSouth = new Connector(textCaveOfAnguishEntranceSouth);
        Connector connectionCaveOfAnguishEntranceEast = new Connector(textCaveOfAnguishEntranceEast);
        Connector connectionCaveOfAnguishEntranceWest = new Connector(sceneFelrockVillage);

        Connector connectionCaveOfAnguish = new Connector(textCaveOfAnguishNoPass);

        Connector connectionClearingNorth = new Connector(sceneIceblueRiver);
        Connector connectionClearingSouth = new Connector(sceneCaveOfAnguish);
        Connector connectionClearingEast = new Connector(textClearingEast);
        Connector connectionClearingWest = new Connector(textClearingWest);

        Connector connectionIceblueRiverNorth = new Connector(sceneBridgeOfSighs);
        Connector connectionIceblueRiverSouth = new Connector(sceneClearing);
        Connector connectionIceblueRiverEast = new Connector(textIceblueRiverEast);
        Connector connectionIceblueRiverWest = new Connector(textIceblueRiverWest);

        Connector connectionBridgeOfSighsNorth = new Connector(textBridgeOfSighsNorth);
        Connector connectionBridgeOfSighsSouth = new Connector(textBridgeOfSighsSouth);
        Connector connectionBridgeOfSighsEast = new Connector(sceneGardenOfCorruption,textBridgeOfSighsEast,"The bridge is finally repaired and ready to be crossed.");
        Connector connectionBridgeOfSighsWest = new Connector(sceneIceblueRiver);

        Connector connectionGardenOfCorruptionNorth = new Connector(textGardenOfCorruptionNorth);
        Connector connectionGardenOfCorruptionSouth = new Connector(textGardenOfCorruptionSouth);
        Connector connectionGardenOfCorruptionEast = new Connector(textGardenOfCorruptionEast);
        Connector connectionGardenOfCorruptionWest = new Connector(sceneBridgeOfSighs);

        Connector connectionGardenOfRadianceNorth = new Connector(textGardenOfRadianceNorth);
        Connector connectionGardenOfRadianceSouth = new Connector(textGardenOfRadianceSouth);
        Connector connectionGardenOfRadianceEast = new Connector(textGardenOfRadianceEast);
        Connector connectionGardenOfRadianceWest = new Connector(sceneBridgeOfSighs);

        //</editor-fold>
        // <editor-fold defaultstate="collapsed" desc="ITEMS">

        //GATEWAYS
        IItem templeEntrance = new GatewayItem("temple","The intense greenery around the stony temple seems to have been there long before it was built.\n" +
                "The entrance is huge and memorable and the gate is shut but probably unlocked.",sceneFelrockTemple,
                "You push and push, harder and harder, but the temple's entrance just won't open.\n" +
                "But wait! What is that tube that connects the brazier with the entrance's upper edge?",
                "A loud sound, some crackling and clinging and finally the temple's entrance is unlocked!",
                "Steams are emitting out of the tube's connectors and a secret mechanism is heard to be moving.\n" +
                        "The temple's entrance is probably powered by a complex, hidden mechanism, which started when you lit the brazier, that locks and unlocks it.");
        IItem secretChamber = new GatewayItem("secret chamber","On the leftmost section of the hall is a wide, flat surface on the wall that looks, weirdly enough, untouched by time or decay.\n" +
                "Also, on some points, you can detect some vertical, possibly man-made, engraves but you can't seem to understand their purpose.",sceneFelrockTempleSecretChamber,
                "You grope the flat surface of the leftmost wall, but can't find either a secret button nor any kind of lever or handle,\n" +
                "apart from some engraves that seem artificial and not random, though.",
                "You place the golden artifact at the exact spot, so that it matches perfectly with the engrave,\n" +
                "a locking sound is heard and then, almost immediately, a certain part of the wall starts to standout from the rest of it.\n" +
                "It was a secret chamber! And now it seems unlocked and able to be pushed aside...",
                "On the leftmost section of the hall is now located the secret chamber that you found earlier,\n" +
                        "with its entrance wide open and the golden artifact perfectly matched within its engraves.");
        IItem hiddenPassage = new GatewayItem("hidden passage","Further inside, there is an altar, with a pile of scriptures on top.",sceneFelrockTempleHiddenPassage,
                "You carefully examine your surroundings but nothing seems to be able to move to reveal a hidden passage.\n" +
                "Nothing but this strange altar. You can't really tell why, but the closer you are, the more you feel some kind of a cold spot or a slight breeze coming from around it.\n" +
                "Maybe from below...?",
                "As soon as you pick the torch, a clunking sound is heard, then a smashing one and then a loud noise, as though something stoney is being dragged across the floor.\n" +
                "Could it be? You have to see what's going on back there...",
                "Further inside, where the altar once stood, now a hidden passage is uncorked and a staircase leads to its interior.\n" +
                        "The altar is still there but moved horizontally aside.");
        IItem townHallEntrance = new GatewayItem("town hall","Its banners flutter as the wind passes through them.\n" +
                "It seems well preserved and, possibly, recently built or renovated.\n" +
                "It also has weird decorations all over its stony framework.\n" +
                "No one is entering or exiting the building since it's a small and quite village with a very low population.\n" +
                "But, surely, there will be someone inside.",sceneFelrockTownHall);
        IItem townHallLobby = new GatewayItem("lobby","Before you spreads a long hallway, ending up in a grand lobby.\n" +
                "While you examine your surroundings and trying to see what's on the top floors,\n" +
                "a low voice is heard in the distance, further onto your right, in what seems to be the lobby,\n" +
                "but the only words you can make out are: \"cave\" and \"corruption\".\n" +
                "At once, a different voice replies and you can only hear the words: \"dying\" and \"leave\". The conversation continues...",
                sceneFelrockTownHallLobby);

        //LOOTS
        IItem goldenArtifactItem = new GoldenArtifact((GatewayItem)secretChamber);
        IItem luckyCoinItem = new LuckyCoin();
        IItem turquoisePebbleItem = new TurquoisePebble();
        IItem pinkPebbleItem = new PinkPebble();

        //COMMONS
        IItem shinyRockItem = new ShinyRock();
        IItem waterItem = new WaterSource();
        IItem papyrusItem = new Papyrus();
        IItem sacredScrollItem = new SacredScroll();
        IItem rustySwordItem = new SimpleWeapon("rusty sword",1,2);
        IItem flintItem = new Flint();
        IItem steelItem = new Steel();

        //PATH BLOCKERS
        IItem flaskItem = new Flask(connectionCampsiteNorth,waterItem,10);
        IItem felrockSignItem = new FelrockSign(connectionWildernessRoadEast);
        IItem barricadeItem = new Barricade(connectionCrossroadsSouth);
        IItem brazierItem = new Brazier((GatewayItem)templeEntrance,flintItem,steelItem);
        IItem torchItem = new Torch((GatewayItem)hiddenPassage);
        IItem tokenPassItem = new TokenPass(connectionFelrockVillageExitEast);

        //CONTAINERS
        IItem vaseItem = new Vase(goldenArtifactItem);
        IItem felrockFountainItem = new FelrockFountain(luckyCoinItem,turquoisePebbleItem,pinkPebbleItem);

        //ENTITIES
        IItem luwinMaesterItem = new LuwinMaester();
        IItem generalCorneliusItem = new GeneralCornelius();
        IItem hodorItem = new Hodor();

        content.addItem(flaskItem);
        content.addItem(flintItem);
        content.addItem(steelItem);
        content.addItem(shinyRockItem);
        content.addItem(barricadeItem);
        content.addItem(waterItem);
        content.addItem(rustySwordItem);
        content.addItem(felrockSignItem);
        content.addItem(papyrusItem);
        content.addItem(felrockFountainItem);
        content.addItem(luckyCoinItem);
        content.addItem(turquoisePebbleItem);
        content.addItem(pinkPebbleItem);
        content.addItem(templeEntrance);
        content.addItem(brazierItem);
        content.addItem(vaseItem);
        content.addItem(goldenArtifactItem);
        content.addItem(secretChamber);
        content.addItem(torchItem);
        content.addItem(hiddenPassage);
        content.addItem(sacredScrollItem);
        content.addItem(townHallEntrance);
        content.addItem(townHallLobby);
        content.addItem(luwinMaesterItem);
        content.addItem(generalCorneliusItem);
        content.addItem(tokenPassItem);
        //</editor-fold>
        // <editor-fold defaultstate="collapsed" desc="ADD CONNECTIONS/ITEMS TO SCENES">
        sceneCampsite.addConnection(Direction.NORTH,connectionCampsiteNorth);
        sceneCampsite.addConnection(Direction.SOUTH,connectionCampsiteSouth);
        sceneCampsite.addConnection(Direction.EAST, connectionCampsiteEast);
        sceneCampsite.addConnection(Direction.WEST, connectionCampsiteWest);
        sceneCampsite.addItem(flaskItem);
        sceneCampsite.addItem(flintItem);
        sceneCampsite.addItem(steelItem);

        sceneCrossroads.addConnection(Direction.NORTH, connectionCrossroadsNorth);
        sceneCrossroads.addConnection(Direction.SOUTH, connectionCrossroadsSouth);
        sceneCrossroads.addConnection(Direction.EAST, connectionCrossroadsEast);
        sceneCrossroads.addConnection(Direction.WEST,connectionCrossroadsWest);
        sceneCrossroads.addItem(shinyRockItem);
        sceneCrossroads.addItem(barricadeItem);

        sceneCrystalLake.addConnection(Direction.NORTH, connectionCrystalLakeNorth);
        sceneCrystalLake.addConnection(Direction.SOUTH, connectionCrystalLakeSouth);
        sceneCrystalLake.addConnection(Direction.EAST,connectionCrystalLakeEast);
        sceneCrystalLake.addConnection(Direction.WEST,connectionCrystalLakeWest);
        sceneCrystalLake.addItem(waterItem);
        sceneCrystalLake.addItem(rustySwordItem);

        sceneWildernessRoad.addConnection(Direction.NORTH, connectionWildernessRoadNorth);
        sceneWildernessRoad.addConnection(Direction.SOUTH,connectionWildernessRoadSouth);
        sceneWildernessRoad.addConnection(Direction.EAST,connectionWildernessRoadEast);
        sceneWildernessRoad.addConnection(Direction.WEST,connectionWildernessRoadWest);
        sceneWildernessRoad.addItem(papyrusItem);
        sceneWildernessRoad.addItem(felrockSignItem);

        sceneFelrockVillage.addConnection(Direction.NORTH,connectionFelrockVillageNorth);
        sceneFelrockVillage.addConnection(Direction.SOUTH,connectionFelrockVillageSouth);
        sceneFelrockVillage.addConnection(Direction.EAST,connectionFelrockVillageEast);
        sceneFelrockVillage.addConnection(Direction.WEST, connectionFelrockVillageWest);
        sceneFelrockVillage.addItem(felrockFountainItem);

        sceneFelrockTempleEntrance.addConnection(Direction.NORTH,connectionFelrockTempleEntranceNorth);
        sceneFelrockTempleEntrance.addConnection(Direction.SOUTH,connectionFelrockTempleEntranceSouth);
        sceneFelrockTempleEntrance.addConnection(Direction.EAST,connectionFelrockTempleEntranceEast);
        sceneFelrockTempleEntrance.addConnection(Direction.WEST,connectionFelrockTempleEntranceWest);
        sceneFelrockTempleEntrance.addItem(templeEntrance);
        sceneFelrockTempleEntrance.addItem(brazierItem);

        sceneFelrockTemple.addConnection(Direction.NORTH,connectionFelrockTemple);
        sceneFelrockTemple.addConnection(Direction.SOUTH,connectionFelrockTemple);
        sceneFelrockTemple.addConnection(Direction.EAST,connectionFelrockTemple);
        sceneFelrockTemple.addConnection(Direction.WEST,connectionFelrockTemple);
        sceneFelrockTemple.addItem(vaseItem);
        sceneFelrockTemple.addItem(secretChamber);
        sceneFelrockTemple.addItem(hiddenPassage);

        sceneFelrockTempleSecretChamber.addConnection(Direction.NORTH,connectionFelrockTempleSecretChamber);
        sceneFelrockTempleSecretChamber.addConnection(Direction.SOUTH,connectionFelrockTempleSecretChamber);
        sceneFelrockTempleSecretChamber.addConnection(Direction.EAST,connectionFelrockTempleSecretChamber);
        sceneFelrockTempleSecretChamber.addConnection(Direction.WEST,connectionFelrockTempleSecretChamber);
        sceneFelrockTempleSecretChamber.addItem(torchItem);

        sceneFelrockTempleHiddenPassage.addConnection(Direction.NORTH,connectionFelrockTempleHiddenPassage);
        sceneFelrockTempleHiddenPassage.addConnection(Direction.SOUTH,connectionFelrockTempleHiddenPassage);
        sceneFelrockTempleHiddenPassage.addConnection(Direction.EAST,connectionFelrockTempleHiddenPassage);
        sceneFelrockTempleHiddenPassage.addConnection(Direction.WEST,connectionFelrockTempleHiddenPassage);
        sceneFelrockTempleHiddenPassage.addItem(sacredScrollItem);

        sceneFelrockTownHallEntrance.addConnection(Direction.NORTH,connectionFelrockTownHallEntranceNorth);
        sceneFelrockTownHallEntrance.addConnection(Direction.SOUTH,connectionFelrockTownHallEntranceSouth);
        sceneFelrockTownHallEntrance.addConnection(Direction.EAST,connectionFelrockTownHallEntranceEast);
        sceneFelrockTownHallEntrance.addConnection(Direction.WEST,connectionFelrockTownHallEntranceWest);
        sceneFelrockTownHallEntrance.addItem(townHallEntrance);

        sceneFelrockTownHall.addConnection(Direction.NORTH,connectionFelrockTownHall);
        sceneFelrockTownHall.addConnection(Direction.SOUTH,connectionFelrockTownHall);
        sceneFelrockTownHall.addConnection(Direction.EAST,connectionFelrockTownHall);
        sceneFelrockTownHall.addConnection(Direction.WEST,connectionFelrockTownHall);
        sceneFelrockTownHall.addItem(townHallLobby);

        sceneFelrockTownHallLobby.addConnection(Direction.NORTH,connectionFelrockTownHallLobby);
        sceneFelrockTownHallLobby.addConnection(Direction.SOUTH,connectionFelrockTownHallLobby);
        sceneFelrockTownHallLobby.addConnection(Direction.EAST,connectionFelrockTownHallLobby);
        sceneFelrockTownHallLobby.addConnection(Direction.WEST,connectionFelrockTownHallLobby);
        sceneFelrockTownHallLobby.addItem(luwinMaesterItem);
        sceneFelrockTownHallLobby.addItem(generalCorneliusItem);
        sceneFelrockTownHallLobby.addItem(tokenPassItem);

        sceneFelrockTownHallFirstFloor.addConnection(Direction.NORTH,connectionFelrockTownHallFirstFloor);
        sceneFelrockTownHallFirstFloor.addConnection(Direction.SOUTH,connectionFelrockTownHallFirstFloor);
        sceneFelrockTownHallFirstFloor.addConnection(Direction.EAST,connectionFelrockTownHallFirstFloor);
        sceneFelrockTownHallFirstFloor.addConnection(Direction.WEST,connectionFelrockTownHallFirstFloor);

        sceneFelrockTownHallSecondFloor.addConnection(Direction.NORTH,connectionFelrockTownHallSecondFloor);
        sceneFelrockTownHallSecondFloor.addConnection(Direction.SOUTH,connectionFelrockTownHallSecondFloor);
        sceneFelrockTownHallSecondFloor.addConnection(Direction.EAST,connectionFelrockTownHallSecondFloor);
        sceneFelrockTownHallSecondFloor.addConnection(Direction.WEST,connectionFelrockTownHallSecondFloor);

        sceneFelrockVillageExit.addConnection(Direction.NORTH,connectionFelrockVillageExitNorth);
        sceneFelrockVillageExit.addConnection(Direction.SOUTH,connectionFelrockVillageExitSouth);
        sceneFelrockVillageExit.addConnection(Direction.EAST,connectionFelrockVillageExitEast);
        sceneFelrockVillageExit.addConnection(Direction.WEST,connectionFelrockVillageExitWest);
        sceneFelrockVillageExit.addItem(hodorItem);

        sceneCaveOfAnguishEntrance.addConnection(Direction.NORTH,connectionCaveOfAnguishEntranceNorth);
        sceneCaveOfAnguishEntrance.addConnection(Direction.SOUTH,connectionCaveOfAnguishEntranceSouth);
        sceneCaveOfAnguishEntrance.addConnection(Direction.EAST,connectionCaveOfAnguishEntranceEast);
        sceneCaveOfAnguishEntrance.addConnection(Direction.WEST,connectionCaveOfAnguishEntranceWest);

        sceneCaveOfAnguish.addConnection(Direction.NORTH,connectionCaveOfAnguish);
        sceneCaveOfAnguish.addConnection(Direction.SOUTH,connectionCaveOfAnguish);
        sceneCaveOfAnguish.addConnection(Direction.WEST,connectionCaveOfAnguish);
        sceneCaveOfAnguish.addConnection(Direction.WEST,connectionCaveOfAnguish);

        sceneClearing.addConnection(Direction.NORTH,connectionClearingNorth);
        sceneClearing.addConnection(Direction.SOUTH,connectionClearingSouth);
        sceneClearing.addConnection(Direction.EAST,connectionClearingEast);
        sceneClearing.addConnection(Direction.WEST,connectionClearingWest);

        sceneIceblueRiver.addConnection(Direction.NORTH,connectionIceblueRiverNorth);
        sceneIceblueRiver.addConnection(Direction.SOUTH,connectionIceblueRiverSouth);
        sceneIceblueRiver.addConnection(Direction.EAST,connectionIceblueRiverEast);
        sceneIceblueRiver.addConnection(Direction.WEST,connectionIceblueRiverWest);

        sceneBridgeOfSighs.addConnection(Direction.NORTH,connectionBridgeOfSighsNorth);
        sceneBridgeOfSighs.addConnection(Direction.SOUTH,connectionBridgeOfSighsSouth);
        sceneBridgeOfSighs.addConnection(Direction.EAST,connectionBridgeOfSighsEast);
        sceneBridgeOfSighs.addConnection(Direction.WEST,connectionBridgeOfSighsWest);

        sceneGardenOfCorruption.addConnection(Direction.NORTH,connectionGardenOfCorruptionNorth);
        sceneGardenOfCorruption.addConnection(Direction.SOUTH,connectionGardenOfCorruptionSouth);
        sceneGardenOfCorruption.addConnection(Direction.EAST,connectionGardenOfCorruptionEast);
        sceneGardenOfCorruption.addConnection(Direction.WEST,connectionGardenOfCorruptionWest);

        sceneGardenOfRadiance.addConnection(Direction.NORTH,connectionGardenOfRadianceNorth);
        sceneGardenOfRadiance.addConnection(Direction.SOUTH,connectionGardenOfRadianceSouth);
        sceneGardenOfRadiance.addConnection(Direction.EAST,connectionGardenOfRadianceEast);
        sceneGardenOfRadiance.addConnection(Direction.WEST,connectionGardenOfRadianceWest);

        //</editor-fold>
        Player player = new Player();
        player.setName(s);
        content.setPlayer(player);
        player.setLocation(sceneCampsite);
    }

    private static void loadGame(String s)
    {
        String saveName = s.concat(".dat");
        try
        {
            FileInputStream loadFile = new FileInputStream(saveName);
            BufferedInputStream loadBuffer = new BufferedInputStream(loadFile);
            ObjectInputStream loadObject = new ObjectInputStream(loadBuffer);
            content = (GameContent)loadObject.readObject();
            loadObject.close();
            GameEngine.textOutput("Loaded \"" + s + "\".");
        }catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private static void saveGame(String s)
    {
        String saveName = s.concat(".dat");
        try
        {
            FileOutputStream saveFile = new FileOutputStream(saveName);
            BufferedOutputStream saveBuffer = new BufferedOutputStream(saveFile);
            ObjectOutputStream saveObject = new ObjectOutputStream(saveBuffer);
            saveObject.writeObject(content);
            saveObject.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
