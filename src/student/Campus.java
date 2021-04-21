package student;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public enum Campus {
    Bennington("802-447-2361"),
    Brattleboro("802-254-6370"),
    Middlebury("802-388-3032"),
    Montpelier("802-828-4060"),
    Morrisville("802-888-4258"),
    Newport("802-334-3387"),
    Rutland("802-786-6996"),
    Springfield("802-885-8360"),
    StAlbans("802-524-6541"),
    StJohnsbury("802-748-6673"),
    Winooski("802-654-0505");

    final String phoneNumber;

    Campus(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


}
