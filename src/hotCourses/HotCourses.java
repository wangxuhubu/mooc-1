package hotCourses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import utility.MySqlConn;

/**
 * @author: wuke 
 * @date  : 2016��6��30�� ����9:00:14
 * Title  : HotCourses
 * Description : 
 */
public class HotCourses {
	//static HashSet<String> res ult = new HashSet<String>(); // �洢���ſγ�   ע�⣬�˴�����ʹ��HashSet�����������
	static ArrayList<String> result = new ArrayList<String>();
	
	/**
	 *  ����ʱ������
	 *  �����ݿ��м���������
	 */
	static ArrayList<String> searchHot() {
		ArrayList<String> hotCourses = new ArrayList<String>();	
		Connection conn = MySqlConn.getConn();
		String sql = "select courseId,sum(totalClick) as totalClicks from hotcourse "
				+ "group by courseId order by totalClicks desc limit 3;";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement)conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();			
			while(rs.next()) {
				hotCourses.add(rs.getString(1)); // ����ѯ���Ľ��һ��һ������ArrayList��
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return hotCourses;
	}
	
	/**
	 *  �趨ʱ�����ƣ�����ʱ�䷶Χ��String����
	 *  �����ݿ��м���������
	 */
	static ArrayList<String> searchHotLimited(String start,String end) {
		ArrayList<String> hotCourses = new ArrayList<String>();	
		Connection conn = MySqlConn.getConn();
		String sql = "select courseId,sum(totalClick) as totalClicks from hotcourse "
				+ "where timeId between \"" + start + "\" and \"" + end
				+ "\" group by courseId order by totalClicks desc limit 3;";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement)conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();			
			while(rs.next()) {
				hotCourses.add(rs.getString(1)); // ����ѯ���Ľ��һ��һ������ArrayList��
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return hotCourses;
	}
	
	/**
	 *  ������
	 */
	public static void main(String[] args) {
		//result = searchHot();    // �����ݿ��в��ҹۿ��������ļ��ſγ�
		result = searchHotLimited("2016-06-08","2016-06-12");    // �����ݿ��в��ҹۿ��������ļ��ſγ�
		System.out.println(result.toString());
	}
}
