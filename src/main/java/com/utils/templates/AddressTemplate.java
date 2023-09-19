package com.utils.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.github.javafaker.Faker;
import com.utils.fixtures.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressTemplate implements TemplateLoader {

    private Object[] getStreet() {
        Faker faker = new Faker();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(faker.address().streetAddress());
        }
        return list.toArray();
    }

    private Object[] getCity() {
        Faker faker = new Faker();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(faker.address().cityName());
        }
        return list.toArray();
    }

    @Override
    public void load() {
        Fixture.of(Address.class).addTemplate("validAddress", new Rule() {{
            add("street", random(getStreet()));
            add("city", random(getCity()));
        }});
    }
}
