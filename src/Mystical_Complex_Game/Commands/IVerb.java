package Mystical_Complex_Game.Commands;

import Mystical_Complex_Game.Characters.ICharacter;
import Mystical_Complex_Game.InputHandler;

/**
 * Created by sakis on 09-Mar-15.
 */
public interface IVerb
{
    String getName();

    String getActionFailed();

    void executeAction(ICharacter character, String argument, InputHandler handler);

}
