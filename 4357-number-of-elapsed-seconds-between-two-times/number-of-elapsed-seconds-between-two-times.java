class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        return fxn(endTime.split(":")) - fxn(startTime.split(":"));
    }

    int fxn(String[] str) {
        int cnt = 0;
        cnt += Integer.parseInt(str[0]) * 60 * 60;
        cnt += Integer.parseInt(str[1]) * 60;
        cnt += Integer.parseInt(str[2]);
        return cnt;
    }
}