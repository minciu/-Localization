package com;


import java.util.Locale;
import java.util.ResourceBundle;


/**
 *
 * @author user
 */
public class SetLocale {
    
      
    public SetLocale(String languege){
            String camp = "res.Messages";
            Locale.setDefault(Locale.forLanguageTag(languege));
            Locale l =Locale.getDefault();
            ResourceBundle messages =ResourceBundle.getBundle(camp, l);
            System.out.println(messages.getString("locale.set"));
    }
    
    
    
    
}
