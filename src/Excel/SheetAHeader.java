package Excel;

public enum SheetAHeader {
    /** Header */
    userUnqId(0,"고유아이디"),
    userName(1,"이름"),
    userAge(2,"나이"),
    userGender(3,"성별"),
    userBirth(4,"생일");

    /** Setting */
    private final int columnIndex;
    private final String columnName;

    SheetAHeader(int index, String name) {
        this.columnIndex = index;
        this.columnName = name;
    }
    public int columnIndex() {
        return this.columnIndex;
    }
    public String columnName(){
        return this.columnName;
    }
    public SheetAHeader[] getHeader() {
        return SheetAHeader.values();
    }
}
