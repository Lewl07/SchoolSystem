package org.leoho;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import util.Util;

@ToString
@EqualsAndHashCode
@Getter
public class Department {
    private final String departmentId;
    @Setter private String departmentName;
    private static int nextId = 1;

    /**
     * Checks if a department name is valid or not.
     * the name should only contain letters or space
     * @param departmentName the department name
     * @return whether the department name is valid.
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }

        for (int i = 0; i < departmentName.length(); i++) {
            char c = departmentName.charAt(i);

            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }

        return true;
    }

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentId = String.format("D%02d", nextId++);
            this.departmentName = Util.toTitleCase(departmentName);
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }
}
