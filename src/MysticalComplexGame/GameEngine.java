package MysticalComplexGame;

import MysticalComplexGame.Commands.*;
import MysticalComplexGame.Items.Flask;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.ShinyRock;

import java.util.Scanner;

public class GameEngine
{

    public void startGame()
    {
        // <editor-fold defaultstate="collapsed" desc="TEXTS">
        String textNameCampsite = "Campsite";
        String textNameCrossroads = "Crossroads";
        String textNameCrystalLake = "Crystal Lake";
        String textNameWildernessRoad = "Wilderness Road";
        String textNameFelrockVillage = "Felrock Village";
        String textNameFelrockTempleExterior = "Felrock Temple Exterior";
        String textNameFelrockTempleInterior = "Felrock Temple Interior";
        String textNameFelrockTownHallExterior = "Felrock Town Hall Exterior";
        String textNameFelrockTownHallInteriorGroundFloor = "Felrock Town Hall Interior Ground Floor";
        String textNameFelrockTownHallInteriorLobby = "Felrock Town Hall Interior Lobby";
        String textNameFelrockTownHallInteriorFirstFloor = "Felrock Town Hall Interior First Floor";
        String textNameFelrockTownHallInteriorSecondFloor = "Felrock Town Hall Interior Second Floor";
        String textNameCaveOfAnguishExterior = "Cave Of Anguish Exterior";
        String textNameCaveOfAnguishInterior = "Cave Of Anguish Interior";
        String textNameClearing = "Clearing";
        String textNameIceblueRiver = "Iceblue River";
        String textNameGardenOfCorruption = "Garden Of Corruption";
        String textNameGardenOfRadiance = "Garden Of Radiance";

        String textDescriptionCampsite = "You grab your stuff and begin traveling to the NORTH,\nwhile the night offers you the perfect cover from prying eyes.\nYou plan to arrive at Serenoth within the next 20 days";
        String textCampsiteSouth = "You can't return home yet. The war still rages and the world needs a hero.";
        String textCampsiteEast = "The Campsite is located in a rather rocky and mountainous scenery \nso the only thing to see are some really big hills blocking your view to the far east.";
        String textCampsiteWest = "Not much to see to the west, for the mighty hills hinder your sight \nand the western part of this area remains unknown.";

        String textDescriptionCrossroads = "The moment you leave the campsite you see the, one and only, road leading upwards, so you take it.\nAfter a while you are facing a large crossroads and must decide which way to go.";
        String textCrossroadsNorth = "A dimly lit and steep trail leads to a dark forest to the west. \nIt would, probably, be a good idea not to follow that road.";
        String textCrossroadsWest = "There lies the path you came from, you should continue your journey.";

        String textDescriptionCrystalLake = "A fairly big lake is located in the center of a, 10-feet diameter, overgrown field.\nThe water seems clean enough to be considered drinkable. \nCoincidentally, you start feeling thirsty.";
        String textCrystalLakeSouth = "You can clearly see the Campsite from down here, despite being at a lower level. \nUnfortunately, there is a steep slope that prevents you from going back that way.";
        String textCrystalLakeEast = "There is nothing to see but trees and mountainsides.";
        String textCrystalLakeWest = "The road that you took when you left the campsite is visible from here too.";

        String textDescriptionWildernessRoad = "As you walk the east road, you begin to perceive a blurry landscape which, as it seems, consists by some kind of structures surrounded by tall trees.\nThe closer you get, the clearer it becomes. It seems you have arrived at a small, remote, yet peaceful village. \nAt the end of the path you see a sign reading \"Felrock Village\".";
        String textWildernessRoadNorth = "Not made yet.";
        String textWildernessRoadSouth = "You can see the Crystal Lake fading away as you keep walking down that road. \nThe trees now block your sight as you leave the Campsite and the Crystal Lake behind.";

        String textDescriptionFelrockVillage = "You can clearly see some residencies and realise that this is a small village with a very few inhabitants.\n" +
                "There is a very big, simple, stone fountain in the middle of the village, spouting crystal clear water from its holes.\n" +
                "On its east you can distinguish a great and majestic building which, judging from the decoration, size and location, must be the village's worship temple.\n" +
                "On the west, there lies a grand structure, of white and pale shades of brown which, considering the architecture that's been used and its position, must be the town hall.\nTo the north, your sight follows a path, quite narrow, leading somewhere far ahead, but you can't see exactly where.";

        String textDescriptionFelrockTempleExterior = "You now stand in front of the temple. \nThe intense greenery around the temple seems to have been there long before it was built. \nThe entrance is huge and memorable and the gate is shut but probably unlocked.";
        String textFelrockTempleExteriorSouth = "The dense forest completely surrounds the village, providing a good defence at the same time.";
        String textFelrockTempleExteriorEast = "To your east are neatly built some residencies. \nIt's late in the afternoon so it would be a good idea not to disturb the villagers.";
        String textFelrockTempleExteriorWest = "To your west there are some trees and, further, the road which you came from.";

        String textDescriptionFelrockTempleInterior = "You get in front of the gate and with a strong push you open it wide. \n" +
                "What you encounter is a bit more than surprising. \n" +
                "It seems like this temple has not been visited or used in any way for a long time. \n" +
                "Cobwebs in every corner, dusty benches and rusted metal candlesticks lie on the floor. \n" +
                "Further inside, there is an altar, with a pile of scriptures on top. \n" +
                "On the leftmost section of the hall is a wide, flat surface on the wall \n" +
                "that looks, weirdly enough, untouched by time or decay. \n" +
                "Also, on some points, you can detect some vertical, possibly man-made, engraves \n" +
                "but you can't seem to understand their purpose.";
        String textFelrockTempleInteriorNorth = "You can't travel while inside the Temple.";
        String textFelrockTempleInteriorSouth = "You can't travel while inside the Temple.";
        String textFelrockTempleInteriorEast = "You can't travel while inside the Temple.";
        String textFelrockTempleInteriorWest = "You can't travel while inside the Temple.";

        String textDescriptionFelrockTownHallExterior = "Only by getting closer to the building, you can estimate how magnificent it truly is. \n" +
                "Its banners flutter as the wind passes through them. \n" +
                "It seems well preserved and, possibly, recently built or renovated. \n" +
                "It also has weird decorations all over its stony framework. \n" +
                "No one is entering or exiting the building since it's a small and quite village with a very low population. \n" +
                "But, surely, there will be someone inside.";
        String textFelrockTownHallExteriorNorth = "More of a dense growth over there.";
        String textFelrockTownHallExteriorEast = "There's one weird road leading away from the village to your east.";
        String textFelrockTownHallExteriorWest = "Some more residencies are neatly built here.";

        String textDescriptionFelrockTownHallInteriorGroundFloor = "Surprisingly, the door requires a bit above than average force to open, \n" +
                "but with a tight grip and a strong push you manage to shove it aside. \n" +
                "Before you spreads a long hallway, ending up in a grand lobby. \n" +
                "On your left, a staircase extends all the way up, to the top of the Town Hall. \n" +
                "As far as you can see there are three floors, including the ground floor. \n" +
                "On your right and left there are several rooms, probably offices and storerooms. \n" +
                "While you examine your surroundings and trying to see what's on the top floors, a low voice is heard in the distance, \n" +
                "but the only words you can make out are: \"cave\" and \"corruption\". \n" +
                "At once, a different voice replies and you can only hear the words: \"dying\" and \"leave\". \n" +
                "The conversation continues...";
        String textFelrockTownHallInteriorGroundFloorNorth = "You can't travel while inside the Town Hall.";
        String textFelrockTownHallInteriorGroundFloorSouth = "You can't travel while inside the Town Hall.";
        String textFelrockTownHallInteriorGroundFloorEast = "You can't travel while inside the Town Hall.";
        String textFelrockTownHallInteriorGroundFloorWest = "You can't travel while inside the Town Hall.";

        String textDescriptionFelrockTownHallInteriorLobby = "Reluctantly, you get closer to the room and the voices are getting clearer. \n" +
                "The two men hear your footsteps and stop at once. \n" +
                "When you reveal yourself they look at you with shirred eyes and a concerned expression. +\n" +
                "Now one of them is approaching you. He is tall, wearing some kind of armour and holds a stick in his right hand. \n" +
                "You sense that he could be a very strict character and probably a high-ranked member of the village's army. \n" +
                "He greets you with a brief introduction, telling you his name: <General \"name of tall man\"> and asking for yours. \n" +
                "...<user name input>... \n" +
                "You kindly introduce yourself to both and ask to learn who the other man is. \n" +
                "He is significantly shorter than <name of tall man> and wears neat and elegant clothes making him very prestigious. \n" +
                "He holds a small case in his hands. His name is <name of short man>. \n" +
                "He tells you that he is the mayor's advisor.";
        String textFelrockTownHallInteriorLobbyNorth = "You can't travel while inside the Town Hall.";
        String textFelrockTownHallInteriorLobbySouth = "You can't travel while inside the Town Hall.";
        String textFelrockTownHallInteriorLobbyEast = "You can't travel while inside the Town Hall.";
        String textFelrockTownHallInteriorLobbyWest = "You can't travel while inside the Town Hall.";

        String textDescriptionFelrockTownHallInteriorFirstFloor = "";
        String textFelrockTownHallInteriorFirstFloorNorth = "You can't travel while inside the Town Hall.";
        String textFelrockTownHallInteriorFirstFloorSouth = "You can't travel while inside the Town Hall.";
        String textFelrockTownHallInteriorFirstFloorEast = "You can't travel while inside the Town Hall.";
        String textFelrockTownHallInteriorFirstFloorWest = "You can't travel while inside the Town Hall.";

        String textDescriptionFelrockTownHallInteriorSecondFloor = "You push the door to open but it won't budge. \nIt seems to be locked for the moment, though the right key would unlock it right away.";
        String textFelrockTownHallInteriorSecondFloorNorth = "You can't travel while inside the Town Hall.";
        String textFelrockTownHallInteriorSecondFloorSouth = "You can't travel while inside the Town Hall.";
        String textFelrockTownHallInteriorSecondFloorEast = "You can't travel while inside the Town Hall.";
        String textFelrockTownHallInteriorSecondFloorWest = "You can't travel while inside the Town Hall.";

        String textDescriptionCaveOfAnguishExterior = "From the roads leading away from the village you take the northern. +\n" +
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
        String textCaveOfAnguishExteriorNorth = "The cave's dark hollow stands before you. Will you dare pass through?";
        String textCaveOfAnguishExteriorSouth = "A massive forest is all you can see to your south.";
        String textCaveOfAnguishExteriorEast = "There is nothing but rocks and hills there.";

        String textDescriptionCaveOfAnguishInterior = "";
        String textCaveOfAnguishInteriorNoPass = "You can't travel while inside the Cave";
        // </editor-fold>
        //CONTENT
        GameContent content = new GameContent();
        // <editor-fold defaultstate="collapsed" desc="ITEMS">
        IItem shinyRock = new ShinyRock("pick","drop");
        IItem flask = new Flask("pick","drop","drink");
        //</editor-fold>
        // <editor-fold defaultstate="collapsed" desc="COMMANDS">
        ICommand go = new GoCommand();
        ICommand look = new LookCommand();
        ICommand pick = new PickCommand();
        ICommand drop = new DropCommand();
        ICommand inventory = new InventoryCommand();
        ICommand drink = new DrinkCommand();

        content.addCommand(go);
        content.addCommand(look);
        content.addCommand(pick);
        content.addCommand(drop);
        content.addCommand(inventory);
        content.addCommand(drink);
        //</editor-fold>
        // <editor-fold defaultstate="collapsed" desc="SCENES">
        Scene sceneCampsite = new Scene(textNameCampsite,textDescriptionCampsite,flask);
        Scene sceneCrossroads = new Scene(textNameCrossroads,textDescriptionCrossroads,shinyRock);
        Scene sceneCrystalLake = new Scene(textNameCrystalLake,textDescriptionCrystalLake);
        Scene sceneWildernessRoad = new Scene(textNameWildernessRoad,textDescriptionWildernessRoad);
        Scene sceneFelrockVillage = new Scene(textNameFelrockVillage,textDescriptionFelrockVillage);

        content.addScene(sceneCampsite);
        content.addScene(sceneCrossroads);
        content.addScene(sceneCrystalLake);
        content.addScene(sceneWildernessRoad);
        content.addScene(sceneFelrockVillage);
        //</editor-fold>
        // <editor-fold defaultstate="collapsed" desc="CONNECTIONS">
        SceneConnection connectionCampsiteNorth = new SceneConnection(State.OPEN,null,sceneCrossroads);
        SceneConnection connectionCampsiteSouth = new SceneConnection(State.CLOSED,textCampsiteSouth,null);
        SceneConnection connectionCampsiteEast = new SceneConnection(State.CLOSED,textCampsiteEast,null);
        SceneConnection connectionCampsiteWest = new SceneConnection(State.CLOSED,textCampsiteWest,null);

        SceneConnection connectionCrossroadsNorth = new SceneConnection(State.CLOSED,textCrossroadsNorth,null);
        SceneConnection connectionCrossroadsSouth = new SceneConnection(State.OPEN,null,sceneCrystalLake);
        SceneConnection connectionCrossroadsEast = new SceneConnection(State.OPEN,null,sceneWildernessRoad);
        SceneConnection connectionCrossroadsWest = new SceneConnection(State.CLOSED,textCrossroadsWest,null);

        SceneConnection connectionCrystalLakeNorth = new SceneConnection(State.OPEN,null,sceneCrossroads);
        SceneConnection connectionCrystalLakeSouth = new SceneConnection(State.CLOSED,textCrystalLakeSouth,null);
        SceneConnection connectionCrystalLakeEast = new SceneConnection(State.CLOSED,textCrystalLakeEast,null);
        SceneConnection connectionCrystalLakeWest = new SceneConnection(State.CLOSED,textCrystalLakeWest,null);

        SceneConnection connectionWildernessRoadNorth = new SceneConnection(State.CLOSED,textWildernessRoadNorth,null);
        SceneConnection connectionWildernessRoadSouth = new SceneConnection(State.CLOSED,textWildernessRoadSouth,null);
        SceneConnection connectionWildernessRoadEast = new SceneConnection(State.OPEN,null,sceneFelrockVillage);
        SceneConnection connectionWildernessRoadWest = new SceneConnection(State.OPEN,null,sceneCrossroads);
        //</editor-fold>
        // <editor-fold defaultstate="collapsed" desc="ADD CONNECTIONS">
        sceneCampsite.addConnection(Direction.NORTH,connectionCampsiteNorth);
        sceneCampsite.addConnection(Direction.SOUTH,connectionCampsiteSouth);
        sceneCampsite.addConnection(Direction.EAST,connectionCampsiteEast);
        sceneCampsite.addConnection(Direction.WEST,connectionCampsiteWest);

        sceneCrossroads.addConnection(Direction.NORTH,connectionCrossroadsNorth);
        sceneCrossroads.addConnection(Direction.SOUTH,connectionCrossroadsSouth);
        sceneCrossroads.addConnection(Direction.EAST,connectionCrossroadsEast);
        sceneCrossroads.addConnection(Direction.WEST,connectionCrossroadsWest);

        sceneCrystalLake.addConnection(Direction.NORTH,connectionCrystalLakeNorth);
        sceneCrystalLake.addConnection(Direction.SOUTH,connectionCrystalLakeSouth);
        sceneCrystalLake.addConnection(Direction.EAST,connectionCrystalLakeEast);
        sceneCrystalLake.addConnection(Direction.WEST,connectionCrystalLakeWest);

        sceneWildernessRoad.addConnection(Direction.NORTH,connectionWildernessRoadNorth);
        sceneWildernessRoad.addConnection(Direction.SOUTH,connectionWildernessRoadSouth);
        sceneWildernessRoad.addConnection(Direction.EAST,connectionWildernessRoadEast);
        sceneWildernessRoad.addConnection(Direction.WEST,connectionWildernessRoadWest);
        //</editor-fold>
        //-----INTRO-----
        System.out.println("ACT I - The Sage\n");
        System.out.println("As the sun sets, the nightfall finds you getting ready for the upcoming journey to the far land of Serenoth.");
        System.out.println("You must reach this region in order to find a great sage, who is the personal advisor of king Ecthelion, son of Exelion.");
        System.out.println("This great sage often goes by many names, but one is more common to the people of Dal'aron, Zenthar");
        System.out.println("He is against all the strife of the two kingdoms, for he knows what really happened two hundred years ago.");
        System.out.println("But the two kings care for nothing than the dominion of their own might all over the world.");
        System.out.println("This is why you need his help to convince king Ecthelion to cease his actions and withdraw his armies before its too late to stop this madness.");
        System.out.println("Therefore...\n");
        //CHARACTERS
        String playerName = getPlayerName();
        Character player = new Character(playerName,sceneCampsite);

        content.addCharacter(player);
        //FIRST SCENE
        player.getLocation().printDescription();
        //GAME LOOP
        gameLoop(player,content);
    }
    private String getPlayerName()
    {
        System.out.println("What is your name?");
        Scanner name = new Scanner(System.in);
        return  name.nextLine();
    }

    private void gameLoop(Character player,GameContent content)
    {
        //USER INPUT
        String userInputString;
        Scanner userInput;
        //COMMAND PARSER
        InputHandler handler = new InputHandler();
        do
        {
            userInput = new Scanner(System.in);
            userInputString = userInput.nextLine().trim();
            handler.tryParse(userInputString,content,player);
            checkThirst(player);

        } while (!player.getLocation().getName().equals("The Sage"));
        System.out.println("\n\n\nYou have completed ACT I, ACT II is under development, stay tuned for more...\n");
    }
    private void checkThirst(Character player)
    {
        if (player.getThirstLevel() == 0 )
        {
            System.out.println("You fall to your knees from dehydration and...slowly.....die...RIP IN PIS "+player.getName());
            System.exit(-10);
        }
    }

}
