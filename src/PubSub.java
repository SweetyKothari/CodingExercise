import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class PubSub {
    private Map<String, ArrayList<Consumer<?>>> topicsSubscribers =
            new HashMap<String, ArrayList<Consumer<?>>>();
    private static PubSub pubSubSingleton = null;

    public static PubSub getInstance() {
        if (pubSubSingleton == null)
            pubSubSingleton = new PubSub();

        return pubSubSingleton;
    }

    public <T> void publish(String topic, T message) {
        ArrayList<Consumer<?>> subscribers = this.topicsSubscribers.get(topic);
        if (subscribers == null)
            return;

        for (Consumer subscriberConsumer : subscribers) {
            subscriberConsumer.accept(message);
        }
    }

    public synchronized <T> void subscribe(String topicName, Consumer<T> subscriberCallback) {
        ArrayList<Consumer<?>> subscribers = this.topicsSubscribers.get(topicName);
        if (subscribers == null) {
            subscribers = new ArrayList<Consumer<?>>();
            subscribers.add(subscriberCallback);
            this.topicsSubscribers.put(topicName, subscribers);
        } else {
            subscribers.add(subscriberCallback);
        }
    }
}