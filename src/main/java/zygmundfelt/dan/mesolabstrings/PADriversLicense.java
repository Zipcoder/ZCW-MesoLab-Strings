package zygmundfelt.dan.mesolabstrings;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PADriversLicense {

    private String licenseNumber;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String dateOfBirth;
    private String issued;
    private String expires;
    private String sex;
    private String eyes;
    private String height;
    private String organDonor;
    private String licenseClass;

    public PADriversLicense(String licenseNumber, String lastName, String firstName, String middleName, String address, String city, String state, String zipCode, String dateOfBirth, String issued, String expires, String sex, String eyes, String height, String organDonor, String licenseClass) {
        this.licenseNumber = licenseNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.dateOfBirth = dateOfBirth;
        this.issued = issued;
        this.expires = expires;
        this.sex = sex;
        this.eyes = eyes;
        this.height = height;
        this.organDonor = organDonor;
        this.licenseClass = licenseClass;
    }

    public static String fileToString(File file) throws IOException {
        FileReader fReader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(fReader);
        String output = "";
        for (String line; (line = bReader.readLine()) != null; output += line + "\n");
        return output;
    }

    //TODO - check input to ensure valid header
    public static List<PADriversLicense> deserializeFromCSV(String string) {
        List<PADriversLicense> list = new ArrayList<PADriversLicense>();
        String[] lineBreaks = string.split("\n");
        for(int i = 1; i < lineBreaks.length; i++) {
            String[] arr = lineBreaks[i].split(",");
            list.add(new PADriversLicense(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8],arr[9],arr[10],arr[11],arr[12],arr[13],arr[14],arr[15]));
        }
        return list;
    }

    public static String getCSVHeader() {
        return "licenseNumber,lastName,firstName,middleName,address,city,state,zipCode,dateOfBirth,issued,expires,sex,eyes,height,organDonor,licenseClass\n";
    }

    public static String serializeToCSV(List<PADriversLicense> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(getCSVHeader());
        for(PADriversLicense license : list) {
            sb.append(license.toStringForCSV());
        }
        return sb.toString();
    }

    public String toStringForCSV() {
        return licenseNumber + ","
                + lastName + ","
                + firstName + ","
                + middleName + ","
                + address + ","
                + city + ","
                + state + ","
                + zipCode + ","
                + dateOfBirth + ","
                + issued + ","
                + expires + ","
                + sex + ","
                + eyes + ","
                + height + ","
                + organDonor + ","
                + licenseClass + "\n";
    }

}
