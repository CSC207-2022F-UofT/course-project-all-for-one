package framworks_drivers_layer.dataAccess;

import application_business_rules_layer.profileUseCases.ProfileGateway;
import application_business_rules_layer.profileUseCases.ProfileRequestModel;


import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
public class FileProfile implements ProfileGateway{
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, ProfileRequestModel> profile = new HashMap<>();

    public FileProfile(String csvPath) throws IOException{
        csvFile = new File (csvPath);

        headers.put("username", 0);
        headers.put("age", 1);
        headers.put("gender", 2);
        headers.put("description", 3);
        headers.put("address", 4);
        headers.put("phone",5);



        if (csvFile.length() == 0) {
            save();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String username = String.valueOf(col[headers.get("username")]);
                String age = String.valueOf(col[headers.get("age")]);
                String gender = String.valueOf(col[headers.get("gender")]);
                String description = String.valueOf(col[headers.get("description")]);
                String address = String.valueOf(col[headers.get("address")]);
                String phone = String.valueOf(col[headers.get("phone")]);
                ProfileRequestModel user = new ProfileRequestModel(username,age,gender,address,description,phone);
                profile.put(username,user);
            }

            reader.close();

        }
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (ProfileRequestModel profile : profile.values()) {
                String line = "" + profile.getUsername() + "," + profile.getAge() + "," + profile.getGender() + ","
                        + profile.getDescription()+ "," + profile.getAddress() + "," + profile.getPhone();
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getUsername(String username) {
        return profile.get(username).getUsername();
    }

    @Override
    public String getAge(String username) {
        return profile.get(username).getAge();
    }

    @Override
    public String getGender(String username) {
        return profile.get(username).getGender();
    }

    @Override
    public String getDescription(String username) { return profile.get(username).getDescription();}

    @Override
    public String getAddress(String username) {
        return profile.get(username).getAddress();
    }

    @Override
    public String getPhone(String username) {return profile.get(username).getPhone();}

    @Override
    public void save(ProfileRequestModel requestModel) {
        profile.put(requestModel.getUsername(), requestModel);
        this.save();
    }

    @Override
    public void changeAge(String username, String age) {
        profile.get(username).setAge(age);
        this.save();
    }

    @Override
    public void changeGender(String username, String gender) {

        profile.get(username).setGender(gender);
        this.save();
    }

    @Override
    public void changeDescription(String username, String description) {
        profile.get(username).setDescription(description);
        this.save();
    }

    @Override
    public void changePhone(String username, String phone) {

        profile.get(username).setPhone(phone);
        this.save();
    }

    @Override
    public void changeAddress(String username, String address) {

        profile.get(username).setAddress(address);
        this.save();
    }
}
