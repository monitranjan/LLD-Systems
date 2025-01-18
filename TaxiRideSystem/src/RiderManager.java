import java.util.HashMap;
import java.util.Map;

public class RiderManager {
    private static RiderManager instance;
    private Map<String, Rider> riderMap = new HashMap<>();

    public static synchronized RiderManager getInstance() {
        if(instance==null){
            instance = new RiderManager();
        }
        return instance;
    }

    public void addRider(Rider rider){
        riderMap.put(rider.getName(),rider);
    }

    public Rider getRider(String name){
        return riderMap.getOrDefault(name,null);
    }
}
