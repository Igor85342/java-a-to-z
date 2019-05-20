package ru.moskalets.spring.section002.task001;

import com.sun.jmx.snmp.Timestamp;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.moskalets.hibernate.section002.task001.*;
import java.io.IOException;

@Controller
public class CarController {
    private static final Logger LOG = LoggerFactory.getLogger(CarController.class);
    private final ValidateService validateService = ValidateService.getInstance();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showAllCars(ModelMap model) {
    model.addAttribute("cars", validateService.getAllCar());
    model.addAttribute("brands", validateService.getAllBrands());
    return "CarsView";
}

    @RequestMapping(value = "showCarsWithImage", method = RequestMethod.GET)
    public String showCarsWithImage(ModelMap model) {
        model.addAttribute("cars", validateService.getCarWithImage());
        model.addAttribute("brands", validateService.getAllBrands());
        return "CarsView";
    }

    @RequestMapping(value = "showCarsLastDay", method = RequestMethod.GET)
    public String showCarsLastDay(ModelMap model) {
        model.addAttribute("cars", validateService.getCarLastDay());
        model.addAttribute("brands", validateService.getAllBrands());
        return "CarsView";
    }

    @RequestMapping(value = "showCarsWithBrand", method = RequestMethod.GET)
    public String showCarsWithBrand(@RequestParam("brand") int brand, ModelMap model) {
        model.addAttribute("cars", validateService.getCarWithBrand(brand));
        model.addAttribute("brands", validateService.getAllBrands());
        return "CarsView";
    }

    @RequestMapping(value = "createCar", method = RequestMethod.GET)
    public String createCar(ModelMap model) {
        model.addAttribute("categories", this.validateService.getAllCategories());
        model.addAttribute("brands", this.validateService.getAllBrands());
        model.addAttribute("carbodyes", this.validateService.getAllCarbodyes());
        model.addAttribute("motors", this.validateService.getAllMotors());
        model.addAttribute("transmissions", this.validateService.getAllTransmissions());
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
        this.validateService.addCar(new CarXML(
                new Category(category),
                new Brand(brand),
                new CarbodyXML(carbody),
                new MotorXML(motor),
                new TransmissionXML(transmission),
                imageBase64,
                false,
                this.validateService.getUserById(1),
                new Timestamp(System.currentTimeMillis()).getDateTime()
        ));
        return "redirect:/cars/";
    }
}
