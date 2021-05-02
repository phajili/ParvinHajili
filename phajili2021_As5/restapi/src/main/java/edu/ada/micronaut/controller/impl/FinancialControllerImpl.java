package edu.ada.micronaut.controller.impl;

import edu.ada.micronaut.controller.FinancialController;
import edu.ada.micronaut.service.FinancialService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Controller(value = "/financial")
@Secured(SecurityRule.IS_AUTHENTICATED)
public class FinancialControllerImpl implements FinancialController {

    protected static final Logger logg = LoggerFactory.getLogger(FinancialControllerImpl.class.getName());

    @Inject
    private FinancialService financialService;

    @Override
    @Get(value = "/data")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getFinancialData(
            @QueryValue("provider") String financial_data_provider,
            @QueryValue("stock_index") String stock_index) {
        if(financial_data_provider.equals("yahoo")) {
            logg.info("Data provider:"+financial_data_provider);
            return financialService.getFinancialData(stock_index.toUpperCase());
        } else {
            logg.info("Data provider:" +financial_data_provider);
            return HttpResponse.badRequest("Name Is Invalid");
        }
    }

    @Override
    @Get("/batch_data")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getBatchFinanceData(@QueryValue("provider") String financial_data_provider,
                                      @QueryValue("stock_index") String stock_index) {

        String[] stockIndexArray = stock_index.split(",");
        String result = "";

        for(String stock : stockIndexArray) {
            if (financial_data_provider.equals("yahoo")) {
                logg.info("Data provider:" + financial_data_provider);
                result += stock + ": " +financialService.getFinancialData(stock) + "\n";
            } else {
                logg.info("Data provider:" + financial_data_provider);
                return HttpResponse.badRequest("Name Is Invalid");
            }
        }

        return result;
    }

}
