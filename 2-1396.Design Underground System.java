import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    // Helper class to bundle check-in data
    private static class CheckInInfo {
        String stationName;
        int checkInTime;
        
        CheckInInfo(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }

    // Helper class to bundle total statistics
    private static class RouteStat {
        double totalTime = 0;
        int tripCount = 0;
    }

    private Map<Integer, CheckInInfo> checkIns;
    private Map<String, RouteStat> routeTotals;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routeTotals = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkIns.remove(id);
        String routeKey = info.stationName + "->" + stationName;
        
        routeTotals.putIfAbsent(routeKey, new RouteStat());
        RouteStat stat = routeTotals.get(routeKey);
        
        stat.totalTime += (t - info.checkInTime);
        stat.tripCount++;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteStat stat = routeTotals.get(routeKey);
        return stat.totalTime / stat.tripCount;
    }
}
