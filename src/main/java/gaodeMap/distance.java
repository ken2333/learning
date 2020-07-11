package gaodeMap;

/**
 * describe: 高德地图工具类
 *
 * @author syh
 * @date 2020/06/16
 */
public class distance {
    /**
     * 计算两个点之间的距离
     * @param start  开始的经纬度
     * @param end 结束的经纬度
     * @return
     */
    public static double getDistance(double[] start, double[] end)
    {

        double lon1 = (Math.PI / 180) * start[0];
        double lon2 = (Math.PI / 180) * end[0];
        double lat1 = (Math.PI / 180) * start[1];
        double lat2 = (Math.PI / 180) * end[1];

        // double Lat1r = (Math.PI/180)*(gp1.getLatitudeE6()/1E6);
        // double Lat2r = (Math.PI/180)*(gp2.getLatitudeE6()/1E6);
        // double Lon1r = (Math.PI/180)*(gp1.getLongitudeE6()/1E6);
        // double Lon2r = (Math.PI/180)*(gp2.getLongitudeE6()/1E6);

        // 地球半径
        double R = 6371;

        // 两点间距离 km，如果想要米的话，结果*1000就可以了
        double d = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)) * R;

        return d * 1000;
    }

    public static void main(String[] args) {
        double[] start = new double[]{113.285459,22.09996};
        double[] end = new double[]{113.285201,22.099671};
        double distance = getDistance(start, end);
        System.out.println(distance);
    }

}
