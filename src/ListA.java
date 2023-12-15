public class ListA implements ListUpdater {
    @Override
    public void update(PrintedMedia pm) {
        System.out.println("Group A notified: A new printed media of type " + pm.getClass().getSimpleName() + " has been created.");
    }
}
//ConcreteObserverA