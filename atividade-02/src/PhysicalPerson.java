

public class PhysicalPerson extends Person{
    private double healthExpenditures = 0;

    public double getHealthExpenditures() {
        return healthExpenditures;
    }

    public PhysicalPerson(String name, double anualIncome, double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double getTax() {
        if (this.getHealthExpenditures() > 0) {
            if (this.getAnualIncome() < 20000) {
                return this.getAnualIncome()*0.15 - (this.getHealthExpenditures()*0.5);
            }
            return  this.getAnualIncome()*0.25 - (this.getHealthExpenditures()*0.5);
        }
        if (this.getAnualIncome() < 20000) {
            return this.getAnualIncome()*0.15;
        }
        return  this.getAnualIncome()*0.25;
    }
}
