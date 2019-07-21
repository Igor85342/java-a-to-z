package ru.moskalets.spring.section002.task001;
import com.sun.jmx.snmp.Timestamp;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.moskalets.spring.section002.task001.models.CarSpring;
import ru.moskalets.spring.section002.task001.service.CarService;
import java.io.IOException;

@Controller
public class CarController {
    private static final Logger LOG = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showAllCars(ModelMap model) {
        model.put("brands", this.carService.findAllBrands());
        model.put("cars", this.carService.findAllCars());
    return "CarsView";
}

    @RequestMapping(value = "showCarsWithImage", method = RequestMethod.GET)
    public String showCarsWithImage(ModelMap model) {
        model.addAttribute("cars", this.carService.findAllCarsWithImage());
        model.put("brands", this.carService.findAllBrands());
        return "CarsView";
    }

    @RequestMapping(value = "showCarsLastDay", method = RequestMethod.GET)
    public String showCarsLastDay(ModelMap model) {
        model.addAttribute("cars", this.carService.findAllCarsLastDay());
        model.addAttribute("brands", this.carService.findAllBrands());
        return "CarsView";
    }

    @RequestMapping(value = "showCarsWithBrand", method = RequestMethod.GET)
    public String showCarsWithBrand(@RequestParam("brand") int brand, ModelMap model) {
        model.addAttribute("cars", this.carService.findAllCarsWithBrand(brand));
        model.addAttribute("brands", this.carService.findAllBrands());
        return "CarsView";
    }

    @RequestMapping(value = "createCar", method = RequestMethod.GET)
    public String createCar(ModelMap model) {
        model.addAttribute("categories", this.carService.findAllCategoryesSpring());
        model.addAttribute("brands", this.carService.findAllBrands());
        model.addAttribute("carbodyes", this.carService.findAllCarbodyesSpring());
        model.addAttribute("motors", this.carService.findAllMotorsSpring());
        model.addAttribute("transmissions", this.carService.findAllTransmissionsSpring());
        return "CarCreateView";
    }

    @RequestMapping(value = "createCar", method = RequestMethod.POST)
    public String createCar(@RequestParam("file") MultipartFile file,
                          @RequestParam(value = "category") int category,
                          @RequestParam("brand") int brand,
                          @RequestParam("carbody") int carbody,
                          @RequestParam("motor") int motor,
                          @RequestParam("transmission") int transmission
    ) throws IOException {
        String imageBase64 = Base64.encode(file.getBytes());
        this.carService.addCarSpring(new CarSpring(
                this.carService.findCategorySpring(category),
                this.carService.findBrandSpring(brand),
                this.carService.findCarbodySpring(carbody),
                this.carService.findMotorSpring(motor),
                this.carService.findTransmissionSpring(transmission),
                imageBase64,
                false,
                this.carService.findUserSpring(1),
                new Timestamp(System.currentTimeMillis()).getDateTime()
        ));
        return "redirect:/cars/";
    }
}
