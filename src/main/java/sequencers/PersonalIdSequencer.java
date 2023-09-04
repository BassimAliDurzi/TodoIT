package sequencers;

public class PersonalIdSequencer {
    private static int currentId = 1;

    public static int nextId() {
        return currentId++;
    }

    public static int currentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        PersonalIdSequencer.currentId = currentId;
    }
}
