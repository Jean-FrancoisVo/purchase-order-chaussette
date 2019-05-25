package fr.lacombe.cuisine.purchaseorder.infra;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:features/" },
        plugin = {"pretty", "html:toto"})
public class PurchaseOrderControllerTest {

}
