package ru.moskalets.spring.section002.task001.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.moskalets.spring.section002.task001.models.*;
import ru.moskalets.spring.section002.task001.stores.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CarbodyRepository carbodyRepository;

    @Autowired
    private MotorRepository motorRepository;

    @Autowired
    private TransmissionRepository transmissionRepository;

    public Iterable<CarSpring> findAllCarsWithBrand(int brandId) {
        Optional<BrandSpring> brandOptional = brandRepository.findById(brandId);
        BrandSpring brand = null;
        if (brandOptional.isPresent()) {
           brand = brandOptional.get();
        }
        return carRepository.findByBrand(brand);
    }

    public Iterable<CarSpring> findAllCarsLastDay() {
        long end = new Timestamp(System.currentTimeMillis()).getTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(end));
        cal.add(Calendar.DATE, -1);
        long start = cal.getTimeInMillis();
        return carRepository.findByDateBetween(start, end);
    }

    public Iterable<CarSpring> findAllCars() {
        return carRepository.findAll();
    }

    public Iterable<BrandSpring> findAllBrands() {
        return brandRepository.findAll();
    }

    public BrandSpring findBrandSpring(int brandSpringId) {
        return this.brandRepository.findById(brandSpringId).orElse(null);
    }

    public Iterable<CarSpring> findAllCarsWithImage() {
        return carRepository.findByImageBase64Not("");
    }

    public Iterable<CategorySpring> findAllCategoryesSpring() {
        return this.categoryRepository.findAll();
    }

    public CategorySpring findCategorySpring(int categorySpringId) {
        return this.categoryRepository.findById(categorySpringId).orElse(null);
    }

    public Iterable<CarbodySpring> findAllCarbodyesSpring() {
        return this.carbodyRepository.findAll();
    }

    public CarbodySpring findCarbodySpring(int carbodySpringId) {
        return this.carbodyRepository.findById(carbodySpringId).orElse(null);
    }

    public Iterable<MotorSpring> findAllMotorsSpring() {
        return this.motorRepository.findAll();
    }

    public MotorSpring findMotorSpring(int motorSpringId) {
        return this.motorRepository.findById(motorSpringId).orElse(null);
    }

    public Iterable<TransmissionSpring> findAllTransmissionsSpring() {
        return this.transmissionRepository.findAll();
    }

    public TransmissionSpring findTransmissionSpring(int transmissionSpringid) {
        return this.transmissionRepository.findById(transmissionSpringid).orElse(null);
    }

    public UserSpring findUserSpring(int userSpringId) {
        return this.userRepository.findById(userSpringId).orElse(null);
    }

    @Transactional
    public void addCarSpring(CarSpring carSpring) {
        this.carRepository.save(carSpring);
    }
}