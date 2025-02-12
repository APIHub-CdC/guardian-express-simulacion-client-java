package io.GuardianExpressSimulacion.client.api;

import java.util.concurrent.TimeUnit;

import io.GuardianExpressSimulacion.client.model.CatalogoEstados;
import io.GuardianExpressSimulacion.client.model.RequestDatosGenerales;
import io.GuardianExpressSimulacion.client.model.RequestDatosGeneralesPersona;
import io.GuardianExpressSimulacion.client.model.RequestDatosGeneralesPersonaDomicilio;
import io.GuardianExpressSimulacion.client.model.ResponseGuardianDG;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.GuardianExpressSimulacion.client.ApiClient;
import okhttp3.OkHttpClient;

public class GuardIAnExpressApiTest {
    private final GuardIAnExpressApi api = new GuardIAnExpressApi();
    
    private Logger logger = LoggerFactory.getLogger(GuardIAnExpressApiTest.class.getName());

    private ApiClient apiClient;
    private String xApiKey = "YOUR_APIKEY";
    private String url = "https://services.circulodecredito.com.mx/v1/guardian-express/sandbox";
    
    @Before()
    public void setUp() {
    	 
		this.apiClient = api.getApiClient();
        this.apiClient.setBasePath(url);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
               .readTimeout(30, TimeUnit.SECONDS)
               .build();
        apiClient.setHttpClient(okHttpClient);
    }
    
    @Test
    public void creditreportTest() throws Exception {

        RequestDatosGenerales requestDatosGenerales = new RequestDatosGenerales();
        requestDatosGenerales.setFolioOtorgante(100000001);
        RequestDatosGeneralesPersona requestDatosGeneralesPersona = new RequestDatosGeneralesPersona();
        requestDatosGeneralesPersona.setPrimerNombre("GUILLERMO");
        requestDatosGeneralesPersona.setApellidoPaterno("PRUEBATROAY");
        requestDatosGeneralesPersona.setApellidoMaterno("MALDONADO");
        requestDatosGeneralesPersona.setFechaNacimiento("1962-09-07");
        requestDatosGeneralesPersona.setRFC("PUMG620907CM6");
        RequestDatosGeneralesPersonaDomicilio requestDatosGeneralesPersonaDomicilio = new RequestDatosGeneralesPersonaDomicilio();
        requestDatosGeneralesPersonaDomicilio.setDireccion("INGENIEROS MILITARES NO. 65");
        requestDatosGeneralesPersonaDomicilio.setColonia("LOMAS DE SOTELO");
        requestDatosGeneralesPersonaDomicilio.setDelegacionMunicipio("Miguel Hidalgo");
        requestDatosGeneralesPersonaDomicilio.setCiudad("MEXICO");
        requestDatosGeneralesPersonaDomicilio.setEstado(CatalogoEstados.CDMX);
        requestDatosGeneralesPersonaDomicilio.setCp("11200");
        requestDatosGeneralesPersona.setDomicilio(requestDatosGeneralesPersonaDomicilio);
        requestDatosGenerales.setPersona(requestDatosGeneralesPersona);

        ResponseGuardianDG response = api.creditreport(this.xApiKey, requestDatosGenerales);
        System.out.println(response.toString());
        logger.info("Report: "+response.toString());
        
        Assert.assertTrue(response.getFolioConsulta() != null);
    }

}
