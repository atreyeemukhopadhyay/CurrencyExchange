package com.atreyee.exchange.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LocaleDetails {

    private static Map<String, Map<String, String>> localeMapping = new HashMap<>();
    private static final String COUNTRY_CODE = "country";
    private static final String LANGUAGE = "language";

    private LocaleDetails() {
    }

    static {
        Map<String, String> dkklocale = new HashMap<>();
        dkklocale.put(LANGUAGE, "da");
        dkklocale.put(COUNTRY_CODE, "DK");
        localeMapping.put("DKK", dkklocale);

        Map<String, String> noklocale = new HashMap<>();
        noklocale.put(LANGUAGE, "nn");
        noklocale.put(COUNTRY_CODE, "NO");
        localeMapping.put("NOK", noklocale);

        Map<String, String> uslocale = new HashMap<>();
        uslocale.put(LANGUAGE, "en");
        uslocale.put(COUNTRY_CODE, "US");
        localeMapping.put("NOK", uslocale);

        Map<String, String> britishlocale = new HashMap<>();
        britishlocale.put(LANGUAGE, "en");
        britishlocale.put(COUNTRY_CODE, "GB");
        localeMapping.put("GBP", britishlocale);

        Map<String, String> seklocale = new HashMap<>();
        seklocale.put(LANGUAGE, "sv");
        seklocale.put(COUNTRY_CODE, "SE");
        localeMapping.put("SEK", seklocale);

        Map<String, String> chflocale = new HashMap<>();
        chflocale.put(LANGUAGE, "gsw");
        chflocale.put(COUNTRY_CODE, "CH");
        localeMapping.put("CHF", chflocale);

        Map<String, String> jpylocale = new HashMap<>();
        jpylocale.put(LANGUAGE, "ja");
        jpylocale.put(COUNTRY_CODE, "JP");
        localeMapping.put("JPY", jpylocale);

    }

    public static Locale getLocale(String currencyCode) {
        if (localeMapping.containsKey(currencyCode)) {
            String language = localeMapping.get(currencyCode).get(LANGUAGE);
            String countryCode = localeMapping.get(currencyCode).get(COUNTRY_CODE);
            return new Locale(language, countryCode);
        }
        return Locale.getDefault();
    }

}
