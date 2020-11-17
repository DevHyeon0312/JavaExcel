package Excel;

public enum SheetBHeader {
    /** Header */
    userUnqId(0,"고유아이디"),
    userName(1,"이름");

    /** Setting */
    private final int columnIndex;
    private final String columnName;

    SheetBHeader(int index, String name) {
        this.columnIndex = index;
        this.columnName = name;
    }

    public int columnIndex() {
        return this.columnIndex;
    }
    public String columnName(){
        return this.columnName;
    }
    public SheetBHeader[] getHeader() {
        return SheetBHeader.values();
    }
}
