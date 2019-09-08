import java.io.*;

public class assignment3 {
    static MyHashTable_<Pair<String, String>, Student> table;

    public static void main(String[] args) {
        int t = Integer.parseInt(args[0]);
        if (args[1].equals("DH")) {
            table = new DH<Pair<String, String>, Student>(t);
        } else if (args[1].equals("SCBST")) {
            table = new SC<Pair<String, String>, Student>(t);
        }
        read(args[2]);
    }

    static void read(String path) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                answer(line.split(" "));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void answer(String[] s) {
        String fname = s[1];
        String lname = s[2];
        Pair<String, String> p = new Pair<String, String>(fname, lname);
        if (s[0].equals("insert")) {
            String hostel = s[3];
            String dept = s[4];
            String cgpa = s[5];
            int r = table.insert(p, new Student(fname, lname, hostel, dept, cgpa));
            System.out.println(r);
        } else if (s[0].equals("update")) {
            String hostel = s[3];
            String dept = s[4];
            String cgpa = s[5];
            int r = table.update(p, new Student(fname, lname, hostel, dept, cgpa));
            System.out.println((r == -1) ? "E" : r);
        } else if (s[0].equals("delete")) {
            int r = table.delete(p);
            System.out.println((r == -1) ? "E" : r);
        } else if (s[0].equals("contains")) {
            System.out.println(table.contains(p) ? "T" : "F");
        } else if (s[0].equals("get")) {
            try {
                System.out.println(table.get(p).toString());
            } catch (NotFoundException e) {
                System.out.println("E");
            }
        } else if (s[0].equals("address")) {
            try {
                System.out.println(table.address(p));
            } catch (NotFoundException e) {
                System.out.println("E");
            }
        }
    }
}