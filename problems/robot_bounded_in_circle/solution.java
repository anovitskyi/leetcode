class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] grid = new int[2];
        Direction direction = Direction.NORTH;
        
        for (int i = 0; i < instructions.length(); ++i) {
            if (instructions.charAt(i) == 'G') {
                goStraight(grid, direction);
            } else if (instructions.charAt(i) == 'L') {
                direction = turnLeft(direction);
            } else {
                direction = turnRight(direction);
            }
        }
        
        if (grid[0] == 0 && grid[1] == 0) {
            return true;
        }
        
        
        return direction != Direction.NORTH;
    }
    
    private void goStraight(int[] grid, Direction direction) {
        switch (direction) {
            case NORTH: {
                ++grid[1]; 
                break;
            }
            case WEST:{
                --grid[0]; 
                break;
            }
            case SOUTH: {
                --grid[1]; 
                break;
            }
            case EAST: {
                ++grid[0]; 
                break;
            }
        }
    }
    
    private Direction turnLeft(Direction direction) {
        switch (direction) {
            case NORTH: return Direction.WEST;
            case WEST: return Direction.SOUTH;
            case SOUTH: return Direction.EAST;
            case EAST: return Direction.NORTH;
            default: return null;
        }
    }
    
    private Direction turnRight(Direction direction) {
        switch (direction) {
            case NORTH: return Direction.EAST;
            case EAST: return Direction.SOUTH;
            case SOUTH: return Direction.WEST;
            case WEST: return Direction.NORTH;
            default: return null;
        }
    }
    
    private static enum Direction {
        NORTH,
        SOUTH,
        WEST,
        EAST
    }
}