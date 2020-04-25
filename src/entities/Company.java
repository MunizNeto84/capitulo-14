package entities;

public class Company extends TaxPayer 
{
	private int numberOfEmployees;
	
	public Company(String name, double anualIncome, int numberOfEmployees)
	{
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public int getNumberOffEmployees() 
	{
		return numberOfEmployees;
	}

	public void setNumberOffEmployees(int numberOffEmployees)
	{
		this.numberOfEmployees = numberOffEmployees;
	}

	@Override
	public double tax() 
	{
		double tax = 0;
		
		if (numberOfEmployees < 10)
		{
			tax += anualIncome * 0.16;
		}
		
		else
		{
			tax += anualIncome * 0.14;
		}
		
		return tax;
	}
}
