package org.fenixedu;

import eu.europa.ec.taxud.tin.algorithm.ITinAlgorithm;

public class TINValidator {

    public static boolean isValid(final String countryCode, final String tin) {
        return isValid(countryCode, tin, true);
    }

    public static boolean isValid(final String countryCode, final String tin, final boolean resultWhenThereIsNoValidator) {
        if (countryCode == null || countryCode.length() != 2) {
            return false;
        }
        if (tin == null) {
            return false;
        }
        try {
            final Class<ITinAlgorithm> tinAlgo =
                    (Class<ITinAlgorithm>) Class.forName("eu.europa.ec.taxud.tin.algorithm." + countryCode + "Algorithm");
            final ITinAlgorithm tinImplementation = (ITinAlgorithm) tinAlgo.newInstance();
            return tinImplementation.isValid(tin) == 0;
        } catch (ClassNotFoundException var4) {
            return resultWhenThereIsNoValidator;
        } catch (IllegalAccessException var5) {
            return false;
        } catch (InstantiationException var6) {
            return false;
        }
    }
}
