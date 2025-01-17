public class ConcreteSubscriber implements Subscriber{
    private String name;

    public ConcreteSubscriber(String name){
        this.name = name;
    }

    @Override
    public void receiveMessage(Message message) {
        System.out.println(name + "received: "+message.getContent());
    }
}
