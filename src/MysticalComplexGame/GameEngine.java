package MysticalComplexGame;

import MysticalComplexGame.Commands.*;
import MysticalComplexGame.Items.*;
import MysticalComplexGame.Parser.*;

import java.io.*;
import java.util.Scanner;

public class GameEngine
{
    //CONTENT
    static GameContent content;
    static Tokenizer tokenizer = new Tokenizer();
    static Parser parser = new Parser();

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
            if (nextCommand != null) nextCommand.executeCommand(player);
            checkThirst(player);
            saveGame(player.getName());
        } while (!player.getLocation().getName().equals("The Sage"));
        textOutput("\n\n\nYou have completed ACT I, ACT II is under development, stay tuned for more...\n");
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

        ICommand go = new GoCommand();
        ICommand look = new LookCommand();
        ICommand pick = new PickCommand();
        ICommand drop = new DropCommand();
        ICommand inventory = new InventoryCommand();
        ICommand drink = new DrinkCommand();
        ICommand fill = new FillCommand();
        ICommand read = new ReadCommand();
        ICommand empty = new EmptyCommand();
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

        content.addCommand(go);
        content.addCommand(look);
        content.addCommand(pick);
        content.addCommand(drop);
        content.addCommand(inventory);
        content.addCommand(drink);
        content.addCommand(fill);
        content.addCommand(read);
        content.addCommand(empty);
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

        tokenizer.addToken("go", Token.VERBDIRECTION);
        tokenizer.addToken("gaze", Token.VERBDIRECTION);

        tokenizer.addToken("look", Token.VERBSOLO);
        tokenizer.addToken("inventory", Token.VERBSOLO);
        tokenizer.addToken("unequip", Token.VERBSOLO);
        tokenizer.addToken("exit",Token.VERBSOLO);

        tokenizer.addToken("pick", Token.VERBITEM);
        tokenizer.addToken("drop",Token.VERBITEM);
        tokenizer.addToken("fill",Token.VERBITEM);
        tokenizer.addToken("drink",Token.VERBITEM);
        tokenizer.addToken("empty",Token.VERBITEM);
        tokenizer.addToken("read",Token.VERBITEM);
        tokenizer.addToken("write",Token.VERBITEM);
        tokenizer.addToken("equip",Token.VERBITEM);
        tokenizer.addToken("attack",Token.VERBITEM);
        tokenizer.addToken("light",Token.VERBITEM);
        tokenizer.addToken("enter",Token.VERBITEM);
        tokenizer.addToken("break",Token.VERBITEM);
        tokenizer.addToken("loot",Token.VERBITEM);
        tokenizer.addToken("quench",Token.VERBITEM);

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
        tokenizer.addToken("advisor",Token.ITEM);
        tokenizer.addToken("torch",Token.ITEM);
        tokenizer.addToken("barricade",Token.ITEM);
        tokenizer.addToken("temple",Token.ITEM);
        tokenizer.addToken("hall",Token.ITEM);
        tokenizer.addToken("vase",Token.ITEM);
        tokenizer.addToken("coin",Token.ITEM);
        tokenizer.addToken("scroll",Token.ITEM);
        tokenizer.addToken("artifact",Token.ITEM);
        tokenizer.addToken("fountain",Token.ITEM);
        tokenizer.addToken("flint",Token.ITEM);
        tokenizer.addToken("steel",Token.ITEM);
        tokenizer.addToken("brazier",Token.ITEM);

        tokenizer.addToken("shiny",Token.PREITEM);
        tokenizer.addToken("leather",Token.PREITEM);
        tokenizer.addToken("rusty",Token.PREITEM);
        tokenizer.addToken("lucky",Token.PREITEM);
        tokenizer.addToken("sacred",Token.PREITEM);
        tokenizer.addToken("rugged",Token.PREITEM);
        tokenizer.addToken("golden",Token.PREITEM);
        tokenizer.addToken("town",Token.PREITEM);
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
        String textNameFelrockTownHallEntrance = "Felrock Town Hall - Entrance";
        String textNameFelrockTownHall = "Felrock Town Hall";
        String textNameFelrockTownHallLobby = "Felrock Town Hall - Lobby";
        String textNameFelrockTownHallFirstFloor = "Felrock Town Hall - First Floor";
        String textNameFelrockTownHallSecondFloor = "Felrock Town Hall - Second Floor";
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
        String textCrossroadsWest = "There lies the path you came from, you should continue your journey.";
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
        String textFelrockVillageEast = "The road is currently guarded by a husky man that won't let you pass until you present to him a special license, signed by the village mayor.";

        String textDescriptionFelrockTempleEntrance = "You now stand in front of the temple.";
        String textFelrockTempleEntranceSouth = "The dense forest completely surrounds the village, providing a good defence at the same time.";
        String textFelrockTempleEntranceEast = "To your east are neatly built some residencies. \nIt's late in the afternoon so it would be a good idea not to disturb the villagers.";
        String textFelrockTempleEntranceWest = "To your west there are some trees and, further, the road which you came from.";

        String textDescriptionFelrockTemple = "You get in front of the gate and with a strong push you open it wide. \n" +
                "What you encounter is a bit more than surprising. \n" +
                "It seems like this temple has not been visited or used in any way for a long time. \n" +
                "Cobwebs in every corner, dusty benches and rusted metal candlesticks lie on the floor. \n" +
                "Further inside, there is an altar, with a pile of scriptures on top. \n" +
                "On the leftmost section of the hall is a wide, flat surface on the wall \n" +
                "that looks, weirdly enough, untouched by time or decay. \n" +
                "Also, on some points, you can detect some vertical, possibly man-made, engraves \n" +
                "but you can't seem to understand their purpose.";
        String textFelrockTempleNoPass = "You can't travel while inside the Temple";

        String textDescriptionFelrockTownHallEntrance = "Only by getting closer to the building, you can estimate how magnificent it truly is. \n" +
                "Its banners flutter as the wind passes through them. \n" +
                "It seems well preserved and, possibly, recently built or renovated. \n" +
                "It also has weird decorations all over its stony framework. \n" +
                "No one is entering or exiting the building since it's a small and quite village with a very low population. \n" +
                "But, surely, there will be someone inside.";
        String textFelrockTownHallEntranceNorth = "More of a dense growth over there.";
        String textFelrockTownHallEntranceEast = "There's one weird road leading away from the village to your east.";
        String textFelrockTownHallEntranceWest = "Some more residencies are neatly built here.";

        String textDescriptionFelrockTownHall = "Surprisingly, the door requires a bit above than average force to open, \n" +
                "but with a tight grip and a strong push you manage to shove it aside. \n" +
                "Before you spreads a long hallway, ending up in a grand lobby. \n" +
                "On your left, a staircase extends all the way up, to the top of the Town Hall. \n" +
                "As far as you can see there are three floors, including the ground floor. \n" +
                "On your right and left there are several rooms, probably offices and storerooms. \n" +
                "While you examine your surroundings and trying to see what's on the top floors, a low voice is heard in the distance, further onto your right, in what seems to be the lobby. \n" +
                "but the only words you can make out are: \"cave\" and \"corruption\". \n" +
                "At once, a different voice replies and you can only hear the words: \"dying\" and \"leave\". \n" +
                "The conversation continues...";
        String textFelrockTownHallNoPass = "You can't travel while inside the Town Hall.";

        String textDescriptionFelrockTownHallLobby = "Reluctantly, you get closer to the room and the voices are getting clearer. \n" +
                "The two men hear your footsteps and stop at once. \n" +
                "When you reveal yourself they look at you with shirred eyes and a concerned expression. \n" +
                "Now one of them is approaching you. He is tall, wearing some kind of armour and holds a stick in his right hand. \n" +
                "You sense that he could be a very strict character and probably a high-ranked member of the village's army. \n" +
                "He greets you with a brief introduction, telling you his name: \"General Patrick Eugene Cornelius\" and asking for yours. \n" +
                "You kindly introduce yourself to both as a member of the Guild of Resuscitation and ask to learn who the other man is.\n" +
                "He is significantly shorter than General Cornelius and wears neat and elegant clothes making him very prestigious. \n" +
                "He holds a small case in his hands. His name is Luwin Maester. \n" +
                "He tells you that he is the mayor's advisor. But when you ask to know where the mayor himself is, \n" +
                "General Cornelius tells you that he's gone missing for a few days now.";
        String textFelrockTownHallLobbyNoPass = "You can't travel while inside the Town Hall.";

        String textDescriptionFelrockTownHallFirstFloor = "NOT MADE YET.";
        String textFelrockTownHallFirstFloorNoPass = "You can't travel while inside the Town Hall.";

        String textDescriptionFelrockTownHallSecondFloor = "You push the door to open but it won't budge. \nIt seems to be locked for the moment, though the right key would unlock it right away.";
        String textFelrockTownHallSecondFloorNoPass = "You can't travel while inside the Town Hall.";

        String textDescriptionCaveOfAnguishEntrance = "From the roads leading away from the village you take the northern. +\n" +
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
                " There are also two medium sized torches placed on each side of the cave's entrance that burn bright. \n" +
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
        Scene sceneFelrockTownHallEntrance = new Scene(textNameFelrockTownHallEntrance,textDescriptionFelrockTownHallEntrance);
        Scene sceneFelrockTownHall = new Scene(textNameFelrockTownHall,textDescriptionFelrockTownHall);
        Scene sceneFelrockTownHallLobby = new Scene(textNameFelrockTownHallLobby,textDescriptionFelrockTownHallLobby);
        Scene sceneFelrockTownHallFirstFloor = new Scene(textNameFelrockTownHallFirstFloor,textDescriptionFelrockTownHallFirstFloor);
        Scene sceneFelrockTownHallSecondFloor = new Scene(textNameFelrockTownHallSecondFloor,textDescriptionFelrockTownHallSecondFloor);
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
        Connector connectionCrossroadsWest = new Connector(textCrossroadsWest);

        Connector connectionCrystalLakeNorth = new Connector(sceneCrossroads);
        Connector connectionCrystalLakeSouth = new Connector(textCrystalLakeSouth);
        Connector connectionCrystalLakeEast = new Connector(textCrystalLakeEast);
        Connector connectionCrystalLakeWest = new Connector(textCrystalLakeWest);

        Connector connectionWildernessRoadNorth = new Connector(textWildernessRoadNorth);
        Connector connectionWildernessRoadSouth = new Connector(textWildernessRoadSouth);
        Connector connectionWildernessRoadEast = new Connector(sceneFelrockVillage,textWildernessRoadEast,"You should take a look at that village");
        Connector connectionWildernessRoadWest = new Connector(sceneCrossroads);

        Connector connectionFelrockVillageNorth = new Connector(sceneFelrockTownHallEntrance);
        Connector connectionFelrockVillageSouth = new Connector(sceneFelrockTempleEntrance);
        Connector connectionFelrockVillageEast = new Connector(sceneCaveOfAnguishEntrance,textFelrockVillageEast,"The husky guard speaks: \"You may pass little one. But know that no good resides further ahead.\"");
        Connector connectionFelrockVillageWest = new Connector(sceneWildernessRoad);

        Connector connectionFelrockTempleEntranceNorth = new Connector(sceneFelrockVillage);
        Connector connectionFelrockTempleEntranceSouth = new Connector(textFelrockTempleEntranceSouth);
        Connector connectionFelrockTempleEntranceEast = new Connector(textFelrockTempleEntranceEast);
        Connector connectionFelrockTempleEntranceWest = new Connector(textFelrockTempleEntranceWest);

        Connector connectionFelrockTemple = new Connector(textFelrockTempleNoPass);

        Connector connectionFelrockTownHallEntranceNorth = new Connector(textFelrockTownHallEntranceNorth);
        Connector connectionFelrockTownHallEntranceSouth = new Connector(sceneFelrockVillage);
        Connector connectionFelrockTownHallEntranceEast = new Connector(textFelrockTownHallEntranceEast);
        Connector connectionFelrockTownHallEntranceWest = new Connector(textFelrockTownHallEntranceWest);

        Connector connectionFelrockTownHall = new Connector(textFelrockTownHallNoPass);

        Connector connectionFelrockTownHallLobby = new Connector(textFelrockTownHallLobbyNoPass);

        Connector connectionFelrockTownHallFirstFloor = new Connector(textFelrockTownHallFirstFloorNoPass);

        Connector connectionFelrockTownHallSecondFloor = new Connector(textFelrockTownHallSecondFloorNoPass);

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

        //LOOTS
        IItem goldenArtifactItem = new GoldenArtifact();
        IItem luckyCoinItem = new LuckyCoin();

        //PATH BLOCKERS
        IItem flaskItem = new Flask(LiquidContainerState.EMPTY,connectionCampsiteNorth);
        IItem felrockSignItem = new FelrockSign(connectionWildernessRoadEast);
        IItem barricadeItem = new Barricade(connectionCrossroadsSouth);

        //COMMONS
        IItem shinyRockItem = new ShinyRock();
        IItem waterItem = new WaterSource();
        IItem fireItem = new FireSource();
        IItem papyrusItem = new Papyrus();
        IItem sacredScrollItem = new SacredScroll();
        IItem rustySwordItem = new SimpleWeapon("rusty sword",1,2);
        IItem torchItem = new Torch(LightEmitterState.LIT);
        IItem flintItem = new Flint();
        IItem steelItem = new Steel();
        IItem brazierItem = new Brazier(LightEmitterState.QUENCHED);

        //CONTAINERS
        IItem vaseItem = new Vase(goldenArtifactItem);
        IItem felrockFountainItem = new FelrockFountain(luckyCoinItem);

        //ENTITIES
        IItem advisorItem = new Advisor();

        //GATEWAYS
        IItem templeEntrance = new GatewayItem("temple","The intense greenery around the stony temple seems to have been there long before it was built.\nThe entrance is huge and memorable and the gate is shut but probably unlocked.",sceneFelrockTemple);
        IItem townHallEntrance = new GatewayItem("town hall","Only by getting closer to the building, you can estimate how magnificent it truly is.\n" +
                "Its banners flutter as the wind passes through them.\n" +
                "It seems well preserved and, possibly, recently built or renovated.\n" +
                "It also has weird decorations all over its stony framework.\n" +
                "No one is entering or exiting the building since it's a small and quite village with a very low population.\n" +
                "But, surely, there will be someone inside.",sceneFelrockTownHall);

        content.addItem(shinyRockItem);
        content.addItem(flaskItem);
        content.addItem(waterItem);
        content.addItem(fireItem);
        content.addItem(felrockSignItem);
        content.addItem(papyrusItem);
        content.addItem(rustySwordItem);
        content.addItem(advisorItem);
        content.addItem(barricadeItem);
        content.addItem(felrockFountainItem);
        content.addItem(templeEntrance);
        content.addItem(townHallEntrance);
        content.addItem(vaseItem);
        content.addItem(goldenArtifactItem);
        content.addItem(luckyCoinItem);
        content.addItem(sacredScrollItem);
        content.addItem(torchItem);
        content.addItem(flintItem);
        content.addItem(steelItem);
        content.addItem(brazierItem);

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

        sceneFelrockTownHallEntrance.addConnection(Direction.NORTH,connectionFelrockTownHallEntranceNorth);
        sceneFelrockTownHallEntrance.addConnection(Direction.SOUTH,connectionFelrockTownHallEntranceSouth);
        sceneFelrockTownHallEntrance.addConnection(Direction.EAST,connectionFelrockTownHallEntranceEast);
        sceneFelrockTownHallEntrance.addConnection(Direction.WEST,connectionFelrockTownHallEntranceWest);
        sceneFelrockTownHallEntrance.addItem(townHallEntrance);

        sceneFelrockTownHall.addConnection(Direction.NORTH,connectionFelrockTownHall);
        sceneFelrockTownHall.addConnection(Direction.SOUTH,connectionFelrockTownHall);
        sceneFelrockTownHall.addConnection(Direction.EAST,connectionFelrockTownHall);
        sceneFelrockTownHall.addConnection(Direction.WEST,connectionFelrockTownHall);

        sceneFelrockTownHallLobby.addConnection(Direction.NORTH,connectionFelrockTownHallLobby);
        sceneFelrockTownHallLobby.addConnection(Direction.SOUTH,connectionFelrockTownHallLobby);
        sceneFelrockTownHallLobby.addConnection(Direction.EAST,connectionFelrockTownHallLobby);
        sceneFelrockTownHallLobby.addConnection(Direction.WEST,connectionFelrockTownHallLobby);

        sceneFelrockTownHallFirstFloor.addConnection(Direction.NORTH,connectionFelrockTownHallFirstFloor);
        sceneFelrockTownHallFirstFloor.addConnection(Direction.SOUTH,connectionFelrockTownHallFirstFloor);
        sceneFelrockTownHallFirstFloor.addConnection(Direction.EAST,connectionFelrockTownHallFirstFloor);
        sceneFelrockTownHallFirstFloor.addConnection(Direction.WEST,connectionFelrockTownHallFirstFloor);

        sceneFelrockTownHallSecondFloor.addConnection(Direction.NORTH,connectionFelrockTownHallSecondFloor);
        sceneFelrockTownHallSecondFloor.addConnection(Direction.SOUTH,connectionFelrockTownHallSecondFloor);
        sceneFelrockTownHallSecondFloor.addConnection(Direction.EAST,connectionFelrockTownHallSecondFloor);
        sceneFelrockTownHallSecondFloor.addConnection(Direction.WEST,connectionFelrockTownHallSecondFloor);

        sceneCaveOfAnguishEntrance.addConnection(Direction.NORTH,connectionCaveOfAnguishEntranceNorth);
        sceneCaveOfAnguishEntrance.addConnection(Direction.SOUTH,connectionCaveOfAnguishEntranceSouth);
        sceneCaveOfAnguishEntrance.addConnection(Direction.EAST,connectionCaveOfAnguishEntranceEast);
        sceneCaveOfAnguishEntrance.addConnection(Direction.WEST,connectionCaveOfAnguishEntranceWest);
        sceneCaveOfAnguishEntrance.addItem(torchItem);

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
