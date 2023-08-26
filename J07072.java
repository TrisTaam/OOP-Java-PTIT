import java.io.*;
import java.util.*;

class Person implements Comparable<Person> {
    private String name;
    private String lastName;
    private String firstName;
    private String middleName;

    public Person(String name) {
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        for (int i = 0; i < tmp.length; ++i) tmp[i] = tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1);
        this.name = tmp[0];
        for (int i = 1; i < tmp.length; ++i) this.name += (" " + tmp[i]);
        this.lastName = tmp[0];
        this.firstName = tmp[tmp.length - 1];
        if (tmp.length > 2) {
            this.middleName = tmp[1];
            for (int i = 2; i < tmp.length; ++i) this.middleName += (" " + tmp[i]);
        } else this.middleName = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public int compareTo(Person o) {
        if (!this.firstName.equals(o.firstName)) return this.firstName.compareTo(o.firstName);
        if (!this.lastName.equals(o.lastName)) return this.lastName.compareTo(o.lastName);
        return this.middleName.compareTo(o.middleName);
    }
}

public class J07072 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        ArrayList<Person> a = new ArrayList<>();
        while (sc.hasNextLine()) a.add(new Person(sc.nextLine()));
        Collections.sort(a);
        for (Person x : a) System.out.println(x.getName());
    }
}
