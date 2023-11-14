package playy.action;

public enum Interaction implements Action{
    ATTACK("A"){

    },
    HEAL("H");

    @Override
    public void execute() {

    }

    Interaction(String acronyme) {
        this.acronyme = acronyme;
    }

    protected String acronyme;

}
