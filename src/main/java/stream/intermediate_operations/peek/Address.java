package stream.intermediate_operations.peek;

public class Address {
    private final int no;
    private final String si;
    private final String gu;
    private final String dong;
    private String fullName;

    public Address(int no, String si, String gu, String dong, String fullName) {
        this.no = no;
        this.si = si;
        this.gu = gu;
        this.dong = dong;
        this.fullName = fullName;
    }

    public String getSi() {
        return si;
    }

    public String getGu() {
        return gu;
    }

    public String getDong() {
        return dong;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object obj) {
        final var address = (Address) obj;
        return no == address.no && si.equals(address.getSi())
                && gu.equals(address.getGu()) && dong.equals(address.getDong())
                && ((fullName == null && address.getFullName() == null) || fullName.equals(address.getFullName()));
    }

    @Override
    public String toString() {
        return "Address{" +
                "no=" + no +
                ", si='" + si + '\'' +
                ", gu='" + gu + '\'' +
                ", dong='" + dong + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
