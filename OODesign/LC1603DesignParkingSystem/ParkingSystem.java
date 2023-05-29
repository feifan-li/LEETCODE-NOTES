package OODesign.LC1603DesignParkingSystem;

class ParkingSystem {
    public final int TYPE_SMALL = 3;
    public final int TYPE_MEDIUM = 2;
    public final int TYPE_BIG = 1;
    public int remainingBig;
    public int remainingMedium;
    public int remainingSmall;
    public ParkingSystem(int big, int medium, int small) {
        this.remainingBig = big;
        this.remainingMedium = medium;
        this.remainingSmall = small;
    }

    public boolean addCar(int carType) {
        if(carType==TYPE_SMALL && remainingSmall>=1){
            remainingSmall--;
            return true;
        }else if(carType==TYPE_MEDIUM && remainingMedium>=1){
            remainingMedium--;
            return true;
        }else if(carType==TYPE_BIG && remainingBig>=1){
            remainingBig--;
            return true;
        }
        return false;
    }
}
