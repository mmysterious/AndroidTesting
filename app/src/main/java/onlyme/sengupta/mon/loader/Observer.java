package onlyme.sengupta.mon.loader;

import java.util.ArrayList;

/**
 * Created by mondrita on 11/12/16.
 */
public abstract class Observer {


    ArrayList<Subscriber> subscriberArrayList;

    Observer() {
        subscriberArrayList= new ArrayList<>();
    }

    public void subscribe(Subscriber subscriber) {
        subscriberArrayList.add(subscriber);
    }


    public void unsubscribe(Subscriber subscriber) {
        subscriberArrayList.remove(subscriber);
    }

    public abstract void notifySubscriber();
}
