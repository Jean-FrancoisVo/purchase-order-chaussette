package fr.lacombe.cuisine.purchaseorder.domain;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:features/" })
public class PurchaseOrderFeaturesTest {

}
