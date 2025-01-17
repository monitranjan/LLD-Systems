import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageBroker {
    public static MessageBroker instance;
    private Map<String,Topic> topics = new ConcurrentHashMap<>();

    public static synchronized MessageBroker getInstance() {
        if(instance == null){
            instance = new MessageBroker();
        }
        return instance;
    }

    public void createTopic(String name){
        topics.putIfAbsent(name, new Topic(name));
    }

    public Topic getTopic(String name){
        return topics.get(name);
    }
}
