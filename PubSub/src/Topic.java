import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;

public class Topic {
    private String name;
    private List<Subscriber> subscriberList = new CopyOnWriteArrayList<>();
    private PriorityBlockingQueue<Message> messageQueue = new PriorityBlockingQueue<>();

    public Topic(String name){
        this.name = name;
    }

    public void subscribe(Subscriber subscriber){
        subscriberList.add(subscriber);
    }

    public void unSubscribe(Subscriber subscriber){
        subscriberList.remove(subscriber);
    }

    public void publish(Message message){
        messageQueue.add(message);
        deliverMessage();
    }

    private void deliverMessage(){
        while (!messageQueue.isEmpty()){
            Message message = messageQueue.poll();
            for(Subscriber subscriber: subscriberList){
                subscriber.receiveMessage(message);
            }
        }

    }

}
