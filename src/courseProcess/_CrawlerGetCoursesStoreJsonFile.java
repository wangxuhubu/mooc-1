package courseProcess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author: wuke 
 * @date  : 2016��11��23�� ����5:36:47
 * Title  : CrawlerGetAllCourseData
 * Description : get all course data from "http://www.mooc2u.com/API/Open/CourseOpen/GetAllCourseData", 
 *               and store them in one json file "courses.json"
 * Problem : // �ᶪʧ�����һ�������ݣ����� BufferedWriter ��С����
 */
public class _CrawlerGetCoursesStoreJsonFile {
	
	static void getCourses(String url,String param) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		String str = null;
		
		File jsonFile = new File("e:\\data\\crawlerMoocCourse.json");
		
		try {
			// ger the url object
			URL coursesUrl = new URL(url);
			
			/** another method
			 * URLConnection urlConn = realUrl.openConnection();
			 * urlConn.connect();
			 * br = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), param));
			 */
			br = new BufferedReader(new InputStreamReader(coursesUrl.openStream(), param));
			
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jsonFile),param));
			
			while((str = br.readLine()) != null) {
				bw.write(str);    // �ᶪʧ�����һ�������ݣ�����
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String url = "http://www.mooc2u.com/API/Open/CourseOpen/GetAllCourseData";
		getCourses(url, "utf-8");
	}
}
