package MultiThreadingJava;
import java.util.LinkedList;
import java.util.Queue;

class Bridge {
    private boolean tokenInCityB = true;
    private boolean bridgeOccupied = false;
    private final Queue<Person> cityAQueue = new LinkedList<>();
    private final Queue<Person> cityBQueue = new LinkedList<>();

    public synchronized void requestToCross(Person person) {
        if (person.getCity().equals("A")) {
            cityAQueue.add(person);
        } else {
            cityBQueue.add(person);
        }

        while (bridgeOccupied ||
              (person.getCity().equals("A") && (tokenInCityB || !cityBQueue.isEmpty())) ||
              (person.getCity().equals("B") && !tokenInCityB)) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        bridgeOccupied = true;

        if (person.getCity().equals("A")) {
            cityAQueue.poll();
            tokenInCityB = true;
        } else {
            cityBQueue.poll();
            tokenInCityB = false;
        }
    }

    public synchronized void leaveBridge(Person person) {
        System.out.println(person.getName() + " from City " + person.getCity() + " crossed to City " + (person.getCity().equals("A") ? "B" : "A"));
        bridgeOccupied = false;
        notifyAll();
    }
}

class Person extends Thread {
    private final String city;
    private final Bridge bridge;

    public Person(String name, String city, Bridge bridge) {
        super(name);
        this.city = city;
        this.bridge = bridge;
    }

    public String getCity() {
        return city;
    }

    public void run() {
        bridge.requestToCross(this);
        try {
            Thread.sleep(500); // simulate crossing
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        bridge.leaveBridge(this);
    }
}

public class BridgeManagement {
    public static void main(String[] args) {
        Bridge bridge = new Bridge();

        // Residents from City B (must go first)
        new Person("B1", "B", bridge).start();
        new Person("B2", "B", bridge).start();

        // Delay to ensure B residents start first
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        // Residents from City A
        new Person("A1", "A", bridge).start();
        new Person("A2", "A", bridge).start();
        new Person("A3", "A", bridge).start();
    }
}

