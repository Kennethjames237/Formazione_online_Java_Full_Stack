package org.kenneth;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AppContainer {
    private Map<String , Object> beans = new HashMap<>();
    private boolean usePasypal;


    public IPaymentProcessor createProcessor(boolean usePaypal){
        this.usePasypal = usePaypal;
        if(beans.containsKey("processor")){
            return (IPaymentProcessor) beans.get("processor");
        }

        if(this.usePasypal){
            PayPalProcessor paypal =  new PayPalProcessor();
            beans.put("processor",paypal);
            return paypal;
        }else {
            CreditCardProcessor card = new CreditCardProcessor();
            beans.put("processor",card);
            return card;
        }

    }
    public TransactionLogger createTransactionLogger(){
        if(beans.containsKey("Transaction")){
            return (TransactionLogger) beans.get("Transaction");
        }
        TransactionLogger transactionLogger = new TransactionLogger();
        beans.put("Transaction",transactionLogger);
        return  transactionLogger;
    }
    public PaymentService createPaymentService(boolean usePaypal){
        if(beans.containsKey("service")){
            return (PaymentService) beans.get("service");
        }

        PaymentService service = new PaymentService(createProcessor(usePaypal), createTransactionLogger());
        beans.put("service",service);
        return service;
    }
    public void stampaBeans(){
        for(Map.Entry<String , Object> n : beans.entrySet()){
            System.out.println(n.getKey() + " : " + n.getValue());
        }

    }
    public Object getBean(String name){
        return beans.get(name);
    }

}
