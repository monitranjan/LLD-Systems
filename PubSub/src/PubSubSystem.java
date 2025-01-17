public class PubSubSystem {
    public static void main(String[] args) {
        MessageBroker broker = MessageBroker.getInstance();
        broker.createTopic("News");
        broker.createTopic("Sports");

        Subscriber subscriber1 = new ConcreteSubscriber("monit");
        Subscriber subscriber2 = new ConcreteSubscriber("ranjan");

        Topic newsTopic = broker.getTopic("News");
        newsTopic.subscribe(subscriber1);
        newsTopic.subscribe(subscriber2);

        Publisher publisher = new Publisher();
        publisher.publishMessage("News",new Message("Breaking News!!!",System.currentTimeMillis()));
        publisher.publishMessage("Sports",new Message("Sports update!!!",System.currentTimeMillis()));

        newsTopic.unSubscribe(subscriber1);

        publisher.publishMessage("News",new Message("More Breaking News!!!",System.currentTimeMillis()));
    }
}