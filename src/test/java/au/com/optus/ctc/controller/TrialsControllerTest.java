package au.com.optus.ctc.controller;

import au.com.optus.ctc.dao.TrialsSummaryRepository;
import au.com.optus.ctc.service.TrialFilterServiceIF;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author revathyms
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TrialsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TrialFilterServiceIF service;

    @MockBean
    private TrialsSummaryRepository repository;

    @Autowired
    ObjectMapper mapper;

    @WithMockUser("root")
    @Test
    public void testFetchMatchingTrials() throws Exception {

        String conditionJson = "{\"pmp\":\"Y\",\"age\":24,\"sex\":\"F,M\",\"nodalStatus\":\"Y/N\",\"spreadToOtherParts\":\"N\",\"tumourSize\":\"15\",\"nodeNumber\":\"1-3\",\"accountUserId\":\"50\"}";
        String summary = "[{\"stage\":\"Early (NA)\",\"subtype\":\"TNBC\",\"name\":\"CHARIOT\",\"summary\":\"Phase II study evaluating efficacy and safety of Ipilimumab and Nivolumab with neoadjuvant weekly paclitaxel after anthracycline based chemotherapy in high-risk primary TNBC, followed by definitive surgery and 1 year  of Nivolumab - Stage III (AJCC 8th Ed.) i.e. > T1N1 or T2N0 - Residual tumour size ? 15mm after neoadjuvant AC/EC\",\"phase\":\"2\",\"trialGovRegId\":\"\",\"anzctrRegId\":\"ACTRN12617000651381\",\"bct\":\"ANZ 1702\",\"location\":\"CH,MH,MUH,LIFEH,WMH\",\"postcode\":\"2060,2109,2050,2145,2560\",\"gender\":\"F,M\",\"pmp\":\"Y\",\"age\":18,\"tumourSize\":15,\"nodeNumber\":\"0,1-3\",\"spreadToOtherParts\":\"N\",\"id\":8,\"createdOn\":\"2019-09-22T10:18:44.000+0000\",\"updatedOn\":\"2019-09-22T10:18:44.000+0000\"},{\"stage\":\"Early (Adjuvant)\",\"subtype\":\"HR+ or TNBC\",\"name\":\"OlympiA\",\"summary\":\"A randomised double-blind study to assess efficacy and safety of olaparib vs placebo as adjuvant treatment in patients with germline BRCA1/2 mutations and high risk HER2 negative breast cancer\",\"phase\":\"3\",\"trialGovRegId\":\"NCT02032823\",\"anzctrRegId\":\" \",\"bct\":\"BCT 1404\",\"location\":\"CRGH\",\"postcode\":\"2139\",\"gender\":\"F,M\",\"pmp\":\"Y\",\"age\":18,\"tumourSize\":0,\"nodeNumber\":\"0,1-3,4-9,>10\",\"spreadToOtherParts\":\"N\",\"id\":12,\"createdOn\":\"2019-09-23T02:29:48.000+0000\",\"updatedOn\":\"2019-09-23T02:29:48.000+0000\"},{\"stage\":\"Early (Adjuvant)\",\"subtype\":\"HR+\",\"name\":\"NATALEE\",\"summary\":\"Ribociclib With Endocrine Therapy as an Adjuvant Treatment in Patients With Hormone Receptor-positive, HER2-negartive Early Breast Cancer\",\"phase\":\"3\",\"trialGovRegId\":\"NCT03701334\",\"anzctrRegId\":\" \",\"bct\":\" \",\"location\":\"CH,LH,MUH,NCI,NH,STG,SAN,STV\",\"postcode\":\"2560,2170,2109,2065,2747,2217,2076,2010\",\"gender\":\"F,M\",\"pmp\":\"Y\",\"age\":18,\"tumourSize\":0,\"nodeNumber\":\"0,1-3,4-9,>10\",\"spreadToOtherParts\":\"N\",\"id\":13,\"createdOn\":\"2019-09-23T02:29:48.000+0000\",\"updatedOn\":\"2019-09-23T02:29:48.000+0000\"}]";
        mvc.perform(post("http://localhost:9090/api/ctc/trials/matchingTrials")
                .content(conditionJson).accept(MediaType.APPLICATION_JSON)
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
                .andExpect(status().isOk());

    }

}
