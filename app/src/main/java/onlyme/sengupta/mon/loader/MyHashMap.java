package onlyme.sengupta.mon.loader;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;



/**
 * Created by mondrita on 11/12/16.
 */
public class MyHashMap {

    int size=5;
    LinkedList<MyNode>[] data=new LinkedList[size];


    public int getHashCode(int key) {
        return key*30;
    }

    public int getIndexFromHashCode(int hashCode) {
        return hashCode%size;
    }

    public int put(int key, int value) {
        int hashCode= getHashCode(key);
        int index= getIndexFromHashCode(hashCode);
        //System.out.println("********************hashcode"+ hashCode);
        //System.out.println("********************hashindex"+ index);
        LinkedList<MyNode> oldList= data[index];
        if (oldList==null) {
            oldList= new LinkedList<>();
            oldList.add(new MyNode(new Entry(key), value));
            data[index]= oldList;
            return 0;
        }else {
            Iterator<MyNode> itr = oldList.iterator();
            int oldVal=-1;
            while (itr.hasNext()) {
                MyNode val= itr.next();
                if(val.equals(new Entry(key))) {
                    oldVal= val.value;
                    itr.remove();
                    break;
                }
            }
            oldList.add(new MyNode(new Entry(key), value));
            return oldVal;

        }

    }

    public int get(int key) {
        int hashCode= getHashCode(key);
        int index= getIndexFromHashCode(hashCode);
        //System.out.println("********************hashcode"+ hashCode);
        //System.out.println("********************hashindex"+ index);
        LinkedList<MyNode> list= data[index];
        if (list==null) {
            return -1;
        }else {
            Iterator<MyNode> itr = list.iterator();
            while (itr.hasNext()) {
                MyNode val= itr.next();
                if(val.equals(new Entry(key))) {
                    return val.value;
                }
            }
            return -1;
        }
    }

    public static class MyNode {
        public Entry key;
        public int value;
        public MyNode next;

        MyNode(Entry key, int value) {
            this.key=key;
            this.value=value;
        }

        public boolean equals(Entry obj) {
            return obj.equals(this.key);
        }

    }

    public static class Entry {
        int key;
        Entry(int key) {
            this.key=key;
        }


        public boolean equals(Entry obj) {
            return obj.key==this.key;
        }
    }
}
