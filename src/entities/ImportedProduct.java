package entities;

public class ImportedProduct extends Product
{
	private double custormsFree;

	public ImportedProduct(String name, double price, double custormsFree) 
	{
		super(name, price);
		this.custormsFree = custormsFree;
	}

	public double getCustormsFree()
	{
		return custormsFree;
	}

	public void setCustormsFree(double custormsFree) 
	{
		this.custormsFree = custormsFree;
	}
	
	public double totalPrice()
	{
		return price += custormsFree;
	}
	
	@Override
	public String priceTag()
	{
		return name
				+ "$ "
				+ String.format("%.2f", totalPrice())
				+ " (Customs fee: $ "
				+ custormsFree
				+ ")";
	}
}
