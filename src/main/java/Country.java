public enum Country {
    Russia("Россия", true),
    UK("Великобритания", true),
    USA("США", false),
    Germany("Германия", true),
    France("Франция", true),
    Sweden("Шведция", true);

    private final String ruName;
    private final boolean isOpen;


    Country(final String ru, final boolean isOp) {
        this.ruName = ru;
        this.isOpen = isOp;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    @Override
    public String toString() {
        return super.toString() + "('" + ruName + "')";
    }


    public static Country getByRuName(final String ruCountry) throws NoSuchCountryException {
        Country[] countryArray = Country.values();
        for (Country country : countryArray) {
            if (country.ruName.equals(ruCountry)) {
                return country;
            }
        }
        throw new NoSuchCountryException("Страны '" + ruCountry + "' не существует.");
    }
}

