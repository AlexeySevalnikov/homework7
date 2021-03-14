import java.util.Scanner;

public class CountrySelection {
    public static void main(final String[] args) {
        Country[] countryArray = Country.values();
        for (Country value : countryArray) {
            System.out.println(value);
        }
        System.out.println("Для выхода введите 'q'");
        Scanner in = new Scanner(System.in, "Cp1251");
        while (true) {
            String str = in.nextLine();
            if ("q".equals(str)) {
                break;
            }
            final Country country = scanError(str);
            if (country == null) {
                continue;
            }
            if (country.getIsOpen()) {
                System.out.println("Страна [" + country + "] открыта для посещения");
            } else {
                System.out.println("Страна [" + country + "] закрыта для посещения");
            }
        }
    }

    public static Country scanError(final String str) {
        try {
            Country.valueOf(str);
        } catch (NullPointerException e) {
            System.err.println("На вход пришел null");
        } catch (IllegalArgumentException e) {
            System.out.println("Наименование страны введено некорректно, проверяю русское название...");
            try {
                return Country.getByRuName(str);
            } catch (NoSuchCountryException exc) {
                System.err.println(exc.getMessage());
                return null;
            }
        }
        return Country.valueOf(str);
    }
}
