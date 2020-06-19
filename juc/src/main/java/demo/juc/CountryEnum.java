package demo.juc;


public enum  CountryEnum {
    ONE(1,"秦");
    private Integer retCode;
    private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    private static CountryEnum codeOf(Integer retCode){
        for (CountryEnum countryEnum1 : CountryEnum.values()) {
            if (countryEnum1.getRetCode() == retCode) {
                return countryEnum1;
            }
        }
        return null;
    }
}
