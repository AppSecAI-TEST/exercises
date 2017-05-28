package org.dp.structural.abstractdoc.domain;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by David Marques on 28/05/2017.
 */
public class CarAndPartTest {

    private static final String CAR_MODEL = "BMW";
    private static final long CAR_PRICE = 1200;
    private static final String PART_MODEL = "SEAT";
    private static final long PART_PRICE = 300;
    private static final String PART_TYPE = "VIP";


    @Test
    public void shouldCreateCarWithAllProperties() throws Exception {

        Car myCar = new Car(new HashMap<>());
        myCar.put(HasModel.PROPERTY_KEY, CAR_MODEL);
        myCar.put(HasPrice.PROPERTY_KEY, CAR_PRICE);
        myCar.put(HasParts.PROPERTY_KEY, Arrays.asList(new HashMap<>(), new HashMap<>()));

        assertThat(myCar.getModel().get()).isEqualTo(CAR_MODEL);
        assertThat(myCar.getPrice().get()).isEqualTo(CAR_PRICE);
        assertThat(myCar.getParts().count()).isEqualTo(2);
    }

    @Test
    public void shouldCreatePartWithAllProperties() throws Exception {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put(HasModel.PROPERTY_KEY, PART_MODEL);
        properties.put(HasType.PROPERTY_KEY, PART_TYPE);
        properties.put(HasPrice.PROPERTY_KEY, PART_PRICE);
        Part part = new Part(properties);

        assertThat(part.getModel().get()).isEqualTo(PART_MODEL);
        assertThat(part.getPrice().get()).isEqualTo(PART_PRICE);
        assertThat(part.getType().get()).isEqualTo(PART_TYPE);

    }


}