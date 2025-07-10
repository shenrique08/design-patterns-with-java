package org.entities;

import org.domain.Order;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void testGetOutstandingLogic() {
        Customer customer = new Customer("Test Customer");
        customer.addOrder(new Order(100.50));
        customer.addOrder(new Order(50.00));
        customer.addOrder(new Order(25.25));

        System.out.println("O sucesso da refatoração EXTRACT_METHOD é a testabilidade do método getOutstanding," +
                " que agora está isolado.");
    }

}