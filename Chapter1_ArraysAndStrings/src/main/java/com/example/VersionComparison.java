package com.example;

/**
 * Given two version numbers, version1 and version2, compare them.
 * <p>
 * Version numbers consist of one or more revisions joined by a dot '.'.
 * Each revision consists of digits and may contain leading zeros.
 * Every revision contains at least one character.
 * Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on.
 * For example 2.5.33 and 0.1 are valid version numbers.
 * <p>
 * To compare version numbers, compare their revisions in left-to-right order.
 * Revisions are compared using their integer value ignoring any leading zeros.
 * This means that revisions 1 and 001 are considered equal.
 * If a version number does not specify a revision at an index, then treat the revision as 0.
 * For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
 * <p>
 * Return the following:
 * <p>
 * If version1 < version2, return -1.
 * If version1 > version2, return 1.
 * Otherwise, return 0.
 */
public class VersionComparison {

    public int compareVersion(String version1, String version2) {

        String[] v1Array = version1.split("\\.");
        String[] v2Array = version2.split("\\.");

        for (int i = 0; i < v1Array.length && i < v2Array.length; i++) {

            if (Integer.parseInt(v1Array[i]) > Integer.parseInt(v2Array[i]))
                return 1;
            if (Integer.parseInt(v2Array[i]) > Integer.parseInt(v1Array[i]))
                return -1;

        }
        if (v1Array.length > v2Array.length) {
            int i = v2Array.length;
            while (i < v1Array.length) {
                if (Integer.parseInt(v1Array[i]) > 0)
                    return 1;
                i++;
            }

        } else if (v1Array.length < v2Array.length) {
            int i = v1Array.length;
            while (i < v2Array.length) {
                if (Integer.parseInt(v2Array[i]) > 0)
                    return -1;
                i++;
            }

        }

        return 0;

    }
}
