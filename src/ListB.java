public class ListB implements ListUpdater {
    @Override
    public void update(PrintedMedia pm) {
        System.out.println("Group B notified: A new printed media of type " + pm.getClass().getSimpleName() + " has been created.");
    }
}

//ConcreteObserverB