package com.example.cars;

import entity.Car;
import entity.Color;
import entity.Owner;
import entity.Type;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import repository.CarRepo;
import repository.OwnerRepo;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
@SpringBootTest
class CarsApplicationTests {

	@Autowired
	private OwnerRepo ownerRepo;

	@Autowired
	private CarRepo carRepo;
	@Test
	public void shouldAddNewCar() {
		Car car = new Car();
		Owner owner = new Owner();
		createCar(car);
		owner.setCarSet(Stream.of(car).collect(Collectors.toSet()));
		Set<Car> carSet = owner.getCarSet();

		Assert.assertThat(carSet, is(1));
		Assert.assertEquals(carSet.stream().findFirst(), car);
	}
	private void createCar(Car car) {
		car.setMark("Mercedes");
		car.setModel("AMG");
		car.setColor(Color.BLACK);
		car.setType(Type.SEDAN);
	}

}
