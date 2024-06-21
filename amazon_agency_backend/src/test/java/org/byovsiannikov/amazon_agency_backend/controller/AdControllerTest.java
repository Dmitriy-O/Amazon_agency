package org.byovsiannikov.amazon_agency_backend.controller;

import org.byovsiannikov.amazon_agency_backend.bom.Advertising;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(AdController.class)
class AdControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdController adController;

    @Test
    void shouldReturnSuccess () throws Exception {
        List<Advertising> ads = Arrays.asList(new Advertising("Ad 1", 100), new Advertising("Ad 2", 200));

        given(adController.getAds()).willReturn(ads);


        mockMvc.perform(get("/api/ads")).andExpect(status().isOk()).andExpect(content().contentType("application/json")).andExpect(jsonPath("$[0].name").value("Ad 1")).andExpect(jsonPath("$[1].name").value("Ad 2")).andExpect(jsonPath("$[0].performance").value(100)).andExpect(jsonPath("$[1].performance").value(200));
    }
}