package br.com.runners;

import br.com.tests.auth.tests.PostAuthTest;
import br.com.tests.ping.tests.GetPingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.suites.SmokeTests.class)
@Suite.SuiteClasses({
        PostAuthTest.class,
        GetPingTest.class
})
public class SmokeTests {
}
