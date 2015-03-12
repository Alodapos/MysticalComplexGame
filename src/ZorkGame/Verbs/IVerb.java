package ZorkGame.Verbs;

import ZorkGame.Characters.ICharacter;
import ZorkGame.InputHandler;

/**
 * Created by sakis on 09-Mar-15.
 */
public interface IVerb {
    String getName();

    String getActionFailed();

    void executeAction(ICharacter character, String argument, InputHandler handler);

}
