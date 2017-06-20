package hello;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static List<Event> db = new ArrayList<>();

    private Database() {
    }

    public static void add(Event event) {
        db.add(event);
    }

    public static void remove(int id){
        Event ev=null;
        for(Event e: db) {
            if (e.getId() == id)
                ev = e;
        }
        if(ev!=null)
            db.remove(ev);

    }

    public static void modify(Event ev){
        boolean found=false;
        for(int i=0;i<db.size() && !found;i++) {
            if (db.get(i).getId() == ev.getId()) {
                db.set(i, ev);
                found = true;
            }
        }
    }

    public static List<Event> getAll() {
        return new ArrayList<>(db);
    }


}
