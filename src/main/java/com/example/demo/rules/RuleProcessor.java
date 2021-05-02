package com.example.demo.rules;

import com.example.demo.enumFactory.BankType;
import com.example.demo.factory.Bank;
import com.example.demo.factory.factoryImpl.BankFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class RuleProcessor {

    public static void main(String[] args) throws JsonProcessingException {
        String ss = "{\"campaign_inclusive_conditions\":[{\"type\":\"BUY_CATE_GROUP\",\"data\":{\"values\":[{\"name\":\"fsdfsdfs\"" +
                ",\"id\":\"d6c48a6b-6011-4af8-80c4-d286dcf5768c\"}]}},{\"type\":\"BUY_CATE\",\"data\":{\"values\":[{\"name\":\"gdfgdf345345\"" +
                ",\"id\":\"8b9d55ea-8e71-4295-adb9-8a09e05bbedf\"},{\"name\":\"fsdfsdf535435\",\"id\":\"b31afc6e-1e6e-41e6-b672-062382b25edb\"}]}}" +
                ",{\"type\":\"" +
                "\",\"data\":{\"values\":[{\"name\":\"453t3f34f43f\",\"id\":\"9cfd0960-a18e-4b69-8f26-2cb4b1884661\"}" +
                ",{\"name\":\"343\",\"id\":\"a739e3f4-d2e0-4469-9d46-27abd10365fc\"}]}},{\"type\":\"BUY_BRAND\"" +
                ",\"data\":{\"values\":[{\"name\":\"Fooddy 1\",\"id\":\"92eab633-005b-401f-8658-0e365f41f67a\"}" +
                ",{\"name\":\"samsung\",\"id\":\"5e38785b-bd09-410f-af00-5714e2faabe2\"},{\"name\":\"panasonic huyen\"" +
                ",\"id\":\"2473f7f1-0272-490e-bc51-a5db137ef09d\"},{\"name\":\"SUNHOUSE\",\"id\":\"f731b316-86b8-4558-af1e-701ba168faa6\"}]}}" +
                ",{\"type\":\"BUY_PRODUCT\",\"data\":{\"values\":[{\"name\":\"Dutch Lady PuRE\"" +
                ",\"id\":\"218a3692-1cec-4412-adec-bf2bd31c3972\",\"quantity\":200},{\"name\":\"EVAP 3CROWNS VG 8 BOX 48X160G TIN\"" +
                ",\"id\":\"fec021bb-8e6a-4407-ad62-cea7284a8f6b\",\"quantity\":2500}]}},{\"type\":\"BUY_SKU\"" +
                ",\"data\":{\"values\":[{\"name\":\"f34f34f\",\"id\":\"0af57532-c681-42e7-963b-2e086305ec42\"" +
                ",\"quantity\":500},{\"name\":\"namSKU1\",\"id\":\"95f7acf6-311e-48dc-8e21-90a12e5ed321\"" +
                ",\"quantity\":200}]}},{\"type\":\"BIRTHDAY\",\"data\":{\"values\":[{\"value\":12},{\"value\":1},{\"value\":2},{\"value\":3}" +
                ",{\"value\":4}]}},{\"type\":\"BUY_FIRST_ORDER\",\"data\":{\"values\":[]}},{\"type\":\"BUY_ORDER_COST\"" +
                ",\"data\":{\"values\":[{\"value\":20000000}]}},{\"type\":\"RANKING\"" +
                ",\"data\":{\"values\":[{\"name\":\"Bac\",\"score\":120}]}}],\"campaign_exclusive_conditions\":[{\"type\":\"BUY_CATE\"" +
                ",\"data\":{\"values\":[{\"name\":\"gdfgdf345345\",\"id\":\"8b9d55ea-8e71-4295-adb9-8a09e05bbedf\"},{\"name\":\"fsdfsdf535435\"" +
                ",\"id\":\"b31afc6e-1e6e-41e6-b672-062382b25edb\"}]}},{\"type\":\"BUY_SUB_CATE\",\"data\":{\"values\":[{\"name\":\"453t3f34f43f\"" +
                ",\"id\":\"9cfd0960-a18e-4b69-8f26-2cb4b1884661\"},{\"name\":\"343\",\"id\":\"a739e3f4-d2e0-4469-9d46-27abd10365fc\"}]}}" +
                ",{\"type\":\"BUY_PRODUCT\",\"data\":{\"values\":[{\"name\":\"Dutch Lady PuRE\",\"id\":\"218a3692-1cec-4412-adec-bf2bd31c3972\"}" +
                ",{\"name\":\"EVAP 3CROWNS VG 8 BOX 48X160G TIN\",\"id\":\"fec021bb-8e6a-4407-ad62-cea7284a8f6b\"}]}}" +
                ",{\"type\":\"BUY_SKU\",\"data\":{\"values\":[{\"name\":\"f34f34f\",\"id\":\"0af57532-c681-42e7-963b-2e086305ec42\"}]}}]}";
//        ObjectMapper objectMapper = new ObjectMapper();
//        Map<String, Object> mapRules = objectMapper.readValue(ss, Map.class);
//        List<Map<String, Object>> getValueType = (List<Map<String, Object>>) mapRules.getOrDefault("campaign_inclusive_conditions", null);
//        System.out.println(getValueType);
        Bank bank = BankFactory.getBank(BankType.TPBANK);
        System.out.println(bank.getBankName());
    }

//    public static List<Map<String, Object>> getRule (String data, String key) throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Map<String, Object> mapRules = objectMapper.readValue(data, Map.class);
//        return null;
//    }

}
