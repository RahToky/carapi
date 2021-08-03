package mg.rmahatoky.carapi.service;

import mg.rmahatoky.carapi.model.entity.Car;

public interface ICarService {

    Iterable<Car> getCars();

    Car saveCar(Car car);

    Car findCarById(int id);

}
