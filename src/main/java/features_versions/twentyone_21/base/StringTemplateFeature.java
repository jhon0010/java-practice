package features_versions.twentyone_21.base;

public class StringTemplateFeature {

    public static void main(String[] args) {
        String interpolationUsingSTRProcessorString= interpolationUsingSTRProcessor("hot", "30", "C");
        System.out.println(STR."interpolationUsingSTRProcessorString = \{interpolationUsingSTRProcessorString}");

        String jsonBlock= interpolationOfJSONBlock("hot", "30", "C");
        System.out.println(STR."jsonBlock = \{jsonBlock}");

        String usingTemplate= usingTemplate("hot", "30", "C");
        System.out.println(STR."usingTemplate = \{usingTemplate}");
    }

    static String interpolationUsingSTRProcessor(String feelsLike, String temperature, String unit) {
        return STR
                . "Today's weather is \{ feelsLike }, with a temperature of \{ temperature } degrees \{ unit }" ;
    }

    static String interpolationOfJSONBlock(String feelsLike, String temperature, String unit) {
        return STR
                . """
      {
        "feelsLike": "\{ feelsLike }",
        "temperature": "\{ temperature }",
        "unit": "\{ unit }"
      }
      """ ;
    }

    /**
     * we obtain an instance of a template, StringTemplate, by evaluating to the right of the dot operator.
     *
     * RAW is the standard template processor that produces an unprocessed StringTemplate type object.
     *
     * Finally, we pass the StringTemplate str instance to the process() method of the processor(which in our case is STR):
     * @param feelsLike
     * @param temperature
     * @param unit
     * @return
     */
    static String usingTemplate(String feelsLike, String temperature, String unit){
        StringTemplate str = StringTemplate.RAW. "Today's weather is \{ getFeelsLike() }, with a temperature of \{ getTemperature() } degrees \{ getUnit() }" ;
        return STR.process(str);
    }

    private static Integer getUnit() {
        return 2;
    }

    private static Long getTemperature() {
        return 32L;
    }

    private static String getFeelsLike() {
        return "hot";
    }

}
