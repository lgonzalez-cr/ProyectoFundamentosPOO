package Pojo;

public class CurrencyData {
    private String currencyName;
    private String currencySymbol;
    private String elementName;

    public CurrencyData(String currencyName, String currencySymbol, String elementName) {
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
        this.elementName = elementName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public String getElementName() {
        return elementName;
    }
}
