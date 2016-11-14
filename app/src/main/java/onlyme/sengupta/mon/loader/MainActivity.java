package onlyme.sengupta.mon.loader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button helloButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.txtview);
        editText = (EditText) findViewById(R.id.edittxt);
        Button helloButton = (Button) findViewById(R.id.btn);
        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayHello(v);
            } });


        MyObserver observer= new MyObserver();
        MySubscriber subscriber1= new MySubscriber("mon");
        MySubscriber subscriber2= new MySubscriber("prabhat");
        observer.subscribe(subscriber1);
        observer.subscribe(subscriber2);
        observer.notifySubscriber();
        observer.value= 10;
        observer.notifySubscriber();

        Hashtable<Integer, Integer> table= new Hashtable<>();
        table.put(1,11);
        table.put(2,22);
        Enumeration<Integer> keys= table.keys();
        while(keys.hasMoreElements()) {
            System.out.println("********************"+table.get(keys.nextElement()));
            table.put(2,31);
        }

//        MyHashMap map= new MyHashMap();
//        System.out.println("********************"+ map.put(2,5));
//        System.out.println("********************"+ map.put(3,2));
//        System.out.println("********************"+ map.put(2,4));
//        System.out.println("********************"+ map.get(2));
    }

    public void sayHello(View view) {
        String name = editText.getText().toString();
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }


    static int mychecker(int a, int b) {
        return a*b;
    }


}

class MyObserver extends Observer {

    int value= 5;
    @Override
    public void notifySubscriber() {
        for (Subscriber subscriber: subscriberArrayList ) {
            subscriber.update(new Integer(value));
        }
    }
}

class MySubscriber extends Subscriber {

    String name;

    MySubscriber(String name) {
        this.name= name;
    }
    @Override
    public void update(Object value) {
        System.out.println("*********** For subscriber---"+name+" value is --- "+value);
    }
}
