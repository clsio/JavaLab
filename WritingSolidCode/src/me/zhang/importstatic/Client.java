package me.zhang.importstatic;

import java.text.NumberFormat;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.text.NumberFormat.getInstance;

/**
 * Do Not!!!
 */


/**
 * Created by Zhang on 2015/6/12 ���� 10:16 .
 */
public class Client {

    /* ���������·��ԭ�����ȵ��ñ����еı��������������� */
    private static final double PI = 3.141592653589793;

    // ����뾶�;��ȣ��������
    public static void main(String[] args) {
        double s = Math.PI * parseDouble(args[0]);
        NumberFormat nf = getInstance();
        nf.setMaximumFractionDigits(parseInt(args[1]));
        formatMessage(nf.format(s));
    }

    // ��ʽ�����
    private static void formatMessage(String s) {
        System.out.println("Բ������ǣ�" + s);
    }

}
