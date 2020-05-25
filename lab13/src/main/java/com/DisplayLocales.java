package com;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author user
 */
public class DisplayLocales {
	
    public DisplayLocales() {
        String camp = "res.Messages";
        Locale locale =Locale.getDefault();
        ResourceBundle messages =ResourceBundle.getBundle(camp, locale);
        System.out.println(messages.getString("locale.set"));
        System.out.println(Locale.getDefault().getDisplayCountry()+"\t"+Locale.getDefault().getDisplayLanguage());
        System.out.println(messages.getString("locales"));
        Locale available[] = Locale.getAvailableLocales();
        for(Locale l : available) {
            System.out.println(l.getDisplayCountry() + "\t" +
                    l.getDisplayLanguage(l));
        }
    }
    
    
}
