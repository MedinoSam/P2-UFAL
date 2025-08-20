import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int taxPayers;
        System.out.printf("Enter the number of tax payers: ");
        taxPayers = sc.nextInt();
        List<Person> persons = new ArrayList<>();

        for (int i = 1; i<= taxPayers; i++) {
            String name;
            double anualIncome;
            double healthExpenditures;
            int numberOfEmployees;
            String individualOrCompany;
            System.out.println("Tax payer #" + i + " data:");
            System.out.printf("Individual or company (i/c)?: ");
            individualOrCompany = sc.next();
            switch (individualOrCompany) {

                case "i":
                    System.out.printf("Name: ");
                    name = sc.next();
                    System.out.printf("Anual income: ");
                    anualIncome = sc.nextDouble();
                    System.out.printf("Health expenditure: ");
                    healthExpenditures = sc.nextDouble();
                    PhysicalPerson physicalPerson = new PhysicalPerson(name, anualIncome, healthExpenditures);
                    persons.add(physicalPerson);
                    break;

                case "c":
                    System.out.printf("Name: ");
                    name = sc.next();
                    System.out.printf("Anual income: ");
                    anualIncome = sc.nextDouble();
                    System.out.printf("Number of employees: ");
                    numberOfEmployees = sc.nextInt();
                    JuridicPerson juridicPerson = new JuridicPerson(name, anualIncome, numberOfEmployees);
                    persons.add(juridicPerson);
                    break;

                default:
                    System.out.println("Erro! caracter nao identificado, digite i ou c");
            }
        }
        double totalTax = 0;
        System.out.println("TAXES PAID:");
        for (Person person : persons) {
            System.out.println(person.getName()+":  $ "+person.getTax());
            totalTax += person.getTax();
        }
        System.out.println("TOTAL TAXES: $ "+ totalTax);
    }
}