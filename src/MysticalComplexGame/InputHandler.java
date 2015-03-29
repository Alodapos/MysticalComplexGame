package MysticalComplexGame;

import MysticalComplexGame.Commands.ICommand;

class InputHandler
{
    private String commandNotFound = "This is not a command that i recognize";
    private ICommand command;
    public void tryParse(String userInput,GameContent content, Character character)
    {
        userInput = userInput.toLowerCase();
        String[] input = new String[2];
        if (userInput.contains(" ")) input = userInput.split(" ",2);
        else
        {
            input[0] = userInput;
            input[1] = "";
        }
        command = content.getCommand(input[0]);
        if (command != null) command.executeCommand(character,input[1],content);
        else System.err.println(commandNotFound);
    }
}


