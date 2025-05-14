public class Resposta {
    private String base_code;
    private String target_code;
    private double conversion_result;

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    @Override
    public String toString() {
        return "\nResultado da conversão" +
                "\nOrigem: " + base_code +
                "\nDestino: " + target_code +
                "\nResultado: " + conversion_result
                ;
    }
}
