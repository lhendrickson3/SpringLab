package lab2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * See if you can modify this class to use Spring as in Lab1.
 */
public class Startup {

    public static void main(String[] args) {
        // First create some low-level instances using
        // Liskov Substitution Principle
        
        final AbstractApplicationContext context =
                new ClassPathXmlApplicationContext(
                    new String[] {"tipConfig.xml"});

//        TipCalculator calc1 =
//           new FoodServiceTipCalculator(TipService.ServiceQuality.FAIR,125.00);
//
//        TipCalculator calc2 =
//           new BaggageServiceTipCalculator(TipService.ServiceQuality.GOOD,5);

        // Next, create the high-level class
        
  
        TipService tipMgr = (TipService)context.getBean("TipService");

        // Now ask the tip manager to do some work...
        double tip = tipMgr.getTip();
        String quality = tipMgr.getServiceQuality();

        TipCalculator tipCalc = tipMgr.getTipCalculator();
        // Now prove it works...
        System.out.println("\nThe tip for the "
                + tipCalc.getClass().getSimpleName() + " is: "
                + tip + ", with a service qualilty of: " + quality);

    }

}
