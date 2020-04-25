package entities;

public class Individual extends TaxPayer
{
	public double healthExpenditures;
	
	public Individual(String name, double anualIncome, double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double tax() 
	{
		double tax = 0;
		
		if (anualIncome < 20000.00)
		{
			tax += (anualIncome * 0.15) - (healthExpenditures * 0.50);
		}
		
		else
		{
			tax += (anualIncome * 0.25) - (healthExpenditures * 0.50);
		}
		
		return tax;
	}

}
