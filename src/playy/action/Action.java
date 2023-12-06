package playy.action;

import static playy.action.Move.STAY;

public interface Action {
    void execute();

     static Action getActionFromAcronyme(String input) {
        for(Move move  : Move.values()) {
            if (input.equalsIgnoreCase(move.acronyme))
                return  move;
        }

        for(Interaction interaction  : Interaction.values()) {
            if (input.equalsIgnoreCase(interaction.acronyme))
                return  interaction;
        }
        return STAY;
    }

}
