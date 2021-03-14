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

    public String getRuName() {
        return ruName;
    }

    @Override
    public String toString() {
        return super.toString() + "('" + ruName + "')";
    }


    public static Country getByRuName(final String ruCountry) throws NoSuchCountryException {
        Country[] countryArray = Country.values();
        for (int i = 0; i < countryArray.length; i++) {
            if (countryArray[i].ruName.equals(ruCountry)) {
                return countryArray[i];
            }
        }
        throw new NoSuchCountryException("Страны '" + ruCountry + "' не существует.");
    }
}

