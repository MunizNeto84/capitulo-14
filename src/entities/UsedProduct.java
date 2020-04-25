package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product
{
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date manufactureDate;

	public UsedProduct(String name, double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	@Override
	public String priceTag()
	{
		return name
				+ "$ "
				+ String.format("%.2f", price)
				+ " (Manufacture date: "
				+ sdf.format(manufactureDate)
				+ ")";
	}
	
}
