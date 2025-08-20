

public abstract class  Person {
    private String name;
    private double anualIncome;

    public Person(String name, double anualIncome) {
        this.name = name;
        this.anualIncome = anualIncome;
    }

    public double getAnualIncome() {
        return anualIncome;
    }

    public String getName() {
        return name;
    }


    public abstract double getTax();
}


