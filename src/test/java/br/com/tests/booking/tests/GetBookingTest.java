package br.com.tests.booking.tests;

import br.com.base.BaseTest;
import br.com.suites.AllTests;
import br.com.suites.SmokeTests;
import br.com.tests.booking.requests.GetBookingRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.*;

public class GetBookingTest extends BaseTest {

    private final GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Category({SmokeTests.class, AllTests.class})
    public void deveRetornarStatus200EListaContendoIdsDasReservas_QuandoEnviarRequisicaoSemNenhumFiltro() {

        getBookingRequest.executeGetAllBookingIds()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }
}
