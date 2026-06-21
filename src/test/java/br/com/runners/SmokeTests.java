package br.com.runners;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.suites.SmokeTests.class)
@Suite.SuiteClasses({

})
public class SmokeTests {
}
