package com.tests.fixtures;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.utils.fixtures.Address;
import com.utils.fixtures.Employee;

import java.util.List;

public class RunnerImpl {
    public static void main(String[] args) {
        //conventianl way
        //Employee employee = new Employee(15, true, "test", new Address("ss", "city"), new ArrayList<>(Collections.singleton("sbs")));
        //Employee Object ->Create template -> Create and emp object using this template
        Fixture.of(Employee.class).addTemplate("valid", new Rule() {{
            add("id", random(Integer.class, range(100, 1000)));
            add("fname", random("testing", "Test1", "Test2"));
            add("isFTE", random(true, false));
            add("roles", uniqueRandom(List.of("tester", "manager")));
            add("address", random(new Address("some str", "Noida")));
        }});
        List<Employee> valid = Fixture.from(Employee.class).gimme(10, "valid");
        valid.forEach(System.out::println);
    }
}
