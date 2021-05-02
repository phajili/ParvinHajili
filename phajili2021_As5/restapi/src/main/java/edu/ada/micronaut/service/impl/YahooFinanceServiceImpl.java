package edu.ada.micronaut.service.impl;

import edu.ada.micronaut.service.FinancialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import javax.inject.Singleton;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@Singleton
public class YahooFinanceServiceImpl implements FinancialService {

    protected static final Logger logg = LoggerFactory.getLogger(YahooFinanceServiceImpl.class);


    @Override
    public Object getFinancialData(String stock_index) {

        Stock stock = null;
        BigDecimal price = BigDecimal.ONE;
        try {
            stock = YahooFinance.get(stock_index);
            price = stock.getQuote(true).getPrice();
            logg.info("Price of Stock:" + price);
            return price;
        } catch (IOException e) {
            logg.error(e.getMessage());
        }

        return price;
    }
    @Override
    public Object getAllFinancialData() {
        Map<String, Stock> stocks = null;
        try {
            String[] symbls = new String[] {"YHOO","INTC", "GOOG", "TSLA", "AIR.PA", "BABA"};
            logg.info("Indexes: \"YHOO\", \"INTC\", \"GOOG\", \"TSLA\", \"AIR.PA\", \"BABA\" ");
            stocks = YahooFinance.get(symbls);
            logg.info("Prices:" + stocks.toString()); }
        catch (IOException e) {
            logg.error(e.getMessage());}

        return stocks.toString();
    }
}
