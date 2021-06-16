package com.secondtonone.jk.jiraclone.rest.api.helpers;

import com.secondtonone.jk.jiraclone.domain.project.task.Task;

public class LoggedTimeHelper {

    public static String countLoggedTime(Task task) {
        int minutes = task.getWorkLog().stream().mapToInt(workLog -> {
            String worked = workLog.getWorked();
            int sum = 0;
            String rest = worked;
            if (worked.contains("d")) {
                sum += Integer.parseInt(worked.split("d")[0]) * 1440;
                if (worked.contains("h") || worked.contains("m"))
                    rest = worked.split("d")[1];
            }
            if (worked.contains("h")) {
                sum += Integer.parseInt(rest.split("h")[0]) * 60;
                if (worked.contains("m"))
                    rest = rest.split("h")[1];
            }
            if (worked.contains("m")) {
                sum += Integer.parseInt(rest.split("m")[0]);
            }

            return sum;
        }).sum();
        return timeConvert(minutes);
    }

    public static String timeConvert(int time) {
        String result = "";
        if ((time / 24 / 60) > 0) {
            result = time / 24 / 60 + "d";
        }
        if (time / 60 % 24 > 0) {
            result += time / 60 % 24 + "h";
        }

        if (time % 60 > 0) {
            result += time % 60 + "m";
        }
        return result;
    }
}
