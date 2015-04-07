package MysticalComplexGame.Items;


import MysticalComplexGame.Character;

public interface LiquidContainer
{
    void drink(Character character);
    void fill(Character character);
    void empty(Character character);
}
