package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program 
{

	public static void main(String[] args) throws ParseException 
	{
		
		/*
		 *Fazer um programa para ler os dados de N
		 *produtos (N fornecido pelo usuário). Ao final,
		 *mostrar a etiqueta de preço de cada produto na
		 *mesma ordem em que foram digitados.
		 *Todo produto possui nome e preço. Produtos
		 *importados possuem uma taxa de alfândega, e
		 *produtos usados possuem data de fabricação.Estes 
		 *dados específicos devem ser a
		 *crescentados na etiqueta de preço conforme
		 *exemplo (próxima página). Para produtos
		 *importados, a taxa e alfândega deve ser
		 *acrescentada ao preço final do produto 
		 */
		 
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List <Product> prod = new ArrayList<> ();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++)
		{
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			
			if (ch == 'c')
			{
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				prod.add(new Product(name, price));
			}
			
			if (ch == 'u')
			{
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				prod.add(new UsedProduct(name, price, manufactureDate));
			}
			
			if (ch == 'i')
			{
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Customs fee: ");
				double custormsFree = sc.nextDouble();
				prod.add(new ImportedProduct(name, price, custormsFree));
			}
			System.out.println();
		}
		
		for (Product product : prod)
		{
			System.out.println(product.priceTag());
		}
		
		sc.close();
	}

}
