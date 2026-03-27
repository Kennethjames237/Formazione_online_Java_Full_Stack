import Interface.IPaymentProcessor;
import Logger.TransactionLogger;
import Processor.CreditCardProcessor;
import Processor.PaypalProcessor;
import Service.PaymentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PaymentService service = context.getBean(PaymentService.class);
        service.makePayment(123);

        PaymentService service1 = context.getBean(PaymentService.class);


        context.close();
    }


}