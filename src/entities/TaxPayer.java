package entities;

public abstract class TaxPayer 
{
	
	protected String name;
	protected double anualIncome;
	
	public TaxPayer(String name, double anualIncome) 
	{
		this.name = name;
		this.anualIncome = anualIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAnulIcome() {
		return anualIncome;
	}

	public void setAnulIcome(double anulIcome) {
		this.anualIncome = anulIcome;
	}
	
	public abstract double tax();
	
	
}
