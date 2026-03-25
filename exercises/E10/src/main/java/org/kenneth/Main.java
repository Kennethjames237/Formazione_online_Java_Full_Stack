package org.kenneth;

public class Main {
    public static void main(String[] args) {

        boolean usePaypal = false;
        AppContainer container = new AppContainer();
       PaymentService service = container.createPaymentService(usePaypal);
       service.makePayment(2323);




        System.out.println();
        System.out.println("-----stampa---------");
        container.stampaBeans();





    }
}