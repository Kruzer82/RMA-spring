package com.gpch.login.enums;

public enum Status {
    PRZYJETOZGLOSZENIE("Przyjęto zgłoszenie"),
    PRZYJETONAMAGAZYN("Przyjęto na magazyn"),
    WTRAKCIENAPRAWY("W trakcie naprawy"),
    PRZEKAZANODOWYSYLKI("Przekazano do wysyłki"),
    ZAKONCZONO("Zakończono"),
    USUNIETO("Usunięto");

    private String displayStatus;

    Status(String displayName) {
        this.displayStatus = displayName;
    }

    public String displayName() { return displayStatus; }

    // Optionally and/or additionally, toString.
    @Override public String toString() { return displayStatus; }
}
