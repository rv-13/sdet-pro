package com.utils.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.github.javafaker.Faker;
import com.utils.fixtures.Address;
import com.utils.fixtures.Employee;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTemplate implements TemplateLoader {

    private Object[] getFirstName() {
        Faker faker = new Faker();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(faker.name().firstName());
        }
        return list.toArray();
    }


    @Override
    public void load() {
        Address validAddress = Fixture.from(Address.class).gimme("validAddress");
        Fixture.of(Employee.class).addTemplate("valid", new Rule() {{
            add("id", random(Integer.class, range(100, 1000)));
            add("fname", random(getFirstName()));
            add("isFTE", random(true, false));
            add("roles", uniqueRandom(List.of("tester", "manager")));
            add("address", random(validAddress));
        }});

        Fixture.of(Employee.class).addTemplate("Invalid", new Rule() {{
            add("id", random(Integer.class, range(100, 1000)));
            add("fname", random("testing", "Test1", "Test2"));
            add("isFTE", random(true, false));
            add("roles", uniqueRandom(List.of("tester", "manager")));
            add("address", random(new Address("some str", "Noida")));
        }});

        Fixture.of(Employee.class).addTemplate("Invalidfname").inherits("valid", new Rule() {{
            add("fname", random("tes##ting", "Tes%@^^@t1", "Te%#%#st2"));
        }});

        Fixture.of(Employee.class).addTemplate("validId", new Rule() {{
            add("id", random(Integer.class, range(1000, 10000)));
        }});

    }

}
