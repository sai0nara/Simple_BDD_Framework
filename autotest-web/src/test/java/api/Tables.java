package api;

public class Tables {
    private static final EnumDatabase EMPLOYEES = EnumDatabase.core_employee;
    private static final EnumDatabase PROJECTS = EnumDatabase.core_project;
    private static final EnumDatabase POSITIONS = EnumDatabase.core_position;

    public static String getEmployees() {
        return String.valueOf(EMPLOYEES);
    }
    public static String getProjects() {
        return String.valueOf(PROJECTS);
    }
    public static String getPositions() {
        return String.valueOf(POSITIONS);
    }

    private enum EnumDatabase {
        core_employee,
        core_project,
        core_position;
    }
}
