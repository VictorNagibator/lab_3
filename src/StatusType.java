public enum StatusType {
    ONHOLD ("В ожидании"),
    INPROCCESS ("В ремонте"),
    FINISHED ("Готов");

    private String name;

    StatusType(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return name;
    }

    public static StatusType intToStatusType (int intType) {
        switch (intType){
            case 0:
                return ONHOLD;
            case 1:
                return INPROCCESS;
            case 2:
                return FINISHED;
            default:
                throw new IllegalArgumentException("Некорректный формат данных!");
        }
    }
}