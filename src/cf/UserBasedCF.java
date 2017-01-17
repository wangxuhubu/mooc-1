package cf;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 * @author: wuke
 * @date : 2016��7��21�� ����8:26:37 
 * Title : UserBasedCF 
 * Description : Эͬ�����㷨 user-based
 */
public class UserBasedCF {
	public static void main(String[] args) {
		try {
			// ���ļ���������
			DataModel model = new FileDataModel(new File("e:\\user_based_cf_test.txt"));
			//DataModel model = new FileDataModel(new File("e:\\user_based_cf_data.txt"));

			// ָ���û����ƶȼ��㷽�����������Ƥ��ɭ��ض�
			UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
			// ָ���û����ھ�����������Ϊ 2
			UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);
			// ���������û����Ƽ�ϵͳ
			Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
			// �õ�ָ���û����Ƽ�����������ǵõ��û� 240 �� 4 ���Ƽ�
			List<RecommendedItem> recommendations = recommender.recommend(240, 4);

			// ��ӡ�Ƽ����
			for (RecommendedItem recommendation : recommendations) {
				System.out.println(recommendation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}