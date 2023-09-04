package sequencers;

public class TodoItemIdSequencer {
    private static int currentId = 1;

    public static int nextId() {
        return currentId++;
    }

    public static int currentId() {
        return currentId;
    }

    public void setCurrentId(int currentId) {
        TodoItemIdSequencer.currentId = currentId;
    }

}
