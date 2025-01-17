public class Message implements Comparable<Message>{
    private String content;
    private long timeStamp;
    public Message(String content, long timestamp){
        this.content = content;
        this.timeStamp = timestamp;
    }

    public String getContent(){
        return  this.content;
    }

    public long getTimeStamp(){
        return this.timeStamp;
    }

    @Override
    public int compareTo(Message other){
        return Long.compare(this.timeStamp, other.timeStamp);
    }
}
