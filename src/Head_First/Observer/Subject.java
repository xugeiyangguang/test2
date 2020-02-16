package Head_First.Observer;

import java.util.Observer;

public interface Subject {
    public void registerObserver(Observer1 o);
    public void removeObserver(Observer1 o);
    public void notifyObservers();

}

interface Observer1 {
    public void update(float temp, float humidity, float pressure);
}

interface DisplayElement {
    public void display();
}
