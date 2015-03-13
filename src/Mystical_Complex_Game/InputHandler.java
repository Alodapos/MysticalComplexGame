package Mystical_Complex_Game;

import Mystical_Complex_Game.Characters.ICharacter;
import Mystical_Complex_Game.Scenes.IScene;
import Mystical_Complex_Game.Commands.IVerb;

import java.util.ArrayList;
import java.util.regex.*;
/**
 * Created by sakis on 09-Mar-15.
 */
public class InputHandler
{

    private final Pattern pattern = Pattern.compile("(\\w+)(.*)");
    private Matcher matcher;
    private ArrayList<IVerb> verbList = new ArrayList<IVerb>();
    private ArrayList<IScene> scenesList = new ArrayList<IScene>();

    public void handle(String userInput,ICharacter character)
    {
        userInput = userInput.trim();
        userInput = userInput.toLowerCase();
        //this.matcher.reset(); no clue what dis be doing here
        this.matcher = pattern.matcher(userInput);
        if (matcher.find())
        {
            for (IVerb name : verbList)
            {
                if (matcher.group(1).equals(name.getName()))
                {
                    name.executeAction(character, matcher.group(2), this);
                }
                else
                {
                    System.out.println("This is not a verb I recognize!");
                }
            }
        }
    }

    public void addVerbs(IVerb verbToAdd)
    {
        this.verbList.add(verbToAdd);
    }

    public void addScene(IScene sceneToAdd)
    {
        this.scenesList.add(sceneToAdd);
    }

    public ArrayList<IScene> getScenesList()
    {
        return scenesList;
    }
}

