package b_theory.question11;

public class Nr4isI {

    //todo this is a contribution based question so make sure to keep commits separate
    //todo A What does I stand for in SOLID? Explain the principle.
    // Answer: I stands for Interface Segregation Principle (ISP)
    // It states that methods should not be forced upon a class by it's dependant.
    // Interfaces should be as small as possible.
    // This way there is no reason to create dummy methods.
}

//todo B Give an example. Write actual or pseudo code.
interface PhysicalRemoteBefore {
    void moveUp(DirectionInput.Direction input);
    void moveUpLeft(DirectionInput.Direction input);
    void moveLeft(DirectionInput.Direction input);
}

class TvRemoteBefore implements PhysicalRemoteBefore{

    @Override
    public void moveUp(DirectionInput.Direction input) {
        if (input == DirectionInput.Direction.UP) {
            moveUp();
        }
    }

    @Override
    public void moveUpLeft(DirectionInput.Direction input) {
        // TV remote physically unable to move in diagonals
        // so I have to implement this as a dummy method.
    }

    @Override
    public void moveLeft(DirectionInput.Direction input) {
        if (input == DirectionInput.Direction.LEFT) {
            moveLeft();
        }
    }
}

class GameRemoteBefore implements PhysicalRemoteBefore {

    @Override
    public void moveUp(DirectionInput.Direction input) {
        if (input == DirectionInput.Direction.UP) {
            moveUp();
        }
    }

    @Override
    public void moveUpLeft(DirectionInput.Direction input) {
        if (input == DirectionInput.Direction.UP_LEFT) {
            moveUpLeft();
        }
    }

    @Override
    public void moveLeft(DirectionInput.Direction input) {
        if (input == DirectionInput.Direction.LEFT) {
            moveLeft();
        }
    }
}

interface PhysicalRemoteBasic {
    void moveUp(DirectionInput.Direction input);
    void moveLeft(DirectionInput.Direction input);
}

interface PhysicalRemoteAdvanced {
    void moveUpLeft(DirectionInput.Direction input);
}

class TvRemote implements PhysicalRemoteBasic {

    @Override
    public void moveUp(DirectionInput.Direction input) {
        if (input == DirectionInput.Direction.UP) {
            moveUp();
        }
    }

    @Override
    public void moveLeft(DirectionInput.Direction input) {
        if (input == DirectionInput.Direction.LEFT) {
            moveLeft();
        }
    }
}

class GameRemote implements PhysicalRemoteBasic, PhysicalRemoteAdvanced {

    @Override
    public void moveUp(DirectionInput.Direction input) {
        if (input == DirectionInput.Direction.UP) {
            moveUp();
        }
    }

    @Override
    public void moveLeft(DirectionInput.Direction input) {
        if (input == DirectionInput.Direction.LEFT) {
            moveLeft();
        }
    }

    @Override
    public void moveUpLeft(DirectionInput.Direction input) {
        if (input == DirectionInput.Direction.UP_LEFT) {
            moveUpLeft();
        }
    }

}


class DirectionInput {
    enum Direction {
        UP,
        LEFT,
        UP_LEFT,
    }
}
