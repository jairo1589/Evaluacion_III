package Clases;

public class Promocion {

    private int Pizzas_Promo;
    private int Master_Pizza;
    private int Pizza_Max;

    public Promocion()
    {
        Pizzas_Promo = 5990;
        Master_Pizza = 12990;
        Pizza_Max = 18500;

    }

    public int getPromo() {
        return Pizzas_Promo;
    }

    public int getMaster() {
        return Master_Pizza;
    }

    public int getMax() {
        return Pizza_Max;
    }

    public void setPizzas_Promo(int pizzas_Promo) {
        Pizzas_Promo = pizzas_Promo;
    }

    public void setMaster_Pizza(int master_Pizza) {
        Master_Pizza = master_Pizza;
    }

    public void setPizza_Max(int pizza_Max) {
        Pizza_Max = pizza_Max;
    }
}
