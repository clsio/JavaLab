package me.zhang.importstatic;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

/**
 * Created by Zhang on 2015/6/12 ���� 10:04 .
 */
public class MathUtils {

    /**
     * ����Բ�����
     *
     * @param r
     * @return
     */
    public static double calcCircleArea(double r) {
        return Math.PI * Math.pow(r, 2);
    }

    /**
     * ��������������ʹ�þ�̬���룩
     *
     * @param r
     * @return
     */
    public static double calcBallArea(double r) {
        return 4 * PI * pow(r, 2);
    }

}
