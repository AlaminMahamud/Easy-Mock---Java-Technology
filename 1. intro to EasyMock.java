//package "<name of the package>";

/// importing statements

import java.util.ArrayList;
import java.util.List;

import org.EasyMock.EasyMock;

public class PortfolioTester
{
	public static void main(String[] args)
	{
		// create a portfolio object which is to be tested
		Portfolio portfolio = new Portfolio();

		// create a list of stocks to be added to the portfolios

		List stocks = new ArrayList();
		Stock googleStock = new Stock("1", "Google", 10);
		Stock microsoftStock = new Stock("2", "Microsoft", 100);

		stocks.add(googleStock);
		stocks.add(microsoftStock);

		// create the mock object of stock service
		StockService stockService = EasyMock.createMock(StockService.class);

		// mock the behavior of stock service to return the value of various stocks
		EasyMock.expect(googleStock).andReturn(50.00);
		EasyMock.expect(microsoftStock).andReturn(100.00);

		EasyMock.replay(stockServiceMock);

		// and stocks to the portfolio
		portfolio.setStocks(stocks);

		// set the stockService to the portfolio
		portfolio.setStockService(stockService);

		double marketValue = portfolio.getMarketValue();

		// verify the market value to be 
		// 10 * 50.00 + 100* 1000.00 = 500.00 + 10000.000 = 100500
		System.out.println("Market Value of the portfolio : " + marketValue);
	}
}