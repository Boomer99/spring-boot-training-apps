package com.neueda.payments;

import com.neueda.payments.control.PaymentsController;
import com.neueda.payments.exceptions.NoMatchingPaymentException;
import com.neueda.payments.model.Payment;
import com.neueda.payments.repositories.PaymentsRepository;
import com.neueda.payments.repositories.UserRepository;
import com.neueda.payments.service.PaymentsService;
import com.neueda.payments.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@SpringBootTest
// @ExtendWith is used to register extensions that provide additional functionality to test classes
@ExtendWith(SpringExtension.class)
// Add this specify which classes to ignore. In this case, we want to ignore the real data source. Mocking preferred.
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
class PaymentsApplicationTests {

	@Autowired
	private PaymentsController paymentsController;

	@Autowired
	private PaymentsService paymentsService;

	@Autowired
	private UserService userService;

	@MockBean
	private PaymentsRepository paymentsRepository;

	@MockBean
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void setup() {

	}

	@Test
	void testPaymentsWithSameIdAreEqual() {
		Payment payment1 = new Payment();
		payment1.setId(17l);
		Payment payment2 = new Payment();
		payment2.setId(17l);

		Assertions.assertEquals(payment1, payment2);
	}

	@Test
	void testFindByIdWithNoResultsShouldThrow() {
		Mockito.when(paymentsRepository.findById(1234l)).thenReturn(Optional.empty());
		Assertions.assertThrows(NoMatchingPaymentException.class,
				() -> paymentsService.getById(1234l));

	}

	@Test
	void testGetDistinctListOfPaymentCountries() {

		Mockito.when(paymentsRepository.findAll()).thenReturn(getMockPaymentsList());

		Assertions.assertEquals(getMockPaymentsList(), paymentsService.getDistinctListOfPaymentCountries());
	}


	List<Payment> getMockPaymentsList() {
		Payment payment1 = new Payment();
		payment1.setCountry("IRL");
		Payment payment2 = new Payment();
		payment2.setCountry("ESP");
		Payment payment3 = new Payment();
		payment3.setCountry("CAN");
		Payment payment4 = new Payment();
		payment4.setCountry("FR");
		Payment payment5 = new Payment();
		payment5.setCountry("FR");

		return List.of(payment1, payment2, payment3, payment4, payment5);
	}


}
