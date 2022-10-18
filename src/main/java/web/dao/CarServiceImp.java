package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Service
public class CarServiceImp implements CarService {

    private final List<Car> cars;
    private static int COUNT;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++COUNT, "bmw", "black"));
        cars.add(new Car(++COUNT, "mers", "black"));
        cars.add(new Car(++COUNT, "audi", "black"));
        cars.add(new Car(++COUNT, "dodge", "black"));
        cars.add(new Car(++COUNT, "lambo", "black"));
    }


    @Override
    public List<Car> getCar(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }
}
