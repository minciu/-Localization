package app;





import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.lang.reflect.InvocationTargetException;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;



public class LocaleExplore {

	public static void main(String[] args) {
		

		String camp = "res.Messages";
        Locale locale = Locale.getDefault();
        Scanner scanner = new Scanner(System.in);
        
       while(true){
           
           ResourceBundle messages = ResourceBundle.getBundle(camp, locale);
           System.out.println(messages.getString("prompt"));
           String command = scanner.nextLine();
           if(command.equals("Info")){
               new Info();
           }else if(command.equals("Display")){
               new DisplayLocales();
           }else if(command.equals("Set")){
               System.out.println("Locale: ");
               System.out.println("Tastati 1 pentru romana");
               System.out.println("Tipo 2 per l'italiano");
               System.out.println("Type 3 pour le français");
               System.out.println("Type something else for English");
               System.out.println(messages.getString("Type"));
               String option = scanner.nextLine();
               String local;
               if(option.equals("1")){
                   local="ro-RO";
               }else
                   if(option.equals("2")){
                   local="it-IT";
               }
                   else
                   if(option.equals("3")){
                   local="fr-FR";
               }
                   else                
                   local="en-US";
                
               new SetLocale(local);
           }else if(command.equals("Exit")){
               System.out.println(messages.getString("Exit"));
               break;
           }else System.out.println(messages.getString("invalid"));
           
           
       }
		
       
		
		
	}  
		
	private static Locale execute(String s, Locale locale) {
        java.lang.reflect.Method method;
        if (s.equals(getName("display-locale"))) {
            String implementation = implementation("display-locale");
            try {
                method = Class.forName(implementation).newInstance().getClass().getMethod("DisplayLocales");
                method.invoke(Class.forName(implementation).newInstance(), locale);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } else if (s.equals(getName("set-locale"))) {
            String implementation = implementation("set-locale");
            try {
                method = Class.forName(implementation).newInstance().getClass().getMethod("SetLocale");
                locale = (Locale) method.invoke(Class.forName(implementation).newInstance(), locale);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } else if (s.equals(getName("info-locale"))) {
            String implementation = implementation("info-locale");
            try {
                method = Class.forName(implementation).newInstance().getClass().getMethod("Info");
                method.invoke(Class.forName(implementation).newInstance(), locale);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } 
        return locale;
    }

    /**
     * Returns the string that the user has to type in order to execute the command
     *
     * @param command
     * @return
     */
    private static String getName(String command) {
        Properties prop = new Properties();
        InputStream stream = LocaleExplore.class.getResourceAsStream("/commands.properties");
        try {
            prop.load(stream);
            String str = prop.getProperty(command + ".command");
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * Returns the name of the class where the command is implemented
     *
     * @param command
     * @return
     */
    private static String implementation(String command) {
        Properties prop = new Properties();
        InputStream stream = LocaleExplore.class.getResourceAsStream("/commands.properties");
        try {
            prop.load(stream);
            String str = prop.getProperty(command + ".impl");
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
