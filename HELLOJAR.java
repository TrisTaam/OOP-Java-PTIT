import view.InvoiceView;
import vn.edu.ptit.Invoice;
import vn.edu.ptit.Rule;
import vn.edu.ptit.Student;
import vn.edu.ptit.Subject;

import java.io.*;
import java.util.*;

class PaymentController {
    private static final Scanner sc = new Scanner(System.in);
    private Invoice invoice;

    public PaymentController() {
        invoice = new Invoice(new Rule());
        String id = sc.nextLine();
        String name = sc.nextLine();
        int subjectCount = Integer.parseInt(sc.nextLine());
        Student st = new Student(id, name);
        ArrayList<Subject> subjects = new ArrayList<>();
        while (subjectCount-- > 0) {
            id = sc.nextLine();
            name = sc.nextLine();
            int credit = Integer.parseInt(sc.nextLine());
            subjects.add(new Subject(name, id, credit));
        }
        id = sc.nextLine();
        name = sc.nextLine();
        double creditPrice = Double.parseDouble(sc.nextLine());
        Rule rule = new Rule(id, name, creditPrice);
        invoice = new Invoice(rule);
        invoice.setSt(st);
        invoice.setAlSubject(subjects);
        double amount = 0;
        for (Subject subject : subjects) {
            amount += rule.getCreditPrice() * subject.getCredit();
        }
        invoice.setAmount(amount);
    }

    public Invoice getInvoice() {
        return invoice;
    }
}

public class HELLOJAR {
    public static void main(String[] args) {
        PaymentController pc = new PaymentController();
        //Output for test
        Invoice invoice = pc.getInvoice();
        InvoiceView.show(invoice);
    }
}
