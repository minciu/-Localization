package app;




import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;


public class LocaleExplore {

	public static void main(String[] args) {
		

		String camp = "res.Messages";
        Locale l = Locale.getDefault();
        Scanner scanner = new Scanner(System.in);
        
       while(true){
           
           ResourceBundle messages = ResourceBundle.getBundle(camp, l);
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
               String locale;
               if(option.equals("1")){
                   locale="ro-RO";
               }else
                   if(option.equals("2")){
                   locale="it-IT";
               }
                   else
                   if(option.equals("3")){
                   locale="fr-FR";
               }
                   else                
                   locale="en-US";
                
               new SetLocale(locale);
           }else if(command.equals("Exit")){
               System.out.println(messages.getString("Exit"));
               break;
           }else System.out.println(messages.getString("invalid"));
           
           
       }
		
		
	}
}
