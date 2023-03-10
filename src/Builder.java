/**
 * Builder pattern i ile oluşturulan sınıfır. Tüm değişkenler private olarak tanımlanıp sınıf içerisinde kullanılmaktadır.
 */

public class Builder {
    private String brand; // required
    private String type; // required
    private String engine; // optional
    private int price;

    private String miniOnarim;
    private String yedekArac;
    private String yetkiliServis;

    /**
     * Araç oluşturmak istendiğinde tüm değerleri alan ve döndüren fonksiyondur.
     * */
    Builder(UserBuilder builder) {
        this.brand = builder.brand;
        this.type = builder.type;
        this.engine = builder.engine;
        this.price = builder.price;
        this.miniOnarim = builder.miniOnarim;
        this.yedekArac = builder.yedekArac;
        this.yetkiliServis = builder.yetkiliServis;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getEngine() {
        return engine;
    }
    public int getPrice(){
        return price;
    }
    public String getMiniOnarim(){
        return miniOnarim;
    }
    public String getYetkiliServis(){
        return yetkiliServis;
    }
    public String getYedekArac(){
        return yedekArac;
    }

    /**
     * Kullanıcının isteğine göre seçilen özellik ve markalar için hesap yapan sınıftır.
     * */
    public static class UserBuilder {

        private String brand;
        private String type;
        private String engine;
        private int price;
        private String miniOnarim;
        private String yedekArac;
        private String yetkiliServis;

        public UserBuilder(String brand, String type, String engine, String miniOnarim, String yedekArac, String yetkiliServis) {
            this.brand = brand;
            this.type = type;
            this.engine = engine;
            this.miniOnarim = miniOnarim;
            this.yedekArac = yedekArac;
            this.yetkiliServis = yetkiliServis;
        }

        public Builder build() {
            return new Builder(this);
        }

        //En boş kasko hesabı
        public UserBuilder Kasko(String brand, String vehicleType) {
            if(brand.equalsIgnoreCase("BMW")){
                this.price = 3000;
            } else if(brand.equalsIgnoreCase("MERCEDES")){
                this.price = 2500;
            } else if (brand.equalsIgnoreCase("FIAT")) {
                this.price = 1600;
            }
            return this;
        }

        //Seçeneklerden herhangi bir tanesini hesaplar
        public UserBuilder Kasko(String brand, String vehicleType, String engine, String miniOnarim) {
            if(brand.equalsIgnoreCase("BMW")){
                this.price = 1100;
            } else if(brand.equalsIgnoreCase("MERCEDES")){
                this.price = 8000;
            } else if (brand.equalsIgnoreCase("FIAT")) {
                this.price = 4000;
            }
            return this;
        }

        //En full kasko ücret hesabı
        public UserBuilder Kasko(String brand, String vehicleType, String engine, String miniOnarim, String yetkiliServis, String yedekArac) {
            if(brand.equalsIgnoreCase("BMW")){
                this.price = 23000;
            } else if(brand.equalsIgnoreCase("MERCEDES")){
                this.price = 18000;
            } else if (brand.equalsIgnoreCase("FIAT")) {
                this.price = 5000;
            }
            return this;
        }
    }
}