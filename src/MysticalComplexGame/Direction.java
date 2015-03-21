package MysticalComplexGame;

public enum Direction {
    NORTH("north"),
    SOUTH("south"),
    EAST("east"),
    WEST("west");

    private final String direction;
    Direction(String direction)
    {
        this.direction = direction;
    }

    public static Direction fromString(String direction)
    {
        if (direction != null) {
            for (Direction dir : Direction.values()) {
                if (direction.equalsIgnoreCase(dir.direction)) {
                    return dir;
                }
            }
        }
        return null;
    }
}
