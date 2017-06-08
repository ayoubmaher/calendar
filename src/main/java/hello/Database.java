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

    public static void remove(int id) {
        // logic here
    }

    public static List<Event> getAll() {
        return new ArrayList<>(db);
    }


}
