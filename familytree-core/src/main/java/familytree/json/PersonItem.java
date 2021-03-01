package familytree.json;

import familytree.model.Gender;

public class PersonItem {

    private int id;

    private Integer motherId;
    private Integer fatherId;

    private Integer wifeId;
    private Integer husbandId;

    private String familyName;
    private String givenName;

    private Gender gender;

    private String cityOfBirth;

    private Integer yearOfBirth;
    private Integer yearOfDeath;

    private Integer height;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Integer getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(Integer yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getMotherId() {
        return motherId;
    }

    public void setMotherId(Integer motherId) {
        this.motherId = motherId;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public Integer getWifeId() {
        return wifeId;
    }

    public void setWifeId(Integer wifeId) {
        this.wifeId = wifeId;
    }

    public Integer getHusbandId() {
        return husbandId;
    }

    public void setHusbandId(Integer husbandId) {
        this.husbandId = husbandId;
    }
}
