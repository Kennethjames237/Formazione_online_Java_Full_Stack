import Interface.IPaymentProcessor;
import Logger.TransactionLogger;
import Processor.CreditCardProcessor;
import Processor.PaypalProcessor;
import Service.PaymentService;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {
    private boolean usePaypal;
    @Bean
    public IPaymentProcessor paymentProcessor(){
        return new PaypalProcessor();
    }

    @Bean
    public IPaymentProcessor creditCardProcessor(){
        return new CreditCardProcessor();
    }

    @Bean
    public PaymentService paymentService(){
        PaymentService service = new PaymentService(this.paymentProcessor(),this.transactionLogger());
        return service;
    }

    @Bean
    public TransactionLogger transactionLogger(){
        return new TransactionLogger();
    }


    @PreDestroy
    public void shutdown(){
        System.out.println("Chuisura del servizio....");
    }



}
