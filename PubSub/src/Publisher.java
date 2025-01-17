public class Publisher {
    public MessageBroker broker;

    public Publisher(){
        this.broker = MessageBroker.getInstance();
    }

    public void publishMessage(String topicName, Message message){
        Topic topic = broker.getTopic(topicName);
        if(topic != null){
            topic.publish(message);
        }else{
            System.out.println("Topic noty found :" + topicName);
        }
    }
}
