package com;

import java.text.DateFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;


import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.json.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author user
 */
public class Info {
    private static final String Url = "http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
    private static final ResteasyClient client = new ResteasyClientBuilder().build();
    
    public Info() {
        String camp = "res.Messages";
        Locale l = Locale.getDefault();
        ResourceBundle messages = ResourceBundle.getBundle(camp, l);
        System.out.println(messages.getString("info"));
        System.out.println(messages.getString("Country")+" "+l.getDisplayCountry());
        System.out.println(messages.getString("Language")+" "+l.getDisplayLanguage());
        System.out.println(messages.getString("Currency")+" "+Currency.getInstance(l));
        String[] weekDays = new DateFormatSymbols(l).getWeekdays();
        System.out.println(messages.getString("Week_days")+" "+Arrays.toString(weekDays));
        String[] months=new DateFormatSymbols(l).getMonths();
        System.out.println(messages.getString("Months")+" "+Arrays.toString(months));
        LocalDateTime today=LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(l);
        System.out.println(messages.getString("Today")+" "+today.format(dtf));
        System.out.println("Capital: " + getCapitalByCountryCode(l.getISO3Country()));
        System.out.println("Continent: " + getContinentByCountryCode(l.getISO3Country()));
    }
    
    
    public static String getCapitalByCountryCode(String countryCode) {
        ResteasyWebTarget target = client.target(Url + "/CapitalCity/JSON/debug");
        Response response = target.queryParam("sCountryISOCode", countryCode).request(MediaType.APPLICATION_JSON).get();
        String value = response.readEntity(String.class);
        response.close();
        return value;
    }

    public static String getContinentByCountryCode(String countryCode) {
        ResteasyWebTarget target = client.target(Url + "/FullCountryInfo/JSON/debug");
        Response response = target.queryParam("sCountryISOCode", countryCode).request(MediaType.APPLICATION_JSON).get();
        String value = response.readEntity(String.class);
        response.close();
        JSONObject jsonObject = new JSONObject(value);
        return jsonObject.getString("sContinentCode");
    }
    
    
    
}
