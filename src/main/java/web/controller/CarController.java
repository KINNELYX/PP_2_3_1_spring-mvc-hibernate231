package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService cars;

    @Autowired
    public CarController(CarService carDao) {
        this.cars = carDao;
    }

    @GetMapping
    public String getCars(@RequestParam(name = "count", defaultValue = "5") int count, Model model) {
        if (count < 0) {
            model.addAttribute("cars", cars.getCars());
            return "cars";
        }
        model.addAttribute("cars", cars.getCar(count));
        return "cars";
    }
}
