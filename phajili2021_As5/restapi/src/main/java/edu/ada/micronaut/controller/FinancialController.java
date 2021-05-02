package edu.ada.micronaut.controller;

public interface FinancialController {

    Object getFinancialData(String financial_data_provider, String stock_index);

    Object getBatchFinanceData (String financial_data_provide, String stock_index);

}
