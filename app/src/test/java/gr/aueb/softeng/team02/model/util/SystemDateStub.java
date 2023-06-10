package gr.aueb.softeng.team02.model.util;

import java.time.LocalDate;

import gr.aueb.softeng.team02.util.SimpleCalendar;
import gr.aueb.softeng.team02.util.SystemDate;
public class SystemDateStub {

    public static void setStub(LocalDate stub) {
        SystemDate.setStub(stub);
    }

    public static void reset() {
        SystemDate.removeStub();
    }
}