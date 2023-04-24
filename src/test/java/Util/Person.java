package Util;

public class Person {
    public String First_Name;
    public String Last_Name;
    public String Company_Name;
    public String Position_Name;
    public int rowNumber;

    public String getFirst_Name() {
        return First_Name.trim();
    }

    public String getLast_Name() {
        return Last_Name.trim();
    }

    public String getCompany_Name() {
        return Company_Name.trim();
    }

    public String getPosition_Name() {
        return Position_Name.trim();
    }

    public int getRowNumber() {
        return rowNumber;
    }

    @Override
    public String toString() {
        return "First Name: " + getFirst_Name()
                + " Last Name: " + getLast_Name()
                + " Company Name: " + getCompany_Name()
                + " Position Name: " + getPosition_Name()
                + " Row Number: " + getRowNumber();
    }
}
