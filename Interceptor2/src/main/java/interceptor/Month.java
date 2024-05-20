package interceptor;

public class Month {
    private int mothNumber;
    private String englishName;
    private String italianName;
    private String germanName;

    public Month() {
    }

    public Month(int mothNumber, String englishName, String italianName, String germanName) {
        this.mothNumber = mothNumber;
        this.englishName = englishName;
        this.italianName = italianName;
        this.germanName = germanName;
    }

    public int getMothNumber() {
        return mothNumber;
    }

    public void setMothNumber(int mothNumber) {
        this.mothNumber = mothNumber;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getItalianName() {
        return italianName;
    }

    public void setItalianName(String italianName) {
        this.italianName = italianName;
    }

    public String getGermanName() {
        return germanName;
    }

    public void setGermanName(String germanName) {
        this.germanName = germanName;
    }


    public static final class MonthBuilder {
        private int mothNumber;
        private String englishName;
        private String italianName;
        private String germanName;

        private MonthBuilder() {
        }

        public static MonthBuilder aMonth() {
            return new MonthBuilder();
        }

        public MonthBuilder withMothNumber(int mothNumber) {
            this.mothNumber = mothNumber;
            return this;
        }

        public MonthBuilder withEnglishName(String englishName) {
            this.englishName = englishName;
            return this;
        }

        public MonthBuilder withItalianName(String italianName) {
            this.italianName = italianName;
            return this;
        }

        public MonthBuilder withGermanName(String germanName) {
            this.germanName = germanName;
            return this;
        }

        public Month build() {
            Month month = new Month();
            month.setMothNumber(mothNumber);
            month.setEnglishName(englishName);
            month.setItalianName(italianName);
            month.setGermanName(germanName);
            return month;
        }
    }
}