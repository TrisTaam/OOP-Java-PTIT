import java.text.SimpleDateFormat;
import java.util.*;

class Person implements Comparable<Person> {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private String name;
    private Date dob;

    public Person(String name, String dob) {
        this.name = name;
        try {
            this.dob = dateFormat.parse(dob);
        } catch (Exception e) {

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public int compareTo(Person o) {
        return -Long.compare(this.dob.getTime(), o.dob.getTime());
    }
}

public class J05032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<Person> a = new ArrayList<Person>();
        for (int i = 0; i < n; ++i) {
            a.add(new Person(sc.next(), sc.next()));
        }
        Collections.sort(a);
        System.out.println(a.get(0).getName());
        System.out.println(a.get(a.size() - 1).getName());
        sc.close();
    }
}
