package observers;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import jade.GameObject;

public class EventSystem {
	private static List<Observer> observers = new ArrayList<>();

	public static void addObserver(Observer observer) {
		observers.add(observer);
	}

	public static void notify(GameObject obj, Event event) {
		for (Observer observer : observers) {
			observer.onNotify(obj, event);
		}
	}
}