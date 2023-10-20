public enum RAMType {
    DDR ("DDR"),
    DDR2 ("DDR2"),
    DDR3 ("DDR3"),
    DDR4 ("DDR4"),
    DDR5 ("DDR5");

    private String name = "";

    RAMType(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return name;
    }

    public static RAMType intToRAMType (int intType) {
        switch (intType){
            case 0:
                return DDR;
            case 1:
                return DDR2;
            case 2:
                return DDR3;
            case 3:
                return DDR4;
            case 4:
                return DDR5;
            default:
                throw new IllegalArgumentException("Некорректный формат данных!");
        }
    }
}