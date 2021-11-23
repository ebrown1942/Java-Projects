
public class Vechicle {

    //attributes or fields
    private int gasTankCapictyInLiters;
    private int gasCurrentlyInTankLiters;
    private int kilometersPerLiterAverage;
    private String make;
    private String model;
    private String color;

    //Set Method for color
    public void setColor(String color) {
        this.color = color;
    }

    public Vechicle(int gasTankCapictyInLiters, int gasCurrentlyInTankLiters, int kilometersPerLiterAverage, String make, String model, String color) {
        this.gasTankCapictyInLiters = gasTankCapictyInLiters;
        this.gasCurrentlyInTankLiters = gasCurrentlyInTankLiters;
        this.kilometersPerLiterAverage = kilometersPerLiterAverage;
        this.make = make;
        this.model = model;
        this.color = color;

    }

    //Methods for drive and addGas
    public boolean addGas(int litersToAdd) {
        boolean isAdded = false;
        int newGasCurrentlyInTankLiters = gasCurrentlyInTankLiters + litersToAdd;
        if (litersToAdd >= 0 && litersToAdd <= gasTankCapictyInLiters && newGasCurrentlyInTankLiters <= gasTankCapictyInLiters) {
            
           gasCurrentlyInTankLiters = newGasCurrentlyInTankLiters;
                isAdded = true;
            } else {
                
                isAdded = false;
            }
      
        return isAdded;
    }

    public boolean Drive(int kilometersToDrive) {
        boolean isDrive = false;
        if (kilometersToDrive > 0) {
            gasCurrentlyInTankLiters -= kilometersToDrive / kilometersPerLiterAverage;
            isDrive = true;
        }
        if (gasCurrentlyInTankLiters < 0) {
            isDrive = false;
        }
        return isDrive;
    }

    public int getGasTankCapictyInLiters() {
        return gasTankCapictyInLiters;
    }

    public int getGasCurrentlyInTankLiters() {
        return gasCurrentlyInTankLiters;
    }

    public int getKilometersPerLiterAverage() {
        return kilometersPerLiterAverage;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

}
