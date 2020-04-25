package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program 
{

	public static void main(String[] args) throws ParseException 
	{
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
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
		 
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List <Product> prod = new ArrayList<> ();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++)
		{
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if (ch == 'c')
			{
				prod.add(new Product(name, price));
			}
			
			if (ch == 'u')
			{
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				prod.add(new UsedProduct(name, price, manufactureDate));
			}
			
			if (ch == 'i')
			{
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
		*/
		
		/*
		 * Fazer um programa para ler os dados de N contribuintes (N fornecido pelo usuário), os quais
		 * podem ser pessoa física ou pessoa jurídica, e depois mostrar o valor do imposto pago por cada um,
		 * bem como o total de imposto arrecadado.
		 * Os dados de pessoa física são: nome, renda anual e gastos com saúde. Os dados de pessoa jurídica
		 * são nome, renda anual e número de funcionários. As regras para cálculo de imposto são as
		 * seguintes:
		 * Pessoa física: pessoas cuja renda foi abaixo de 20000.00 pagam 15% de imposto. Pessoas com
		 * renda de 20000.00 em diante pagam 25% de imposto. Se a pessoa teve gastos com saúde, 50%
		 * destes gastos são abatidos no imposto.
		 * Exemplo: uma pessoa cuja renda foi 50000.00 e teve 2000.00 em gastos com saúde, o imposto
		 * fica: (50000 * 25%) - (2000 * 50%) = 11500.00
		 * Pessoa jurídica: pessoas jurídicas pagam 16% de imposto. Porém, se a empresa possuir mais de 10
		 * funcionários, ela paga 14% de imposto.
		 * Exemplo: uma empresa cuja renda foi 400000.00 e possui 25 funcionários, o imposto fica:
		 * 400000 * 14% = 56000.00
		 */
		 
		List <TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++)
		{
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			
			
			if (ch == 'i')
			{
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			}
			else
			{
				System.out.print("Number of employees: ");
				int numberOfEmployee = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployee));
			}
			System.out.println();
		}
		
		System.out.println("TAXES PAID: ");
		
		for (TaxPayer taxpayer : list)
		{
			System.out.println(taxpayer.getName()+ " $ " + String.format("%.2f", taxpayer.tax()));
		}
		
		double total = 0;
		
		for (TaxPayer taxpayer : list)
		{
			total += taxpayer.tax();
		}
		System.out.println();
		System.out.print("TOTAL TAXES: " + String.format("%.2f", total));
		
		sc.close();
	}

}
