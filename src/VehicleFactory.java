/**
 * Factory pattern ile oluşturulan sınıfın implemet edildiği ve marka ismine göre yeni aracın o özelliklere sahip olmasını sağlayan sınıftır.
 * */
public class VehicleFactory implements IVehicleFactory{
    public IVehicle ProduceVehicle(VehicleBrand brand)
    {
        IVehicle vehicle = null;
        switch (brand)
        {
            case BMW:
                vehicle = new BMWIVehicle();
                break;
            case MERCEDES:
                vehicle = new MercedesIVehicle();
                break;
            case FIAT:
                vehicle = new FiatIVehicle();
                break;
        }
        return vehicle;
    }
}
