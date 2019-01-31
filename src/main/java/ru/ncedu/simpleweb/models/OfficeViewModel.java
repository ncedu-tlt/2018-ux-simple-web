package ru.ncedu.simpleweb.models;

public class OfficeViewModel {

    private long id;
    private String name;
    private String phoneNumber;
    private String cityName;

    public OfficeViewModel() {}

    public OfficeViewModel(Office office, City city) {
        this.name = office.getName();
        this.phoneNumber = office.getPhoneNumber();
        this.id = office.getId();
        this.cityName = city.getName();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCityName() {
        return cityName;
    }
}
