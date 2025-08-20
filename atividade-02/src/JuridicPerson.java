

public class JuridicPerson extends Person{
    private int numberOfEmployees;

    public JuridicPerson(String name, double anualIncome, int numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }


    @Override
    public double getTax() {
        if (this.getNumberOfEmployees() > 10) {
            return this.getAnualIncome()*0.14;
        }
        return this.getAnualIncome()*0.16;
    }
}
